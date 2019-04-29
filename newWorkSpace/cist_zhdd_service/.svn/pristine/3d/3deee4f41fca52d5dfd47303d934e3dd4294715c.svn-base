package com.cist.keyarea.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cist.frame.page.PageInfo;
import com.cist.keyarea.model.ZhddHotArea;
import com.cist.keyarea.service.KeyAreaService;

@RestController
@RequestMapping("/keyarea")
public class KeyAreaController {
	@Autowired
	private KeyAreaService service;
	
	/**
	 * 重点区域查询
	 * @param request
	 * 请求
	 */
	@RequestMapping(value="list")
	public PageInfo<ZhddHotArea> list(@RequestBody HashMap<String,Object> map) {
	
		PageInfo pinfo = new PageInfo();
		    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<ZhddHotArea> pageinfo = (PageInfo<ZhddHotArea>)service.listpageList(map,pinfo);
			return pageinfo;
	}
	
	/**
	 * 批量删除
	 * 
	 * @return Integer
	 */
	@RequestMapping(value ="delete")
	public String delete(@RequestBody HashMap<String,Object> modelMap){
//		HashMap<String,Object> modelMap=new HashMap<String, Object>();
//		modelMap.put("pk_id", pk_id);
		Integer delete = service.delete(modelMap);
		 if(delete>0)//1表示更新成功返回的行数
			{
				return "{\"result\":\"删除成功\"}";
			}
			else{
				return "{\"result\":\"删除失败\"}";
			}
		
	}
	/**
	 * 新增重点区域
	 * 
	 * @return String
	 */
	@RequestMapping(value ="save")
	public String save(@RequestBody HashMap<String,Object> map,HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		String deptCode = userMap.get("sypi_dept_pk")==null?null:userMap.get("sypi_dept_pk").toString();
		map.put("fk_dept_id", deptCode);//当前登录用户部门id
		map.put("fk_create_founder_id", userPk);//当前登录用户id
		Integer save = service.save(map);
		 if(save>0)//1表示更新成功返回的行数
			{
				return "{\"result\":\"保存成功\"}";
			}
			else{
				return "{\"result\":\"保存失败\"}";
			}
		
	}
	
	/**
	 * 更新重点区域
	 * 
	 * @return String
	 */
	@RequestMapping(value ="update")
	public String update(@RequestBody HashMap<String,Object> map){
		Integer update = service.update(map);
		 if(update>0)//1表示更新成功返回的行数
			{
				return "{\"result\":\"更新成功\"}";
			}
			else{
				return "{\"result\":\"更新失败\"}";
			}
		
	}
}
