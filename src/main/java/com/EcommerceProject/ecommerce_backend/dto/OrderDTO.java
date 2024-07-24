package com.EcommerceProject.ecommerce_backend.dto;

import com.EcommerceProject.ecommerce_backend.entities.Order;
import com.EcommerceProject.ecommerce_backend.entities.OrderItem;
import com.EcommerceProject.ecommerce_backend.entities.OrderStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;
    private ClientDTO client;
    private PaymentDTO payment;
    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }

    public OrderDTO(Order entity) {
        id = entity.getId();
        moment = entity.getMoment();
        status = entity.getStatus();
        client = new ClientDTO(entity.getClient());
        payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment()); //O pagamento pode ser nulo por isso fiz esse tratamento com ternarios
        for (OrderItem item : entity.getItems()){
            OrderItemDTO itemDto = new OrderItemDTO(item);
            items.add(itemDto);
        }
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public Double getTotal(){
        double soma = 0.0;
        for(OrderItemDTO item : items) {
            soma += item.getSubTotal();
        }
        return soma;
    }
}
