package com.kdp.springBootCurd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdp.springBootCurd.model.Employee;

@Repository
public class EmployeeDaoImp implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> get() {
         Session currentSession = entityManager.unwrap(Session.class);
         Query<Employee> query= currentSession.createQuery("from Employee", Employee.class);
         List<Employee> list= query.getResultList();
         return list;
	}

	@Override
	public Employee get(int id) {
		 Session currentSession = entityManager.unwrap(Session.class);
		 Employee employeeObject = currentSession.get(Employee.class, id);
		 return employeeObject;
	}

	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
		
	}

	@Override
	public void delete(int id) {
		 Session currentSession = entityManager.unwrap(Session.class);
		 Employee employeeObject = currentSession.get(Employee.class, id);
		 currentSession.delete(employeeObject);
		
	}

}
