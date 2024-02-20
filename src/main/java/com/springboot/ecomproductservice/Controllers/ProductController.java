package com.springboot.ecomproductservice.Controllers;

import com.springboot.ecomproductservice.Dtos.ExceptionDto;
import com.springboot.ecomproductservice.Dtos.GenericProductDto;
import com.springboot.ecomproductservice.Services.ProductService;
import com.springboot.ecomproductservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return productService.getProductById(id);
    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
      return productService.createProduct(product);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
}
@ExceptionHandler(NotFoundException.class)
private ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException){
        return new ResponseEntity(new ExceptionDto(HttpStatus.NOT_FOUND,notFoundException.getMessage()),
                    HttpStatus.NOT_FOUND);

    }
}
