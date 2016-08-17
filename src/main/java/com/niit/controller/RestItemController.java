package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.ProductDao;
import com.niit.model.Product;

@RestController
public class RestItemController {
	@Autowired
	ProductDao productDao;
	@RequestMapping("/product/all")
	public @ResponseBody List<Product> list(){
		return productDao.list(); 
	
		
	}
	

}
