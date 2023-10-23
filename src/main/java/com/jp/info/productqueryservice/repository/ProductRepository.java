package com.jp.info.productqueryservice.repository;

import com.jp.info.productqueryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
