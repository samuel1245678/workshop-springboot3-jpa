package com.educandoweb.course.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;


//@Component //PRA REGISTRAR A CLASSE COMO COMPONENTE DO STRING 
@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	//METODO PRA RETORNAR TODOS USUARIOS DO BANCO DE DADOS
	public List<Order> findAll(){
		return repository.findAll();
	} 
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
