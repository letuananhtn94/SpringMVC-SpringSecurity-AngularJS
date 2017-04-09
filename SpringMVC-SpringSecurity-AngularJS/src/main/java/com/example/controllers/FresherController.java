package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.models.Fresher;
import com.example.services.FresherService;

/**
 * A class to test interactions with the SQLSERVER database using the UserDao
 * class.
 *
 */
@RestController
public class FresherController {
	
	// ------------------------
	// PUBLIC METHODS
	// ------------------------
	@Autowired
	FresherService fresherService;

	@RequestMapping(value = "/fresher/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Fresher>> listAll() {

		List<Fresher> fresher = null;
		try {
			fresher = fresherService.findAll();
		} catch (Exception ex) {
			
		}
		
		if (fresher.size() == 0) {
			return new ResponseEntity<List<Fresher>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Fresher>>(fresher, HttpStatus.OK);

	}

	// -------------------Retrieve Single Fresher--------------------------------------------------------

	@RequestMapping(value = "/fresher/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fresher> getFresher(@PathVariable("id") long id) {
		
		Fresher fresher = fresherService.findById(id);
		if (fresher == null) {
			
			return new ResponseEntity<Fresher>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Fresher>(fresher, HttpStatus.OK);
	}

	
	// -------------------Create a Fresher--------------------------------------------------------

	@RequestMapping(value = "/fresher/create", method = RequestMethod.POST)
	public ResponseEntity<Void> createFresher(@RequestBody Fresher fresher, UriComponentsBuilder ucBuilder) {
		

		fresherService.saveFresher(fresher);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(fresher.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Fresher --------------------------------------------------------

	@RequestMapping(value = "/fresher/update/{id}", method = RequestMethod.POST)
	public ResponseEntity<Fresher> updateUser(@PathVariable("id") long id, @RequestBody Fresher fresher) {
		
		Fresher currentFresher = fresherService.findById(id);

		if (currentFresher == null) {			
			return new ResponseEntity<Fresher>(HttpStatus.NOT_FOUND);
		}

		currentFresher.setEmployeeId(fresher.getEmployeeId());
		currentFresher.setFullName(fresher.getFullName());
		currentFresher.setSex(fresher.getSex());
		currentFresher.setShortName(fresher.getShortName());
		currentFresher.setOffice(fresher.getOffice());
		currentFresher.setCube(fresher.getCube());

		fresherService.updateFresher(currentFresher);
		return new ResponseEntity<Fresher>(currentFresher, HttpStatus.OK);
	}

	// ------------------- Delete a Fresher --------------------------------------------------------

	@RequestMapping(value = "/fresher/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<Fresher> deleteUser(@PathVariable("id") long id) {
		
		Fresher fresher = fresherService.findById(id);
		if (fresher == null) {
			
			return new ResponseEntity<Fresher>(HttpStatus.NOT_FOUND);
		}

		fresherService.deleteFresher(id);
		return new ResponseEntity<Fresher>(HttpStatus.NO_CONTENT);
	}

} 
