package com.ads.adsback.model.entites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StockWarehouseDetail {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStockWarehouseDetail;

    @ManyToOne
    @JoinColumn(name = "id_stock_warehouse")
    private StockWarehouse stockWarehouse;

    @ManyToOne
    @JoinColumn(name="id_product")
    private Product product;

    private short quantity;

}
