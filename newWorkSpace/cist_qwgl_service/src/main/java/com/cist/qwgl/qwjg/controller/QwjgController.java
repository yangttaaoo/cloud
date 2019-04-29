package com.cist.qwgl.qwjg.controller;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.configUrl.model.FileUtil;
import com.cist.personalentry.service.PersonalEntryService;
import com.cist.qwgl.qwbb.model.Jcsj_police_res_person;
import com.cist.qwgl.qwbb.model.Qw_report;
import com.cist.qwgl.qwbb.model.Qw_report_car_patrol;
import com.cist.qwgl.qwbb.model.Qw_report_car_relation;
import com.cist.qwgl.qwbb.model.Qw_report_walk_relation;
import com.cist.qwgl.qwbb.model.Qwpbdata;
import com.cist.qwgl.qwbb.model.Syspoliceinfo;
import com.cist.qwgl.qwbb.service.QwbbService;
import com.cist.qwgl.qwjg.model.EventInfo;
import com.cist.qwgl.qwjg.model.GpsRecord;
import com.cist.qwgl.qwjg.model.Jcsj_police_resources;
import com.cist.qwgl.qwjg.model.Qw_individual_assessment;
import com.cist.qwgl.qwjg.model.Qw_patrol_alarm_log;
import com.cist.qwgl.qwjg.model.Qw_sign_in;
import com.cist.qwgl.qwjg.service.QwjgService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONArray;
@RestController
@RequestMapping("qwjk")
public class QwjgController {
	@Autowired
	private QwjgService service;
	@Autowired
	private QwbbService bbservice;
	@Autowired
	private PersonalEntryService personalentryservice;
	/***
	 * 上次文件信息  结果
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/avatarjie", method=RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void avatarjie( HttpServletResponse response,HashMap<String, Object> map,List<MultipartFile> file,String datainfo,String attachmentpk,HttpServletRequest request) throws Exception {
		    try {
		    	ObjectMapper objectMapper = new ObjectMapper();
		    	HashMap<String, Object> modelMap = new LinkedHashMap<String, Object>();
				HttpSession session = request.getSession();
				modelMap = objectMapper.readValue(datainfo, HashMap.class); // JSON转Map
				if(attachmentpk!=null&&!attachmentpk.equals("[]")) {
					 JSONArray array = JSONArray.fromObject(attachmentpk);
				        List array2 =(ArrayList)JSONArray.toCollection(array, HashMap.class);
					modelMap.put("pk_id", array2);
					service.deleteAttachment(modelMap);//删除附件信息
				}
				 Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
			 for (MultipartFile multipartFile : file) {
				 if (!multipartFile.isEmpty()){
					 System.err.println(multipartFile.getOriginalFilename());
					 String uploadService = FileUtil.FileUploadService(multipartFile);
					 System.err.println(uploadService);
					 int index = multipartFile.getOriginalFilename().lastIndexOf(".");
					 String	suffix=multipartFile.getOriginalFilename().substring(index+1, multipartFile.getOriginalFilename().length());
					 modelMap.put("fk_relation_id", modelMap.get("dualassessmentpk"));//关联ID
					 modelMap.put("attachment_name", multipartFile.getOriginalFilename());//附件名称
					 modelMap.put("attachment_suffix", suffix);//
					 modelMap.put("attachment_size", multipartFile.getSize());
					 modelMap.put("fk_commit_person_id",userMap.get("sypi_pk").toString());
					 modelMap.put("attachment_source",uploadService);
					 service.addattachment(modelMap);
			 }
			 }
			 modelMap.put("fk_verify_person_id",userMap.get("sypi_pk").toString());
			 service.updateassessment(modelMap);//更新个人考核
			 response.setHeader("Content-type","text/html;charset=UTF-8"); 
			 String data = "1";  
			 OutputStream stream = response.getOutputStream();  
			 stream.write(data.getBytes("UTF-8"));  
			} catch (Exception e) {
				System.err.println(e.getMessage());
				response.setHeader("Content-type","text/html;charset=UTF-8"); 
				 String data = "2";  
				 OutputStream stream = response.getOutputStream();  
				 stream.write(data.getBytes("UTF-8"));  
			}
	}
	/***
	 * 查询执勤任务列表
	 * @param modelMap
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping("qwreport")
	public HashMap<String,Object> fctlist(@RequestBody HashMap<String,Object> modelMap ) throws IllegalAccessException, InvocationTargetException{
		List<Qw_report> list=	service.selectQw_report(modelMap);
	
		//当前勤务所有的警员信息
		List<String> listjy=new ArrayList<String>();
		//当前勤务所有的警车信息
		List<String> listjc=new ArrayList<String>();
		for (Qw_report qw_report : list) {
			modelMap.put("pk_id",qw_report.getPk_id());//勤务报备id 
			modelMap.put("fk_report_id",qw_report.getPk_id());//勤务报备id 
			List<Qw_report_walk_relation> relation=qw_report.getQw_report_walk_relation();
			for (Qw_report_walk_relation qw_report_walk_relation : relation) {//步行人员
				Jcsj_police_res_person syspoliceinfo=qw_report_walk_relation.getSyspoliceinfo();
				listjy.add(syspoliceinfo.getRybh());
				modelMap.put("fk_sign_in_user_id", syspoliceinfo.getId());
				modelMap.put("rybh", syspoliceinfo.getRybh());
				String name=syspoliceinfo.getXm()+"（"+syspoliceinfo.getRybh()+"）";
				modelMap.put("zqr",name);
				qw_report_walk_relation.getSyspoliceinfo().setQw_patrol_alarm_log(service.qw_patrol_alarm_log(modelMap));//9.43. 街面勤务异常日志
				modelMap.put("sign_in_type",1);
				qw_report_walk_relation.getSyspoliceinfo().setQw_sign_in(service.sign(modelMap));//签到
				modelMap.put("sign_in_type",2);
				qw_report_walk_relation.getSyspoliceinfo().setQw_sign_intui(service.sign(modelMap));//签退
				qw_report_walk_relation.getSyspoliceinfo().setBeiqiang(service.qiangziqungwu(modelMap));//查询是否配枪
			}
			List<Qw_report_car_patrol> 	patrol=qw_report.getQw_report_car_patrol();
			for (Qw_report_car_patrol qw_report_car_patrol : patrol) {//警车人员
				listjc.add(qw_report_car_patrol.getJcsjpoliceresources().getCar_num());//车牌号码
				List<Qw_report_car_relation> carrelatio=qw_report_car_patrol.getQw_report_car_relation();
				for (Qw_report_car_relation qw_report_car_relation : carrelatio) {
					Jcsj_police_res_person person=qw_report_car_relation.getSyspoliceinfo();
					listjy.add(person.getRybh());
					modelMap.put("fk_sign_in_user_id", person.getId());
					modelMap.put("rybh", person.getRybh());
					String name=person.getXm()+"（"+person.getRybh()+"）";
					modelMap.put("zqr",name);
					qw_report_car_relation.getSyspoliceinfo().setQw_patrol_alarm_log(service.qw_patrol_alarm_log(modelMap));//9.43. 街面勤务异常日志
					modelMap.put("sign_in_type",1);
					qw_report_car_relation.getSyspoliceinfo().setQw_sign_in(service.sign(modelMap));//签到
					modelMap.put("sign_in_type",2);
					qw_report_car_relation.getSyspoliceinfo().setQw_sign_intui(service.sign(modelMap));//签退
					qw_report_car_relation.getSyspoliceinfo().setBeiqiang(service.qiangziqungwu(modelMap));//查询是否配枪
				}
			}
		}
		modelMap.put("listjc", listjc);
		modelMap.put("resources",service.jcsj_police_resources(modelMap));//车辆信息
		modelMap.put("listjy", listjy);
		modelMap.put("jygpsdata",service.jcsjpolicerespersoninfo(modelMap));//人员信息
		modelMap.put("list", list);
		modelMap.put("rybhdata", listjy);
		Double jy=0.0;
		if(listjy.size()!=0) {
			 jy=Double.valueOf(service.jczzxl(modelMap));
		}
		modelMap.put("jinnfyuanz", listjy.size());
		modelMap.put("jinnfyuanl", jy);
		Double jylv=(double) (jy/Double.valueOf(listjy.size())*100);
		modelMap.put("rybhdata", listjc);
		Double jc=0.0;
		if(listjc.size()!=0) {
			 jc=Double.valueOf(service.jczzxl(modelMap));
		}
		modelMap.put("jinnfchez", listjc.size());
		modelMap.put("jinnfchel", jc);
		Double jclv=(double) (jc/Double.valueOf(listjc.size())*100);
		if (Double.isInfinite(jylv) || Double.isNaN(jylv)){
			jylv=0.0;
		}
		if (Double.isInfinite(jclv) || Double.isNaN(jclv)){
			jclv=0.0;
		}
		modelMap.put("jylv", new BigDecimal(jylv).setScale(0, RoundingMode.HALF_DOWN).doubleValue());
		modelMap.put("jclv", new BigDecimal(jclv).setScale(0, RoundingMode.HALF_DOWN).doubleValue());
		modelMap.put("jylv_l", new BigDecimal(100-jylv).setScale(0, RoundingMode.HALF_DOWN).doubleValue());
		modelMap.put("jclv_l", new BigDecimal(100-jclv).setScale(0, RoundingMode.HALF_DOWN).doubleValue());
		 return modelMap;
	}
	/**
	 * 当前勤务人员街面勤务异常日志 分页数据
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("querylist")
	public PageInfo<Qw_patrol_alarm_log> querylist(@RequestBody HashMap<String,Object> modelMap ){
		Integer pageSize= Integer.parseInt(modelMap.get("pageSize").toString());//每页有显示多少条
		//获取分页数据位置,每页显示16条数据
 		PageHelper.startPage(Integer.valueOf(modelMap.get("currentPage").toString()),pageSize, true);
		List<Qw_patrol_alarm_log> list= service.alarmlogList(modelMap);
		PageInfo<Qw_patrol_alarm_log> pageinfo=new PageInfo<Qw_patrol_alarm_log>(list,5);
	    List<Qw_patrol_alarm_log> qwpatrol=	pageinfo.getList();
	    for (Qw_patrol_alarm_log qw_patrol_alarm_log : qwpatrol) {
	    	modelMap.put("yjkssj", qw_patrol_alarm_log.getYjkssj());
	    	modelMap.put("yjjssj", qw_patrol_alarm_log.getYjjssj());
	    	qw_patrol_alarm_log.setFk_event_id(service.eventid(modelMap));//是否有接处警
	    	if(qw_patrol_alarm_log.getFk_event_id()!=null) {
	    		modelMap.put("pk_id", qw_patrol_alarm_log.getFk_event_id());
		    	qw_patrol_alarm_log.setEventinfo(service.eventlist(modelMap));
	    	}
		}
		
		return pageinfo;
	}
	/***
	 * 350M在线数据   监控设备
	 * @param map
	 * @return
	 */
	@RequestMapping("gpsrecord")
	public HashMap<String, Object> gpsrecord(@RequestBody HashMap<String, Object> map){
	    List<GpsRecord>	gpsrecord=service.gpsrecord(map);
		Integer all= service.gpsrecordlixian(map);
		//	在线率    离线/总数*100
		Double gpslv=(double) (Double.valueOf(gpsrecord.size())/Double.valueOf(all)*100);
		map.put("gpslv", new BigDecimal(gpslv).setScale(0, RoundingMode.HALF_DOWN).doubleValue());
		map.put("gpslv_l", new BigDecimal(100-gpslv).setScale(0, RoundingMode.HALF_DOWN).doubleValue());
		map.put("gpsrecord", gpsrecord);
		map.put("deviceList", service.deviceList(map));// 监控设备
		map.put("gpsrecordlixian", all);//在线
		map.put("gpsrecordl", gpsrecord.size());//离线
		return map;
	}
	/***
	 * 历史gps数据
	 * @param map
	 * @return
	 */
	@RequestMapping("qwgpshistory")
	public HashMap<String, Object> qw_gps_history(@RequestBody HashMap<String, Object> map){
		map.put("history", service.qw_gps_history(map));
		return map;
	}
	/***
	 * 一键解除报警
	 * @param map
	 * @return
	 */
	@RequestMapping("releasealarm")
	public HashMap<String, Object> releasealarm(@RequestBody HashMap<String, Object> map){
		service.delyichang(map);//一键解除报警 删除所有异常数据
		if(map.get("fkreport")!=null&&!map.equals("[]")) {
			 JSONArray array = JSONArray.fromObject(map.get("fkreport"));
		        List array2 =(ArrayList)JSONArray.toCollection(array, HashMap.class);
		        map.put("fkreport", array2);
		        if(array2.size()>0) {
		        	service.delkaohe(map);//一键解除报警 删除这段时间内 考核数据
		        }
		        
		}
		return map;
	}
	/***
	 * 获取基础信息
	 * @param map
	 * @return
	 */
	@RequestMapping("jichuxiinxi")
	public HashMap<String, Object> jichuxiinxi(@RequestBody HashMap<String, Object> map){
		map.put("fct_code", "QW06");
		map.put("qukh", service.sysfrmcode(map));
		//考核栏目
		map.put("qwjm",personalentryservice.AppraiseList());
		//考核条例
		map.put("tionsList",personalentryservice.RegulationsList(map));
	
		return map;
	}
	
	/***
	 * 获取基础信息
	 * @param map
	 * @return
	 */
	@RequestMapping("sysfrmcode")
	public HashMap<String, Object> sysfrmcode(@RequestBody HashMap<String, Object> map){
		map.put("fct_code","FW01");//公里范围
		map.put("fanweigls", service.sysfrmcode(map));
		map.put("fct_code","SJYX");//事件类型
		map.put("frmcodesjlx", service.sysfrmcode(map));
		return map;
	}
	/***
	 * 个人考核信息
	 * @param map
	 * @return
	 */
	@RequestMapping("dualassessment")
	public HashMap<String, Object> dualassessment(@RequestBody HashMap<String, Object> map){
		Qw_individual_assessment  qw_individual_assessment =service.qwindividualassessment(map);

		map.put("dualassessment", qw_individual_assessment);
		if(null!=qw_individual_assessment) {
			map.put("fk_relation_id", qw_individual_assessment.getPk_id());
			map.put("attachment",service.getAttachment(map));
		}
		
		return map;
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
			Qwpbdata data=service.eventinfobumen(modelMap);
			if(null!=data) {
				qwpbdata.setFujingcount(data.getFujingcount());
				qwpbdata.setZongshu(data.getZongshu());
				qwpbdata.setMingjingcount(data.getMingjingcount());
			}
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
	 * 预警信息
	 * @param modelMap
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("yujing")
	public HashMap<String,Object> yujing(@RequestBody HashMap<String,Object> modelMap ) throws IllegalAccessException, InvocationTargetException{
		List<Qw_patrol_alarm_log> qwpatrol=service.qwpatrolalarmyujing(modelMap);
		   for (Qw_patrol_alarm_log qw_patrol_alarm_log : qwpatrol) {
		    	modelMap.put("yjkssj", qw_patrol_alarm_log.getYjkssj());
		    	modelMap.put("yjjssj", qw_patrol_alarm_log.getYjjssj());
		    	modelMap.put("zqr", qw_patrol_alarm_log.getZqr());
		    	qw_patrol_alarm_log.setFk_event_id(service.eventid(modelMap));//是否有接处警
		    	if(qw_patrol_alarm_log.getFk_event_id()!=null) {
		    		modelMap.put("pk_id", qw_patrol_alarm_log.getFk_event_id());
			    	qw_patrol_alarm_log.setEventinfo(service.eventlist(modelMap));
		    	}
			}
		   modelMap.put("yujing",qwpatrol);
		return modelMap;
	}
	/***
	 * 警车警员历史数据
	 * @param modelMap
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("qwgpshistoryywbh")
	public HashMap<String,Object> qwgpshistoryywbh(@RequestBody HashMap<String,Object> modelMap ) throws IllegalAccessException, InvocationTargetException{
		modelMap.put("qwgpshistor", service.qwgpshistoryywbh(modelMap));
		modelMap.put("buxing", service.onduty(modelMap));//勤务报备步行人员
		modelMap.put("chexing", service.ondutyche(modelMap));//勤务报备车行人员
		modelMap.put("ondutydiaodu", service.ondutydiaodu(modelMap));//122
		
		modelMap.put("ondutyjcbk", service.ondutyjcbk(modelMap));//稽查布控
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
