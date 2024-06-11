package com.ads.adsback.model.DTO;

import com.ads.adsback.model.entites.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class StockWarehouseDetailDTO {

    private Integer idStockWarehouseDetail;

    @JsonBackReference
    private StockWarehouseDTO stockWarehouse;

    private ProductDTO product;

    private short quantity;



}
