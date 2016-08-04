package com.niit.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class CategoryController {

	private Path path;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private Product product;
	@Autowired
	private Category category;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private Supplier supplier;
	@Autowired
	private SupplierDao supplierDao;
	
	
	

	// ============category first Step==================//

	@RequestMapping("/category")
	public ModelAndView productcPage(Model model) {
		ModelAndView mv = new ModelAndView("index");
		List<Category> listCategory = categoryDao.list();
		model.addAttribute("categories", listCategory);
		mv.addObject("category", category);
		mv.addObject("isCategoryClicked", "true");
		mv.addObject("active", "category");
		
		return mv;

	}

	// Admin category mapping

	@RequestMapping("/adminAddCategory")
	public ModelAndView AdminAddCategory(Model model) {
		ModelAndView mv = new ModelAndView("index");
		List<Category> listCategory = categoryDao.list();
		model.addAttribute("categories", listCategory);
		mv.addObject("isAdminAddCategoryClicked", true);
		mv.addObject("active", "adminAddCategory");

		return mv;
	}

	@RequestMapping("/addCategory")
	public ModelAndView AddCategory(Model model) {
		ModelAndView mv = new ModelAndView("index");
		//Category category = new Category();
		model.addAttribute("category", category);

		mv.addObject("isAddCategoryClicked", true);
		mv.addObject("active", "addCategory");

		return mv;
	}

	// AddCategory

	@RequestMapping(value = "/adminAddCategory", method = RequestMethod.POST)
	public String AdminAddCategoryPost(@ModelAttribute("category") Category category, Model model,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("index");

		MultipartFile imgUrl = category.getImgUrl();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\resources\\img\\" + category.getCategory_id() + ".png");
		if (imgUrl != null && !imgUrl.isEmpty()) {
			try {
				imgUrl.transferTo(new java.io.File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("product image saving failed", e);
				// TODO: handle exception
			}
		}
		categoryDao.saveOrUpdate(category);

		// mv.addObject("isAdminAddCategoryClicked", true);
		// mv.addObject("active", "redirect:/AdminAddCategory");
		return "redirect:/adminAddCategory";
	}

	// Delete Category==============//

	@RequestMapping("/adminAddCategory/{category_id}")
	public String Categorydelete(@PathVariable("category_id") String id, Model model, HttpServletRequest request) {

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\resources\\img\\" + id + ".png");
		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

		}
		categoryDao.delete(id);
		return "redirect:/adminAddCategory";
	}

	// ======EditCategory
	
	

	@RequestMapping("/editCategory/{category_id}")
	public ModelAndView editcategory(@PathVariable("category_id") String id, Model model) {
		 ModelAndView mv = new ModelAndView("index");
		Category category = categoryDao.get(id);
		model.addAttribute(category);
		 mv.addObject("isEditCategoryClicked", "true");
		 mv.addObject("active", "editCategory");
		return mv;
	}

	@RequestMapping(value = "/editCategory", method = RequestMethod.POST)
	public String EditCategoryPost(@ModelAttribute("category") Category category, Model model,
			HttpServletRequest request) {
		// ModelAndView mv = new ModelAndView("index");

		MultipartFile imgUrl = category.getImgUrl();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\resources\\img\\" + category.getCategory_id() + ".png");
		if (imgUrl != null && !imgUrl.isEmpty()) {
			try {
				imgUrl.transferTo(new java.io.File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("category image saving failed", e);
				// TODO: handle exception
			}
		}
		categoryDao.editCategory(category);

		// mv.addObject("isAdminAddCategoryClicked", true);
		// mv.addObject("active", "redirect:/AdminAddCategory");
		return "redirect:/editCategory";
	}



}
