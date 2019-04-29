package com.cist.controlCarAudit.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.controlCarAudit.mapper.ControlCarAuditMapper;
import com.cist.controlCarAudit.service.ControlCarAuditService;

@Service
public class ControlCarAuditServiceImpl implements ControlCarAuditService {
	@Autowired
	private ControlCarAuditMapper mapper;

	@Override
	public int AuditControlCar(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		return mapper.AuditControlCar(param);
	}

}
