package com.accenture.multidb.controller;

import com.accenture.multidb.personal.PersonRepository;
import com.accenture.multidb.employment.EmploymentRepository;
import com.accenture.multidb.financial.FinancialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class LookupController {

    @Autowired private PersonRepository personRepo;
    @Autowired private EmploymentRepository empRepo;
    @Autowired private FinancialRepository finRepo;

    @GetMapping("/{ssn}/{category}")
    public ResponseEntity<?> lookup(
            @PathVariable String ssn,
            @PathVariable String category) {

        // Log to check if the method is being invoked
        System.out.println("SSN: " + ssn + ", Category: " + category);

        switch (category.toLowerCase()) {
            case "personal":
                return ResponseEntity.of(personRepo.findById(ssn));

            case "employment":
                return ResponseEntity.ok(empRepo.findBySsn(ssn));

            case "financial":
                return ResponseEntity.ok(finRepo.findBySsn(ssn));

            default:
                return ResponseEntity.badRequest()
                        .body("Unknown category: " + category);
        }
    }
}
