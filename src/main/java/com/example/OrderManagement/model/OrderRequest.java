package com.example.OrderManagement.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This is the model class to get order request json into Object.
 * */
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
public class OrderRequest {

    int productId;
    String item;
    long price;

    public OrderRequest(int productId, String item, long price) {
        this.productId = productId;
        this.item = item;
        this.price = price;
    }

    public OrderRequest() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "productId=" + productId +
                ", item='" + item + '\'' +
                ", price=" + price +
                '}';
    }
}
