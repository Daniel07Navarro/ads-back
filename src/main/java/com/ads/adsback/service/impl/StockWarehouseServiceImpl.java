package com.ads.adsback.service.impl;


import com.ads.adsback.model.entites.StockWarehouse;
import com.ads.adsback.repository.IGenericRepository;
import com.ads.adsback.repository.IProductRepository;
import com.ads.adsback.repository.IStockWarehouseRepository;
import com.ads.adsback.service.IStockWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockWarehouseServiceImpl extends CRUDImpl<StockWarehouse,Integer> implements IStockWarehouseService {

    @Autowired
    private IStockWarehouseRepository stockWarehouseRepository;

    @Autowired
    private IProductRepository productRepository;

    @Override
    IGenericRepository<StockWarehouse, Integer> getRepo() {
        return stockWarehouseRepository;
    }
}
