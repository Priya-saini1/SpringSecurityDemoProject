package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Modal.UserModal;
import java.util.List;


public interface UserRepository extends JpaRepository<UserModal, String>{
	
	public UserModal findByUserName(String userName);

}
