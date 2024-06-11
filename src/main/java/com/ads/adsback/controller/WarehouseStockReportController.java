package com.ads.adsback.controller;

import com.ads.adsback.model.DTO.WarehouseStockReportDTO;
import com.ads.adsback.model.entites.WarehouseStockReport;
import com.ads.adsback.service.IWarehouseStockReportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warehouseStockReport")
public class WarehouseStockReportController {

    @Autowired
    private IWarehouseStockReportService warehouseStockReportService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/save")
    private ResponseEntity<WarehouseStockReportDTO> save(WarehouseStockReportDTO warehouseStockReportDTO) throws Exception{
        WarehouseStockReport warehouseStockReport = warehouseStockReportService.save(modelMapper.map(warehouseStockReportDTO,WarehouseStockReport.class));
        return new ResponseEntity<>(modelMapper.map(warehouseStockReport,WarehouseStockReportDTO.class), HttpStatus.CREATED);
    }

}
