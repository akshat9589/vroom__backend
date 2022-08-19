package com.teamb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.teamb.demo.dao.Orders;
import com.teamb.demo.dao.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersRepository ordersrepo;
	
	// getorders
	@Override
	public List<Orders> getAllOrders(){
		List<Orders> order = ordersrepo.findAll();
		return order;
	}
	
	//post 
	@Override
	public Orders postOrders(Orders order) {
		return ordersrepo.save(order);
	}
	
	// update
	
//	public Orders updatOrders(Orders order , Integer orderid) {
//		return 
//	}
	@Override
	public void deleteOrders(Integer orderid) {
		ordersrepo.deleteById(orderid);
	}
	
	//
	//public List<Orders> findByUsername(String username){
		//List<Orders> orderbyid = ordersrepo.findByUsername(username);
		// return orderbyid;
	//}
	
	// revenue
	
	//public Long calculateRevenue() {
		//return ordersrepo.calculateRevenue();
	//}
	
	//public List<Orders> findOrdersByUsername(String username){
		//return ordersrepo.findOrdersByUsername(username);
	//}
	
	
	
	
}
