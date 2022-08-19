package com.teamb.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.teamb.demo.dao.User_Details;

public class RestClient {
	private static String Get_All_USERS = "http://localhost:8080/api/user/user_details";
	private static String Get_USER_BY_USERNAME = "http://localhost:8080/api/user/getusername/{userName}";
	
	static RestTemplate restCall = new RestTemplate();
	
	public static void callGetAllUser() {
		HttpHeaders httpheader = new HttpHeaders();
		httpheader.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("parameters",httpheader);
		
		ResponseEntity<String> result = restCall.exchange(Get_All_USERS,HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}
	
	public static void callGetUserById() {
		HttpHeaders httpheader = new HttpHeaders();
		httpheader.setContentType(MediaType.APPLICATION_JSON);
		httpheader.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		Map<String, String> params = new HashMap<>();
		params.put("userName", "manav_nexturn");
		HttpEntity<?> entity = new HttpEntity<>("parameter",httpheader);
		
		ResponseEntity<User_Details> user = restCall.exchange(Get_USER_BY_USERNAME, HttpMethod.GET,entity,User_Details.class,params);
		System.out.println(user);
	}
	
	public static void main(String [] args) {
		callGetAllUser();
		
	}
	
	
}
