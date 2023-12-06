package vn.sourcecode.controller.backend;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.sourcecode.model.Category;
import vn.sourcecode.model.Product;
import vn.sourcecode.model.User;
import vn.sourcecode.service.CategoryService;
import vn.sourcecode.service.UserService;

@Controller
public class AdminCategoryController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/admin/category-list", method = RequestMethod.GET)
	public String categoryList(final Model model)throws IOException {
		// lay danh sach user tu tbl_user trong database
		List<Category> categories = categoryService.findAll();
		// day danh sach len user-list
		model.addAttribute("categories", categories);
		// day user-list len locallhost
		return "backend/category-list";
	}
	
	@RequestMapping(value = "/admin/category-add", method = RequestMethod.GET)
	public String categoryAdd(final Model model)throws IOException {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		// lay danh sach category tu tbl_category trong database
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		Category category = new Category();
		model.addAttribute("category", category);
	
		return "backend/category-add";
	}
	
	@RequestMapping(value = "/admin/category-add-save", method = RequestMethod.POST)
	public String categoryAddSave(
			@ModelAttribute("category") Category category
			)throws IOException{
		
		categoryService.saveOrUpdate(category);
		
		return "redirect:/admin/category-list";
	}
	
	//-------------------Edit category--------------------------------------------------------
		@RequestMapping(value = "/admin/category-edit/{categoryId}", method = RequestMethod.GET)
		public String categoryEdit(final Model model,
				@PathVariable("categoryId") int categoryId //Lay category id khi cick Edit
				)throws IOException {
			List<User> users = userService.findAll();
			model.addAttribute("users", users);
			// Lay category tu tbl_category trong database
			Category category = categoryService.getById(categoryId);
			model.addAttribute("category", category);
			
			return "backend/category-edit";
		}
	//-------------------Edit-save category-----------------------------------------------
	@RequestMapping(value = "/admin/category-edit-save", method = RequestMethod.POST)
	public String categoryEditSave(final Model model,
			@ModelAttribute("category") Category category// lay file upload tu form
			)throws IOException{
		
		categoryService.saveOrUpdate(category);
		
		return "redirect:/admin/category-list";
	}
	//-------------------------Inactive category-------------------------------------------------
	@RequestMapping(value = "/admin/category-delete/{categoryId}", method = RequestMethod.GET)
	public String productInactive(final Model model,
			@PathVariable("categoryId") int categoryId
			) throws IOException {
		
		Category category = categoryService.getById(categoryId);
		category.setStatus(Boolean.FALSE);
		
		categoryService.saveOrUpdate(category);
		
		return "redirect:/admin/category-list";
	}
}