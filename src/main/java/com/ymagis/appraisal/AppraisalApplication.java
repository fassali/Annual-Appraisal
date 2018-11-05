package com.ymagis.appraisal;


import com.ymagis.appraisal.entities.AnnualSession;
import com.ymagis.appraisal.entities.ApEmploye;
import com.ymagis.appraisal.entities.ApObjEmp;
import com.ymagis.appraisal.entities.Employe;
import com.ymagis.appraisal.repository.AnnualSessionRepository;
import com.ymagis.appraisal.repository.ApEmployeRepository;
import com.ymagis.appraisal.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Set;


@SpringBootApplication
public class AppraisalApplication implements CommandLineRunner{


	
    public static void main(String[] args) {
        SpringApplication.run(AppraisalApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        /*AnnualSession annualSession = annualSessionRepository.findAnnualSessionByLabel("2018");
        Employe employe = employeRepository.findEmployeByIdEmp(1L);
        ApEmploye apEmploye = apEmployeRepository.findApEmployeByAnnualSessionAndEmploye(annualSession, employe);
        Set<ApObjEmp> apObjEmps = apEmploye.getApObjEmps();
        System.out.println(apObjEmps.size());*/
    }

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
////		Skils skils = new Skils("tesst");
////		MeaningSkils meaningSkils = new MeaningSkils(1, "desciption test");
////		meaningSkils.setSkil(skils);
////		skilsRepository.save(skils);
////		skilsRepository.save(new Skils("Team Spirit"));
//	}
}
