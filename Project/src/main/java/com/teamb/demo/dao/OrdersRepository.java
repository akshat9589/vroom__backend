package com.teamb.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository  extends JpaRepository<Orders, Integer>{
	
//	@Query("Select o from Orders o where o.username = ?1 ")
//	List<Orders> findByUsername(String username);
//	
//	
//	@Query("Select ((AVG(o.final_price))*(Count(o.orderid))) from Orders o")
//	public Long calculateRevenue();
//	
//	@Query("Select * from Orders as o Join User_Details as u using(username) where o.username = ?1")
//	public List<Orders> findOrdersByUsername(String username);
	
	

}
