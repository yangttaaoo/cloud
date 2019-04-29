package com.cist.bayonetRegister.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.bayonetRegister.mapper.BayonetRegisterMapper;
import com.cist.bayonetRegister.service.BayonetRegisterService;
import com.cist.devRegister.model.Device;
import com.cist.devRegister.util.TempModel;
import com.cist.frame.page.PageInfo;
import com.cist.frame.springContext.SpringContextUtil;

@Service
public class BayonetRegisterServiceImpl implements BayonetRegisterService {
	@Autowired
	private BayonetRegisterMapper mapper;

	@Override
	public Object queryImminentExpirypageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		// TODO Auto-generated method stub
		return mapper.queryImminentExpiryList(paramMap);
	}

	@Override
	public List<TempModel> queryBayonetFunType(String FCT_CODE) {
		// TODO Auto-generated method stub
		return mapper.queryBayonetFunType(FCT_CODE);
	}

	@Override
	public Object queryDevicepageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		return mapper.SecurityByfk_dept_idTocode(paramMap);
	}

	@Override
	public Device queryBayonetById(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.queryBayonetById(paramMap);
	}
}
