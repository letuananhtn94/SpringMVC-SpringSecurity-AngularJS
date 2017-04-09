package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Fresher;
import com.example.repository.FresherRepository;

@Service("fresherService")
public class FresherServiceImpl implements FresherService{

	@Autowired
	FresherRepository fresherRepository;
	
	
	public FresherServiceImpl() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public Fresher findById(Long id) {
		// TODO Auto-generated method stub
		return fresherRepository.findOne(id);
	}


	@Override
	public Fresher findByEmployeeId(String employeeid) {
		// TODO Auto-generated method stub
		return fresherRepository.findByEmployeeId(employeeid);
	}


	@Override
	public List<Fresher> findAll() {
		// TODO Auto-generated method stub
		return fresherRepository.findAll();
	}


	@Override
	public void saveFresher(Fresher fresher) {
		// TODO Auto-generated method stub
		fresherRepository.save(fresher);
	}


	@Override
	public void updateFresher(Fresher fresher) {
		// TODO Auto-generated method stub
		fresherRepository.saveAndFlush(fresher);
	}


	@Override
	public void deleteFresher(Long id) {
		// TODO Auto-generated method stub
		fresherRepository.delete(id);
	}


			
}
