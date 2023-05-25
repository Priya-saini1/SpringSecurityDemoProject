package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.UserRepository;
import com.example.demo.Modal.CustomUserDetails;
import com.example.demo.Modal.UserModal;

@Service
public class CustomUserDetailServices implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserModal user = this.userRepository.findByUserName(username);
		if(user != null) {
			return new CustomUserDetails(user);
		}
		return (UserDetails) new UsernameNotFoundException("Username or Password Is in valid");
	}

}
