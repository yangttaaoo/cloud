package com.cist.myScheduling.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.feedback.model.Sys_frm_code;
import com.cist.frame.page.PageInfo;
import com.cist.myScheduling.model.QwReport;
import com.cist.myScheduling.model.QwSignIn;
import com.cist.myScheduling.model.Qw_patrol_alarm_log;
import com.cist.myScheduling.service.MySchedulingService;
import com.cist.qwgl.jzgl.model.Jcsj_police_res_person;
import com.cist.qwgl.jzgl.model.Qw_duty_relation;
import com.cist.qwgl.jzgl.model.Qw_equip_info;
import com.cist.qwgl.jzgl.model.Qw_guns_relation;
import com.cist.qwgl.jzgl.model.Syspoliceinfo;
import com.cist.qwgl.jzgl.service.JzglService;

@RestController
@RequestMapping("myScheduling")
public class MySchedulingController {
	@Autowired
	private MySchedulingService service;
	
	@Autowired
	private JzglService jzService;

	/**
	 * 查询数据
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/list")
	public PageInfo<QwReport> list(@RequestBody HashMap<String, Object> map,HttpServletRequest request) {
		// 警员
				HttpSession session = request.getSession();
				Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
				String report_person_id = userMap.get("sypi_code")==null?null:userMap.get("sypi_code").toString();
//				"\"rybh\":"+
				map.put("report_person_id", report_person_id);//查询报备人对应的排班
		try {
			PageInfo page = new PageInfo();
			page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<QwReport> info = (PageInfo<QwReport>) service.listpageList(map, page);
			return info;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询数据
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/selectlist")
	public List<QwReport> selectlist(@RequestBody HashMap<String, Object> map,HttpServletRequest request) {
		// 警员
				HttpSession session = request.getSession();
				Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
				String report_person_id = userMap.get("sypi_code")==null?null:userMap.get("sypi_code").toString();
				map.put("report_person_id", report_person_id);//查询报备人对应的排班
		try {
			List<QwReport> selectlist = service.selectlist(map);
			return selectlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *勤务类型下拉列表
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/selectQwList")
	public Map<String,Object> selectBaseData(@RequestBody HashMap<String, Object> map){
		map.put("fct_code", SysBaseDataCode.SYS_QWLX);
		List<Sys_frm_code> selectBaseData = service.selectBaseData(map);
		map.put("qwlxList", selectBaseData);
		return map;
		
	}
	
	/**
	 * 查询装备信息
	 * @param map
	 * @return
	 */
	@RequestMapping("queryequip")
	public HashMap<String,Object> queryequip(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		List<Qw_equip_info> equip= service.queryequip(map);//查询装备信息
		for (int i = 0; i < equip.size(); i++) {
			map.put("fk_equip_id", equip.get(i).getPk_id());//装备信息id
			List<Qw_guns_relation> gunslist = service.queryqw_guns_relation(map);//根据装备信息id查询枪支关联警员
			ModelMap.put("gunslist", gunslist.size());//枪支数量
		}
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
		List<Qw_duty_relation> Qw_duty_relation =  jzService.queryQw_duty_relation(map);//根据警组id查询值班值守关联人员
		String Dutyleadername="";
		String Commandername="";
		String shiftforemanname="";
		String Dutypolicename="";
		String Guardondutyname="";
		for (int i = 0; i < Qw_duty_relation.size(); i++) {
			//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
			if("1".equals(Qw_duty_relation.get(i).getUSER_TYPE().toString())) {
				map.put("sypi_pk", Qw_duty_relation.get(i).getFk_user_id());
				List<Jcsj_police_res_person> policeinfo = jzService.selectpolice(map);
				if(policeinfo!=null) {
					Dutyleadername+=policeinfo.get(0).getXm()+"("+policeinfo.get(0).getId()+")"+"、";
				}
			}else if("2".equals(Qw_duty_relation.get(i).getUSER_TYPE().toString())) {
				map.put("sypi_pk", Qw_duty_relation.get(i).getFk_user_id());
				List<Jcsj_police_res_person> policeinfo = jzService.selectpolice(map);
				if(policeinfo!=null) {
					Commandername+=policeinfo.get(0).getXm()+"("+policeinfo.get(0).getId()+")"+"、";
				}
			}else if("3".equals(Qw_duty_relation.get(i).getUSER_TYPE().toString())) {
				map.put("sypi_pk", Qw_duty_relation.get(i).getFk_user_id());
				List<Jcsj_police_res_person> policeinfo = jzService.selectpolice(map);
				if(policeinfo!=null) {
					shiftforemanname+=policeinfo.get(0).getXm()+"("+policeinfo.get(0).getId()+")"+"、";
				}
			}else if("4".equals(Qw_duty_relation.get(i).getUSER_TYPE().toString())) {
				map.put("sypi_pk", Qw_duty_relation.get(i).getFk_user_id());
				List<Jcsj_police_res_person> policeinfo = jzService.selectpolice(map);
				if(policeinfo!=null) {
					Dutypolicename+=policeinfo.get(0).getXm()+"("+policeinfo.get(0).getId()+")"+"、";
				}
			}else {
				map.put("sypi_pk", Qw_duty_relation.get(i).getFk_user_id());
				List<Jcsj_police_res_person> policeinfo = jzService.selectpolice(map);
				if(policeinfo!=null) {
					Guardondutyname+=policeinfo.get(0).getXm()+"("+policeinfo.get(0).getId()+")"+"、";
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
		ModelMap.put("Dutyleadername", Dutyleadername);
		ModelMap.put("Commandername", Commandername);
		ModelMap.put("shiftforemanname", shiftforemanname);
		ModelMap.put("Dutypolicename", Dutypolicename);
		ModelMap.put("Guardondutyname", Guardondutyname);
		return ModelMap;
		}
	
	/**
	 * 街面勤务异常日志查询
	 * @param map
	 * @return
	 */ 
	@RequestMapping("/selectAlarmLog")
	public Map<String,Object>selectAlarmLog(@RequestBody HashMap<String,Object> map){
		//街面勤务异常日志查询
		map.put("alarmLog", service.selectAlarmLog(map));
		return map;
		
	}
	
	/**
	 * 任务状态查询
	 * @param map
	 * @return
	 */ 
	@RequestMapping("/selectStatus")
	public Map<String,Object>selectStatus(@RequestBody HashMap<String,Object> map){
		
		if("1".equals(map.get("report_type"))){
			//街面勤务异常日志查询
			map.put("alarmLog", service.selectAlarmLog(map));//街面勤务异常信息
		}
		List<QwSignIn> selectSign = service.selectSign(map);
		for (QwSignIn sign: selectSign) {
			// 签到
			if ("1".equals(sign.getSign_in_type()))
				map.put("signIn", sign);
			// 签退
			if ("2".equals(sign.getSign_in_type()))
				map.put("signBack", sign);
		}
		return map;
		
	}
	
	/**
	 * 街面勤务异常日志分页展示
	 * @param map
	 * @return
	 */
	@RequestMapping("jmqwlog")
	public PageInfo<Qw_patrol_alarm_log> jmqwlog(@RequestBody HashMap<String,Object> map ){
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Qw_patrol_alarm_log> pageinfo = (PageInfo<Qw_patrol_alarm_log>)service.queryjmqwlogpageList(map, info);
		return pageinfo;
	}
}