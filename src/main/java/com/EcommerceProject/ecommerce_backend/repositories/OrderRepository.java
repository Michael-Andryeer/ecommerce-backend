package com.EcommerceProject.ecommerce_backend.repositories;

import com.EcommerceProject.ecommerce_backend.entities.Order;
import com.EcommerceProject.ecommerce_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}