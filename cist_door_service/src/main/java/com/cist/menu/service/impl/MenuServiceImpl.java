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


@Service
public class MenuServiceImpl implements MenuService  {
	@Autowired
	private MenuMapper mapper;
	public List<Menu> selectMenu(HashMap<String, Object> map) {
		return mapper.selectMenu(map);
	}
	public List<Menu> selectMenuwid(HashMap<String, Object> map) {
		return mapper.selectMenuwid(map);
	}
	public List<Menu> selectMenuwper(HashMap<String, Object> map) {
		return mapper.selectMenuwper(map);
	}
	public List<Menu> selectMenushang(HashMap<String, Object> map) {
		return mapper.selectMenushang(map);
	}	
}
