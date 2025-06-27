package com.luv2code.springboot.tymeleafcrud.service;

import com.luv2code.springboot.tymeleafcrud.dao.EmployeeDAO;
import com.luv2code.springboot.tymeleafcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//    private EmployeeRepository employeeRepository;

    private EmployeeDAO employeeDAO;

    // to Change spring data jpa to entity manager Modify your Service to use EmployeeDAO instead of EmployeeRepository

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = Optional.ofNullable(employeeDAO.findById(theId));

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}






