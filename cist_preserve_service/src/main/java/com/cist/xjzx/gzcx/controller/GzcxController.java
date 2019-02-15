package com.cist.xjzx.gzcx.controller;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.xjzx.gzcx.model.JTYW_JOB_ORDER;
import com.cist.xjzx.gzcx.model.JTYW_MAINTENANCE_COMPANY;
import com.cist.xjzx.gzcx.model.JTYW_MAINTENANCE_GROUP;
import com.cist.xjzx.gzcx.model.VW_SBGZ_INFO;
import com.cist.xjzx.gzcx.service.GzcxService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("gzcx")
public class GzcxController {
	@Autowired
	private GzcxService service;
	/**
	 * 故障查询
	 * @param map
	 * @return
	 */
	@RequestMapping("gzcxinfo")
	public PageInfo<VW_SBGZ_INFO> querygzcx(@RequestBody HashMap<String,Object> map){
		PageInfo info = new PageInfo();
		if(map.get("currentPage")!=null){
			info.setPageNum( Integer.parseInt(map.get("currentPage").toString()) );
		}else{
			info.setPageNum(1);
		}
		if(map.get("pageSize")!=null){
			info.setPageSize(Integer.parseInt(map.get("pageSize").toString()) );
		}else{
			info.setPageSize(9);
		}
		Object obj = service.querygzpageList(map, info);
		PageInfo<VW_SBGZ_INFO> list = (PageInfo<VW_SBGZ_INFO>)obj;
		return list;
	}
	/**
	 * 添加工单信息
	 * @param map
	 * @return
	 */
	@RequestMapping("addgd")
	public Integer addgd(@RequestBody HashMap<String,Object> map) {
		map.put("fk_device_id", map.get("device_id").toString());
		map.put("fk_device_list_id", map.get("device_id").toString());
		map.put("fk_dept_id", "1");
		map.put("job_status", '0');
		map.put("fk_job_num", map.get("job_num").toString());
		map.put("fk_d_operator_id", 1);
		map.put("distribution_time", new Date());
		int count = service.addgd(map);
		int count1 = service.addgdgl(map);
		int count2 = service.addgdlc(map);
		return count+count1;
	}
	/**
	 * 更新工单
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("updategd")
	public Integer updategd(@RequestBody HashMap<String,Object> map) throws ParseException {
		Calendar calendar=Calendar.getInstance(); 
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(map.get("complete_time_limit")!=null) {
			Date daystart = df.parse(map.get("complete_time_limit").toString());
			calendar.setTime(daystart);
			map.put("complete_time_limit", calendar.getTime());
		}
		return service.updategd(map);
	}
	/**
	 * 故障设备信息删除
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deletegzsb(@RequestBody HashMap<String,Object> map) {
		String sbgz_pk = map.get("pk_id").toString();
		if (null != sbgz_pk && sbgz_pk != "" && sbgz_pk.indexOf(",") != -1) {
			sbgz_pk = sbgz_pk.substring(0, sbgz_pk.length() - 1);
			String sbb[] = sbgz_pk.split(",");
			map.put("sbgz_pk", sbb);
		} else {
			String[] sbb = new String[1];
			sbb[0] = sbgz_pk;
			map.put("sbgz_pk", sbb);
		}
		Integer count = service.del(map);
		return count;
	}
	/**
	 * 工单查询
	 * @param map
	 * @return
	 */
	@RequestMapping("gdcx")
	public PageInfo<JTYW_JOB_ORDER> querygd(@RequestBody HashMap<String,Object> map){
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<JTYW_JOB_ORDER> pageinfo = (PageInfo<JTYW_JOB_ORDER>)service.querygdpageList(map, info);
		return pageinfo;
	}
	/**
	 * 查询维护单位
	 * @param map
	 * @return
	 */
	@RequestMapping("querycompany")
	public List<JTYW_MAINTENANCE_COMPANY> querycompany(@RequestBody HashMap<String,Object> map){
		return service.querycompany(null);
	}
	/**
	 * 查询维护组
	 * @param map
	 * @return
	 */
	@RequestMapping("querygroup")
	public List<JTYW_MAINTENANCE_GROUP> querygroup(@RequestBody HashMap<String,Object> map){
		return service.querygroup(map);
	}
}
