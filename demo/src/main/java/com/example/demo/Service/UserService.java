package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Modal.UserModal;

@Service
public class UserService {

	List<UserModal> list = new ArrayList<>();
//	public UserService() {
//		list.add(new UserModal("abc","abc","abc@gmail.com"));
//		list.add(new UserModal("xyz","xyz","xyz@gmail.com"));
//	}
	
	// get all user 
	
	public List<UserModal> getAllUser(){
		return this.list;
	}
	
	// get single User 
	
	public UserModal getUser(String UserName) {
		return this.list.stream().filter((user)->user.getUserName().equals(UserName)).findAny().orElse(null);
	}
	
	// add use r
	public UserModal addUser(UserModal user) {
		this.list.add(user);
		return user;
	}
}
