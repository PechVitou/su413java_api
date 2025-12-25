package com.setec.entities;

import org.springframework.web.multipart.MultipartFile;

public class PostProductDAO {
	private String name;
	private double price;
	private int qty;
	private MultipartFile file;
	
    public PostProductDAO() {
    }

    // All-args constructor
    public PostProductDAO(String name, double price, int qty, MultipartFile file) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.file = file;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
