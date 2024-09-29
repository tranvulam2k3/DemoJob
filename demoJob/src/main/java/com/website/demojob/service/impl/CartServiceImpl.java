package com.website.demojob.service.impl;

import com.website.demojob.Exception.ProductNotFoundException;
import com.website.demojob.model.Cart;
import com.website.demojob.model.Product;
import com.website.demojob.repository.CartReponsitory;
import com.website.demojob.repository.ProductRepository;
import com.website.demojob.service.CartSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartSevice {

    @Autowired
     CartReponsitory cartReponsitory;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProductToCart(int productId, String color, String size, int quantity) {
        Product product = productRepository.checkProduct(productId, color, size);
        Cart cart = cartReponsitory.checkProductByCart(productId, color, size);

        if(product == null) {
            throw new ProductNotFoundException("Sản phẩm tạm thời không tồn tại");
        } else if (cart != null && product.getIDProduct() == cart.getIDProduct()
                && product.getColor().equals(cart.getColor())
                && product.getSize().equals(cart.getSize())) {
            int quantityFromCart = cart.getQuantity()+quantity;
            cartReponsitory.updateQuantilyByCart(productId,quantityFromCart);
        }else {
            cartReponsitory.addCartByIdproduct(productId, color, size, quantity);
        }
    }

    @Override
    public List<Cart> getAllCart() {
        return cartReponsitory.getAllProductByCart();
    }

}
