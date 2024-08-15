//package com.springboot.ecomproductservice.Services;
//
//import com.springboot.ecomproductservice.Dtos.GenericProductDto;
//import com.springboot.ecomproductservice.Repositories.ProductRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
////@Service("SelfProductserviceImpl")
//public class SelfProductServiceImpl implements ProductService{
//     private ProductRepository productRepository;
//     public SelfProductServiceImpl(ProductRepository productRepository){
//         this.productRepository = productRepository;
//     }
//    @Override
//   public List<GenericProductDto> getAllProducts() {
//
//        return null;// productRepository.findAllProducts();
//    }
//
//    @Override
//    public GenericProductDto getProductById(UUID uuid) {
//
//        return productRepository.findProductById(uuid);
//    }
//
//    @Override
//    public GenericProductDto createProduct(GenericProductDto product) {
//        return null;
//    }
//
//    @Override
//    public GenericProductDto deleteProductById(Long id) {
//
//        return null;
//    }
//    @Override
//    public GenericProductDto updateProduct(GenericProductDto productDto,Long id) {
//        return null;
//    }
//
//}
