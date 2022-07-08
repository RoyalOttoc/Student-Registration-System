package com.mthree.restfulwebservice.service;

import java.util.List;

import com.mthree.restfulwebservice.Student;


public interface IService {
	public List<Student> findAll();
	public Student save(Student student);
	public Student deleteById(int id);
	public List<Student> findById(int id);
//	public List<Student> findByName(String Student);
//	public List<Student> findByIdOrName(int id, String name);
	public void updateById(int id, String name, int age, String mobile, String address);
}