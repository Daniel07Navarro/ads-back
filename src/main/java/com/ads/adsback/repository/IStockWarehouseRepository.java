package com.ads.adsback.repository;

import com.ads.adsback.model.entites.StockWarehouse;
import com.ads.adsback.model.entites.WarehouseStockReport;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockWarehouseRepository extends IGenericRepository<StockWarehouse,Integer>{
}
