package com.teamb.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface BikeRepository extends JpaRepository<Bike_details,String>{

	@Query("Select b from Bike_details as b where b.seater = ?1")
	List<Bike_details> findBySeaters(Integer seaters);
	
	@Query("Select b from Bike_details as b where b.biketype= ?1")
	List<Bike_details> findByBikeType(String bikeType);
}
