package com.mthree.restfulwebservice.dao;

import java.util.List;
import java.util.Optional;

import com.mthree.restfulwebservice.Student;

public interface IDAO {
	public List<Student> findAll();
	public Student save(Student student);
	public Student deleteById(int id);
	public List<Student> findById(int id);
//	public List<Student> findByName(String Student);
//	public List<Student> findByIdOrName(int id, String name);
	public void updateById(int id, String name, int age, String mobile, String address);
}
