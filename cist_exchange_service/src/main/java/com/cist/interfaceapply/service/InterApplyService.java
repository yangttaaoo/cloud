package com.cist.interfaceapply.service;

import java.util.HashMap;
import java.util.List;
import com.cist.frame.page.PageInfo;
import com.cist.interfaceapply.model.DeptInfo;
import com.cist.interfaceapply.model.SjgxDevCompany;
import com.cist.interfaceapply.model.SjgxInterface;
import com.cist.interfaceapply.model.SjgxInterfaceList;
import com.cist.interfaceapply.model.SjgxInterfaceUseApply;
import com.cist.interfaceapply.model.VwDeptList;

public interface InterApplyService {
	//使用接口列表
		List<SjgxInterface> selectTInterface(HashMap<String,Object> map); 
		
		//接口开发单位
		List<SjgxDevCompany> selectDevCompany(HashMap<String,Object> map); 
		
		//根据pk删除
		Integer delete(HashMap<String,Object> map);
		
		//新增接口使用申请
		Integer save(HashMap<String,Object> map);
		
		//新增接口使用申请时新增接口使用列表
		Integer saveList(HashMap<String,Object> map);
		
		
		//条件分页查询
		Object listpageList(HashMap<String,Object> map,PageInfo pinfo); 
		
		//更新菜单内容
		Integer update(HashMap<String,Object> map);
		
		//使用单位下拉列表数据
		List<VwDeptList> selectDept(HashMap<String,Object> map); 
		
		//首页根据使用单位id查询对应名称
		VwDeptList selectDeptName(HashMap<String,Object> map); 
		
		//首页根据使用单位id查询对应名称
		List<SjgxDevCompany> selectDevCompanyName(HashMap<String,Object> map);
		
		//首页开发单位名称查询，在使用接口列表中查询
		List<SjgxInterfaceList> devCompanyName(HashMap<String,Object> map);
		
		/**
		 * 使用单位树
		 * @param dept_superior
		 * @return
		 */
		List<DeptInfo> depart_infolist(Integer dept_superior);
		
		//更新接口使用列表
		Integer updateInterface(HashMap<String,Object> map);
}
