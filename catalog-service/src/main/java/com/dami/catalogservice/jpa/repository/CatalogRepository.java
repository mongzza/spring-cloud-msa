package com.dami.catalogservice.jpa.repository;

import com.dami.catalogservice.jpa.entity.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatalogRepository extends JpaRepository<CatalogEntity, Long> {
    
    Optional<CatalogEntity> findByProductId(String productId);
}
