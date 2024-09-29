package com.website.demojob.Controller;

import com.website.demojob.Exception.ProductNotFoundException;
import com.website.demojob.model.Cart;
import com.website.demojob.repository.CartReponsitory;
import com.website.demojob.service.CartSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartSevice cartSevice;

    @PostMapping("/add")
    public ResponseEntity<?> addProductToCart(@RequestParam int IDProduct,
                                              @RequestParam String Color,
                                              @RequestParam String Size,
                                              @RequestParam int quantity) {
        try {
            cartSevice.addProductToCart(IDProduct, Color, Size, quantity);
            return ResponseEntity.ok("Product added to cart successfully.");
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping()
    public List<Cart> getCart() {
        return cartSevice.getAllCart();
    }
}
