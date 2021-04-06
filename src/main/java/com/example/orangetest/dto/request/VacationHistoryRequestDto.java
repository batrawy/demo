package com.example.orangetest.dto.request;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

public class VacationHistoryRequestDto {
    private Long userId;
    //    private LocalDate startDate;
//    private LocalDate endDate;
    @NotNull
    private String startDate;
    @NotNull
    private String endDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
