package com.cist.home.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cist.configUrl.model.FileUtil;
import com.cist.home.model.DeviceInfo;
import com.cist.home.model.EventFlowInfo;
import com.cist.home.model.EventInfo;
import com.cist.home.model.GpsRecord;
import com.cist.home.model.Jcsj_police_res_person;
import com.cist.home.model.Jcsj_police_resources;
import com.cist.home.model.PoliceInfo;
import com.cist.home.model.Tbl_car_reco;
import com.cist.home.model.Zhdd_event_acceptance;
import com.cist.home.model.Zhdd_event_attachment;
import com.cist.home.model.Zhdd_event_personnel;
import com.cist.home.model.Zhdd_event_result;
import com.cist.home.model.Zhdd_sms_template;
import com.cist.home.model.Zhdd_work_flow;
import com.cist.home.service.HomeService;
import com.cist.utils.SnowflakeIdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONArray;


/***
 * 
 * @Title:  PersonalEntryController.java   
 * @Package com.cist.personalentry.controller
 * @Description:    指挥调度主页面
 * @author: 王涛
 * @date:   2018年12月04日 上午11:01:00 
 * @version V1.0
 */
@RestController
@RequestMapping("/homecommand")
public class HomeController {
	
	@Autowired
	private HomeService service;
	/***
	 * 上次文件信息  结果
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/avatarjie", method=RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void avatarjie( HttpServletResponse response,HashMap<String, Object> map,List<MultipartFile> file,String weizhi,String fangui,String pk_id,String attachmentpk,String fankuipk,HttpServletRequest request) throws Exception {
		    try {
		    	HashMap<String, Object> modelMap = new LinkedHashMap<String, Object>();
				HttpSession session = request.getSession();
				Zhdd_event_attachment zhdd_event_attachment=new Zhdd_event_attachment();
				 String liuc=SnowflakeIdWorker.getUUID();//流程唯一id
				if(attachmentpk!=null&&!attachmentpk.equals("[]")) {
					 JSONArray array = JSONArray.fromObject(attachmentpk);
				        List array2 =(ArrayList)JSONArray.toCollection(array, HashMap.class);
					modelMap.put("attachmentpk", array2);
					service.delattachment(modelMap);//删除附件信息
				}

			 for (MultipartFile multipartFile : file) {
				 if (!multipartFile.isEmpty()){
					 System.err.println(multipartFile.getOriginalFilename());
					
					 String uploadService = FileUtil.FileUploadService(multipartFile);
					 System.err.println(uploadService);
					 int index = multipartFile.getOriginalFilename().lastIndexOf(".");
					 String a=SnowflakeIdWorker.getUUID();
					 String	suffix=multipartFile.getOriginalFilename().substring(index+1, multipartFile.getOriginalFilename().length());
					 zhdd_event_attachment.setAttachment_name(multipartFile.getOriginalFilename());//附件名称
					 zhdd_event_attachment.setAttachment_suffix(suffix);//附件后缀名
					 zhdd_event_attachment.setAttachment_size(String.valueOf(multipartFile.getSize()));//附件大小
					 zhdd_event_attachment.setAttachment_source(uploadService);//附件路径
					 zhdd_event_attachment.setRemarks("122调度岗返回结果操作");
					 if(fankuipk==null||fankuipk.equals("")) {
						 zhdd_event_attachment.setFk_event_id(liuc);//事件ID  原来是事件id  现在分流程  结果  事件  id
					 }else {
						 zhdd_event_attachment.setFk_event_id(fankuipk);//事件ID  原来是事件id  现在分流程  结果  事件  id
					 }
					
					 zhdd_event_attachment.setPk_id(a);
					 service.addattachment(zhdd_event_attachment);//新增事件附件
				 }
			 }
			 Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
			 Zhdd_event_result eventflowinfo=new Zhdd_event_result();
			 eventflowinfo.setProcessing_results(fangui);//反馈信息
			 eventflowinfo.setFk_event_id(pk_id);//当前事件id
			 eventflowinfo.setFk_submitter_id(Integer.valueOf(userMap.get("sypi_pk").toString()));//操作人id
			 if(fankuipk==null||fankuipk.equals("")) {//当前事件没有流程  新增
				 eventflowinfo.setPk_id(liuc);//流程id
				   service.addzhddeventresult(eventflowinfo);
			 }else {
				 eventflowinfo.setPk_id(fankuipk);//流程id
				  service.updatezhddeventresult(eventflowinfo);
			 }
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
	 * 上次文件信息  反馈信息
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@RequestMapping(value="/avatar", method=RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void avatar( HttpServletResponse response,HashMap<String, Object> map,List<MultipartFile> file,String weizhi,String fangui,String pk_id,String attachmentpk,String fankuipk,HttpServletRequest request) throws IOException {
		try {
		    HashMap<String, Object> modelMap = new LinkedHashMap<String, Object>();
					HttpSession session = request.getSession();
					Zhdd_event_attachment zhdd_event_attachment=new Zhdd_event_attachment();
					 String liuc=System.currentTimeMillis()+""+(int)(Math.random() * 99999);//流程唯一id
					if(attachmentpk!=null&&!attachmentpk.equals("[]")) {
						 JSONArray array = JSONArray.fromObject(attachmentpk);
					        List array2 =(ArrayList)JSONArray.toCollection(array, HashMap.class);
						modelMap.put("attachmentpk", array2);
						service.delattachment(modelMap);//删除附件信息
					}

				 for (MultipartFile multipartFile : file) {
					 if (!multipartFile.isEmpty()){
						 System.err.println(multipartFile.getOriginalFilename());
						 String uploadService = FileUtil.FileUploadService(multipartFile);
						 System.err.println(uploadService);
						 int index = multipartFile.getOriginalFilename().lastIndexOf(".");
						 String a=System.currentTimeMillis()+""+(int)(Math.random() * 99999);
						 String	suffix=multipartFile.getOriginalFilename().substring(index+1, multipartFile.getOriginalFilename().length());
						 zhdd_event_attachment.setAttachment_name(multipartFile.getOriginalFilename());//附件名称
						 zhdd_event_attachment.setAttachment_suffix(suffix);//附件后缀名
						 zhdd_event_attachment.setAttachment_size(String.valueOf(multipartFile.getSize()));//附件大小
						 zhdd_event_attachment.setAttachment_source(uploadService);//附件路径
						 zhdd_event_attachment.setRemarks("122调度岗反馈操作");
						 if(fankuipk==null||fankuipk.equals("")) {
							 zhdd_event_attachment.setFk_event_id(liuc);//事件ID  原来是事件id  现在分流程  结果  事件  id
						 }else {
							 zhdd_event_attachment.setFk_event_id(fankuipk);//事件ID  原来是事件id  现在分流程  结果  事件  id
						 }
						
						 zhdd_event_attachment.setPk_id(a);
						 service.addattachment(zhdd_event_attachment);//新增事件附件
					 }
				 }
				 Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
				 EventFlowInfo eventflowinfo=new EventFlowInfo();
				 eventflowinfo.setFeedback_contents(fangui);//反馈信息
				 eventflowinfo.setFk_event_id(pk_id);//当前事件id
				 eventflowinfo.setWork_flow_name("反馈信息");
				 eventflowinfo.setFk_complete_person_id(Integer.valueOf(userMap.get("sypi_pk").toString()));//操作人id
				 if(fankuipk==null||fankuipk.equals("")) {//当前事件没有流程  新增
					 eventflowinfo.setPk_id(liuc);//流程id
					   service.addEventFlowInfo(eventflowinfo);
				 }else {
					 eventflowinfo.setPk_id(fankuipk);//流程id
					  service.updateEventFlowInfo(eventflowinfo);
				 }
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
	
	/**
	 * 设备列表查询
	 * @param map
	 */
	@RequestMapping("devicelist")
	public HashMap<String, Object>  DeviceList(@RequestBody HashMap<String, Object> map){			
		List<DeviceInfo> Appraiselist = service.DeviceList();
		List<GpsRecord> gpsRecordList = service.gpsRecordList(map);
		map.put("Appraiselist", Appraiselist);//设备
		map.put("gpsRecordList", gpsRecordList);//警员警车信息
		map.put("zzclsjjy", service.zzclsjjy(map));//正在处理事件的警员
		return map;
	}
	/***
	 * 获取警员信息
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("personpageliist")
	public PageInfo<Jcsj_police_res_person> personpageliist(@RequestBody HashMap<String,Object> modelMap) throws Exception{
			Integer pageSize= Integer.parseInt(modelMap.get("pageSize").toString());//每页有显示多少条
			//获取分页数据位置,每页显示16条数据
	 		PageHelper.startPage(Integer.valueOf(modelMap.get("currentPage").toString()),pageSize, true);
			List<Jcsj_police_res_person> list= service.jcsj_police_res_personpageliist(modelMap);
			PageInfo<Jcsj_police_res_person> pageinfo=new PageInfo<Jcsj_police_res_person>(list,5);
		return pageinfo;
	}
	/***
	 * 更新122事件经纬度
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updatejwd")
	public Integer updatejwd(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		return service.updatejwd(modelMap);
	}
	
	/***
	 * 工作流程
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("workflow")
	public List<Zhdd_work_flow> workflow(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		List<Zhdd_work_flow> list= service.zhdd_work_flow(modelMap);
		return list;
	}
	/***
	 * 查询短信模板
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("smstemplate")
	public List<Zhdd_sms_template> smstemplate(@RequestBody HashMap<String,Object> modelMap) throws Exception{
		List<Zhdd_sms_template> list= service.zhdd_sms_template(modelMap);
		return list;
	}
	
	/**
	 * 警员警车信息
	 * @param map
	 */
	@RequestMapping("gpsRecordList")
	public List<GpsRecord>  gpsRecordList(@RequestBody HashMap<String, Object> map){			
		List<GpsRecord> gpsRecordList = service.gpsRecordList(map);
		return gpsRecordList;
	}
	/**
	 * 5.23. 警务资源信息 设备编号
	 * @param map
	 */
	@RequestMapping("jcsjpolice")
	public Jcsj_police_resources  jcsjpolice_resperson(@RequestBody HashMap<String, Object> map){	
		return service.jcsjpolice_resperson(map);
	}
	/**
	 * 5.23.查询警员信息
	 * @param map
	 */
	@RequestMapping("jcsjpoliceresperson")
	public Jcsj_police_res_person  jcsjpoliceresperson(@RequestBody HashMap<String, Object> map){	
		return service.Jcsjpoliceresperson(map);
	}
	/**
	 * 5.23.卡口数据
	 * @param map
	 */
	@RequestMapping("tblcarreco")
	public Tbl_car_reco  tbl_car_reco(@RequestBody HashMap<String, Object> map){	
		return service.tbl_car_reco(map);
	}
	/***
	 * 部门pk获取所有下级部门
	 * @param map
	 * @return
	 */
	public List<Integer>  getsuqok(HashMap<String, Object> map){
		List<Integer> list=service.shangjibumenpk(map);
		
		if(list.size()!=0) {
			return	getdigui(list);
		}
		return null;
	}
	public List<Integer>  getdigui(List<Integer> list){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("bumenpk", list);
		List<Integer> listdigui=service.shangjibumenpk(map);
		if(listdigui.size()!=0) {
			list.addAll(listdigui);
			getdigui(listdigui);
		}
		return list;
	}
	/**
	 * 事件查询
	 * @param map
	 */
	@RequestMapping("eventinfo")
	public HashMap<String, Object>   EventList(@RequestBody HashMap<String, Object> map,HttpServletRequest request){	
			HttpSession session = request.getSession();
			Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());//操作人单位ID
			 List<Integer> listhahah=new ArrayList<Integer>();
			if(map.get("bumenpk")!=null&&!map.get("bumenpk").toString().equals("[]")) {
				 listhahah=getsuqok(map);
				 Collection<Integer> valueCollection = (Collection<Integer>) map.get("bumenpk");
				 List<Integer> valueList = new ArrayList<Integer>(valueCollection);
				 if(listhahah==null) {
					 listhahah=new ArrayList<Integer>();
					 listhahah.addAll(valueList);
				 }else {
					 listhahah.addAll(valueList);
				 }
				
			}
		map.put("bumenfkdeptid", listhahah);
		List<EventInfo> eventlist1 =service.EventList(map);//接警
		List<EventInfo> eventlist2 =service.EventListchu(map);//出警
		List<EventInfo> eventlist3 =service.EventListchuu(map);//处警
		List<EventInfo> eventlist4 =service.EventListquan(map);//全部
		if(userMap.get("sypi_dept_pk").equals("1")) {//指挥长
		    List<Integer> list=	service.xiafashijian(map);
		    for (EventInfo info : eventlist4) {
				      for (Integer data : list) {
				    	  if(info.getPk_id().equals(data)) {
				    		  info.setXiafa(2);
					      }
					}
			}
		}
		map.put("eventlist4", eventlist4);
		map.put("eventlist3", eventlist3);
		map.put("eventlist2", eventlist2);
		map.put("eventlist1", eventlist1);
	
		return map;
	}
	@RequestMapping("addzhddeventacceptance")
	public Integer  addzhddeventacceptance(@RequestBody HashMap<String, Object> map,HttpServletRequest request){	
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		map.put("fk_acceptance_dept_id", userMap.get("sypi_dept_pk"));//操作人单位ID
		 map.put("fk_acceptance_person_id", userMap.get("sypi_pk"));//操作人ID
		//添加受理信息
		service.addzhddeventacceptance(map);
		return service.updatezhddeventinformation(map);
	}
	
	/**
	 * 警员信息查询
	 * @param map
	 */
	@RequestMapping("policeinfo")
	public Jcsj_police_res_person PoliceList(@RequestBody HashMap<String, Object> map){			
		Jcsj_police_res_person policelist = service.PoliceList(map);
		return policelist;
	}
	/**
	 * 警员任务信息查询
	 * @param map
	 */
	@RequestMapping("eventpoliceinfo")
	public List<EventInfo> EventPoliceList(@RequestBody HashMap<String, Object> map){			
		List<EventInfo> policelist = service.EventPoliceList(map);
		return policelist;
	}
	/**
	 * 单条任务详情信息查询
	 * @param map
	 */
	@RequestMapping("eventflowinfo")
	public EventInfo EventFlowList(@RequestBody HashMap<String, Object> map){			
		EventInfo eventlist = service.EventFlowList(map);
		return eventlist;
	}
	/**
	 * 单条任务流程详情信息查询
	 * @param map
	 */
	@RequestMapping("eventresultinfo")
	public List<EventFlowInfo> EventResultList(@RequestBody HashMap<String, Object> map){			
		List<EventFlowInfo> eventlist = service.EventResultList(map);
		return eventlist;
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
		map.put("fct_code","SJLX");//事件类型
		map.put("frmcodesjlx", service.sysfrmcode(map));
		return map;
	}

	/***
	 * 根据警员编号查询事件
	 * @param map
	 * @return
	 */
	@RequestMapping("eventinfojy")
	public EventInfo eventinfojy(@RequestBody HashMap<String, Object> map){	
		return service.eventinfojy(map);
	}
	/**
	 * 获取事件信息
	 * @param map
	 * @return
	 */
	@RequestMapping("acceptance")
	public EventInfo acceptance(@RequestBody HashMap<String, Object> map){	
		return service.acceptance(map);
	}
	
	/**
	 * 事件流程
	 * @param map
	 */
	@RequestMapping("shijianlc")
	public HashMap<String, Object> shijianlc(@RequestBody HashMap<String, Object> map){	
		
		if(map.get("rybh")==null) {
			map.put("shhoulixishij", service.shhoulixishij(map));//接到报警  事件表
			map.put("shhoulixi", service.shhoulixi(map));//受理信息表
			
			Zhdd_event_result eventresult=service.eventresult(map);
			map.put("eventresult", eventresult);//事件成功返回结果
			
			map.put("eventflowinfolist", service.eventflowinfolist(map));//4.9. 事件处置流程
			
			
			EventFlowInfo eventflowinfo=service.eventflowinfov(map);
			map.put("fankui", eventflowinfo);//反馈
			if(eventflowinfo!=null) {
				map.put("pk_id",eventflowinfo.getPk_id());//反馈的附件信息
				map.put("tupian", service.selectattachment(map));//图片
				map.put("yinpin", service.selectyinpin(map));//音频
			}
		
			
			if(eventresult!=null) {
				map.put("pk_id",eventresult.getPk_id());//返回结果的附件信息
				map.put("jietupian", service.selectattachment(map));//图片
				map.put("jieyinpin", service.selectyinpin(map));//音频
			}
		
			
		}else {
			map.put("pk_id", service.shijianid(map));
			if(map.get("pk_id")!=null) {
				map.put("shhoulixishij", service.shhoulixishij(map));//接到报警  事件表
				map.put("shhoulixi", service.shhoulixi(map));//受理信息表
				map.put("eventresult", service.eventresult(map));//事件成功返回结果
				map.put("eventflowinfolist", service.eventflowinfolist(map));//4.9. 事件处置流程
				
				
				/*map.put("jieguo", service.zhdd_event_resultjieguo(map));//结果
*/			}else {
				return null;
			}
		}
		return map;
	}
	/**
	 * 保存调度信息
	 * @param map
	 * @return
	 */
	@RequestMapping("adddiaodu")
	public Integer adddiaodu(@RequestBody HashMap<String, Object> map,HttpServletRequest request){	
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		map.put("fk_acceptance_dept_id", userMap.get("sypi_dept_pk"));//操作人单位ID
		 map.put("fk_acceptance_person_id", userMap.get("sypi_pk"));//操作人ID	
		 map.put("fk_dispatch_person_id", userMap.get("sypi_pk"));//调度人ID
		service.addzhddeventacceptance(map);//保存受理信息
		service.addzhddeventdispatch(map);//4.7. 事件调度信息
		String pk_id_p=map.get("pk_id_p").toString();
		String persondata=map.get("persondata").toString();
		List<Zhdd_event_personnel> policList=new ArrayList<Zhdd_event_personnel>();
		String pk[]=persondata.split(",");
		for (String string : pk) {//
			Zhdd_event_personnel zhdd=new Zhdd_event_personnel();
			zhdd.setFk_event_dispatch_id(Integer.valueOf(pk_id_p));
			zhdd.setFk_event_id(Integer.valueOf(map.get("fk_event_id").toString()));
			zhdd.setFk_person_id(Integer.valueOf(string));
			policList.add(zhdd);
		}
		service.addzhdd_event_personnel(policList);//4.8. 事件处置人员
		map.put("event_current_status", 0);
		int a=service.updatezhddeventinf(map);//事件信息状态改变0已受理    ->事件当前状态（4未受理-查询事件受理信息、0已受理、1未调度、2已调度-查询事件处理流程、3已完成查询事件结果）
		return a;
	}
}
