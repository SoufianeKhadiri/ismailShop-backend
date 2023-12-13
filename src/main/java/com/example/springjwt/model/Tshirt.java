package com.example.springjwt.model;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name="tshirt")
public class Tshirt  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private String brand;
    private String price;
    private String size;
    @ElementCollection
    private List<String> fotos;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Tshirt() {
    }

    public Tshirt(String name, String brand, String price, String size, List<String> fotos, String description) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.size = size;
         this.fotos = fotos;
        this.description = description;
    }
}



