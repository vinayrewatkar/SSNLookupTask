package com.accenture.multidb.financial;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FinancialRepository extends JpaRepository<Financial, Long> {
    List<Financial> findBySsn(String ssn);
}
