package com.example.orangetest.service;

import com.example.orangetest.dao.EmployeeDao;
import com.example.orangetest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employee addEmployee(Employee employee) {
       return employeeDao.save(employee);
    }

    public List<Employee> filterByName(String name) {
      return   employeeDao.findEmployeesByNameContaining(name);
    }

    public Optional<Employee> getEmployee(Long userId) {
        return employeeDao.findById(userId);
    }
}
