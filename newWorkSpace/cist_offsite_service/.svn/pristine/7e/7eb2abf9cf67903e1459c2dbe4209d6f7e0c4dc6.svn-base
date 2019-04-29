package com.cist.endNumberLimit.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.cist.endNumberLimit.model.CarLimtRules;
import com.cist.endNumberLimit.model.MountTree;

/**
 * 尾号限行管理
 * 
 * @author xh
 *
 */
public interface EndNumberLimitMapper {
	/**
	 * 分页查询
	 * 
	 * @param paramMap
	 * @return
	 */
	List<CarLimtRules> queryList(HashMap<String, Object> paramMap);

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
	 * 插入一条记录
	 * 
	 * @param paramMap
	 * @return
	 */
	int insertData(HashMap<String, Object> paramMap);

	/**
	 * 删除一条记录
	 * 
	 * @param paramMap
	 * @return
	 */
	int delData(HashMap<String, Object> paramMap);

	/**
	 * 批量删除多条记录
	 * 
	 * @param list
	 * @return
	 */
	int delAllData(List<String> list);

}
