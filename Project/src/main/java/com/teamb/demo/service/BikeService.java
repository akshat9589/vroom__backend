package com.teamb.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.teamb.demo.dao.Bike_details;
import com.teamb.demo.dao.Cars_details;


public interface BikeService {
	// create/save
	public Bike_details saveBikeDetails(Bike_details bikedetails);
	
	// read
	public List<Bike_details> fetchBikeDetails();
	
	// update
	public Bike_details updatebikedetails(Bike_details bikedetails , String bikename);
	
	// delete
	
	public void deleteBikeDetails(String bikename);
	
	public  List<Bike_details> findBySeaters(Integer seaters);
	
    public List<Bike_details> findByBikeType(String bikeType);

}
