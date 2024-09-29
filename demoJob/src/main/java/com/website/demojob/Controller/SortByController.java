package com.website.demojob.Controller;

import com.website.demojob.model.Product;
import com.website.demojob.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/products/filter")
public class SortByController {

    @Autowired
    private ProductService productService;

    String errorMessage = "Vui lòng chạy List Product trước khi sort";

    @GetMapping("/sortbynameASC")
    public ResponseEntity<?> sortProductsByNameASC(HttpSession session) {
        List<Product> products = (List<Product>) session.getAttribute("products");
        if (products != null && !products.isEmpty()) {
            List<Product> modifiableProducts = new ArrayList<>(products);
            modifiableProducts.sort(Comparator.comparing(Product::getProductname));
            return ResponseEntity.ok(modifiableProducts);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @GetMapping("/sortbynameDESC")
    public ResponseEntity<?> sortProductsByNameDESC(HttpSession session) {
        List<Product> products = (List<Product>) session.getAttribute("products");
        if (products != null && !products.isEmpty()) {
            List<Product> modifiableProducts = new ArrayList<>(products);
            modifiableProducts.sort(Comparator.comparing(Product::getProductname).reversed());
            return ResponseEntity.ok(modifiableProducts);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @GetMapping("/sortbypriceASC")
    public ResponseEntity<?> sortProductsBySpecialpriceASC(HttpSession session) {
        List<Product> products = (List<Product>) session.getAttribute("products");
        if (products != null) {
            List<Product> modifiableProducts = new ArrayList<>(products);
            modifiableProducts.sort(Comparator.comparing(Product::getSpecialprice));
            return ResponseEntity.ok(modifiableProducts);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @GetMapping("/sortbypriceDESC")
    public ResponseEntity<?> sortProductsBySpecialpriceDESC(HttpSession session) {
        List<Product> products = (List<Product>) session.getAttribute("products");
        if (products != null) {
            List<Product> modifiableProducts = new ArrayList<>(products);
            modifiableProducts.sort(Comparator.comparing(Product::getSpecialprice).reversed());
            return ResponseEntity.ok(modifiableProducts);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @GetMapping("/sortnewproduct")
    public ResponseEntity<?> sortnewProducts(HttpSession session) {
        List<Product> products = (List<Product>) session.getAttribute("products");
        if (products != null) {
            List<Product> modifiableProducts = new ArrayList<>(products);
            modifiableProducts.sort(Comparator.comparing(Product::getIDProduct).reversed());
            return ResponseEntity.ok(modifiableProducts);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @GetMapping("/sortoldproduct")
    public ResponseEntity<?> sortoldProducts(HttpSession session) {
        List<Product> products = (List<Product>) session.getAttribute("products");
        if (products != null) {
            List<Product> modifiableProducts = new ArrayList<>(products);
            modifiableProducts.sort(Comparator.comparing(Product::getIDProduct));
            return ResponseEntity.ok(modifiableProducts);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}
