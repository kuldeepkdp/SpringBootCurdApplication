package com.kdp.springBootCurd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kdp.springBootCurd.dao.EmployeeDao;
import com.kdp.springBootCurd.dao.EmployeeDaoImp;
import com.kdp.springBootCurd.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional
	@Override
	public List<Employee> get() {
		return employeeDao.get();
	}

	@Transactional
	@Override
	public Employee get(int id) {
		return employeeDao.get(id);
	}

	@Transactional
	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
		
	}

	@Transactional
	@Override
	public void delete(int id) {
		employeeDao.delete(id);
		
	}

}
