package com.jp.info.productqueryservice.dto;

import com.jp.info.productqueryservice.entity.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEvent {
    private String eventType;
    private Product product;
}
