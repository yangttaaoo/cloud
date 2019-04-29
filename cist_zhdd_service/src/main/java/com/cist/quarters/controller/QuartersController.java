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
import com.cist.quarters.model.Zdcl_car_info;
import com.cist.quarters.service.QuartersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
   *      禁行区域维护
 * @author wangtao
 *
 */
@RestController
@RequestMapping("/jxqy")
public class QuartersController {

	@Autowired
	private QuartersService service; 
	/***
	 * 获取车俩信息
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getpagecar")
	public PageInfo<Zdcl_car_info> getpagecar(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		Integer pageSize= Integer.parseInt(modelMap.get("pageSize").toString());//每页有显示多少条
		//获取分页数据位置,每页显示16条数据
 		PageHelper.startPage(Integer.valueOf(modelMap.get("currentPage").toString()),pageSize, true);
		List<Zdcl_car_info> list= service.pageListZdclcarinfo(modelMap);
		PageInfo<Zdcl_car_info> pageinfo=new PageInfo<Zdcl_car_info>(list,5);
		 return pageinfo;
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
