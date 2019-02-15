package com.cist.menupurview.service.impl;


import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.frame.page.PageInfo;
import com.cist.menupurview.mapper.MenuPurviewMapper;
import com.cist.menupurview.model.SysModuleInfo;
import com.cist.menupurview.service.MenuPurviewService;



@Service
public class MenuPurviewServiceImpl implements MenuPurviewService  {

	@Autowired
	private MenuPurviewMapper mapper;

	public List<SysModuleInfo> selectMenu(HashMap<String,Object> map) {
		return mapper.selectMenu(map);
	}

	@Override
	public List<SysModuleInfo> acquisition(Integer symi_parent) {
		return mapper.acquisition(symi_parent);
	}

	@Override
	public List<SysModuleInfo> menuInfoList(Integer symi_pk) {
		return mapper.menuInfoList(symi_pk);
	}

	@Override
	public Integer save(HashMap<String, Object> map) {
		return mapper.save(map);
	}

	@Override
	public Integer delete(HashMap<String, Object> map) {
		return mapper.delete(map);
	}

	@Override
	public Integer update(HashMap<String, Object> map) {
		return mapper.update(map);
	}

	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo p) {
		return mapper.list(map);
	}

	@Override
	public SysModuleInfo selectParent(HashMap<String, Object> map) {
		return mapper.selectParent(map);
	}


	
}
