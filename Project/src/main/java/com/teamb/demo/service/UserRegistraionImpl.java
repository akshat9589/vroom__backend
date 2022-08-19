package com.teamb.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamb.demo.dao.BikeRepository;
import com.teamb.demo.dao.Bike_details;
import com.teamb.demo.dao.UserRepository;
import com.teamb.demo.dao.User_Details;

@Service
public class UserRegistraionImpl implements UserRegister{
	@Autowired
	private UserRepository userrepository;
	
	// save
	@Override
	public User_Details saveUserDetails(User_Details user_details) {
		return userrepository.save(user_details);
	}
	
	//read
	@Override
	public List<User_Details> fetchUserDetails(){
		return (List<User_Details>)userrepository.findAll();
	}
	
	// update 
	@Override
	public User_Details updateUserdetails(User_Details userdetail , String username) {
		User_Details userDB = userrepository.findById(username).get();
		
		if(!Objects.nonNull(userdetail.getFirst()) && !"".equals(userdetail.getFirst())) {
			userDB.setFirst(userdetail.getFirst());
		}
		if(!Objects.nonNull(userdetail.getLast()) && !"".equals(userdetail.getLast())) {
			userDB.setLast(userdetail.getLast());
		}
		if(!Objects.nonNull(userdetail.getEmail())) {
			userDB.setEmail(userdetail.getEmail());
		} 
		     
		if(!Objects.nonNull(userdetail.getUserName())) {
		    userDB.setUserName(userdetail.getUserName());
		}
		
		if(!Objects.nonNull(userdetail.getAadhar())) {
		    userDB.setAadhar(userdetail.getAadhar());
		}
		if(!Objects.nonNull(userdetail.getPass())) {
		    userDB.setPass(userdetail.getPass());
		}
		return userrepository.save(userDB);
	}
	
	// delete
	@Override
	public void deleteUserDetails(String bikename) {
		userrepository.deleteById(bikename);
	}

	@Override
	public List<User_Details> findByUserName(String userName) {
		List<User_Details> user = userrepository.findByUserName(userName);
		return user;
	}
}
