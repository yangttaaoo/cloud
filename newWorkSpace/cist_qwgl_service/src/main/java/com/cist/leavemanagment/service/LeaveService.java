package com.cist.leavemanagment.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.leavemanagment.model.Dept;
import com.cist.leavemanagment.model.DeptInfo;
import com.cist.leavemanagment.model.Leave;

public interface LeaveService {
	/**
	 * 销假管理
	 * @param map
	 * @return
	 */
	Object selectSelfoffpageList(HashMap<String,Object> map, PageInfo pageInfo);
	/**
	 * 根据条件查询数据
	 * @param map
	 * @return
	 */
	Object selectSelfpageList(HashMap<String,Object> map,PageInfo pageInfo);
	 Integer updateLeaveoff(HashMap<String, Object> map);
	/**
	 * 添加数据
	 * @return
	 */
	Integer insertLeave(HashMap<String,Object> map);
	/**
	 * 删除请假申请
	 * @param map
	 * @return
	 */
	Integer deleteById(HashMap<String,Object> map);
	/**
	 * 更新请假申请
	 * @param map
	 * @return
	 */
	Integer updateLeave(HashMap<String,Object> map);
	/**
	 * 查询部门
	 * @param map
	 * @return
	 */
	List<Dept> selectDept(HashMap<String, Object> map);
	/**
	 * 根据条件查询未审核请假信息
	 * @param map
	 * @return
	 */
	Object selectNoAuditingpageList(HashMap<String,Object> map,PageInfo pageInfo);
	/**
	 * 根据条件查询请假信息
	 * @param map
	 * @return
	 */
	Object selectAllpageList(HashMap<String,Object> map,PageInfo pageInfo);
	/**
	 * 审核请假信息
	 * @param map
	 * @return
	 */
	Integer auditingLeave(HashMap<String, Object> map);
	
	List<DeptInfo> depart_infolist(Integer dept_superior);
}
