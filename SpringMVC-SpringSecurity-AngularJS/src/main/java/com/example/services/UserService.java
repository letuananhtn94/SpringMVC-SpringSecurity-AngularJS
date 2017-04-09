package com.example.services;

import com.example.models.Users;

public interface UserService {
	Users findByName(String name);
}