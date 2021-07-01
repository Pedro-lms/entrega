package com.entrega.entrega.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entrega.entrega.DTO.OrderDTO;
import com.entrega.entrega.DTO.ProductDTO;
import com.entrega.entrega.entities.Order;
import com.entrega.entrega.entities.OrderStatus;
import com.entrega.entrega.entities.Product;
import com.entrega.entrega.repository.OrderRepository;
import com.entrega.entrega.repository.ProductRepository;

@Service
/*
 * Nesta classe é feita a relação de DTO(Transferência Objetos-Dados) entre a camada de microserviços 
 * E o controlador REST para relacionar a API entre o front end em React e a regra de negocios em SpringJava
 * Neste caso é utilizado o padrão REST sendo executado pelo modelo Restful através
 *  de arquitetura de microserviços
 */
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAdress(), dto.getLatitude(), dto.getLongitude(), 
				Instant.now(), OrderStatus.PENDING);
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId()); //JPa instancia o pedido e o produto
			order.getProducts().add(product);
		}
		order = repository.save(order);
		return new OrderDTO();
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = repository.getOne(id);
		order.setStatus(OrderStatus.DELIREVED);
		order = repository.save(order);
		return new OrderDTO(order);
	}
}
