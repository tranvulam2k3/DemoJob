package com.website.demojob.Controller;

import com.website.demojob.model.BillForm;
import com.website.demojob.model.Product;
import com.website.demojob.model.ProductDetelForm;
import com.website.demojob.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/products/")
public class BuyNowController {

    @Autowired
    private ProductService productService;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @GetMapping("/pay/{IDProduct}")
    public ResponseEntity<?> pay(@PathVariable int IDProduct,
                                 @RequestParam(value = "quantity", required = false) Integer quantity) {
        if (quantity == null) {
            return ResponseEntity.badRequest().body("Vui lòng chọn quantity");
        } else if (quantity <= 0) {
            return ResponseEntity.badRequest().body("Số lượng phải lớn hơn 0");
        } else {
            Product product = productService.getProductById(IDProduct);
            if (product == null) {
                return ResponseEntity.badRequest().body("Mã sản phẩm không hợp lệ");
            }
            LocalDateTime offertime = product.getOffertime();
            LocalDateTime now = LocalDateTime.now();
            String formattedOrderTime = now.format(formatter);

            Duration duration = Duration.between(now, offertime);

            if (duration.isNegative()) {
                BigDecimal mout = product.getOriginalprice().multiply(BigDecimal.valueOf(quantity));
                BillForm billForm = new BillForm(product, quantity, mout, formattedOrderTime);

                return ResponseEntity.ok(billForm);
            } else {
                BigDecimal mout = product.getSpecialprice().multiply(BigDecimal.valueOf(quantity));
                BillForm billForm = new BillForm(product, quantity, mout, formattedOrderTime);
                return ResponseEntity.ok(billForm);
            }
        }
    }
}
