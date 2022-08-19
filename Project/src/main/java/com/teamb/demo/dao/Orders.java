package com.teamb.demo.dao;


import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.xml.crypto.Data;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

@Entity
public class Orders {
	@Id
	@JsonProperty("orderid")
	private Integer orderid;
	@JsonProperty("customer_name")
	private String customer_name;
	// @JsonProperty("username")
	// private String username;
	// @JsonProperty("carname")
	// private String carname;
	// @JsonProperty("bikename")
	// private String bikename;
	@JsonProperty("final_price")
	private Long final_price;
	@JsonProperty("pickup_location")
	private String pickup_location;
	@JsonProperty("pickup_day")
	private java.sql.Date pickup_day;
	@JsonProperty("return_date")
	private java.sql.Date return_date;
	
	//	
	@JsonProperty("images")
	private String images;
	@JsonProperty("order_status")
	private String order_status;
	
	@ManyToOne
    
    @JoinColumn(name = "username")
    User_Details userdetails;

    @ManyToOne
    
    @JoinColumn(name = "carname")
	Cars_details carsdetails;	
    
    @ManyToOne
    
    @JoinColumn(name = "bikename")
	Bike_details bikedetails;	
	
	
	
	Orders(){};
	Orders(Integer orderid,Cars_details cardetails,  String customer_name ,String pickup_location,String images,Long final_price,String order_status, String pickup_day, String return_date){
		this.orderid = orderid;
		this.carsdetails =cardetails;
		
		this.customer_name = customer_name;
		// this.carname = carname;
		this.final_price = final_price;
		this.pickup_location = pickup_location;
		// this.bikename= bikename;
		this.order_status = order_status;
		// this.username = username;
		this.images = images;
		
		//
		java.sql.Date pickup_date = java.sql.Date.valueOf(pickup_day);
		java.sql.Date return_day = java.sql.Date.valueOf(return_date);
		this.return_date = return_day;
		this.pickup_day = pickup_date;
		
		
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public Long getFinal_price() {
		return final_price;
	}
	public void setFinal_price(Long final_price) {
		this.final_price = final_price;
	}
	public String getPickup_location() {
		return pickup_location;
	}
	public void setPickup_location(String pickup_location) {
		this.pickup_location = pickup_location;
	}
	public java.sql.Date getPickup_day() {
		return pickup_day;
	}
	public void setPickup_day(String pickup_day) {
		java.sql.Date pickup_date = java.sql.Date.valueOf(pickup_day);
		this.pickup_day = pickup_date;
	}
	public java.sql.Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		java.sql.Date return_day = java.sql.Date.valueOf(return_date);
		this.return_date = return_day;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public User_Details getUser_details() {
		return userdetails;
	}
	public void setUser_details(User_Details user_details) {
		this.userdetails = user_details;
	}
	public Cars_details getCars_details() {
		return carsdetails;
	}
	public void setCars_details(Cars_details cars_details) {
		this.carsdetails = cars_details;
	}
	public Bike_details getBike_details() {
		return bikedetails;
	}
	public void setBike_details(Bike_details bike_details) {
		this.bikedetails = bike_details;
	}
	
}

