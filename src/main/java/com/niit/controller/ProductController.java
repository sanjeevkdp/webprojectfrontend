package com.niit.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

		return mv;

	}
	
//=============== Admin part==========================//
	
	

//	==========================================//
//	     Admin Add Product
	//===================================================//
	@RequestMapping("/adminAddProduct")
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

		return mv;

	}
	
	//=====================================second step =====================//
	//    add product
	//=====================================================================//

	@RequestMapping("/addProduct")
	public ModelAndView AddProduct(Model model) {
		ModelAndView mv = new ModelAndView("index");
		Product product = new Product();
		List<Category> categoryList = categoryDao.list();
		mv.addObject("categories", categoryList);
		List<Supplier> supplierList =supplierDao.list();
		mv.addObject("suppliers", supplierList);
		product.setQuantity(1);
		product.setOut_of_stock(false);
		model.addAttribute("product", product);

		mv.addObject("isAddProductClicked", true);
		mv.addObject("active", "addProduct");

		return mv;
	}
	
	
	
	
	                    
	//=====================================================================//
	//====================adding Product step third========================
	
	@RequestMapping(value ="/adminAddProduct", method = RequestMethod.POST)
	public ModelAndView AdminAddProductPost(@Valid @ModelAttribute("product") Product product, Model model,BindingResult result,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("index");

		if(result.hasErrors()){
			mv.addObject("isAddProductClicked", true);
			mv.addObject("active", "eeeaddProduct");

			return mv;
			
		}
	
		
		MultipartFile imgUrl = product.getImgUrl();
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		
		Path path = Paths.get(rootDirectory +"\\resources\\img\\"+product.getProduct_id()+".png");
		
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
		return mv;
		//return "redirect:/adminAddProduct";
	}
	
	
	//========================================================================//
	//===============================edit Product forth======================//
	
	
	@RequestMapping("/editProduct/{product_id}")
	public ModelAndView editProduct(@PathVariable("product_id") String id, Model model) {
		 ModelAndView mv = new ModelAndView("index");
		 Product product = productDao.get(id);
		 List<Category> categoryList = categoryDao.list();
			mv.addObject("categories", categoryList);
			List<Supplier> supplierList =supplierDao.list();
			mv.addObject("suppliers", supplierList);
		model.addAttribute(product);
		 mv.addObject("isEditProductClicked", "true");
		 mv.addObject("active", "editProduct");
		return mv;
	}

	@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
	public ModelAndView EditProductPost(@ModelAttribute("product") Product product, Model model,
			HttpServletRequest request) {
		   ModelAndView mv = new ModelAndView("index");

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
	
	return mv;
		//return "redirect:/editProduct";
	}

	
	//========================delete product fifth===============//
	@RequestMapping("/adminAddProduct/{product_id}")
	public ModelAndView Productdelete(@PathVariable("product_id") String id, Model model, HttpServletRequest request) {
                ModelAndView mv=new ModelAndView("index");
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
		
		
		//return "redirect:/adminAddProduct";
		 mv.addObject("isAdminAddProductClicked", true);
		 mv.addObject("active", "AdminAddProduct");
		return mv;
	}
	

	// showing the description

	@RequestMapping("/productShow/{product_id}")
	public ModelAndView productShow(@PathVariable("product_id") String id, Model model) {
		ModelAndView mv = new ModelAndView("index");

		product = productDao.get(id);
		model.addAttribute("product", product);
		category = categoryDao.get(product.getCategory_id());
		String categoryName = category.getCategory_name();
		mv.addObject("categoryName", categoryName);
		supplier = supplierDao.get(product.getSupplier_id());
		String supplierName = supplier.getSupplier_name();
		mv.addObject("supplierName", supplierName);

		mv.addObject("isProductShowClicked", "true");
		mv.addObject("active", "productShow");
		return mv;
	}

}
