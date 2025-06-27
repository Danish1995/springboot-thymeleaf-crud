package com.luv2code.springboot.tymeleafcrud.controller;


import com.luv2code.springboot.tymeleafcrud.entity.Employee;
import com.luv2code.springboot.tymeleafcrud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public String getEmployees(Model model){
        List<Employee> allEmployees = employeeService.findAll();
        model.addAttribute("employees",allEmployees);

        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String addEmployees(Model model){
        Employee employee= new Employee();
        model.addAttribute("employee",employee);

        return "employee-form";
    }

    @PostMapping("/save")
    public String employeeSave(@ModelAttribute("employee") Employee theEmployee){

        employeeService.save(theEmployee);
        return "redirect:/employee";
    }
    @GetMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("employeeId") int theId, Model model){

        Employee employeeToUpdate = employeeService.findById(theId);
        model.addAttribute("employee",employeeToUpdate);

        return "employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId){
        employeeService.deleteById(theId);
        return "redirect:/employee";
    }
}

