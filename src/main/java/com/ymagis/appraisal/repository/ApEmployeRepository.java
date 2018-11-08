package com.ymagis.appraisal.repository;

import com.ymagis.appraisal.entities.AnnualSession;
import com.ymagis.appraisal.entities.ApEmploye;
import com.ymagis.appraisal.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApEmployeRepository extends JpaRepository<ApEmploye, Long> {

    @Query("select apEmp from ApEmploye apEmp where apEmp.annualSession = :annSess" +
            " and apEmp.employe = :emp")
    public ApEmploye findApEmployeByAnnualSessionAndEmploye(@Param("annSess")AnnualSession annualSession, @Param("emp")Employe employe);
    
    @Query("select s from AnnualSession  s where s.status  = 'en cour'")
    public AnnualSession findAnnualSession();

}
