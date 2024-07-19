package com.educandoweb.course.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

//@Component //PRA REGISTRAR A CLASSE COMO COMPONENTE DO STRING 
@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	//METODO PRA RETORNAR TODOS USUARIOS DO BANCO DE DADOS
	public List<User> findAll(){
		return repository.findAll();
	} 
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
		
	//PARA INSERIR NO BANCO DE DADOS UM NOVO OBJETO DO TIPO USER
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//PARA DELETAR UM USUARIO DO BANCO DE DADOS
	public void delete(Long id) {
		try {
		    repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
		    throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
