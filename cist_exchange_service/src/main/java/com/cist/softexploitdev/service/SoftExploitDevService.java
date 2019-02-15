package com.cist.softexploitdev.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.visitinterface.model.SjgxDevCompany;

public interface SoftExploitDevService {
	public Object querylistpageList(HashMap<String,Object> map,PageInfo info);
	public Integer add(HashMap<String,Object> map);
	public Integer queryid();
	public Integer update(HashMap<String,Object> map);
	/**
	 * 删除接口开发单位信息
	 * @param map
	 * @return
	 */
	public Integer del(HashMap<String,Object> map);
}
