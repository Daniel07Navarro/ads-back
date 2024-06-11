package com.ads.adsback.model.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class WarehouseStockReportDTO {

    private Integer idWarehouseStockReport;

    private LocalDateTime dateGenerated;

    @JsonManagedReference
    private List<StockWarehouseDetailDTO> details;

    @Size(min = 5,max = 100)
    private String description;

}
