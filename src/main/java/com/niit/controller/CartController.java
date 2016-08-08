package com.niit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niit.dao.CartDao;
import com.niit.dao.ProductDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Product;

@Controller
@RequestMapping("/user/cart")
public class CartController {
	@Autowired
	private CartDao cartDao;
	@Autowired
	private ProductDao productDao;
	@RequestMapping(value="/{cart_id}",method=RequestMethod.GET)
	public @ResponseBody Cart read(@PathVariable(value="cart_id") String cart_id){
		return cartDao.read(cart_id);
	}

	@RequestMapping(value="/{cart_id}",method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value="cart_id") String cart_id,@RequestBody Cart cart){
		cartDao.update(cart_id, cart);
	}
	@RequestMapping(value="/{cart_id}",method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value="cart_id") String cart_id){
		cartDao.delete(cart_id);
	}
	@RequestMapping(value="  /add/{product_id}", method =RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value="product_id") String product_id, HttpServletRequest request){
		String session_id=request.getSession(true).getId();
		Cart cart=cartDao.read(session_id);
		if(cart==null){
			cart= cartDao.create(new Cart(session_id));
			
		}
		Product product=productDao.get(product_id);
		if(product==null){
			throw new IllegalArgumentException(new Exception());
		}
		cart.addCartItem(new CartItem(product));
		cartDao.update(session_id, cart);
	}
	@RequestMapping(value="/remove/{product_id}",method=RequestMethod.PUT)
	public void removeItem(@PathVariable(value="product_id") String product_id,HttpServletRequest request ){
		String session_id=request.getSession(true).getId();
		Cart cart=cartDao.read(session_id);
		if(cart==null){
			cart= cartDao.create(new Cart(session_id));
			
		}
		Product product=productDao.get(product_id);
		if(product==null){
			throw new IllegalArgumentException(new Exception());
		}
		cart.deleteCartItem(new CartItem(product));
		cartDao.update(session_id, cart);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="Illegal request,please verify your payload")
	public void handleClientErrors(Exception e){
		
	}
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR,reason="Itenal ServerError")
	public void handleServerError(Exception e){
		
	}
}
