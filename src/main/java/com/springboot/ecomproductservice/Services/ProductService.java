package com.springboot.ecomproductservice.Services;

import com.springboot.ecomproductservice.Dtos.GenericProductDto;
import com.springboot.ecomproductservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
     GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto product);

     List<GenericProductDto> getAllProducts();

     GenericProductDto deleteProduct(Long id);


}
