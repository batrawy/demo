package com.example.orangetest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {
   @Id
   @GeneratedValue
    private Long id;
   @Column(name = "name")
    private String name;

    @Column(name = "TOTAL_VACATION_BALANCE")
    private long totalVacationBalance;

    @Column(name = "REMAINING_BALANCE")
    private long remainingBalance;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VacationHistory> vacationHistoryList = new ArrayList<>();

    public Employee(String name, long totalVacationBalance,long remainingBalance) {

        this.name = name;
        this.totalVacationBalance = totalVacationBalance;
        this.remainingBalance = remainingBalance;
    }
    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<VacationHistory> getVacationHistoryList() {
        return vacationHistoryList;
    }

    public void setVacationHistoryList(List<VacationHistory> vacationHistoryList) {
        this.vacationHistoryList = vacationHistoryList;
    }
}
