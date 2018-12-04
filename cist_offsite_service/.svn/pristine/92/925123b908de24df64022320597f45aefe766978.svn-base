package com.cist.serviceconfig.imgnameconfig.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.SysDepartInfo;
import com.cist.serviceconfig.imgnameconfig.model.Sys_frm_code;
import com.cist.serviceconfig.imgnameconfig.model.TblDevTypeInfo;
import com.cist.serviceconfig.imgnameconfig.model.TblImgNameInfo;
import com.cist.serviceconfig.imgnameconfig.service.ImgNameConfigService;

@RestController
@RequestMapping("imgnameconfig")
public class ImgNameConfigController {
	@Autowired
	ImgNameConfigService service;
	

	/**
	 * 查询违法图片文件名配置模板
	 * 
	 * @return PageInfo<TblImgNameInfo>
	 */
	@RequestMapping(value ="list")
	public PageInfo<TblImgNameInfo> list(@RequestBody HashMap<String,Object> map) {
		PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<TblImgNameInfo> selectImgNamepageList = (PageInfo<TblImgNameInfo>)service.listpageList(map,pinfo);
		return  selectImgNamepageList;
	}
	/**
	 * 查询可选项
	 * 
	 * @return PageInfo<TblImgNameInfo>
	 */
	@RequestMapping(value ="selectKxx")
	public List<HashMap<String, Object>> selectKxz(@RequestBody HashMap<String,Object> map) {
		List<Sys_frm_code> selectKxx = service.selectKxx(map);
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Sys_frm_code sys_frm_code : selectKxx) {
			HashMap<String, Object> modelMap=new HashMap();
			modelMap.put("key", sys_frm_code.getFc_code());
			switch (sys_frm_code.getFc_code()) {
			case "HPHM":
				modelMap.put("exm", "川A12345");
				break;
			case "HPZL":
				modelMap.put("exm", "02");
				break;
			case "WFSJ":
				modelMap.put("exm", "20180807192020");
				break;
			case "WFJSSJ":
				modelMap.put("exm", "20180807192020");
				break;
			case "CLSD":
				modelMap.put("exm", "120");
				break;
			default:
				modelMap.put("exm", "160");
				break;
			}
			modelMap.put("title", sys_frm_code.getFc_name());
			listmap.add(modelMap);
		}
		return listmap;
	}
	/**
   	 * 违法图片文件名模板保存
   	 * @return PageInfo<TblImgNameInfo>
   	 */
	@RequestMapping(value ="save")
	public String save(@RequestBody HashMap<String,Object> map){
		 Integer save = service.save(map);
		 if(save==1)//1表示更新成功返回的行数
			{
				return "{\"result\":\"保存成功\"}";
			}
			else{
				return "{\"result\":\"保存失败\"}";
			}
		
	}
	/**
   	 * 违法图片文件名模板更新
   	 * @return PageInfo<TblImgNameInfo>
   	 */
	@RequestMapping(value ="update")
	public String update(@RequestBody HashMap<String,Object> map){
		 Integer update = service.update(map);
		 if(update==1)//1表示更新成功返回的行数
			{
				return "{\"result\":\"更新成功\"}";
			}
			else{
				return "{\"result\":\"更新失败\"}";
			}
		
	}
	/**
	 * 批量删除
	 * 
	 * @return Integer
	 */
	@RequestMapping(value ="delete")
	public String delete(@RequestParam("tbie_pk") String [] tbie_pk){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		modelMap.put("tbie_pk", tbie_pk);
		Integer delete = service.delete(modelMap);
		 if(delete>0)//1表示更新成功返回的行数
			{
				return "{\"result\":\"删除成功\"}";
			}
			else{
				return "{\"result\":\"删除失败\"}";
			}
		
	}
	
	/**
	 * 根据部门code查询部门名称
	 * 
	 * @return SysDepartInfo
	 */
	@RequestMapping(value ="selectDeptName")
	public SysDepartInfo selectDeptName(HashMap<String, Object> map) {
		return service.selectDeptName(map);
	}
	
	/**
	 * 时间测试
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping("dateTest")
	public Map<String,Object> dateTest(@RequestBody Map<String, Object> map) {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();
		String sjgs=(String) map.get("sjgs");
		try{
		SimpleDateFormat sf=new SimpleDateFormat(sjgs);
		Date date=new Date();
		String format = sf.format(date);
		modelMap.put("formatdate", format);
		modelMap.put("format",true);//标识时间格式转换是否成功
		return modelMap;
		}catch (Exception e) {
			modelMap.put("format",false);
			return modelMap;
		}
		
	}
	/**
	 * 查询图片文件名配置设备类型下拉所有
	 * 
	 * @return TblDevTypeInfo
	 */
	@RequestMapping("selectSblxList")
	public Map<String,Object> selectSblxList(@RequestBody HashMap<String, Object> map) {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();
		List<Sys_frm_code> selectSblxList = service.selectSblxList(map);
		modelMap.put("TblDevTypeList",selectSblxList );
		return modelMap;
	}
}
