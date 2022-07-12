package com.accent.employeemanagementsystem.jwtconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.accent.employeemanagementsystem.jwtuserentitydao.User;
import com.accent.employeemanagementsystem.userrepository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority(user));

	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
		/*
		 * user.getRole().forEach(role -> { authorities.add(new
		 * SimpleGrantedAuthority("ROLE_" + role.getName())); });
		 */
		return authorities;
	}
}
