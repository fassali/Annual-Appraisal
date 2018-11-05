package com.ymagis.appraisal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymagis.appraisal.entities.ApObjEmp;
import com.ymagis.appraisal.repository.ApObjEmpRepository;

@RestController
public class ApObjEmpController {
	@Autowired
	private ApObjEmpRepository  apObjEmpRepository;
	
	
	// ajouter un nv obj
	@RequestMapping(method = RequestMethod.POST, value = "/objectives/add")
	public List<ApObjEmp> saveEmployeur(@RequestBody List<ApObjEmp>  objs) {
		for (int i = 0; i < objs.size(); i++) {
			ApObjEmp obj=objs.get(i);
			apObjEmpRepository.save(obj);
		}
		return objs;
	}

}
