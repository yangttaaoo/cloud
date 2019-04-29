package com.cist.workflow.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.workflow.model.Syspoliceinfo;
import com.cist.workflow.model.Zhdd_wflow_detall;
import com.cist.workflow.model.Zhdd_work_flow;
import com.cist.workflow.service.WorkFlowService;

@RestController
@RequestMapping("workflow")
public class WorkFlowController {

	@Autowired
	private WorkFlowService workFlowService;

	/**
	 * 工作流程条件查询及分页
	 * @param map
	 * @return
	 */
	
	@RequestMapping("index")
	public PageInfo<Zhdd_work_flow> selectWorkFlow(@RequestBody Map<String, Object> map){
		PageInfo pinfo = new PageInfo();
		pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Zhdd_work_flow> pageInfo = (PageInfo<Zhdd_work_flow>) workFlowService.selectWorkpageList(map, pinfo);
		return pageInfo;
	}
	
	/**
	 * 工作流程明显详情
	 * @return
	 */
	@RequestMapping("detall")
	public List<Zhdd_wflow_detall> selectWorkDetall(){
		List<Zhdd_wflow_detall> lists = workFlowService.selectWorkfDetall();
		return lists;
	}
	
	/**
	 * 根据登录人ID获取详情
	 * @return
	 */
	@RequestMapping("police")
	public List<Syspoliceinfo> selectPolice(@RequestBody String sypi_code){
		List<Syspoliceinfo> lists = workFlowService.selectPolice(sypi_code);
		return lists;
	}
	
	
	/**
	 * 添加工作明细详情
	 * @param map
	 * @return
	 */
	@RequestMapping("insertdetall")
	public Integer addWorkfDetall(@RequestBody Map<String, Object> map){
		Integer addDetall = workFlowService.insertWorkfDetall(map);
		return addDetall;
	}

	/**
	 * 删除工作流程详情
	 * @param map
	 * @return
	 */
	@RequestMapping("deletes")
	public Integer deleteWorkFlow(@RequestBody Map<String, Object> map){
		return workFlowService.deleteWorkFlow(map);
	}

	/**
	 * 添加工作流程详情
	 * @param map
	 * @return
	 */
	@RequestMapping("insert")
	public Integer addWorkFlow(@RequestBody Map<String, Object> map,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		String deptCode = userMap.get("sypi_dept_pk")==null?null:userMap.get("sypi_dept_pk").toString();
		map.put("fk_producer_id", userPk);//操作人pk
		map.put("fk_dept_id", deptCode);//操作部门代码
		Integer addDetall = workFlowService.insertWorkFolw(map);
		map.put("fk_work_flow_id", map.get("pk_id"));
		if(addDetall != null&&map.get("list")!=null&&((ArrayList)map.get("list")).size() > 0){
				workFlowService.insertWorkfDetall(map);
		}
		
		return addDetall;
	}
	
	
	/**
	 * 修改工作流程详情
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updateWorkFlow(@RequestBody Map<String, Object> map){
		
		
		Integer updateWorkFlow = workFlowService.updateWorkFlow(map);

		return updateWorkFlow;
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("names")
	public List<Zhdd_wflow_detall> selectWorkName(@RequestBody Map<String, Object> map){
		List<Zhdd_wflow_detall> hEvdiInfo = workFlowService.selectWorkName(map);
		return hEvdiInfo;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("isname")
	public List<Zhdd_wflow_detall> selectWorkNames(){
		List<Zhdd_wflow_detall> hEvdiInfo = workFlowService.selectWorkNames();
		return hEvdiInfo;
	}
	
	/**
	 * 根据登录人ID获取详情
	 * @return
	 */
	@RequestMapping("selectDetail")
	public List<Zhdd_wflow_detall> selectDetail(@RequestBody  Map<String, Object> map){
		List<Zhdd_wflow_detall> lists = workFlowService.selectDetail(map);
		return lists;
	}
	
}
