package com.cist.role.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.police.model.Sysuserauthority;
import com.cist.police.model.Sysuserdataqx;
import com.cist.role.model.RoleInfo;
import com.cist.role.model.Sysroleauthority;
import com.cist.role.model.Sysroledataqx;
import com.cist.role.service.RoleService;

/***
 * 
 * @Title:  KerisController.java   
 * @Package com.cist.kreis.controller
 * @Description:    角色管理
 * @author: 田隽杭    
 * @date:   2018年6月27日 下午7:55:35 
 * @version V1.0
 */
@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService service;
	
	/**
	 * 角色管理首页查询
	 * @param map
	 */
	@RequestMapping("roleInfoList")
    public PageInfo<RoleInfo> redInfopageList(@RequestBody HashMap<String,Object> modelMap ){
    	PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
    	PageInfo<RoleInfo> list= (PageInfo<RoleInfo>)service.roleInfopageList(modelMap,pinfo);
    	for (int i = 0; i < list.getList().size(); i++) {
    		if(list.getList().get(i).getSyri_flag().equals("1")){
    			list.getList().get(i).setSyri_flag_name("启用");
    		}else {
    			list.getList().get(i).setSyri_flag_name("禁用");
			}
		}
		return list;
	}
	/***
	 * 当前角色授权信息
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("selectSysuserauthority")
	public HashMap<String,Object>  selectSysuserauthority(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		List<Sysroleauthority> list=service.selectSysuserauthority(modelMap);
		modelMap.put("authority", list);
		modelMap.put("datakey", list);
		if(list.size()!=0) {
			modelMap.put("authoritycai", service.selectSysuserauthorityleve(modelMap));
		}
		return modelMap;
	}
	/***
	 * 当前角色部门数据权限
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deptdataauthority")
	public List<Sysroleauthority> deptdataauthority(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		List<Sysroleauthority> list=service.deptdataauthority(modelMap);
		return list;
	}
	/***
	 * 用户数据权限
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("sysuserdataqx")
	public List<Sysroledataqx> sysuserdataqx(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		return service.sysuserdataqx(modelMap);
	}
	//添加
		@RequestMapping("addSyspoliceinfo")
		public Integer addSyspoliceinfo(@RequestBody HashMap<String,Object> modelMap) throws Exception{
			modelMap.put("SYPI_PK", null);//用户主键
			modelMap.put("dept_pk", 3871);
			modelMap.put("syri_buider", "杨茂林2");
			int res=service.addSyspoliceinfo(modelMap);//添加用户信息
			if(res>0) {//添加成功
				List<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
				String userrights=modelMap.get("Userrights").toString();
				if(null!=userrights) {
					if(userrights.length()>2) {
						userrights=userrights.substring(1, userrights.length()-1);
					}
					String inf[]=userrights.split(",");
					for (String string : inf) {
						HashMap<String,Object> map=new HashMap<String, Object>();
						map.put("sypi_pk", modelMap.get("SYPI_PK"));//用户主键
						map.put("symi_pk", string);
						list.add(map);
					}
				}
				if(userrights.length()>2) {
					service.addsysuserauthority(list);//添加用户授权
				}
				list=new ArrayList<HashMap<String,Object>>();
				String departmentaldata=modelMap.get("departmentaldata").toString();
				String departmentaldatainfo=modelMap.get("departmentaldatainfo").toString();
				if(null!=departmentaldata) {
					if(departmentaldata.length()>2) {
						departmentaldata=departmentaldata.substring(1, departmentaldata.length()-1);
						departmentaldatainfo=departmentaldatainfo.substring(1, departmentaldatainfo.length()-1);
					}
					String inf[]=departmentaldata.split(",");
					for (String string : inf) {
						HashMap<String,Object> map=new HashMap<String, Object>();
						map.put("sypi_pk", modelMap.get("SYPI_PK"));//用户主键
						map.put("dept_pk", string);
						map.put("dept_pk_lev", departmentaldatainfo);
						list.add(map);
					}
				}
				if(departmentaldata.length()>2) {
					service.addDept(list);//保存部门数据权限
				}
				list=new ArrayList<HashMap<String,Object>>();
				String uservalue=modelMap.get("uservalue").toString();
				if(null!=uservalue) {
					if(uservalue.length()>2) {
						uservalue=uservalue.substring(1, uservalue.length()-1);
					}
					String inf[]=uservalue.split(",");
					for (String string : inf) {
						HashMap<String,Object> map=new HashMap<String, Object>();
						map.put("sypi_pk", modelMap.get("SYPI_PK"));//用户主键
						map.put("sypi_pks", string);
						list.add(map);
					}
				}
				
				if(uservalue.length()>2) {
					service.addbumenquanx(list);
				}
				return 1;
			}
			return 2;
		}
		/***
		 * 删除角色信息
		 * @param modelMap
		 * @return
		 * @throws Exception
		 */
		@RequestMapping("delrole")
		public Integer deluserpolise(@RequestBody HashMap<String,Object> modelMap) throws Exception{
			String 	dept_pk=modelMap.get("syri_pk").toString();
			 String pk[]=dept_pk.split(",");
			modelMap.put("sypi_pk", dept_pk.split(","));
			//删除角色
			int a=service.deluserpolise(modelMap);
			for (String string : pk) {
				modelMap.put("sypi_pk", string);
				//删除当前角色授权信息
				service.delusersq(modelMap);
				//删除当前角色数据权限
				service.deluserdataqx(modelMap);
				//删除当前角色部门授权信息
				service.deldeptauthority(modelMap); 
			}
			return 1;
		}
		//修改
		@RequestMapping("updateSyspoliceinfo")
		public Integer updateSyspoliceinfo(@RequestBody HashMap<String,Object> modelMap) throws Exception{
			modelMap.put("dept_pk", 3871);
			modelMap.put("syri_buider", "杨茂林2");
			int res=service.updateSysroleinfo(modelMap);//更新用户信息
			if(res>0) {//更新成功
				List<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
				String userrights=modelMap.get("Userrights").toString();
				if(null!=userrights) {
					if(userrights.length()>2) {
						userrights=userrights.substring(1, userrights.length()-1);
					}
					String inf[]=userrights.split(",");
					for (String string : inf) {
						HashMap<String,Object> map=new HashMap<String, Object>();
						map.put("sypi_pk", modelMap.get("sypi_pk"));//用户主键
						map.put("symi_pk", string);
						list.add(map);
					}
				}
				if(userrights.length()>2) {
					service.delusersq(modelMap);//删除当前用户授权的信息
					service.addsysuserauthority(list);//添加用户授权
				}
				list=new ArrayList<HashMap<String,Object>>();
				String departmentaldata=modelMap.get("departmentaldata").toString();
				String departmentaldatainfo=modelMap.get("departmentaldatainfo").toString();
				if(null!=departmentaldata) {
					if(departmentaldata.length()>2) {
						departmentaldata=departmentaldata.substring(1, departmentaldata.length()-1);
						departmentaldatainfo=departmentaldatainfo.substring(1, departmentaldatainfo.length()-1);
					}
					String inf[]=departmentaldata.split(",");
					for (String string : inf) {
						HashMap<String,Object> map=new HashMap<String, Object>();
						map.put("sypi_pk", modelMap.get("sypi_pk"));//用户主键
						map.put("dept_pk", string);
						map.put("dept_pk_lev", departmentaldatainfo);
						list.add(map);
					}
				}
				if(departmentaldata.length()>2) {
					service.deldeptauthority(modelMap);//删除当前用户部门授权信息
					service.addDept(list);//保存部门数据权限
				}
				list=new ArrayList<HashMap<String,Object>>();
				String uservalue=modelMap.get("uservalue").toString();
				if(null!=uservalue) {
					if(uservalue.length()>2) {
						uservalue=uservalue.substring(1, uservalue.length()-1);
					}
					String inf[]=uservalue.split(",");
					for (String string : inf) {
						HashMap<String,Object> map=new HashMap<String, Object>();
						map.put("sypi_pk", modelMap.get("sypi_pk"));//用户主键
						map.put("sypi_pks", string);
						list.add(map);
					}
				}
				if(uservalue.length()>2) {
					service.deluserdataqx(modelMap);//删除当前用户数据权限
					service.addbumenquanx(list);//保存当前用户数据权限
				}
				return 1;
			}
			return 2;
		}
}
