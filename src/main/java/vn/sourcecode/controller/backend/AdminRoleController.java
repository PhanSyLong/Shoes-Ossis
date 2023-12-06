package vn.sourcecode.controller.backend;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.sourcecode.controller.BaseController;
import vn.sourcecode.dto.JwConstants;
import vn.sourcecode.model.Category;
import vn.sourcecode.model.Role;
import vn.sourcecode.model.User;
import vn.sourcecode.service.RoleService;
import vn.sourcecode.service.UserService;
@Controller
public class AdminRoleController extends BaseController implements JwConstants{
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/admin/role-list", method = RequestMethod.GET)
	public String roleList(final Model model,
			final HttpServletRequest request) throws IOException{
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		return "backend/role-list";
	}
	@RequestMapping(value = "/admin/role-add", method = RequestMethod.GET)
	public String roleAdd(final Model model) throws IOException{
		// lay db trong tbl_user len view
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		
		Role role = new Role();
		role.setCreateDate(new Date());
		model.addAttribute("role", role);
		return "backend/role-add";
	}
	@RequestMapping(value = "/admin/role-add-save", method = RequestMethod.POST)
	public String roleAddSave(
			@ModelAttribute("role") Role role) throws IOException{
		roleService.saveOrUpdate(role);
		return "redirect:/admin/role-list";
	}
	@RequestMapping(value = "/admin/role-edit/{roleId}", method = RequestMethod.GET)
	public String roleEdit(final Model model,
			@PathVariable("roleId") int roleId // Lay roleId tu form
			) throws IOException{
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		// lay role tu db thong qua roleId tu form
		Role role = roleService.getById(roleId);
		model.addAttribute("role", role);
		return "backend/role-edit";
	}
	//-------------------Edit-save category-----------------------------------------------
		@RequestMapping(value = "/admin/role-edit-save", method = RequestMethod.POST)
		public String roleEditSave(final Model model,
				@ModelAttribute("role") Role role// lay file upload tu form
				)throws IOException{
			
			roleService.saveOrUpdate(role);
			
			return "redirect:/admin/role-list";
		}
		//-------------------------Inactive role-------------------------------------------------
		@RequestMapping(value = "/admin/role-delete/{roleId}", method = RequestMethod.GET)
		public String productInactive(final Model model,
				@PathVariable("roleId") int roleId
				) throws IOException {
			
			Role role = roleService.getById(roleId);
			role.setStatus(Boolean.FALSE);
			
			roleService.saveOrUpdate(role);
			
			return "redirect:/admin/category-list";
		}
}
