package com.teamb.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Cars_details {
	@Id
	@JsonProperty("carname")
	private String carname;
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("cartype")
	private String cartype;
	@JsonProperty("seater")
	private Integer seater;
	@JsonProperty("price")
	private Long Price;
	
	@OneToMany(mappedBy = "carsdetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<Orders> orders=new ArrayList<>();
	
	Cars_details(){};
	Cars_details(Integer id,String cartype, String carname, Integer seater,Long price){
		this.id = id;
		this.cartype = cartype;
		this.carname = carname;
		this.seater = seater;
		this.Price = price;
	}
	public void setPrice(Long Price) {
		this.Price = Price;
	}
	public Long getPrice() {
		return this.Price;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getid() {
		return this.id;
	}
	public void setCarType(String cartype) {
		this.cartype = cartype;
	}
	public String getCarType() {
		return this.cartype;
	}
	public void setCarName(String carname) {
		this.carname = carname;
	}
	public String getCarName() {
		return this.carname;
	}
	public void setSeaters(Integer seater) {
		this.seater = seater;
	}
	public Integer getSeaters() {
		return this.seater;
	}
	@Override
	public String toString() {
		return "Car{" + "id:"  + this.id +
				"Car_type:" + this.cartype +
				"Car_name:" + this.carname +
				"seaters:" + this.seater + "}"; 
	}


}
