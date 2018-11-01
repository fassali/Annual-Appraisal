package com.ymagis.appraisal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ymagis.appraisal.entities.ApHardSkill;
import com.ymagis.appraisal.repository.ApHardSkillRepository;

@RestController
public class HardSkillController {

	@Autowired
	private ApHardSkillRepository apHardSkillRepository;

	@GetMapping(value = "/hard_skills")
	public List<ApHardSkill> getHardSkills(@RequestParam("idApEmp") Long idApEmp) {
		return apHardSkillRepository.namedFindAllApHardSkillsByApEmploye(idApEmp);
	}
}
