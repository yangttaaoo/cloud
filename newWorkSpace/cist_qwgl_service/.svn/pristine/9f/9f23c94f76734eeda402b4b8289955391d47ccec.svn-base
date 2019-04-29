package com.cist.qwgl.qwgzt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.leavemanagment.model.DeptInfo;
import com.cist.qwgl.qwgzt.mapper.QwgztMapper;
import com.cist.qwgl.qwgzt.model.CarInfo;
import com.cist.qwgl.qwgzt.model.Need;
import com.cist.qwgl.qwgzt.model.PbglPolice;
import com.cist.qwgl.qwgzt.model.Police;
import com.cist.qwgl.qwgzt.model.PoliceCar;
import com.cist.qwgl.qwgzt.service.QwgztService;
@Service
public class QwgztSeviceImpl implements QwgztService{
	@Autowired
	private QwgztMapper mapper;

	@Override
	public Set<Need> queryNeed(HashMap<String, Object> map) {
		return mapper.queryNeed(map);
	}

	@Override
	public List<CarInfo> queryCar(String cx) {
		return mapper.queryCar(cx);
	}

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public List<Police> selectPolice(HashMap<String, Object> map) {
		return mapper.selectPolice(map);
	}

	@Override
	public List<PoliceCar> selectPoliceCarCount(HashMap<String, Object> map) {
		return mapper.selectPoliceCarCount(map);
	}

	@Override
	public List<PbglPolice> selectPbglPolice(String today) {
		return mapper.selectPbglPolice(today);
	}

	@Override
	public List<String> querydepts() {
		return mapper.querydepts();
	}


}
