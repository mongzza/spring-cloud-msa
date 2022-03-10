package com.dami.orderservice.jpa.repository;

import com.dami.orderservice.jpa.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    
    Optional<OrderEntity> findByOrderId(String orderId);
    
    List<OrderEntity> findAllByUserId(String userId);
}
