package com.scaler.myfirstapi.Service;

import com.scaler.myfirstapi.Dto.FackStoreProductDto;
import com.scaler.myfirstapi.Expection.ProductNotFoundException;
import com.scaler.myfirstapi.Modle.Category;
import com.scaler.myfirstapi.Modle.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
    public Product getProductById(Long id) throws ProductNotFoundException {
        FackStoreProductDto fakeStoreProductDto =
                    restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                            FackStoreProductDto.class);
        if (fakeStoreProductDto == null) {
                throw new ProductNotFoundException("Product with id:"+id+" not found");
            }

            //Convert FakeStore DTO into Product object.
            return convertFackStoreProductToProduct(fakeStoreProductDto);

    }

    @Override
    public List<Product> getAllProducts() {
        FackStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FackStoreProductDto[].class);

        //convert List of FakeStoreProductDtos to List of Products
        List<Product> response = new ArrayList<>();
        for (FackStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            response.add(convertFackStoreProductToProduct(fakeStoreProductDto));
        }

        return response;
    }

    @Override
    public Product replaceProductById(Long id,Product product) {
        FackStoreProductDto fackStoreProductDto = new FackStoreProductDto();

        fackStoreProductDto.setTitle(product.getTitle());
        fackStoreProductDto.setPrice(product.getPrice());
        fackStoreProductDto.setDescription(product.getDescription());
        fackStoreProductDto.setImage(product.getImage());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fackStoreProductDto, FackStoreProductDto.class);
        HttpMessageConverterExtractor<FackStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FackStoreProductDto.class, restTemplate.getMessageConverters());
        FackStoreProductDto response=  restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
    return convertFackStoreProductToProduct(response);
    }
}
