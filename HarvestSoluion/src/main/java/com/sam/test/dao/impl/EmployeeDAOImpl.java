package com.sam.test.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sam.ams.entity.Employee;
import com.sam.test.dao.EmployeeDAO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;

	//@Override
	public void createEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
	//	Transaction tx = session.beginTransaction();
		session.save(employee);
	//	tx.commit();
		session.close();
	}

	//@Override
	public Employee getEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Criteria criteria = null;
		Employee emp = null;
		try {
			criteria = session.createCriteria(Employee.class);
			Criterion criterion = Restrictions.eq("username",
					employee.getUsername());
			criteria.add(criterion);

			criteria.setMaxResults(1);
			emp = (Employee) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return emp;
	}

}