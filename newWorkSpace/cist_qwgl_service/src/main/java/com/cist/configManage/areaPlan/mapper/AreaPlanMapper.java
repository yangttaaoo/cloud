package com.cist.configManage.areaPlan.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.configManage.areaPlan.model.PatrolArea;
import com.cist.configManage.areaPlan.model.TempModel;

public interface AreaPlanMapper {
	/**
	 * 根据查询顶级部门
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<PatrolArea> queryTopLevelDept();

	/**
	 * 根据部门Id查询子部门
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<PatrolArea> querySubLevelDept(Long deptId);

	/**
	 * 根据查询顶级巡区
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<PatrolArea> queryTopLevelArea(HashMap<String, Object> paramMap);

	/**
	 * 根据巡区Id查询子巡区
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<PatrolArea> querySubLevelArea(HashMap<String, Object> paramMap);

	/**
	 * 在数据字典中根据<索引>找到对应数据
	 * 
	 * @return
	 */
	public List<TempModel> queryBaseDateByFct_Code(String FCT_CODE);

	/**
	 * 新增巡区
	 * 
	 * @param paramMap
	 * @return
	 */
	public int insertArea(HashMap<String, Object> paramMap);

	/**
	 * 更新巡区
	 * 
	 * @param paramMap
	 * @return
	 */
	public int updateArea(HashMap<String, Object> paramMap);

	/**
	 * 删除巡区
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteArea(HashMap<String, Object> paramMap);
	/**
	 * 查询巡区List
	 *
	 */
	public List<PatrolArea> queryAreaList(HashMap<String, Object> paramMap);
}
