package com.example.orangetest.model;

import com.example.orangetest.util.LocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "VACATION_HISTORY")

public class VacationHistory implements Serializable {
   @Id
   @GeneratedValue
    private Long historyId;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_DATE")
//    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
//    @JsonDeserialize(using=LocalDateDeserializer.class)
    private LocalDate startDate;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_DATE")
//    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
//    @JsonDeserialize(using= LocalDateDeserializer.class)
   private LocalDate endDate;

    @Transient
   private int duration;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    public VacationHistory() {
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
