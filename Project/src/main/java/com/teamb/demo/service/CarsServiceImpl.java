package com.teamb.demo.service;

import java.util.List;
import java.util.Objects;

//import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamb.demo.dao.CarsRepository;
import com.teamb.demo.dao.Cars_details;

@Service
public class CarsServiceImpl implements CarsService {
	

	@Autowired
	private CarsRepository carRepository;
	
	@Override
	public Cars_details saveCarsDetails(Cars_details cardetails) {
		return carRepository.save(cardetails);
	}
	
	@Override
//  Read
	public List<Cars_details> fetchCarsDetails(){
		return (List<Cars_details>)carRepository.findAll();
	}
	
//	update
	@Override
	public Cars_details updateCarsDetails(Cars_details cardetails , String car_name) {
	     Cars_details carDB = carRepository.findById(car_name).get();
	     if(!Objects.nonNull(cardetails.getCarName()) && !"".equalsIgnoreCase(cardetails.getCarName())) {
	    	 carDB.setCarName(cardetails.getCarName());
	     }
	     
	     if(!Objects.nonNull(cardetails.getCarName()) && !"".equalsIgnoreCase(cardetails.getCarType())) {
	    	 carDB.setCarType(car_name);
	     }
	     
	     if(!Objects.nonNull(cardetails.getSeaters())) {
	    	 carDB.setSeaters(cardetails.getSeaters());
	     } 
	     
	     if(!Objects.nonNull(cardetails.getPrice())) {
	    	 carDB.setPrice(cardetails.getPrice());
	     } 
	     
	     return carRepository.save(carDB);
	}
	
//	delete
	@Override
	public void deleteCarsDetails(String carname) {
	    	 carRepository.deleteById(carname);
	     }
	
	
// seater filter endpoint
	
	@Override
	public List<Cars_details> findBySeaters(Integer seaters){
		List<Cars_details> cars = carRepository.findBySeaters(seaters);
		return cars;
	}
	
// get by cartype
	
	@Override
	public List<Cars_details> findByCarType(String carType){
		List<Cars_details> cars = carRepository.findByCarType(carType);
		return cars;
	}
}
