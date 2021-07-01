package com.entrega.entrega.DTO;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.entrega.entrega.entities.Order;
import com.entrega.entrega.entities.OrderStatus;

public class OrderDTO implements Serializable{
	private static final long serialVersionUID = 1L; 
	
	private Long id;
	private String adress;
	private Double latitude;
	private Double longitude;
	private Instant moment;
	private OrderStatus status;
	
	private List<ProductDTO> products = new ArrayList<>();
	
	public OrderDTO() {
	}

	
	
	public OrderDTO(Long id, String adress, Double latitude, Double longitude, Instant moment, OrderStatus status) {
		super();
		this.id = id;
		this.adress = adress;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
	}



	public OrderDTO(Order entity) {
		id = entity.getId();
		adress = entity.getAdress();
		latitude = entity.getLatitude();
		longitude = entity.getLongitude();
		moment = entity.getMoment();
		status = entity.getStatus();
		products = entity.getProducts().stream().
				map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getAdress() {
		return adress;
	}



	public void setAdress(String adress) {
		this.adress = adress;
	}



	public Double getLatitude() {
		return latitude;
	}



	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}



	public Double getLongitude() {
		return longitude;
	}



	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}



	public Instant getMoment() {
		return moment;
	}



	public void setMoment(Instant moment) {
		this.moment = moment;
	}



	public OrderStatus getStatus() {
		return status;
	}



	public void setStatus(OrderStatus status) {
		this.status = status;
	}



	public List<ProductDTO> getProducts() {
		return products;
	}



	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
		
}
