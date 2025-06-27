package com.luv2code.springboot.tymeleafcrud.dao;

import com.luv2code.springboot.tymeleafcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
