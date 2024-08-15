package com.springboot.ecomproductservice.Services;

import com.springboot.ecomproductservice.Dtos.GenericProductDto;
import com.springboot.ecomproductservice.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
     GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto getProductById(UUID uuid);

    GenericProductDto createProduct(GenericProductDto product);

     List<GenericProductDto> getAllProducts();

     GenericProductDto deleteProductById(Long id);
     GenericProductDto updateProduct(GenericProductDto productDto,Long id);



}
