package com.entrega.entrega.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entrega.entrega.DTO.ProductDTO;
import com.entrega.entrega.entities.Product;
import com.entrega.entrega.repository.ProductRepository;

@Service
/*
 * Nesta classe é feita a relação de DTO(Transferência Objetos-Dados) entre a camada de microserviços 
 * E o controlador REST para relacionar a API entre o front end em React e a regra de negocios em SpringJava
 * Neste caso é utilizado o padrão REST sendo executado pelo modelo Restful através
 *  de arquitetura de microserviços
 */
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product> list = repository.findAll();
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
}
