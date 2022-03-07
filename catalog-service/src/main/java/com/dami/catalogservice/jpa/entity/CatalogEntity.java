package com.dami.catalogservice.jpa.entity;

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
@Table(name = "Catalogs")
public class CatalogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 120, unique = true)
    private String productId;
    
    @Column(nullable = false, length = 100)
    private String productName;
    
    @Column(nullable = false)
    private Integer stock;
    
    @Column(nullable = false)
    private Integer unitPrice;
    
    @CreatedDate
    @Column(nullable = false, updatable = false, insertable = false)
    private LocalDateTime createdAt;
}
