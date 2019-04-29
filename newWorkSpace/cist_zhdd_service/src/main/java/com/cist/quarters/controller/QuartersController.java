package com.cist.quarters.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.quarters.model.Depart_info;
import com.cist.quarters.model.Functionconf;
import com.cist.quarters.model.Functiontype;
import com.cist.quarters.model.Postglinfo;
import com.cist.quarters.model.Postinfo;
import com.cist.quarters.service.QuartersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@RestController
@RequestMapping("/quarters")
public class QuartersController {

	
	@Autowired
	private QuartersService service;
	/***
	 * 岗位分页查询
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("querylist")
	public PageInfo<Postinfo> querylist(@RequestBody HashMap<String,Object> modelMap ){
		Integer pageSize= Integer.parseInt(modelMap.get("pageSize").toString());//每页有显示多少条
		//获取分页数据位置,每页显示16条数据
 		PageHelper.startPage(Integer.valueOf(modelMap.get("currentPage").toString()),pageSize, true);
		List<Postinfo> list= service.querylistpageList(modelMap);
		PageInfo<Postinfo> pageinfo=new PageInfo<Postinfo>(list, 5);
		return pageinfo;
	}
	/***
	 * 删除岗位信息
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("depost")
	public Integer depost(@RequestBody HashMap<String,Object> modelMap ){
		int a=service.delpostinfo(modelMap);//删除岗位信息
		service.delpostinfogl(modelMap);//删除岗位关联的信息
		return a;
	}
	/***
	 * 获取岗位信息的岗位关联配置
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("postglinfo")
	public List<Postglinfo> postglinfo(@RequestBody HashMap<String,Object> modelMap ){
		return service.selectPostglinfo(modelMap);//删除岗位关联的信息
	}
	
   /***
    * 添加岗位信息
    * @param modelMap
    * @return
    * @throws Exception
    */
	@SuppressWarnings("unchecked")
	@RequestMapping("addpost")
	public Integer permissions(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String fk_dept_id=userMap.get("sypi_dept_pk").toString();
		Postinfo postinfo=new Postinfo();
		postinfo.setFk_dept_id(fk_dept_id);
		postinfo.setPost_name(modelMap.get("post_name").toString());
		postinfo.setRemarks(null!=modelMap.get("remarks")?modelMap.get("remarks").toString():"");
		if(modelMap.get("is_default").toString().equals("true")) {////是否默认（0：否、1：是）
			service.updatemo();//初始化默认岗位
			postinfo.setIs_default(1);
		}else {
			postinfo.setIs_default(0);
		}
		postinfo.setPost_time(new Date());
		Integer a= service.addPostinfo(postinfo);
		String functionconf=modelMap.get("fk_function_conf_id").toString();
		functionconf=functionconf.substring(1,functionconf.length()-1);
		String confid[]=functionconf.split(",");
		
		List<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
		if(!functionconf.equals("")) {//岗位基础配置
			for (String string : confid) {
				HashMap<String,Object> m=new HashMap<String,Object>();
				m.put("FK_POST_ID", postinfo.getPk_id());
				m.put("FK_FUNCTION_CONF_ID",string);
				list.add(m);
			}
			service.addPostglinfo(list);
		}
		return a;
	}
	   /***
	    * 更新岗位信息
	    * @param modelMap
	    * @return
	    * @throws Exception
	    */
		@SuppressWarnings("unchecked")
		@RequestMapping("updatepost")
		public Integer updatepost(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request) throws Exception{
			HttpSession session = request.getSession();
			Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
			String fk_dept_id=userMap.get("sypi_dept_pk").toString();
			Postinfo postinfo=new Postinfo();
			postinfo.setFk_dept_id(fk_dept_id);
			postinfo.setPost_name(modelMap.get("post_name").toString());
			postinfo.setRemarks(null!=modelMap.get("remarks")?modelMap.get("remarks").toString():"");
			if(modelMap.get("is_default").toString().equals("true")) {////是否默认（0：否、1：是）
				service.updatemo();//初始化默认岗位
				postinfo.setIs_default(1);
			}else {
				postinfo.setIs_default(0);
			}
			postinfo.setPost_time(new Date());
			postinfo.setPk_id(Integer.valueOf(modelMap.get("pk_id").toString()));
			Integer a= service.updatePostinfo(postinfo);
			String functionconf=modelMap.get("fk_function_conf_id").toString();
			functionconf=functionconf.substring(1,functionconf.length()-1);
			String confid[]=functionconf.split(",");
			
			List<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
			modelMap.put("pk_id", postinfo.getPk_id());
			service.delpostinfogl(modelMap);
			if(!functionconf.equals("")) {//岗位基础配置
				for (String string : confid) {
					HashMap<String,Object> m=new HashMap<String,Object>();
					m.put("FK_POST_ID", postinfo.getPk_id());
					m.put("FK_FUNCTION_CONF_ID",string);
					list.add(m);
				}
				service.addPostglinfo(list);
			}
			return a;
		}
	/**
	  * 获取配置基础信息
	  * @param map
	 * @throws JsonProcessingException 
	  */
	@RequestMapping("conf")
	public String  conf() throws JsonProcessingException{
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		List<Functiontype> list=service.functiontypeList();
		for (Functiontype functiontype : list) {
			HashMap<String,Object> modelMap=new HashMap<String,Object>();
			modelMap.put("fk_function_type_id", functiontype.getPk_id());
			List<Functionconf>	conf=service.fssunctionconf(modelMap);
			functiontype.setFunctionconf(conf);
			
			modelMap.put("jsoninfo", permissionsinfo(conf));
			modelMap.put("functiontype", functiontype);
			listmap.add(modelMap);
		}
		
		ObjectMapper mapper = new ObjectMapper();	
		String json=mapper.writeValueAsString(listmap);
		return json;
	}
	public List<HashMap<String, Object>> permissionsinfo(List<Functionconf> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
	
		for (Functionconf functionconf : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("label",functionconf.getFunction_content());
			map.put("value",functionconf.getPk_id());
			map.put("checked", false);
			listmap.add(map);
		}
		return listmap;
		
	}
	/***
	 * 
	 * @Title:  PictureController.java   
	 * @Package com.cist.picture.controller   
	 * @Description:    部门树
	 * @author: 王涛    
	 * @date:   2018年5月16日 上午9:13:10 
	 * @param: @return      
	 * @return: List<Depart_info>      
	 * @throws JsonProcessingException 
	 * @throws 
	 * @version V1.0  
	 */
	@RequestMapping("departinfo")
	public String departinfo() throws JsonProcessingException{
    //顶级部门 null
	List<Depart_info>	departinfo=service.depart_infolist(null);
	ObjectMapper mapper = new ObjectMapper();	
	List<Depart_info> list=departinfodg(departinfo); 
	String json=mapper.writeValueAsString(getdiwfdidian(list));
	return json.substring(1, json.length()-1);
	}
	public List<Depart_info> departinfodg(List<Depart_info> departinfo){
		for (Depart_info depart_info : departinfo) {
			List<Depart_info> list= service.depart_infolist(depart_info.getDept_pk());
			depart_info.setChildren(list);
			if(null!=list){
				departinfodg(list);
			}
		}
		return departinfo;
	}
	public List<HashMap<String, Object>> getdiwfdidian(List<Depart_info> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_pk().toString());
			map.put("isLeaf", depart_info.getIsLeaf());
			map.put("data", depart_info.getGeo_spatial());
			
			if(null!=depart_info.getChildren()) {//下级
				
				map.put("children", getdiwfdidian(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
}
