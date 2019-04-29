package com.cist.dwqwkhcx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.dwqwkhcx.mapper.DwqwcxMapper;
import com.cist.dwqwkhcx.model.QWAppraiseFeedbackResponse;
import com.cist.dwqwkhcx.model.QwAssessmentAttachment;
import com.cist.dwqwkhcx.model.Qw_Opertion_Log;
import com.cist.dwqwkhcx.service.DwqwcxService;
import com.cist.frame.page.PageInfo;

@Service
public class DwqwcxServiceImpl implements DwqwcxService{
	
	@Autowired
	private DwqwcxMapper mapper;

	@Override
	public Object selectAllpageList(Map<String, Object> map, PageInfo p) {
		return mapper.selectCheckAll(map);
	}

	@Override
	public List<QwAssessmentAttachment> selectList(Map<String, Object> map) {
		return mapper.selectList(map);
	}

	@Override
	public List<QWAppraiseFeedbackResponse> selectResponse(Map<String, Object> map) {
		return mapper.selectResponse(map);
	}

	@Override
	public List<Qw_Opertion_Log> selectLog(Map<String, Object> map) {
		return mapper.selectLog(map);
	}
	
}
