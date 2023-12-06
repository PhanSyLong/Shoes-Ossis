package vn.sourcecode.controller.frontend;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.sourcecode.controller.BaseController;
import vn.sourcecode.dto.Cart;
import vn.sourcecode.dto.CartProduct;
import vn.sourcecode.dto.Customer;
import vn.sourcecode.dto.JwConstants;
import vn.sourcecode.model.Product;
import vn.sourcecode.model.SaleOrder;
import vn.sourcecode.model.SaleOrderProduct;
import vn.sourcecode.model.User;
import vn.sourcecode.service.ProductService;
import vn.sourcecode.service.SaleOrderService;

@Controller
public class CartController extends BaseController implements JwConstants {
	@Autowired
	private ProductService productService;
	@Autowired
	private SaleOrderService saleOrderService;

	// --------------------------Add-CartProduct---------------------------------
	@RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addToCart(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, @RequestBody CartProduct addedProduct // lay giu lieu tu ham ajax
	) throws IOException {
		
		// Lay gio hang su dung bien session
		HttpSession session = request.getSession();
		Cart cart = null;

		// Kiem tra xem co gio hang chua(cart)
		if (session.getAttribute("cart") == null) {// chua co gio hang
			cart = new Cart();
			// Tao bien session cho cart
			session.setAttribute("cart", cart);
		} else {// Da co gio hang
			cart = (Cart) session.getAttribute("cart");
		}
		// Them hang vao gio
		// + lay product trong DB
		Product dbProduct = productService.getById(addedProduct.getProductId());
		// + Tao moi mot cart'product: 2 truong hop
		int index = cart.findProductById(dbProduct.getId());
		if (index != -1) {// TH1: San pham co trong gio -> tang so luong
			cart.getCartProducts().get(index)
					.setQuantity(cart.getCartProducts().get(index).getQuantity() + addedProduct.getQuantity());
		} else {// TH2: San pham chua co trong gio -> them moi
			addedProduct.setAvatar(dbProduct.getAvatar());
			addedProduct.setProductName(dbProduct.getName());
			addedProduct.setPrice(dbProduct.getPrice());

			cart.getCartProducts().add(addedProduct);
		}

		// Thiet lap bien session cho cart

		// Tra ve tong so san pham
		model.addAttribute("totalCartProducts", cart.totalCartProducts());

		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("code", 404);
		jsonResult.put("message", "Đã thêm sản phẩm '" + dbProduct.getName() + "' vào giỏ hàng");
		jsonResult.put("totalCartProducts", cart.totalCartProducts());
		return ResponseEntity.ok(jsonResult);
	}

	// -------------------------------Cart-view-------------------------------------
	@RequestMapping(value = "/cart-view", method = RequestMethod.GET)
	public String cartView(final Model model, final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		HttpSession session = request.getSession();
		Cart cart = null;
		String message = null;
		String errorMessage = null;
		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
			message = "Co " + cart.totalCartProducts() + " trong gio hang";
			errorMessage = "Không có hàng trong gio hang";
//			model.addAttribute("totalCartPoduct", cart.totalCartProducts());		
			model.addAttribute("totalCartPrice", cart.totalCartPrice());
		} else {
			errorMessage = "Khong co san pham nao trong gio hang, vui lòng chọn sản phẩm !!!";
		}

		model.addAttribute("message", message);
		model.addAttribute("errorMessage", errorMessage);
		if (isLogined()) {
			model.addAttribute("user", getLoginedUser());
		} else {
			model.addAttribute("user", new User());
		}
		return "frontend/cart-view";
	}

	// -----------------------------DeleteCartProduct--------------------------------------
	@RequestMapping(value = "product-cart-delete/{productId}", method = RequestMethod.GET)
	public String productCartDelete(final Model model, final HttpServletRequest request,
			@PathVariable("productId") int productId) throws IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		int index = cart.findProductById(productId);
		if (index != -1) {
			cart.getCartProducts().remove(index);
		}
		if (cart.totalCartProducts() == 0) {
			cart = null;
		}
		session.setAttribute("cart", cart);

		return "redirect:/cart-view";
	}

	// --------------------------UpdateProductQuantity-----------------------------------
	@RequestMapping(value = "/update-product-quantity", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> updateProductQuantity(final Model model,
			final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody CartProduct updateProduct) throws IOException {

		// Lay gio hang
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		int index = cart.findProductById(updateProduct.getProductId());
		Integer newQuantity = cart.getCartProducts().get(index).getQuantity() + updateProduct.getQuantity();
		if (newQuantity.intValue() < 1) {
			newQuantity = 1;
		}
		cart.getCartProducts().get(index).setQuantity(newQuantity);

		Map<String, Object> jsonResult = new HashMap<String, Object>();

		jsonResult.put("code", 200);
		jsonResult.put("status", "Succes");
		jsonResult.put("newQuantity", newQuantity);
		return ResponseEntity.ok(jsonResult);
	}

	// ---------------------------Place-order---------------------------------------------
	@RequestMapping(value = "/place-order", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> placeOrder(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, @RequestBody Customer customer) throws IOException {

		// if(!isLogined()) {
		// return "redirect:/login;
		// }

		Map<String, Object> jsonResult = new HashMap<String, Object>();
		// Kiem tra thong tin bat buoc
		if (customer.getTxtName().isEmpty()) {
			jsonResult.put("code", 100);
			jsonResult.put("message", "Ban chua nhap ho ten");
		} else if (customer.getTxtMobile().isEmpty()) {
			jsonResult.put("code", 101);
			jsonResult.put("message", "Ban chua nhap so dien thoai");
		} else if (customer.getTxtAddress().isEmpty()) {
			jsonResult.put("code", 102);
			jsonResult.put("message", "Ban chua nhap dia chi giao hang");
		} else {

			// Lay gio hang de luu vao tbl_sale_order_product
			HttpSession session = request.getSession();
			if (session.getAttribute("cart") != null) { // Co gio hang
				Cart cart = (Cart) session.getAttribute("cart");
				if (cart.totalCartProducts().intValue() > 0) { // Co hang trong gio

					// Tao don hang
					SaleOrder saleOrder = new SaleOrder();
					saleOrder.setCustomerName(customer.getTxtName());
					saleOrder.setCustomerMobile(customer.getTxtMobile());
					saleOrder.setCustomerEmail(customer.getTxtEmail());
					saleOrder.setCustomerAddress(customer.getTxtAddress());
					saleOrder.setTotal(cart.totalCartPrice());
					saleOrder.setCode(customer.getTxtMobile());
					saleOrder.setCreateDate(new Date());
					saleOrder.setStatus(false);
					// Set moi quan he voi user
					User user = new User();
					user.setId(1);
					saleOrder.setUser(user);
					// Duyet danh sach san pham trong gio hang va luu vao tvl_sale_order_product DB
					for (CartProduct cartProduct : cart.getCartProducts()) {
						SaleOrderProduct saleOrderProduct = new SaleOrderProduct();
						saleOrderProduct.setQuantity(cartProduct.getQuantity().intValue());
						Product product = productService.getById(cartProduct.getProductId()); // Lay product
						saleOrderProduct.setProduct(product);
						saleOrder.addRelationalProduct(saleOrderProduct);// Luu vao bang tbl_sale_order_product
					}
					// Luu don hang vao tbl_sale_order
					saleOrderService.saveOrder(saleOrder);
					// Xoa gio hang sau khi luu thanh cong
					cart = new Cart();
					session.setAttribute("cart", null);
					jsonResult.put("code", 200);
					jsonResult.put("message", "Ban da dat hang thanh cong");
				} else {
					jsonResult.put("code", 103);
					jsonResult.put("message", "Co loi duong truyen internet");
				}
			} else {
				jsonResult.put("code", 104);
				jsonResult.put("message", "Co loi duong truyen internet");
			}
		}
		return ResponseEntity.ok(jsonResult);
	}
}
