package com.example.demo.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitys.Produto;
import com.example.demo.service.ProdutoService;



@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		
		List<Produto> listaProdutos = service.findAll();
		return ResponseEntity.ok().body(listaProdutos);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto produto = service.findById(id);
		return ResponseEntity.ok().body(produto);
		
	}
	
}
