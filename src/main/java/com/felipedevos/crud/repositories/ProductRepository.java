package com.felipedevos.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipedevos.crud.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
