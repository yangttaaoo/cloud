package com.cist.orbit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cist.frame.page.PageInfo;
import com.cist.orbit.model.Depart_info;
import com.cist.orbit.model.TblCarRecoInfo;
import com.cist.orbit.service.OrbitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/orbit")
public class OrbitController {


	@Autowired
	OrbitService service;
	
	/**
	 * 车辆轨迹查询 条件查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="list")
	public PageInfo<TblCarRecoInfo> list(@RequestBody HashMap<String,Object> map) {
		try{	
				ArrayList sbbh=(ArrayList)map.get("sbbh");
				//设备编号多选编号分隔数组用作查询
				if(sbbh.size()>0)
				{
						map.put("list", sbbh);
				}
	PageInfo pinfo = new PageInfo();
		    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<TblCarRecoInfo> pageinfo = (PageInfo<TblCarRecoInfo>)service.listpageList(map,pinfo);
			return pageinfo;
			}catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
	/**
	 * 首页条件框数据查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="index")
	public HashMap<String,Object> index(@RequestBody HashMap<String,Object> map) {
		    map.put("road", service.selectRoadList(map));//所属道路
			map.put("hpzl", service.selectSysFrmCode("C001"));//号牌种类
			return map;
	}
	/**
	 * 上一条下一条数据查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="selectOne")
	public Map<String,Object> selectOne(@RequestBody HashMap<String,Object> map,HttpServletRequest request) {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		PageInfo<TblCarRecoInfo> list = list(map);
		  modelMap.put("list",list);
		return modelMap;
	}
	
	@RequestMapping("mendepartinfo")
	public String mendepartinfo() throws JsonProcessingException{
    //顶级部门 null
	List<Depart_info>	departinfo=service.depart_infolist(null);
	ObjectMapper mapper = new ObjectMapper();	
	List<Depart_info> list=departinfodgmen(departinfo); 
	String json=mapper.writeValueAsString(getdiwfdidianmen(list));
	return json.substring(1, json.length()-1);
	}	
	public List<HashMap<String, Object>> getdiwfdidianmen(List<Depart_info> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_pk().toString());
			map.put("isLeaf", depart_info.getIsLeaf());
			if(null!=depart_info.getChildren()) {//下级
				map.put("children", getdiwfdidianmen(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	public List<Depart_info> departinfodgmen(List<Depart_info> departinfo){
		for (Depart_info depart_info : departinfo) {
			List<Depart_info> list= service.depart_infolist(depart_info.getDept_pk());
			depart_info.setChildren(list);
			if(null!=list){
				departinfodgmen(list);
			}
		}
		return departinfo;
	}
	/***
	 * 
	 * @Title:  PictureController.java   
	 * @Package com.cist.picture.controller   
	 * @Description:    点击部门树获取设备列表
	 * @author: 王涛    
	 * @date:   2018年5月16日 上午9:13:10 
	 * @param: @return      
	 * @return: List<Depart_info>      
	 * @throws JsonProcessingException 
	 * @throws 
	 * @version V1.0  
	 */
	@RequestMapping("clickdepartinfo")
	public String clickdepartinfo(@RequestBody HashMap<String,Object> modelMap) throws JsonProcessingException{

	List<Depart_info>	departinfo=service.clickdepartinfo(modelMap.get("dept_pk").toString());
	ObjectMapper mapper = new ObjectMapper();	
	List<Depart_info> list=clickdepartinfodg(departinfo); 
	String json=mapper.writeValueAsString(getdiwfdidianckick(list));
	return json;
	}	
	public List<HashMap<String, Object>> getdiwfdidianckick(List<Depart_info> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getTbei_name());
			map.put("key", depart_info.getTbec_kkbh());
			if(null!=depart_info.getChildren()) {//下级
				map.put("children", getdiwfdidianckick(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	public List<Depart_info> clickdepartinfodg(List<Depart_info> departinfo){
		for (Depart_info depart_info : departinfo) {
			List<Depart_info> list= service.kakou(depart_info.getTbec_kkbh());//卡口编码
			depart_info.setChildren(list);
		}
		return departinfo;
	}
	/***
	 * 
	 * @Title:  PictureController.java   
	 * @Package com.cist.picture.controller   
	 * @Description:    点击部门树获取设备列表
	 * @author: 王涛    
	 * @date:   2018年5月16日 上午9:13:10 
	 * @param: @return      
	 * @return: List<Depart_info>      
	 * @throws JsonProcessingException 
	 * @throws 
	 * @version V1.0   
	 */
	@RequestMapping("yijickdepartinfo")
	public String yijickdepartinfo(@RequestBody HashMap<String,Object> modelMap) throws JsonProcessingException{
		List<Depart_info>	departinfo=service.yijicdepartinfo(modelMap);
		ObjectMapper mapper = new ObjectMapper();	
		modelMap.put("departinfo", departinfo);
		List<Depart_info> list=clickdeparckd(modelMap); 
		String json=mapper.writeValueAsString(getdiwfdidianckick(list));
		return json;
	}
	public List<Depart_info> clickdeparckd(HashMap<String,Object> modelMap){
		@SuppressWarnings("unchecked")
		List<Depart_info>	departinfo= (List<Depart_info>) modelMap.get("departinfo");
		for (Depart_info depart_info : departinfo) {
			modelMap.put("tbec_kkbh", depart_info.getTbec_kkbh());
			List<Depart_info> list= service.kakouxiabu(modelMap);//卡口编码
			depart_info.setChildren(list);
		}
		return departinfo;
	}
}
