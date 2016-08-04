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
public class SupplierController {

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
	
	

	// ===========================================
	//                         SUPPLIER
	// ===========================================

	// ======================= show the tale First Step=======================//

	@RequestMapping("/adminAddSupplier")
	public ModelAndView AdminAddSupplier(Model model) {
		ModelAndView mv = new ModelAndView("index");
		List<Supplier> listSupplier = supplierDao.list();
		model.addAttribute("suppliers", listSupplier);
		mv.addObject("isAdminAddSupplierClicked", true);
		mv.addObject("active", "adminAddSupplier");

		return mv;
	}

	//================== ADDINGForm for SUPPLIER second Step================//

	@RequestMapping("/addSupplier")
	public ModelAndView AddSupplier(Model model) {
		ModelAndView mv = new ModelAndView("index");
        Supplier supplier = new Supplier();
	
		model.addAttribute("supplier",supplier);

		mv.addObject("isAddSupplierClicked", true);
		mv.addObject("active", "addSupplier");

		return mv;
	}

//========================Adding the content to database third step================
	
	
	
	@RequestMapping(value = "/adminAddSupplier", method = RequestMethod.POST)
	public String AdminAddSupplierPost(@ModelAttribute("supplier") Supplier supplier, Model model,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("index");

		MultipartFile imgUrl = supplier.getImgUrl();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\resources\\img\\" + supplier.getSupplier_id() + ".png");
		if (imgUrl != null && !imgUrl.isEmpty()) {
			try {
				imgUrl.transferTo(new java.io.File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("product image saving failed", e);
				// TODO: handle exception
			}
		}
		supplierDao.saveOrUpdate(supplier);

		// mv.addObject("isAdminAddCategoryClicked", true);
		// mv.addObject("active", "redirect:/AdminAddCategory");
		return "redirect:/adminAddSupplier";
	}
//================================show the profile forth step=============================//
	
	
	@RequestMapping("/profile/{supplier_id}")
	public ModelAndView SupplierProfile(@PathVariable("supplier_id") String id, Model model) {
		ModelAndView mv = new ModelAndView("index");

		supplier = supplierDao.get(id);
		model.addAttribute("supplier", supplier);
        mv.addObject("isProfileClicked", "true");
		mv.addObject("active", "profile");
		return mv;
	}
	
	
	
	
	
	
//================================ Delete supplier fifth step=============================//
	
	@RequestMapping("/adminAddSupplier/{supplier_id}")
	public String DeleteSupplier(@PathVariable("supplier_id") String id, Model model, HttpServletRequest request) {

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
		supplierDao.delete(id);
		return "redirect:/adminAddSupplier";
	}
   
	
	//=================Edit supplier=============================//
	
	

	@RequestMapping("/editSupplier/{supplier_id}")
	public ModelAndView editSupplier(@PathVariable("supplier_id") String id, Model model) {
		 ModelAndView mv = new ModelAndView("index");
		 Supplier supplier = supplierDao.get(id);
		model.addAttribute(supplier);
		 mv.addObject("isEditSupplierClicked", "true");
		 mv.addObject("active", "editSupplier");
		return mv;
	}

	@RequestMapping(value = "/editSupplier", method = RequestMethod.POST)
	public String EditSupplierPost(@ModelAttribute("supplier") Supplier supplier, Model model,
			HttpServletRequest request) {
		// ModelAndView mv = new ModelAndView("index");

		MultipartFile imgUrl = supplier.getImgUrl();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\resources\\img\\" + supplier.getSupplier_id() + ".png");
		if (imgUrl != null && !imgUrl.isEmpty()) {
			try {
				imgUrl.transferTo(new java.io.File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("supplier image saving failed", e);
				// TODO: handle exception
			}
		}
		supplierDao.editSupplier(supplier);

		// mv.addObject("isEditSupplierClicked", true);
		// mv.addObject("active", "redirect:/editSupplier");
		return "redirect:/editSupplier";
	}
	
	

}
