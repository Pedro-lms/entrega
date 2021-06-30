package com.entrega.entrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrega.entrega.entities.Product;

/*
 * Pela arquitetura de microserviços, neste ponto é feito o Mapeamento Objeto Relacional. 
 * A API para esta relação é o JPA entre o Mysql e o Spring
 */

public interface ProductRepository extends JpaRepository<Product, Long>{

}
