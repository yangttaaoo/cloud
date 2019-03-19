package com.cist.pcmanagement.service;

import java.util.HashMap;
import java.util.List;

import com.cist.devmanagement.model.DeptInfo;
import com.cist.devmanagement.model.JcsjDevice;
import com.cist.devmanagement.model.Sys_frm_code;
import com.cist.frame.page.PageInfo;


/***
 * 
 * @Title:PcManagementService.java
 * @Package:com.cist.pcmanagement.service
 * @Description:TODO
 * @author:YT
 * @date:2019年3月12日
 * @version V1.0
 */
public interface PcManagementService {

	
	//PC终端入网登记
	Object pcListpageList(HashMap<String,Object> map,PageInfo p);
	
	//新增PC终端信息
	Integer addPc(HashMap<String,Object> map);
	
	//更新PC终端信息
	Integer updatePC(HashMap<String,Object> map);
	
	//删除PC终端信息
	Integer deletePc(HashMap<String,Object> map);
}
