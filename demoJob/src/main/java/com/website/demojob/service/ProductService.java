package com.website.demojob.service;

import com.website.demojob.model.Product;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Product getProductById(int IDProduct);

    Page<Product> filterProducts(Integer TypeID, String Color, String Size, BigDecimal minPrice, BigDecimal maxPrice, Integer StyleID, int page, int size);

}
