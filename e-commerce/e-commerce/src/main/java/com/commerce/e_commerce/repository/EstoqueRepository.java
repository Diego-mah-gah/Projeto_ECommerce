package com.commerce.e_commerce.repository;
import model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends
        JpaRepository<Estoque, Integer> {
}