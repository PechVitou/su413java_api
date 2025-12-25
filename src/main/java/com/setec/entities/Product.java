package com.setec.entities;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private int qty;
    @JsonIgnore
    private String imageUrl;

    // No-arg constructor
    public Product() {
    }

    // All-args constructor
    public Product(Integer id, String name, double price, int qty, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.imageUrl = imageUrl;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Custom method
    public String getFullImageUrl() {
    	return ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString()+imageUrl;
    }
    
    
    public double amount() {
        return price * qty;
    }
}
