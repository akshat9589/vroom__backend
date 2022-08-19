package com.teamb.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// jpa consists of two api one mapping subsytemms to maps classes to rdbms and entitty manager api to access the objects and create update and delete.

@Repository
public interface CarsRepository extends JpaRepository<Cars_details, String> {
	@Query("Select c from Cars_details as c where c.seater = ?1")
	List<Cars_details> findBySeaters(Integer seaters);
	
	@Query("Select c from Cars_details c where c.cartype=?1")
	List<Cars_details> findByCarType(String carType);
	
	
	
	
}
