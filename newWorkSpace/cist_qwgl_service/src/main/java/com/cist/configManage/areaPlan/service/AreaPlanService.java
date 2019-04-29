package com.cist.configManage.areaPlan.service;

import java.util.HashMap;
import java.util.List;

import com.cist.configManage.areaPlan.model.PatrolArea;
import com.cist.configManage.areaPlan.model.TempModel;
import com.cist.frame.page.PageInfo;

public interface AreaPlanService {
	/**
	 * 查询部门巡区Tree(筛选Tree)
	 * 
	 * @return
	 */
	public List<PatrolArea> initDeptAreaTree();
	/**
	 * 查询部门巡区Tree(未筛选Tree)
	 * 
	 * @return
	 */
	public List<PatrolArea> initDeptAreaTreeAll();

	public List<PatrolArea> deptAreaCount(List<PatrolArea> deptAreaTree);

	/**
	 * 查询部门巡区Tree子节点
	 * 
	 * @return
	 */
	public void getChildrenTreeNode(List<PatrolArea> areaList);

	public int getDeptAreaChildrenTreeNode(List<PatrolArea> currentNodeChildrens, List<PatrolArea> currentAreas,
			PatrolArea currentNode, int currentNodeAreaNum, HashMap<String, Object> paramMap);

	/**
	 * 获取子巡区
	 * 
	 * @param areaList
	 */
	public void getChildrenArea(List<PatrolArea> areaList);

	public int getChildrenArea(List<PatrolArea> areaList, int currentNodeAreaNum);

	/**
	 * 查询巡区Tree
	 * 
	 * @param areaList
	 */
	public List<PatrolArea> initAreaTree(PatrolArea parentDept);

	public int initAreaTree(PatrolArea currentNode, int currentNodeAreaNum);

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

	/**
	 * 分页查询巡区List
	 *
	 */
	public Object queryAreapageList(HashMap<String, Object> paramMap, PageInfo pageInfo);
}