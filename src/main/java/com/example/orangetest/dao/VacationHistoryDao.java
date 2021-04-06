package com.example.orangetest.dao;

import com.example.orangetest.model.VacationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationHistoryDao extends JpaRepository<VacationHistory,Long > {

}
