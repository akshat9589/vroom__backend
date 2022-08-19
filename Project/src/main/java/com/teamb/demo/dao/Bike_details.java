package com.teamb.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Bike_details {
	@Id
	@JsonProperty("bikename")
	private String bikename;
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("biketype")
	private String biketype;
	@JsonProperty("seater")
	private Integer seater;
	@JsonProperty("price")
	private Long Price;
	@OneToMany(mappedBy = "bikedetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // Set<Orders> orders;
       private List<Orders> orders=new ArrayList<>();
	Bike_details(){};
	Bike_details(Integer id,String biketype, String bikename, Integer seater,Long price){
		this.id = id;
		this.biketype = biketype;
		this.bikename = bikename;
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
	public void setBikeType(String biketype) {
		this.biketype = biketype;
	}
	public String getBikeType() {
		return this.biketype;
	}
	public void setBikeName(String bikename) {
		this.bikename = bikename;
	}
	public String getBikeName() {
		return this.bikename;
	}
	public void setSeaters(Integer seater) {
		this.seater = seater;
	}
	public Integer getSeaters() {
		return this.seater;
	}
	@Override
	public String toString() {
		return "Bike{" + "id:"  + this.id +
				"Bike_type:" + this.biketype +
				"Bike_name:" + this.bikename +
				"seaters:" + this.seater + "}"; 
	}

}
