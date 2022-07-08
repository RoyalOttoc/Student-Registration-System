package com.mthree.restfulwebservice.dao;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mthree.restfulwebservice.Student;

@Repository(value = "userjparepos")
//@Profile("prod")
public interface UserJPARepository extends IDAO,JpaRepository<Student, Integer> {
	/*
	 findById : Retrieves one object based on the ID you pass it
	 findAll  :	Retrieves a list of all the objects of the type
		save  :	Used for both creating and updating an object; returns the object that was created or updated as it now exists in the database
	 deleteById : Deletes the object with the passed ID from the database
	 count : Retrieves a count of all objects of a type in the database
	 existsById : Checks if an object with the passed ID exists in the database; returns true or false
	 */
	
//	public List<User> findByName(String name);
//	public List<User> findByIdOrName(int id, String name);
//	
	@Modifying
	@Query("update Student u set u.name = ?2,u.age= ?3,u.mobile= ?4, u.address=?5 where u.id = ?1")
	public void updateById(int id, String name, int age, String mobile, String address);
	
}
