package com.commerce.e_commerce.repository;
import model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends
        JpaRepository<Cliente, Integer> {
}
