package com.educandoweb.course.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

//@Component //PRA REGISTRAR A CLASSE COMO COMPONENTE DO STRING 
@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	//METODO PRA RETORNAR TODOS USUARIOS DO BANCO DE DADOS
	public List<Product> findAll(){
		return repository.findAll();
	} 
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
