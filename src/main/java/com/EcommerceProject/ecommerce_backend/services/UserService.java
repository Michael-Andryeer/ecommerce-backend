package com.EcommerceProject.ecommerce_backend.services;

import com.EcommerceProject.ecommerce_backend.dto.UserDTO;
import com.EcommerceProject.ecommerce_backend.entities.User;
import com.EcommerceProject.ecommerce_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Email não encontrado!");
        }
        return user;
    }

    protected User authenticated(){
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return repository.findByEmail(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("Usúario inválido!");
        }
    }

    @Transactional(readOnly = true) //Se comunica com o controlador logo tem que ter o Transactional
    public UserDTO getMe() {
        User entity = authenticated();
        return new UserDTO(entity);
    }
}
