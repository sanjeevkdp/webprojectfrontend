package com.niit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class cartItemController {
//	@RequestMapping("/cart")
//	public String get(HttpServletRequest request){
//		return "redirect:/cart/"+request.getSession(true).getId();
//	}
//    @RequestMapping(value="/{cart_id}",method=RequestMethod.GET)
//    public String getCart(@PathVariable(value="cart_id") String cart_id,Model model){
//    	model.addAttribute("cart_id",cart_id);
//    	return "cart";
//    }
    @RequestMapping("/cart")
    public ModelAndView getCart(Model model){
    	ModelAndView mv=new ModelAndView("index");
    	mv.addObject("isCartClicked","true");
    	mv.addObject("active","cart");
		return mv;
    	
    }
}
  