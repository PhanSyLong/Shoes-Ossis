package vn.sourcecode.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.sourcecode.model.Product;
import vn.sourcecode.service.ProductService;

@Controller
public class UserHomeController extends vn.sourcecode.controller.BaseController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(final Model model, 
						final HttpServletRequest request, 
						final HttpServletResponse response) throws IOException {
		
		List<Product> products = productService.findAllActive();
		
		model.addAttribute("products", products);
		model.addAttribute("totalProducts", products.size());
		return "frontend/home";
	}
	
}
