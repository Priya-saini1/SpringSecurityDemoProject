package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import com.example.demo.Dao.UserRepository;
import com.example.demo.Modal.UserModal;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("started .................");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		UserModal u = new UserModal();
		u.setUserName("Priya");
		u.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("1234").substring(8));
		u.setRole("ROLE_NORMAL");
		u.setEmail("abc@gmail.com");
		this.userRepo.save(u);
		
		
		UserModal u1 = new UserModal();
		u1.setUserName("admin");
		u1.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin123").substring(8));
		u1.setRole("ROLE_ADMIN");
		u1.setEmail("admin@gmail.com");
		this.userRepo.save(u1);
	}

}
