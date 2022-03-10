package com.dami.orderservice.jpa.entity;

import com.dami.orderservice.model.dto.OrderDto;
import com.dami.orderservice.util.ModelMapperUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "Orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String orderId;
    
    @Column(nullable = false, length = 120, unique = true)
    private String productId;
    
    @Column(nullable = false)
    private String quantity;
    
    @Column(nullable = false)
    private Integer unitPrice;
    
    @Column(nullable = false)
    private Integer totalPrice;
    
    @Column(nullable = false)
    private String userId;
    
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    protected OrderEntity() {
        super();
    }
    
    public static OrderEntity from(OrderDto orderDto) {
        return ModelMapperUtils.map(orderDto, OrderEntity.class);
    }
}
