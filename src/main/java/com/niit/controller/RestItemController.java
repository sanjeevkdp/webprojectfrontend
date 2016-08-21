package com.niit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.viewModel.ProductModel;

@RestController
public class RestItemController {
	@Autowired
	Product product;
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	ProductDao productDao;
	@RequestMapping(value="/product/all",method=RequestMethod.GET)
	public @ResponseBody List<ProductModel> list(){
		List<Product> listProduct = productDao.list();
		

		// list the name of supplier and category into the product row

		List<ProductModel> products = new ArrayList<>();
		ProductModel productModel = null;
		for (Product p : listProduct) {
			productModel = new ProductModel();
			productModel.setProduct(p);
			
			if (product!=null) {
				// add category name but first check if category is available 
				if(p.getCategory_id() != null) {			

					category = categoryDao.get(p.getCategory_id());
					productModel.setCategoryName(category.getCategory_name());
				}
				else {
					productModel.setCategoryName("'Not Available'");
					
				}
				
				// add supplier name but first check if supplier is available
				if (p.getSupplier_id() !=null) {
					supplier = supplierDao.get(p.getSupplier_id());
					
					productModel.setSupplierName(supplier.getSupplier_name());
				} else {
					productModel.setSupplierName("'Not Available'");
					
				}
				
			} 
			
			products.add(productModel);

		}
		
				
		return products;
	
		
	}
	

}
