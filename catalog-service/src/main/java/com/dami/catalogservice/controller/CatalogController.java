package com.dami.catalogservice.controller;

import com.dami.catalogservice.model.dto.CatalogDto;
import com.dami.catalogservice.model.response.ResponseCatalog;
import com.dami.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/catalog-service")
public class CatalogController {
    
    private final CatalogService catalogService;
    
    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalogs() {
        List<CatalogDto> catalogs = catalogService.getAllCatalogs();
        return ResponseEntity.ok(catalogs.stream()
                                         .map(ResponseCatalog::from)
                                         .collect(Collectors.toList()));
    }
}
