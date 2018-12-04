package com.cist.leavemanagment.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.cist.leavemanagment.model.Dept;
import com.cist.leavemanagment.model.DeptInfo;
import com.cist.leavemanagment.model.Leave;
import com.cist.leavemanagment.service.LeaveService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("leave")
public class LeaveController {
	@Autowired
	private LeaveService lService;
	/**
	 * 查询自己的请假申请
	 * @param map
	 * @return
	 */
	@RequestMapping("selflist")
	public PageInfo<Leave> indexSelf(@RequestBody HashMap<String, Object> map,HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		map.put("userPk", userPk);
		PageInfo pInfo = new PageInfo();
		pInfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pInfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Leave> pageInfo = (PageInfo<Leave>) lService.selectSelfpageList(map, pInfo);
		return pageInfo;
	}
	/**
	 * 销假管理
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("selloff")
	public PageInfo<Leave> selloff(@RequestBody HashMap<String, Object> map,HttpServletRequest request){
		HttpSession session = request.getSession();
		PageInfo pInfo = new PageInfo();
		pInfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pInfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Leave> pageInfo = (PageInfo<Leave>) lService.selectSelfoffpageList(map, pInfo);
		return pageInfo;
	}
	/***
	 * 获取当前用户
	 * @param request
	 * @return
	 */
	@RequestMapping("getuser")
	public Map<String,Object> indexSelf(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		return userMap;
	}
	
	
	/**
	 * 查询未审批的请假申请
	 * @param map
	 * @return
	 */
	@RequestMapping("noauditinglist")
	public PageInfo<Leave> indexNoAuditing(@RequestBody HashMap<String, Object> map){
		PageInfo pInfo = new PageInfo();
		pInfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pInfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Leave> pageInfo = (PageInfo<Leave>) lService.selectNoAuditingpageList(map, pInfo);
		List<Leave> leaves = pageInfo.getList();
		Leave leave = null;
		for (int i = 0; i < leaves.size(); i++) {
			leave = leaves.get(i);
			map.put("dept_pk", leave.getL_deptid());
			if(lService.selectDept(map).size()>0) {
				leave.setDeptname(lService.selectDept(map).get(0).getDept_name());
			}else {
				leave.setDeptname("未知");
			}
			
		}
		pageInfo.setList(leaves);
		return pageInfo;
	}
	/**
	 * 查询所有请假申请
	 * @param map
	 * @return
	 */
	@RequestMapping("alllist")
	public PageInfo<Leave> indexAll(@RequestBody HashMap<String, Object> map){
		PageInfo pInfo = new PageInfo();
		pInfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pInfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Leave> pageInfo = (PageInfo<Leave>) lService.selectAllpageList(map, pInfo);
	/*	List<Leave> leaves = pageInfo.getList();
		Leave leave = null;
		for (int i = 0; i < leaves.size(); i++) {
			leave = leaves.get(i);
			map.put("dept_pk", leave.getL_deptid());
			leave.setDeptname(lService.selectDept(map).get(0).getDept_name());
		}
		pageInfo.setList(leaves);*/
		return pageInfo;
	}
	/**
	 * 添加请假申请
	 * @param map
	 * @return
	 */
	@RequestMapping("insert")
	public Integer insertLeave(@RequestBody HashMap<String, Object> map){
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("l_sqsj", sim.format(date));
		return lService.insertLeave(map);
	}
	
	/**
	 * 获取管理部门
	 * @param map
	 * @return
	 */
	@RequestMapping("depts")
	public Dept getDept(@RequestBody HashMap<String, Object> map) {
		return lService.selectDept(map).get(0);
	}
	/**
	 * 删除单条数据
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deleteLeave(@RequestBody HashMap<String, Object> map){
		return lService.deleteById(map);
	}
	/**
	 * 更新请假申请
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updateLeave(@RequestBody HashMap<String, Object> map){
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("l_sqsj", sim.format(date));
		return lService.updateLeave(map);
	}
	
	@RequestMapping("updateoff")
	public Integer updateoff(@RequestBody HashMap<String, Object> map){
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("sell_off_time", sim.format(date));
		Integer a=lService.updateLeaveoff(map);
		System.err.println(a);
		return a;
	}
	
	
	/**
	 * 审核请假申请
	 * @param map
	 * @return
	 */
	@RequestMapping("auditing")
	public Integer auditingLeave(@RequestBody HashMap<String, Object> map){
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("l_spsj", sim.format(date));
		return lService.auditingLeave(map);
	}
	
	// 部门
		@RequestMapping("deptinfo")
		public String deptinfo() throws JsonProcessingException {
			// 顶级部门
			List<DeptInfo> departinfo = lService.depart_infolist(null);
			ObjectMapper mapper = new ObjectMapper();
			List<DeptInfo> list = departinfodg(departinfo);
			String json = mapper.writeValueAsString(getdiwfdidian(list));
			return json.substring(1, json.length() - 1);
		}

		public List<HashMap<String, Object>> getdiwfdidian(List<DeptInfo> list) {
			List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
			for (DeptInfo depart_info : list) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("title", depart_info.getName());
				map.put("key", depart_info.getDept_pk());
				map.put("selectable", depart_info.getSelectable());
				map.put("isLeaf", depart_info.getIsLeaf());
				if (null != depart_info.getChildren()) {// 下级

					map.put("children", getdiwfdidian(depart_info.getChildren()));
					listmap.add(map);
				} else {
					listmap.add(map);
				}
			}
			return listmap;
		}

		public List<DeptInfo> departinfodg(List<DeptInfo> departinfo) {
			for (DeptInfo depart_info : departinfo) {
				// 部门
				List<DeptInfo> list = lService.depart_infolist(depart_info.getDept_pk());
				if (list.size() != 0) {
					depart_info.setChildren(list);
					departinfodg(list);
				}
			}
			return departinfo;
		}
}



