package com.ads.adsback.model.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StockWarehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idStockWarehouse;

    @OneToMany(mappedBy = "stockWarehouse",cascade = CascadeType.ALL)
    private List<StockWarehouseDetail> details;

    private short total;
}
