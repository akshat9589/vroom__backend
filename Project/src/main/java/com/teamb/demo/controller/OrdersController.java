package com.teamb.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamb.demo.dao.Orders;
import com.teamb.demo.service.OrdersService;

@CrossOrigin(origins="http://localhost:3000")
@Controller
@RequestMapping("api/orders")
public class OrdersController {
	@Autowired
	OrdersService ordersservice;
	
	@GetMapping("/get")
	public @ResponseBody List<Orders> getAllOrders(){
		return ordersservice.getAllOrders();
	}
	
	// post
	@PostMapping("/postorder")
	public @ResponseBody Orders postOrders(@RequestBody Orders order) {
		return ordersservice.postOrders(order);
	}
	
	//delete
	 @DeleteMapping("/deleteorder/{id}")
	 public void deleteOrder(@PathVariable Integer id ) {
		 ordersservice.deleteOrders(id);
	 }
	 
//	 @GetMapping("getbyid/{username}")
//	 public @ResponseBody List<Orders> getOrderById(@PathVariable String username){
//		 return ordersservice.findByUsername(username);
//		 
//	 }
//	 
//	 @GetMapping("/getrevenue")
//	public @ResponseBody Long calculateRevenue() {
//		return ordersservice.calculateRevenue();
//			
//		}
//	 
//	 @GetMapping("/getordersbtuser/{username}")
//	 public @ResponseBody List<Orders> findOrdersByUsername(@PathVariable String username){
//		 return ordersservice.findOrdersByUsername(username);
//	 }


}
