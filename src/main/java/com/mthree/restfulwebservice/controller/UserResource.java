package com.mthree.restfulwebservice.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.restfulwebservice.Student;
import com.mthree.restfulwebservice.exceptionhandling.UserNotFoundException;
import com.mthree.restfulwebservice.service.IService;

@RestController
public class UserResource {
	@Autowired
	private IService service;
	
	
//	@RequestMapping(method = RequestMethod.GET, value = "/users")
	@GetMapping(path = "/students/all")
	public List<Student> retrieveAllUsers(){
		System.out.println("Inside retrieveAllUsers of UserResource");
		return service.findAll();
				
	}
	
//	@GetMapping(path = "/students/{id}")
//	public User retrieveUser(@PathVariable(value = "id") int eid) { //PathVariable value will match automatically
//		System.out.println("Inside retrieveUser of UserResource");
//		User user = service.findById(eid);
//		System.out.println(user);
//		if(user == null) {
//			throw new UserNotFoundException("id-" + eid + " is not found");
//		}
//		return user;
//	}
	

	
	@PostMapping(path = "/students")

	public Student createUser(@RequestBody Student student, BindingResult result, Model model) {
		System.out.println("Inside createUser of UserResource " + student);
		
		if(result.hasErrors()) {
			return student;
		}else {
			return service.save(student);
		}
		
	}
//	
	@DeleteMapping(path = "/students/{id}")
	public Student removeUser(@PathVariable int id) {
		System.out.println("Inside removeUser of UserResource");
		return service.deleteById(id);
	}
//	
//	@GetMapping(path="/users/name/{name}")
//	public List<User> retrieveUsersByName(@PathVariable String name){
//		System.out.println("Inside retrieveUsersByName of UserResource");
//		return service.findByName(name);
//	}
//	
//	@GetMapping(path="/users/idorname/{id}/{name}")
//	public List<User> retrieveUsersByIdOrName(@PathVariable int id,@PathVariable String name){
//		System.out.println("Inside retrieveUsersByIdOrName of UserResource");
//		return service.findByIdOrName(id, name);
//	}
	
	@GetMapping(path="/students/{id}")
	public List<Student> retrieveStudentsByID(@PathVariable int id){
		System.out.println("Inside retrieveStudentsByID of UserResource");
		return service.findById(id);
	}
//	
	@Transactional
	@PutMapping(path = "/students/{id}/{name}/{age}/{mobile}/{addr}")
	public void updateUser(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("age") int age, @PathVariable("mobile") String mobile, @PathVariable("addr") String address) {
		System.out.println("Inside updateUser of UserResource");
		service.updateById(id, name, age, mobile, address);
	}
//	
}
