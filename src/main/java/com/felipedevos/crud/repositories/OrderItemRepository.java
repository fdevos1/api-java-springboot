package com.felipedevos.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipedevos.crud.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
