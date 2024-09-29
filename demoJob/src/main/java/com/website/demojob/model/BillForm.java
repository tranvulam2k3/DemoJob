package com.website.demojob.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class BillForm {
    private Product product;
    private int quantity;
    private BigDecimal totalAmount;
    private String orderTime;

    public BillForm() {
    }

    public BillForm(Product product, int quantity, BigDecimal totalAmount, String orderTime) {
        this.product = product;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.orderTime = orderTime;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
}
