package com.dami.catalogservice.service;

import com.dami.catalogservice.jpa.entity.CatalogEntity;
import com.dami.catalogservice.jpa.repository.CatalogRepository;
import com.dami.catalogservice.model.dto.CatalogDto;
import com.dami.catalogservice.util.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Slf4j
@Service
public class CatalogService {
    
    private final CatalogRepository catalogRepository;
    
    public List<CatalogDto> getAllCatalogs() {
        return catalogRepository.findAll()
                                .stream()
                                .map(catalog -> ModelMapperUtils.map(catalog, CatalogDto.class))
                                .collect(toList());
    }
}
