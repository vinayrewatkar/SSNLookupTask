package com.accenture.multidb.employment;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmploymentRepository extends JpaRepository<Employment, Long> {
    List<Employment> findBySsn(String ssn);
}
