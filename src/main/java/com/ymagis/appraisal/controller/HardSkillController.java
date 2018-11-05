package com.ymagis.appraisal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ymagis.appraisal.entities.ApHardSkill;
import com.ymagis.appraisal.repository.HardSkillRepository;

@RestController
@CrossOrigin
public class HardSkillController {

	@Autowired
	private HardSkillRepository hardSkillRepository;

	@GetMapping(value = "/competencies")
	public List<ApHardSkill> getHardSkills(@RequestParam("idApEmp") Long idApEmp) {
		return hardSkillRepository.namedFindAllApHardSkillsByApEmploye(idApEmp);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/competencies/save")
	public ApHardSkill saveApHardSkill(@RequestBody ApHardSkill hardSkill) {
		hardSkillRepository.save(hardSkill);
		return hardSkill;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/competencies/update")
	public ApHardSkill updateApHardSkill(@RequestBody ApHardSkill hardSkill) {
		hardSkillRepository.save(hardSkill);
		return hardSkill;
	}

}
