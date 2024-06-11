package com.ads.adsback.repository;

import com.ads.adsback.model.entites.WarehouseStockReport;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface IWarehouseStockReportRepository extends IGenericRepository<WarehouseStockReport,Integer>{
}
