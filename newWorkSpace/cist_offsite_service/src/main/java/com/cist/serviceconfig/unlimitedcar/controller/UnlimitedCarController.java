package com.cist.serviceconfig.unlimitedcar.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.page.PageInfo;
import com.cist.serviceconfig.unlimitedcar.model.CarManage;
import com.cist.serviceconfig.unlimitedcar.model.Didels;
import com.cist.serviceconfig.unlimitedcar.model.ExportExcel;
import com.cist.serviceconfig.unlimitedcar.model.NoLimited;
import com.cist.serviceconfig.unlimitedcar.service.UnlimitedService;
import com.cist.frame.utils.SysTempStoreUtils;
@RestController
@RequestMapping("/nolimit")
public class UnlimitedCarController {
  @Autowired
  private UnlimitedService service;  
  /**
   * 查询不限行数据
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  @RequestMapping("/pagelist")
  public PageInfo<CarManage> selectPageData(@RequestBody HashMap<String ,Object> map){
	  try {
		PageInfo page=new PageInfo();
		  page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		  page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<CarManage> list=(PageInfo<CarManage>) service.selectNoCarpageList(map, page);
		  for (int i = 0; i < list.getList().size(); i++) {
				String plate = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_HPZL,list.getList().get(i).getTwi_plate_type());
				list.getList().get(i).setHpzl_name(plate);
				String cllx = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CLLX ,list.getList().get(i).getTwi_type_code());
				list.getList().get(i).setCllx_name(cllx);
			}
		  return list;
 	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;	   
  }
  /**
   * 添加数据
   */
   @RequestMapping("/insert")
    public 	Integer insertInfo(@RequestBody HashMap<String, Object> map){
	   map.put("hphm",map.get("hpqy").toString()+map.get("hphm").toString());
	   Integer  info=service.insertInfo(map);
	return info;
  }
   /**
    * 根据号牌号牌查询数据详情
    */
   @RequestMapping("/selectbyid")
   public Didels selectById(@RequestBody HashMap<String, Object> map){
	   HashMap<String,Object> modelMap=new HashMap<String,Object>();
	   modelMap.put("hphm",map.get("hpqy").toString()+map.get("hphm").toString());
	   Didels car=service.selectById(modelMap);
	   return car;
   }
   /**
    * 根据id删除数据
    */
   @RequestMapping("/deletbyid")
   public Integer deletById(@RequestBody HashMap<String, Object> map){
	   Integer  it=service.delectInfo(map);
	return it;	
   }
   /**
    * 批量删除
    */
   @RequestMapping("/deleteall")
   public Integer deleteAll(@RequestParam("pk")  String[] pk){
	  Integer in=service.deleteAll(pk);
	return in; 
   }
   /**
	 * 根据id更新数据
	 */
   @RequestMapping("/update")
   public Integer updateByid(@RequestBody HashMap<String, Object> map){
	   map.put("hphm",map.get("hpqy").toString()+map.get("hphm").toString());
	   Integer ma=service.updateById(map);
	 return ma;
   }
   /**
    * 导出
    */
   @RequestMapping(value = "/downloadExcle")
	public String downloadExcle(@RequestParam HashMap<String, Object> map, HttpServletResponse response,
			HttpServletRequest request) {
	
		   List<NoLimited> list = service.selectAll(map);
			response.reset();
			response.setCharacterEncoding("utf-8");
			response.setContentType("multipart/form-data");
			// 解决不同浏览器excle包名字含有中文时乱码的问题
			String downloadName = "不限行车辆管理-新增.xls";
			String agent = request.getHeader("USER-AGENT");
			try {
				if (agent.contains("MSIE") || agent.contains("Trident")) {
					downloadName = java.net.URLEncoder.encode(downloadName, "UTF-8");
				} else {
					downloadName = new String(downloadName.getBytes("UTF-8"), "ISO-8859-1");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.setHeader("Content-Disposition", "attachment;fileName=\"" + downloadName + "\"");
			ExportExcel<NoLimited> ex = new ExportExcel<NoLimited>();
			String[] headers = { "号牌号码", "号牌种类 ", "车辆类型", "开始时间 ", "结束时间", "车辆状态", "描述" };
			OutputStream out;
			try {
				out = response.getOutputStream();
				ex.exportExcel(headers, list, out,"yyyy-MM-dd HH:mm:ss");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return null;
		
   }
  }
