package com.EcommerceProject.ecommerce_backend.services;

import com.EcommerceProject.ecommerce_backend.dto.OrderDTO;
import com.EcommerceProject.ecommerce_backend.dto.ProductDTO;
import com.EcommerceProject.ecommerce_backend.entities.Order;
import com.EcommerceProject.ecommerce_backend.entities.Product;
import com.EcommerceProject.ecommerce_backend.repositories.OrderRepository;
import com.EcommerceProject.ecommerce_backend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true) //gerenciar transações de banco de dados de maneira declarativa.
    public OrderDTO findById(Long id) { //Me retorna um ProductDTO através de um Id
        Order order = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Não encontrado!")); //Busco no banco de dados o Produto com o Id de argumento,com tratamento de exceção
        return new OrderDTO(order);
    }
}
