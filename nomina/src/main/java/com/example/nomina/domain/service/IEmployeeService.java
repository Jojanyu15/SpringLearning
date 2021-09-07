package com.example.nomina.domain.service;

import com.example.nomina.domain.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
}
