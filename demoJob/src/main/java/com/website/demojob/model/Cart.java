package com.website.demojob.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDCart;
    private int IDProduct;
    private String Productname;
    private String Productimage;
    private BigDecimal Specialprice;
    private String Color;
    private String Size;
    private int Quantity;

    public Cart() {}

    public Cart(int IDCart, int IDProduct, String productname, String productimage, BigDecimal specialprice, String color, String size, int quantity) {
        this.IDCart = IDCart;
        this.IDProduct = IDProduct;
        Productname = productname;
        Productimage = productimage;
        Specialprice = specialprice;
        Color = color;
        Size = size;
        Quantity = quantity;
    }

    public int getIDProduct() {
        return IDProduct;
    }

    public void setIDProduct(int IDProduct) {
        this.IDProduct = IDProduct;
    }

    public int getIDCart() {
        return IDCart;
    }

    public void setIDCart(int IDCart) {
        this.IDCart = IDCart;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String productname) {
        Productname = productname;
    }

    public String getProductimage() {
        return Productimage;
    }

    public void setProductimage(String productimage) {
        Productimage = productimage;
    }

    public BigDecimal getSpecialprice() {
        return Specialprice;
    }

    public void setSpecialprice(BigDecimal specialprice) {
        Specialprice = specialprice;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
