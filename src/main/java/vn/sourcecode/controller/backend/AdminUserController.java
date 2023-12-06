package vn.sourcecode.controller.backend;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.sourcecode.controller.BaseController;
import vn.sourcecode.model.Role;
import vn.sourcecode.model.User;
import vn.sourcecode.service.RoleService;
import vn.sourcecode.service.UserService;

@Controller
public class AdminUserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/admin/user-list", method = RequestMethod.GET)
	public String userList(final Model model) throws IOException {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "backend/user-list";
	}
	//-------------------ADD user-------------------------
	@RequestMapping(value = "/admin/user-add", method = RequestMethod.GET)
	public String userAdd(final Model model) throws IOException {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		
		User user = new User();
		user.setCreateDate(new Date());
		model.addAttribute("user", user);
		
		return "backend/user-add";
	}
	// Save to database
		@RequestMapping(value = "/admin/user-add-save", method = RequestMethod.POST)
		public String userAddSave(final Model model,
				final HttpServletRequest request,
				@ModelAttribute("user") User user)throws IOException {
			
			if(!StringUtils.isEmpty(request.getParameter("role"))){
				int roleId = Integer.parseInt(request.getParameter("role"));
				// lay role tu tbl_role trong DB
				Role role = roleService.getById(roleId);
				
				//Luu user_id va role_id vao tbl_user_role
				user.addRelationalUserRole(role);
				
				//Ma hoa
				user.setPassword(new BCryptPasswordEncoder(4).encode(user.getPassword()));
				
				// Luu user vao bang tbl_user
				userService.saveOrUpdate(user);
			}
		// khong chon role thi khong luu user
			return "redirect:/admin/user-list";
		}
		//-------------------Edit user------------------------
		@RequestMapping(value = "/admin/user-edit/{userId}", method = RequestMethod.GET)
		public String userEdit(final Model model,
				@PathVariable("userId") int userId //Lay user id khi cick Edit
				)throws IOException {
			// Lay user tu tbl_user trong database
			
			User user = userService.getById(userId);
			model.addAttribute("user", user);
			
			List<User> users = userService.findAll();
			model.addAttribute("users", users);
			
			return "backend/user-edit";
		}
		// Save to database
			@RequestMapping(value = "/admin/user-edit-save", method = RequestMethod.POST)
			public String userEditSave(final Model model,
					final HttpServletRequest request,
					@ModelAttribute("user") User user)throws IOException {
				
					userService.saveOrUpdate(user);
					
				return "redirect:/admin/user-list";
			}
//			//-------------------Delete user------------------------
//			@RequestMapping(value = "/admin/user-delete/{userId}", method = RequestMethod.GET)
//			public String userDelete(final Model model,
//					@PathVariable("userId") int userId //Lay user id khi cick Edit
//					)throws IOException {
//				
//				userService.deleteUserById(userId);
//				
//				return "redirect:/admin/user-list";
//			}
			
			//-------------------Delete user------------------------
			@RequestMapping(value = "/admin/user-delete/{userId}", method = RequestMethod.GET)
			public String userDelete(final Model model,
					@PathVariable("userId") int userId //Lay user id khi cick Edit
					)throws IOException {
				
				User user = userService.getById(userId);
				user.setStatus(Boolean.FALSE);
				
				userService.saveOrUpdate(user);
				
				return "redirect:/admin/user-list";
			}
//			//-------------------Inactive user------------------------
//			@RequestMapping(value = "/admin/user-delete/{userId}", method = RequestMethod.GET)
//			public String userDelete(final Model model,
//					@PathVariable("userId") int userId //Lay user id khi cick Edit
//					)throws IOException {
//				
//				User user = userService.getById(userId);
//				user.setStatus(Boolean.FALSE);
//				
//				userService.saveOrUpdate(user);
//				
//				return "redirect:/admin/user-list";
//			}
}
