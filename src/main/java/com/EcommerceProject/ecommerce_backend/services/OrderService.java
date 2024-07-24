package com.EcommerceProject.ecommerce_backend.services;

import com.EcommerceProject.ecommerce_backend.dto.OrderDTO;
import com.EcommerceProject.ecommerce_backend.dto.OrderItemDTO;
import com.EcommerceProject.ecommerce_backend.dto.ProductDTO;
import com.EcommerceProject.ecommerce_backend.entities.*;
import com.EcommerceProject.ecommerce_backend.repositories.OrderItemRepository;
import com.EcommerceProject.ecommerce_backend.repositories.OrderRepository;
import com.EcommerceProject.ecommerce_backend.repositories.ProductRepository;
import com.EcommerceProject.ecommerce_backend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true) //gerenciar transações de banco de dados de maneira declarativa.
    public OrderDTO findById(Long id) { //Me retorna um ProductDTO através de um Id
        Order order = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Não encontrado!")); //Busco no banco de dados o Produto com o Id de argumento,com tratamento de exceção
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        User user = userService.authenticated();
        order.setClient(user);

        for (OrderItemDTO itemDto : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId()); // Pega o Id do produto e instancia uma referencia a partir do Id
            OrderItem item = new OrderItem(order,product,itemDto.getQuantity(),product.getPrice());
            order.getItems().add(item);
        }
        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
