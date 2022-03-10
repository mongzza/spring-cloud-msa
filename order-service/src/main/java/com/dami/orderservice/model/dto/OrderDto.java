package com.dami.orderservice.model.dto;

import com.dami.orderservice.jpa.entity.OrderEntity;
import com.dami.orderservice.model.request.RequestOrder;
import com.dami.orderservice.util.ModelMapperUtils;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class OrderDto implements Serializable {
    private String productId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
    
    private String orderId;
    private String userId;
    
    public static OrderDto of(RequestOrder requestOrder, String userId) {
        OrderDto order = ModelMapperUtils.map(requestOrder, OrderDto.class);
        order.orderId = UUID.randomUUID().toString();
        order.userId = userId;
        order.totalPrice = requestOrder.getTotalPrice();
        return order;
    }
    
    public static OrderDto from(OrderEntity orderEntity) {
        return ModelMapperUtils.map(orderEntity, OrderDto.class);
    }
}
