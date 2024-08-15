package com.springboot.ecomproductservice.Services;

import com.springboot.ecomproductservice.thirdPartyClientsFakeStore.FakeStoreProductDto;
import com.springboot.ecomproductservice.Dtos.GenericProductDto;
import com.springboot.ecomproductservice.exceptions.NotFoundException;
import com.springboot.ecomproductservice.thirdPartyClientsFakeStore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

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
    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }


    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
      return convertFakeStoreProductDtoIntoGenericProductDto(
              fakeStoreProductServiceClient.getProductById(id));

    }

    @Override
    public GenericProductDto getProductById(UUID uuid) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
      return convertFakeStoreProductDtoIntoGenericProductDto(
              fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
            List<GenericProductDto> genericProductDtos = new ArrayList<>();

            for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductServiceClient.getAllProducts()) {
                genericProductDtos.add(convertFakeStoreProductDtoIntoGenericProductDto(
                        fakeStoreProductDto));
            }
            return genericProductDtos;
    }

    public GenericProductDto deleteProductById(Long id){
    return convertFakeStoreProductDtoIntoGenericProductDto(fakeStoreProductServiceClient
            .deleteProductById(id));
    }
    public GenericProductDto updateProduct(GenericProductDto productDto,Long id) {
        return convertFakeStoreProductDtoIntoGenericProductDto(fakeStoreProductServiceClient.updateProduct(productDto, id));
    }
}

