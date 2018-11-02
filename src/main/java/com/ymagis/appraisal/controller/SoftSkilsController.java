package com.ymagis.appraisal.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ymagis.appraisal.dao.ApSoftSkillRepository;
import com.ymagis.appraisal.dao.LevelRepository;
import com.ymagis.appraisal.dao.SoftSkilsRepository;
import com.ymagis.appraisal.entities.ApEmploye;
import com.ymagis.appraisal.entities.ApSoftSkill;
import com.ymagis.appraisal.entities.Level;
import com.ymagis.appraisal.entities.SoftSkill;

@RestController
@CrossOrigin
public class SoftSkilsController {

	@Autowired
	private SoftSkilsRepository skilsRepository;

	@Autowired
	private LevelRepository LevelRepository;
	@Autowired
	private ApSoftSkillRepository apSoftSkillRepository;
	// ajouter skils
	@RequestMapping(method = RequestMethod.POST, value = "/skils/save")
	public SoftSkill saveSkils(@RequestBody SoftSkill skils) {
		SoftSkill softSkill = skilsRepository.getsoftSkill(skils.getLabel());
		if(softSkill != null) throw new RuntimeException("labell "+softSkill.getLabel()+" existe deja");
		else if(skils.getCode() == null)
			throw new RuntimeException("vous devez mentionner type ");
		else {
		skilsRepository.save(skils);
		
		return skils;
		}
	}
	@RequestMapping(method = RequestMethod.POST, value = "/skilsLevel/save")
	public SoftSkill saveSkilslevel(@RequestBody SoftSkill skils) {
		Optional<SoftSkill> skill = skilsRepository.findById(skils.getIdSoftSkill());
		for(Level level : skils.getLevels())
			if(((level.getIdLevel() == null))&&(skils.getLevels().size()!= 0)) {
			for(Level level2 : skils.getLevels())
				if((level.getDegree() == level2.getDegree())&&(level2.getIdLevel() != null))
					 throw new RuntimeException("level  "+level.getDegree()+" existe deja");
				else 
					level.setSoftSkill(skils);
			}else{
				for(Level levl : skill.get().getLevels())
					if((level.getDegree() == levl.getDegree())&&(level.getIdLevel() != levl.getIdLevel()))
						throw new RuntimeException("level  "+level.getDegree()+" existe deja");
					else
				       level.setSoftSkill(skils);
			}

		skilsRepository.save(skils);
		
		return skils;
	}
	// recuperer skils by id
	@RequestMapping(method = RequestMethod.GET, value = "/skils/{id}")
	public SoftSkill getSkils(@PathVariable Long id) {
		Optional<SoftSkill> skils = skilsRepository.findById(id);
		return skils.get();
	}

	// recuperer skils
	@RequestMapping(value = "/skils", method = RequestMethod.GET)
	public List<SoftSkill> getSkils() {
		
		return skilsRepository.findAll();
	}
	@RequestMapping(value = "/skill", method = RequestMethod.GET)
	public Page<SoftSkill> getSoftSkill(
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		return skilsRepository.getoftSkill(PageRequest.of(page, size));
	}
	// update skils
	@RequestMapping(value = "/skils/{id}", method = RequestMethod.PUT)
	public SoftSkill updateSkils(@PathVariable Long id, @RequestBody SoftSkill skils) {
		Optional<SoftSkill> softSkill = skilsRepository.findById(skils.getIdSoftSkill());
		for(Level level : skils.getLevels())
			for(Level level2 : softSkill.get().getLevels())
				if((level.getDegree() == level2.getDegree())&&((level.getIdLevel() != level2.getIdLevel())))
					 throw new RuntimeException("level  "+level.getDegree()+" existe deja");
				else
			{

			level.setSoftSkill(skils);
			
			
			}
		skilsRepository.save(skils);
		return skils;
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/skils/{id}/update")
	public SoftSkill SkilsUpdate(@PathVariable Long id,@RequestBody SoftSkill skils) {
		SoftSkill softSkill = skilsRepository.getsoftSkill(skils.getLabel());
		if(skils.getIdSoftSkill() != softSkill.getIdSoftSkill()) {
			if(softSkill != null) throw new RuntimeException("labell "+softSkill.getLabel()+" existe deja");
		}
		
		for(Level level : skils.getLevels())
			level.setSoftSkill(skils);
skilsRepository.save(skils);
return skils;
	}
	@RequestMapping(value = "/skils/{id}/meaning/{idm}", method = RequestMethod.PUT)
	public SoftSkill updateSkilsLevel(@PathVariable Long id,@PathVariable Long idm, @RequestBody SoftSkill skils) {
		SoftSkill softSkill = skilsRepository.getsoftSkill(skils.getLabel());
		Optional<SoftSkill> skill = skilsRepository.findById(id);
		if((skill.get().getLabel() != skils.getLabel())&&(softSkill != null))
			throw new RuntimeException("labell "+softSkill.getLabel()+" existe deja");
		else {

		skilsRepository.save(skils);
		}
		return skils;
	}
	
	//********************************************************************************//

	@RequestMapping(method = RequestMethod.GET, value = "/meaning/{id}")
	public Level getLevel(@PathVariable Long id) {
		
		Optional<Level> level =  LevelRepository.findById(id);

		return level.get();
	}

	

	@RequestMapping(method = RequestMethod.GET, value = "/skils/{id}/meaning/{idM}")
	public SoftSkill getmeanig(@PathVariable Long id,@PathVariable Long idM) {
		Optional<SoftSkill> skils = skilsRepository.findById(id);
		skils.get().getLevels().clear();
		Optional<Level> level =  LevelRepository.findById(idM);
		Set<Level> listlevel = new HashSet<>();
		listlevel.add(level.get());	
		skils.get().setLevels(listlevel);;
		return skils.get();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/apskils/save")
	public ApSoftSkill saveAppsoft(@RequestBody ApSoftSkill apSoftSkill) {

		ApEmploye apEmploye = new ApEmploye();
		apSoftSkill.setApEmploye(apEmploye);
		apSoftSkillRepository.save(apSoftSkill);
		return apSoftSkill;
	}
	
	// recuperer skils
	@RequestMapping(value = "/apskils", method = RequestMethod.GET)
	public List<ApSoftSkill> getapSkils() {
		return apSoftSkillRepository.findAll();
	}
}
