package com.examly.springapp.repository;

import com.examly.springapp.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Object findById(String firstName);

}