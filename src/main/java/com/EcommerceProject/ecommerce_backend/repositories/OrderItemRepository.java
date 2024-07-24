package com.EcommerceProject.ecommerce_backend.repositories;

import com.EcommerceProject.ecommerce_backend.entities.Order;
import com.EcommerceProject.ecommerce_backend.entities.OrderItem;
import com.EcommerceProject.ecommerce_backend.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}