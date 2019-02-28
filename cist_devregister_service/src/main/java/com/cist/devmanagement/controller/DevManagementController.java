package com.cist.devmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cist.devmanagement.service.DevManagementService;

@RestController
@RequestMapping("devManagement")
public class DevManagementController {

	@Autowired
	DevManagementService service;

}
