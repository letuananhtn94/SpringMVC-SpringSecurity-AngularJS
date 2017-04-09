package com.example.services;

import java.util.List;

import com.example.models.Fresher;

public interface FresherService {
	Fresher findById(Long id);
	
	Fresher findByEmployeeId(String employeeid);
	
	List<Fresher> findAll();
	
	void saveFresher(Fresher fresher);
	
	void updateFresher(Fresher fresher);
	
	void deleteFresher(Long id);
}