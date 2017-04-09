package com.example.services;

import com.example.models.Role;

public interface RoleService {
	Role findByName(String name);
}
