package com.cist.personalentry.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cist.configUrl.model.FileUtil;
import com.cist.frame.page.PageInfo;
import com.cist.myDuty.myAssess.model.GpsRecord;
import com.cist.myDuty.myAssess.model.SignIn;
import com.cist.myDuty.myAssess.service.MyAssessService;
import com.cist.personalentry.model.AppraiseInfo;
import com.cist.personalentry.model.DeptInfo;
import com.cist.personalentry.model.IndividualInfo;
import com.cist.personalentry.model.Oeuser;
import com.cist.personalentry.model.OfficeInfo;
import com.cist.personalentry.model.PoliceInfo;
import com.cist.personalentry.model.RegulationsInfo;
import com.cist.personalentry.model.ReportInfo;
import com.cist.personalentry.model.UserInfo;
import com.cist.personalentry.service.PersonalEntryService;
import com.cist.qwgl.qwbb.model.Jcsj_police_res_person;
import com.cist.qwgl.qwbb.model.Qw_report;
import com.cist.qwgl.qwjg.service.QwjgService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;

/***
 * 
 * @Title:  PersonalEntryController.java   
 * @Package com.cist.personalentry.controller
 * @Description:    个人勤务考核录入
 * @author: 田隽杭    
 * @date:   2018年11月13日 下午04:06:00 
 * @version V1.0
 */
@RestController
@RequestMapping("/personalentry")
public class PersonalEntryController {
	@Autowired
	private PersonalEntryService service;
	@Autowired
	private MyAssessService iservice;
	@Autowired
	private QwjgService qwjgservice;
	/**
	 * 管理部门树查询
	 * @param map
	 */
	@RequestMapping("deptinfo")
	public String deptinfo()throws JsonProcessingException{
    //顶级部门
	List<DeptInfo>	departinfo=service.depart_infolist(null);
	ObjectMapper mapper = new ObjectMapper();
	List<DeptInfo> list=departinfodg(departinfo);
	String json=mapper.writeValueAsString(getdiwfdidian(list));
	return json.substring(1, json.length()-1);
	}
	public List<HashMap<String, Object>> getdiwfdidian(List<DeptInfo> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (DeptInfo depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_code());
			map.put("selectable", depart_info.getSelectable());
			map.put("isLeaf", depart_info.getIsLeaf());
			if(null!=depart_info.getChildren()) {//下级
				
				map.put("children", getdiwfdidian(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	public List<DeptInfo> departinfodg(List<DeptInfo> departinfo){
	for (DeptInfo depart_info : departinfo) {
	//部门
	List<DeptInfo> list= service.depart_infolist(depart_info.getDept_pk());
		if(list.size()!=0){
			depart_info.setChildren(list);
			departinfodg(list);
		}
	  }
     return departinfo;
	}
	/**
	 * 非现场审核警员树查询/部门-警员
	 * @param map
	 */
	@RequestMapping("policeinfo")
	public String policeinfo() throws JsonProcessingException{
	    //顶级部门 null
		List<PoliceInfo> departinfo=service.police_infolist(null);//部门
		ObjectMapper mapper = new ObjectMapper();	
		List<PoliceInfo> list=departinfodg2(departinfo);
		String json=mapper.writeValueAsString(getdiwfdidian2(list));
		return json.substring(1, json.length()-1);
	}
	@RequestMapping("qwjgservice")
	public Qw_report qwjgservice(@RequestBody HashMap<String, Object> map) throws JsonProcessingException{
			return	qwjgservice.kaoheselectQwreport(map);
	}
	
	public List<HashMap<String, Object>> getdiwfdidian2(List<PoliceInfo> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (PoliceInfo depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			if(depart_info.getSelectable()) {//
				map.put("key", depart_info.getSypi_code());
			}else {
				map.put("key", depart_info.getDept_code());
			}
			map.put("selectable", depart_info.getSelectable());
			map.put("isLeaf", depart_info.getIsLeaf());
			if(null!=depart_info.getChildren()) {//下级
				map.put("children", getdiwfdidian2(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	
	
	public List<PoliceInfo> departinfodg2(List<PoliceInfo> departinfo){
		for (PoliceInfo depart_info : departinfo) {
			//警员
			depart_info.setChildren(service.Police(depart_info.getDept_code()));
			//部门
			List<PoliceInfo> list= service.police_infolist(depart_info.getDept_pk());
			for (PoliceInfo depart_info2 : list) {
				depart_info.getChildren().add(depart_info2);
			}
			depart_info.setChildren(depart_info.getChildren());
			if(null!=list){
				departinfodg2(list);
			}
		}
		return departinfo;
	}
	/**
	 * 非现场审核信息查询
	 * @param map
	 */
	@RequestMapping("/findData")
	public PageInfo<Oeuser> findData(@RequestBody HashMap<String, Object> map) {
		try {
			PageInfo page = new PageInfo();
			page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<Oeuser> user = (PageInfo<Oeuser>) service.findDatapageList(map, page);
			return user;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 勤务报备信息查询
	 * @param map
	 */
	@RequestMapping("/reportInfo")
	public PageInfo<ReportInfo> reportInfo(@RequestBody HashMap<String, Object> map) {
		try {
			PageInfo page = new PageInfo();
			page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<ReportInfo> list = (PageInfo<ReportInfo>) service.reportpageList(map, page);
			for(int i=0;i<list.getList().size();i++){
				if(list.getList().get(i).getReport_type()=='1'){
					ReportInfo xq = service.getAreaname(list.getList().get(i).getPk_id());
		    		list.getList().get(i).setArea_name(xq.getArea_name());
					list.getList().get(i).setArmed_forces_type(xq.getArmed_forces_type());
					list.getList().get(i).setFk_patrol_area_id(xq.getFk_patrol_area_id());
				}else{
					list.getList().get(i).setArea_name("无(只有街面执勤才有巡逻区域)");
					list.getList().get(i).setArmed_forces_type('2');
					list.getList().get(i).setFk_patrol_area_id(-1);
				}
	    		
	    	}
			return list;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 考核栏目查询
	 * @param map
	 */
	@RequestMapping("AppraiseList")
	public List<AppraiseInfo>  AppraiseList(@RequestBody HashMap<String, Object> map){			
		List<AppraiseInfo> Appraiselist = service.AppraiseList();
		return Appraiselist;
	}
	/**
	 * 考核条例查询
	 * @param map
	 */
	@RequestMapping("RegulationsList")
	public List<RegulationsInfo>  RegulationsList(@RequestBody HashMap<String, Object> map){			
		List<RegulationsInfo> Regulationslist = service.RegulationsList(map);
		for(int a = 0;a<Regulationslist.size();a++){
			Regulationslist.get(a).setRegulations_name(Regulationslist.get(a).getRegulations_name()+Regulationslist.get(a).getAssessment_num().toString());
		}
		return Regulationslist;
	}
	/**
	 * 个人勤务考核录入信息查询
	 * @param map
	 */
	@RequestMapping("IndivInfopageList")
	@SuppressWarnings("rawtypes")
    public PageInfo<IndividualInfo> IndivInfopageList(@RequestBody HashMap<String,Object> modelMap ){
		PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
    	PageInfo<IndividualInfo> list= (PageInfo<IndividualInfo>)service.IndivInfopageList(modelMap,pinfo);
    /*	for(int i=0;i<list.getList().size();i++){
    		list.getList().get(i).setDaterng(list.getList().get(i).getStart_date_name().substring(0, 10));
    		List<IndividualInfo> tp = service.getAttachment(list.getList().get(i).getPk_id());
    		list.getList().get(i).setInput_name(service.UserList(list.getList().get(i).getInput_person().toString()));
    		if(tp.size()!=0){
    			list.getList().get(i).setTp(tp);
    		}
    	}*/
		return list;
	}
	/**
	 * 考核条数和审核条数查询
	 */
	@RequestMapping("officeList")
	public OfficeInfo  OfficeList(@RequestBody HashMap<String, Object> map){
		OfficeInfo officelist = new OfficeInfo();
		if(map.get("bbsj") != "" && map.get("sypi_pk") != ""){
			int shts = service.shtsList(map);
			if(shts != 0){
				officelist.setShts(shts);
			}else{
				officelist.setShts(0);
			}
		}
		if(map.get("sypi_pk") != ""){
			Object khts = service.khtsList(map);
			if(null!=khts&&!khts.equals("0")){
				officelist.setKhts(Integer.valueOf(khts.toString()));
			}else{
				officelist.setKhts(0);
			}
		}
		return officelist;
	}
	/**
	 * 当前用户查询
	 */
	@RequestMapping("UserList")
	public UserInfo  UserList(HttpServletRequest request){
		UserInfo user = new UserInfo();
		Integer count = null;
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		String user_name = service.UserList(userPk);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		user.setSypi_date(df.format(new Date()));
		user.setSypi_name(user_name);
		return user;
	}
	
	/**
	 * 个人勤务考核录入新增
	 * @param map
	 */
	@RequestMapping("addpersonalentry")
	public int  addpersonalentry(List<MultipartFile> file, String data,HttpServletRequest request){
		String fileUploadService = null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			modelMap = objectMapper.readValue(data, HashMap.class); // JSON转Map
			// data为前台传递的参数JSON参数字符串

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Integer count = null;
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		modelMap.put("fk_commit_person_id", userPk);//操作人pk
		String a = modelMap.get("time_state").toString().substring(0,8);
		String b = modelMap.get("time_end").toString().substring(0,8);
		String c = modelMap.get("time_date").toString();
		String khsj = modelMap.get("khsj").toString();
		modelMap.put("khsj", khsj);
		modelMap.put("state_date", c+" "+a);
		modelMap.put("end_date", c+" "+b);
		int status;
		if(modelMap.get("shzt").equals("2")){
			 int o = service.addpersonaloffice(modelMap);
			 status = 1;
		}else{
			int o = service.addpersonalreport(modelMap);
			status = 1;
		}
		int id = (int) modelMap.get("id");
		map.put("id", id);
		for (int i = 0; i < file.size(); i++) {
			MultipartFile file1 = file.get(i);
			
			int dx = (int) file1.getSize();
			String name=file1.getOriginalFilename();
			fileUploadService = FileUtil.FileUploadService(file1);
			String photo_name =name.substring(0, name.indexOf(".")-1);
			String attachment_suffix = name.substring(name.indexOf(".")+1,name.length());
			map.put("attachment_name", photo_name);
			map.put("attachment_suffix", attachment_suffix);
			map.put("attachment_source", fileUploadService);
			map.put("fk_commit_person_id", userPk);
			map.put("attachment_size", dx);
			int g = service.addattachment(map);
		}
		return status;
	}
	
	/**
	 * 个人勤务考核录入修改
	 * @param map
	 */
	@RequestMapping("editpersonalentry")
	public int  editpersonalentry(List<MultipartFile> file, String data,HttpServletRequest request,String history){
		String fileUploadService = null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		HashMap<String, Object> modelMap3 = new HashMap<String, Object>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> historyMap = new HashMap<String, Object>();
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			modelMap = objectMapper.readValue(data, HashMap.class); // JSON转Map
			// data为前台传递的参数JSON参数字符串

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Integer count = null;
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		modelMap.put("khryid", userPk);//操作人pk
		/*String a = modelMap.get("time_state").toString().substring(0,8);
		String b = modelMap.get("time_state").toString().substring(0,8);
		String c = modelMap.get("time_date").toString();*/
		modelMap.put("state_date", modelMap.get("time_state"));
		modelMap.put("end_date", modelMap.get("time_end"));
		int status;
		String ip = "未知";
		try {
			ip = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		String ip_a = ip.substring(ip.indexOf("/")+1,ip.length());
		String 	dept_pk=modelMap.get("pk_id").toString();
		if(file.size()>0){
			modelMap3.put("pk_id", dept_pk.split(","));
			int p = service.deleteAttachment(modelMap3);
		}
		for (int i = 0; i < file.size(); i++) {
			MultipartFile file1 = file.get(i);
			int dx = (int) file1.getSize();
			fileUploadService = FileUtil.FileUploadService(file1);
			String photo_dz = fileUploadService.substring(0,fileUploadService.indexOf("c"));
			String photo_name = fileUploadService.substring(fileUploadService.indexOf("c")+1,fileUploadService.length());
			String photo_hz = photo_name.substring(photo_name.indexOf("."), photo_name.length());
			String photo_na = photo_name.substring(0,photo_name.indexOf("."));
			map.put("photo_name", photo_na);
			map.put("photo_dz", photo_dz);
			map.put("id", modelMap.get("pk_id"));
			map.put("photo_hz", photo_hz);
			map.put("khryid", userPk);
			map.put("size", dx);
			int g = service.addattachment(map);
		}
		if(modelMap.get("shzt").equals("2")){
			 int o = service.editpersonaloffice(modelMap);
			 status = 1;
		}else{
			int o = service.editpersonalreport(modelMap);
			status = 1;
		}
		int tpid = (int) modelMap.get("pk_id");
		List<IndividualInfo> tp = service.getAttachment(tpid);
		modelMap.put("tp", tp);
		JSONObject jsonObject=JSONObject.fromObject(modelMap);
		historyMap.put("data", jsonObject.toString());
		historyMap.put("history", history);
		historyMap.put("khryid", userPk);
		historyMap.put("pk_id", modelMap.get("pk_id"));
		historyMap.put("bjyy", modelMap.get("edit_reason"));
		historyMap.put("ip",ip_a);
		int cp =  service.addLog(historyMap);
		return status;
	}
	/**
	 * 个人勤务考核录入删除
	 * @param map
	 */
	@RequestMapping("delpersonalentry")
	public int  delRedInfo(@RequestBody HashMap<String,Object> modelMap){
		String 	dept_pk=modelMap.get("pk_id").toString();
		modelMap.put("pk_id", dept_pk.split(","));
		int status = service.deleteAttachment(modelMap);
		int p =  service.deletepersonalentry(modelMap);
		return status;
	}
	/**
	 * 查询报备勤务考核中考核类型为街面勤务的执勤情况页需要的数据
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("queryReportStreet")
	public HashMap<String, Object> queryReportStreet(@RequestBody HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("reportStreet", iservice.queryReportStreet(paramMap));
		List<SignIn> signInfo = iservice.querySignIn(paramMap);
		for (SignIn sign : signInfo) {
			// 签到
			if (sign.getSign_in_type() == '1')
				resultMap.put("signIn", sign);
			// 签退
			if (sign.getSign_in_type() == '2')
				resultMap.put("signBack", sign);
		}

		return resultMap;

	}
	/**
	 * 根据警员Id查询某段时间的巡逻轨迹信息
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("queryTrackPlayback")
	public List<GpsRecord> queryTrackPlayback(@RequestBody HashMap<String, Object> paramMap) {
		return iservice.queryTrackPlayback(paramMap);

	}
}
