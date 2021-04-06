package com.example.orangetest.controller;

import com.example.orangetest.dto.response.EmployeeResponseDto;
import com.example.orangetest.model.Employee;
import com.example.orangetest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/test")
    public String addCourse() {
        return"hellow";
    }

    @PostMapping("/employee")
    public ResponseEntity addEmployee (@RequestBody Employee employee){
        return ResponseEntity.ok().body(EmployeeResponseDto.convert(employeeService.addEmployee(employee)));
    }

    @GetMapping("/employee-filter/{name}")
    public ResponseEntity filterEmployee(@PathVariable String name){
        return ResponseEntity.ok().body(EmployeeResponseDto.convert(employeeService.filterByName(name)));
    }

}
