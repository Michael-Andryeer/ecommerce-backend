package com.EcommerceProject.ecommerce_backend.repositories;

import com.EcommerceProject.ecommerce_backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}