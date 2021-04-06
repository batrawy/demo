package com.example.orangetest.service;

import com.example.orangetest.dao.EmployeeDao;
import com.example.orangetest.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;
    @MockBean
    private EmployeeDao employeeDao ;

    @Test
    public void addEmployeeTest() {

        Employee employee = getEmployee();

        Mockito.when(employeeDao.save(employee)).thenReturn(employee);

        assertThat(employeeService.addEmployee(employee)).isEqualTo(employee);

    }

    private Employee getEmployee() {
        Employee employee =new Employee();
        employee.setId(1l);
        employee.setName("ahmed");
        employee.setRemainingBalance(30);
        employee.setTotalVacationBalance(60);
        return employee;
    }




}
