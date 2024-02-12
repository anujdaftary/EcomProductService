package com.springboot.ecomproductservice.Controllers;

import com.springboot.ecomproductservice.Dtos.GenericProductDto;
import com.springboot.ecomproductservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService")  ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();

    }
    @GetMapping("/products/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){
     return productService.getProductById(id);
    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
      return productService.createProduct(product);
    }
}
