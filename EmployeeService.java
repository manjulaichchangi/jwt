package com.jwt.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.example.model.Employee;
import com.jwt.example.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository repository;
	//creating
	public Employee create(int empid, String name, String job)
	{
		return repository.save(new Employee());
	}
	//getall the records
	public List<Employee> listAll()
	{
		return (List<Employee>) repository.findAll();
	}
	//find by id
	public Employee findByEmpid(int empid)
	{
		return repository.findByEmpid(empid);
	}
	//updating
	public void update(int empid, String name, String job)
	{
		Employee emp=repository.findByEmpid(empid);
	    emp.setName(name);
		emp.setJob(job);
		 repository.save(emp);
	}
	//delete by id
	public void delete(int empid)
	{
		repository.deleteById(empid);
	}
	//delete all
	public void deleteAll()
	{
		repository.deleteAll();
	}
}
