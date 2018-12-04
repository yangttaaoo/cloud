package com.cist.tjfx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.tjfx.model.EvidenceTj;
import com.cist.tjfx.model.Myxzltj;
import com.cist.tjfx.model.Zltj;
import com.cist.tjfx.service.TjfxService;
import com.cist.tjfx.util.TjUtil;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/tjfx")
public class TjfxController {
	@Autowired
	private TjfxService service;
	
	@RequestMapping("index")
	public HashMap<String,Object> index(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> modelMap=new HashMap<String,Object>();
		modelMap.put("evidencenum", service.queryevidencenum(null));//证据总件数
		map.put("evidence_status", 1);
		modelMap.put("gdevidencenum", service.queryevidencenum(map));//归档证据总数
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
        String firstday = format.format(calendar.getTime())+" 00:00:00";//本月开始时间
        map.put("kssj", firstday);
        modelMap.put("byxzl", service.querybyxz(map));//本月新增量
        modelMap.put("evidencebydept", service.querynumbydept(null));//根据单位查询证据数量,(未根据时间查询)
        modelMap.put("zjlxtj", service.querytjbyzjlx(null));//证据类型统计
        modelMap.put("salxtj", service.querytjbysalx(null));//涉案类型统计
        //统计本周每天总量
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setFirstDayOfWeek(Calendar.MONDAY);
        calendar1.set(Calendar. DAY_OF_WEEK, Calendar.MONDAY);
        String bzkssj = format.format(calendar1.getTime())+" 00:00:00";
        String dqsj = format1.format(new Date());
        map.put("kssj", bzkssj);
        map.put("jssj", dqsj);
        List<Myxzltj> bzzllist = service.querybzzl(map);
        //统计上周每天总量
        String szkssj = format.format(TjUtil.getBeginDayOfLastWeek())+" 00:00:00";
        String szjssj = format.format(TjUtil.getEndDayOfLastWeek())+" 23:59:59";
        map.put("kssj", szkssj);
        map.put("jssj", szjssj);
        List<Myxzltj> szzllist = service.querybzzl(map);
        //将
//        modelMap.put("bzzltj", szzllist);
        List<Zltj> bzzltjlist = new ArrayList<Zltj>();
        String []arr = {"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
        int[] int1=new int[7];
        int[] int2=new int[7];
        Zltj zltj = null;
        for (int i = 0; i < 7; i++) {
        	zltj =new Zltj();
        	zltj.setName(arr[i]);
        	//本周
			for (int j = 0; j < bzzllist.size(); j++) {
				if(arr[i].equals(bzzllist.get(j).getXq())) {
					zltj.setDqnum(bzzllist.get(j).getNum());
				}
			}
			
			//上周
			for (int j = 0; j < szzllist.size(); j++) {
				if(arr[i].equals(szzllist.get(j).getXq())) {
					zltj.setSynum(szzllist.get(j).getNum());
				}
			}
			int1[i]=zltj.getDqnum();
			int2[i]=zltj.getDqnum()-zltj.getSynum()>0?(zltj.getDqnum()-zltj.getSynum()):0;
			bzzltjlist.add(zltj);
		}
        modelMap.put("xq", arr);
        modelMap.put("dq", int1);
        modelMap.put("sy", int2);
		return modelMap;
	}
	/**
	 * 查询本月统计
	 * @param map
	 * @return
	 */
	@RequestMapping("bytj")
	public HashMap<String,Object> bytj(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> modelMap=new HashMap<String,Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String bykssj = format.format(TjUtil.getBeginDayOfMonth())+" 00:00:00";//本月开始时间
		String byjssj = format.format(TjUtil.getEndDayOfMonth())+" 23:59:59";//本月结束时间
		map.put("kssj", bykssj);
		map.put("jssj", byjssj);
		List<Myxzltj> bytjlist = service.querybzzl(map);
		String sykssj = format.format(TjUtil.getBeginDayOfLastMonth())+" 00:00:00";//上月开始时间
		String syjssj = format.format(TjUtil.getEndDayOfLastMonth())+" 23:59:59";//上月结束时间
		map.put("kssj", sykssj);
		map.put("jssj", syjssj);
		List<Myxzltj> sytjlist = service.querybzzl(map);
		List<Zltj> bzzltjlist = new ArrayList<Zltj>();
		Zltj zltj = null;
		String[] str=new String[31];
		int[] int2=new int[31];
        int[] int3=new int[31];
		for (int i = 0; i < 31; i++) {
			zltj = new Zltj();
			zltj.setName((i+1)+"日");
			for (int j = 0; j < bytjlist.size(); j++) {
				//本月
				calendar.setTime(bytjlist.get(j).getYf());
				if(zltj.getName().equals(calendar.get(Calendar.DAY_OF_MONTH)+"日")) {
					zltj.setDqnum(bytjlist.get(j).getNum());
				}
			}
			
			for (int j = 0; j < sytjlist.size(); j++) {
				calendar.setTime(sytjlist.get(j).getYf());
				if(zltj.getName().equals(calendar.get(Calendar.DAY_OF_MONTH)+"日")) {
					zltj.setSynum(sytjlist.get(j).getNum());
				}
			}
			str[i]=(i+1)+"日";
			int2[i]=zltj.getDqnum();
			int3[i]=zltj.getDqnum()-zltj.getSynum()>0?(zltj.getDqnum()-zltj.getSynum()):0;
		}
		modelMap.put("rq", str);
		modelMap.put("dq", int2);
		modelMap.put("sy", int3);
		return modelMap;
	}
	/**
	 * 查询本周统计
	 * @param map
	 * @return
	 */
	@RequestMapping("bztj")
	public HashMap<String,Object> bztj(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> modelMap=new HashMap<String,Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		//统计本周每天总量
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setFirstDayOfWeek(Calendar.MONDAY);
        calendar1.set(Calendar. DAY_OF_WEEK, Calendar.MONDAY);
        String bzkssj = format.format(calendar1.getTime())+" 00:00:00";
        String dqsj = format1.format(new Date());
        map.put("kssj", bzkssj);
        map.put("jssj", dqsj);
        List<Myxzltj> bzzllist = service.querybzzl(map);
		 //统计上周每天总量
        String szkssj = format.format(TjUtil.getBeginDayOfLastWeek())+" 00:00:00";
        String szjssj = format.format(TjUtil.getEndDayOfLastWeek())+" 23:59:59";
        map.put("kssj", szkssj);
        map.put("jssj", szjssj);
        List<Myxzltj> szzllist = service.querybzzl(map);
        //将
//        modelMap.put("bzzltj", szzllist);
        List<Zltj> bzzltjlist = new ArrayList<Zltj>();
        String []arr = {"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
        int[] int1=new int[7];
        int[] int2=new int[7];
        Zltj zltj = null;
        for (int i = 0; i < 7; i++) {
        	zltj =new Zltj();
        	zltj.setName(arr[i]);
        	//本周
			for (int j = 0; j < bzzllist.size(); j++) {
				if(arr[i].equals(bzzllist.get(j).getXq())) {
					zltj.setDqnum(bzzllist.get(j).getNum());
				}
			}
			
			//上周
			for (int j = 0; j < szzllist.size(); j++) {
				if(arr[i].equals(szzllist.get(j).getXq())) {
					zltj.setSynum(szzllist.get(j).getNum());
				}
			}
			int1[i]=zltj.getDqnum();
			int2[i]=zltj.getDqnum()-zltj.getSynum()>0?(zltj.getDqnum()-zltj.getSynum()):0;
			bzzltjlist.add(zltj);
		}
        modelMap.put("xq", arr);
        modelMap.put("dq", int1);
        modelMap.put("sy", int2);
		return modelMap;
	}
	/**
	 * 查询全年统计
	 * @param map
	 * @return
	 */
	@RequestMapping("qntj")
	public HashMap<String,Object> qntj(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> modelMap=new HashMap<String,Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		//查询本年统计
		String bnkssj = TjUtil.getNowYear()+"-01-01 00:00:00";
		String bnjssj = TjUtil.getNowYear()+"-12-31 23:59:59";
		map.put("kssj", bnkssj);
		map.put("jssj", bnjssj);
		List<Myxzltj> bnzltj = service.querymyxzl(map);
		
		//查询上年统计
		String snkssj = (TjUtil.getNowYear().intValue()-1)+"-01-01 00:00:00";
		String snjssj = (TjUtil.getNowYear().intValue()-1)+"-12-31 23:59:59";
		map.put("kssj", snkssj);
		map.put("jssj", snjssj);
		List<Myxzltj> snzltj = service.querymyxzl(map);
	//	 List<Zltj> bzzltjlist = new ArrayList<Zltj>();
		String[] str=new String[12];
		int[] int2=new int[12];
        int[] int3=new int[12];
        Zltj zltj=null;
		for (int i = 0; i < 12; i++) {
			str[i]=(i+1)+"月";
			zltj = new Zltj();
			zltj.setName((i+1)+"月");
			for (int j = 0; j < bnzltj.size(); j++) {
				calendar.setTime(bnzltj.get(j).getYf());
				if(str[i].equals((calendar.get(Calendar.MONTH)+1)+"月")) {
					zltj.setDqnum(bnzltj.get(j).getNum());
				}
			}
			
			for (int j = 0; j < snzltj.size(); j++) {
				calendar.setTime(snzltj.get(j).getYf());
				if(str[i].equals((calendar.get(Calendar.MONTH)+1)+"月")) {
					zltj.setSynum(snzltj.get(j).getNum());
				}
			}
			int2[i]=zltj.getDqnum();
			int3[i]=zltj.getDqnum()-zltj.getSynum()>0?(zltj.getDqnum()-zltj.getSynum()):0;
		}
		 modelMap.put("yf", str);
	     modelMap.put("dq", int2);
	     modelMap.put("sy", int3);
		return modelMap;
	}
	/**
	 * 根据时间查询单位证据数量
	 * @param map
	 * @return
	 */
	@RequestMapping("evidencebydept")
	public List<EvidenceTj> queryevidencebydept(@RequestBody HashMap<String,Object> map) {
		return service.querynumbydept(map);
	}
}
