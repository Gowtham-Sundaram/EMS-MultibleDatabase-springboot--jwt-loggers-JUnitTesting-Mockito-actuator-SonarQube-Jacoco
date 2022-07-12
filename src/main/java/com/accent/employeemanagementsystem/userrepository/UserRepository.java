package com.accent.employeemanagementsystem.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accent.employeemanagementsystem.jwtuserentitydao.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
