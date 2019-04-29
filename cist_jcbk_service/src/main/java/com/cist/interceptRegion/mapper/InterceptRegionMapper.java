package com.cist.interceptRegion.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.interceptRegion.model.FenceArea;
import com.cist.interceptRegion.model.TempModel;

public interface InterceptRegionMapper {
	/**
	 * 根据查询顶级部门
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<FenceArea> queryTopLevelDept();

	/**
	 * 根据部门Id查询子部门
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<FenceArea> querySubLevelDept(Long deptId);

	/**
	 * 根据查询顶级巡区
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<FenceArea> queryTopLevelArea(HashMap<String, Object> paramMap);

	/**
	 * 根据巡区Id查询子巡区
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<FenceArea> querySubLevelArea(HashMap<String, Object> paramMap);

	/**
	 * 在数据字典中根据<索引>找到对应数据
	 * 
	 * @return
	 */
	public List<TempModel> queryBaseDateByFct_Code(String FCT_CODE);

	/**
	 * 新增拦截区域
	 * 
	 * @param paramMap
	 * @return
	 */
	public int insertArea(HashMap<String, Object> paramMap);

	/**
	 * 更新拦截区域
	 * 
	 * @param paramMap
	 * @return
	 */
	public int updateArea(HashMap<String, Object> paramMap);

	/**
	 * 删除拦截区域
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteArea(HashMap<String, Object> paramMap);
	/**
	 * 查询拦截区域List
	 *
	 */
	public List<FenceArea> queryAreaList(HashMap<String, Object> paramMap);
	/**
	 * 根据部门编码查询拦截区域
	 * @param paramMap
	 * @return
	 */
	
	List<FenceArea> queryInterceptRegionByDept(HashMap<String, Object> paramMap);
	/**
	 * 导入拦截区域
	 * @param paramMap
	 * @return
	 */
	int importInterceptRegion(HashMap<String, Object> paramMap);
}
