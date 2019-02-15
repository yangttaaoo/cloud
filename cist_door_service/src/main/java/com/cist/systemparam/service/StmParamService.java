package com.cist.systemparam.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cist.systemparam.model.Sys_cfg_info;
import com.cist.systemparam.model.Sys_config;

@Service(value="StmParamServiceImpl")
public interface StmParamService {
	
	/**
	 * 系统参数详情
	 * @param map
	 * @return
	 */
	List<Sys_config> queryCfg(Map<String, Object> map);
	
	
	/**
	 * 修改参数详情
	 * @param map
	 * @return
	 */
	Integer updateCfg(Map<String, Object> map);
}
