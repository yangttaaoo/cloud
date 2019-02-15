package com.cist.interfaceapply.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cist.frame.page.PageInfo;
import com.cist.interfaceapply.mapper.InterApplyMapper;
import com.cist.interfaceapply.model.DeptInfo;
import com.cist.interfaceapply.model.SjgxDevCompany;
import com.cist.interfaceapply.model.SjgxInterface;
import com.cist.interfaceapply.model.SjgxInterfaceList;
import com.cist.interfaceapply.model.VwDeptList;
import com.cist.interfaceapply.service.InterApplyService;

@Service
public class InterApplyServiceImpl implements InterApplyService  {
	@Autowired
	private InterApplyMapper mapper;
	@Override
	public List<SjgxInterface> selectTInterface(HashMap<String,Object> map) {
		return mapper.selectTInterface(map);
	}
	
	@Override
	public List<SjgxDevCompany> selectDevCompany(HashMap<String, Object> map) {
		return mapper.selectDevCompany(map);
	}
	
	@Override
	public Integer delete(HashMap<String, Object> map) {
		return mapper.delete(map);
	}
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer save(HashMap<String, Object> map) {
		Integer save = mapper.save(map);
		//接口使用列表批量插入
		saveList(map);
		return save;
	}
	
	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.list(map);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer update(HashMap<String, Object> map) {
		Integer updateindex = mapper.update(map);
		updateInterface(map);
		return updateindex;
	}
	
	@Override
	public List<VwDeptList> selectDept(HashMap<String, Object> map) {
		return mapper.selectDept(map);
	}

	@Override
	public VwDeptList selectDeptName(HashMap<String, Object> map) {
		return mapper.selectDeptName(map);
	}

	@Override
	public List<SjgxDevCompany> selectDevCompanyName(HashMap<String, Object> map) {
		return mapper.selectDevCompanyName(map);
	}

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public Integer saveList(HashMap<String, Object> map) {
		return mapper.saveList(map);
	}

	@Override
	public List<SjgxInterfaceList> devCompanyName(HashMap<String, Object> map) {
		return mapper.devCompanyName(map);
	}

	@Override
	public Integer updateInterface(HashMap<String, Object> map) {
		return mapper.updateInterface(map);
	}


}
