package vn.sourcecode.controller.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.sourcecode.controller.BaseController;
import vn.sourcecode.dto.JwConstants;
import vn.sourcecode.dto.SearchModel;
import vn.sourcecode.model.Category;
import vn.sourcecode.model.Product;
import vn.sourcecode.model.User;
import vn.sourcecode.service.CategoryService;
import vn.sourcecode.service.ProductService;
import vn.sourcecode.service.UserService;



@Controller
public class AdminProductController extends BaseController implements JwConstants {
	// Su dung service de thao tac du lieu voi database

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UserService userService;

	// -----------------------List product-------------------------------------------------
		@RequestMapping(value = "/admin/product-list", method = RequestMethod.GET)
		public String productList(final Model model,
				final HttpServletRequest request) throws IOException {
			// lay danh sach product tu tbl_product trong database
//			List<Product> products = productService.findAll();
			// lay danh sach category tu tbl_category trong database
			List<Category> categories = categoryService.findAll();
			model.addAttribute("categories", categories);
			
			SearchModel productSearch = new SearchModel();
			
			//Tim voi tieu chi status
			productSearch.setStatus(2);//Khong chon(all)
			if(!StringUtils.isEmpty(request.getParameter("status"))) {//Co chon active or inactive
				productSearch.setStatus(Integer.parseInt(request.getParameter("status")));
			}
			
			//Tim voi tieu chi category
			productSearch.setCategoryId(0);//Khong chon category(all)
			if(!StringUtils.isEmpty(request.getParameter("categoryId"))) {
				productSearch.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			}
			
			//Tim kiem voi tieu chí keyword
			productSearch.setKeyword(request.getParameter("keyword"));
			
			//Tim kiem voi tieu chi
			productSearch.setBeginDate(request.getParameter("beginDate"));
			productSearch.setEndDate(request.getParameter("endDate"));
			
			
		// Bat dau phan trang
			if(!StringUtils.isEmpty(request.getParameter("page"))){ // Bam nut chuyen trang
				productSearch.setCurrentPage(Integer.parseInt(request.getParameter("page")));
			}
			else {
				productSearch.setCurrentPage(1);//Lan dau truy cap luon hien thi trang 
			}
			
			
			List<Product> allProducts = productService.searchProduct(productSearch);
			
			
			List<Product> products = new ArrayList<Product>();
			
			//Neu tong so trang ma nho hon trang hien tai
			int totalPages = allProducts.size() / SIZE_OF_PAGE;
			if (allProducts.size() % SIZE_OF_PAGE > 0) {
				totalPages++;
			}
			if (totalPages < productSearch.getCurrentPage()) {
				productSearch.setCurrentPage(1);
			}
			
			int firstIndex = (productSearch.getCurrentPage() - 1) * SIZE_OF_PAGE;
			int index = firstIndex, count = 0;
			while(index < allProducts.size() && count < SIZE_OF_PAGE) {
				products.add(allProducts.get(index));
				index++;
				count++;
			}
			
			//phan trang
			productSearch.setSizeOfPage(SIZE_OF_PAGE);// So ban ghi tren mot trang
			productSearch.setTotalItems(allProducts.size());// Tong so san pham
			
			model.addAttribute("products", products);
			model.addAttribute("productSearch", productSearch);
			return "backend/product-list";
		}

	// -----------------------Add product-------------------------------------------------
	@RequestMapping(value = "/admin/product-add", method = RequestMethod.GET)
	public String productAdd(final Model model) throws IOException {
		// lay danh sach user tu tbl_user trong database
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		// day du lieu product len product-list
		Product product = new Product();
		model.addAttribute("product", product);

		return "backend/product-add";
	}

	// -----------------------Add-save-product-------------------------------------------------
		@RequestMapping(value = "/admin/product-add-save", method = RequestMethod.POST)
		public String productAddSave(final Model model, @ModelAttribute("product") Product product, // lay file upload tu
																									// form
				@RequestParam("avatarFile") MultipartFile avatarFile,
				@RequestParam("imageFiles") MultipartFile[] imageFiles) throws IOException {

			productService.saveAddProduct(product, avatarFile, imageFiles);

			return "redirect:/admin/product-list";
		}

	// -------------------Edit product--------------------------------------------------------
	@RequestMapping(value = "/admin/product-edit/{productId}", method = RequestMethod.GET)
	public String productEdit(final Model model, @PathVariable("productId") int productId // Lay product id khi cick
																							// Edit
	) throws IOException {
		// lay danh sach user tu tbl_user trong database
		List<User> users = userService.findAll();
		model.addAttribute("users", users);

		// Lay product tu tbl_prduct trong database
		Product product = productService.getById(productId);
		model.addAttribute("product", product);

		// lay danh sach category tu tbl_category trong database
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);

		return "backend/product-edit";
	}

	// -------------------Edit-save product-----------------------------------------------
		@RequestMapping(value = "/admin/product-edit-save", method = RequestMethod.POST)
		public String productEditSave(final Model model, 
				@ModelAttribute("product") Product product, 	// lay file upload tu form
				@RequestParam("avatarFile") MultipartFile avatarFile,
				@RequestParam("imageFiles") MultipartFile[] imageFiles) throws IOException {

			productService.saveEditProduct(product, avatarFile, imageFiles);

			return "redirect:/admin/product-list";
	}
//	// -----------------------Delete product-------------------------------------------------
//		@RequestMapping(value = "/admin/product-delete/{productId}", method = RequestMethod.GET)
//		public String deleteProduct(final Model model,
//				@PathVariable("productId") int productId
//				) throws IOException {
//			
//			productService.deleteProductById(productId);
//			
//			return "redirect:/admin/product-list";
//		}
	//-------------------------Inactive product-------------------------------------------------
			@RequestMapping(value = "/admin/product-delete/{productId}", method = RequestMethod.GET)
			public String productInactive(final Model model,
					@PathVariable("productId") int productId
					) throws IOException {
				
				Product product = productService.getById(productId);
				product.setStatus(Boolean.FALSE);
				
				productService.saveOrUpdate(product);
				
				return "redirect:/admin/product-list";
			}
}

