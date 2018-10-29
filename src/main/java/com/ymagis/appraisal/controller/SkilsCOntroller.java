package com.ymagis.appraisal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymagis.appraisal.dao.MeaningRepository;
import com.ymagis.appraisal.dao.SkilsRepository;
import com.ymagis.appraisal.model.MeaningSkils;
import com.ymagis.appraisal.model.Skils;

@RestController
@CrossOrigin
public class SkilsCOntroller {

	@Autowired
	private SkilsRepository skilsRepository;

	@Autowired
	private MeaningRepository meaningRepository;

	// ajouter skils
	@RequestMapping(method = RequestMethod.POST, value = "/skils/save")
	public Skils saveSkils(@RequestBody Skils skils) {
		for(MeaningSkils meaningSkils : skils.getMeaningSkils())
			{
			meaningSkils.setSkil(skils);
			}
		skilsRepository.save(skils);
		System.out.println(skilsRepository.findById(skils.getIdSkils()).get().getMeaningSkils().size());
		return skilsRepository.findById(skils.getIdSkils()).get();
	}

	// recuperer skils by id
	@RequestMapping(method = RequestMethod.GET, value = "/skils/{id}")
	public Skils getSkils(@PathVariable Long id) {
		Optional<Skils> skils = skilsRepository.findById(id);
		return skils.get();
	}

	// recuperer skils
	@RequestMapping(value = "/skils", method = RequestMethod.GET)
	public List<Skils> getSkils() {
		return skilsRepository.findAll();
	}

	// update skils
	@RequestMapping(value = "/skils/{id}", method = RequestMethod.PUT)
	public Skils updateSkils(@PathVariable Long id, @RequestBody Skils skils) {
		List<MeaningSkils> listmeaningSkils = skils.getMeaningSkils();
		for (MeaningSkils meaningSkils : listmeaningSkils)
			meaningSkils.setSkil(skils);
		skils.setMeaningSkils(listmeaningSkils);
		skilsRepository.save(skils);

		return skils;
	}

	
	//********************************************************************************//
	@RequestMapping(value = "/meanings", method = RequestMethod.GET)
	public List<MeaningSkils> liste() {
		return meaningRepository.findAll();
	}

	@RequestMapping(value = "/meanings/save", method = RequestMethod.POST)
	public MeaningSkils saveMeaning(@RequestBody MeaningSkils meaningSkils) {
		return meaningRepository.save(meaningSkils);
	}
	

	@RequestMapping(method = RequestMethod.GET, value = "/skils/{id}/meaning/{idM}")
	public Skils getmeanig(@PathVariable Long id,@PathVariable Long idM) {
		Optional<Skils> skils = skilsRepository.findById(id);
		skils.get().getMeaningSkils().clear();
		Optional<MeaningSkils> meaningSkils =  meaningRepository.findById(idM);
		ArrayList<MeaningSkils> meaning = new ArrayList<>();
		meaning.add(meaningSkils.get());	
		skils.get().setMeaningSkils(meaning);
		return skils.get();
	}
}
