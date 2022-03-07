package com.dami.catalogservice.model.response;

import com.dami.catalogservice.model.dto.CatalogDto;
import com.dami.catalogservice.util.ModelMapperUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCatalog {
    private String productId;
    private String productName;
    private Integer unitPrice;
    private Integer stock;
    private LocalDateTime createdAt;
    
    public static ResponseCatalog from(CatalogDto catalogDto) {
        return ModelMapperUtils.map(catalogDto, ResponseCatalog.class);
    }
}
