package com.ymagis.appraisal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class AppraisalApplication implements CommandLineRunner{

	
    public static void main(String[] args) {
        SpringApplication.run(AppraisalApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Skils skils = new Skils("tesst");
//		MeaningSkils meaningSkils = new MeaningSkils(1, "desciption test");
//		meaningSkils.setSkil(skils);
//		skilsRepository.save(skils);
//		skilsRepository.save(new Skils("Team Spirit"));
	}
}
