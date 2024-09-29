package com.website.demojob.Controller;

import com.website.demojob.model.Product;
import com.website.demojob.model.ProductDetelForm;
import com.website.demojob.repository.ProductRepository;
import com.website.demojob.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/products/filter")
public class ProductDeltelController {

    @Autowired
    private ProductService productService;

    @GetMapping("/deltel/{IDProduct}")
    public ResponseEntity<?> getById(@PathVariable int IDProduct) {
        Product product = productService.getProductById(IDProduct);
        if (product == null) {
            return ResponseEntity.badRequest().body("Mã sản phẩm không hợp lệ");
        }
        LocalDateTime offertime = product.getOffertime();
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, offertime);

        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        String timeDifference = String.format("%d ngày %d giờ %d phút %d giây",
                days, hours, minutes, seconds);

        ProductDetelForm response = new ProductDetelForm(product, timeDifference);

        return ResponseEntity.ok(response);
    }
}
