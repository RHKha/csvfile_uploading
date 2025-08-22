package com.example.simple_crud.repository;

import com.example.simple_crud.model.CreditReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditReportRepository extends JpaRepository<CreditReport, Long> {

}
