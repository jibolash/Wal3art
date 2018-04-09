package com.mayowasogbein.android.walmart.models;

public class Product {
    private String Title;
    private double price;
    private String color;
    private String image;
    private String itemid;
    private String desc;

    public Product(String title, double price, String color, String image, String itemid, String desc) {
        Title = title;
        this.price = price;
        this.color = color;
        this.image = image;
        this.itemid = itemid;
        this.desc = desc;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
