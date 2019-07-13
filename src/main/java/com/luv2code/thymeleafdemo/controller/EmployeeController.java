package com.luv2code.thymeleafdemo.controller;

import com.luv2code.thymeleafdemo.model.Employee;
import com.luv2code.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employees/employee-list";
    }

    @GetMapping("/add-employee")
    public String addEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/update-employee")
    public String updateEmployee(@RequestParam("employeeId") int employeeId, Model model) {
        Employee employee = employeeService.findById(employeeId);
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @GetMapping("/delete-employee")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId) {
        employeeService.deleteById(employeeId);
        return "redirect:/employees/list";
    }
}
