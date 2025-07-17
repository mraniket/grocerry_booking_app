package com.qpassessment.qpgrocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qpassessment.qpgrocery.dao.EmployeeDao;
import com.qpassessment.qpgrocery.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeConroller {
	
	@Autowired
	EmployeeDao employeedao;
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee emp){
		
		return employeedao.saveUser(emp);
	}

}
