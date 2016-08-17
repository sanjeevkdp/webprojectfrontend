//package com.niit.controller;
//
//import java.security.Principal;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.niit.dao.CartDao;
//import com.niit.dao.CartItemDao;
//import com.niit.dao.CategoryDao;
//import com.niit.dao.CustomerDao;
//import com.niit.dao.ProductDao;
//import com.niit.dao.SupplierDao;
//import com.niit.model.Cart;
//import com.niit.model.CartItem;
//import com.niit.model.Category;
//import com.niit.model.Customer;
//import com.niit.model.Product;
//import com.niit.model.Supplier;
//import com.niit.viewModel.CartItemModel;
//
//@Controller
//public class CartController {
//
//	@Autowired
//	private ProductDao productDao;
//	@Autowired
//	private Product product;
//	@Autowired
//	private Category category;
//	@Autowired
//	private CategoryDao categoryDao;
//	@Autowired
//	private Supplier supplier;
//	@Autowired
//	private SupplierDao supplierDao;
//	@Autowired
//	private Cart cart;
//	@Autowired
//	private CartItem cartItem;
//	@Autowired
//	private CartDao cartDao;
//	@Autowired
//	private CartItemDao cartItemDao;
//	@Autowired
//	private Customer customer;
//	@Autowired
//	private CustomerDao customerDao;
//	
//	@Autowired
//	HttpSession HttpSession;
//	@RequestMapping("/cart/addToCart/{product_id}")
//	public String addToCart(@PathVariable("product_id") String product_id, Model model, Principal principal,HttpServletRequest request) {
//		//1.get the customer name
//		
//		String user=principal.getName();
//		
//		System.out.println(user);
//        
//		customer=customerDao.getCustomerByUserName(user);
//       // 2.get the customer 
//		String id=customer.getCustomerId();
//        System.out.println(id);
//        
//        
//      // 3. assign cart to the customer  
//      //  cart = new Cart();
//       // cart.setCustomerId(id);
//      //  cart=cartDao.getCartByCustomerId(id);
//        
//      //4.select from product  
//        product = productDao.get(product_id);
//    
//        
//        //5.insert items into database
//        // if cart is not  available
//        if((cart=cartDao.getCartByCustomerId(id))==null){
//        cart=new Cart();
//        cart.setCustomerId(customer.getCustomerId());
//        cart.setGrandTotal(product.getUnit_price());
//        cart.setNoOfproduct(1);
//        cartDao.saveOrUpdate(cart);
//        }
//        
//        
//       //6.insert into database
//        if(addCartItem(id ,product_id,model)==null){
//        cartItem=new CartItem();
//        cartItem.setCart_id(cart.getCart_id());
//        cartItem.setCustomerId(id);
//        cartItem.setProduct_id(product.getProduct_id());
//        cartItem.setQuantity(1);
//        cartItem.setTotalPrice(product.getUnit_price());
//        cartItemDao.persist(cartItem);
//        }
//        // if productIs available then
//       
//      
//      
//        
//       List<CartItem> listOfProduct=cartItemDao.getCartItemsByCustomerId(id);
//       double grandTotal= 0.0 ; 
//       for(CartItem item: listOfProduct){
//    	   grandTotal=grandTotal+product.getUnit_price();
//       }
//       cart.setCart_id(cart.getCart_id());
//       cart.setCustomerId(id);
//       cart.setGrandTotal(grandTotal);
//       int size=listOfProduct.size();
//       cart.setNoOfproduct(size);
//       cartDao.saveOrUpdate(cart);
//       
//		return "redirect:/productShow/{product_id}";
//		
//		
//		
//		
//	}
//
//	private String addCartItem(String id, String product_id, Model model) {
//		 List<CartItem> productList=cartItemDao.getCartItemsByCustomerId(id);
//		
//	        for(CartItem itemCart:productList){
//	        String itemProduct_id=itemCart.getProduct_id();
//	        if(product.getProduct_id().equals(itemProduct_id)){
//	      //  if(itemProduct_id.equals(product.getProduct_id())){
//	     	   itemCart.setCartItem_id(itemCart.getCartItem_id());
//	     	   itemCart.setCart_id(itemCart.getCart_id());
//	     	   itemCart.setCustomerId(id);
//	     	   itemCart.setProduct_id(itemProduct_id);
//	     	   itemCart.setQuantity(itemCart.getQuantity()+1);
//	     	   itemCart.setTotalPrice(itemCart.getTotalPrice()+product.getUnit_price());
//	     	   cartItemDao.saveOrUpdate(itemCart);
//	     	   return "redirect:/productShow/{product_id}";
//	        }
//	        
//	        }
//		return null;
//	}
//
////=================================================	view cart====================================
//	
//	@RequestMapping("/cart")
//	public ModelAndView viewCart(Model model, Principal userName,
//			@RequestParam(value = "cartItemRemoved", required = false) String cartItemRemoved)
//
//	{
//		ModelAndView mv = new ModelAndView("index");
//		String customerName = userName.getName();
//		if (cartItemRemoved != null) {
//			model.addAttribute("cartItemRemoved", "Cart item removed successfully");
//		}
//
//		customer = customerDao.getCustomerByUserName(customerName);
//		String customerId = customer.getCustomerId();
//
//		List<CartItemModel> cartItems = null;
//
//		// When there are products in cart
//		if (returnProductName(customerId) != null && !returnProductName(customerId).isEmpty()) {
//			cartItems = returnProductName(customerId);
//
//			mv.addObject("cartItems", cartItems);
//			double grandTotal = cartDao.getCartByCustomerId(customerId).getGrandTotal();
//			mv.addObject("grandTotal", grandTotal);
//
//		
//
//		}
//		// When there are no products in cart
//		else {
//			model.addAttribute("cartEmpty", "No items present in the cart");
//
//			mv.addObject("noOfProducts", 0);
//		}
//		mv.addObject("isCartClicked", true);
//		
//		mv.addObject("active", "cart");
//
//		return mv;
//	}
//	// Method to get name of product
//	public List<CartItemModel> returnProductName(String customerId) {
//
//		List<CartItem> cartItems = cartItemDao.getCartItemsByCustomerId(customerId);
//
//		List<CartItemModel> cartItemModelList = new ArrayList<>();
//
//		CartItemModel cartItemModel = null;
//
//		for (CartItem item : cartItems) {
//			cartItemModel = new CartItemModel();
//			cartItemModel.setCartItem(item);
//			if (item.getProduct_id() != null && !item.getProduct_id().isEmpty()) {
//				product = productDao.get(item.getProduct_id());
//				cartItemModel.setProductName(product.getProduct_name());
//			} else {
//				cartItemModel.setProductName("Currently not avilable");
//			}
//			cartItemModelList.add(cartItemModel);
//		}
//		return cartItemModelList;
//	}
//
//}
