package com.cist.endNumberLimit.service;

import java.util.HashMap;
import java.util.List;

import com.cist.endNumberLimit.model.CarLimtRules;
import com.cist.endNumberLimit.model.MountTree;
import com.cist.frame.page.PageInfo;

public interface EndNumberLimitService {

	/**
	 * 分页查询
	 * 
	 * @param paramMap
	 * @param pageInfo
	 * @return
	 */

	Object querypageList(HashMap<String, Object> paramMap, PageInfo pageInfo);

	/**
	 * 更新一条记录
	 * 
	 * @param paramMap
	 * @return
	 */
	int update(HashMap<String, Object> paramMap);

	/**
	 * 获取卡口点位与方位节点
	 * @return
	 */
	List<MountTree> queryParentNode();
	/**
	 * 根据点位Id与方位Id获取设备信息
	 * @param parentId
	 * @param childrenId
	 * @return
	 */
	List<MountTree> querChildrenNode(HashMap<String, Object> hashMap);

	/**
	 * 删除一条数据
	 * 
	 * @param paramMap
	 * @return
	 */
	int delData(HashMap<String, Object> paramMap);

	/**
	 * 批量删除多条数据
	 * 
	 * @param list
	 * @return
	 */
	int delAllData(List<String> list);

	/**
	 * 插入条数据
	 * 
	 * @param paramMap
	 * @return
	 */
	int insertData(HashMap<String, Object> paramMap);

	/*
	 * CarLimtRules querydataById(int tlr_pk);
	 * 
	 * List<MountTree> queryPTlist();
	 * 
	 * List<MountTree> queryDIRElist(List<String> direIds);
	 * 
	 * List<MountTree> queryDEVlist(HashMap<String, Object> hashMap);
	 */

}
