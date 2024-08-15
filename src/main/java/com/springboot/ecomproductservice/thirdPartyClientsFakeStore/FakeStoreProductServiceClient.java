package com.springboot.ecomproductservice.thirdPartyClientsFakeStore;

import com.springboot.ecomproductservice.Dtos.GenericProductDto;
import com.springboot.ecomproductservice.exceptions.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductServiceClient {
    private final RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    private String fakeStoreApiUrl;

    @Value("${fakestore.api.paths.product}")
    private String fakeStoreProductsApiPath;

    private String specificProductURL;
    private String productRequestsURl;

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder,
                                         @Value("${fakestore.api.url}") String fakeStoreApiUrl,
                                         @Value("${fakestore.api.paths.product}") String fakeStoreProductsApiPath) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.productRequestsURl = fakeStoreApiUrl + fakeStoreProductsApiPath;
        this.specificProductURL = fakeStoreApiUrl + fakeStoreProductsApiPath + "/{id}";
    }

    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(specificProductURL,
                FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        if (fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id: " + id + " doesn't exist.");
        }
        return fakeStoreProductDto;
    }

    public FakeStoreProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity
                (productRequestsURl, product, FakeStoreProductDto.class);
        return response.getBody();
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> response =
                restTemplate.getForEntity(productRequestsURl, FakeStoreProductDto[].class);

        List<GenericProductDto> answer = new ArrayList<>();

        return Arrays.stream(response.getBody()).toList();
    }

    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.
                acceptHeaderRequestCallback(FakeStoreProductDto.class);

        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.execute(specificProductURL, HttpMethod.DELETE,
                        requestCallback, responseExtractor, id);

        return response.getBody();
    }
    public FakeStoreProductDto updateProduct(GenericProductDto productDto, Long id) {
        RestTemplate restTemplate = new RestTemplate();

        RequestCallback requestCallback = restTemplate.httpEntityCallback(productDto, FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity =restTemplate.execute(specificProductURL, HttpMethod.PUT, requestCallback, responseExtractor, id);

        return responseEntity.getBody();
    }
}
