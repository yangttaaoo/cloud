package com.cist.serviceconfig.warningconfig.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.serviceconfig.warningconfig.model.DeptInfo;
import com.cist.serviceconfig.warningconfig.model.TBL_OFFE_VIO_ALARM;

public interface WarningconfigService {
	/**
	 * 点位树
	 * @param dept_superior
	 * @return
	 */
	 List<DeptInfo> depart_infolist(Integer dept_superior);
	 List<DeptInfo> Monitorpoint(String tbmp_dept_code);
	 List<DeptInfo> Device(String tbmp_id);
	 /**
	  * 查询预警阈值
	  * @param map
	  * @return
	  */
	 List<TBL_OFFE_VIO_ALARM> queryyjyz(HashMap<String, Object> map);
	 /**
	  * 查询预警阈值（分页）
	  * @param map
	  * @param info
	  * @return
	  */
	 Object queryyjyzpageList(HashMap<String, Object> map,PageInfo info);
	 /**
	  * 添加预警阈值信息
	  * @param map
	  * @return
	  */
	Integer addyjyz(HashMap<String, Object> map); 
	/**
	 * 更新预警阈值信息
	 * @param map
	 * @return
	 */
	Integer updateyjyz(HashMap<String, Object> map);
	/**
	 * 删除预警阈值信息
	 * @param map
	 * @return
	 */
	Integer delyjyz(HashMap<String, Object> map);
	/**
	 * 初始化视频监控的Tree
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initTree() throws Exception;
}
