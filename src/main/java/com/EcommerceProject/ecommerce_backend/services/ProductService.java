package com.EcommerceProject.ecommerce_backend.services;

import com.EcommerceProject.ecommerce_backend.dto.ProductDTO;
import com.EcommerceProject.ecommerce_backend.entities.Product;
import com.EcommerceProject.ecommerce_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true) //gerenciar transações de banco de dados de maneira declarativa.
    public ProductDTO findById(Long id) { //Me retorna um ProductDTO através de um Id
        Product product = repository.findById(id).get(); //Busco no banco de dados o Produto com o Id de argumento
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> result = repository.findAll(pageable);
        return result.map(x ->new ProductDTO(x));
    }
}
