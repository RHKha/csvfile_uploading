package com.example.simple_crud.controller;

import com.example.simple_crud.model.CreditReport;
import com.example.simple_crud.repository.CreditReportRepository;
import org.springframework.web.bind.annotation.RestController;
import com.example.simple_crud.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@RequestMapping("/api/credit_reports")
public class CSVFileController {
    @Autowired
    private CSVService csvService;

    @Autowired
    private CreditReportRepository repository;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadCSV(@RequestParam("file") MultipartFile file) {
        List<String> errors = csvService.uploadCSV(file);
        if (errors.isEmpty()) {
            return ResponseEntity.ok("Upload successful");
        }
        return ResponseEntity.badRequest().body(errors);
    }

    @GetMapping("/history")
    public List<CreditReport> getHistory() {
        return repository.findAll();
    }
}
