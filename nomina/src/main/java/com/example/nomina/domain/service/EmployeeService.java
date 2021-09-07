package com.example.nomina.domain.service;
import java.util.List;

import com.example.nomina.domain.employee.Employee;
import com.example.nomina.infraestructure.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {

        var employees = (List<Employee>) repository.findAll();

        return employees;
    }
}
