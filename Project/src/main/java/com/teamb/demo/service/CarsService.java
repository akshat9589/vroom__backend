package com.teamb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.teamb.demo.dao.CarsRepository;
import com.teamb.demo.dao.Cars_details;

public interface CarsService {
	

//	Create/save
	public Cars_details saveCarsDetails(Cars_details cardetails );
	
//  Read
	public List<Cars_details> fetchCarsDetails( );
	
//	update
	public Cars_details updateCarsDetails(Cars_details cardetails , String car_name);
	
//	delete
	public void deleteCarsDetails(String car_name );
	
// find by seats
	public List<Cars_details> findBySeaters(Integer seaters);
	
// find by type
	public List<Cars_details> findByCarType(String carType);
}
