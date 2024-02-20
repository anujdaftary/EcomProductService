package com.springboot.ecomproductservice.Services;

import com.springboot.ecomproductservice.Dtos.FakeStoreProductDto;
import com.springboot.ecomproductservice.Dtos.GenericProductDto;
import com.springboot.ecomproductservice.exceptions.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private String specificProductURL = "https://fakestoreapi.com/products/{id}";
    private String ProductRequestURL = "https://fakestoreapi.com/products";

    private GenericProductDto convertFakeStoreProductDtoIntoGenericProductDto(
            FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto product = new GenericProductDto();

        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setPrice(fakeStoreProductDto.getPrice());

        return product;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.getForEntity(specificProductURL, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if (fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id:" + id + " doesn`t exists");
        }
        return convertFakeStoreProductDtoIntoGenericProductDto(fakeStoreProductDto);

    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity
                (ProductRequestURL, product, GenericProductDto.class);
        return response.getBody();
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response =
                restTemplate.getForEntity(ProductRequestURL, FakeStoreProductDto[].class);
        List<GenericProductDto> answer = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto : response.getBody()) {
            answer.add(convertFakeStoreProductDtoIntoGenericProductDto(fakeStoreProductDto));
        }
        return answer;
    }

    public GenericProductDto deleteProduct(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.
                acceptHeaderRequestCallback(FakeStoreProductDto.class);

        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.execute(specificProductURL, HttpMethod.DELETE,
                requestCallback, responseExtractor, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return convertFakeStoreProductDtoIntoGenericProductDto(fakeStoreProductDto);
    }
}

