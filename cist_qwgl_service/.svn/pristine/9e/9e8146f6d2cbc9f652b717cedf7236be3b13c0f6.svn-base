package com.cist.dwqwkhcx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cist.dwqwkhcx.model.QWAppraiseFeedbackResponse;
import com.cist.dwqwkhcx.model.QwAssessmentAttachment;
import com.cist.dwqwkhcx.model.Qw_Opertion_Log;
import com.cist.frame.page.PageInfo;

@Service(value="DwqwcxServiceImpl")
public interface DwqwcxService {

	Object selectAllpageList(Map<String,Object> map,PageInfo p);
	
	List<QwAssessmentAttachment> selectList(Map<String, Object> map);
	
	/**
	 * 查询反馈信息详情
	 * 
	 * @param map
	 * @return
	 */
	List<QWAppraiseFeedbackResponse> selectResponse(Map<String, Object> map);
	
	List<Qw_Opertion_Log> selectLog(Map<String, Object> map);
}
