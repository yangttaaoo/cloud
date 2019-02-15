package com.cist.qwgl.qwjg.controller;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.qwgl.qwbb.model.Jcsj_police_res_person;
import com.cist.qwgl.qwbb.model.Qw_report;
import com.cist.qwgl.qwbb.model.Qw_sign_in;
import com.cist.qwgl.qwbb.model.Qwpbdata;
import com.cist.qwgl.qwbb.model.Syspoliceinfo;
import com.cist.qwgl.qwbb.service.QwbbService;
import com.cist.qwgl.qwjg.model.Jcsj_police_resources;
import com.cist.qwgl.qwjg.model.Qw_patrol_alarm_log;
import com.cist.qwgl.qwjg.service.QwjgService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@RestController
@RequestMapping("qwjk")
public class QwjgController {
	@Autowired
	private QwjgService service;
	@Autowired
	private QwbbService bbservice;

	/***
	 * 查询执勤任务列表
	 * @param modelMap
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping("qwreport")
	public List<Qw_report> fctlist(@RequestBody HashMap<String,Object> modelMap ) throws IllegalAccessException, InvocationTargetException{
		List<Qw_report> list=	service.selectQw_report(modelMap);
		for (Qw_report qw_report : list) {
			modelMap.put("pk_id",qw_report.getPk_id());//勤务报备id 
		}
		 return list;
	}
	/***
	 * 查询勤务排班信息
	 * @param modelMap
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping("selectqwpbdata")
	public List<Qwpbdata> selectqwpbdata(@RequestBody HashMap<String,Object> modelMap ) throws IllegalAccessException, InvocationTargetException{
		List<Qwpbdata> list=service.selectQwpbdata(modelMap);
		for (Qwpbdata qwpbdata : list) {
			modelMap.put("fk_dept_id", qwpbdata.getFk_dept_id());
			qwpbdata.setQwpbdatainfo(service.qwpbdataxunqu(modelMap));
		}
		 return list;
	}
	/**
	 * 签到数据
	 * @param modelMap
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("qwsignin")
	public HashMap<String,Object> qw_sign_in(@RequestBody HashMap<String,Object> modelMap ) throws IllegalAccessException, InvocationTargetException{
		List<Qw_sign_in> list=service.qw_sign_in(modelMap);
		modelMap.put("qw_sign_in", list);
		modelMap.put("qiangzi", service.qiangzi(modelMap));
		return modelMap;
	}
	
	/***
	 * gps警车警员信息
	 * @param modelMap
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("jcsjpoliceresources")
	public HashMap<String,Object> jcsjpoliceresources(@RequestBody HashMap<String,Object> modelMap ) throws IllegalAccessException, InvocationTargetException{
		List<Qw_report> list=service.qwreportjg(modelMap);//警员数据
		modelMap.put("jingyuandata", list);
		 return modelMap;
	}
	
	
	/***
	 * 勤务排班信息 预警信息
	 * @param modelMap
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping("qinwuyujing")
	public List<Qw_patrol_alarm_log> qinwuyujing(@RequestBody HashMap<String,Object> modelMap ) throws IllegalAccessException, InvocationTargetException{

		 return service.yujingxinx(modelMap);
	}
	/***
	 * 查询基础信息
	 * @param modelMap
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("selectjichuxin")
	public HashMap<String,Object> selectjichuxin(@RequestBody HashMap<String,Object> modelMap ) throws IllegalAccessException, InvocationTargetException{
		modelMap.put("fct_code", "JW02");
		modelMap.put("cheliangyonghu", service.selectjichuxin(modelMap));//车辆用户
		modelMap.put("fct_code", "C110");
		modelMap.put("cheliangpingpai", service.selectjichuxin(modelMap));//车辆品牌
		return modelMap;
	}
	
	/***
	 * 警务资源——获取警员信息
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getpolice")
	public PageInfo<Jcsj_police_res_person> getToUsers(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		Integer pageSize= Integer.parseInt(modelMap.get("pageSize").toString());//每页有显示多少条
		//获取分页数据位置,每页显示16条数据
 		PageHelper.startPage(Integer.valueOf(modelMap.get("currentPage").toString()),pageSize, true);
		List<Jcsj_police_res_person> list= service.pageListSyspoliceinfo(modelMap);
		PageInfo<Jcsj_police_res_person> pageinfo=new PageInfo<Jcsj_police_res_person>(list,5);
		 return pageinfo;
	}
	/***
	 * 警务资源——获取警车信息
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getpolicejinche")
	public PageInfo<Jcsj_police_resources> getpolicejinche(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		Integer pageSize= Integer.parseInt(modelMap.get("pageSize").toString());//每页有显示多少条
		//获取分页数据位置,每页显示16条数据
 		PageHelper.startPage(Integer.valueOf(modelMap.get("currentPage").toString()),pageSize, true);
		List<Jcsj_police_resources> list= service.pageListJcsj_police_resources(modelMap);
		PageInfo<Jcsj_police_resources> pageinfo=new PageInfo<Jcsj_police_resources>(list,5);
		 return pageinfo;
	}
}
