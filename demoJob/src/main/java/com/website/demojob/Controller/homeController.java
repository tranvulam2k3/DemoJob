package com.website.demojob.Controller;
import org.springframework.data.domain.Page;

import com.website.demojob.model.Product;
import com.website.demojob.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/api/products")
public class homeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filterProducts(
            @RequestParam(required = false) Integer TypeID,
            @RequestParam(required = false) String Color,
            @RequestParam(required = false) String Size,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) Integer StyleID,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,
            HttpSession session) {

        Page<Product> products = productService.filterProducts(TypeID, Color, Size, minPrice, maxPrice, StyleID, page, size);
        session.setAttribute("products", products.getContent());
        return ResponseEntity.ok(products.getContent());
    }
}
