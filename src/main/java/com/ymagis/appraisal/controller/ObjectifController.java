package com.ymagis.appraisal.controller;

import com.ymagis.appraisal.entities.AnnualSession;
import com.ymagis.appraisal.entities.ApEmploye;
import com.ymagis.appraisal.entities.ApObjEmp;
import com.ymagis.appraisal.entities.Employe;
import com.ymagis.appraisal.repository.AnnualSessionRepository;
import com.ymagis.appraisal.repository.ApEmployeRepository;
import com.ymagis.appraisal.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ObjectifController {

    @Autowired
    private ApEmployeRepository apEmployeRepository;

    @Autowired
    private AnnualSessionRepository annualSessionRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @GetMapping(value = "/Objectifs")
    public Set<ApObjEmp> listObjectifs(@RequestParam("year") String year, @RequestParam("idEmp") Long idEmp) {
        AnnualSession annualSession = annualSessionRepository.findAnnualSessionByLabel(year);
        Employe employe = employeRepository.findEmployeByIdEmp(idEmp);
        ApEmploye apEmploye = apEmployeRepository.findApEmployeByAnnualSessionAndEmploye(annualSession, employe);
        Set<ApObjEmp> apObjEmps = apEmploye.getApObjEmps();
        return apObjEmps;
    }

}
