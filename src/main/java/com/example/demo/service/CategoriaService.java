package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Categoria;
import com.example.demo.repositories.categoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private categoriaRepository repository;
	
	public List<Categoria> findAll(){
		return repository.findAll();
		}
	
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj= repository.findById(id);
		return obj.get();
	}

}
