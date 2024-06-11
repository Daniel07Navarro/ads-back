package com.ads.adsback.controller;

import com.ads.adsback.model.DTO.ProductDTO;
import com.ads.adsback.model.entites.Product;
import com.ads.adsback.repository.IProductRepository;
import com.ads.adsback.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() throws Exception{
        List<ProductDTO> products = productService.findAll()
                .stream()
                .map(p -> modelMapper.map(p,ProductDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) throws Exception{
        Product product = productService.save(modelMapper.map(productDTO,Product.class));
        return new ResponseEntity<>(modelMapper.map(product,ProductDTO.class),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete") //EJEMPLO: localhost:8080/api/products/delete?idProduct=1
    public ResponseEntity<Void> delete(@RequestParam("idProduct") Integer idProduct) throws Exception{
        productService.deleteById(idProduct);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
