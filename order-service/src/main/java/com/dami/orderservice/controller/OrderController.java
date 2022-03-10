package com.dami.orderservice.controller;

import com.dami.orderservice.model.dto.OrderDto;
import com.dami.orderservice.model.request.RequestOrder;
import com.dami.orderservice.model.response.ResponseOrder;
import com.dami.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order-service")
public class OrderController {
    
    private final OrderService orderService;
    
    @PostMapping("/{userId}/orders")
    public ResponseEntity<ResponseOrder> createOrder(@PathVariable String userId,
                                                     @RequestBody RequestOrder order) {
        OrderDto result = orderService.createOrder(OrderDto.of(order, userId));
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(ResponseOrder.from(result));
    }
    
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<ResponseOrder> getOrder(@PathVariable String orderId) {
        OrderDto order = orderService.getOrderByOrderId(orderId);
        return ResponseEntity.ok(ResponseOrder.from(order));
    }
    
    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrders(@PathVariable String userId) {
        List<ResponseOrder> result = orderService.getOrdersByUserId(userId)
                                                 .stream()
                                                 .map(ResponseOrder::from)
                                                 .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
