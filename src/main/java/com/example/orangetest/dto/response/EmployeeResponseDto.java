package com.example.orangetest.dto.response;

import com.example.orangetest.model.Employee;
import com.example.orangetest.model.VacationHistory;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class EmployeeResponseDto {
    private long employeeId;
private String name;
    private long totalVacationBalance;
    private long remainingBalance;

private List <VacationHistoryDto> vacationHistoryDtoList ;

    public static EmployeeResponseDto convert(Employee employee) {
      if(employee == null)
          return null;
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setEmployeeId(employee.getId());
        employeeResponseDto.setName(employee.getName());
        employeeResponseDto.setRemainingBalance(employee.getRemainingBalance());
        employeeResponseDto.setTotalVacationBalance(employee.getTotalVacationBalance());
        employeeResponseDto.setVacationHistoryDtoList(VacationHistoryDto.convert(employee.getVacationHistoryList()));
        return employeeResponseDto;
    }


    public static List<EmployeeResponseDto> convert(List<Employee> employeeList) {
        List<EmployeeResponseDto> employeeResponseDtoList = new ArrayList<>();
        for (Employee employee : employeeList) {
            employeeResponseDtoList.add(convert(employee));
        }
        return employeeResponseDtoList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VacationHistoryDto> getVacationHistoryDtoList() {
        return vacationHistoryDtoList;
    }

    public void setVacationHistoryDtoList(List<VacationHistoryDto> vacationHistoryDtoList) {
        this.vacationHistoryDtoList = vacationHistoryDtoList;
    }

    public long getTotalVacationBalance() {
        return totalVacationBalance;
    }

    public void setTotalVacationBalance(long totalVacationBalance) {
        this.totalVacationBalance = totalVacationBalance;
    }

    public long getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(long remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
}
