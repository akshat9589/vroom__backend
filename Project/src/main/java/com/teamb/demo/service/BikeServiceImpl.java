package com.teamb.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamb.demo.dao.BikeRepository;
import com.teamb.demo.dao.Bike_details;

@Service
public class BikeServiceImpl implements BikeService {

	@Autowired
	private BikeRepository bikerepository;
	
	// save
	@Override
	public Bike_details saveBikeDetails(Bike_details bike_details) {
		return bikerepository.save(bike_details);
	}
	
	//read
	@Override
	public List<Bike_details> fetchBikeDetails(){
		return bikerepository.findAll();
	}
	
	// update 
	@Override
	public Bike_details updatebikedetails(Bike_details bikedetails , String bikename) {
		Bike_details bikeDB = bikerepository.findById(bikename).get();
		
		if(!Objects.nonNull(bikedetails.getBikeName()) && !"".equals(bikedetails.getBikeName())) {
			bikeDB.setBikeName(bikedetails.getBikeName());
		}
		if(!Objects.nonNull(bikedetails.getBikeType()) && !"".equals(bikedetails.getBikeType())) {
			bikeDB.setBikeType(bikedetails.getBikeType());
		}
		if(!Objects.nonNull(bikedetails.getSeaters())) {
			bikeDB.setSeaters(bikedetails.getSeaters());
		} 
		     
		if(!Objects.nonNull(bikedetails.getPrice())) {
		    bikeDB.setPrice(bikedetails.getPrice());
		} 
		return bikerepository.save(bikeDB);
	}
	
	// delete
	@Override
	public void deleteBikeDetails(String bikename) {
		bikerepository.deleteById(bikename);
	}
	
	public  List<Bike_details> findBySeaters(Integer seaters){
		List<Bike_details> bikes = bikerepository.findBySeaters(seaters);
		return bikes;
	}
	
    public List<Bike_details> findByBikeType(String bikeType){
    	List<Bike_details> bikes = bikerepository.findByBikeType(bikeType);
    	return bikes;
    }
}
