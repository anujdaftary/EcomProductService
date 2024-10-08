package com.springboot.ecomproductservice.Controllers;

import com.springboot.ecomproductservice.Dtos.GenericProductDto;
import com.springboot.ecomproductservice.Services.ProductService;
import com.springboot.ecomproductservice.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();

    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return productService.getProductById(id);
    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
      return productService.createProduct(product);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                productService.deleteProductById(id),
                HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public GenericProductDto updateProduct(@PathVariable("id") Long id,
                                               @RequestBody GenericProductDto productDto){
        return productService.updateProduct(productDto,id);
    }
}

