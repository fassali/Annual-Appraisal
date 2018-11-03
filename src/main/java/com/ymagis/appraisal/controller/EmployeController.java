package com.ymagis.appraisal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymagis.appraisal.entities.Employe;
import com.ymagis.appraisal.repository.EmployeRepository;

@RestController
public class EmployeController {
	@Autowired
	private EmployeRepository employeRepository;
	
	// ajouter un nouvel employé
	@RequestMapping(method = RequestMethod.POST, value = "/employers/add")
	public Employe saveEmployeur(@RequestBody Employe employeur) {
		if (employeur.getLastName() == null || employeur.getFirstName() == null || employeur.getDateEntry() == null
				|| employeur.getTeam() == null || employeur.getPosition() == null || employeur.getEmail() == null
				|| employeur.getUsername() == null) {
			throw new RuntimeException(
					"Vous devez saisir tous les éléments d'un nouvel employé avant l'enregistrement, Veuillez réessayer");
		}
		employeRepository.save(employeur);
		return employeur;
	}
	// chercher un employé par "username"
	@RequestMapping(method = RequestMethod.GET, value = "/employerLogin/{username}")
	public Employe getEmployer(@PathVariable String username) {
		Employe employer = employeRepository.findByUsername(username);
		return employer;
	}
	
	
}
