package com.ads.adsback.repository;

import com.ads.adsback.model.entites.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends IGenericRepository<Product,Integer>{
}
