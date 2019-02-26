package com.cist.police.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.BaseInfo.model.Des3ECB;
import com.cist.dept.service.DeptService;
import com.cist.police.model.Syspoliceinfo;
import com.cist.police.model.Syspolicestatus;
import com.cist.police.model.Syspolicetype;
import com.cist.police.model.Syspost;
import com.cist.police.model.Sysuserauthority;
import com.cist.police.model.Sysuserdataqx;
import com.cist.police.service.PoliceService;
import com.cist.role.model.RoleInfo;
import com.cist.role.model.Sysroleauthority;
import com.cist.role.service.RoleService;
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
@RequestMapping("police")
public class PoliceController{

	@Value("${server.port}")
	private String port;
	@Autowired
	private DeptService deptService;
	@Autowired
	private PoliceService policeService;
	@Autowired
	private RoleService roleService;//角色
	/***
	 * 
	 * @Title:  PoliceController.java   
	 * @Package com.cist.police.controller   
	 * @Description:    警员用户分页查询 
	 * @author: 王涛    
	 * @date:   2018年6月12日 上午9:41:18 
	 * @param: @param request
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<Syspoliceinfo>      
	 * @throws 
	 * @version V1.0
	 */
	@RequestMapping("getpolice")
	public PageInfo<Syspoliceinfo> getToUsers(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		//获取分页数据位置,每页显示16条数据pageSize
		Integer pageSize= Integer.parseInt(modelMap.get("pageSize").toString());//每页有显示多少条
		//currentPage  当前位置
 		PageHelper.startPage(Integer.valueOf(modelMap.get("currentPage").toString()), pageSize, true);
		List<Syspoliceinfo> list=policeService.selectSyspoliceinfo(modelMap);
		PageInfo<Syspoliceinfo> pageinfo=new PageInfo<Syspoliceinfo>(list,5);
		pageinfo.setNavigatepageNums(null);
		return pageinfo;
	}
	/***
	 * 人员类型
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("selectSyspolicetype")
	public List<Syspolicetype> selectSyspolicetype() throws Exception{
		List<Syspolicetype> list=policeService.selectSyspolicetype();
	/*	for (Syspolicetype syspolicetype : list) {
			syspolicetype.setCode(syspolicetype.getFc_code().trim());
		}*/
		return list;
	}
	/***
	 * 角色
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("jueseauthority")
	public List<Sysroleauthority> jueseauthority(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		List<Sysroleauthority> list=roleService.selectSysuserauthority(modelMap);
		return list;
	}
	/***
	 * 重置密码
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updatwpwd")
	public Integer updatwpwd(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		modelMap.put("sypi_comp",Des3ECB.EncoderByMd5(modelMap.get("sypi_code")+"123456"));
		return policeService.updatwpwd(modelMap);//sypi_name
	}
	/***
	 * 所有角色信息
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("selectRole")
	public List<RoleInfo> selectRole() throws Exception{
		return policeService.selectRole();
	}
	/***
	 * 删除用户信息
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deluserpolise")
	public Integer deluserpolise(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		String 	dept_pk=modelMap.get("sypi_pk").toString();
		 String pk[]=dept_pk.split(",");
		modelMap.put("sypi_pk", dept_pk.split(","));
		//删除用户
		int a=policeService.deluserpolise(modelMap);
		for (String string : pk) {
			modelMap.put("sypi_pk", string);
			//删除当前用户授权信息
			policeService.delusersq(modelMap);
			//删除当前用户数据权限
			policeService.deluserdataqx(modelMap);
			//删除当前用户部门授权信息
			deptService.deldeptauthority(modelMap); 
		}
		return 1;
	}
	/***
	 * 用户数据权限
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("sysuserdataqx")
	public List<Sysuserdataqx> sysuserdataqx(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		return policeService.sysuserdataqx(modelMap);
	}
	/***
	 * 查询警员职位
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("selectSyspost")
	public List<Syspost> selectSyspost() throws Exception{
		return policeService.selectSyspost();
	}
	/***
	 * 状态
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("selectSyspolicestatus")
	public List<Syspolicestatus> selectSyspolicestatus() throws Exception{
		return policeService.selectSyspolicestatus();
	}
	/***
	 * 当前用户授权信息
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("selectSysuserauthority")
	public HashMap<String,Object>  selectSysuserauthority(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		List<Sysuserauthority> list=policeService.selectSysuserauthority(modelMap);
		modelMap.put("authority", list);
		modelMap.put("datakey", list);
		if(list.size()!=0) {
			modelMap.put("authoritycai", policeService.selectSysuserauthorityleve(modelMap));
		}
		return modelMap;
	}
	/***
	 * 当前用户部门数据权限
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deptdataauthority")
	public List<Sysuserauthority> deptdataauthority(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		List<Sysuserauthority> list=policeService.deptdataauthority(modelMap);
		return list;
	}
	/***
	 * 修改密码
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("changePassword")
	public HashMap<String,Object> changePassword(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		Syspoliceinfo syspoliceinfo=policeService.syspoliceinfo(modelMap);
		String old=Des3ECB.EncoderByMd5(syspoliceinfo.getSypi_code()+modelMap.get("oldpassword"));//原密码
		if(old.equals(syspoliceinfo.getSypi_comp())) {//原密码和新密码是否一直
			modelMap.put("sypi_comp",Des3ECB.EncoderByMd5(syspoliceinfo.getSypi_code()+modelMap.get("newpassword")));
		   policeService.updatwpwd(modelMap);
		   modelMap.put("start", "1");
		  // modelMap.put("msg", "更新成功");
		   return modelMap;
		}else {
			 modelMap.put("start", "2");
			//modelMap.put("msg", "原密码不正确");
			return modelMap;
		}
		
	}
	
	@RequestMapping("zijiedian")
	public HashMap<String,Object> zijiedian(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		String pk=modelMap.get("dept").toString();
		List<String> list=new ArrayList<String>();
		if(pk.length()>2) {
			String userpk[]=pk.substring(1, pk.length()-1).split(",");
			for (String string : userpk) {
				modelMap.put("dept_pk", string);
				if(policeService.zijiedian(modelMap)==0) {//无下级
					list.add(string.trim());
				}
			}
		}
		modelMap.put("list", list);
		return modelMap;
	}
	@RequestMapping("sSyspoliceinfo")
	public String sSyspoliceinfo(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		List<Syspoliceinfo>  list=  policeService.sSyspoliceinfo(modelMap);
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Syspoliceinfo syspoliceinfo : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("label", syspoliceinfo.getSypi_name());
			map.put("value", syspoliceinfo.getSypi_pk());
			map.put("checked", false);
			listmap.add(map);
		}
		ObjectMapper mapper = new ObjectMapper();	
		String json=mapper.writeValueAsString(listmap);
		return json;
	}
	
	/***
	 * 添加警员权限信息
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addSyspoliceinfo")
	public Integer addSyspoliceinfo(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		modelMap.put("sypi_pvp", df.parse(modelMap.get("sypi_pvp").toString()));
		modelMap.put("sypi_avp", df.parse(modelMap.get("sypi_avp").toString()));
		System.err.println(modelMap.get("sypi_tel"));
		modelMap.put("SYPI_PK", null);//用户主键
		modelMap.put("sypi_comp", Des3ECB.EncoderByMd5(modelMap.get("sypi_code")+"123456"));
		int res=policeService.addSyspoliceinfo(modelMap);//添加用户信息
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
			policeService.addsysuserauthority(list);//添加用户授权
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
			deptService.addbumenquanx(list);//保存部门数据权限
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
			policeService.addbumenquanx(list);
			}
			return 1;
		}
		return 2;
	}
	/***
	 * 修改警员权限信息
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updateSyspoliceinfo")
	public Integer updateSyspoliceinfo(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		modelMap.put("sypi_pvp", df.parse(modelMap.get("sypi_pvp").toString()));
		modelMap.put("sypi_avp", df.parse(modelMap.get("sypi_avp").toString()));
		int res=policeService.updateSyspoliceinfo(modelMap);//更新用户信息
		modelMap.put("sypi_comp",Des3ECB.EncoderByMd5(modelMap.get("sypi_code")+"123456"));
		 policeService.updatwpwd(modelMap);//sypi_name
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
			policeService.delusersq(modelMap);//删除当前用户授权的信息
			policeService.addsysuserauthority(list);//添加用户授权
			}
			if(userrights.equals("[]")) {//用户权限选中等于null 没有任何权限
				policeService.delusersq(modelMap);//删除当前用户授权的信息
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
			deptService.deldeptauthority(modelMap);//删除当前用户部门授权信息
			deptService.addbumenquanx(list);//保存部门数据权限
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
			policeService.deluserdataqx(modelMap);//删除当前用户数据权限
			policeService.addbumenquanx(list);//保存当前用户数据权限
			}
			return 1;
		}
		return 2;
	}

}
