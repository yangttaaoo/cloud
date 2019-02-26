package com.cist.qwgl.qwbb.controller;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cist.qwgl.bcgl.model.DeptInfo;
import com.cist.qwgl.bcgl.service.BcglService;
import com.cist.qwgl.qwbb.model.Gongen;
import com.cist.qwgl.qwbb.model.Jcsj_police_res_person;
import com.cist.qwgl.qwbb.model.Jcsjpoliceresources;
import com.cist.qwgl.qwbb.model.Overviewdata;
import com.cist.qwgl.qwbb.model.Qw_car_patrol_info;
import com.cist.qwgl.qwbb.model.Qw_car_patrol_relation;
import com.cist.qwgl.qwbb.model.Qw_duty_relation;
import com.cist.qwgl.qwbb.model.Qw_equip_info;
import com.cist.qwgl.qwbb.model.Qw_guns_relation;
import com.cist.qwgl.qwbb.model.Qw_police_team;
import com.cist.qwgl.qwbb.model.Qw_police_team_duty;
import com.cist.qwgl.qwbb.model.Qw_police_team_street;
import com.cist.qwgl.qwbb.model.Qw_report;
import com.cist.qwgl.qwbb.model.Qw_walk_patrol_relation;
import com.cist.qwgl.qwbb.model.Qwgl_bc_info;
import com.cist.qwgl.qwbb.model.Qwpatrolarea;
import com.cist.qwgl.qwbb.model.Sysfrmcode;
import com.cist.qwgl.qwbb.model.Tjzy;
import com.cist.qwgl.qwbb.model.View_preparation;
import com.cist.qwgl.qwbb.service.QwbbService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("qwbb")
public class QwbbController {
	@Autowired
	private QwbbService service;
	@Autowired
	private BcglService servicebggl;
	/**
	 * 管理部门树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfo")
	public String deptinfo() throws JsonProcessingException {
		// 顶级部门
		List<DeptInfo> departinfo = servicebggl.depart_infolist(null);
		ObjectMapper mapper = new ObjectMapper();
		List<DeptInfo> list = departinfodg(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidian(list));
		return json.substring(1, json.length() - 1);
	}
	public List<DeptInfo> departinfodg(List<DeptInfo> departinfo) {
		for (DeptInfo depart_info : departinfo) {
			// 部门
			List<DeptInfo> list = servicebggl.depart_infolist(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodg(list);
			}
		}
		return departinfo;
	}
	public List<HashMap<String, Object>> getdiwfdidian(List<DeptInfo> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (DeptInfo depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_pk());
			map.put("selectable", depart_info.getSelectable());
			map.put("isLeaf", depart_info.getIsLeaf());
			if (null != depart_info.getChildren()) {// 下级

				map.put("children", getdiwfdidian(depart_info.getChildren()));
				listmap.add(map);
			} else {
				listmap.add(map);
			}
		}
		return listmap;
	}
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
			qw_police_team.setSysfrmcode(service.selectSysfrmcodeinfo(modelMap));//报备类型
			if(qw_police_team.getReport_type().equals("2")) {//	2：值班值守
				Qw_police_team_duty qw_police_team_duty=service.seqw_police_team_duty(modelMap);//值班值守
				qw_police_team.setQw_police_team_duty(qw_police_team_duty);//值班值守
				modelMap.put("bc_pk", qw_police_team_duty.getFk_work_shift_id());//班次id
				qw_police_team_duty.setQwgl_bc_info(service.chauxnQwgl_bc_info(modelMap));
				List<Qw_duty_relation> qwdutyrelationlist=service.qw_duty_relationid(modelMap);//9.7.	值班值守关联人员信息
				for (Qw_duty_relation qw_duty_relation : qwdutyrelationlist) {
					modelMap.put("fk_user_id", qw_duty_relation.getFk_user_id());
					qw_duty_relation.setSyspoliceinfo(service.syspoliceinfo(modelMap));
				}
				qw_police_team_duty.setQw_duty_relation(qwdutyrelationlist);//值班值守关联人员信息
			}
			if(qw_police_team.getReport_type().equals("1")) {//	1：街面勤务
				Qw_police_team_street qw_police_team_street=service.selQw_police_team_street(modelMap);//警组信息
				if(null!=qw_police_team_street) {
					modelMap.put("bc_pk",qw_police_team_street.getFk_work_shift_id());//班次id
					modelMap.put("qwpatrolareaid",qw_police_team_street.getFk_patrol_area_id());//巡区id
					qw_police_team_street.setQwpatrolarea(service.chauxnxunqu(modelMap));//巡区信息
					qw_police_team_street.setQwgl_bc_info(service.chauxnQwgl_bc_info(modelMap));//班次信息
					
					//9.3.	车巡信息
					List<Qw_car_patrol_info> listcar=service.qw_car_patrol_info(modelMap);
					for (Qw_car_patrol_info qw_car_patrol_info : listcar) {
						modelMap.put("fk_car_patrol_id", qw_car_patrol_info.getPk_id());
						List<Qw_car_patrol_relation> listqwcar=service.qw_car_patrol_relation(modelMap);//9.4.	车巡关联人员信息
						for (Qw_car_patrol_relation qw_car_patrol_relation : listqwcar) {
							modelMap.put("fk_user_id", qw_car_patrol_relation.getFk_user_id());
							if(null!=modelMap.get("fk_user_id")) {
								qw_car_patrol_relation.setSyspoliceinfo(service.syspoliceinfo(modelMap));//车巡关联人员信息
							}
							
						}
						qw_car_patrol_info.setQw_car_patrol_relation(listqwcar);//9.4.	车巡关联人员信息
						modelMap.put("jcsjpoliceresourcespk", qw_car_patrol_info.getFk_police_car_id());
						qw_car_patrol_info.setJcsjpoliceresources(service.jcsjpoliceresources(modelMap));
					}//syspoliceinfo
					qw_police_team.setQw_car_patrol_info(listcar);//车巡信息
					
					qw_police_team.setQw_police_team_street(qw_police_team_street);//警组信息
					Qw_equip_info qw_equip_info=service.qwequipinfos(modelMap);//9.14.	装备信息
					modelMap.put("fk_equip_id",qw_equip_info.getPk_id());
					List<Qw_guns_relation> listguns=service.qwgunsrelation(modelMap);//枪支关联警员信息 装备信息ID查询
					for (Qw_guns_relation qw_guns_relation : listguns) {
						modelMap.put("fk_user_id", qw_guns_relation.getFk_user_id());
						if(null!=modelMap.get("fk_user_id")) {
						qw_guns_relation.setSyspoliceinfo(service.syspoliceinfo(modelMap));//枪支关联警员信息
						}
					}
					qw_equip_info.setQw_guns_relation(listguns);//9.15.	枪支关联警员信息
					qw_police_team.setQw_equip_info(qw_equip_info);//9.14.	装备信息
					List<Qw_walk_patrol_relation> walklist=service.qwwalkpatrolrelationlist(modelMap);
					for (Qw_walk_patrol_relation qw_walk_patrol_relation : walklist) {
						modelMap.put("fk_user_id", qw_walk_patrol_relation.getFk_user_id());
						if(null!=modelMap.get("fk_user_id")) {
						qw_walk_patrol_relation.setSyspoliceinfo(service.syspoliceinfo(modelMap));
						}
					}
					qw_police_team.setQw_walk_patrol_relation(walklist);//步巡关联人员信息
					
				}
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
		List<Jcsjpoliceresources> jcsjpoliceresources=pageinfo.getList();
	    //勤务报备   车俩 当天班次是否报备
 		List<Integer> listuserid=service.bcheliangbaobei(modelMap);
	    for (Jcsjpoliceresources resources : jcsjpoliceresources) {
			     for (Integer  userid : listuserid) {
					    if(resources.getPk_id().equals(userid)) {//存在
					    	resources.setShifou(1);;//报备了
					    	break;
					    }
				}
		}
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
	public PageInfo<Jcsj_police_res_person> policelist(@RequestBody HashMap<String,Object> modelMap ){
		String jian=modelMap.get("jiangzhijinyuandata").toString();
		if(jian.equals("")) {
			modelMap.put("arr", null);
		}else {
			modelMap.put("arr", jian.split(","));
		}
		
		if(modelMap.get("jinyuandataAll")!=null&&!modelMap.get("jinyuandataAll").toString().equals("[]")) {
			 JSONArray array = JSONArray.fromObject(modelMap.get("jinyuandataAll").toString());
		        List array2 =(ArrayList)JSONArray.toCollection(array, HashMap.class);
			modelMap.put("jinyuandataAll", array2);
		}else {
			modelMap.put("jinyuandataAll", null);
		}
		Integer pageSize= Integer.parseInt(modelMap.get("pageSize").toString());//每页有显示多少条
		//获取分页数据位置,每页显示16条数据
 		PageHelper.startPage(Integer.valueOf(modelMap.get("currentPage").toString()),pageSize, true);
 		
		List<Jcsj_police_res_person> list= service.selectpolice(modelMap);
		PageInfo<Jcsj_police_res_person> pageinfo=new PageInfo<Jcsj_police_res_person>(list,5);
	    List<Jcsj_police_res_person> resperson=pageinfo.getList();
	    //勤务报备 步行人员  车俩人员 当天班次是否报备
 		List<Integer> listuserid=service.bancibaobei(modelMap);
	    for (Jcsj_police_res_person jcsj_police_res_person : resperson) {
			     for (Integer  userid : listuserid) {
					    if(jcsj_police_res_person.getId().equals(userid)) {//存在
					    	jcsj_police_res_person.setBaobei(1);//报备了
					    	break;
					    }
				}
		}
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
	 * 查询节假日
	 * @return
	 */
	@RequestMapping("jiejiari")
	public List<String> selectjj(@RequestBody HashMap<String,Object> modelMap){
		List<Sysfrmcode> list=service.selectjjr(modelMap);
		List<String> timelist=new ArrayList<String>();
		for (Sysfrmcode sysfrmcode : list) {
			String time[]=sysfrmcode.getSyhi_holiday().split(",");
			for (String string : time) {
				timelist.add(string);
			}
		}
		return timelist;
	}
	/**
	 * 勤务报备主界面统计参数
	 * @return
	 */
	@RequestMapping("selectTjzy")
	public List<Tjzy> selectTjzy(@RequestBody HashMap<String,Object> modelMap){
		return service.selectTjzy(modelMap);
	}
	/**
	 * 查询报备日期的警车警员民警 数据
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("preparation")
	public List<View_preparation> view_preparation(@RequestBody HashMap<String,Object> modelMap){
		return service.view_preparation(modelMap);
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
	/**
	 *  删除报备信息
	 * @return
	 */
	@RequestMapping("delqinwubaobei")
	public Integer delqinwubaobei(@RequestBody HashMap<String,Object> modelMap){
		try {
			service.delbaobei(modelMap);
			return 1;
		} catch (Exception e) {
			return 2;
		}
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
	 * 更新警组街面勤务
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("updateinformation")
	public Integer updateinformation(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request) throws ParseException{
		try {
			HttpSession session = request.getSession();
			Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());//获取用户
			modelMap.put("fk_dept_id", userMap.get("sypi_dept_pk"));//部门id
			modelMap.put("create_person_id", userMap.get("sypi_pk"));//创建人
			modelMap.put("report_person_id",userMap.get("sypi_pk"));//创建人
			modelMap.put("report_time",new Date());//报备时间
			modelMap.put("report_type", 1);//报备类型（1：街面勤务；2：值班值守；3：接处警；4：轮休;5：机关）
			modelMap.put("service_type", 1);//勤务类型（冗余数据）（1：街面勤务；2：值班值守；3：接处警；4：轮休;5：机关）
			modelMap.put("fk_police_team_id", modelMap.get("fk_police_team_id"));//警组ID
			modelMap.put("fk_report_id", modelMap.get("baobeipk"));//勤务报备ID
			
			ObjectMapper obj=new ObjectMapper();
			
			modelMap.put("personnel_list_str",obj.writeValueAsString(modelMap.get("personnel_list_str")));//关联人员集合
			modelMap.put("car_list_str",obj.writeValueAsString(modelMap.get("car_list_str")));//警车集合

				//更新9.17.	勤务报备
				service.updateQw_report(modelMap);
				
				service.delchexingg(modelMap);//删除枪支信息  装备信息 街面勤务
				
				//保存9.18.	街面勤务报备
				service.addqw_report_street(modelMap);
				//保存装备信息
				service.saveQw_equip_info(modelMap);
				//获取装备信息ID
				Integer qwequipinfopk=(Integer) modelMap.get("qwequipinfopk");
				modelMap.put("fk_equip_id", qwequipinfopk);//勤务报备ID
				JSONArray gunsdata = JSONArray.fromObject(modelMap.get("gunsdata"));//枪支关联警员
				if(!gunsdata.toString().equals("[null]")) {
				for(int i=0;i<gunsdata.size();i++){//枪支关联警员
					JSONObject json=gunsdata.getJSONObject(i);
					modelMap.put("fk_user_id", json.get("id"));
					service.addqw_guns_relation(modelMap);
				}
				}
			    //步巡人员 start
				List<Jcsj_police_res_person> policList=new ArrayList<Jcsj_police_res_person>();//警员集合
				if(null!=modelMap.get("personincharge")&&!modelMap.get("personincharge").equals("")) {
					JSONArray personincharge = JSONArray.fromObject(modelMap.get("personincharge"));//负责人
					if(!personincharge.toString().equals("[null]")) {
					for(int i=0;i<personincharge.size();i++){//负责人
						Jcsj_police_res_person stu=(Jcsj_police_res_person)JSONObject.toBean(personincharge.getJSONObject(i), Jcsj_police_res_person.class);
					    stu.setRyfl("1");//1负责人2 民警 3协警
					    stu.setFk_police_team_id(modelMap.get("baobeipk").toString());//勤务报备ID
					    policList.add(stu);
				 }
					}
				}
				if(null!=modelMap.get("peoplespolice")&&!modelMap.get("peoplespolice").equals("")) {
					JSONArray peoplespolice = JSONArray.fromObject(modelMap.get("peoplespolice"));//民警
					if(!peoplespolice.toString().equals("[null]")) {
					for(int i=0;i<peoplespolice.size();i++){//民警
						Jcsj_police_res_person stu=(Jcsj_police_res_person)JSONObject.toBean(peoplespolice.getJSONObject(i), Jcsj_police_res_person.class);
					    stu.setRyfl("2");//1负责人2 民警 3协警
					    stu.setFk_police_team_id(modelMap.get("baobeipk").toString());//勤务报备ID
					    policList.add(stu);
				 }
					}
				}
				if(null!=modelMap.get("peoplespolice")&&!modelMap.get("peoplespolice").equals("")) {
					JSONArray auxiliarypolice = JSONArray.fromObject(modelMap.get("auxiliarypolice"));//协警
					if(!auxiliarypolice.toString().equals("[null]")) {
					for(int i=0;i<auxiliarypolice.size();i++){//协警
						Jcsj_police_res_person stu=(Jcsj_police_res_person)JSONObject.toBean(auxiliarypolice.getJSONObject(i), Jcsj_police_res_person.class);
					    stu.setRyfl("3");//1负责人2 民警 3协警
					    stu.setFk_police_team_id(modelMap.get("baobeipk").toString());//勤务报备ID
					    policList.add(stu);
				 }
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
					 Integer patrolpk=(Integer) modelMap.get("seq_qw_report_car_patrolpk");//获取车巡信息id
					 modelMap.put("fk_car_patrol_id", patrolpk);//车巡信息id
						 if(null!=json.get("fuzeren")&&!json.get("fuzeren").equals("null")&&!json.get("fuzeren").equals("")) {
							 modelMap.put("qw_car_patrol_relation_user_type", 1);//关联人员类型（1：负责人；2：民警；3：协警）
								 JSONArray fuzeren = JSONArray.fromObject(json.get("fuzeren"));//车辆负责人
								 for(int k=0;k<fuzeren.size();k++){
									 JSONObject fuzerenjson=fuzeren.getJSONObject(k);
									 modelMap.put("qw_car_patrol_relation_fk_user_id",fuzerenjson.get("id"));
									 service.saveqw_car_patrol_relation(modelMap);
								 }
							 
						 }
						if(null!=json.get("xiejing")&&!json.get("xiejing").equals("null")&&!json.get("xiejing").equals("")) {
							 modelMap.put("qw_car_patrol_relation_user_type", 3);//关联人员类型（1：负责人；2：民警；3：协警）
								 JSONArray xiejing = JSONArray.fromObject(json.get("xiejing"));//车辆协警
								 for(int k=0;k<xiejing.size();k++){
									 JSONObject xiejingjson=xiejing.getJSONObject(k);
									 modelMap.put("qw_car_patrol_relation_fk_user_id",xiejingjson.get("id"));
									 service.saveqw_car_patrol_relation(modelMap);
								 }
							 
						}
						if(null!=json.get("minjing")&&!json.get("minjing").equals("null")&&!json.get("minjing").equals("")) {
							 modelMap.put("qw_car_patrol_relation_user_type", 2);//关联人员类型（1：负责人；2：民警；3：协警）
								 JSONArray minjing = JSONArray.fromObject(json.get("minjing"));//车辆民警
								 for(int k=0;k<minjing.size();k++){
									 JSONObject minjingjson=minjing.getJSONObject(k);
									 modelMap.put("qw_car_patrol_relation_fk_user_id",minjingjson.get("id"));
									 service.saveqw_car_patrol_relation(modelMap);
								 }
						}
					
					}
				}
				
				//巡控方式  车辆 end
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	/***
	 * 更新报备值班值守信息
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("updatebeonduty")
	public Integer updatebeonduty(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request) throws ParseException{
		try {
			HttpSession session = request.getSession();
			Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());//获取用户
			modelMap.put("fk_dept_id", userMap.get("sypi_dept_pk"));//部门id
			modelMap.put("report_person_id", userMap.get("sypi_pk"));//报备人
			modelMap.put("report_time", new Date());//报备时间
			modelMap.put("fk_police_team_id", modelMap.get("fk_police_team_id"));//警组ID
			modelMap.put("report_type", 2);//2：值班值守
			JSONArray selecteddate = JSONArray.fromObject(modelMap.get("selecteddate"));//报备日期
			modelMap.put("personnel_list_str", JSONArray.fromObject(modelMap.get("personnel_list_str")).toString());//关联人员集合，存放人员类型、姓名、警号、呼号、电话号码json对象，以逗号分割（冗余数据）
			modelMap.put("fk_report_id", modelMap.get("baobeipk"));//勤务报备ID
			//更新9.17.	勤务报备
			service.updateQw_report(modelMap);
			service.delchexingg(modelMap);//删除枪支信息  装备信息 街面勤务
				service.addqw_report_duty(modelMap);//保存9.22.	值班值守报备
				JSONArray dutyleader = JSONArray.fromObject(modelMap.get("Dutyleader"));//值班领导
				if(!dutyleader.toString().equals("[null]")) {
				for(int k=0;k<dutyleader.size();k++){
					 JSONObject json=dutyleader.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("leader_telphone", json.get("yddh"));//值班领导联系电话
					if(null==json.get("yddh")||json.get("yddh").equals("null")) {
						modelMap.put("leader_telphone", "");//值班领导联系电话
					}
					modelMap.put("user_type", 1);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
					service.addqw_report_duty_relation(modelMap);
				}
				}
				modelMap.put("leader_telphone","");//值班领导联系电话
				JSONArray commander = JSONArray.fromObject(modelMap.get("Commander"));//指挥长
				if(!commander.toString().equals("[null]")) {
				for(int k=0;k<commander.size();k++){
					 JSONObject json=commander.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 2);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
					service.addqw_report_duty_relation(modelMap);
				}
				}
				JSONArray shiftforeman = JSONArray.fromObject(modelMap.get("shiftforeman"));//值班长
				if(!shiftforeman.toString().equals("[null]")) {
				for(int k=0;k<shiftforeman.size();k++){
					 JSONObject json=shiftforeman.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 3);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
					service.addqw_report_duty_relation(modelMap);
				}
				}
				JSONArray dutypolice = JSONArray.fromObject(modelMap.get("Dutypolice"));//值班民警
				if(!dutypolice.toString().equals("[null]")) {
				for(int k=0;k<dutypolice.size();k++){
					 JSONObject json=dutypolice.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 4);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
					service.addqw_report_duty_relation(modelMap);
				}
		     }
				JSONArray guardonduty = JSONArray.fromObject(modelMap.get("Guardonduty"));//值班协警
				if(!guardonduty.toString().equals("[null]")) {
				for(int k=0;k<guardonduty.size();k++){
					 JSONObject json=guardonduty.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 5);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
					service.addqw_report_duty_relation(modelMap);
				}
				}
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	/***
	 * 保存报备值班值守信息
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
			modelMap.put("report_person_id", userMap.get("sypi_pk"));//报备人
			modelMap.put("report_time", new Date());//报备时间
			modelMap.put("fk_police_team_id", modelMap.get("fk_police_team_id"));//警组ID
			modelMap.put("report_type", 2);//2：值班值守
			JSONArray selecteddate = JSONArray.fromObject(modelMap.get("selecteddate"));//报备日期
			modelMap.put("personnel_list_str", JSONArray.fromObject(modelMap.get("personnel_list_str")).toString());//关联人员集合，存放人员类型、姓名、警号、呼号、电话号码json对象，以逗号分割（冗余数据）
			for(int q=0;q<selecteddate.size();q++){
				String timr=selecteddate.get(q).toString().replace("年", "-").replace("月", "-").replace("日", "");
				SimpleDateFormat data=new SimpleDateFormat("yyyy-MM-dd");
		        modelMap.put("report_period_type", data.parse(timr));//报备日期
				service.addqw_report(modelMap);//保存9.17.	勤务报备
				Integer seq_qw_reportpk=(Integer) modelMap.get("seq_qw_reportpk");//获取勤务报备pk
				modelMap.put("fk_report_id", seq_qw_reportpk);
				service.addqw_report_duty(modelMap);//保存9.22.	值班值守报备
				JSONArray dutyleader = JSONArray.fromObject(modelMap.get("Dutyleader"));//值班领导
				if(!dutyleader.toString().equals("[null]")) {
				for(int k=0;k<dutyleader.size();k++){
					 JSONObject json=dutyleader.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("leader_telphone", json.get("yddh"));//值班领导联系电话
					if(null==json.get("yddh")||json.get("yddh").equals("null")) {
						modelMap.put("leader_telphone", "");//值班领导联系电话
					}
					modelMap.put("user_type", 1);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
					service.addqw_report_duty_relation(modelMap);
				}
				}
				modelMap.put("leader_telphone","");//值班领导联系电话
				JSONArray commander = JSONArray.fromObject(modelMap.get("Commander"));//指挥长
				if(!commander.toString().equals("[null]")) {
					for(int k=0;k<commander.size();k++){
						 JSONObject json=commander.getJSONObject(k);
						modelMap.put("fk_user_id", json.get("id"));
						modelMap.put("user_type", 2);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
						service.addqw_report_duty_relation(modelMap);
					}
				}
				JSONArray shiftforeman = JSONArray.fromObject(modelMap.get("shiftforeman"));//值班长
				if(!shiftforeman.toString().equals("[null]")) {
				for(int k=0;k<shiftforeman.size();k++){
					 JSONObject json=shiftforeman.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 3);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
					service.addqw_report_duty_relation(modelMap);
				}
				}
				JSONArray dutypolice = JSONArray.fromObject(modelMap.get("Dutypolice"));//值班民警
				if(!dutypolice.toString().equals("[null]")) {
				for(int k=0;k<dutypolice.size();k++){
					 JSONObject json=dutypolice.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 4);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
					service.addqw_report_duty_relation(modelMap);
				}
				}
				JSONArray guardonduty = JSONArray.fromObject(modelMap.get("Guardonduty"));//值班协警
				if(!guardonduty.toString().equals("[null]")) {
				for(int k=0;k<guardonduty.size();k++){
					 JSONObject json=guardonduty.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 5);//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
					service.addqw_report_duty_relation(modelMap);
				}
				}
			}
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	/***
	 * 更新机关工作报备
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("updateofficework")
	public Integer updateofficework(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request) throws ParseException{
		try {
			HttpSession session = request.getSession();
			Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());//获取用户
			modelMap.put("fk_dept_id", userMap.get("sypi_dept_pk"));//部门id
			modelMap.put("report_person_id", userMap.get("sypi_pk"));//报备人
			modelMap.put("report_time", new Date());//报备时间
			modelMap.put("fk_police_team_id", modelMap.get("fk_police_team_id"));//警组ID
			modelMap.put("report_type", 5);//5：机关
			JSONArray selecteddate = JSONArray.fromObject(modelMap.get("selecteddate"));//报备日期
			modelMap.put("personnel_list_str", JSONArray.fromObject(modelMap.get("personnel_list_str")).toString());//关联人员集合，存放人员类型、姓名、警号、呼号、电话号码json对象，以逗号分割（冗余数据）
		
			modelMap.put("fk_report_id", modelMap.get("baobeipk"));//勤务报备ID
			//更新9.17.	勤务报备
			service.updateQw_report(modelMap);
					service.delchexingg(modelMap);//删除枪支信息  装备信息 街面勤务
				
				service.addqw_report_office(modelMap);//保存9.28.	机关工作报备
				Integer seq_qw_report_officepk=(Integer) modelMap.get("seq_qw_report_officepk");//机关工作报备ID
				modelMap.put("fk_report_office_id", seq_qw_report_officepk);//机关工作报备ID
				JSONArray dutypolice = JSONArray.fromObject(modelMap.get("Dutypolice"));//值班民警
				if(!dutypolice.toString().equals("[null]")) {
				for(int k=0;k<dutypolice.size();k++){
					 JSONObject json=dutypolice.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 1);//关联人员类型（1：民警；2：协警）
					service.addqw_report_office_relation(modelMap);
				}
				}
				JSONArray guardonduty = JSONArray.fromObject(modelMap.get("Guardonduty"));//值班协警
				if(!guardonduty.toString().equals("[null]")) {
				for(int k=0;k<guardonduty.size();k++){
					 JSONObject json=guardonduty.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 2);//关联人员类型（1：民警；2：协警）
					service.addqw_report_office_relation(modelMap);
				}
				}
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	/***
	 * 保存机关工作报备
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("officework")
	public Integer officework(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request) throws ParseException{
		try {
			HttpSession session = request.getSession();
			Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());//获取用户
			modelMap.put("fk_dept_id", userMap.get("sypi_dept_pk"));//部门id
			modelMap.put("report_person_id", userMap.get("sypi_pk"));//报备人
			modelMap.put("report_time", new Date());//报备时间
			modelMap.put("fk_police_team_id", modelMap.get("fk_police_team_id"));//警组ID
			modelMap.put("report_type", 5);//5：机关
			JSONArray selecteddate = JSONArray.fromObject(modelMap.get("selecteddate"));//报备日期
			modelMap.put("personnel_list_str", JSONArray.fromObject(modelMap.get("personnel_list_str")).toString());//关联人员集合，存放人员类型、姓名、警号、呼号、电话号码json对象，以逗号分割（冗余数据）
			for(int q=0;q<selecteddate.size();q++){
				String timr=selecteddate.get(q).toString().replace("年", "-").replace("月", "-").replace("日", "");
				SimpleDateFormat data=new SimpleDateFormat("yyyy-MM-dd");
		        modelMap.put("report_period_type", data.parse(timr));//报备日期
				service.addqw_report(modelMap);//保存9.17.	勤务报备
				Integer seq_qw_reportpk=(Integer) modelMap.get("seq_qw_reportpk");//获取勤务报备pk
				modelMap.put("fk_report_id", seq_qw_reportpk);
				service.addqw_report_office(modelMap);//保存9.28.	机关工作报备
				Integer seq_qw_report_officepk=(Integer) modelMap.get("seq_qw_report_officepk");//机关工作报备ID
				modelMap.put("fk_report_office_id", seq_qw_report_officepk);//机关工作报备ID
				JSONArray dutypolice = JSONArray.fromObject(modelMap.get("Dutypolice"));//值班民警
				if(!dutypolice.toString().equals("[null]")) {
				for(int k=0;k<dutypolice.size();k++){
					 JSONObject json=dutypolice.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 1);//关联人员类型（1：民警；2：协警）
					service.addqw_report_office_relation(modelMap);
				}
				}
				JSONArray guardonduty = JSONArray.fromObject(modelMap.get("Guardonduty"));//值班协警
				if(!guardonduty.toString().equals("[null]")) {
				for(int k=0;k<guardonduty.size();k++){
					 JSONObject json=guardonduty.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 2);//关联人员类型（1：民警；2：协警）
					service.addqw_report_office_relation(modelMap);
				}
				}
			}
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	/***
	 * 更新轮休报备报备
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("updateroundbreak")
	public Integer updateroundbreak(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request) throws ParseException{
		try {
			HttpSession session = request.getSession();
			Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());//获取用户
			modelMap.put("fk_dept_id", userMap.get("sypi_dept_pk"));//部门id
			modelMap.put("report_person_id", userMap.get("sypi_pk"));//报备人
			modelMap.put("report_time", new Date());//报备时间
			modelMap.put("fk_police_team_id", modelMap.get("fk_police_team_id"));//警组ID
			modelMap.put("report_type", 4);//4：轮休
			JSONArray selecteddate = JSONArray.fromObject(modelMap.get("selecteddate"));//报备日期
			modelMap.put("personnel_list_str", JSONArray.fromObject(modelMap.get("personnel_list_str")).toString());//关联人员集合，存放人员类型、姓名、警号、呼号、电话号码json对象，以逗号分割（冗余数据）
			
			modelMap.put("fk_report_id", modelMap.get("baobeipk"));//勤务报备ID
			//更新9.17.	勤务报备
			service.updateQw_report(modelMap);
					service.delchexingg(modelMap);//删除枪支信息  装备信息 街面勤务
			
				service.addqw_report_rest(modelMap);//保存9.26.	轮休报备
				JSONArray dutypolice = JSONArray.fromObject(modelMap.get("Dutypolice"));//值班民警
				if(!dutypolice.toString().equals("[null]")) {
				for(int k=0;k<dutypolice.size();k++){
					 JSONObject json=dutypolice.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 1);//关联人员类型（1：民警；2：协警）
					service.addqw_report_rest_relation(modelMap);
				}
				}
				JSONArray guardonduty = JSONArray.fromObject(modelMap.get("Guardonduty"));//值班协警
				if(!guardonduty.toString().equals("[null]")) {
				for(int k=0;k<guardonduty.size();k++){
					 JSONObject json=guardonduty.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 2);//关联人员类型（1：民警；2：协警）
					service.addqw_report_rest_relation(modelMap);
				}
				}
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	/***
	 * 保存轮休报备报备
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("roundbreak")
	public Integer roundbreak(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request) throws ParseException{
		try {
			HttpSession session = request.getSession();
			Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());//获取用户
			modelMap.put("fk_dept_id", userMap.get("sypi_dept_pk"));//部门id
			modelMap.put("report_person_id", userMap.get("sypi_pk"));//报备人
			modelMap.put("report_time", new Date());//报备时间
			modelMap.put("fk_police_team_id", modelMap.get("fk_police_team_id"));//警组ID
			modelMap.put("report_type", 4);//4：轮休
			JSONArray selecteddate = JSONArray.fromObject(modelMap.get("selecteddate"));//报备日期
			modelMap.put("personnel_list_str", JSONArray.fromObject(modelMap.get("personnel_list_str")).toString());//关联人员集合，存放人员类型、姓名、警号、呼号、电话号码json对象，以逗号分割（冗余数据）
			for(int q=0;q<selecteddate.size();q++){
				String timr=selecteddate.get(q).toString().replace("年", "-").replace("月", "-").replace("日", "");
				SimpleDateFormat data=new SimpleDateFormat("yyyy-MM-dd");
		        modelMap.put("report_period_type", data.parse(timr));//报备日期
				service.addqw_report(modelMap);//保存9.17.	勤务报备
				Integer seq_qw_reportpk=(Integer) modelMap.get("seq_qw_reportpk");//获取勤务报备pk
				modelMap.put("fk_report_id", seq_qw_reportpk);
				service.addqw_report_rest(modelMap);//保存9.26.	轮休报备
				Integer qwreportrestpk=(Integer) modelMap.get("qwreportrestpk");//轮休报备ID
				modelMap.put("fk_report_rest_id", qwreportrestpk);//机关工作报备ID
				JSONArray dutypolice = JSONArray.fromObject(modelMap.get("Dutypolice"));//值班民警
				if(!dutypolice.toString().equals("[null]")) {
				for(int k=0;k<dutypolice.size();k++){
					 JSONObject json=dutypolice.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 1);//关联人员类型（1：民警；2：协警）
					service.addqw_report_rest_relation(modelMap);
				}
				}
				JSONArray guardonduty = JSONArray.fromObject(modelMap.get("Guardonduty"));//值班协警
				if(!guardonduty.toString().equals("[null]")) {
				for(int k=0;k<guardonduty.size();k++){
					 JSONObject json=guardonduty.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 2);//关联人员类型（1：民警；2：协警）
					service.addqw_report_rest_relation(modelMap);
				}
				}
			}
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	/***
	 * 更新接处警报备
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("updatetakepolice")
	public Integer updatetakepolice(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request) throws ParseException{
		try {
			HttpSession session = request.getSession();
			Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());//获取用户
			modelMap.put("fk_dept_id", userMap.get("sypi_dept_pk"));//部门id
			modelMap.put("report_person_id", userMap.get("sypi_pk"));//报备人
			modelMap.put("report_time", new Date());//报备时间
			modelMap.put("fk_police_team_id", modelMap.get("fk_police_team_id"));//警组ID
			modelMap.put("report_type", 3);//3：接处警
			JSONArray selecteddate = JSONArray.fromObject(modelMap.get("selecteddate"));//报备日期
			modelMap.put("personnel_list_str", JSONArray.fromObject(modelMap.get("personnel_list_str")).toString());//关联人员集合，存放人员类型、姓名、警号、呼号、电话号码json对象，以逗号分割（冗余数据）
			modelMap.put("telephone", modelMap.get("telephone"));//值班电话
			modelMap.put("fk_report_id", modelMap.get("baobeipk"));//勤务报备ID
			//更新9.17.	勤务报备
			service.updateQw_report(modelMap);
			service.delchexingg(modelMap);//删除枪支信息  装备信息 街面勤务
				service.addqw_report_alarm(modelMap);//保存9.24.	接处警报备
				Integer restrelationpk=(Integer) modelMap.get("restrelationpk");//接处警报备ID
				modelMap.put("fk_report_alarm_id", restrelationpk);//接处警报备ID
				JSONArray dutypolice = JSONArray.fromObject(modelMap.get("Dutypolice"));//值班民警
				if(!dutypolice.toString().equals("[null]")) {
				for(int k=0;k<dutypolice.size();k++){
					 JSONObject json=dutypolice.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 1);//关联人员类型（1：民警；2：协警）
					service.addqw_report_alarm_relation(modelMap);
				}
				}
				JSONArray guardonduty = JSONArray.fromObject(modelMap.get("Guardonduty"));//值班协警
				if(!guardonduty.toString().equals("[null]")) {
				for(int k=0;k<guardonduty.size();k++){
					 JSONObject json=guardonduty.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 2);//关联人员类型（1：民警；2：协警）
					service.addqw_report_alarm_relation(modelMap);
				}
				}
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	/***
	 * 保存接处警报备
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("takepolice")
	public Integer takepolice(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request) throws ParseException{
		try {
			HttpSession session = request.getSession();
			Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());//获取用户
			modelMap.put("fk_dept_id", userMap.get("sypi_dept_pk"));//部门id
			modelMap.put("report_person_id", userMap.get("sypi_pk"));//报备人
			modelMap.put("report_time", new Date());//报备时间
			modelMap.put("fk_police_team_id", modelMap.get("fk_police_team_id"));//警组ID
			modelMap.put("report_type", 3);//3：接处警
			JSONArray selecteddate = JSONArray.fromObject(modelMap.get("selecteddate"));//报备日期
			modelMap.put("personnel_list_str", JSONArray.fromObject(modelMap.get("personnel_list_str")).toString());//关联人员集合，存放人员类型、姓名、警号、呼号、电话号码json对象，以逗号分割（冗余数据）
			modelMap.put("telephone", modelMap.get("telephone"));//值班电话
			for(int q=0;q<selecteddate.size();q++){
				String timr=selecteddate.get(q).toString().replace("年", "-").replace("月", "-").replace("日", "");
				SimpleDateFormat data=new SimpleDateFormat("yyyy-MM-dd");
		        modelMap.put("report_period_type", data.parse(timr));//报备日期
				service.addqw_report(modelMap);//保存9.17.	勤务报备
				Integer seq_qw_reportpk=(Integer) modelMap.get("seq_qw_reportpk");//获取勤务报备pk
				modelMap.put("fk_report_id", seq_qw_reportpk);
				
				service.addqw_report_alarm(modelMap);//保存9.24.	接处警报备
				Integer restrelationpk=(Integer) modelMap.get("restrelationpk");//接处警报备ID
				modelMap.put("fk_report_alarm_id", restrelationpk);//接处警报备ID
				JSONArray dutypolice = JSONArray.fromObject(modelMap.get("Dutypolice"));//值班民警
				if(!dutypolice.toString().equals("[null]")) {
				for(int k=0;k<dutypolice.size();k++){
					 JSONObject json=dutypolice.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 1);//关联人员类型（1：民警；2：协警）
					service.addqw_report_alarm_relation(modelMap);
				}
				}
				JSONArray guardonduty = JSONArray.fromObject(modelMap.get("Guardonduty"));//值班协警
				if(!guardonduty.toString().equals("[null]")) {
				for(int k=0;k<guardonduty.size();k++){
					 JSONObject json=guardonduty.getJSONObject(k);
					modelMap.put("fk_user_id", json.get("id"));
					modelMap.put("user_type", 2);//关联人员类型（1：民警；2：协警）
					service.addqw_report_alarm_relation(modelMap);
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
	 * 总览数据
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("overview")
	public HashMap<String,Object> overview(@RequestBody HashMap<String,Object> modelMap ){
		Overviewdata overviewdata=new Overviewdata();
		modelMap.put("state", 1);//街面勤务
	    List<Overviewdata>	jiemian=service.overviewdata(modelMap);
		modelMap.put("state", 2);//值班值守
		List<Overviewdata>	zhiban=service.overviewdata(modelMap);
		modelMap.put("state", 3);//接处警
		List<Overviewdata>	jiechu=service.overviewdata(modelMap);
		modelMap.put("state", 4);//轮休
		List<Overviewdata>	lunxiu=service.overviewdata(modelMap);
		modelMap.put("state", 5);//机关
		List<Overviewdata>	jiguan=service.overviewdata(modelMap);
		Integer a=0;
		a=jiemian.size();
		if(a<zhiban.size()) {
			a=zhiban.size();
		}
		if(a<jiechu.size()) {
			a=jiechu.size();
		}
		if(a<jiguan.size()) {
			a=jiguan.size();
		}
		if(a<lunxiu.size()) {
			a=lunxiu.size();
		}
		for (int i = 0; i <a; i++) {
			if(a>jiemian.size()) {
				jiemian.add(overviewdata);
			}
			if(a>jiechu.size()) {
				jiechu.add(overviewdata);
			}
			if(a>jiguan.size()) {
				jiguan.add(overviewdata);
			}
			if(a>zhiban.size()) {
				zhiban.add(overviewdata);
			}
			if(a>lunxiu.size()) {
				lunxiu.add(overviewdata);
			}
		}
		modelMap.put("jiemian", jiemian);
		modelMap.put("zhiban", zhiban);
		modelMap.put("jiechu", jiechu);
		modelMap.put("jiguan", jiguan);
		modelMap.put("lunxiu", lunxiu);
		 return modelMap;
	}
	/***
	 * 数据总览集合
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("gongen")
	public HashMap<String,Object> gongen(@RequestBody HashMap<String,Object> modelMap ){
		modelMap.put("report_type", 1);//街面勤务
		modelMap.put("x_jiemian", service.gongen(modelMap));
		modelMap.put("report_type", 2);//值班值守
		List<Gongen> list=service.gongen(modelMap);
	/*	Dutyleader 值班领导
		Commander 指挥长
		shiftforeman 值班长
		Dutypolice 值班民警
		Guardonduty 值班协警*/
		for (Gongen gongen : list) {
			JSONArray dutypolice = JSONArray.fromObject(gongen.getPersonnel_list_str());//值班民警
			for(int k=0;k<dutypolice.size();k++){
				JSONObject json=dutypolice.getJSONObject(k);
				JSONArray bsjson = JSONArray.fromObject(json.get("Dutyleader"));
				if(!bsjson.toString().equals("[null]")) {
				for(int d=0;d<bsjson.size();d++){
					JSONObject js=bsjson.getJSONObject(d);
					gongen.setZhibanlingdao(js.get("xm").toString());
					gongen.setLianxiphone(js.get("yddh").toString());
					
				}
				}
				
				JSONArray zhihuizhang = JSONArray.fromObject(json.get("Commander"));
				if(!zhihuizhang.toString().equals("[null]")) {
				for(int d=0;d<zhihuizhang.size();d++){
					JSONObject js=zhihuizhang.getJSONObject(d);
					gongen.setZhihuizhang(js.get("xm").toString());
					
				}
				}
			}
		}
		modelMap.put("x_zhiban", list);
		modelMap.put("report_type", 3);//接处警
		List<Gongen> jiechujing=service.gongen(modelMap);
		for (Gongen gongen2 : jiechujing) {
			StringBuilder  sb = new StringBuilder();
			JSONArray dutypolice = JSONArray.fromObject(gongen2.getPersonnel_list_str());//警员
			for(int k=0;k<dutypolice.size();k++){
				JSONObject json=dutypolice.getJSONObject(k);
				JSONArray minjing = JSONArray.fromObject(json.get("minjing"));
				if(!minjing.toString().equals("[null]")) {
				for (int i = 0; i < minjing.size(); i++) {
					JSONObject minjingjson=minjing.getJSONObject(i);
					sb.append(minjingjson.get("xm").toString()+",");
				}
				}
				JSONArray xiejing = JSONArray.fromObject(json.get("xiejing"));
				if(!xiejing.toString().equals("[null]")) {
				for (int i = 0; i < xiejing.size(); i++) {
					JSONObject xiejingjson=xiejing.getJSONObject(i);
					sb.append(xiejingjson.get("xm").toString()+",");
				}
				}
			}
			if(sb.length()!=0) {
				gongen2.setRenyuan(sb.substring(0, sb.length()-1));
			}else {
				gongen2.setRenyuan("");
			}
			
		}
		modelMap.put("x_jiechujing", jiechujing);
		modelMap.put("report_type", 4);//轮休
		List<Gongen> go_lunxun=service.gongen(modelMap);
		for (Gongen gongen : go_lunxun) {
			StringBuilder  min = new StringBuilder();
			StringBuilder  xie = new StringBuilder();
			JSONArray dutypolice = JSONArray.fromObject(gongen.getPersonnel_list_str());//警员
			for(int k=0;k<dutypolice.size();k++){
				JSONObject json=dutypolice.getJSONObject(k);
				JSONArray minjing = JSONArray.fromObject(json.get("minjing"));
				if(!minjing.toString().equals("[null]")) {
				for (int i = 0; i < minjing.size(); i++) {
					JSONObject minjingjson=minjing.getJSONObject(i);
					min.append(minjingjson.get("xm").toString()+",");
				}
				}
				JSONArray xiejing = JSONArray.fromObject(json.get("xiejing"));
				if(!xiejing.toString().equals("[null]")) {
				for (int i = 0; i < xiejing.size(); i++) {
					JSONObject xiejingjson=xiejing.getJSONObject(i);
					xie.append(xiejingjson.get("xm").toString()+",");
				}
				}
			}
			if(min.length()!=0) {
				gongen.setMinjing(min.substring(0, min.length()-1));
			}else {
				gongen.setRenyuan("");
			}
			if(xie.length()!=0) {
				gongen.setXiejing(xie.substring(0, xie.length()-1));
			}else {
				gongen.setRenyuan("");
			}
		}
		modelMap.put("x_lunxun", go_lunxun);
		
		modelMap.put("report_type", 5);//机关
		List<Gongen> go_jiguan=service.gongen(modelMap);
		for (Gongen gongen : go_jiguan) {
			StringBuilder  min = new StringBuilder();
			StringBuilder  xie = new StringBuilder();
			JSONArray dutypolice = JSONArray.fromObject(gongen.getPersonnel_list_str());//警员
			for(int k=0;k<dutypolice.size();k++){
				JSONObject json=dutypolice.getJSONObject(k);
				JSONArray minjing = JSONArray.fromObject(json.get("minjing"));
				if(!minjing.toString().equals("[null]")) {
				for (int i = 0; i < minjing.size(); i++) {
					JSONObject minjingjson=minjing.getJSONObject(i);
					min.append(minjingjson.get("xm").toString()+",");
				}
				}
				JSONArray xiejing = JSONArray.fromObject(json.get("xiejing"));
				if(!xiejing.toString().equals("[null]")) {
				for (int i = 0; i < xiejing.size(); i++) {
					JSONObject xiejingjson=xiejing.getJSONObject(i);
					xie.append(xiejingjson.get("xm").toString()+",");
				}
				}
			}
			if(min.length()!=0) {
				gongen.setMinjing(min.substring(0, min.length()-1));
			}else {
				gongen.setRenyuan("");
			}
			if(xie.length()!=0) {
				gongen.setXiejing(xie.substring(0, xie.length()-1));
			}else {
				gongen.setRenyuan("");
			}
		}
		modelMap.put("x_jiguan", go_jiguan);
		return modelMap;
	}
	/***
	 * 获取街面报备信息
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("jieqwreport")
	public Qw_report jieqwreport(@RequestBody HashMap<String,Object> modelMap ){
		Qw_report qw_report=service.qwreport(modelMap);//勤务报备
		
		
		 return qw_report;
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
			modelMap.put("report_person_id",userMap.get("sypi_pk"));//创建人
			modelMap.put("report_time",new Date());//报备时间
			modelMap.put("report_type", 1);//报备类型（1：街面勤务；2：值班值守；3：接处警；4：轮休;5：机关）
			modelMap.put("service_type", 1);//勤务类型（冗余数据）（1：街面勤务；2：值班值守；3：接处警；4：轮休;5：机关）
			modelMap.put("fk_police_team_id", modelMap.get("fk_police_team_id"));//警组ID
			ObjectMapper obj=new ObjectMapper();
			
			modelMap.put("personnel_list_str",obj.writeValueAsString(modelMap.get("personnel_list_str")));//关联人员集合
			modelMap.put("car_list_str",obj.writeValueAsString(modelMap.get("car_list_str")));//警车集合
			JSONArray selecteddate = JSONArray.fromObject(modelMap.get("selecteddate"));//报备日期
			for(int q=0;q<selecteddate.size();q++){
				String timr=selecteddate.get(q).toString().replace("年", "-").replace("月", "-").replace("日", "");
				SimpleDateFormat data=new SimpleDateFormat("yyyy-MM-dd");
		        modelMap.put("report_period_type", data.parse(timr));//报备日期
				//保存9.17.	勤务报备
				Integer start=service.addqw_report(modelMap);
				//获取勤务报备ID
				Integer count=(Integer) modelMap.get("seq_qw_reportpk");
				modelMap.put("fk_report_id", count);//勤务报备ID
				//保存9.18.	街面勤务报备
				service.addqw_report_street(modelMap);
				//保存装备信息
				service.saveQw_equip_info(modelMap);
				//获取装备信息ID
				Integer qwequipinfopk=(Integer) modelMap.get("qwequipinfopk");
				modelMap.put("fk_equip_id", qwequipinfopk);//勤务报备ID
				JSONArray gunsdata = JSONArray.fromObject(modelMap.get("gunsdata"));//枪支关联警员
				if(!gunsdata.toString().equals("[null]")) {
				for(int i=0;i<gunsdata.size();i++){//枪支关联警员
					JSONObject json=gunsdata.getJSONObject(i);
					modelMap.put("fk_user_id", json.get("id"));
					service.addqw_guns_relation(modelMap);
				}
				}
			    //步巡人员 start
				List<Jcsj_police_res_person> policList=new ArrayList<Jcsj_police_res_person>();//警员集合
				if(null!=modelMap.get("personincharge")&&!modelMap.get("personincharge").equals("")) {
					JSONArray personincharge = JSONArray.fromObject(modelMap.get("personincharge"));//负责人
					if(!personincharge.toString().equals("[null]")) {
					for(int i=0;i<personincharge.size();i++){//负责人
						Jcsj_police_res_person stu=(Jcsj_police_res_person)JSONObject.toBean(personincharge.getJSONObject(i), Jcsj_police_res_person.class);
					    stu.setRyfl("1");//1负责人2 民警 3协警
					    stu.setFk_police_team_id(count.toString());//勤务报备ID
					    policList.add(stu);
				 }
					}
				}
				if(null!=modelMap.get("peoplespolice")&&!modelMap.get("peoplespolice").equals("")) {
					JSONArray peoplespolice = JSONArray.fromObject(modelMap.get("peoplespolice"));//民警
					if(!peoplespolice.toString().equals("[null]")) {
					for(int i=0;i<peoplespolice.size();i++){//民警
						Jcsj_police_res_person stu=(Jcsj_police_res_person)JSONObject.toBean(peoplespolice.getJSONObject(i), Jcsj_police_res_person.class);
					    stu.setRyfl("2");//1负责人2 民警 3协警
					    stu.setFk_police_team_id(count.toString());//勤务报备ID
					    policList.add(stu);
				 }
					}
				}
				if(null!=modelMap.get("peoplespolice")&&!modelMap.get("peoplespolice").equals("")) {
					JSONArray auxiliarypolice = JSONArray.fromObject(modelMap.get("auxiliarypolice"));//协警
					if(!auxiliarypolice.toString().equals("[null]")) {
					for(int i=0;i<auxiliarypolice.size();i++){//协警
						Jcsj_police_res_person stu=(Jcsj_police_res_person)JSONObject.toBean(auxiliarypolice.getJSONObject(i), Jcsj_police_res_person.class);
					    stu.setRyfl("3");//1负责人2 民警 3协警
					    stu.setFk_police_team_id(count.toString());//勤务报备ID
					    policList.add(stu);
				 }
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
					 Integer patrolpk=(Integer) modelMap.get("seq_qw_report_car_patrolpk");//获取车巡信息id
					 modelMap.put("fk_car_patrol_id", patrolpk);//车巡信息id
						 if(null!=json.get("fuzeren")&&!json.get("fuzeren").equals("null")&&!json.get("fuzeren").equals("")) {
							 modelMap.put("qw_car_patrol_relation_user_type", 1);//关联人员类型（1：负责人；2：民警；3：协警）
								 JSONArray fuzeren = JSONArray.fromObject(json.get("fuzeren"));//车辆负责人
								 for(int k=0;k<fuzeren.size();k++){
									 JSONObject fuzerenjson=fuzeren.getJSONObject(k);
									 modelMap.put("qw_car_patrol_relation_fk_user_id",fuzerenjson.get("id"));
									 service.saveqw_car_patrol_relation(modelMap);
								 }
								 
						 }
						if(null!=json.get("xiejing")&&!json.get("xiejing").equals("null")&&!json.get("xiejing").equals("")) {
							 modelMap.put("qw_car_patrol_relation_user_type", 3);//关联人员类型（1：负责人；2：民警；3：协警）
								 JSONArray xiejing = JSONArray.fromObject(json.get("xiejing"));//车辆协警
								 for(int k=0;k<xiejing.size();k++){
									 JSONObject xiejingjson=xiejing.getJSONObject(k);
									 modelMap.put("qw_car_patrol_relation_fk_user_id",xiejingjson.get("id"));
									 service.saveqw_car_patrol_relation(modelMap);
								 }
							 
						}
						if(null!=json.get("minjing")&&!json.get("minjing").equals("null")&&!json.get("minjing").equals("")) {
							 modelMap.put("qw_car_patrol_relation_user_type", 2);//关联人员类型（1：负责人；2：民警；3：协警）
								 JSONArray minjing = JSONArray.fromObject(json.get("minjing"));//车辆民警
								 for(int k=0;k<minjing.size();k++){
									 JSONObject minjingjson=minjing.getJSONObject(k);
									 modelMap.put("qw_car_patrol_relation_fk_user_id",minjingjson.get("id"));
									 service.saveqw_car_patrol_relation(modelMap);
								 }
						}
					
					}
				}
				
				//巡控方式  车辆 end
				
				
			}
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	@RequestMapping("/documents/{fkdeptid}/{reportperiodtype}/{deptname}")
	public void   documents(@PathVariable("fkdeptid") String fkdeptid,@PathVariable("reportperiodtype") String reportperiodtype,@PathVariable("deptname") String deptname,HttpServletRequest request, HttpServletResponse response,HashMap<String, Object> map) throws Exception {
		String savePath = request.getSession().getServletContext().getRealPath(deptname+"-勤务报备("+reportperiodtype+").xls");
		downexcle(fkdeptid, reportperiodtype,savePath,deptname);
		HashMap<String, Object> modelMap = new LinkedHashMap<String, Object>();
	    //另外下载方式
		/*String savePath="F:\\ce\\import.log";*/
		
		System.err.println(savePath);
		// savePath=request.getSession().getServletContext().getRealPath(savePath);
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
	        response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("gb2312"), "ISO8859-1"));
	        response.addHeader("Content-Length", "" + file.length());
	        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
	        response.setContentType("application/octet-stream");
	        toClient.write(buffer);
	        toClient.flush();
	        toClient.close();
	}
	public void downexcle(String fkdeptid,String reportperiodtype,String savePath,String deptname) throws FileNotFoundException, IOException {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();
		modelMap.put("report_period_type", reportperiodtype);modelMap.put("fk_dept_id", fkdeptid);
		Overviewdata overviewdata=new Overviewdata();
		modelMap.put("state", 1);//街面勤务
	    List<Overviewdata>	jiemian=service.overviewdata(modelMap);
		modelMap.put("state", 2);//值班值守
		List<Overviewdata>	zhiban=service.overviewdata(modelMap);
		modelMap.put("state", 3);//接处警
		List<Overviewdata>	jiechu=service.overviewdata(modelMap);
		modelMap.put("state", 4);//轮休
		List<Overviewdata>	lunxiu=service.overviewdata(modelMap);
		modelMap.put("state", 5);//机关
		List<Overviewdata>	jiguan=service.overviewdata(modelMap);
		Integer a=0;
		a=jiemian.size();
		if(a<zhiban.size()) {
			a=zhiban.size();
		}
		if(a<jiechu.size()) {
			a=jiechu.size();
		}
		if(a<jiguan.size()) {
			a=jiguan.size();
		}
		if(a<lunxiu.size()) {
			a=lunxiu.size();
		}
		for (int i = 0; i <a; i++) {
			if(a>jiemian.size()) {
				jiemian.add(overviewdata);
			}
			if(a>jiechu.size()) {
				jiechu.add(overviewdata);
			}
			if(a>jiguan.size()) {
				jiguan.add(overviewdata);
			}
			if(a>zhiban.size()) {
				zhiban.add(overviewdata);
			}
			if(a>lunxiu.size()) {
				lunxiu.add(overviewdata);
			}
		}
		  HSSFWorkbook wb = new HSSFWorkbook();
    	  HSSFSheet sheet = wb.createSheet("table");  //创建table工作薄
    	  String[] headers = { "单位信息", "街面勤务", "", "", "","值班值守","", "接处警", "机关工作","", "轮休",""};
    	  String[] headerse = { "","巡区名称", "班次/时间", "车辆", "人员","班次时间", "人员", "人员", "工作时间", "人员", "工作时间", "人员"};
    	 
    	  //普通样式
    	 HSSFCellStyle cellStyle = wb.createCellStyle();
  		cellStyle.setAlignment(HorizontalAlignment.CENTER);// 居中    
  		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直 
  		cellStyle.setBorderBottom(BorderStyle.THIN);//下边框    
  		cellStyle.setBorderLeft(BorderStyle.THIN);//左边框    
  		cellStyle.setBorderTop(BorderStyle.THIN);//上边框    
  		cellStyle.setBorderRight(BorderStyle.THIN);//右边框 
  		
  		//标题带颜色 样式
  	   	 HSSFCellStyle cellStyleb = wb.createCellStyle();
  	   	 cellStyleb.setAlignment(HorizontalAlignment.CENTER);// 居中    
  	   	 cellStyleb.setVerticalAlignment(VerticalAlignment.CENTER);//垂直 
	  	cellStyleb.setBorderBottom(BorderStyle.THIN);//下边框    
	  	cellStyleb.setBorderLeft(BorderStyle.THIN);//左边框    
	  	cellStyleb.setBorderTop(BorderStyle.THIN);//上边框    
	  	cellStyleb.setBorderRight(BorderStyle.THIN);//右边框 
	  	HSSFFont font = wb.createFont(); 
	  	font.setFontName("楷体");//设置字体名称 
	  	font.setFontHeightInPoints((short)18);//设置字号 
	  	font.setItalic(false);//设置是否为斜体 
	  	font.setBold(true);//设置是否加粗 
	  	font.setColor(IndexedColors.WHITE.index);//设置字体颜色 
	  	cellStyleb.setFont(font);
	  	
	  	
		  //普通样式
   	 HSSFCellStyle cellStyletime = wb.createCellStyle();
   	cellStyletime.setAlignment(HorizontalAlignment.CENTER);// 居中    
   	cellStyletime.setVerticalAlignment(VerticalAlignment.CENTER);//垂直 
   	cellStyletime.setBorderBottom(BorderStyle.THIN);//下边框    
   	cellStyletime.setBorderLeft(BorderStyle.THIN);//左边框    
   	cellStyletime.setBorderTop(BorderStyle.THIN);//上边框    
   	cellStyletime.setBorderRight(BorderStyle.THIN);//右边框 
 	 	HSSFFont font1 = wb.createFont(); 
       	font1.setFontName("华文楷体");//设置字体名称 
       	font1.setFontHeightInPoints((short)12);//设置字号 
       	font1.setItalic(false);//设置是否为斜体 
       	font1.setBold(true);//设置是否加粗 
       	font1.setColor(IndexedColors.BLACK.index);//设置字体颜色 
       	cellStyletime.setFont(font1);
	  	  
  	      HSSFRow row = sheet.createRow(0);
  	      HSSFCell cells = row.createCell(0);
		  HSSFRichTextString texts = new HSSFRichTextString("总览");
          //给单元格设置内容
          cells.setCellValue(texts);
          cellStyleb.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
          cellStyleb.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
          cells.setCellStyle(cellStyleb);
    	   row = sheet.createRow(1);
    	  for(int i = 0; i < headers.length; i++) {
    		  HSSFCell cell = row.createCell(i);
    		  HSSFRichTextString text = new HSSFRichTextString(headers[i]);
              //给单元格设置内容
              cell.setCellValue(text);
              cell.setCellStyle(cellStyletime);
    	  }
    	  row = sheet.createRow(2);
    	  for(int i = 0; i < headerse.length; i++) {
    		  HSSFCell cell = row.createCell(i);
    		  HSSFRichTextString text = new HSSFRichTextString(headerse[i]);
              //给单元格设置内容
              cell.setCellValue(text);
              cell.setCellStyle(cellStyletime);
    	  }
  		  //总览
    	  for (int b = 0; b < jiemian.size(); b++) {
    		  row = sheet.createRow(3+b);
    		  HSSFCell cell = row.createCell(b);
	    		  cell = row.createCell(0);//根据表格行创建单元格
	    		  HSSFRichTextString text0 = new HSSFRichTextString(deptname);
	              cell.setCellValue(text0);
	              cell.setCellStyle(cellStyle);
	              cell = row.createCell(1);//根据表格行创建单元格
	    		  HSSFRichTextString text = new HSSFRichTextString(jiemian.get(b).getArea_name());
	              cell.setCellValue(text);
	              cell.setCellStyle(cellStyle);
	              cell = row.createCell(2);//根据表格行创建单元格
	              HSSFRichTextString text1 = new HSSFRichTextString(jiemian.get(b).getJiemiani_biename());
	              cell.setCellValue(text1);
	              cell.setCellStyle(cellStyle);
	              cell = row.createCell(3);//根据表格行创建单元格
	              HSSFRichTextString text2 = new HSSFRichTextString(jiemian.get(b).getJiemiani_cheliang());
	              cell.setCellValue(text2);
	              cell.setCellStyle(cellStyle);
	              cell = row.createCell(4);//根据表格行创建单元格
	              HSSFRichTextString text3 = new HSSFRichTextString(jiemian.get(b).getJiemiani_renyuan());
	              cell.setCellValue(text3);
	              cell.setCellStyle(cellStyle);
	              cell = row.createCell(5);//根据表格行创建单元格
	    		  HSSFRichTextString zhi1 = new HSSFRichTextString(zhiban.get(b).getBanci_biename());
	              cell.setCellValue(zhi1);
	              cell.setCellStyle(cellStyle);
	              cell = row.createCell(6);//根据表格行创建单元格
	              HSSFRichTextString zhi2 = new HSSFRichTextString(zhiban.get(b).getBanci_renyuan());
	              cell.setCellValue(zhi2);
	              cell.setCellStyle(cellStyle);
	              cell = row.createCell(7);//根据表格行创建单元格
	              HSSFRichTextString jie1 = new HSSFRichTextString(jiechu.get(b).getJiechu_renyuan());
	              cell.setCellValue(jie1);
	              cell.setCellStyle(cellStyle);
	              cell = row.createCell(8);//根据表格行创建单元格
	              HSSFRichTextString jg1 = new HSSFRichTextString(jiguan.get(b).getJiguan_biename());
	              cell.setCellValue(jg1);
	              cell.setCellStyle(cellStyle);
	              cell = row.createCell(9);//根据表格行创建单元格
	              HSSFRichTextString jg2 = new HSSFRichTextString(jiguan.get(b).getJiguan_renyuan());
	              cell.setCellValue(jg2);
	              cell.setCellStyle(cellStyle);
	              cell = row.createCell(10);//根据表格行创建单元格
	              HSSFRichTextString lun1 = new HSSFRichTextString(lunxiu.get(b).getLun_biename());
	              cell.setCellValue(lun1);
	              cell.setCellStyle(cellStyle);
	              cell = row.createCell(11);//根据表格行创建单元格
	              HSSFRichTextString lun2 = new HSSFRichTextString(lunxiu.get(b).getLun_renyuan());
	              cell.setCellValue(lun2);
	              cell.setCellStyle(cellStyle);
		  }
    	  
    	    //街面勤务
    	    HSSFRow rowb = sheet.createRow(4+jiguan.size());
    	    HSSFCell cellss = rowb.createCell(0);
  		    HSSFRichTextString textp = new HSSFRichTextString("街面勤务");
            //给单元格设置内容
  		    cellss.setCellValue(textp);
            cellStyleb.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
            cellStyleb.setFillForegroundColor(IndexedColors.ROYAL_BLUE.index);
            cellss.setCellStyle(cellStyleb);
    	  /**
    	   * 获取数据
    	   */
            modelMap.put("report_type", 1);//街面勤务
            List<Gongen> x_jiemian=service.gongen(modelMap);
    		modelMap.put("report_type", 2);//值班值守
    		List<Gongen> x_zhiban=service.gongen(modelMap);
    	/*	Dutyleader 值班领导
    		Commander 指挥长
    		shiftforeman 值班长
    		Dutypolice 值班民警
    		Guardonduty 值班协警*/
    		for (Gongen gongen : x_zhiban) {
    			JSONArray dutypolice = JSONArray.fromObject(gongen.getPersonnel_list_str());//值班民警
    			for(int k=0;k<dutypolice.size();k++){
    				JSONObject json=dutypolice.getJSONObject(k);
    				JSONArray bsjson = JSONArray.fromObject(json.get("Dutyleader"));
    				if(!bsjson.toString().equals("[null]")) {
    				for(int d=0;d<bsjson.size();d++){
    					JSONObject js=bsjson.getJSONObject(d);
    					gongen.setZhibanlingdao(js.get("xm").toString());
    					gongen.setLianxiphone(js.get("yddh").toString());
    					
    				}
    				}
    				
    				JSONArray zhihuizhang = JSONArray.fromObject(json.get("Commander"));
    				if(!zhihuizhang.toString().equals("[null]")) {
    				for(int d=0;d<zhihuizhang.size();d++){
    					JSONObject js=zhihuizhang.getJSONObject(d);
    					gongen.setZhihuizhang(js.get("xm").toString());
    					
    				}
    				}
    			}
    		}
    		modelMap.put("x_zhiban", x_zhiban);
    		modelMap.put("report_type", 3);//接处警
    		List<Gongen> jiechujing=service.gongen(modelMap);
    		for (Gongen gongen2 : jiechujing) {
    			StringBuilder  sb = new StringBuilder();
    			JSONArray dutypolice = JSONArray.fromObject(gongen2.getPersonnel_list_str());//警员
    			for(int k=0;k<dutypolice.size();k++){
    				JSONObject json=dutypolice.getJSONObject(k);
    				JSONArray minjing = JSONArray.fromObject(json.get("minjing"));
    				if(!minjing.toString().equals("[null]")) {
    				for (int i = 0; i < minjing.size(); i++) {
    					JSONObject minjingjson=minjing.getJSONObject(i);
    					sb.append(minjingjson.get("xm").toString()+",");
    				}
    				}
    				JSONArray xiejing = JSONArray.fromObject(json.get("xiejing"));
    				if(!xiejing.toString().equals("[null]")) {
    				for (int i = 0; i < xiejing.size(); i++) {
    					JSONObject xiejingjson=xiejing.getJSONObject(i);
    					sb.append(xiejingjson.get("xm").toString()+",");
    				}
    				}
    			}
    			if(sb.length()!=0) {
    				gongen2.setRenyuan(sb.substring(0, sb.length()-1));
    			}else {
    				gongen2.setRenyuan("");
    			}
    			
    		}
    		modelMap.put("x_jiechujing", jiechujing);
    		modelMap.put("report_type", 4);//轮休
    		List<Gongen> go_lunxun=service.gongen(modelMap);
    		for (Gongen gongen : go_lunxun) {
    			StringBuilder  min = new StringBuilder();
    			StringBuilder  xie = new StringBuilder();
    			JSONArray dutypolice = JSONArray.fromObject(gongen.getPersonnel_list_str());//警员
    			for(int k=0;k<dutypolice.size();k++){
    				JSONObject json=dutypolice.getJSONObject(k);
    				JSONArray minjing = JSONArray.fromObject(json.get("minjing"));
    				if(!minjing.toString().equals("[null]")) {
    				for (int i = 0; i < minjing.size(); i++) {
    					JSONObject minjingjson=minjing.getJSONObject(i);
    					min.append(minjingjson.get("xm").toString()+",");
    				}
    				}
    				JSONArray xiejing = JSONArray.fromObject(json.get("xiejing"));
    				if(!xiejing.toString().equals("[null]")) {
    				for (int i = 0; i < xiejing.size(); i++) {
    					JSONObject xiejingjson=xiejing.getJSONObject(i);
    					xie.append(xiejingjson.get("xm").toString()+",");
    				}
    				}
    			}
    			if(min.length()!=0) {
    				gongen.setMinjing(min.substring(0, min.length()-1));
    			}else {
    				gongen.setRenyuan("");
    			}
    			if(xie.length()!=0) {
    				gongen.setXiejing(xie.substring(0, xie.length()-1));
    			}else {
    				gongen.setRenyuan("");
    			}
    		}
    		modelMap.put("x_lunxun", go_lunxun);
    		
    		modelMap.put("report_type", 5);//机关
    		List<Gongen> go_jiguan=service.gongen(modelMap);
    		for (Gongen gongen : go_jiguan) {
    			StringBuilder  min = new StringBuilder();
    			StringBuilder  xie = new StringBuilder();
    			JSONArray dutypolice = JSONArray.fromObject(gongen.getPersonnel_list_str());//警员
    			for(int k=0;k<dutypolice.size();k++){
    				JSONObject json=dutypolice.getJSONObject(k);
    				JSONArray minjing = JSONArray.fromObject(json.get("minjing"));
    				if(!minjing.toString().equals("[null]")) {
    				for (int i = 0; i < minjing.size(); i++) {
    					JSONObject minjingjson=minjing.getJSONObject(i);
    					min.append(minjingjson.get("xm").toString()+",");
    				}
    				}
    				JSONArray xiejing = JSONArray.fromObject(json.get("xiejing"));
    				if(!xiejing.toString().equals("[null]")) {
    				for (int i = 0; i < xiejing.size(); i++) {
    					JSONObject xiejingjson=xiejing.getJSONObject(i);
    					xie.append(xiejingjson.get("xm").toString()+",");
    				}
    				}
    			}
    			if(min.length()!=0) {
    				gongen.setMinjing(min.substring(0, min.length()-1));
    			}else {
    				gongen.setRenyuan("");
    			}
    			if(xie.length()!=0) {
    				gongen.setXiejing(xie.substring(0, xie.length()-1));
    			}else {
    				gongen.setRenyuan("");
    			}
    		}
    		modelMap.put("x_jiguan", go_jiguan);
            //结束
    	  
    	    	
    	    	  
    	  CellRangeAddress region1 = new CellRangeAddress(0,0,0,11 );
    	  CellRangeAddress region2 = new CellRangeAddress(1,2,0,0 );
    	  CellRangeAddress region3 = new CellRangeAddress(1,1,1,4 );
    	  CellRangeAddress region4 = new CellRangeAddress(1,1,5,6 );
    	  CellRangeAddress region5 = new CellRangeAddress(1,1,8,9 );
    	  CellRangeAddress region6 = new CellRangeAddress(1,1,10,11 );
    	 
    	  CellRangeAddress region8 = new CellRangeAddress(4+jiguan.size(),4+jiguan.size(),0,11 );
    		//巡控区域	巡控类型	班次	人员(总量)	车辆(总辆)
		  String[] jiemiandata = { "巡控区域","", "","巡控类型","","", "班次","", "人员(总量)","", "车辆(总辆)",""};
		   row = sheet.createRow(5+jiguan.size());
	    	  for(int i = 0; i < jiemiandata.length; i++) {
	    		  HSSFCell cell = row.createCell(i);
	    		  HSSFRichTextString text = new HSSFRichTextString(jiemiandata[i]);
	              //给单元格设置内容
	              cell.setCellValue(text);
	              cell.setCellStyle(cellStyletime);
	    	}
    	  CellRangeAddress region9 = new CellRangeAddress(5+jiguan.size(),5+jiguan.size(),0,2 );
    	  CellRangeAddress region10 = new CellRangeAddress(5+jiguan.size(),5+jiguan.size(),3,5 );
    	  CellRangeAddress region11 = new CellRangeAddress(5+jiguan.size(),5+jiguan.size(),6,7 );
    	  CellRangeAddress region12 = new CellRangeAddress(5+jiguan.size(),5+jiguan.size(),8,9 );
    	  CellRangeAddress region13 = new CellRangeAddress(5+jiguan.size(),5+jiguan.size(),10,11 );
    		sheet.addMergedRegion(region1);
    		sheet.addMergedRegion(region2);
    		sheet.addMergedRegion(region3);
    		sheet.addMergedRegion(region4);
    		sheet.addMergedRegion(region5);
    		sheet.addMergedRegion(region6);
    		// Merged region A4 must contain 2 or more cells   合并区域A4必须包含2个或更多个单元
    		if(3!=2+jiguan.size()) {
    			 CellRangeAddress region7 = new CellRangeAddress(3,2+jiguan.size(),0,0 );
    	    		sheet.addMergedRegion(region7);
    		}
    		sheet.addMergedRegion(region8);
    		sheet.addMergedRegion(region9);
    		sheet.addMergedRegion(region10);
    		sheet.addMergedRegion(region11);
    		sheet.addMergedRegion(region12);
    		sheet.addMergedRegion(region13);
    		sheet.setColumnWidth(0,20 * 256);
    		sheet.setColumnWidth(1,20 * 256);
    		sheet.setColumnWidth(2,20 * 256);
    		sheet.setColumnWidth(3,20 * 256);
    		sheet.setColumnWidth(4,20 * 256);
    		sheet.setColumnWidth(5,20 * 256);
    		sheet.setColumnWidth(6,20 * 256);
    		sheet.setColumnWidth(7,20 * 256);
    		sheet.setColumnWidth(8,20 * 256);
    		sheet.setColumnWidth(9,20 * 256);
    		sheet.setColumnWidth(10,20 * 256);
    		sheet.setColumnWidth(11,20 * 256);
    		/**
    		 * 街面勤务
    		 */
            for (int i = 0; i < x_jiemian.size(); i++) {
            	 row = sheet.createRow(6+i+jiguan.size());
       		      HSSFCell cell = row.createCell(0);
   	    		  cell = row.createCell(0);//根据表格行创建单元格
   	    		  HSSFRichTextString text0 = new HSSFRichTextString(x_jiemian.get(i).getName());//巡控区域
   	              cell.setCellValue(text0);
   	              cell.setCellStyle(cellStyle);
   	              cell = row.createCell(1);
   	              cell.setCellStyle(cellStyle);
   	              cell = row.createCell(2);
	              cell.setCellStyle(cellStyle);
	            
	              CellRangeAddress reg1 = new CellRangeAddress(6+i+jiguan.size(),6+i+jiguan.size(),0,2);
		      	 sheet.addMergedRegion(reg1);
	              cell = row.createCell(3);//巡控类型
   	    		  HSSFRichTextString text3 = new HSSFRichTextString(x_jiemian.get(i).getFangshi());//巡控类型
   	              cell.setCellValue(text3);
   	              cell.setCellStyle(cellStyle);
   	              cell = row.createCell(4);
	              cell.setCellStyle(cellStyle);
	              cell = row.createCell(5);
	              cell.setCellStyle(cellStyle);
	              CellRangeAddress reg2 = new CellRangeAddress(6+i+jiguan.size(),6+i+jiguan.size(),3,5);
			      	 sheet.addMergedRegion(reg2);
	              cell = row.createCell(6);//班次
   	    		  HSSFRichTextString text6 = new HSSFRichTextString(x_jiemian.get(i).getBancibiename());//班次
   	              cell.setCellValue(text6);
   	              cell.setCellStyle(cellStyle);
   	              cell = row.createCell(7);
	              cell.setCellStyle(cellStyle);
	              CellRangeAddress reg3 = new CellRangeAddress(6+i+jiguan.size(),6+i+jiguan.size(),6,7);
			      	 sheet.addMergedRegion(reg3);
	              cell = row.createCell(8);//人员(总量)
   	    		  HSSFRichTextString text8 = new HSSFRichTextString(x_jiemian.get(i).getRenzong().toString());//人员(总量)
   	              cell.setCellValue(text8);
   	              cell.setCellStyle(cellStyle);
   	              cell = row.createCell(9);
	              cell.setCellStyle(cellStyle);
	              CellRangeAddress reg4 = new CellRangeAddress(6+i+jiguan.size(),6+i+jiguan.size(),8,9);
			      	 sheet.addMergedRegion(reg4);
	              cell = row.createCell(10);//车辆(总辆)
   	    		  HSSFRichTextString text10 = new HSSFRichTextString(x_jiemian.get(i).getChezong().toString());//车辆(总辆)
   	              cell.setCellValue(text10);
   	              cell.setCellStyle(cellStyle);
   	              cell = row.createCell(11);
	              cell.setCellStyle(cellStyle);
	              CellRangeAddress reg5 = new CellRangeAddress(6+i+jiguan.size(),6+i+jiguan.size(),10,11);
			      	 sheet.addMergedRegion(reg5);
			}
            //值班值守
    	    HSSFRow rowzhiban = sheet.createRow(7+jiguan.size()+x_jiemian.size());
    	    HSSFCell cellzhiban = rowzhiban.createCell(0);
  		    HSSFRichTextString textzhiban = new HSSFRichTextString("值班值守");
            //给单元格设置内容
  		     cellzhiban.setCellValue(textzhiban);
            cellStyleb.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
            cellStyleb.setFillForegroundColor(IndexedColors.ROYAL_BLUE.index);
            cellzhiban.setCellStyle(cellStyleb);
	     //班次	值班领导	联系电话	指挥长	人员
            String[] zhibandata = { "班次","", "","值班领导","","", "联系电话","", "指挥长","", "人员",""};
          Integer zhibandatacount=8+jiguan.size()+x_jiemian.size();
 		   row = sheet.createRow(zhibandatacount);
 	    	  for(int i = 0; i < zhibandata.length; i++) {
 	    		  HSSFCell cell = row.createCell(i);
 	    		  HSSFRichTextString text = new HSSFRichTextString(zhibandata[i]);
 	              //给单元格设置内容
 	              cell.setCellValue(text);
 	              cell.setCellStyle(cellStyletime);
 	    	}
 	    	 CellRangeAddress zhi00 = new CellRangeAddress(7+jiguan.size()+x_jiemian.size(),7+jiguan.size()+x_jiemian.size(),0,11 );
 	    	  CellRangeAddress zhi0 = new CellRangeAddress(zhibandatacount,zhibandatacount,0,2 );
 	    	  CellRangeAddress zhi1 = new CellRangeAddress(zhibandatacount,zhibandatacount,3,5 );
 	    	  CellRangeAddress zhi2 = new CellRangeAddress(zhibandatacount,zhibandatacount,6,7 );
 	    	  CellRangeAddress zhi3 = new CellRangeAddress(zhibandatacount,zhibandatacount,8,9 );
 	    	  CellRangeAddress zhi4 = new CellRangeAddress(zhibandatacount,zhibandatacount,10,11 );
 	    	 sheet.addMergedRegion(zhi00);
 	    	 sheet.addMergedRegion(zhi0);
 	    	sheet.addMergedRegion(zhi1);
 	    	sheet.addMergedRegion(zhi2);
 	    	sheet.addMergedRegion(zhi3);
 	    	sheet.addMergedRegion(zhi4);
 	   		/**
    		 * 值班值守
    		 */
            for (int i = 0; i < x_zhiban.size(); i++) {
            	 row = sheet.createRow(zhibandatacount+1+i);
       		      HSSFCell cell = row.createCell(0);
   	    		  cell = row.createCell(0);//根据表格行创建单元格
   	    		  HSSFRichTextString text0 = new HSSFRichTextString(x_zhiban.get(i).getBancibiename());//班次
   	              cell.setCellValue(text0);
   	              cell.setCellStyle(cellStyle);
   	              cell = row.createCell(1);
   	              cell.setCellStyle(cellStyle);
   	              cell = row.createCell(2);
	              cell.setCellStyle(cellStyle);
	            
	              CellRangeAddress reg1 = new CellRangeAddress(zhibandatacount+1+i,zhibandatacount+1+i,0,2);
		      	 sheet.addMergedRegion(reg1);
	              cell = row.createCell(3);//巡控类型
   	    		  HSSFRichTextString text3 = new HSSFRichTextString(x_zhiban.get(i).getZhibanlingdao());//值班领导
   	              cell.setCellValue(text3);
   	              cell.setCellStyle(cellStyle);
   	              cell = row.createCell(4);
	              cell.setCellStyle(cellStyle);
	              cell = row.createCell(5);
	              cell.setCellStyle(cellStyle);
	              CellRangeAddress reg2 = new CellRangeAddress(zhibandatacount+1+i,zhibandatacount+1+i,3,5);
			      	 sheet.addMergedRegion(reg2);
	              cell = row.createCell(6);//班次
   	    		  HSSFRichTextString text6 = new HSSFRichTextString(x_zhiban.get(i).getLianxiphone().equals("null")?"无":x_zhiban.get(i).getLianxiphone());//联系电话
   	              cell.setCellValue(text6);
   	              cell.setCellStyle(cellStyle);
   	              cell = row.createCell(7);
	              cell.setCellStyle(cellStyle);
	              CellRangeAddress reg3 = new CellRangeAddress(zhibandatacount+1+i,zhibandatacount+1+i,6,7);
			      	 sheet.addMergedRegion(reg3);
	              cell = row.createCell(8);//人员(总量)
   	    		  HSSFRichTextString text8 = new HSSFRichTextString(x_zhiban.get(i).getZhihuizhang());//指挥长
   	              cell.setCellValue(text8);
   	              cell.setCellStyle(cellStyle);
   	              cell = row.createCell(9);
	              cell.setCellStyle(cellStyle);
	              CellRangeAddress reg4 = new CellRangeAddress(zhibandatacount+1+i,zhibandatacount+1+i,8,9);
			      	 sheet.addMergedRegion(reg4);
	              cell = row.createCell(10);//车辆(总辆)
   	    		  HSSFRichTextString text10 = new HSSFRichTextString(x_zhiban.get(i).getRenzong().toString());//人员
   	              cell.setCellValue(text10);
   	              cell.setCellStyle(cellStyle);
   	              cell = row.createCell(11);
	              cell.setCellStyle(cellStyle);
	              CellRangeAddress reg5 = new CellRangeAddress(zhibandatacount+1+i,zhibandatacount+1+i,10,11);
			      	 sheet.addMergedRegion(reg5);
			}
 	    	//接处警
            //值班值守
            Integer jiechucount=zhibandatacount+x_zhiban.size()+2;
            HSSFRow rowjiechu= sheet.createRow(jiechucount);
            for (int j = 0; j < 11; j++) {
            	HSSFCell cell = rowjiechu.createCell(j);
	            cell.setCellStyle(cellStyle);
			}
    	    HSSFCell celljiechu = rowjiechu.getCell(0);
  		    HSSFRichTextString textjiechu = new HSSFRichTextString("接处警");
            //给单元格设置内容
  		   celljiechu.setCellValue(textjiechu);
            cellStyleb.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
            cellStyleb.setFillForegroundColor(IndexedColors.ROYAL_BLUE.index);
            celljiechu.setCellStyle(cellStyleb);
            
            CellRangeAddress jiechu1 = new CellRangeAddress(jiechucount,jiechucount,0,11 );
	    	 sheet.addMergedRegion(jiechu1);
            //值班电话	人员
	    	jiechucount=zhibandatacount+x_zhiban.size()+3;
	    	   String[] jiechudata = { "值班电话","", "","","","", "人员","", "","", ""};
	  		   row = sheet.createRow(jiechucount);
	  	    	  for(int i = 0; i < jiechudata.length; i++) {
	  	    		  HSSFCell cell = row.createCell(i);
	  	    		  HSSFRichTextString text = new HSSFRichTextString(jiechudata[i]);
	  	              //给单元格设置内容
	  	              cell.setCellValue(text);
	  	              cell.setCellStyle(cellStyletime);
	  	    	}
	  	    	 CellRangeAddress jiadad1 = new CellRangeAddress(jiechucount,jiechucount,0,5 );
	 	    	 CellRangeAddress jiadad2 = new CellRangeAddress(jiechucount,jiechucount,6,11 );
	 	    	 sheet.addMergedRegion(jiadad1);
	 	    	 sheet.addMergedRegion(jiadad2);
	 	 		/**
	     		 * 接处警
	     		 */
	             for (int i = 0; i < jiechujing.size(); i++) {
	             	 row = sheet.createRow(jiechucount+1+i);
	        		      HSSFCell cell = row.createCell(0);
	    	    		  cell = row.createCell(0);//值班电话
	    	    		  HSSFRichTextString text0 = new HSSFRichTextString(jiechujing.get(i).getLianxiphone());//值班电话
	    	              cell.setCellValue(text0);
	    	              cell.setCellStyle(cellStyle);
	    	              cell = row.createCell(1);
	    	              cell.setCellStyle(cellStyle);
	    	              cell = row.createCell(2);
	 	                  cell.setCellStyle(cellStyle);
	 	                 cell = row.createCell(3);
	 	                  cell.setCellStyle(cellStyle);
	 	                 cell = row.createCell(4);
	 	                  cell.setCellStyle(cellStyle);
	 	                 cell = row.createCell(5);
	 	                  cell.setCellStyle(cellStyle);
	 	              CellRangeAddress reg1 = new CellRangeAddress(jiechucount+1+i,jiechucount+1+i,0,5);
	 		      	 sheet.addMergedRegion(reg1);
	 	              cell = row.createCell(6);//人员
	    	    		  HSSFRichTextString text6 = new HSSFRichTextString(jiechujing.get(i).getRenyuan());//人员
	    	              cell.setCellValue(text6);
	    	              cell.setCellStyle(cellStyle);
	    	              cell = row.createCell(7);
	 	              cell.setCellStyle(cellStyle);
	 	              cell = row.createCell(8);
	 	              cell.setCellStyle(cellStyle);
	 	             cell = row.createCell(9);
	 	              cell.setCellStyle(cellStyle);
	 	             cell = row.createCell(10);
	 	              cell.setCellStyle(cellStyle);
	 	             cell = row.createCell(11);
	 	              cell.setCellStyle(cellStyle);
	 	              CellRangeAddress reg2 = new CellRangeAddress(jiechucount+1+i,jiechucount+1+i,6,11);
	 			      	 sheet.addMergedRegion(reg2);
	 	           
	 			}
	             //机关工作
	             Integer jiguancount=jiechucount+jiechujing.size()+2;
	     	    HSSFRow rowjiguan= sheet.createRow(jiguancount);
	     	    HSSFCell celljiguan = rowjiguan.createCell(0);
	   		    HSSFRichTextString textjiguan = new HSSFRichTextString("机关工作");
	             //给单元格设置内容
	   		    celljiguan.setCellValue(textjiguan);
	             cellStyleb.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
	             cellStyleb.setFillForegroundColor(IndexedColors.ROYAL_BLUE.index);
	             celljiguan.setCellStyle(cellStyleb);
	             CellRangeAddress jieguan1 = new CellRangeAddress(jiguancount,jiguancount,0,11 );
	 	    	 sheet.addMergedRegion(jieguan1);
	 	    	 //机关工作
	 	    	//工作时间	民警  协警
	 	    	   String[] jiguandata = { "工作时间","", "民警","","","","", "协警","", "","", ""};
	 	    	  jiguancount=jiguancount+1;
	 	  		   row = sheet.createRow(jiguancount);
	 	  	    	  for(int i = 0; i < jiguandata.length; i++) {
	 	  	    		  HSSFCell cell = row.createCell(i);
	 	  	    		  HSSFRichTextString text = new HSSFRichTextString(jiguandata[i]);
	 	  	              //给单元格设置内容
	 	  	              cell.setCellValue(text);
	 	  	              cell.setCellStyle(cellStyletime);
	 	  	    	}
	 	  	    	 CellRangeAddress jiguandata1 = new CellRangeAddress(jiguancount,jiguancount,0,1 );
	 	 	    	 CellRangeAddress jiguandata2 = new CellRangeAddress(jiguancount,jiguancount,2,6 );
	 	 	    	 CellRangeAddress jiguandata3 = new CellRangeAddress(jiguancount,jiguancount,7,11 );
	 	 	    	 sheet.addMergedRegion(jiguandata1);
	 	 	    	 sheet.addMergedRegion(jiguandata2);
	 	 	    	 sheet.addMergedRegion(jiguandata3);
	 	 	    	jiguancount=jiguancount+1;
	 	 	   	/**
	 	     		 * 机关工作
	 	     		 */
	 	             for (int i = 0; i < go_jiguan.size(); i++) {
	 	             	 row = sheet.createRow(jiguancount+i);
	 	        		      HSSFCell cell = row.createCell(0);
	 	    	    		  cell = row.createCell(0);//工作时间
	 	    	    		  HSSFRichTextString text0 = new HSSFRichTextString(go_jiguan.get(i).getGongzuotime());//工作时间
	 	    	              cell.setCellValue(text0);
	 	    	              cell.setCellStyle(cellStyle);
	 	    	              cell = row.createCell(1);
	 	    	              cell.setCellStyle(cellStyle);
	 	 	                  CellRangeAddress reg1 = new CellRangeAddress(jiguancount+i,jiguancount+i,0,1);
	 	 		      	      sheet.addMergedRegion(reg1);
	 	 		      	 
	 	 	                  cell = row.createCell(2);//人员
	 	    	    		  HSSFRichTextString text2 = new HSSFRichTextString(go_jiguan.get(i).getMinjing());//民警
	 	    	              cell.setCellValue(text2);
	 	    	              cell.setCellStyle(cellStyle);
	 	    	              
	 	    	              cell = row.createCell(3);
	 	 	              cell.setCellStyle(cellStyle);
	 	 	              cell = row.createCell(4);
	 	 	              cell.setCellStyle(cellStyle);
	 	 	             cell = row.createCell(5);
	 	 	              cell.setCellStyle(cellStyle);
	 	 	             cell = row.createCell(6);
	 	 	              cell.setCellStyle(cellStyle);
	 	 	              CellRangeAddress reg6 = new CellRangeAddress(jiguancount+i,jiguancount+i,2,6);
	 	 	            sheet.addMergedRegion(reg6);
	 	 	            cell = row.createCell(7);//人员
	    	    		  HSSFRichTextString text7 = new HSSFRichTextString(go_jiguan.get(i).getMinjing());//民警
	    	              cell.setCellValue(text7);
	    	              cell.setCellStyle(cellStyle);
	    	              cell = row.createCell(8);
	 	              cell.setCellStyle(cellStyle);
	 	              cell = row.createCell(9);
	 	              cell.setCellStyle(cellStyle);
	 	             cell = row.createCell(10);
	 	              cell.setCellStyle(cellStyle);
	 	             cell = row.createCell(11);
	 	              cell.setCellStyle(cellStyle);
	 	              CellRangeAddress reg7 = new CellRangeAddress(jiguancount+i,jiguancount+i,7,11);
	 	 			   sheet.addMergedRegion(reg7);
	 	 			}
	 	           
	 	          //轮休备勤
		             Integer lunxuncount=jiguancount+go_jiguan.size()+1;
		     	    HSSFRow rowlunxun= sheet.createRow(lunxuncount);
		     	    HSSFCell celllunxun = rowlunxun.createCell(0);
		   		    HSSFRichTextString textlunxun = new HSSFRichTextString("轮休备勤");
		             //给单元格设置内容
		   		    celllunxun.setCellValue(textlunxun);
		             cellStyleb.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
		             cellStyleb.setFillForegroundColor(IndexedColors.ROYAL_BLUE.index);
		             celllunxun.setCellStyle(cellStyleb);
		             CellRangeAddress lunxun1 = new CellRangeAddress(lunxuncount,lunxuncount,0,11 );
		 	    	 sheet.addMergedRegion(lunxun1);
	 	             /**
	 	              * 轮休备勤
	 	              */
	 	            //String[] jiguandata = { "工作时间","", "民警","","","","", "协警","", "","", ""};
		 	    	lunxuncount=lunxuncount+1;
		 	  		   row = sheet.createRow(lunxuncount);
		 	  	    	  for(int i = 0; i < jiguandata.length; i++) {
		 	  	    		  HSSFCell cell = row.createCell(i);
		 	  	    		  HSSFRichTextString text = new HSSFRichTextString(jiguandata[i]);
		 	  	              //给单元格设置内容
		 	  	              cell.setCellValue(text);
		 	  	              cell.setCellStyle(cellStyletime);
		 	  	    	}
		 	  	    	 CellRangeAddress lu1 = new CellRangeAddress(lunxuncount,lunxuncount,0,1 );
		 	 	    	 CellRangeAddress lu2 = new CellRangeAddress(lunxuncount,lunxuncount,2,6 );
		 	 	    	 CellRangeAddress lu3 = new CellRangeAddress(lunxuncount,lunxuncount,7,11 );
		 	 	    	 sheet.addMergedRegion(lu1);
		 	 	    	 sheet.addMergedRegion(lu2);
		 	 	    	 sheet.addMergedRegion(lu3);
		 	 	    	lunxuncount=lunxuncount+1;
		 	 	      	/**
			 	     		 * 机关工作
			 	     		 */
			 	             for (int i = 0; i < go_lunxun.size(); i++) {
			 	             	 row = sheet.createRow(lunxuncount+i);
			 	        		      HSSFCell cell = row.createCell(0);
			 	    	    		  cell = row.createCell(0);//工作时间
			 	    	    		  HSSFRichTextString text0 = new HSSFRichTextString(go_lunxun.get(i).getGongzuotime());//工作时间
			 	    	              cell.setCellValue(text0);
			 	    	              cell.setCellStyle(cellStyle);
			 	    	              cell = row.createCell(1);
			 	    	              cell.setCellStyle(cellStyle);
			 	 	                  CellRangeAddress reg1 = new CellRangeAddress(lunxuncount+i,lunxuncount+i,0,1);
			 	 		      	      sheet.addMergedRegion(reg1);
			 	 		      	 
			 	 	                  cell = row.createCell(2);//人员
			 	    	    		  HSSFRichTextString text2 = new HSSFRichTextString(go_lunxun.get(i).getMinjing());//民警
			 	    	              cell.setCellValue(text2);
			 	    	              cell.setCellStyle(cellStyle);
			 	    	              
			 	    	              cell = row.createCell(3);
			 	 	              cell.setCellStyle(cellStyle);
			 	 	              cell = row.createCell(4);
			 	 	              cell.setCellStyle(cellStyle);
			 	 	             cell = row.createCell(5);
			 	 	              cell.setCellStyle(cellStyle);
			 	 	             cell = row.createCell(6);
			 	 	              cell.setCellStyle(cellStyle);
			 	 	              CellRangeAddress reg6 = new CellRangeAddress(lunxuncount+i,lunxuncount+i,2,6);
			 	 	            sheet.addMergedRegion(reg6);
			 	 	            cell = row.createCell(7);//人员
			    	    		  HSSFRichTextString text7 = new HSSFRichTextString(go_lunxun.get(i).getMinjing());//民警
			    	              cell.setCellValue(text7);
			    	              cell.setCellStyle(cellStyle);
			    	              cell = row.createCell(8);
			 	              cell.setCellStyle(cellStyle);
			 	              cell = row.createCell(9);
			 	              cell.setCellStyle(cellStyle);
			 	             cell = row.createCell(10);
			 	              cell.setCellStyle(cellStyle);
			 	             cell = row.createCell(11);
			 	              cell.setCellStyle(cellStyle);
			 	              CellRangeAddress reg7 = new CellRangeAddress(lunxuncount+i,lunxuncount+i,7,11);
			 	 			   sheet.addMergedRegion(reg7);
			 	 }
    	  wb.write(new FileOutputStream(savePath));
    	  wb.close();
	}
}
