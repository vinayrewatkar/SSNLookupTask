package com.accenture.multidb.financial;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "financial")
public class Financial {

    @Id
    @GeneratedValue
    private Long id;
    private String ssn;
    private String bankName;
    private BigDecimal accountBalance;
    private Integer creditScore;

    public Financial() { }

    public Financial(Long id, String ssn, String bankName,
                     BigDecimal accountBalance, Integer creditScore) {
        this.id = id;
        this.ssn = ssn;
        this.bankName = bankName;
        this.accountBalance = accountBalance;
        this.creditScore = creditScore;
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

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Integer getCreditScore() {
        return creditScore;
    }
    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }
}
