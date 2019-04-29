package com.cist.yjgl.ljqygl.mapper;

import java.util.HashMap;
import java.util.List;
import com.cist.yjgl.ljqygl.model.Jcbk_Ljqy;

public interface LjqyglMapper {
	public List<Jcbk_Ljqy> queryljqygl(HashMap<String, Object> map);
	public Integer addljqygl(HashMap<String, Object> map);
	public Integer delljqygl(HashMap<String, Object> map);
	public Integer updateljqygl(HashMap<String, Object> map);
	public String querydept_name(String dept_pk);
	public String querypolicename(String sypi_code);
}
