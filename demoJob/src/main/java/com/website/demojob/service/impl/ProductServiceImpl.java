package com.website.demojob.service.impl;

import com.website.demojob.model.Product;
import com.website.demojob.repository.ProductRepository;
import com.website.demojob.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductById(int IDProduct) {
        return productRepository.findProductByID(IDProduct);
    }

    @Override
    public Page<Product> filterProducts(Integer TypeID, String Color, String Size, BigDecimal minPrice, BigDecimal maxPrice, Integer StyleID, int page, int size) {
        return productRepository.findFilteredProducts(TypeID, Color, Size, minPrice, maxPrice, StyleID, PageRequest.of(page, size));
    }


}


