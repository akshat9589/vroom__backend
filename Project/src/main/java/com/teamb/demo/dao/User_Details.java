package com.teamb.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User_Details {
	@Id
	@JsonProperty("username")
	private String username;
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("lastname")
	private String lastname;
	@JsonProperty("email")
	private String email;
	@JsonProperty("pass")
	private String pass;
	@JsonProperty("aadharno")
	private long aadharno;
	
	@OneToMany(mappedBy = "userdetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<Orders> orders=new ArrayList<>();
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}
	
	public void setUserName(String userid) {
		this.username = username;
	}
	public String getUserName() {
		return this.username;
	}
	
	public void setFirst(String first) {
		this.firstname = first;
	}
	public String getFirst() {
		return this.firstname;
	}
	
	public void setLast(String last) {
		this.lastname = last;
	}
	
	public String getLast() {
	  return this.lastname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getPass() {
		return this.pass;
	}
	
	public void setAadhar(Long aadhar) {
		this.aadharno = aadhar;
	}
	
	public Long getAadhar() {
		return this.aadharno;
	}
	
	@Override
	public String toString() {
		return "User{" + "id:"  + this.id +
				"firstname:" + this.firstname +
				"lastname:" + this.lastname +
				"username:" + this.username +
				"email:" + this.email +
				"aadharno:" + this.aadharno +
				"pass" + this.pass +"}"; 
	}

}
