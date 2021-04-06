package com.example.orangetest.service;


import com.example.orangetest.dao.EmployeeDao;
import com.example.orangetest.dao.VacationHistoryDao;
import com.example.orangetest.model.Employee;
import com.example.orangetest.model.VacationHistory;
import com.example.orangetest.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VacationHistoryService {
    private VacationHistoryDao vacationHistoryDao;
    private EmployeeDao employeeDao;

    @Autowired
    public VacationHistoryService(VacationHistoryDao vacationHistoryDao,
                                  EmployeeDao employeeDao) {
        this.vacationHistoryDao = vacationHistoryDao;
        this.employeeDao = employeeDao;
    }

    public VacationHistory addVacation(VacationHistory vacationHistory) {
        long vacationDuration = Util.calculateDuration(vacationHistory.getStartDate(), vacationHistory.getEndDate());
        Employee employee = vacationHistory.getEmployee();
        if(Util.validateVacation(employee.getRemainingBalance(),vacationDuration)){
          vacationHistory =  vacationHistoryDao.save(vacationHistory);
          employee.setRemainingBalance(Util.calculateRemainingBalance(
                  employee.getRemainingBalance()
                  ,vacationDuration));
          employeeDao.save(employee);
      }
      return vacationHistory;
    }
}
