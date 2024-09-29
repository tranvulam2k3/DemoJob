package com.website.demojob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    private int IDProduct;
    private String Productname;
    private String Productimage;
    private BigDecimal Originalprice;
    private BigDecimal Specialprice;
    private String Introduction;
    private Integer TypeID;
    private String Color;
    private String Size;
    private LocalDateTime Offertime;
    private int StyleID;

    public int getIDProduct() {
        return IDProduct;
    }

    public void setIDProduct(int IDProduct) {
        this.IDProduct = IDProduct;
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

    public BigDecimal getOriginalprice() {
        return Originalprice;
    }

    public void setOriginalprice(BigDecimal originalprice) {
        Originalprice = originalprice;
    }

    public BigDecimal getSpecialprice() {
        return Specialprice;
    }

    public void setSpecialprice(BigDecimal specialprice) {
        Specialprice = specialprice;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public Integer getTypeID() {
        return TypeID;
    }

    public void setTypeID(Integer typeID) {
        TypeID = typeID;
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

    public LocalDateTime getOffertime() {
        return Offertime;
    }

    public void setOffertime(LocalDateTime offertime) {
        Offertime = offertime;
    }

    public int getStyleID() {
        return StyleID;
    }

    public void setStyleID(int styleID) {
        StyleID = styleID;
    }
}
