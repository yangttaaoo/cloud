package com.cist.kreis.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.kreis.mapper.KreisMapper;
import com.cist.kreis.model.KreisInfo;
import com.cist.kreis.model.KreisLevelInfo;
import com.cist.kreis.model.TbekInfo;
import com.cist.kreis.service.KreisService;


@Service("KreisService")
public class KreisServiceImpl implements KreisService{
	
	@Autowired
	private KreisMapper mapper;

	public Object kerisInfopageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.kerisInfopageList(map);
	}

	public KreisInfo getTbekname(Integer tbek_parent) {
		return mapper.getTbekname(tbek_parent);
	}

	public int delKreis(HashMap<String,Object> modelMap) {
		return mapper.delKreis(modelMap);
	}

	public List<KreisLevelInfo> kreisLevelList() {
		return mapper.kreisLevelList();
	}

	public int addKreis(HashMap<String, Object> map) {
		return mapper.addKreis(map);
	}

	public int editKreis(HashMap<String, Object> map) {
		return mapper.editKreis(map);
	}

	public List<TbekInfo> tbek_infolist(Integer dept_superior) {
		return mapper.tbek_infolist(dept_superior);
	}

}
