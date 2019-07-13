package com.luv2code.thymeleafdemo.controller;

import com.luv2code.thymeleafdemo.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees;

    @PostConstruct
    private void loadEmployees() {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "Leslie", "Andrews", "leslie@gmail.com"));
        employees.add(new Employee(1, "Emma", "Baumgarten", "Emma@gmail.com"));
        employees.add(new Employee(1, "Avani", "Gupta", "Avani@gmail.com"));
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employees);
        return "employee-list";
    }
}
