package com.cist.configManage.areaPlan.service;

import java.util.HashMap;
import java.util.List;

import com.cist.configManage.areaPlan.model.PatrolArea;
import com.cist.configManage.areaPlan.model.TempModel;

public interface AreaPlanService {
	/**
	 * 查询部门巡区Tree
	 * 
	 * @return
	 */
	public List<PatrolArea> initDeptAreaTree();

	/**
	 * 查询部门巡区Tree子节点
	 * 
	 * @return
	 */
	public void getChildrenTreeNode(List<PatrolArea> areaList);

	/**
	 * 获取子巡区
	 * 
	 * @param areaList
	 */
	public void getChildrenArea(List<PatrolArea> areaList);

	/**
	 * 查询巡区Tree
	 * 
	 * @param areaList
	 */
	public List<PatrolArea> initAreaTree(PatrolArea parentDept);

	/**
	 * 查询部门Tree
	 * 
	 * @return
	 */
	public List<PatrolArea> initDeptTree();

	/**
	 * 获取子部门
	 * 
	 * @param areaList
	 */
	public void getChildrenDept(List<PatrolArea> deptList);

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
}
