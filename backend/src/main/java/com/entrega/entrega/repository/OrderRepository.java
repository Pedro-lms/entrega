package com.entrega.entrega.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entrega.entrega.entities.Order;
/*
 * Aqui o JPA faz o CRUD com o Banco de dados por implementação do Hibernate
 */
public interface OrderRepository extends JpaRepository<Order, Long>{

	@Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products"
			+ "WHERE obj.status = 0 ORDER BY obj.moment ASC")
	List<Order> findOrdersWithProducts();
}
