package com.entrega.entrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrega.entrega.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
