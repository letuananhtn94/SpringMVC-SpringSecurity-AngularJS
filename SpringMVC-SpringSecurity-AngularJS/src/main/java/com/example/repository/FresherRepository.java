package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Fresher;
import java.lang.Long;
import java.util.List;
import java.lang.String;

/**
 * A DAO for the entity User is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 * The magic is that such methods must not be implemented, and moreover it is
 * possible create new query methods working only by defining their signature!
 * 
 */
// @Transactional
@Repository
public interface FresherRepository extends CrudRepository<Fresher, Long>,JpaRepository<Fresher, Long> {
	
	Fresher findByEmployeeId(String employeeid);
	
	List<Fresher> findAll();
} 
