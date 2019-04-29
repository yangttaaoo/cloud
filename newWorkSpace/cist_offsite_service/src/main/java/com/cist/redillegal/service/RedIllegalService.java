package com.cist.redillegal.service;

import java.util.HashMap;

import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;

public interface RedIllegalService {
	  /**
		 * 多条件查询红名单违法数据
		 */
	  Object redIllegalpageList(HashMap<String,Object> map,PageInfo p);
}
