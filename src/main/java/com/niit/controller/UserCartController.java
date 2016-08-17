//package com.niit.controller;
//
//import java.security.Principal;
//import java.util.ArrayList;
//import java.util.List;
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
//public class UserCartController {
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
//	
//	private CartItem cartItem;
//	@Autowired
//	private CartDao cartDao;
//	@Autowired
//	private CartItemDao cartItemDao;
//	@Autowired
//	private Customer customer;
//	@Autowired
//	private CustomerDao customerDao;
////
////	@RequestMapping("/cart/addToCart/{product_id}")
////	public String addToCart(@PathVariable("product_id") String product_id, Model model, Principal userName) {
////
////		// System.out.println(name);
////
////		// 1.Get the customer id by its user name
////		String customerName = userName.getName();
////		customer = customerDao.getCustomerByUserName(customerName);
////		String customerId = customer.getCustomerId();
////
////		// 2.Check whether his cart is present in the cart table
////		// If cart is not present then make a cart for him
////
////		if ((cart = cartDao.getCartByCustomerId(customerId)) == null) {
////			cart = new Cart();
////			cart.setCustomerId(customerId);
////			cartDao.saveOrUpdate(cart);
////
////			// cartItem.setCartId(cart.getCartId());
////		}
////
////
////		String cartId = cart.getCart_id();
////
////		// 3.get the product price
////
////		product = productDao.get(product_id);
////
////		// If cart is present then go into the cartItem table and search for
////		// product
////		// this customer selected whether it exists or it is a new product.
////		// -------------
////		// passing the customerId and productId to a method name returnCartItem
////		// through a method
////
////		// if we get null means the product is not present
////
////		if (addCartItem(customerId, product_id,cartId, model) == null) {
////			cartItem = new CartItem();
////			cartItem.setCart_id(cartId);
////			cartItem.setCustomerId(customerId);
////			cartItem.setProduct_id(product.getProduct_id());
////			cartItem.setQuantity(1);
////			cartItem.setTotalPrice(product.getUnit_price());
////			cartItemDao.persist(cartItem);
////			
////			
////			System.out.println("Insertion of cartItem");
////			
////			
////			
////			int noOfProducts = updateCartAgain(cartId, customerId);
////			
////			
////			model.addAttribute("noOfProducts", noOfProducts);
////			
////			
////		}
////		// Now navigate to the same page
////		return "redirect:/productShow/{product_id}";
////		
////		
////	}
////
////	// This function will update the cart
////	public int updateCartAgain(String cartId, String customerId) {
////
////		List<CartItem> listOfSelectedCartItems;
////		// Now after getting the cartItem change grandTotal and No of Products
////		listOfSelectedCartItems = cartItemDao.getCartItemsByCustomerId(customerId);
////		double grandTotal = 0;
////		for (CartItem item : listOfSelectedCartItems) {
////			grandTotal = grandTotal + item.getTotalPrice();
////		}
////		cart.setGrandTotal(grandTotal);
////
////		int noOfProducts = listOfSelectedCartItems.size();
////
////		cart.setCart_id(cartId);
////		cart.setCustomerId(customerId);
////		cart.setNoOfproduct(noOfProducts);
////		cartDao.saveOrUpdate(cart); // This method updates the cart
////
////		return noOfProducts;
////		// =========== Completed Adding the item to cart =====
////
////	}
////
////	// This is the method which perform all the operations related to addition
////	// of product cartItem
////	public String addCartItem(String customerId, String product_id, String cartId, Model model) {
////		List<CartItem> listOfSelectedCartItems = cartItemDao.getCartItemsByCustomerId(customerId);
////		Product product = productDao.get(product_id);
////		for (CartItem item : listOfSelectedCartItems) {
////			String itemProductId = item.getProduct_id();
////			System.out.println(itemProductId);
////			if (itemProductId.equals(product.getProduct_id())) {
////				System.out.println(item.getCartItem_id());
////				item.setCartItem_id(item.getCartItem_id());
////
////				System.out.println(item.getQuantity());
////				item.setQuantity(item.getQuantity() + 1);
////
////				System.out.println(item.getTotalPrice());
////				item.setTotalPrice(item.getTotalPrice() + product.getUnit_price());
////
////				System.out.println(item.toString());
////				cartItemDao.saveOrUpdate(item);
////				int noOfProducts = updateCartAgain(cartId, customerId);
////				model.addAttribute("noOfProducts", noOfProducts);
////				return "redirect:/productShow/{product_id}";
////
////			}
////
////		}
////
////		return null;
////	}
//
//	// ===========================================viewcart=====================================================
//
////	@RequestMapping("/cart")
////	public ModelAndView Cart(Model model, Principal userName,
////			@RequestParam(value = "cartItemRemoved", required = false) String cartItemRemoved)
////
////	{
////		ModelAndView mv = new ModelAndView("index");
////		String customerName = userName.getName();
////		if (cartItemRemoved != null) {
////			model.addAttribute("cartItemRemoved", "Cart item removed successfully");
////		}
////
////		customer = customerDao.getCustomerByUserName(customerName);
////		String customerId = customer.getCustomerId();
////
////		List<CartItemModel> cartItems = null;
////
////		// When there are products in cart
////		if (returnProductName(customerId).size() > 0) {
////			cartItems = returnProductName(customerId);
////
////			
////			double grandTotal = cartDao.getCartByCustomerId(customerId).getGrandTotal();
////			
////			
////			mv.addObject("cartItems", cartItems);
////			mv.addObject("grandTotal", grandTotal);
////
////			mv.addObject("noOfProducts", cartItems.size());
////
////		}
////		// When there are no products in cart
////		else {
////			model.addAttribute("cartEmpty", "No items present in the cart");
////
////			mv.addObject("noOfProducts", 0);
////		}
////		// mv.addObject("isCartClicked", true);
////		mv.addObject("isCartClicked", "true");
////		mv.addObject("active", "cart");
////
////		return mv;
////	}
////
////	// Method to get name of product
////	public List<CartItemModel> returnProductName(String customerId) {
////
////		List<CartItem> cartItems = cartItemDao.getCartItemsByCustomerId(customerId);
////
////		List<CartItemModel> cartItemModelList = new ArrayList<>(cartItems.size());
////
////		CartItemModel cartItemModel = null;
////
////		for (CartItem item : cartItems) {
////			cartItemModel = new CartItemModel();
////			cartItemModel.setCartItem(item);
////			if (item.getProduct_id() != null && !item.getProduct_id().isEmpty()) {
////				product = productDao.get(item.getProduct_id());
////				cartItemModel.setProductName(product.getProduct_name());
////			} else {
////				cartItemModel.setProductName("Currently not avilable");
////			}
////			cartItemModelList.add(cartItemModel);
////		}
////		return cartItemModelList;
////	}
//
//	@RequestMapping("/cart/remove/{cartItem_id}")
//	public String removeCarItems(@PathVariable("cartItem_id") String cartItem_id, Model model) {
//		cartItem = cartItemDao.get(cartItem_id);
//		String customerId = cartItem.getCustomerId();
//		String cart_id = cartItem.getCart_id();
//		cartItemDao.delete(cartItem_id);
////		int noOfProducts = updateCartAgain(cart_id, customerId);
//	//	model.addAttribute("noOfProducts", noOfProducts);
//		return "redirect:/cart/?cartItemRemoved";
//	}
//}
