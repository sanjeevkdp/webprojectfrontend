package com.niit.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
import com.niit.viewModel.ProductModel;

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
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isHomeClicked", "true");
		mv.addObject("active", "home");
		return mv;
	}

	@RequestMapping("/admin")
	public String Admin() {
		return "admin";
	}

	// ============category==================//

	@RequestMapping("/category")
	public ModelAndView productcPage(Model model) {
		ModelAndView mv = new ModelAndView("index");
		List<Category> listCategory = categoryDao.list();
		model.addAttribute("categories", listCategory);

		mv.addObject("isCategoryClicked", "true");
		mv.addObject("active", "category");
		return mv;

	}

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

	// rever

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
		Category category = new Category();
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
	public String editcategory(@PathVariable("category_id") String id, Model model) {
		// ModelAndView mv = new ModelAndView("index");
		Category category = categoryDao.get(id);
		model.addAttribute(category);
		// mv.addObject("isEditCategoryClicked", "true");
		// mv.addObject("active", "editCategory");
		return "editCategory";
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

	// ============AdminMapping===================//
	
	@RequestMapping("/addProduct")
	public ModelAndView AddProduct(Model model) {
		ModelAndView mv = new ModelAndView("index");
		Product product = new Product();
		product.setCategory_id("WoodCraft");
		product.setQuantity(1);
		product.setOut_of_stock(false);
		model.addAttribute("product", product);

		mv.addObject("isAddProductClicked", true);
		mv.addObject("active", "addProduct");

		return mv;
	}

	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isHomeClicked", "true");
		mv.addObject("active", "home");
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

	@RequestMapping("/productItem")
	public ModelAndView productSingleItem() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isProductItemClicked", "true");
		mv.addObject("active", "productItem");
		return mv;

	}

	// pages including
	@RequestMapping("/about")
	public ModelAndView About() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isAboutClicked", "true");
		mv.addObject("active", "about");
		return mv;
	}

	@RequestMapping("/service")
	public ModelAndView Service() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isServiceClicked", "true");
		mv.addObject("active", "service");
		return mv;
	}

	// @RequestMapping("/Admin")
	// public ModelAndView AdminByIndex(){
	// ModelAndView mv = new ModelAndView("index");
	// mv.addObject("isAdminClicked","true");
	// mv.addObject("active","Admin");
	// return mv;
	// }
	@RequestMapping("/aboutMe")
	public ModelAndView AboutMe() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isAboutMeClicked", "true");
		mv.addObject("active", "aboutMe");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isLoginClicked", "true");
		mv.addObject("active", "login");
		return mv;

	}

	@RequestMapping("/register")
	public ModelAndView Register() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isRegisterClicked", "true");
		mv.addObject("active", "register");
		return mv;
	}

	@RequestMapping("/error")
	public ModelAndView Error() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isErrorClicked", "true");
		mv.addObject("active", "error");
		return mv;
	}

	@RequestMapping("/contact")
	public ModelAndView Contactr() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isContactClicked", "true");
		mv.addObject("active", "contact");
		return mv;
	}

}
