package vn.sourcecode.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.sourcecode.dto.JwConstants;

@Controller
public class AdminHomeController implements JwConstants {

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String homeAdmin() {
		return "backend/home";
	}
}
