package com.dami.orderservice.model.request;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class RequestOrder {
    
    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    
    public BigDecimal getUnitPrice() {
        return BigDecimal.valueOf(unitPrice);
    }
    
    public BigDecimal getTotalPrice() {
        return BigDecimal.valueOf((long) unitPrice * quantity);
    }
}
