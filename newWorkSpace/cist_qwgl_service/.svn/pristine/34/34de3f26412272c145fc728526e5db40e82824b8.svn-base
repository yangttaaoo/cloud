package com.cist.leavemanagment.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.leavemanagment.model.Dept;
import com.cist.leavemanagment.model.DeptInfo;
import com.cist.leavemanagment.model.Leave;

public interface LeaveMapper {
	/**
	 * 销假管理
	 * @param map
	 * @return
	 */
	List<Leave> selectSelfoff(HashMap<String,Object> map);
	/**
	 * 根据条件查询自己的请假数据
	 * @param map
	 * @return
	 */
	List<Leave> selectSelf(HashMap<String,Object> map);
	/**
	 * 根据条件查询未审核请假信息
	 * @param map
	 * @return
	 */
	List<Leave> selectNoAuditing(HashMap<String,Object> map);
	/**
	 * 根据条件查询请假信息
	 * @param map
	 * @return
	 */
	List<Leave> selectAll(HashMap<String,Object> map);
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
	 * 审核请假信息
	 * @param map
	 * @return
	 */
	Integer auditingLeave(HashMap<String, Object> map);
	 Integer updateLeaveoff(HashMap<String, Object> map);
	List<DeptInfo> depart_infolist(Integer dept_superior);
}
