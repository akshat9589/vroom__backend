package com.teamb.demo.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

import com.teamb.demo.dao.Bike_details;
import com.teamb.demo.dao.Cars_details;
import com.teamb.demo.dao.Orders;
import com.teamb.demo.service.BikeService;

@Controller
@RequestMapping("/api/bike")
public class BikeController {
	@Autowired
	BikeService bikeservice;
	@PostMapping("/bikes_details")
	public @ResponseBody Bike_details savebike(@RequestBody Bike_details bikedetails) {
		return 	bikeservice.saveBikeDetails(bikedetails);
		
	}
	
//	@OneToMany(mappedBy = "bike_details")
//    Set<Orders> orders;
	// fetch 
	@GetMapping("/bikes_details")
	public @ResponseBody List<Bike_details> getBikes() {
		return bikeservice.fetchBikeDetails();
	}
	
	//update
	@PutMapping("/bikes_details")
	public @ResponseBody Bike_details updateBikeDetails(@RequestBody Bike_details bikedetails,String bikename) {
		return bikeservice.updatebikedetails(bikedetails, bikename);
	}
	
	//delete
	@DeleteMapping
	public void deleteBikeDetails(@RequestBody String bikename) {
		bikeservice.deleteBikeDetails(bikename);
	}
	
	
	@GetMapping("/showbikebyseats")
	public @ResponseBody List<Bike_details> findBySeaters(@RequestParam Integer seats){
		return bikeservice.findBySeaters(seats);
	}
	
	@GetMapping("/showbikebytype")
	public @ResponseBody List<Bike_details> findByBikeType(@RequestParam String biketype){
		return bikeservice.findByBikeType(biketype);
	}

}
