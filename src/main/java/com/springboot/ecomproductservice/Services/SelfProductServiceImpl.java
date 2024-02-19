package com.springboot.ecomproductservice.Services;

import com.springboot.ecomproductservice.Dtos.GenericProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductserviceImpl")
public class SelfProductServiceImpl implements ProductService{

    @Override
    public List<GenericProductDto> getAllProducts() {

        return null;
    }

    @Override
    public GenericProductDto getProductById(Long id) {

        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
}
