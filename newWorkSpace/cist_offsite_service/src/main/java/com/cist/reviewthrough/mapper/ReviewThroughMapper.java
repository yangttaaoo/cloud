package com.cist.reviewthrough.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.reviewthrough.model.Creason;

public interface ReviewThroughMapper {
	
	List<TblOffeEvdiInfo> reviewThroughpageList(HashMap<String,Object> map);
	Integer updateByWfpk(HashMap<String,Object> map);
	List<Creason> selectByCReasonInfo();
}
