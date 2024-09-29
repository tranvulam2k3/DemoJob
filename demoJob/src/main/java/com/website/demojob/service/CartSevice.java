package com.website.demojob.service;

import com.website.demojob.model.Cart;

import java.util.List;

public interface CartSevice {
     void addProductToCart(int productId, String color, String size, int quantity);

     List<Cart> getAllCart();
}
