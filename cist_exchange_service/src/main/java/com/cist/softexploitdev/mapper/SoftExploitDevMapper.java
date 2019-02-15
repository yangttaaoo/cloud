package com.cist.softexploitdev.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.visitinterface.model.SjgxDevCompany;

public interface SoftExploitDevMapper {
	public List<SjgxDevCompany> querylist(HashMap<String,Object> map);
	public Integer add(HashMap<String,Object> map);
	public Integer queryid();
	public Integer update(HashMap<String,Object> map);
	public Integer del(HashMap<String,Object> map);
}
