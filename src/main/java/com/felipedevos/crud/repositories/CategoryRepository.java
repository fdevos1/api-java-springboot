package com.felipedevos.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipedevos.crud.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
