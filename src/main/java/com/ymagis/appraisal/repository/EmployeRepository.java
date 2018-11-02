package com.ymagis.appraisal.repository;

import com.ymagis.appraisal.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

    public Employe findEmployeByIdEmp(@Param("idEmp") Long idEmp);
}
