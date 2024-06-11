package com.ads.adsback.service.impl;


import com.ads.adsback.model.entites.WarehouseStockReport;
import com.ads.adsback.repository.IGenericRepository;
import com.ads.adsback.repository.IProductRepository;
import com.ads.adsback.repository.IWarehouseStockReportRepository;
import com.ads.adsback.service.IWarehouseStockReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseStockReportServiceImpl extends CRUDImpl<WarehouseStockReport,Integer> implements IWarehouseStockReportService {

    @Autowired
    private IWarehouseStockReportRepository warehouseStockReportRepository;

    @Autowired
    private IProductRepository productRepository;

    @Override
    IGenericRepository<WarehouseStockReport, Integer> getRepo() {
        return warehouseStockReportRepository;
    }
}
