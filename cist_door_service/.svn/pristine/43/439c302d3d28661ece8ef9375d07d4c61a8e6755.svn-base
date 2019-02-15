package com.cist.codemaintain.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cist.codemaintain.model.Sys_frm_code_type;
import com.cist.frame.page.PageInfo;

@Service(value="CodeMaintainServiceImpl")
public interface CodeMaintainService {
	/**
	 * 数据详情
	 * @param map
	 * @param info
	 * @return
	 */
	Object queryAllpageList(Map<String, Object> map,PageInfo info);
	
	/**
	 * 点位类型
	 * @return
	 */
	List<Sys_frm_code_type> queryFrmType(Map<String, Object> map);
	
	/**
	 * 修改代码详情
	 * @return
	 */
	Integer update(Map<String, Object> map);
	
	/**
	 * 添加代码详情
	 * @param map
	 * @return
	 */
	Integer insert(Map<String, Object> map);
	
	/**
	 * 删除代码详情
	 * @param map
	 * @return
	 */
	Integer delete(Map<String, Object> map);
}
