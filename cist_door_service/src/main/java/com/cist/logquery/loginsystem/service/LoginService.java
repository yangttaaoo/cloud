package com.cist.logquery.loginsystem.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.logquery.loginsystem.model.Sys_login_log;

public interface LoginService {
	//登陆日志查询
   Object  selectDatapageList(HashMap<String, Object> map,PageInfo page);
   Object  selectOnepageList(HashMap<String, Object> map,PageInfo page);
   //删除所有数据
   Integer deleteAll(String[] pk);
}
