package com.cist.personalexamine.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
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

import com.cist.frame.page.PageInfo;
import com.cist.personalentry.model.IndividualInfo;
import com.cist.personalentry.service.PersonalEntryService;
import com.cist.personalexamine.service.PersonalExemineService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/***
 * 
 * @Title:  PersonalEntryController.java   
 * @Package com.cist.personalentry.controller
 * @Description:    个人勤务考核审核
 * @author: 田隽杭    
 * @date:   2018年11月27日 上午09:06:00 
 * @version V1.0
 */
@RestController
@RequestMapping("/personalexamine")
public class PersonalExemineController {
	@Autowired
	private PersonalExemineService service;
	@Autowired
	private PersonalEntryService iservice;
	
	/**
	 * 个人勤务考核录入信息查询
	 * @param map
	 */
	@RequestMapping("ExamineInfopageList")
	@SuppressWarnings("rawtypes")
    public PageInfo<IndividualInfo> ExamineInfopageList(@RequestBody HashMap<String,Object> modelMap ){
		PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
    	PageInfo<IndividualInfo> list= (PageInfo<IndividualInfo>)service.ExamineInfopageList(modelMap,pinfo);
    	for(int i=0;i<list.getList().size();i++){
    		list.getList().get(i).setDaterng(list.getList().get(i).getStart_date_name().substring(0, 10));
    		String topic  =  service.getTopice(list.getList().get(i).getFk_topic_id());
    		String regulations = service.getRegulations(list.getList().get(i).getFk_regulations_id());
    		if(list.getList().get(i).getAssessment_type().equals("1")){
    			String report = service.getReport(list.getList().get(i).getFk_report_id().toString());
        		list.getList().get(i).setReport_type(report);
    		}
    		list.getList().get(i).setFk_topic_name(topic);
    		list.getList().get(i).setFk_regulations_name(regulations);
    		List<IndividualInfo> tp = iservice.getAttachment(list.getList().get(i).getPk_id());
    		list.getList().get(i).setInput_name(iservice.UserList(list.getList().get(i).getInput_person().toString()));
    		if(tp.size()!=0){
    			list.getList().get(i).setTp(tp);
    		}
    	}
		return list;
	}
	/**
	 * 个人勤务考核审核
	 * @return
	 */
	@RequestMapping("examinepersonal")
	public int  examinepersonal(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		modelMap.put("khryid", userPk);//操作人pk
		int status = service.examinepersonal(modelMap);
		return status;
	}
}
