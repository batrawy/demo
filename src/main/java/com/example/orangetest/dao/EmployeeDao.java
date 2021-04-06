package com.example.orangetest.dao;

import com.example.orangetest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeDao extends JpaRepository<Employee,Long > {
    public List findEmployeesByNameContaining(String name);
}
