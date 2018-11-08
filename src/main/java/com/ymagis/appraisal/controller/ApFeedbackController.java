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

import com.ymagis.appraisal.entities.ApFeedBack;
import com.ymagis.appraisal.entities.FeedBack;
import com.ymagis.appraisal.repository.ApFeedbackRepository;
import com.ymagis.appraisal.repository.FeedbackRepository;

@RestController
@CrossOrigin
public class ApFeedbackController {

	@Autowired
	private ApFeedbackRepository repository;

	@GetMapping(value = "/apfeedbacks")
	public List<ApFeedBack> getApFeedBacks() {
		return repository.findAll();

	}

	@RequestMapping(method = RequestMethod.POST, value = "/apfeedbacks/save")
	public ApFeedBack save(@RequestBody ApFeedBack model) {
		repository.save(model);
		return model;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/apfeedbacks/update/{id}")
	public ApFeedBack update(@RequestBody ApFeedBack model, @PathVariable("id") Long id) {
		model.setIdApFdBach(id);
		repository.save(model);
		return model;
	}

}
