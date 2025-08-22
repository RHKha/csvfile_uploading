package com.example.simple_crud.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "credit_reports")
public class CreditReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "date_opened")
    private LocalDate dateOpened;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

    @Column(name = "high_credit")
    private BigDecimal highCredit;

    @Column(name = "total_outstanding")
    private BigDecimal totalOutstanding;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "address_1")
    private String address1;

    @Column(name = "address_2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "tax_id_ssn")
    private String taxIdSsn;

    @Column(name = "terms")
    private String terms;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getReportDate() { return reportDate; }
    public void setReportDate(LocalDate reportDate) { this.reportDate = reportDate; }

    public LocalDate getDateOpened() { return dateOpened; }
    public void setDateOpened(LocalDate dateOpened) { this.dateOpened = dateOpened; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public BigDecimal getCreditLimit() { return creditLimit; }
    public void setCreditLimit(BigDecimal creditLimit) { this.creditLimit = creditLimit; }

    public BigDecimal getHighCredit() { return highCredit; }
    public void setHighCredit(BigDecimal highCredit) { this.highCredit = highCredit; }

    public BigDecimal getTotalOutstanding() { return totalOutstanding; }
    public void setTotalOutstanding(BigDecimal totalOutstanding) { this.totalOutstanding = totalOutstanding; }

    public String getBusinessName() { return businessName; }
    public void setBusinessName(String businessName) { this.businessName = businessName; }

    public String getAddress1() { return address1; }
    public void setAddress1(String address1) { this.address1 = address1; }

    public String getAddress2() { return address2; }
    public void setAddress2(String address2) { this.address2 = address2; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public String getTaxIdSsn() { return taxIdSsn; }
    public void setTaxIdSsn(String taxIdSsn) { this.taxIdSsn = taxIdSsn; }

    public String getTerms() { return terms; }
    public void setTerms(String terms) { this.terms = terms; }
}