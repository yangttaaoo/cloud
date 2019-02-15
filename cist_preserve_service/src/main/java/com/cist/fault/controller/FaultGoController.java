package com.cist.fault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.fault.service.FaultGoService;

@RestController
@RequestMapping("fault")
public class FaultGoController {
	
	@Autowired
	private FaultGoService fGoService;
	
	
	
}
