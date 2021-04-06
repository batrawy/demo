package com.example.orangetest.dto.response;

import com.example.orangetest.model.VacationHistory;
import com.example.orangetest.util.Util;

import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VacationHistoryDto {
private Long hisoryId;
private LocalDate startDate;
private LocalDate endDate;
private long duration;

public static VacationHistoryDto convert (VacationHistory vacationHistory){
    if(vacationHistory == null)
        return null;
    VacationHistoryDto dto= new VacationHistoryDto();
    dto.setEndDate(vacationHistory.getEndDate());
    dto.setStartDate(vacationHistory.getStartDate());
    dto.setHisoryId(vacationHistory.getHistoryId());
    dto.setDuration(Util.calculateDuration(vacationHistory.getStartDate(),vacationHistory.getEndDate()));
    return dto;
}


    public static List<VacationHistoryDto> convert (List<VacationHistory> vacationHistoryList){
        List<VacationHistoryDto> dtoList = new ArrayList<>();
        for (VacationHistory vacationHistory : vacationHistoryList){
            dtoList.add(convert(vacationHistory));
        }
        return dtoList;
    }

    public Long getHisoryId() {
        return hisoryId;
    }

    public void setHisoryId(Long hisoryId) {
        this.hisoryId = hisoryId;
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

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
