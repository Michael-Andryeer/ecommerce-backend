package com.EcommerceProject.ecommerce_backend.repositories;

import com.EcommerceProject.ecommerce_backend.entities.Product;
import com.EcommerceProject.ecommerce_backend.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email); //Consulta  personalizada para encontrar o usúario pelo email
}