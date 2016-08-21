package com.niit.controller;

import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;


@Controller
public class HelloController {
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


	@RequestMapping({ "/", "/index" })
	public ModelAndView index(Model model) {
		ModelAndView mv = new ModelAndView("index");
		List<Product> list=productDao.list();
		mv.addObject("list",list);
		
		mv.addObject("isHomeClicked", "true");
		mv.addObject("active", "home");
		//===========list Category in navBar=========//
				List<Category> listCategory = categoryDao.list();
				model.addAttribute("categories", listCategory);
				
		return mv;
	}

	@RequestMapping("/admin")
	public String Admin(Model model) {
		
		//===========list Category in navBar=========//
				List<Category> listCategory = categoryDao.list();
				model.addAttribute("categories", listCategory);
				
		return "admin";
	}

	
	
	

	
		
	// ============AdminMapping===================//
	

	@RequestMapping("/home")
	public ModelAndView home(Model model) {
		ModelAndView mv = new ModelAndView("index");
		List<Product> list=productDao.list();
		mv.addObject("list",list);
		
		
		mv.addObject("isHomeClicked", "true");
		mv.addObject("active", "home");
		
		//===========list Category in navBar=========//
		List<Category> listCategory = categoryDao.list();
		model.addAttribute("categories", listCategory);
			
		
		return mv;
	}


	@RequestMapping("/productItem")
	public ModelAndView productSingleItem(Model model) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isProductItemClicked", "true");
		mv.addObject("active", "productItem");
		
		//===========list Category in navBar=========//
		List<Category> listCategory = categoryDao.list();
		model.addAttribute("categories", listCategory);
				
		return mv;

	}

	// pages including
	@RequestMapping("/about")
	public ModelAndView About(Model model) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isAboutClicked", "true");
		mv.addObject("active", "about");
		
		//===========list Category in navBar=========//
				List<Category> listCategory = categoryDao.list();
				model.addAttribute("categories", listCategory);
				
		return mv;
	}

	@RequestMapping("/service")
	public ModelAndView Service(Model model) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isServiceClicked", "true");
		mv.addObject("active", "service");
		
		//===========list Category in navBar=========//
				List<Category> listCategory = categoryDao.list();
				model.addAttribute("categories", listCategory);
				
		return mv;
	}

	// @RequestMapping("/Admin")
	 //public ModelAndView AdminByIndex(){
	 //ModelAndView mv = new ModelAndView("index");
	 //mv.addObject("isAdminClicked","true");
	 //mv.addObject("active","Admin");
	 //return mv;
	 //}


//	@RequestMapping("/login")
//	public ModelAndView login(Model model) {
//		ModelAndView mv = new ModelAndView("index");
//		mv.addObject("isLoginClicked", "true");
//		mv.addObject("active", "login");
//		
//		//===========list Category in navBar=========//
//				List<Category> listCategory = categoryDao.list();
//				model.addAttribute("categories", listCategory);
//				
//		return mv;
//
//	}

	@RequestMapping("/register")
	public ModelAndView Register(Model model) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isRegisterClicked", "true");
		mv.addObject("active", "register");
		
		//===========list Category in navBar=========//
				List<Category> listCategory = categoryDao.list();
				model.addAttribute("categories", listCategory);
				
		return mv;
	}



	@RequestMapping("/contact")
	public ModelAndView Contactr(Model model) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isContactClicked", "true");
		mv.addObject("active", "contact");
		
		//===========list Category in navBar=========//
				List<Category> listCategory = categoryDao.list();
				model.addAttribute("categories", listCategory);
				
		return mv;
	}
   @RequestMapping("/productviewbyCategory/{category_id}")
   public ModelAndView ViewCategory(@PathVariable("category_id")String category_id,Model model){
	   ModelAndView mv=new ModelAndView("index");
	   
	   List<Product> productList = categoryDao.ProductListByCategory(category_id);
		if (!productList.isEmpty()) {
			mv.addObject("productList", productList);
		} else {
			mv.addObject("productNotPresent", "true");
		}
	   
	   mv.addObject("isProductByCategory","true");
//	   mv.addObject("active","productByCategory");
//	   
	 //===========list Category in navBar=========//
		List<Category> listCategory = categoryDao.list();
		model.addAttribute("categories", listCategory);

	   return mv;
   }
   @RequestMapping(value="/productItems/",method=RequestMethod.GET)
   public ModelAndView productItems(@RequestParam("keyword") String keyword,Model model){
	   ModelAndView mv =new ModelAndView("index");
	   List<Product> listOfProduct=productDao.productItems(keyword);
	   if(!listOfProduct.isEmpty()){
		   mv.addObject("products",listOfProduct);		   
	   }
	   else{
		   model.addAttribute("noProductFound","Sorry! ............"+keyword);
	   }
	   
	   //===========list Category in navBar=========//
		List<Category> listCategory = categoryDao.list();
		model.addAttribute("categories", listCategory);
	   
	   
	   mv.addObject("isProductItemClicked",true);
	   return mv;
	   
	  
   }
}
