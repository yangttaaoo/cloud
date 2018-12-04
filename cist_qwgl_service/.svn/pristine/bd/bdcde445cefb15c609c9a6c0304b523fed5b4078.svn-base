package com.cist.qwgl.jzgl.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.qwgl.bcgl.model.Qw_type;
import com.cist.qwgl.jzgl.model.Jcsjpoliceresources;
import com.cist.qwgl.jzgl.model.Qw_alarm_relation;
import com.cist.qwgl.jzgl.model.Qw_car_patrol_info;
import com.cist.qwgl.jzgl.model.Qw_car_patrol_relation;
import com.cist.qwgl.jzgl.model.Qw_duty_relation;
import com.cist.qwgl.jzgl.model.Qw_equip_info;
import com.cist.qwgl.jzgl.model.Qw_guns_relation;
import com.cist.qwgl.jzgl.model.Qw_police_team;
import com.cist.qwgl.jzgl.model.Qw_police_team_alarm;
import com.cist.qwgl.jzgl.model.Qw_police_team_duty;
import com.cist.qwgl.jzgl.model.Qw_police_team_street;
import com.cist.qwgl.jzgl.model.Qw_walk_patrol_relation;
import com.cist.qwgl.jzgl.model.Qwgl_bc_info;
import com.cist.qwgl.jzgl.model.Qwpatrolarea;
import com.cist.qwgl.jzgl.model.Sysfrmcode;
import com.cist.qwgl.jzgl.model.Syspoliceinfo;
import com.cist.qwgl.jzgl.service.JzglService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("jzgl")
public class JzglController {
	@Autowired
	private JzglService service;
	/***
	 * 警组分页查询
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("policeteam")
	public PageInfo<Qw_police_team> policeteam(@RequestBody HashMap<String,Object> modelMap ){
		Integer pageSize= Integer.parseInt(modelMap.get("pageSize").toString());//每页有显示多少条
		//获取分页数据位置,每页显示16条数据
 		PageHelper.startPage(Integer.valueOf(modelMap.get("currentPage").toString()),pageSize, true);
		List<Qw_police_team> list= service.qwpoliceteampagelist(modelMap);
		PageInfo<Qw_police_team> pageinfo=new PageInfo<Qw_police_team>(list,5);
		for (Qw_police_team qw_police_team : list) {
			modelMap.put("fk_police_team_id", qw_police_team.getPk_id());//警组id
			modelMap.put("fc_num", qw_police_team.getReport_type());//报备类型（1：街面勤务；2：值班值守；3：接处警；4：机关工作）
			if("2".equals(qw_police_team.getReport_type())) {//值班值守时

				qw_police_team.setZbzsbcname(service.querybcnamebyzbzs(modelMap));
			}
			qw_police_team.setSysfrmcode(service.selectSysfrmcodeinfo(modelMap));//报备类型
			Qw_police_team_street qw_police_team_street=service.selQw_police_team_street(modelMap);//警组信息
			if(null!=qw_police_team_street) {
				modelMap.put("bc_pk",qw_police_team_street.getFk_work_shift_id());//班次id
				modelMap.put("qwpatrolareaid",qw_police_team_street.getFk_patrol_area_id());//巡区id
				qw_police_team_street.setQwpatrolarea(service.chauxnxunqu(modelMap));//巡区信息
				qw_police_team_street.setQwgl_bc_info(service.chauxnQwgl_bc_info(modelMap));//班次信息
				qw_police_team.setQw_police_team_street(qw_police_team_street);//警组信息
			}
		}
		return pageinfo;
	}
	/***
	 * 警车分页查询
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("jclist")
	public PageInfo<Jcsjpoliceresources> querylist(@RequestBody HashMap<String,Object> modelMap ){
		Integer pageSize= Integer.parseInt(modelMap.get("pageSize").toString());//每页有显示多少条
		//获取分页数据位置,每页显示16条数据
 		PageHelper.startPage(Integer.valueOf(modelMap.get("currentPage").toString()),pageSize, true);
		List<Jcsjpoliceresources> list= service.querylistpageList(modelMap);
		PageInfo<Jcsjpoliceresources> pageinfo=new PageInfo<Jcsjpoliceresources>(list,5);
		 return pageinfo;
	}
	/***
	 * 获取车辆基础类型
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("fctlist")
	public List<Sysfrmcode> fctlist(@RequestBody HashMap<String,Object> modelMap ){
		 return service.selectSysfrmcode(modelMap);
	}
	/***
	 * 警员分页查询
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("policelist")
	public PageInfo<Syspoliceinfo> policelist(@RequestBody HashMap<String,Object> modelMap ){
		Integer pageSize= Integer.parseInt(modelMap.get("pageSize").toString());//每页有显示多少条
		//获取分页数据位置,每页显示16条数据
 		PageHelper.startPage(Integer.valueOf(modelMap.get("currentPage").toString()),pageSize, true);
		List<Syspoliceinfo> list= service.selectpolice(modelMap);
		PageInfo<Syspoliceinfo> pageinfo=new PageInfo<Syspoliceinfo>(list,5);
		 return pageinfo;
	}
	/**
	 * 查询勤务类型
	 * @return
	 */
	@RequestMapping("queryqwlx")
	public List<Sysfrmcode> queryqwlx(@RequestBody HashMap<String,Object> modelMap){
		return service.selfct(modelMap);
	}
	/**
	 * 查询勤务类型
	 * @return
	 */
	@RequestMapping("queryqwlxquan")
	public List<Sysfrmcode> queryqwlxquan(@RequestBody HashMap<String,Object> modelMap){
		return service.selfctquan(modelMap);
	}
	/**
	 * 班次跨天
	 * @return
	 */
	@RequestMapping("bancigt")
	public List<Sysfrmcode> bancigt(@RequestBody HashMap<String,Object> modelMap){
		return service.bancigt(modelMap);
	}
	/**
	 * 获取巡区信息
	 * @return
	 */
	@RequestMapping("patrolarea")
	public List<Qwpatrolarea> patrolarea(@RequestBody HashMap<String,Object> modelMap){
		return service.patrolarea(modelMap);
	}
	/**
	 *  获取班次信息
	 * @return
	 */
	@RequestMapping("qwglbcinfo")
	public List<Qwgl_bc_info> qwglbcinfo(@RequestBody HashMap<String,Object> modelMap){
		return service.qwglbcinfo(modelMap);
	}
	/***
	 * 获取当前用户
	 * @param request
	 * @return
	 */
	@RequestMapping("getuser")
	public Map<String,Object> indexSelf(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		return userMap;
	}
	/**
	 * 保存警组街面勤务
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("saveinformation")
	public Integer saveinformation(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request) throws ParseException{
		try {
			HttpSession session = request.getSession();
			Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());//获取用户
			modelMap.put("fk_dept_id", userMap.get("sypi_dept_pk"));//部门id
			modelMap.put("create_person_id", userMap.get("sypi_pk"));//创建人
			modelMap.put("create_time", new Date());//创建人
			//保存警组信息
			Integer start=service.saveQw_police_team(modelMap);
			//保存警组信息获取警组ID
			Integer count=(Integer) modelMap.get("qwpoliceteampk");
			modelMap.put("fk_police_team_id", count);//警组ID
		    //步巡人员 start
			List<Syspoliceinfo> policList=new ArrayList<Syspoliceinfo>();//警员集合
			if(null!=modelMap.get("personincharge")&&!modelMap.get("personincharge").equals("")) {
				JSONArray personincharge = JSONArray.fromObject(modelMap.get("personincharge"));//负责人
				for(int i=0;i<personincharge.size();i++){//负责人
				    Syspoliceinfo stu=(Syspoliceinfo)JSONObject.toBean(personincharge.getJSONObject(i), Syspoliceinfo.class);
				    stu.setSypi_comp("1");//1负责人2 民警 3协警
				    stu.setFk_police_team_id(count.toString());//警组ID
				    policList.add(stu);
			 }
			}
			if(null!=modelMap.get("peoplespolice")&&!modelMap.get("peoplespolice").equals("")) {
				JSONArray peoplespolice = JSONArray.fromObject(modelMap.get("peoplespolice"));//民警
				for(int i=0;i<peoplespolice.size();i++){//民警
				    Syspoliceinfo stu=(Syspoliceinfo)JSONObject.toBean(peoplespolice.getJSONObject(i), Syspoliceinfo.class);
				    stu.setSypi_comp("2");//1负责人2 民警 3协警
				    stu.setFk_police_team_id(count.toString());//警组ID
				    policList.add(stu);
			 }
			}
			if(null!=modelMap.get("peoplespolice")&&!modelMap.get("peoplespolice").equals("")) {
				JSONArray auxiliarypolice = JSONArray.fromObject(modelMap.get("auxiliarypolice"));//协警
				for(int i=0;i<auxiliarypolice.size();i++){//协警
				    Syspoliceinfo stu=(Syspoliceinfo)JSONObject.toBean(auxiliarypolice.getJSONObject(i), Syspoliceinfo.class);
				    stu.setSypi_comp("3");//1负责人2 民警 3协警
				    stu.setFk_police_team_id(count.toString());//警组ID
				    policList.add(stu);
			 }
			}
			
			//保存步巡人员
			if(policList.size()>0) {
				service.saveQw_walk_patrol_relation(policList);
			}
			
			//步巡人员 end
			 
			//巡控方式  车辆 start
			if(null!=modelMap.get("getpolicecar")&&!modelMap.get("getpolicecar").equals("")) {
				JSONArray policecar = JSONArray.fromObject(modelMap.get("getpolicecar"));//车辆信息
				for(int i=0;i<policecar.size();i++){//负责人
				 JSONObject json=policecar.getJSONObject(i);
				 modelMap.put("fk_police_car_id", json.get("pk_id"));//警车ID
				 service.saveqw_car_patrol_info(modelMap);//保存车巡信息
				 Integer patrolpk=(Integer) modelMap.get("qw_car_patrol_infopk");//获取车巡信息id
				 modelMap.put("fk_car_patrol_id", patrolpk);//车巡信息id
					 if(null!=json.get("fuzeren")&&!json.get("fuzeren").equals("null")&&!json.get("fuzeren").equals("")) {
						 modelMap.put("qw_car_patrol_relation_user_type", 1);//关联人员类型（1：负责人；2：民警；3：协警）
							 JSONArray fuzeren = JSONArray.fromObject(json.get("fuzeren"));//车辆负责人
							 for(int k=0;k<fuzeren.size();k++){
								 JSONObject fuzerenjson=fuzeren.getJSONObject(k);
								 modelMap.put("qw_car_patrol_relation_fk_user_id",fuzerenjson.get("sypi_pk"));
								 service.saveqw_car_patrol_relation(modelMap);
							 }
						 
					 }
					if(null!=json.get("xiejing")&&!json.get("xiejing").equals("null")&&!json.get("xiejing").equals("")) {
						 modelMap.put("qw_car_patrol_relation_user_type", 3);//关联人员类型（1：负责人；2：民警；3：协警）
							 JSONArray xiejing = JSONArray.fromObject(json.get("xiejing"));//车辆协警
							 for(int k=0;k<xiejing.size();k++){
								 JSONObject xiejingjson=xiejing.getJSONObject(k);
								 modelMap.put("qw_car_patrol_relation_fk_user_id",xiejingjson.get("sypi_pk"));
								 service.saveqw_car_patrol_relation(modelMap);
							 }
						 
					}
					if(null!=json.get("minjing")&&!json.get("minjing").equals("null")&&!json.get("minjing").equals("")) {
						 modelMap.put("qw_car_patrol_relation_user_type", 2);//关联人员类型（1：负责人；2：民警；3：协警）
							 JSONArray minjing = JSONArray.fromObject(json.get("minjing"));//车辆民警
							 for(int k=0;k<minjing.size();k++){
								 JSONObject minjingjson=minjing.getJSONObject(k);
								 modelMap.put("qw_car_patrol_relation_fk_user_id",minjingjson.get("sypi_pk"));
								 service.saveqw_car_patrol_relation(modelMap);
							 }
					}
				
				}
			}
			
			//巡控方式  车辆 end
			
			//保存警组-街面勤务
			service.saveQw_police_team_street(modelMap);
			//保存装备信息
			service.saveQw_equip_info(modelMap);
			Integer qwequipinfopk=(Integer) modelMap.get("qwequipinfopk");
			modelMap.put("fk_equip_id", qwequipinfopk);//勤务报备ID
			JSONArray gunsdata = JSONArray.fromObject(modelMap.get("gunsdata"));//枪支关联警员
			if(!gunsdata.toString().equals("[null]")) {
				for(int i=0;i<gunsdata.size();i++){//枪支关联警员
					JSONObject json=gunsdata.getJSONObject(i);
					modelMap.put("fk_user_id", json.get("sypi_pk"));
					service.addqw_guns_relation(modelMap);
				}
			}
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	/***
	 * 保存警组值班值守信息
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("beonduty")
	public Integer beonduty(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request) throws ParseException{
		try {

			HttpSession session = request.getSession();
			Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());//获取用户
			modelMap.put("fk_dept_id", userMap.get("sypi_dept_pk"));//部门id
			modelMap.put("create_person_id", userMap.get("sypi_pk"));//创建人
			modelMap.put("create_time", new Date());//创建时间
			//保存警组信息
			Integer start=service.saveQw_police_team(modelMap);
			//保存警组信息获取警组ID
			Integer count=(Integer) modelMap.get("qwpoliceteampk");
			modelMap.put("fk_police_team_id", count);//警组ID
			
			//保存警组-值班值守
			service.addteam_duty(modelMap);
			//值班值守关联人员信息
			JSONArray qwdutyrelation = JSONArray.fromObject(modelMap.get("qwdutyrelation"));//值班人员
			for(int i=0;i<qwdutyrelation.size();i++){//值班人员
				 JSONObject json=qwdutyrelation.getJSONObject(i);
				 if(!"".equals(json.get("Dutyleader").toString())) {
					 JSONArray dutyleader = JSONArray.fromObject(json.get("Dutyleader"));//值班领导
					 for(int k=0;k<dutyleader.size();k++){
							JSONObject dutyleaderjso=dutyleader.getJSONObject(k);
							modelMap.put("fk_user_id", dutyleaderjso.get("sypi_pk"));//人员id
							modelMap.put("user_type", 1);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
							service.addQw_duty_relation(modelMap);
						 }
				 }
				 
				 
				 if(!"".equals(json.get("Commander").toString())) {
				 JSONArray commander = JSONArray.fromObject(json.get("Commander"));//指挥长
					 for(int k=0;k<commander.size();k++){
							JSONObject commanderjso=commander.getJSONObject(k);
							modelMap.put("fk_user_id", commanderjso.get("sypi_pk"));//人员id
							modelMap.put("user_type", 2);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
							service.addQw_duty_relation(modelMap);
						 } 
				 }
				
				 if(!"".equals(json.get("shiftforeman").toString())) {
				 JSONArray shiftforeman = JSONArray.fromObject(json.get("shiftforeman"));//值班长
					 for(int k=0;k<shiftforeman.size();k++){
							JSONObject shiftforemanjso=shiftforeman.getJSONObject(k);
							modelMap.put("fk_user_id", shiftforemanjso.get("sypi_pk"));//人员id
							modelMap.put("user_type", 3);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
							service.addQw_duty_relation(modelMap);
						 } 
				 }
					
				 if(!"".equals(json.get("Dutypolice").toString())) {
				 JSONArray dutypolice = JSONArray.fromObject(json.get("Dutypolice"));//值班民警
					 for(int k=0;k<dutypolice.size();k++){
							JSONObject dutypolicejso=dutypolice.getJSONObject(k);
							modelMap.put("fk_user_id", dutypolicejso.get("sypi_pk"));//人员id
							modelMap.put("user_type", 4);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
							service.addQw_duty_relation(modelMap);
						 }
				 }  
				
				 if(!"".equals(json.get("Guardonduty").toString())) {
				 JSONArray guardonduty = JSONArray.fromObject(json.get("Guardonduty"));//值班协警
					 for(int k=0;k<guardonduty.size();k++){
							JSONObject guardondutyjso=guardonduty.getJSONObject(k);
							modelMap.put("fk_user_id", guardondutyjso.get("sypi_pk"));//人员id
							modelMap.put("user_type", 5);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
							service.addQw_duty_relation(modelMap);
						 } 
				 }
				
			}
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	
	/**
	 * 根据警组ID查询出巡车详细信息
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("carinfo")
	public HashMap<String,Object> querypolicecarbyjzid(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		//querylistpageList查询警车selectpolice查询人员
		List<Jcsjpoliceresources> list = new ArrayList<Jcsjpoliceresources>();
		//根据警组id查询警车id
		List<Qw_car_patrol_info> cxinfo = service.querypolicecarbyjzid(map);
		String fuzerenname=null;//负责人名字
		String minjingname=null;//民警名字
		String xiejingname=null;//民警名字
		List<Syspoliceinfo> fuzeren = null;
		List<Syspoliceinfo> minjing = null;
		List<Syspoliceinfo> xiejing = null;
		for (int i = 0; i < cxinfo.size(); i++) {
			map.put("fk_police_car_id", cxinfo.get(i).getFk_police_car_id());
			List<Jcsjpoliceresources> policecarinfo = service.querylistpageList(map);//警车详细信息
			map.put("fk_car_patrol_id", cxinfo.get(i).getPk_id());
			List<Qw_car_patrol_relation> carinfo= service.querypolicecarinfo(map);//根据车巡id查询车巡关联信息
			
			fuzerenname="";
			minjingname="";
			xiejingname="";
			fuzeren = new ArrayList<Syspoliceinfo>();
			minjing = new ArrayList<Syspoliceinfo>();
			xiejing = new ArrayList<Syspoliceinfo>();
			for (int j = 0; j < carinfo.size(); j++) {
			
				if("1".equals(carinfo.get(j).getUser_type())) {//负责人
					map.put("sypi_pk", carinfo.get(j).getFk_user_id());
					List<Syspoliceinfo> policeinfo = service.selectpolice(map);
					if(policeinfo!=null) {
						fuzerenname+=policeinfo.get(0).getSypi_name()+",";
						fuzeren.add(policeinfo.get(0));
					}
				}else if("2".equals(carinfo.get(j).getUser_type())) {//民警
					map.put("sypi_pk", carinfo.get(j).getFk_user_id());
					List<Syspoliceinfo> policeinfo = service.selectpolice(map);
					if(policeinfo!=null) {
						minjingname+=policeinfo.get(0).getSypi_name()+",";
						minjing.add(policeinfo.get(0));
					}
				}else if("3".equals(carinfo.get(j).getUser_type())) {//协警
					map.put("sypi_pk", carinfo.get(j).getFk_user_id());
					List<Syspoliceinfo> policeinfo = service.selectpolice(map);
					if(policeinfo!=null) {
						xiejingname+=policeinfo.get(0).getSypi_name()+",";
						xiejing.add(policeinfo.get(0));
					}
				}else {
					
				}
			}
			if(fuzerenname.length()>1) {
				fuzerenname=fuzerenname.substring(0, fuzerenname.length()-1);
			}
			if(xiejingname.length()>1) {
				xiejingname=xiejingname.substring(0, xiejingname.length()-1);
			}
			if(minjingname.length()>1) {
				minjingname=minjingname.substring(0, minjingname.length()-1);
			}
			JSONArray fuzerenstr=JSONArray.fromObject(fuzeren);
			JSONArray minjingstr=JSONArray.fromObject(minjing);
			JSONArray xiejingstr=JSONArray.fromObject(xiejing);
			if(policecarinfo.size()>0) {
				policecarinfo.get(0).setFuzerenname(fuzerenname);
				policecarinfo.get(0).setXiejingname(xiejingname);
				policecarinfo.get(0).setMinjingname(minjingname);
				policecarinfo.get(0).setFuzeren(fuzerenstr.toString());
				policecarinfo.get(0).setMinjing(minjingstr.toString());
				policecarinfo.get(0).setXiejing(xiejingstr.toString());
				list.add(policecarinfo.get(0));
			}
		}
		ModelMap.put("carinfo", list);
		return ModelMap;
	}
	/**
	 * 根据警组id查询步巡人员信息
	 * @param map
	 * @return
	 */
	@RequestMapping("bxryinfo")
	public HashMap<String,Object> querybxrybyjzid(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		List<Qw_walk_patrol_relation> bxinfo = service.querybxrybyjzid(map);//根据警组id查询步巡信息
		String fuzerenname="";//负责人名字
		String minjingname="";//民警名字
		String xiejingname="";//民警名字
		List<Syspoliceinfo> fuzeren = new ArrayList<Syspoliceinfo>();
		List<Syspoliceinfo> minjing = new ArrayList<Syspoliceinfo>();
		List<Syspoliceinfo> xiejing = new ArrayList<Syspoliceinfo>();
		for (int i = 0; i < bxinfo.size(); i++) {
			if("1".equals(bxinfo.get(i).getUser_type())) {//负责人
				map.put("sypi_pk", bxinfo.get(i).getFk_user_id());
				List<Syspoliceinfo> policeinfo = service.selectpolice(map);
				if(policeinfo!=null) {
					fuzerenname+=policeinfo.get(0).getSypi_name()+",";
					fuzeren.add(policeinfo.get(0));
				}
			}else if("2".equals(bxinfo.get(i).getUser_type())) {//民警
				map.put("sypi_pk", bxinfo.get(i).getFk_user_id());
				List<Syspoliceinfo> policeinfo = service.selectpolice(map);
				if(policeinfo!=null) {
					minjingname+=policeinfo.get(0).getSypi_name()+",";
					minjing.add(policeinfo.get(0));
				}
			}else if("3".equals(bxinfo.get(i).getUser_type())) {//协警
				map.put("sypi_pk", bxinfo.get(i).getFk_user_id());
				List<Syspoliceinfo> policeinfo = service.selectpolice(map);
				if(policeinfo!=null) {
					xiejingname+=policeinfo.get(0).getSypi_name()+",";
					xiejing.add(policeinfo.get(0));
				}
			}else {
				
			}
		}
		if(fuzerenname.length()>1) {
			fuzerenname=fuzerenname.substring(0, fuzerenname.length()-1);
		}
		if(xiejingname.length()>1) {
			xiejingname=xiejingname.substring(0, xiejingname.length()-1);
		}
		if(minjingname.length()>1) {
			minjingname=minjingname.substring(0, minjingname.length()-1);
		}
		ModelMap.put("personinchargename", fuzerenname);//负责人名字
		ModelMap.put("personincharge", fuzeren);//负责人信息
		ModelMap.put("peoplespolicename", minjingname);//民警名字
		ModelMap.put("peoplespolice", minjing);//民警信息
		ModelMap.put("auxiliarypolicename", xiejingname);//协警名字
		ModelMap.put("auxiliarypolice", xiejing);//协警信息
		return ModelMap;
		}
	/**
	 * 查询装备信息
	 * @param map
	 * @return
	 */
	@RequestMapping("queryequip")
	public HashMap<String,Object> queryequip(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		List<Syspoliceinfo> policeinfo= new ArrayList<Syspoliceinfo>();
		String policename="";
		List<Qw_equip_info> equip= service.queryequip(map);//查询装备信息
		for (int i = 0; i < equip.size(); i++) {
			map.put("fk_equip_id", equip.get(i).getPk_id());//装备信息id
			List<Qw_guns_relation> gunslist = service.queryqw_guns_relation(map);//根据装备信息id查询枪支关联警员
			for (int j = 0; j < gunslist.size(); j++) {
				map.put("sypi_pk", gunslist.get(j).getFk_user_id());//警员
				List<Syspoliceinfo> police = service.selectpolice(map);
				if(policeinfo!=null) {
					policename+=police.get(0).getSypi_name()+",";
					policeinfo.add(police.get(0));
				}
			}
		}
		if(policename.length()>1) {
			policename=policename.substring(0, policename.length()-1);
		}
		ModelMap.put("policename", policename);
		ModelMap.put("policeinfo", policeinfo);
		ModelMap.put("equip", equip);
		return ModelMap;
		}
	/**
	 * 根据警组id查询值班值守信息
	 * @param map
	 * @return
	 */
	@RequestMapping("queryzbzs")
	public HashMap<String,Object> queryzbzs(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		List<Qw_police_team_duty> zbzs = service.queryQw_police_team_duty(map);
		List<Qw_duty_relation> Qw_duty_relation =  service.queryQw_duty_relation(map);//根据警组id查询值班值守关联人员
		List<Syspoliceinfo> Dutyleader = new ArrayList<Syspoliceinfo>();//值班领导
		List<Syspoliceinfo> Commander = new ArrayList<Syspoliceinfo>();//指挥长
		List<Syspoliceinfo> shiftforeman = new ArrayList<Syspoliceinfo>();//值班长
		List<Syspoliceinfo> Dutypolice = new ArrayList<Syspoliceinfo>();//值班民警
		List<Syspoliceinfo> Guardonduty = new ArrayList<Syspoliceinfo>();//值班协警
		String Dutyleadername="";
		String Commandername="";
		String shiftforemanname="";
		String Dutypolicename="";
		String Guardondutyname="";
		for (int i = 0; i < Qw_duty_relation.size(); i++) {
			//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
			if("1".equals(Qw_duty_relation.get(i).getUSER_TYPE().toString())) {
				map.put("sypi_pk", Qw_duty_relation.get(i).getFk_user_id());
				List<Syspoliceinfo> policeinfo = service.selectpolice(map);
				if(policeinfo!=null) {
					Dutyleadername+=policeinfo.get(0).getSypi_name()+",";
					Dutyleader.add(policeinfo.get(0));
				}
			}else if("2".equals(Qw_duty_relation.get(i).getUSER_TYPE().toString())) {
				map.put("sypi_pk", Qw_duty_relation.get(i).getFk_user_id());
				List<Syspoliceinfo> policeinfo = service.selectpolice(map);
				if(policeinfo!=null) {
					Commandername+=policeinfo.get(0).getSypi_name()+",";
					Commander.add(policeinfo.get(0));
				}
			}else if("3".equals(Qw_duty_relation.get(i).getUSER_TYPE().toString())) {
				map.put("sypi_pk", Qw_duty_relation.get(i).getFk_user_id());
				List<Syspoliceinfo> policeinfo = service.selectpolice(map);
				if(policeinfo!=null) {
					shiftforemanname+=policeinfo.get(0).getSypi_name()+",";
					shiftforeman.add(policeinfo.get(0));
				}
			}else if("4".equals(Qw_duty_relation.get(i).getUSER_TYPE().toString())) {
				map.put("sypi_pk", Qw_duty_relation.get(i).getFk_user_id());
				List<Syspoliceinfo> policeinfo = service.selectpolice(map);
				if(policeinfo!=null) {
					Dutypolicename+=policeinfo.get(0).getSypi_name()+",";
					Dutypolice.add(policeinfo.get(0));
				}
			}else {
				map.put("sypi_pk", Qw_duty_relation.get(i).getFk_user_id());
				List<Syspoliceinfo> policeinfo = service.selectpolice(map);
				if(policeinfo!=null) {
					Guardondutyname+=policeinfo.get(0).getSypi_name()+",";
					Guardonduty.add(policeinfo.get(0));
				}
			}
		}
		if(Dutyleadername.length()>1) {
			Dutyleadername=Dutyleadername.substring(0, Dutyleadername.length()-1);
		}
		if(Commandername.length()>1) {
			Commandername=Commandername.substring(0, Commandername.length()-1);
		}
		if(shiftforemanname.length()>1) {
			shiftforemanname=shiftforemanname.substring(0, shiftforemanname.length()-1);
		}
		if(Dutypolicename.length()>1) {
			Dutypolicename=Dutypolicename.substring(0, Dutypolicename.length()-1);
		}
		if(Guardondutyname.length()>1) {
			Guardondutyname=Guardondutyname.substring(0, Guardondutyname.length()-1);
		}
		ModelMap.put("zbzsinfo", zbzs);
		ModelMap.put("Dutyleader", Dutyleader);
		ModelMap.put("Commander", Commander);
		ModelMap.put("shiftforeman", shiftforeman);
		ModelMap.put("Dutypolice", Dutypolice);
		ModelMap.put("Guardonduty", Guardonduty);
		ModelMap.put("Dutyleadername", Dutyleadername);
		ModelMap.put("Commandername", Commandername);
		ModelMap.put("shiftforemanname", shiftforemanname);
		ModelMap.put("Dutypolicename", Dutypolicename);
		ModelMap.put("Guardondutyname", Guardondutyname);
		return ModelMap;
		}
	/**
	 * 删除警组
	 * return 1:成功   2:失败
	 * @param map
	 * @return
	 */
	@RequestMapping("deletejz")
	public Integer deletejz(@RequestBody HashMap<String, Object> map) {
		try {
			// 判断是否为空或者空字符串及删除类型（单条删除或者批量删除）
			String pk_id = map.get("pk_id").toString();
			if (null != pk_id && pk_id != "" && pk_id.indexOf(",") != -1) {
				pk_id = pk_id.substring(0, pk_id.length() - 1);
				String sbb[] = pk_id.split(",");
				map.put("pk_id", sbb);
			} else {
				String[] sbb = new String[1];
				sbb[0] = pk_id;
				map.put("pk_id", sbb);
			}
			List<Qw_police_team> jzlist = service.queryjzinfo(map);// 根据pk_id查询警组信息
			for (int i = 0; i < jzlist.size(); i++) {
				map.put("fk_police_team_id", jzlist.get(i).getPk_id());// 警组id
				if ("1".equals(jzlist.get(i).getReport_type())) {// 判断是否为街面勤务
					List<Qw_equip_info> equiplist = service.queryequip(map);// 查询装备信息
					//删除装备信息和枪支关联警员信息
					for (int j = 0; j < equiplist.size(); j++) {
						map.put("fk_equip_id", equiplist.get(j).getPk_id());// 装备信息id
						service.delQw_guns_relation(map);// 根据装备信息表id删除枪支关联警员信息
						service.delzbbb(map);// 删除装备信息
					}
					Qw_police_team_street jmqw = service.selQw_police_team_street(map);// 警组ID获取街面勤务
					//删除车巡信息
					List<Qw_car_patrol_info> carpatrol = service.querypolicecarbyjzid(map);//根据警组id查询查询信息
					for (int j = 0; j < carpatrol.size(); j++) {
						map.put("fk_car_patrol_id", carpatrol.get(j).getPk_id());//车巡id
						service.delcarpatrol(map);//根据巡车id删除车巡关联人员信息
						service.delQw_car_patrol_info(map);//根据警组id删除车巡信息
					}
					//删除步巡信息
					service.delQw_walk_patrol_relation(map);
					service.deljmqw(map);//删除街面勤务信息
					service.delQw_police_team(map);//根据警组id删除警组信息
				} else if ("2".equals(jzlist.get(i).getReport_type())) {// 值班值守
					service.delQw_duty_relation(map);//根据警组id删除值班值守关联人员信息
					service.delQw_police_team_duty(map);//根据警组id删除警组-值班值守信息
					service.delzbzs(map);
					service.delQw_police_team(map);//根据警组id删除警组信息
				} else if ("5".equals(jzlist.get(i).getReport_type())) {// 接警处
					service.deljjc(map);//删除接警处信息
					service.deljjcglry(map);//删除接警处关联人员信息
					service.delQw_police_team(map);//根据警组id删除警组信息
				} else {// 机关工作

				}

			}
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}

	}
	
	/**
	 * 更新警组信息
	 * return 1:成功   2:失败
	 * @param map
	 * @return
	 */
	@RequestMapping("updatejz")
	public Integer updatejz(@RequestBody HashMap<String, Object> map) {
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		try {
			ModelMap.put("fk_police_team_id", map.get("jz_id"));//警组id
			Qw_police_team jzinfo = service.queryjzbyjzid(ModelMap);
			if("1".equals(jzinfo.getReport_type())){//更新前为街面勤务
				//删除更新前街面勤务的信息
				List<Qw_equip_info> equiplist = service.queryequip(ModelMap);// 查询装备信息
				//删除装备信息和枪支关联警员信息
				for (int j = 0; j < equiplist.size(); j++) {
					ModelMap.put("fk_equip_id", equiplist.get(j).getPk_id());// 装备信息id
					service.delQw_guns_relation(ModelMap);// 根据装备信息表id删除枪支关联警员信息
					service.delzbbb(ModelMap);// 删除装备信息
				}
				Qw_police_team_street jmqw = service.selQw_police_team_street(ModelMap);// 警组ID获取街面勤务
				//删除车巡信息
				List<Qw_car_patrol_info> carpatrol = service.querypolicecarbyjzid(ModelMap);//根据警组id查询查询信息
				for (int j = 0; j < carpatrol.size(); j++) {
					ModelMap.put("fk_car_patrol_id", carpatrol.get(j).getPk_id());//车巡id
					service.delcarpatrol(ModelMap);//根据巡车id删除车巡关联人员信息
					service.delQw_car_patrol_info(ModelMap);//根据警组id删除车巡信息
				}
				//删除步巡信息
				service.delQw_walk_patrol_relation(ModelMap);
				service.deljmqw(ModelMap);//删除街面勤务信息
			}else if("2".equals(jzinfo.getReport_type())){//更新前为值班值守
				service.delQw_duty_relation(ModelMap);//根据警组id删除值班值守关联人员信息
				service.delQw_police_team_duty(ModelMap);//根据警组id删除警组-值班值守信息
				service.delzbzs(ModelMap);
			}else if("5".equals(jzinfo.getReport_type())){//更新前为接警处
				service.deljjc(ModelMap);//删除接警处信息
				service.deljjcglry(ModelMap);//删除接警处关联人员信息
			}else{
				
			}
			
			//更新警组信息
			service.updatejz(map);
			if("1".equals(map.get("report_type"))){//更新的数据为街面勤务
				map.put("fk_police_team_id", map.get("jz_id"));//警组ID
			    //步巡人员 start
				List<Syspoliceinfo> policList=new ArrayList<Syspoliceinfo>();//警员集合
				if(null!=map.get("personincharge")&&!map.get("personincharge").equals("")) {
					JSONArray personincharge = JSONArray.fromObject(map.get("personincharge"));//负责人
					for(int i=0;i<personincharge.size();i++){//负责人
					    Syspoliceinfo stu=(Syspoliceinfo)JSONObject.toBean(personincharge.getJSONObject(i), Syspoliceinfo.class);
					    stu.setSypi_comp("1");//1负责人2 民警 3协警
					    stu.setFk_police_team_id(map.get("jz_id").toString());//警组ID
					    policList.add(stu);
				 }
				}
				if(null!=map.get("peoplespolice")&&!map.get("peoplespolice").equals("")) {
					JSONArray peoplespolice = JSONArray.fromObject(map.get("peoplespolice"));//民警
					for(int i=0;i<peoplespolice.size();i++){//民警
					    Syspoliceinfo stu=(Syspoliceinfo)JSONObject.toBean(peoplespolice.getJSONObject(i), Syspoliceinfo.class);
					    stu.setSypi_comp("2");//1负责人2 民警 3协警
					    stu.setFk_police_team_id(map.get("jz_id").toString());//警组ID
					    policList.add(stu);
				 }
				}
				if(null!=map.get("peoplespolice")&&!map.get("peoplespolice").equals("")) {
					JSONArray auxiliarypolice = JSONArray.fromObject(map.get("auxiliarypolice"));//协警
					for(int i=0;i<auxiliarypolice.size();i++){//协警
					    Syspoliceinfo stu=(Syspoliceinfo)JSONObject.toBean(auxiliarypolice.getJSONObject(i), Syspoliceinfo.class);
					    stu.setSypi_comp("3");//1负责人2 民警 3协警
					    stu.setFk_police_team_id(map.get("jz_id").toString());//警组ID
					    policList.add(stu);
				 }
				}
				
				//保存步巡人员
				if(policList.size()>0) {
					service.saveQw_walk_patrol_relation(policList);
				}
				
				//步巡人员 end
				 
				//巡控方式  车辆 start
				if(null!=map.get("getpolicecar")&&!map.get("getpolicecar").equals("")) {
					JSONArray policecar = JSONArray.fromObject(map.get("getpolicecar"));//车辆信息
					for(int i=0;i<policecar.size();i++){//负责人
					 JSONObject json=policecar.getJSONObject(i);
					 map.put("fk_police_car_id", json.get("pk_id"));//警车ID
					 service.saveqw_car_patrol_info(map);//保存车巡信息
					 Integer patrolpk=(Integer) map.get("qw_car_patrol_infopk");//获取车巡信息id
					 map.put("fk_car_patrol_id", patrolpk);//车巡信息id
						 if(null!=json.get("fuzeren")&&!json.get("fuzeren").equals("null")&&!json.get("fuzeren").equals("")) {
							 map.put("qw_car_patrol_relation_user_type", 1);//关联人员类型（1：负责人；2：民警；3：协警）
								 JSONArray fuzeren = JSONArray.fromObject(json.get("fuzeren"));//车辆负责人
								 for(int k=0;k<fuzeren.size();k++){
									 JSONObject fuzerenjson=fuzeren.getJSONObject(k);
									 map.put("qw_car_patrol_relation_fk_user_id",fuzerenjson.get("sypi_pk"));
									 service.saveqw_car_patrol_relation(map);
								 }
							 
						 }
						if(null!=json.get("xiejing")&&!json.get("xiejing").equals("null")&&!json.get("xiejing").equals("")) {
							 map.put("qw_car_patrol_relation_user_type", 3);//关联人员类型（1：负责人；2：民警；3：协警）
								 JSONArray xiejing = JSONArray.fromObject(json.get("xiejing"));//车辆协警
								 for(int k=0;k<xiejing.size();k++){
									 JSONObject xiejingjson=xiejing.getJSONObject(k);
									 map.put("qw_car_patrol_relation_fk_user_id",xiejingjson.get("sypi_pk"));
									 service.saveqw_car_patrol_relation(map);
								 }
							 
						}
						if(null!=json.get("minjing")&&!json.get("minjing").equals("null")&&!json.get("minjing").equals("")) {
							 map.put("qw_car_patrol_relation_user_type", 2);//关联人员类型（1：负责人；2：民警；3：协警）
								 JSONArray minjing = JSONArray.fromObject(json.get("minjing"));//车辆民警
								 for(int k=0;k<minjing.size();k++){
									 JSONObject minjingjson=minjing.getJSONObject(k);
									 map.put("qw_car_patrol_relation_fk_user_id",minjingjson.get("sypi_pk"));
									 service.saveqw_car_patrol_relation(map);
								 }
						}
					
					}
				}
				
				//巡控方式  车辆 end
				
				//保存警组-街面勤务
				service.saveQw_police_team_street(map);
				//保存装备信息
				service.saveQw_equip_info(map);
				Integer qwequipinfopk=(Integer) map.get("qwequipinfopk");
				map.put("fk_equip_id", qwequipinfopk);//勤务报备ID
				JSONArray gunsdata = JSONArray.fromObject(map.get("gunsdata"));//枪支关联警员
				if(!gunsdata.toString().equals("[null]")) {
					for(int i=0;i<gunsdata.size();i++){//枪支关联警员
						JSONObject json=gunsdata.getJSONObject(i);
						map.put("fk_user_id", json.get("sypi_pk"));
						service.addqw_guns_relation(map);
					}
				}
				
				
			}else if("2".equals(map.get("report_type"))){//更新的数据为值班值守
				
				
				map.put("fk_police_team_id", map.get("jz_id"));//警组ID
				
				//保存警组-值班值守
				service.addteam_duty(map);
				//值班值守关联人员信息
				JSONArray qwdutyrelation = JSONArray.fromObject(map.get("qwdutyrelation"));//值班人员
				for(int i=0;i<qwdutyrelation.size();i++){//值班人员
					 JSONObject json=qwdutyrelation.getJSONObject(i);
					 if(!"".equals(json.get("Dutyleader").toString())) {
						 JSONArray dutyleader = JSONArray.fromObject(json.get("Dutyleader"));//值班领导
						 for(int k=0;k<dutyleader.size();k++){
								JSONObject dutyleaderjso=dutyleader.getJSONObject(k);
								map.put("fk_user_id", dutyleaderjso.get("sypi_pk"));//人员id
								map.put("user_type", 1);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
								service.addQw_duty_relation(map);
							 }
					 }
					 
					 
					 if(!"".equals(json.get("Commander").toString())) {
					 JSONArray commander = JSONArray.fromObject(json.get("Commander"));//指挥长
						 for(int k=0;k<commander.size();k++){
								JSONObject commanderjso=commander.getJSONObject(k);
								map.put("fk_user_id", commanderjso.get("sypi_pk"));//人员id
								map.put("user_type", 2);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
								service.addQw_duty_relation(map);
							 } 
					 }
					
					 if(!"".equals(json.get("shiftforeman").toString())) {
					 JSONArray shiftforeman = JSONArray.fromObject(json.get("shiftforeman"));//值班长
						 for(int k=0;k<shiftforeman.size();k++){
								JSONObject shiftforemanjso=shiftforeman.getJSONObject(k);
								map.put("fk_user_id", shiftforemanjso.get("sypi_pk"));//人员id
								map.put("user_type", 3);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
								service.addQw_duty_relation(map);
							 } 
					 }
						
					 if(!"".equals(json.get("Dutypolice").toString())) {
					 JSONArray dutypolice = JSONArray.fromObject(json.get("Dutypolice"));//值班民警
						 for(int k=0;k<dutypolice.size();k++){
								JSONObject dutypolicejso=dutypolice.getJSONObject(k);
								map.put("fk_user_id", dutypolicejso.get("sypi_pk"));//人员id
								map.put("user_type", 4);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
								service.addQw_duty_relation(map);
							 }
					 }  
					
					 if(!"".equals(json.get("Guardonduty").toString())) {
					 JSONArray guardonduty = JSONArray.fromObject(json.get("Guardonduty"));//值班协警
						 for(int k=0;k<guardonduty.size();k++){
								JSONObject guardondutyjso=guardonduty.getJSONObject(k);
								map.put("fk_user_id", guardondutyjso.get("sypi_pk"));//人员id
								map.put("user_type", 5);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
								service.addQw_duty_relation(map);
							 } 
					 }
					
				}
			}else if("5".equals(map.get("report_type"))){//更新的数据为接处警
				map.put("fk_police_team_id", map.get("jz_id"));//警组ID
				service.addjjc(map);
				
				//添加
				if(!"".equals(map.get("jjcxiejing"))) {
					 JSONArray jjcxiejing = JSONArray.fromObject(map.get("jjcxiejing"));//接警处协警
					 for (int i = 0; i < jjcxiejing.size(); i++) {
						 JSONObject jjcxj=jjcxiejing.getJSONObject(i);
						 map.put("fk_user_id", jjcxj.get("sypi_pk"));//人员id
						 map.put("user_type", 2);//协警
						 service.addjjcglry(map);//添加接处警关联人员信息
					}
				}
				if(!"".equals(map.get("jjcminjing"))) {
					 JSONArray jjcminjing = JSONArray.fromObject(map.get("jjcminjing"));//接警处民警
					 for (int i = 0; i < jjcminjing.size(); i++) {
						 JSONObject jjcmj=jjcminjing.getJSONObject(i);
						 map.put("fk_user_id", jjcmj.get("sypi_pk"));//人员id
						 map.put("user_type", 1);//协警
						 service.addjjcglry(map);//添加接处警关联人员信息
						}
				}
			}else{
				
			}
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
		
	}
	/**
	 * 添加接警处
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("addjjc")
	public Integer addjjc(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request) throws ParseException{
			try {
				HttpSession session = request.getSession();
				Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());//获取用户
				modelMap.put("fk_dept_id", userMap.get("sypi_dept_pk"));//部门id
				modelMap.put("create_person_id", userMap.get("sypi_pk"));//创建人
				modelMap.put("create_time", new Date());//创建人
				//保存警组信息
				Integer start=service.saveQw_police_team(modelMap);
				//保存警组信息获取警组ID
				Integer count=(Integer) modelMap.get("qwpoliceteampk");
				modelMap.put("fk_police_team_id", count);//警组ID
				service.addjjc(modelMap);
				
				//添加
				if(!"".equals(modelMap.get("jjcxiejing"))) {
					 JSONArray jjcxiejing = JSONArray.fromObject(modelMap.get("jjcxiejing"));//接警处协警
					 if(!"[null]".equals(jjcxiejing.toString())){
						 for (int i = 0; i < jjcxiejing.size(); i++) {
							 JSONObject jjcxj=jjcxiejing.getJSONObject(i);
							 modelMap.put("fk_user_id", jjcxj.get("sypi_pk"));//人员id
							 modelMap.put("user_type", 2);//协警
							 service.addjjcglry(modelMap);//添加接处警关联人员信息
						}
					 }
					 
				}
				if(!"".equals(modelMap.get("jjcminjing"))) {
					 JSONArray jjcminjing = JSONArray.fromObject(modelMap.get("jjcminjing"));//接警处民警
					 if(!"[null]".equals(jjcminjing.toString())){
					 for (int i = 0; i < jjcminjing.size(); i++) {
						 JSONObject jjcmj=jjcminjing.getJSONObject(i);
						 modelMap.put("fk_user_id", jjcmj.get("sypi_pk"));//人员id
						 modelMap.put("user_type", 1);//协警
						 service.addjjcglry(modelMap);//添加接处警关联人员信息
						}
					 }
				}
				return 1;
			} catch (Exception e) {
				return 2;
			}
	}
	/**
	 * 根据警组id查询接处警相关信息
	 * @param map
	 * @return
	 */
	@RequestMapping("queryjcj")
	public HashMap<String,Object> queryjcj(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		Qw_police_team_alarm Qw_police_team_alarm = service.queryjcc(map);
		List<Qw_alarm_relation> list =service.queryjccglry(map);
		List<Syspoliceinfo> jjcminjing = new ArrayList<Syspoliceinfo>();//接处警民警信息
		List<Syspoliceinfo> jjcxiejing = new ArrayList<Syspoliceinfo>();//接处警协警信息
		String jjcminjingname = "";//接处警民警名字
		String jjcxiejingname = "";//接处警协警名字
		for (int i = 0; i < list.size(); i++) {
			if("1".equals(list.get(i).getUser_type())){//民警
				map.put("sypi_pk", list.get(i).getFk_user_id());
				List<Syspoliceinfo> policeinfo = service.selectpolice(map);
				for (int j = 0; j < policeinfo.size(); j++) {
					jjcminjing.add(policeinfo.get(j));
					jjcminjingname+=policeinfo.get(j).getSypi_name()+",";
				}
			}else if("2".equals(list.get(i).getUser_type())){//协警
				map.put("sypi_pk", list.get(i).getFk_user_id());
				List<Syspoliceinfo> policeinfo = service.selectpolice(map);
				for (int j = 0; j < policeinfo.size(); j++) {
					jjcxiejing.add(policeinfo.get(j));
					jjcxiejingname+=policeinfo.get(j).getSypi_name()+",";
				}
			}else{
				
			}
		}
		if(jjcminjingname.length()>1) {
			jjcminjingname=jjcminjingname.substring(0, jjcminjingname.length()-1);
		}
		if(jjcxiejingname.length()>1) {
			jjcxiejingname=jjcxiejingname.substring(0, jjcxiejingname.length()-1);
		}
		ModelMap.put("jjcminjing", jjcminjing);
		ModelMap.put("jjcxiejing", jjcxiejing);
		ModelMap.put("jjcminjingname", jjcminjingname);
		ModelMap.put("jjcxiejingname", jjcxiejingname);
		ModelMap.put("jcjinfo", Qw_police_team_alarm);
		return ModelMap;
	}
}
