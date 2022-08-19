package com.teamb.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamb.demo.dao.CarsRepository;
import com.teamb.demo.dao.Cars_details;
import com.teamb.demo.service.CarsService;

@Controller
@RequestMapping("/api/cars")
@CrossOrigin(origins="http://localhost:3000/")
public class CarsController {
	@Autowired
	private CarsService carsService;
	
//	Post
	@PostMapping("/cars_details")
	public @ResponseBody Cars_details saveCars(@RequestBody Cars_details cardetails)
	{		
		return carsService.saveCarsDetails(cardetails);
	}
	
	@GetMapping("/cars_details")
	public @ResponseBody List<Cars_details> getCars() {
		return carsService.fetchCarsDetails();
	}
	
	
	@PutMapping("/cars_details/{carname}")
	public @ResponseBody Cars_details updateCardetails(Cars_details cardetails, @PathVariable("carname") String carname) {
		return carsService.updateCarsDetails(cardetails, carname);
		
	}
	
	@DeleteMapping("/cars_details{id}")
	   public void deletecars(@PathVariable("id") String carname) {
		carsService.deleteCarsDetails(carname);
	}
	
	// filter by seats
	@GetMapping("/showcarsbyseats")
		public @ResponseBody List<Cars_details> findBySeaters(@RequestParam Integer seaters){
			return carsService.findBySeaters(seaters);
			
		}
	@GetMapping("/showcarsbytype")
		public @ResponseBody List<Cars_details> findByCarType(@RequestParam String carType){
			return carsService.findByCarType(carType);
		}
}
