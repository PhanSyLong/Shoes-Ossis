package vn.sourcecode.controller.frontend;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.sourcecode.controller.BaseController;
import vn.sourcecode.model.Product;
import vn.sourcecode.service.ProductService;

@Controller
public class UserProductController extends BaseController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/product-detail/{productId}", method = RequestMethod.GET)
	public String productDetail(final Model model,
			@PathVariable("productId") int productId,
			final HttpServletRequest request, 
			final HttpServletResponse response) throws IOException {
		
		Product product = productService.getById(productId);
		model.addAttribute("product", product);
		
		return "frontend/product-detail";
	}
}
