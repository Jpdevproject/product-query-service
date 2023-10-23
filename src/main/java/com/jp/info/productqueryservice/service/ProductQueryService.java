package com.jp.info.productqueryservice.service;

import com.jp.info.productqueryservice.dto.ProductEvent;
import com.jp.info.productqueryservice.entity.Product;
import com.jp.info.productqueryservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductQueryService {

    @Autowired
    private ProductRepository repository;


    public List<Product> fetchAllProducts(){
        return repository.findAll();
    }

    public Product fetchProduct(Long productId){
        return repository.findById(productId).get();
    }
    @KafkaListener(topics="product-event-topic",groupId = "product-event-group")
    public void processEvent(ProductEvent productEvent){
        Product product = productEvent.getProduct();
        if (productEvent.getEventType().equalsIgnoreCase("CreateProductEvent")){
            repository.save(product);
        }else if(productEvent.getEventType().equalsIgnoreCase("UpdateProductEvent")){
            Product existingProduct= repository.findById(product.getId()).get();
            existingProduct=Product.builder()
                    .name(product.getName())
                    .price(product.getPrice())
                    .description(product.getDescription())
                    .build();
            repository.save(existingProduct);
        }

    }
}
