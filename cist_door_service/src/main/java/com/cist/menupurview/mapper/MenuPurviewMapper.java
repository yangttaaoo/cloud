package com.cist.menupurview.mapper;


import java.util.HashMap;
import java.util.List;
import com.cist.menupurview.model.SysModuleInfo;

public interface MenuPurviewMapper {
	List<SysModuleInfo> selectMenu(HashMap<String,Object> map); 
	
	//根据顶级菜单查询下一级菜单
		List<SysModuleInfo> acquisition(Integer symi_parent);
		//根据顶级菜单查询下一级菜单
		List<SysModuleInfo> menuInfoList(Integer symi_pk);
		
		//条件分页查询
		List<SysModuleInfo> list(HashMap<String,Object> map); 
		//保存菜单
		Integer save(HashMap<String,Object> map);
		
		//根据pk删除菜单
		Integer delete(HashMap<String,Object> map);
		//更新菜单内容
		Integer update(HashMap<String,Object> map);
		
		SysModuleInfo selectParent(HashMap<String,Object> map);
}
