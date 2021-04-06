package com.example.orangetest.dao;


import com.example.orangetest.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeDaoTest {

    @Autowired
   private TestEntityManager entityManager;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void addEmployeeTest() {
        Employee employee = getEmployee();

        Employee savedEmployee = entityManager.persist(employee);
        Optional<Employee> returnedEmployee = employeeDao.findById(savedEmployee.getId());
        assertThat(returnedEmployee.get()).isEqualTo(savedEmployee);

    }


    private Employee getEmployee() {
    return new Employee("ahmed",60,30);
    }

}
