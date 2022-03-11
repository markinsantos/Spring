package com.example.demo.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitys.Categoria;
import com.example.demo.service.CategoriaService;



@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		
		List<Categoria> listaUsuarios = service.findAll();
		return ResponseEntity.ok().body(listaUsuarios);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		Categoria usuario = service.findById(id);
		return ResponseEntity.ok().body(usuario);
		
	}
	
}
