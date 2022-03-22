package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.exceptions.DataBaseException;
import com.example.demo.service.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
		}
	
	
	public User findById(Long id) {
		Optional<User> obj= repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User inserir(User user) {
		return repository.save(user);
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User user) {
		try {
		User entity = repository.getById(id);
		updateData(entity, user);
		return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}


	private void updateData(User entity, User user) {
		entity.setNome(user.getNome());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		
	}

}
