package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitys.Categoria;

public interface categoriaRepository extends JpaRepository<Categoria, Long> {

}
