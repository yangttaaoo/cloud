package com.cist.serviceconfig.illegalconfig.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.recheck.model.TblOffeCateInfo;


@Service(value="IllegalConfigServiceImpl")
public interface IllegalConfigService {
	/**
	 * 违法行为
	 * @return
	 */
	Object selectNameCodepageList(Map<String, Object> map,PageInfo info);
	
	/**
	 * 违法列表
	 * @return
	 */
	List<TblOffeCateInfo> selectAll();
	
	/**
	 * 修改违法详情
	 * @return
	 */
	Integer updateWfxw(HashMap<String,Object> map);
	
	/**
	 * 添加违法行为详情
	 * @param info
	 */
	Integer insertWfxw(HashMap<String,Object> map);
	
	/**
	 * 删除违法行为数据
	 * @param map
	 * @return
	 */
	Integer deleteWfxw(HashMap<String,Object> map);
	
	/**
	 * 查询违法内容
	 * @param map 
	 * @return
	 */
	List<TblOffeCateInfo> queryForm(HashMap<String, Object> map);

	
	/**
	 * 
	 * @param code
	 * @return
	 */
	TblOffeCateInfo verifyCode(HashMap<String,Object> map);
	
	
	/**
	 * 批量删除
	 * @return
	 */
	Integer deleteAll(String[] pk);
	
	Integer selectCode(HashMap<String, Object> map);
}
