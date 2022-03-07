package com.dami.userservice.model.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponseOrder {
    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;
    private LocalDateTime createdAt;
    
    private String orderId;
}
