package com.cist.menu.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.menu.mapper.MenuMapper;
import com.cist.menu.model.Menu;
import com.cist.menu.service.MenuService;
import com.cist.picture.mapper.PictureMapper;
import com.cist.picture.model.C_plate_type;
import com.cist.picture.model.Depart_info;
import com.cist.picture.model.MenuDetails;
import com.cist.picture.model.Monitorpoint;
import com.cist.picture.model.Tbl_offe_cate;
import com.cist.picture.model.Tbl_offe_evdi;
import com.cist.picture.service.PictureService;
import com.cist.policeofficer.mapper.PoliceofficerMapper;
import com.cist.policeofficer.model.SysPoliceInfo;
import com.cist.policeofficer.service.PoliceofficerService;


@Service
public class MenuServiceImpl implements MenuService  {

	@Autowired
	private MenuMapper mapper;

	@Override
	public List<Menu> selectMenu(HashMap<String,Object> map) {
		return mapper.selectMenu(map);
	}


	
}
