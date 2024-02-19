package com.springboot.ecomproductservice.Services;

import com.springboot.ecomproductservice.Dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
     GenericProductDto getProductById(Long id);

    GenericProductDto createProduct(GenericProductDto product);

     List<GenericProductDto> getAllProducts();

     GenericProductDto deleteProduct(Long id);


}
