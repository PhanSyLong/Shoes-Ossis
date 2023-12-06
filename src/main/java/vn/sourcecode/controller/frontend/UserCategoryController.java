package vn.sourcecode.controller.frontend;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.sourcecode.controller.BaseController;

@Controller
public class UserCategoryController extends BaseController {
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String category( final Model model,
						final HttpServletRequest request,
						final HttpServletResponse response) throws IOException {
		return "frontend/category/category";
	}
}
