package com.niit.viewModel;

import com.niit.model.CartItem;

public class CartItemModel {
private String productName;
private CartItem cartItem;
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public CartItem getCartItem() {
	return cartItem;
}
public void setCartItem(CartItem cartItem) {
	this.cartItem = cartItem;
}
}
