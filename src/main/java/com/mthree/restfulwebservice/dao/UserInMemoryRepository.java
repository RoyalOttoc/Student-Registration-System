package com.mthree.restfulwebservice.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.mthree.restfulwebservice.Student;

import com.mthree.restfulwebservice.exceptionhandling.UserNotFoundException;

@Repository(value = "usermemoryrepos")
@Profile("dev")
public class UserInMemoryRepository implements IDAO {

	private static List<Student> students = null;
//	private static int studentCount = 3;
	
	static {
		students = new ArrayList<Student>();
		students.add(new Student(1, "Jong", 20, "041238571", "Sydney"));
		students.add(new Student(2, "Andrew", 25, "041238571", "Brisbane"));
		students.add(new Student(3, "Peter", 30, "041238571", "Hobart"));
		
	}
		
	public UserInMemoryRepository() {
		System.out.println("Inside Default Constructor of UserInMemoryRepository");
	}

	
	@Override
	public List<Student> findAll() {
		System.out.println("Inside findAll of UserInMemoryRepository"); // to fire "SELECT * FROM users-table"
		return students;
	}

	@Override
	public Student save(Student student) {
		System.out.println("Inside save of UserInMemoryRepository");
		students.add(student);
		return student;
		
	}


	@Override
	public Student deleteById(int id) {
		System.out.println("Inside deleteById of UserInMemoryRepository");
		Iterator<Student> iter = students.iterator();
		while(iter.hasNext()) {
			Student u = iter.next();
			if(u.getId() == id) {
				iter.remove();
				return u;
			}
		}
		return null;
	}


	@Override
	public void updateById(int id, String name, int age, String mobile, String address) {
		System.out.println("Inside updateById of UserInMemoryRepository");
		Iterator<Student> iter = students.iterator();
		while(iter.hasNext()) {
			Student u = iter.next();
			if(u.getId() == id) {
				u.setName(name);
				u.setAge(age);
				u.setMobile(mobile);
				u.setAddress(address);
				
//				return u;
			}
		}
		
//		return null;
		
	}


	@Override
	public List<Student> findById(int id) {
		System.out.println("Inside findByName of UserInMemoryRepository");
		List<Student> studentList =  students.stream().filter(u -> u.getId() == id).toList();
		return studentList;
	}


	


	

	

	

}
