package com.cist.interceptRegion.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.interceptRegion.model.FenceArea;
import com.cist.interceptRegion.model.TempModel;

public interface InterceptRegionService {
	/**
	 * 管理部门-勤务区域巡区
	 * 
	 * @return
	 */
	public List<FenceArea> initDeptAreaTree();
	/**
	 * 管理部门-拦截区域(未筛选)
	 * 
	 * @return
	 */
	public List<FenceArea> initDeptAreaTreeAll();

	public List<FenceArea> deptAreaCount(List<FenceArea> deptAreaTree);

	/**
	 * 查询部门巡区Tree子节点
	 * 
	 * @return
	 */
	public void getChildrenTreeNode(List<FenceArea> areaList);

	public int getDeptAreaChildrenTreeNode(List<FenceArea> currentNodeChildrens, List<FenceArea> currentAreas,
			FenceArea currentNode, int currentNodeAreaNum, HashMap<String, Object> paramMap);

	/**
	 * 获取子巡区
	 * 
	 * @param areaList
	 */
	public void getChildrenArea(List<FenceArea> areaList);

	public int getChildrenArea(List<FenceArea> areaList, int currentNodeAreaNum);

	/**
	 * 查询巡区Tree
	 * 
	 * @param areaList
	 */
	public List<FenceArea> initAreaTree(FenceArea parentDept);

	public int initAreaTree(FenceArea currentNode, int currentNodeAreaNum);

	/**
	 * 查询部门Tree
	 * 
	 * @return
	 */
	public List<FenceArea> initDeptTree();

	/**
	 * 获取子部门
	 * 
	 * @param areaList
	 */
	public void getChildrenDept(List<FenceArea> deptList);
	/**
	 * 获取子部门
	 * @param deptList
	 * @param verifySpatialInfo  是否验证是否有空间信息
	 */
	public void getChildrenDept(List<FenceArea> deptList,boolean verifySpatialInfo);

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
	 * 分页查询拦截区域
	 *
	 */
	public Object queryAreapageList(HashMap<String, Object> paramMap, PageInfo pageInfo);
	
	/**
	 * 生成只有空间信息的管理部门Tree(管理部门(禁用不具备空间信息的部门))
	 * @param paramMap
	 * @return
	 */
	public List<FenceArea> initInterceptRegionOfSpace(HashMap<String, Object> paramMap);
	/**
	 * 导入拦截区域
	 * @param paramMap
	 * @return
	 */
	int importInterceptRegion(HashMap<String, Object> paramMap);
	/**
	 * 管理部门-拦截区域(筛选)
	 * @return
	 */
	HashMap<String, Object> initDeptInterceptRegionTree();
}
