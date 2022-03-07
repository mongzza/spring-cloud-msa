package com.dami.catalogservice.model.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class CatalogDto implements Serializable {
    private String productId;
    private String productName;
    private Integer stock;
    private Integer unitPrice;
    private Integer totalPrice;
    
    private String orderId;
    private String userId;
}
