package com.educandoweb.course.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

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
		return obj.get();
	}
		
	//PARA INSERIR NO BANCO DE DADOS UM NOVO OBJETO DO TIPO USER
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//PARA DELETAR UM USUARIO DO BANCO DE DADOS
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
