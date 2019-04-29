package com.cist.personageassess.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.personageassess.model.Qw_Opertion_Log;
import com.cist.personageassess.model.Qw_assessment_attachment;
import com.cist.personageassess.model.Qw_individual_assessment;
import com.cist.personageassess.model.Qw_patrol_alarm_log;
import com.cist.personageassess.model.TBL_OFFE_EVDI;
import com.cist.personageassess.service.PersonageAssessService;


@RestController
@SuppressWarnings("unchecked")
@RequestMapping("personageassess")
public class PersonageAssessController {
	@Autowired
	private PersonageAssessService service;
	/**
	 * 个人勤务考核查询（分页）
	 * @param map
	 * @return
	 */
	@RequestMapping("list")
	public PageInfo<Qw_individual_assessment> querypersonageassessinfo(@RequestBody HashMap<String,Object> map ){
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Qw_individual_assessment> pageinfo = (PageInfo<Qw_individual_assessment>)service.querypersonageassessinfopageList(map, info);
		return pageinfo;
	}
	/**
	 * 根据个人勤务id查询日志信息
	 * @param map
	 * @return
	 */
	@RequestMapping("log")
	public HashMap<String,Object> querylog(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		List<Qw_Opertion_Log> loginfo = service.querylog(map);//根据个人勤务id查询日志信息
		ModelMap.put("log", loginfo);
		return ModelMap;
		}
	/**
	 * 根据条件查询非现信息
	 * @param map
	 * @return
	 */
	@RequestMapping("fxinfo")
	public HashMap<String,Object> queryfxinfo(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		List<TBL_OFFE_EVDI> fxinfo = service.queryfxinfo(map);
		ModelMap.put("fxinfo", fxinfo);
		return ModelMap;
	}
	/**
	 * 非现场详情分页查询
	 * @param map
	 * @return
	 */
	@RequestMapping("fxinfofy")
	public PageInfo<TBL_OFFE_EVDI> queryfxinfopageList(@RequestBody HashMap<String,Object> map){
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<TBL_OFFE_EVDI> pageinfo = (PageInfo<TBL_OFFE_EVDI>)service.queryfxinfopageList(map,info);
		return pageinfo;
	}
	/**
	 * 根据个人勤务考核id查询附件信息
	 * @param map
	 * @return
	 */
	@RequestMapping("fjinfo")
	public HashMap<String,Object> queryfjinfo(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		map.put("constraint", "wdkhfj");//我的考核附件
		List<Qw_assessment_attachment> wdfjinfo = service.queryfjinfo(map);
		ModelMap.put("wdfjinfo", wdfjinfo);
		
		map.put("constraint", "wdhffj");//我的勤务考核回复附件
		List<Qw_assessment_attachment> wdhffjinfo = service.queryfjinfo(map);
		ModelMap.put("wdhffjinfo", wdhffjinfo);
		
		map.put("constraint", "wdfkfj");//我的勤务考核反馈附件
		List<Qw_assessment_attachment> wdfkfjinfo = service.queryfjinfo(map);
		ModelMap.put("wdfkfjinfo", wdfkfjinfo);
		return ModelMap;
	}
	/**
	 * 考核信息详情
	 * @param map
	 * @return
	 */
	@RequestMapping("khxx")
	public HashMap<String,Object> querykhxx(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		ModelMap.put("khlm", service.querykhlm(map));//考核栏目名称
		ModelMap.put("khtl", service.querykhtl(map));//考核条例名称
		return ModelMap;
	}
	
	/**
	 * 勤务报备详情查询
	 * @param map
	 * @return
	 */
	@RequestMapping("qwbbinfo")
	public HashMap<String,Object> queryqwbbinfo(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		ModelMap.put("qwbbinfo", service.queryqwbbinfo(map));
		return ModelMap;
	}
	/**
	 * 街面勤务异常日志分页展示
	 * @param map
	 * @return
	 */
	@RequestMapping("jmqwlog")
	public PageInfo<Qw_patrol_alarm_log> jmqwlog(@RequestBody HashMap<String,Object> map ){
		String jmqwbbid = service.queryjmqwbyqwbb(map);
		map.put("jmqwbbid", jmqwbbid);
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Qw_patrol_alarm_log> pageinfo = (PageInfo<Qw_patrol_alarm_log>)service.queryjmqwlogpageList(map, info);
		return pageinfo;
	}
	/**
	 * 根据勤务报备id查询街面勤务报备信息
	 * @param map
	 * @return
	 */
	@RequestMapping("jmqwinfo")
	public HashMap<String,Object> queryjmqwinfo(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		ModelMap.put("jmqwinfo", service.queryjmqwinfo(map));
		ModelMap.put("equipinfo", service.queryequip(map));
		return ModelMap;
	}
}
