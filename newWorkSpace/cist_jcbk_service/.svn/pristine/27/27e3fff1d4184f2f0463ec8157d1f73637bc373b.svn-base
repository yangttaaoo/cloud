package com.cist.interceptRegion.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.interceptRegion.model.FenceArea;
import com.cist.interceptRegion.service.InterceptRegionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("areaPlan")
public class InterceptRegionController {
	@Autowired
	private InterceptRegionService service;

	/**
	 * deptArea 管理部门-勤务区域巡区
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("deptArea")
	public HashMap<String, Object> deptArea(@RequestBody HashMap<String, Object> paramMap)
			throws JsonProcessingException {
		List<FenceArea> deptArea = service.initDeptAreaTree();
		paramMap.put("deptArea", new ObjectMapper().writeValueAsString(deptArea));
		return paramMap;

	}

	/**
	 * deptAreaAll 管理部门-拦截区域(未筛选)
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("deptAreaAll")
	public HashMap<String, Object> deptAreaAll(@RequestBody HashMap<String, Object> paramMap) {
		List<FenceArea> deptAreaAll = service.initDeptAreaTreeAll();
		paramMap.put("deptAreaAll", deptAreaAll);
		return paramMap;

	}

	/**
	 *  deptInterceptRegionTree 
	 * 管理部门-拦截区域(筛选)
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("deptInterceptRegionTree")
	public HashMap<String, Object> deptInterceptRegionTree(@RequestBody HashMap<String, Object> paramMap)  {
		return service.initDeptInterceptRegionTree();
		
	}

	/**
	 * deptOfSpace 管理部门(禁用不具备空间信息的部门)
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("deptOfSpace")
	public HashMap<String, Object> deptOfSpace(@RequestBody HashMap<String, Object> paramMap) {
		paramMap.put("deptOfSpace", service.initInterceptRegionOfSpace(paramMap));
		return paramMap;

	}

	/**
	 * 分页查询拦截区域
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("queryList")
	public PageInfo<FenceArea> queryList(@RequestBody HashMap<String, Object> paramMap) {
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<FenceArea> querypageList = (PageInfo<FenceArea>) service.queryAreapageList(paramMap, pageInfo);
		return querypageList;

	}

	/**
	 * 新增拦截区域
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("insert")
	public int insert(@RequestBody HashMap<String, Object> paramMap) {
		return service.insertArea(paramMap);

	}

	/**
	 * 更新拦截区域
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("update")
	public int update(@RequestBody HashMap<String, Object> paramMap) {

		return service.updateArea(paramMap);

	}

	/**
	 * 删除拦截区域
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("delete")
	public int delete(@RequestBody HashMap<String, Object> paramMap) {

		return service.deleteArea(paramMap);

	}

	/**
	 * dept 管理部门
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("dept")
	public List<FenceArea> dept(@RequestBody HashMap<String, Object> paramMap) {
		List<FenceArea> dept = service.initDeptTree();
		for (FenceArea patrolArea : dept) {
			patrolArea.setExpanded(true);
		}
		return dept;

	}

	/**
	 * 导入拦截区域
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("importInterceptRegion")
	public int importInterceptRegion(@RequestBody HashMap<String, Object> paramMap) {

		try {
			service.importInterceptRegion(paramMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 1;

	}

}
