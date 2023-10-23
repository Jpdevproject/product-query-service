package com.jp.info.productqueryservice.controller;

import com.jp.info.productqueryservice.entity.Product;
import com.jp.info.productqueryservice.service.ProductQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    @Autowired
    private ProductQueryService service;
    @GetMapping("/all")
    public List<Product> getAllProducts(){
       return service.fetchAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable Long productId){
        return service.fetchProduct(productId);
    }
}
