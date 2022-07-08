package com.mthree.restfulwebservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mthree.restfulwebservice.Student;
import com.mthree.restfulwebservice.dao.IDAO;
import com.mthree.restfulwebservice.dao.UserInMemoryRepository;
import com.mthree.restfulwebservice.exceptionhandling.UserNotFoundException;

@Service
public class UserService implements IService {
	@Autowired
	private IDAO dao;
	
	public UserService() {
		System.out.println("Inside Default Constructor of UserService");
	}
	
	@Override
	public List<Student> findAll() {
		System.out.println("Inside findAll of UserService");
		return dao.findAll();
	
	}
	
		
	

	@Override
	public Student save(Student student) {
		
		System.out.println("Inside save of UserService");
		return dao.save(student);
		
	}

	@Override
	public Student deleteById(int id) {
		System.out.println("Inside deleteById of UserService");
		return dao.deleteById(id);
	}

	@Override
	public void updateById(int id, String name, int age, String mobile, String address) {
		System.out.println("Inside updateById of UserService");
		dao.updateById(id, name, age, mobile, address);
		
	}

	@Override
	public List<Student> findById(int id) {
		System.out.println("Inside findById of UserService");
		return dao.findById(id);
	}

}
