package com.dami.orderservice.model.response;

import com.dami.orderservice.util.ModelMapperUtils;
import com.dami.orderservice.model.dto.OrderDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseOrder {
    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;
    private LocalDateTime createdAt;
    
    private String orderId;
    
    public static ResponseOrder from(OrderDto orderDto) {
        return ModelMapperUtils.map(orderDto, ResponseOrder.class);
    }
}
