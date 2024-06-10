package com.ads.adsback.service.impl;


import com.ads.adsback.model.entites.Product;
import com.ads.adsback.repository.IGenericRepository;
import com.ads.adsback.repository.IProductRepository;
import com.ads.adsback.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends CRUDImpl<Product,Integer> implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    IGenericRepository<Product, Integer> getRepo() {
        return productRepository;
    }
}
