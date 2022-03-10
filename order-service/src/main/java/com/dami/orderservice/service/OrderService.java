package com.dami.orderservice.service;

import com.dami.orderservice.jpa.entity.OrderEntity;
import com.dami.orderservice.jpa.repository.OrderRepository;
import com.dami.orderservice.model.dto.OrderDto;
import com.dami.orderservice.util.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    
    public OrderDto createOrder(OrderDto orderDto) {
        OrderEntity savedOrder = orderRepository.save(OrderEntity.from(orderDto));
        return OrderDto.from(savedOrder);
    }
    
    public OrderDto getOrderByOrderId(String orderId) {
        return orderRepository.findByOrderId(orderId)
                              .map(order -> ModelMapperUtils.map(order, OrderDto.class))
                              .orElseThrow();
    }
    
    public List<OrderDto> getOrdersByUserId(String userId) {
        return orderRepository.findAllByUserId(userId)
                              .stream()
                              .map(order -> ModelMapperUtils.map(order, OrderDto.class))
                              .collect(Collectors.toList());
    }
}
