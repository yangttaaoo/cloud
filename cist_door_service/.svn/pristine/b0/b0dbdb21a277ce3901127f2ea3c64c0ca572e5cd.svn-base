package com.cist.menupurview.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cist.menupurview.model.SysModuleInfo;
import com.cist.menupurview.service.MenuPurviewService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cist.frame.page.PageInfo;
/***
 * 
 * @Title:  MenuPurviewController.java   
 * @Package com.cist.menupurview.controller   
 * @Description:    菜单权限维护
 * @author: yt
 * @date:   2018年5月10日 下午4:27:35 
 * @version V1.0
 */


@RestController
@RequestMapping("menupurview")
public class MenuPurviewController{
	
	@Autowired
	private MenuPurviewService service;
	
	 /***
	    * 上级菜单树
	    * @param request
	    * @return String
	    * @throws Exception
	    */
	@RequestMapping("menuTree")
	public String getToUsers(HttpServletRequest request) throws Exception{
		HashMap<String,Object> map=new HashMap<String, Object>();
		//菜单树顶级菜单
		map.put("symi_level", 1);
		List<SysModuleInfo> selectMenu = service.selectMenu(map);
		ObjectMapper mapper = new ObjectMapper();
		List<SysModuleInfo> list = acquisition(selectMenu);
		String json=mapper.writeValueAsString(getmenu(list));
		return json.substring(1, json.length()-1);
	}
	
	/***
	    * 保存菜单
	    * @param HashMap<String,Object>
	    * @return String
	    * @throws 
	    */
	@RequestMapping("save")
	public String save(@RequestBody HashMap<String,Object> map,HttpServletRequest req){
		
		Integer save = service.save(map);
		 if(save==1)//1表示更新成功返回的行数
			{
			if(map.get("symi_type").equals("5")||map.get("symi_type").equals("4")) 
			{
//				Object refresh = service1.refresh();
			}
			
				return "{\"result\":\"保存成功\"}";
			}
			else{
				return "{\"result\":\"保存失败\"}";
			}
	
	}
	
	/***
	    * 条件查询
	    * @param HashMap<String,Object>
	    * @return PageInfo<SysModuleInfo>
	    * @throws 
	    */
	@RequestMapping("list")
	public PageInfo<SysModuleInfo> select(@RequestBody HashMap<String,Object> map){
		try{	
		PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<SysModuleInfo> pageinfo=(PageInfo<SysModuleInfo>)service.listpageList(map, pinfo);
		 return pageinfo;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/***
	    * 删除和批量删除
	    * @param String []
	    * @return String
	    * @throws 
	    */
	@RequestMapping("delete")
	public String delete(@RequestParam("symi_pk") String [] symi_pk){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		modelMap.put("symi_pk", symi_pk);
		Integer delete = service.delete(modelMap);
		 if(delete>0)//1表示删除成功返回的行数
			{
				return "{\"result\":\"删除成功\"}";
			}
			else{
				return "{\"result\":\"删除失败\"}";
			}
	
	}
	
	/***
	    * 更新
	    * @param HashMap<String,Object>
	    * @return String
	    * @throws 
	    */
	@RequestMapping("update")
	public String update(@RequestBody HashMap<String,Object> map){
		Integer update = service.update(map);
		 if(update>0)//1表示删除成功返回的行数
			{
				return "{\"result\":\"更新成功\"}";
			}
			else{
				return "{\"result\":\"更新失败\"}";
			}
	
	}
	
	
	public List<HashMap<String, Object>> getmenu(List<SysModuleInfo> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (SysModuleInfo sys : list) {
			HashMap<String, Object> map=new HashMap();
			map.put("title", sys.getSymi_name());
			map.put("key", sys.getSymi_pk());
			map.put("disableCheckbox", sys.getSymi_status()!=1?false:true);
			
			if(0!=sys.getChildren().size()) {//下级
				map.put("isLeaf", false);
				map.put("children", getmenu(sys.getChildren()));
				listmap.add(map);
			}else {
				map.put("isLeaf", true);
				listmap.add(map);
			}
		}
		return listmap;
	}
	public List<SysModuleInfo> acquisition(List<SysModuleInfo> sysModuleInfo){
		for (SysModuleInfo sys : sysModuleInfo) {
			//顶级菜单下的系统
			List<SysModuleInfo> list1=new ArrayList<SysModuleInfo>();
			sys.setChildren(list1);
			List<SysModuleInfo> list= service.acquisition(sys.getSymi_pk());//根据上一级菜单查询下一级菜单
			for (SysModuleInfo sysModuleInfo2 : list) {
				sys.getChildren().add(sysModuleInfo2);
			}
			if(null!=list){
				acquisition(list);
			}
		}
		return sysModuleInfo;
	}
}
