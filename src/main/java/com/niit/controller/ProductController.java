package com.niit.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.sql.Result;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import com.niit.viewModel.ProductModel;

@Controller
public class ProductController {

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

	// ===========================
	// USER SHOW
	// =====================product==============//

	@RequestMapping("/product")
	public ModelAndView productPage(Model model) {
		ModelAndView mv = new ModelAndView("index");
		List<Product> listProduct = productDao.list();
		model.addAttribute("products", listProduct);

		// list the name of supplier and category into the product row

		List<ProductModel> products = new ArrayList<>();
		ProductModel productModel = null;
		for (Product p : listProduct) {
			productModel = new ProductModel();
			productModel.setProduct(p);
			category = categoryDao.get(p.getCategory_id());
			supplier = supplierDao.get(p.getSupplier_id());
			productModel.setCategoryName(category.getCategory_name());
			productModel.setSupplierName(supplier.getSupplier_name());
			products.add(productModel);

		}
		model.addAttribute("products", products);
		mv.addObject("isProductClicked", "true");
		mv.addObject("active", "product");
		//===========list Category in navBar=========//
				List<Category> listCategory = categoryDao.list();
				model.addAttribute("categories", listCategory);
				
		return mv;

	}

	// =============== Admin part==========================//

	// ==========================================//
	// Admin Add Product
	// ===================================================//
	@RequestMapping("/admin/adminAddProduct")
	public ModelAndView adminAddProduct(Model model) {
		ModelAndView mv = new ModelAndView("index");
		List<Product> listProduct = productDao.list();
		model.addAttribute("products", listProduct);

		// list the name of supplier and category into the product row

		List<ProductModel> products = new ArrayList<>();
		ProductModel productModel = null;
		for (Product p : listProduct) {
			productModel = new ProductModel();
			productModel.setProduct(p);
			category = categoryDao.get(p.getCategory_id());
			supplier = supplierDao.get(p.getSupplier_id());
			productModel.setCategoryName(category.getCategory_name());
			productModel.setSupplierName(supplier.getSupplier_name());
			products.add(productModel);

		}
		model.addAttribute("products", products);
		mv.addObject("isAdminAddProductClicked", "true");
		mv.addObject("active", "adminAddProduct");
		//===========list Category in navBar=========//
				List<Category> listCategory = categoryDao.list();
				model.addAttribute("categories", listCategory);
				

		return mv;

	}

	// =====================================second step =====================//
	// add product
	// =====================================================================//

	@RequestMapping("/admin/adminAddProduct/addProduct")
	public ModelAndView AddProduct(Model model) {
		ModelAndView mv = new ModelAndView("index");
		Product product = new Product();
		List<Category> categoryList = categoryDao.list();
		mv.addObject("categories", categoryList);
		List<Supplier> supplierList = supplierDao.list();
		mv.addObject("suppliers", supplierList);
		product.setQuantity(1);
		product.setOut_of_stock(false);
		model.addAttribute("product", product);

		mv.addObject("isAddProductClicked", true);
		mv.addObject("active", "addProduct");
		
		//===========list Category in navBar=========//
				List<Category> listCategory = categoryDao.list();
				model.addAttribute("categories", listCategory);
				

		return mv;
	}

	// =====================================================================//
	// ====================adding Product step third========================

	@RequestMapping(value = "/admin/adminAddProduct", method = RequestMethod.POST)
	public ModelAndView AdminAddProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
			Model model, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("index");

		if (result.hasErrors()) {
			List<Category> categoryList = categoryDao.list();
			mv.addObject("categories", categoryList);
			List<Supplier> supplierList = supplierDao.list();
			mv.addObject("suppliers", supplierList);
			// product.setQuantity(1);
			// product.setOut_of_stock(false);
			// model.addAttribute("product", product);
			mv.addObject("isAddProductClicked", true);
			mv.addObject("active", "addProduct");
			
			//===========list Category in navBar=========//
			List<Category> listCategory = categoryDao.list();
			model.addAttribute("categories", listCategory);
			
			return mv;

		}

		MultipartFile imgUrl = product.getImgUrl();

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		Path path = Paths.get(rootDirectory + "\\resources\\img\\" + product.getProduct_id() + ".png");

		if (imgUrl != null && !imgUrl.isEmpty()) {
			try {
				imgUrl.transferTo(new java.io.File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("product image saving failed", e);
				// TODO: handle exception
			}
		}
		productDao.saveOrUpdate(product);

		List<Product> listProduct = productDao.list();
		model.addAttribute("products", listProduct);

		// list the name of supplier and category into the product row

		List<ProductModel> products = new ArrayList<>();
		ProductModel productModel = null;
		for (Product p : listProduct) {
			productModel = new ProductModel();
			productModel.setProduct(p);
			category = categoryDao.get(p.getCategory_id());
			supplier = supplierDao.get(p.getSupplier_id());
			productModel.setCategoryName(category.getCategory_name());
			productModel.setSupplierName(supplier.getSupplier_name());
			products.add(productModel);

		}
		model.addAttribute("products", products);

		mv.addObject("isAdminAddProductClicked", true);
		mv.addObject("active", "adminAddProduct");
		
		//===========list Category in navBar=========//
				List<Category> listCategory = categoryDao.list();
				model.addAttribute("categories", listCategory);
				
		return mv;
		// return "redirect:/adminAddProduct";
	}

	// ========================================================================//
	// ===============================edit Product forth======================//

	@RequestMapping("/admin/adminAddProduct/editProduct/{product_id}")
	public ModelAndView editProduct(@PathVariable("product_id") String id, Model model) {
		ModelAndView mv = new ModelAndView("index");
		Product product = productDao.get(id);
		List<Category> categoryList = categoryDao.list();
		mv.addObject("categories", categoryList);
		List<Supplier> supplierList = supplierDao.list();
		mv.addObject("suppliers", supplierList);
		model.addAttribute(product);
		mv.addObject("isEditProductClicked", "true");
		mv.addObject("active", "editProduct");
		
		
		//===========list Category in navBar=========//
				List<Category> listCategory = categoryDao.list();
				model.addAttribute("categories", listCategory);
				
		return mv;
	}

	// admin can Edit Product//

	@RequestMapping(value = "/admin/adminAddProduct/editProduct/", method = RequestMethod.POST)
	public ModelAndView EditProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
			Model model, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("index");
		if (result.hasErrors()) {
			List<Category> categoryList = categoryDao.list();
			mv.addObject("categories", categoryList);
			List<Supplier> supplierList = supplierDao.list();
			mv.addObject("suppliers", supplierList);
			// product.setQuantity(1);
			// product.setOut_of_stock(false);
			// model.addAttribute("product", product);
			mv.addObject("isEditProductClicked", "true");
			mv.addObject("active", "editProduct");
			
			//===========list Category in navBar=========//
			List<Category> listCategory = categoryDao.list();
			model.addAttribute("categories", listCategory);
			

			return mv;

		}
		MultipartFile imgUrl = product.getImgUrl();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\resources\\img\\" + product.getProduct_id() + ".png");
		if (imgUrl != null && !imgUrl.isEmpty()) {
			try {
				imgUrl.transferTo(new java.io.File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("product image saving failed", e);
				// TODO: handle exception
			}
		}

		productDao.editProduct(product);
		List<Product> listProduct = productDao.list();
		model.addAttribute("products", listProduct);

		// list the name of supplier and category into the product row

		List<ProductModel> products = new ArrayList<>();
		ProductModel productModel = null;
		for (Product p : listProduct) {
			productModel = new ProductModel();
			productModel.setProduct(p);
			category = categoryDao.get(p.getCategory_id());
			supplier = supplierDao.get(p.getSupplier_id());
			productModel.setCategoryName(category.getCategory_name());
			productModel.setSupplierName(supplier.getSupplier_name());
			products.add(productModel);

		}

		model.addAttribute("products", products);

		mv.addObject("isEditProductClicked", "true");
		mv.addObject("active", "editProduct");
		
		//===========list Category in navBar=========//
				List<Category> listCategory = categoryDao.list();
				model.addAttribute("categories", listCategory);
				

		return mv;
		// return "redirect:/editProduct";
	}

	// ========================delete product fifth===============//
	@RequestMapping("/admin/adminAddProduct/{product_id}")
	public ModelAndView Productdelete(@PathVariable("product_id") String id, Model model, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("index");
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
		productDao.delete(id);
		List<Product> listProduct = productDao.list();
		model.addAttribute("products", listProduct);

		List<ProductModel> products = new ArrayList<>();
		ProductModel productModel = null;
		for (Product p : listProduct) {
			productModel = new ProductModel();
			productModel.setProduct(p);
			category = categoryDao.get(p.getCategory_id());
			supplier = supplierDao.get(p.getSupplier_id());
			productModel.setCategoryName(category.getCategory_name());
			productModel.setSupplierName(supplier.getSupplier_name());
			products.add(productModel);

		}
		model.addAttribute("products", products);

		// return "redirect:/adminAddProduct";
		mv.addObject("isAdminAddProductClicked", true);
		mv.addObject("active", "AdminAddProduct");
		
		//===========list Category in navBar=========//
				List<Category> listCategory = categoryDao.list();
				model.addAttribute("categories", listCategory);
				
		return mv;
	}

	// showing the description

	@RequestMapping("/productShow/{product_id}")
	public ModelAndView productShow(@PathVariable("product_id") String id, Model model) {
		ModelAndView mv = new ModelAndView("index");

		product = productDao.get(id);
		model.addAttribute("product", product);
		
		String categoryName = null;
		String supplierName = null; 
		// check if the product is available or not
		if (product!=null) {
			// add category name but first check if category is available 
			if(product.getCategory_id() != null) {			
				category = categoryDao.get(product.getCategory_id());
				categoryName = category.getCategory_name();
			}
			else {
				category.setCategory_name("'Not Available'");
				categoryName = category.getCategory_name();
			}
			
			// add supplier name but first check if supplier is available
			if (product.getSupplier_id() !=null) {
				supplier = supplierDao.get(product.getSupplier_id());
				supplierName = supplier.getSupplier_name();
			} else {
				supplier.setSupplier_name("'Not Available'");
				supplierName = supplier.getSupplier_name();
			}
			
		} 
		
		
		mv.addObject("categoryName", categoryName);		
		mv.addObject("supplierName", supplierName);
		mv.addObject("isProductShowClicked", "true");
		mv.addObject("active", "productShow");
		//===========list Category in navBar=========//
				List<Category> listCategory = categoryDao.list();
				model.addAttribute("categories", listCategory);
				
		return mv;
	}

}
