package com.scaler.myfirstapi.Service;

import com.scaler.myfirstapi.Dto.FackStoreProductDto;
import com.scaler.myfirstapi.Modle.Category;
import com.scaler.myfirstapi.Modle.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FackStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    public FackStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
private Product convertFackStoreProductToProduct(FackStoreProductDto dto){
        Product product = new Product();
    product.setId(dto.getId());
    product.setTitle(dto.getTitle());
    product.setPrice(dto.getPrice());
    product.setDescription(dto.getDescription());
    product.setImage(dto.getImage());

    Category category = new Category();
    category.setDesc(dto.getCategory());
    product.setCategory(category);

    return product;

 }
    @Override
    public Product getProductById(Long id) {
        try {

            FackStoreProductDto fakeStoreProductDto =
                    restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                            FackStoreProductDto.class);


            if (fakeStoreProductDto == null) {
                return null;
            }

            //Convert FakeStore DTO into Product object.
            return convertFackStoreProductToProduct(fakeStoreProductDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
