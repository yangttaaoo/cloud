package com.cist.logquery.loginsystem.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.logquery.loginsystem.mapper.LoginMapper;
import com.cist.logquery.loginsystem.model.Sys_login_log;
import com.cist.logquery.loginsystem.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired	
	private LoginMapper  mapper;
	
	public Object selectDatapageList(HashMap<String, Object> map,PageInfo page) {
		return mapper.selectData(map);
	}

	@Override
	public Object selectOnepageList(HashMap<String, Object> map,PageInfo page) {
		return mapper.selectOne(map);
	}

	@Override
	public Integer deleteAll(String[] pk) {
		return mapper.deleteAll(pk);
	}

}
