package com.niit.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart")
public class cartItemController {
	@RequestMapping
	public String get(HttpServletRequest request){
		return "redirect:/cart/"+request.getSession(true).getId();
	}
    @RequestMapping(value="/{cart_id}",method=RequestMethod.GET)
    public String getCart(@PathVariable(value="cart_id") String cart_id,Model model){
    	model.addAttribute("cart_id",cart_id);
    	return "cart";
    }
}
