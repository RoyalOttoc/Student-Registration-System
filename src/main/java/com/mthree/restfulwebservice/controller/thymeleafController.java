package com.mthree.restfulwebservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mthree.restfulwebservice.Student;
import com.mthree.restfulwebservice.service.IService;

@Controller
public class thymeleafController {
	
	@Autowired
	private IService service;
	
	@GetMapping(value="/thyme")
	public String getTemplate() {
//		System.out.println("Inside getTemplate() " + name);
		System.out.println("Inside getTemplate");
		System.out.println("Invoking service layer...");

		return "thymetemplate";
 }
	
	@PostMapping(value="/thyme")
	public Student createUser(@RequestBody @Valid Student student, BindingResult result, Model model) {
		System.out.println("Inside createUser of UserResource " + student);
		
		if(result.hasErrors()) {
			return student;
		}else {
			return service.save(student);
		}
		
	}
	

}
