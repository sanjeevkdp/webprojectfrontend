package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class AdminController {
	
	@Autowired
	private Product product;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Category category;
	
	@Autowired
	private SupplierDao supplierDAO;
	
	@Autowired
	private CategoryDao categoryDAO;
	
	
	@Autowired
	private ProductDao productDAO;

	
	@RequestMapping("/home")
	public ModelAndView Login() {
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("Home");
		mv.addObject("isClickedHome", "true");
		return mv;
	}

	@RequestMapping("/manageProducts")
	public ModelAndView suppliers() {
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("product", product);
		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("productList", productDAO.list());
		return mv;
	}

	@RequestMapping("/manageSuppliers")
	public ModelAndView products() {
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("supplier", supplier);
		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("supplierList", supplierDAO.list());
		return mv;
	}

}

