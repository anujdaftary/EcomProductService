package com.springboot.ecomproductservice.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String title;
    private String description;
    private String image;
    private double price;
    private Category category;

}
