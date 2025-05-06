package com.accenture.multidb.personal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "person")
public class Person {

    @Id
    private String ssn;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String address;

    public Person() { }

    public Person(String ssn, String firstName, String lastName, LocalDate dob, String address) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
    }

    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
