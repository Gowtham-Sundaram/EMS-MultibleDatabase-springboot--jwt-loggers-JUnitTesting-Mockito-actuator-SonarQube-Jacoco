package com.accent.employeemanagementsystem;

import com.accent.employeemanagementsystem.jwtuserentitydao.User;
import com.accent.employeemanagementsystem.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class EmployeemanagementsystemApplication {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(new User(101, "admin", passwordEncoder.encode("pwd1"), true, "ADMIN", "user1@gmail.com"),
				new User(102, "manager", passwordEncoder.encode("pwd2"), true, "USER", "user2@gmail.com")).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementsystemApplication.class, args);
	}
}
