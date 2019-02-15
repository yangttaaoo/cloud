package com.cist.menu.controller;
import java.beans.IntrospectionException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.dept.model.Depart_info;
import com.cist.menu.model.Menu;
import com.cist.menu.service.MenuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/***
 * 
 * @Title:  PictureController.java   
 * @Package com.cist.offsite.controller.firsttrial.picture   
 * @Description:    菜单
 * @author: 王涛    
 * @date:   2018年5月10日 下午4:27:35 
 * @version V1.0
 */
@RestController
@RequestMapping("menu")
public class MenuController{
    
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private MenuService menuService;
   /***
    * 系统菜单
    * @param request
    * @return
    * @throws Exception
    */
	@RequestMapping("getmenuinfo")
	public List<Menu> getToUsers(HttpServletRequest request) throws Exception{
		HashMap<String,Object> map=new HashMap<String, Object>();
		//父菜单  1
		map.put("symi_parent", 16);
		List<Menu> list=menuService.selectMenu(map);
		 return  getdigun(list);
	}
	public List<Menu> getdigun(List<Menu> list){
		HashMap<String,Object> map=new HashMap<String, Object>();
		for (Menu menu : list) {
			map.put("symi_parent", menu.getSymi_pk());
			List<Menu> listdi=menuService.selectMenu(map);
			menu.setChild(listdi);
			if(null!=list){
				getdigun(listdi);
			}
		}
		return list;
	}
	/***
	 * 系统权限菜单
	 */
	@RequestMapping("selectMenuwid")
	public String selectMenuwid(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		HashMap<String,Object> map=new HashMap<String, Object>();
		//父菜单  1
		map.put("symi_level", 1);//顶级菜单级别
		List<Menu> departinfo=menuService.selectMenuwid(map);
		ObjectMapper mapper = new ObjectMapper();	
		List<Menu> list=getdigunwid(departinfo,2); 
		String json=mapper.writeValueAsString(getdiwfdidian(list, modelMap));
		return json.substring(1, json.length()-1);
	}
	public List<HashMap<String, Object>> getdiwfdidian(List<Menu> list,HashMap<String,Object> modelMap){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Menu depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getSymi_pk());
			if(null!=modelMap.get("sypipkinfo")) {
				String ch=modelMap.get("sypipkinfo").toString();
				if(null!=ch&&!ch.equals("")) {
					String h[]=ch.split(",");
					for (String string : h) {
						if(depart_info.getSymi_pk().toString().equals(string)) {
							map.put("checked", true);
						}
					}
				}
			}
			if(null!=depart_info.getChild()) {//下级
				map.put("children", getdiwfdidian(depart_info.getChild(),modelMap));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	public List<Menu> getdigunwid(List<Menu> list,Integer type){
		HashMap<String,Object> map=new HashMap<String, Object>();
		for (Menu menu : list) {
			map.put("symi_parent", menu.getSymi_pk());
			map.put("symi_level",type);//系统级别
			List<Menu> listdi=menuService.selectMenuwid(map);
			menu.setChild(listdi);
			if(null!=list){
				getdigunwid(listdi,3);
			}
		}
		return list;
	}
	//菜单权限
	@RequestMapping("permissions")
	public String permissions(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		List<Menu> departshang=menuService.selectMenushang(modelMap);//上级
        for (Menu menu : departshang) {
        	menu.setIsshangji(true);
		}
		//List<Menu> departinfo=menuService.selectMenuwper(modelMap);
		ObjectMapper mapper = new ObjectMapper();	
		List<Menu> list=getpermissionsinfo(departshang); 
		String json=mapper.writeValueAsString(permissionsinfo(list));
		return json;
	}
	public List<HashMap<String, Object>> permissionsinfo(List<Menu> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Menu depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			String name=depart_info.getNames()+"/"+depart_info.getSymi_name();
			map.put("label", depart_info.getIsshangji()?name:depart_info.getName());
			map.put("value", depart_info.getSymi_pk());
			map.put("checked", false);
			if(null!=depart_info.getChild()) {//下级
				map.put("children", permissionsinfo(depart_info.getChild()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	public List<Menu> getpermissionsinfo(List<Menu> list){
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("datakey", null);
		for (Menu menu : list) {
			map.put("symi_parent", menu.getSymi_pk());
			List<Menu> listdi=menuService.selectMenuwper(map);
			menu.setChild(listdi);
			if(null!=list){
				getpermissionsinfo(listdi);
			}
		}
		return list;
	}
	@RequestMapping("documents")
	public String   documents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> modelMap = new LinkedHashMap<String, Object>();
	
	        //另外下载方式
		String savePath="23123";
		 savePath=request.getSession().getServletContext().getRealPath(savePath);
	     // path是指欲下载的文件的路径。
	        File file = new File(savePath);
	        // 取得文件名。
	        String filename = file.getName();
	        // 取得文件的后缀名。
	        String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
	   
	        // 以流的形式下载文件。
	        InputStream fis = new BufferedInputStream(new FileInputStream(savePath));
	        byte[] buffer = new byte[fis.available()];
	        fis.read(buffer);
	        fis.close();
	        // 清空response
	        response.reset();
	        // 设置response的Header
	        response.addHeader("Content-Disposition", "attachment;filename=" + new String("wtwtwt".getBytes("gb2312"), "ISO8859-1"));
	        response.addHeader("Content-Length", "" + file.length());
	        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
	        response.setContentType("application/octet-stream");
	        toClient.write(buffer);
	        toClient.flush();
	        toClient.close();
		return null;
	}
}
