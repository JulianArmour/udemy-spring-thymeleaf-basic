package com.luv2code.thymeleafdemo.service;

import com.luv2code.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.thymeleafdemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> maybeEmployee = employeeRepository.findById(id);
        if (maybeEmployee.isPresent()) {
            return maybeEmployee.get();
        }
        throw new RuntimeException("No employee with id " + id + " found.");
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
