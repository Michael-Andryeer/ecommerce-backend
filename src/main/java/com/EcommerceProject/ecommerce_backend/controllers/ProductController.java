package com.EcommerceProject.ecommerce_backend.controllers;
import com.EcommerceProject.ecommerce_backend.dto.ProductDTO;
import com.EcommerceProject.ecommerce_backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products") //Rota
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public Page<ProductDTO> findAll(@PageableDefault(size = 12,sort = "name")Pageable pageable) {
        return service.findAll(pageable);
    }
}
