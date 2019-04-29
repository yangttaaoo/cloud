package com.cist.dwqwkhcx.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.dwqwkhcx.model.QWAppraiseFeedbackResponse;
import com.cist.dwqwkhcx.model.QwAssessmentAttachment;
import com.cist.dwqwkhcx.model.Qw_Opertion_Log;
import com.cist.dwqwkhcx.model.Qw_company;


public interface DwqwcxMapper {

	List<Qw_company> selectCheckAll(Map<String, Object> map);
	
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
