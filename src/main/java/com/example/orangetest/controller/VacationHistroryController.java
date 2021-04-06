package com.example.orangetest.controller;


import com.example.orangetest.dto.request.VacationHistoryRequestDto;
import com.example.orangetest.dto.response.VacationHistoryDto;
import com.example.orangetest.exception.ResourceNotFoundExcepation;
import com.example.orangetest.model.Employee;
import com.example.orangetest.model.VacationHistory;
import com.example.orangetest.service.EmployeeService;
import com.example.orangetest.service.VacationHistoryService;
import com.example.orangetest.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class VacationHistroryController {
    private VacationHistoryService vacationHistoryService;
    private EmployeeService employeeService;

    @Autowired
    public VacationHistroryController(VacationHistoryService vacationHistoryService,
                                      EmployeeService employeeService) {
        this.vacationHistoryService = vacationHistoryService;
        this.employeeService = employeeService;
    }


    @PostMapping("/vacation")
    public ResponseEntity addEmployeeVacation (@RequestBody VacationHistoryRequestDto requestDto){
        Optional<Employee>employeeOptional =  employeeService.getEmployee(requestDto.getUserId());
      if(employeeOptional.isPresent()) {
          VacationHistory vacationHistory = new VacationHistory();
          vacationHistory.setEmployee(employeeOptional.get());
          vacationHistory.setStartDate(Util.convertStringToLcalDate(requestDto.getStartDate()));
          vacationHistory.setEndDate(Util.convertStringToLcalDate(requestDto.getEndDate()));
          return ResponseEntity.ok().body(VacationHistoryDto.convert(vacationHistoryService.addVacation(vacationHistory)));
      }else {
          throw new ResourceNotFoundExcepation("No Existing Employee ");
      }
    }

}
