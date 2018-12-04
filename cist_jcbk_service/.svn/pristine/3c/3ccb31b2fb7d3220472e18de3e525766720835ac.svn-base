package com.cist.warningmanagement.bayonet.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.warningmanagement.bayonet.mapper.BayonetMapper;
import com.cist.warningmanagement.bayonet.model.DeptInfo;
import com.cist.warningmanagement.bayonet.model.Qy_Bm;
import com.cist.warningmanagement.bayonet.model.Qylx;
import com.cist.warningmanagement.bayonet.service.BayonetService;
import com.cist.warningmanagement.controlcar.model.Kklx;
@Service
public class BayonetServiceImpl implements BayonetService {
@Autowired
private BayonetMapper mapper;
	@Override
	public Object selectAllpageList(HashMap<String, Object> map, PageInfo page) {
		return mapper.selectAll(map);
	}
	@Override
	public Integer deleteDada(HashMap<String, Object> map) {
		return mapper.deleteDada(map);
	}
	@Override
	public Integer updateDada(HashMap<String, Object> map) {
		return mapper.updateDada(map);
	}
	@Override
	public Integer insertDada(HashMap<String, Object> map) {
		return mapper.insertDada(map);
	}
	@Override
	public Integer deleteAll(String[] pk) {
		return mapper.deleteAll(pk);
	}
	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}
	@Override
	public Kklx selectKkxx(HashMap<String, Object> map) {
		return mapper.selectKkxx(map);
	}
	@Override
	public List<Qylx> selectQylx() {
		return mapper.selectQylx();
	}
	@Override
	public Integer insertQy(HashMap<String, Object> map) {
		return mapper.insertQy(map);
	}
	@Override
	public Integer insertDept(HashMap<String, Object> map) {
		return mapper.insertDept(map);
	}
	@Override
	public List<Qy_Bm> selectQy(HashMap<String, Object> map) {
		return mapper.selectQy(map);
	}
	@Override
	public List<Qy_Bm> selectDept(HashMap<String, Object> map) {
		return mapper.selectDept(map);
	}
	@Override
	public Integer deleteQy(HashMap<String, Object> map) {
		return mapper.deleteQy(map);
	}
	@Override
	public Integer deleteDept(HashMap<String, Object> map) {
		return mapper.deleteDept(map);
	}
	@Override
	public Integer selectQyRepet(HashMap<String, Object> map) {
		return mapper.selectQyRepet(map);
	}
	@Override
	public Integer selectDepatRepet(HashMap<String, Object> map) {
		return mapper.selectDepatRepet(map);
	}

}
