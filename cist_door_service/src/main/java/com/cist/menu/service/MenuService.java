package com.cist.menu.service;
import java.util.HashMap;
import java.util.List;
import com.cist.menu.model.Menu;


public interface MenuService {

	public List<Menu> selectMenu(HashMap<String,Object> map); 
	public List<Menu> selectMenuwid(HashMap<String,Object> map); 
	public List<Menu> selectMenuwper(HashMap<String,Object> map);
	public List<Menu> selectMenushang(HashMap<String,Object> map);
}
