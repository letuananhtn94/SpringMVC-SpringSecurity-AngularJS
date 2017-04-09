package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByName(String name);
}
