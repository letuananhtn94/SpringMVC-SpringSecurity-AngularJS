package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Users;
import com.example.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Users findByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(name);
	}
			
}
