package com.ads.adsback.model.entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WarehouseStockReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idWarehouseStockReport;

    private LocalDateTime dateGenerated;

    @ManyToOne
    @JoinColumn(name = "id_stock_warehouse")
    private StockWarehouse stockWarehouse;

    @Column(length = 100)
    private String description;

}
