package com.ymagis.appraisal.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.ymagis.appraisal.entities.*;
import com.ymagis.appraisal.repository.ApEmployeRepository;
import com.ymagis.appraisal.repository.EmployeRepository;
import com.ymagis.appraisal.repository.FeedbackRepository;
import com.ymagis.appraisal.service.IFeedBackService;
import com.ymagis.appraisal.vo.FeedBackVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import com.ymagis.appraisal.repository.ApFeedbackRepository;

@RestController
@CrossOrigin
public class ApFeedbackController {

	@Autowired
	private ApFeedbackRepository repository;

	@Autowired
	private ApEmployeRepository apEmployeRepository;

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Autowired
	private IFeedBackService feedBackService;

	@Autowired
	private EmployeRepository employeRepository;

	@GetMapping(value = "/apfeedbacks")
	public List<ApFeedBack> getApFeedBacks() {
		return repository.findAll();

	}

	@PostMapping(value = "/apfeedbacks/save")
	public ApFeedBack save(@RequestBody ApFeedBack model) {
		repository.save(model);
		return model;
	}

	@PutMapping(value = "/apfeedbacks/update/{id}")
	public ApFeedBack update(@RequestBody ApFeedBack model, @PathVariable("id") Long id) {
		model.setIdApFdBach(id);
		repository.save(model);
		return model;
	}

	@GetMapping(value = "/feedBackEmp")
	public Page<FeedBackVO> listFeedBack(@RequestParam("idApEmp") Long idApEmp,
										@RequestParam(name = "page", defaultValue = "0") int page,
										@RequestParam(name = "size", defaultValue = "10") int size) throws ParseException {
		//IFeedBackService feedBackService = new FeedBackService();
		ApEmploye apEmploye = apEmployeRepository.findApEmployeByIdApEmp(idApEmp);
		if(null == apEmploye){
			throw new RuntimeException("erreur interne");
		}
			//List<FeedBack> listFeedBack = new ArrayList<>(0);
			List<FeedBackVO> listFeedBack = new ArrayList<>(0);
			Set<ApFeedBack> apFeedBacks = apEmploye.getApFeedBacks();
			if(null != apFeedBacks && !apFeedBacks.isEmpty()){
				List<ApFeedBack> listFdb = new ArrayList<>(apFeedBacks);
				listFeedBack = feedBackService.fillFeedBackVOFromApFds(listFdb);
				Page<FeedBackVO> feedbackPage = new PageImpl<FeedBackVO>(listFeedBack, PageRequest.of(page, size, Sort.by("idFdb").ascending()), listFeedBack.size());
				return feedbackPage;
			}else {
				Page<FeedBackVO> feedbackPage = feedBackService.getFeedBacks(page, size);
				if (null == feedbackPage) {
					throw new RuntimeException("list of feedback is empty");
				} else {
					return feedbackPage;
				}
			}
}

	//Mettre à jour la mention rating et commenatire pour les objectifs de l'année dernière
	@PutMapping(value = "/saveApFeedbacks/{idApEmp}")
	public boolean saveApFeedb(@RequestBody List<FeedBackVO> listApFdb, @PathVariable("idApEmp") Long idApEmp) {
		ApEmploye apEmploye = apEmployeRepository.findApEmployeByIdApEmp(idApEmp);
		Employe employe = apEmploye.getEmploye();
		if(null == listApFdb || listApFdb.isEmpty()){
			throw new RuntimeException("list of feedbacks is empty");
		}else{
			Set<ApFeedBack> apFeedbacksEmp = apEmploye.getApFeedBacks();
			if(null != apFeedbacksEmp && !apFeedbacksEmp.isEmpty()){
				Set<ApFeedBack> apFeedBackEmp = feedBackService.fillApFdbFromVO(apFeedbacksEmp, listApFdb, apEmploye);
				List<ApEmploye> appEmpList =new ArrayList<> (employe.getApEmployes());
				for(int j = 0; j < appEmpList.size(); j++) {
					if(appEmpList.get(j).getIdApEmp()==idApEmp) {
						appEmpList.get(j).setApFeedBacks(apFeedBackEmp);
					}
				}
				Set<ApEmploye> apEmps = appEmpList.stream().collect(Collectors.toSet());
				employe.setApEmployes(apEmps);
				employeRepository.save(employe);
				//repository.saveAll(apFeedBackEmp);
			}else{
				Set<ApFeedBack> apFeedBackEmp = feedBackService.fillApFdbFromVO(null, listApFdb, apEmploye);
				List<ApEmploye> appEmpList =new ArrayList<> (employe.getApEmployes());
				for(int j = 0; j < appEmpList.size(); j++) {
					if(appEmpList.get(j).getIdApEmp()==idApEmp) {
						appEmpList.get(j).setApFeedBacks(apFeedBackEmp);
					}
				}
				Set<ApEmploye> apEmps = appEmpList.stream().collect(Collectors.toSet());
				employe.setApEmployes(apEmps);
				employeRepository.save(employe);
				//repository.saveAll(apFeedBackEmp);
			}
			return true;
		}
	}
}
