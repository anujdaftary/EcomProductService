package com.springboot.ecomproductservice.Services;

import com.springboot.ecomproductservice.Dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    public GenericProductDto getProductById(Long id);

    GenericProductDto createProduct(GenericProductDto product);

    public List<GenericProductDto> getAllProducts();


}
