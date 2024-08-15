package com.springboot.ecomproductservice.Dtos;

import com.springboot.ecomproductservice.Models.Price;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String title;
    private String description;
    private String image;
    private Price price;

}
