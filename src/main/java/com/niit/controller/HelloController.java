package com.niit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.viewModel.ProductModel;



@Controller
public class HelloController {
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

	
	
	
	
	@RequestMapping({"/","/index"})
	public ModelAndView index(){
	  ModelAndView mv= new ModelAndView("index");
	  mv.addObject("isHomeClicked", "true");
	  mv.addObject("active", "Home");
		return mv;
	}
	 @RequestMapping("/Admin")
	public String Admin(){
		 return "Admin";
	 }
	 
//	      Admin   category mapping
	 
	 
		@RequestMapping("/AdminAddCategory")
		public ModelAndView AdminAddCategory(Model model){
			ModelAndView mv=new ModelAndView("index");
			List<Category> listCategory=categoryDao.list();
			model.addAttribute("categories", listCategory);
			mv.addObject("isAdminAddCategoryClicked", true);
			mv.addObject("active", "AdminAddCategory");
			
			return mv;
		}
	  
		@RequestMapping("/AddCategory")
		public ModelAndView AddCategory(Model model){
			ModelAndView mv=new ModelAndView("index");
			Category category=new Category();
			model.addAttribute("category", category);
			
			mv.addObject("isAddCategoryClicked", true);
			mv.addObject("active", "AddCategory");
			
			return mv;
		}
		@RequestMapping(value="/AdminAddCategory",method=RequestMethod.POST)
		public ModelAndView AdminAddCategoryPost(@ModelAttribute("category") Category category,Model model){
			ModelAndView mv=new ModelAndView("index");
			category.setCategory_id("45");
			categoryDao.saveOrUpdate(category);
			mv.addObject("isAdminAddCategoryClicked", true);
			mv.addObject("active", "AdminAddCategory");
	        return mv;
		}
	
	
	
	
//	============AdminMapping===================//
	@RequestMapping("/AddProduct")
	public ModelAndView AddProduct(Model model){
		ModelAndView mv=new ModelAndView("index");
		Product product=new Product();
		product.setCategory_id("WoodCraft");
		product.setQuantity(1);
		product.setOut_of_stock(false);
       model.addAttribute("product", product);		
		
		
		mv.addObject("isAddProductClicked", true);
		mv.addObject("active", "AddProduct");
		
		return mv;
	}
	
	
	

	
	@RequestMapping("/AddSupplier")
	public ModelAndView AddSupplier(){
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("isAddSupplierClicked", true);
		mv.addObject("active", "AddSupplier");
		
		return mv;
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping({"/Home"})
	public ModelAndView home(){
	  ModelAndView mv= new ModelAndView("index");
	  mv.addObject("isHomeClicked", "true");
	  mv.addObject("active", "Home");
		return mv;
	}
	
	
	@RequestMapping("/Product")
	public ModelAndView productPage(Model model){
		ModelAndView mv = new ModelAndView("index");
		List<Product> listProduct=productDao.list();
		model.addAttribute("products",listProduct);
//		list the name of supplier and category into the product row
		
		
		List<ProductModel> products =new ArrayList<>();
		ProductModel productModel=null;
		for(Product p: listProduct){
			productModel=new ProductModel();
			productModel.setProduct(p);
			category=categoryDao.get(p.getCategory_id());
			supplier=supplierDao.get(p.getSupplier_id());
			productModel.setCategoryName(category.getCategory_name());
			productModel.setSupplierName(supplier.getSupplier_name());
			products.add(productModel);
			
		}
		model.addAttribute("products", products);
		mv.addObject("isProductClicked","true");
		mv.addObject("active","Product");
		
		return mv;

		
	}
	
	@RequestMapping("/Category")
	public ModelAndView productcPage(Model model){
		ModelAndView mv = new ModelAndView("index");
		List<Category> listCategory=categoryDao.list();
		model.addAttribute("categories", listCategory);
		
		
		mv.addObject("isCategoryClicked","true");
		mv.addObject("active","Category");
		return mv;
		


	}
	
	@RequestMapping("/ProductShow/{product_id}")
	public ModelAndView productShow(@PathVariable("product_id") String id,Model model){
		ModelAndView mv = new ModelAndView("index");
		
		 product=productDao.get(id);
		model.addAttribute("product",product);
		category=categoryDao.get(product.getCategory_id());
		String categoryName=category.getCategory_name();
		mv.addObject("categoryName", categoryName);
		supplier=supplierDao.get(product.getSupplier_id());
		String supplierName=supplier.getSupplier_name();
		mv.addObject("supplierName", supplierName);
		
		mv.addObject("isProductShowClicked","true");
		mv.addObject("active","ProductShow");
		return mv;
	}
	
	
	@RequestMapping("/ProductItem")
	public ModelAndView productSingleItem(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isProductItemClicked","true");
		mv.addObject("active","ProductItem");
		return mv;
		


	}
	
	
	
	
//	pages including
	@RequestMapping("/About")
	public ModelAndView About(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isAboutClicked","true");
		mv.addObject("active","About");
		return mv;
	}
	@RequestMapping("/Service")
	public ModelAndView Service(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isServiceClicked","true");
		mv.addObject("active","Service");
		return mv;
	}
	@RequestMapping("/FAQ")
	public ModelAndView FAQ(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isFAQClicked","true");
		mv.addObject("active","FAQ");
		return mv;
	}
	@RequestMapping("/AboutMe")
	public ModelAndView AboutMe(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isAboutMeClicked","true");
		mv.addObject("active","AboutMe");
		return mv;
	}
	
	@RequestMapping("/Login")
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isLoginClicked","true");
		mv.addObject("active","Login");
		return mv;
		
	}
	@RequestMapping("/Register")
	public ModelAndView Register(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isRegisterClicked","true");
		mv.addObject("active","Register");
		return mv;
	}
	@RequestMapping("/Error")
	public ModelAndView Error(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isErrorClicked","true");
		mv.addObject("active","Error");
		return mv;
	}
	@RequestMapping("/Contact")
	public ModelAndView Contactr(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isContactClicked","true");
		mv.addObject("active","Contact");
		return mv;
	}
}
