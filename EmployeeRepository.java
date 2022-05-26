package com.jwt.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jwt.example.model.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
	public Employee findByEmpid(int empid);

	public Employee save(Employee emp);
	
}
