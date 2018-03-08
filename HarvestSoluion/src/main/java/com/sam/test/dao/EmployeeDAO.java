package com.sam.test.dao;

import com.sam.ams.entity.Employee;

/**
 * 
 * @author SamarjeetYadav
 *
 */
public interface EmployeeDAO {
	public void createEmployee(Employee employee);
	public Employee getEmployee(Employee employee);

}
