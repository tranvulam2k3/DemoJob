package com.website.demojob.model;

public class ProductDetelForm {
    private Product product;
    private String timeDifference;

    public ProductDetelForm(Product product, String timeDifference) {
        this.product = product;
        this.timeDifference = timeDifference;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getTimeDifference() {
        return timeDifference;
    }

    public void setTimeDifference(String timeDifference) {
        this.timeDifference = timeDifference;
    }
}
