package com.example.simple_crud.service;

import com.example.simple_crud.model.CreditReport;
import com.example.simple_crud.repository.CreditReportRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
public class CSVService {

    @Autowired
    private CreditReportRepository repository;

    public List<String> uploadCSV(MultipartFile file) {
        List<String> errors = new ArrayList<>();

        try (Reader reader = new InputStreamReader(file.getInputStream());
             CSVReader csvReader = new CSVReader(reader)) {

            String[] line;
            int rowNumber = 0;
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yy");

            while ((line = csvReader.readNext()) != null) {
                rowNumber++;
                if (rowNumber == 1) continue; // skip header

                if (line.length < 14) {
                    errors.add("Row " + rowNumber + " has missing columns");
                    continue;
                }

                try {
                    CreditReport report = new CreditReport();

                    // Date parsing
                    report.setReportDate(LocalDate.parse(line[0], dateFormatter));
                    report.setDateOpened(LocalDate.parse(line[1], dateFormatter));

                    // Text fields
                    report.setAccountNumber(line[2]);
                    report.setBusinessName(line[6]);
                    report.setAddress1(line[7]);
                    report.setAddress2(line[8]);
                    report.setCity(line[9]);
                    report.setState(line[10]);
                    report.setZipCode(line[11]);
                    report.setTaxIdSsn(line[12]);
                    report.setTerms(line[13]);

                    // Numeric fields
                    report.setCreditLimit(new BigDecimal(line[3]));
                    report.setHighCredit(new BigDecimal(line[4]));
                    report.setTotalOutstanding(new BigDecimal(line[5]));

                    repository.save(report);
                } catch (Exception e) {
                    errors.add("Row " + rowNumber + " has invalid data: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            errors.add("CSV file parsing error: " + e.getMessage());
        }

        return errors;
    }
}
