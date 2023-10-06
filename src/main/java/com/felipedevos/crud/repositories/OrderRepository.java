package com.felipedevos.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipedevos.crud.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
