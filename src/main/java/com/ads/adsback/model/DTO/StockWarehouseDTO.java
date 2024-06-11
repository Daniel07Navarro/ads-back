package com.ads.adsback.model.DTO;

import com.ads.adsback.model.entites.StockWarehouseDetail;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockWarehouseDTO {

    private Integer idStockWarehouse;

    @JsonManagedReference
    private List<StockWarehouseDetail> details;

    private short total;

}
