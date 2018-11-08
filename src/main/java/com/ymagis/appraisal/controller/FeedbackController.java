package com.ymagis.appraisal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymagis.appraisal.entities.FeedBack;
import com.ymagis.appraisal.repository.FeedbackRepository;

@RestController
@CrossOrigin
public class FeedbackController {

	@Autowired
	private FeedbackRepository repository;

	@GetMapping(value = "/feedbacks")
	public List<FeedBack> getFeedBacks() {
		return repository.findAll();

	}

	@RequestMapping(method = RequestMethod.POST, value = "/feedbacks/save")
	public FeedBack save(@RequestBody FeedBack model) {
		repository.save(model);
		return model;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/feedbacks/update/{id}")
	public FeedBack update(@RequestBody FeedBack model, @PathVariable("id") Long id) {
		model.setIdFdBack(id);
		repository.save(model);
		return model;
	}

}
