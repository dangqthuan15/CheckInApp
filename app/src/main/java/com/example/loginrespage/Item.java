package com.example.loginrespage;

import java.io.Serializable;

public class Item implements Serializable {

    private int image;
    private String name;
    private String nguyenlieu;
    private String price;

    public Item(int image, String name, String price, String nguyenlieu) {
        this.image = image;
        this.nguyenlieu = nguyenlieu;
        this.name = name;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNguyenlieu() {
        return nguyenlieu;
    }

    public void setNguyenlieu(String nguyenlieu) {
        this.nguyenlieu = nguyenlieu;
    }
}
