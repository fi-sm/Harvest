package com.sam.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.ams.entity.Employee;
import com.sam.test.dao.EmployeeDAO;
import com.sam.test.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	//EmployeeDAO employeeDAO =new EmployeeDAOImpl();
	
	public void createEmployee(Employee employee) {
		
		
		
		employeeDAO.createEmployee(employee);
			
	
		
	}


	public Employee getEmployee(Employee employee) {
		//
		//
		//
		return employeeDAO.getEmployee(employee);
	}
	
	
	
	

}
