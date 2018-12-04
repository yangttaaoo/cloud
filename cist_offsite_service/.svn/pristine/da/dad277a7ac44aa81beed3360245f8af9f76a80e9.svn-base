package com.cist.serviceconfig.illegalconfig.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.recheck.model.TblOffeCateInfo;

public interface IllegalConfigMapper {

	/**
	 * 违法行为
	 * @return
	 */
	List<TblOffeCateInfo> selectNameCode(Map<String, Object> map);
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
	 * 根据违法行为pk获取详情
	 * @param pk
	 * @return
	 */
	List<TblOffeCateInfo> getWfxwPk(String pk);
	
	/**
	 * 添加违法行为详情
	 * @param info
	 */
	int insertWfxw(HashMap<String,Object> map);
	
	/**
	 * 批量删除违法行为数据
	 * @param map
	 * @return
	 */
	Integer deleteWfxw(HashMap<String,Object> map);
	
	/**
	 * 查询违法内容
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
