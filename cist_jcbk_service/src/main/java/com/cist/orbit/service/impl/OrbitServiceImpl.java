package com.cist.orbit.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.frame.page.PageInfo;
import com.cist.orbit.mapper.OrbitMapper;
import com.cist.orbit.model.CRoadSegitemInfo;
import com.cist.orbit.model.C_road_item;
import com.cist.orbit.model.Depart_info;
import com.cist.orbit.model.Sys_frm_code;
import com.cist.orbit.service.OrbitService;

@Service("OrbitService")
public class OrbitServiceImpl implements OrbitService{


	@Autowired
	private OrbitMapper mapper;
	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo p) {
		return mapper.list(map);
	}
	@Override
	public List<Sys_frm_code> selectSysFrmCode(String fct_code) {
		return mapper.selectSysFrmCode(fct_code);
	}
	@Override
	public List<C_road_item> selectRoadList(HashMap<String, Object> map) {
		return mapper.selectRoadList(map);
	}
	@Override
	public List<Depart_info> yijicdepartinfo(HashMap<String, Object> map) {
		return mapper.yijicdepartinfo(map);
	}
	@Override
	public List<Depart_info> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}
	@Override
	public List<Depart_info> clickdepartinfo(String dept_superior) {
		return mapper.clickdepartinfo(dept_superior);
	}
	@Override
	public List<Depart_info> kakou(String tbec_kkbh) {
		return mapper.kakou(tbec_kkbh);
	}
	@Override
	public List<Depart_info> kakouxiabu(HashMap<String, Object> map) {
		return mapper.kakouxiabu(map);
	}
	@Override
	public CRoadSegitemInfo selectLukou(HashMap<String, Object> map) {
		return mapper.selectLukou(map);
	}

}
