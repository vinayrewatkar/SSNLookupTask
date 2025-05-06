package com.accenture.multidb.employment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "employment")
public class Employment {

    @Id
    @GeneratedValue
    private Long id;
    private String ssn;
    private String company;
    private String role;
    private LocalDate startDate;
    private LocalDate endDate;

    public Employment() { }

    public Employment(Long id, String ssn, String company, String role,
                      LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.ssn = ssn;
        this.company = company;
        this.role = role;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
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
}
