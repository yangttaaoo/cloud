package com.cist.dataexport.controller;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.dataexport.model.Depart_info;
import com.cist.dataexport.service.DataExportService;
import com.cist.dataexport.util.UrlFilesToZip;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.CDirectionInfo;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.offsite.invalidtrial.service.InvalidTrialService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("dataexport")
public class DataExportController {

	@Autowired
	DataExportService service;
	@Autowired
	InvalidTrialService Inservice;
	
	
	/**
	 * 无效数据审核首页
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping("index")
	public Map<String,Object> index(Map<String, Object> map, HttpServletRequest request) {
		/*
		 * map.put("plateTypeList", pService.plateTypeList());
		 * map.put("tblOffeCateList", pService.tblOffeCateList());
		 */
		map.put("cDirectionInfo", service.selectCDirectionInfo());
		return map;
	}
	/**
	 * 川外违法数据多条件查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="dataexportlist")
	public PageInfo<TblOffeEvdiInfo> dataExportList(@RequestBody HashMap<String,Object> map) {
		try{	
			ArrayList sbbh=(ArrayList)map.get("sbbh");
			//设备编号多选编号分隔数组用作查询
			if(sbbh.size()>0)
			{
					map.put("list", sbbh);
			}
		PageInfo pinfo = new PageInfo();
		    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<TblOffeEvdiInfo> pageinfo = (PageInfo<TblOffeEvdiInfo>)service.dataExportListpageList(map,pinfo);
			return pageinfo;
			}catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	/**
	 * 查询川外违法数据详情
	 * 
	 * @param tblOffeEvdiInfo
	 *            查询条件
	 * @return TblOffeEvdiInfo
	 */
	@RequestMapping(value = "selectBywfxw")
	public Map<String,Object> selectNextByWfpk(@RequestBody HashMap<String, Object> map) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("tblOffeCate", Inservice.selectByWfxw(map));//违法记分信息
		return modelMap;

	}
	/**
	 * 查询川外违法数据详情
	 * @param tblOffeEvdiInfo 查询条件
	 * @return TblOffeEvdiInfo
	 */
	@RequestMapping(value="selectbywfpk")
	public TblOffeEvdiInfo selectByWfpk(@RequestBody TblOffeEvdiInfo tblOffeEvdiInfo) {
		
	    	return service.selectByWfpk(tblOffeEvdiInfo);
		
	}
	
	/**
	 * 查询将要导出到excle的数据
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="exportexclelist")
	public List<TblOffeEvdiInfo> exportExcleList(@RequestParam HashMap<String,Object> map) {
		try{	
			List<TblOffeEvdiInfo> exportExcleList = service.exportZipList(map);
			return exportExcleList;
			}catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	/**
	 * 查询方向信息
	 * @return  Tbl_offe_cate
	 */
	@RequestMapping(value="selectCDirectionInfo")
	public List<CDirectionInfo> selectByFxbh () {
		return service.selectCDirectionInfo();
	}
	/**
	 * 更新导出的数据状态
	 * @return  Integer
	 */
	@RequestMapping(value="updateShbz")
	public Integer updateShbz(@RequestParam HashMap<String,Object> map){
		return service.updateShbz(map);
		
	}
	/**
	 * 下载信息的压缩包
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value = "/downloadFiles")
	public void downloadFiles(@RequestBody  HashMap<String,Object> map,HttpServletRequest request,
			HttpServletResponse response) {
		List<TblOffeEvdiInfo> exportExcleList = exportExcleList(map);
//		if(exportExcleList.size()<1)
//		{
//			return "{\"result\":\"暂无数据\"}";
//		}
		try {
			// 获取当前时间当做文件夹名
			Date da = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_SS");// 格式化日期
			int rd = (int) (Math.random() * 1000);// 第一层文件夹名的末尾的随机数
			String format = sf.format(da) + "_" + rd;// 时间文件名结尾加三位随机数

			// 控制文件名编码
			// 响应头的设置
			response.reset();
			response.setCharacterEncoding("utf-8");
			response.setContentType("multipart/form-data");

			// 设置压缩包的名字
			// 解决不同浏览器压缩包名字含有中文时乱码的问题
			String downloadName = format + ".zip";
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
			// 设置压缩流：直接写入response，实现边压缩边下载
			ZipOutputStream zipos = null;
			zipos = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream()));
			zipos.setMethod(ZipOutputStream.DEFLATED); // 设置压缩方法
			ArrayList<String> urls = new ArrayList<String>();// 存放图片路径
			UrlFilesToZip s = new UrlFilesToZip();
			// 循环将文件写入压缩流
			DataOutputStream os = null;
			try {
				for (TblOffeEvdiInfo tblOffeEvdiInfo : exportExcleList) {
					if(tblOffeEvdiInfo.getWfzj1()!=null)
					{
						urls.add(tblOffeEvdiInfo.getWfzj1());
					}
					if(tblOffeEvdiInfo.getWfzj2()!=null)
					{
						urls.add(tblOffeEvdiInfo.getWfzj2());
					}
					if(tblOffeEvdiInfo.getWfzj3()!=null)
					{
						urls.add(tblOffeEvdiInfo.getWfzj3());
					}
					for (String oneFile : urls) {
						// 根据实体字段名生成压缩包内文件路径
						zipos.putNextEntry(
								new ZipEntry(format + "/" + tblOffeEvdiInfo.getWfdz() + "(" + tblOffeEvdiInfo.getKkbh()
										+ ")" + "/" + tblOffeEvdiInfo.getSbbh() + "/" + tblOffeEvdiInfo.getWfxw()
										+ "/" + tblOffeEvdiInfo.getHphm() + "/" + oneFile.substring(21)));

						byte[] bytes = s.getImageFromURL(oneFile);
						os = new DataOutputStream(zipos);
						os.write(bytes, 0, bytes.length);
						zipos.closeEntry();

					}
					urls.clear();// 操作完一条记录清除一次图片路径
				}
				// 关闭流
				zipos.close();
				os.flush();
				if(os!=null)
				{
					os.close();
				}
				
			} catch (IOException e) {
				// 此异常不打印，用户在下载途中点击取消中断流的输出会报此异常
			}
			// 更改已导出数据的状态为导出
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		 Integer updateShbz = updateShbz(map);
	}
	
	//违法地点树
	@RequestMapping("departinfo")
	public String departinfo() throws JsonProcessingException{
    //顶级部门 null
	List<Depart_info>	departinfo=service.depart_infolist(null);
	ObjectMapper mapper = new ObjectMapper();	
	List<Depart_info> list=departinfodg(departinfo);
	String json=mapper.writeValueAsString(getdiwfdidian(list));
	return json.substring(1, json.length()-1);
	}
	
	public List<HashMap<String, Object>> getdiwfdidian(List<Depart_info> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map=new HashMap();
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
	
	
	public List<Depart_info> departinfodg(List<Depart_info> departinfo){
		for (Depart_info depart_info : departinfo) {
			//安装地点
			depart_info.setChildren(service.Monitorpoint(depart_info.getDept_code()));
			//部门
			List<Depart_info> list= service.depart_infolist(depart_info.getDept_pk());
			for (Depart_info depart_info2 : list) {
				depart_info.getChildren().add(depart_info2);
			}
			depart_info.setChildren(depart_info.getChildren());
			if(null!=list){
				departinfodg(list);
			}
		}
		return departinfo;
	}
	//采集设备树
	@RequestMapping("acquisition")
	public String acquisition() throws JsonProcessingException{
    //顶级部门 null
	List<Depart_info>	departinfo=service.depart_infolist(null);
	ObjectMapper mapper = new ObjectMapper();
	
	List<Depart_info> list=acquisition(departinfo);
	String json=mapper.writeValueAsString(getjiaojishebei(list));
	
	return json.substring(1, json.length()-1);
	}
	public List<HashMap<String, Object>> getjiaojishebei(List<Depart_info> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map=new HashMap();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getTbmp_azdz());
			map.put("disableCheckbox", depart_info.getSelectable()==true?false:true);
			map.put("isLeaf", depart_info.getIsLeaf());
			if(null!=depart_info.getChildren()) {//下级
				map.put("children", getjiaojishebei(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	public List<Depart_info> acquisition(List<Depart_info> departinfo){
		for (Depart_info depart_info : departinfo) {
			//采集设备
			depart_info.setChildren(new ArrayList<Depart_info>());
			//部门
			List<Depart_info> list= service.depart_infolist(depart_info.getDept_pk());
			for (Depart_info depart_info2 : list) {
				depart_info.getChildren().add(depart_info2);
			}
			depart_info.setChildren(depart_info.getChildren());
			if(null!=list){
				acquisition(list);
			}
		}
		return departinfo;
	}
	
	/**
	 * 下载信息的压缩包
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value = "/downloadOne")
	public void downloadOne(@RequestParam  HashMap<String,Object> map,HttpServletRequest request,
			HttpServletResponse response) {
		List<TblOffeEvdiInfo> exportExcleList = exportExcleList(map);
		try {
			// 获取当前时间当做文件夹名
			Date da = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_SS");// 格式化日期
			int rd = (int) (Math.random() * 1000);// 第一层文件夹名的末尾的随机数
			String format = sf.format(da) + "_" + rd;// 时间文件名结尾加三位随机数

			// 控制文件名编码
			// 响应头的设置
			response.reset();
			response.setCharacterEncoding("utf-8");
			response.setContentType("multipart/form-data");

			// 设置压缩包的名字
			// 解决不同浏览器压缩包名字含有中文时乱码的问题
			String downloadName = format + ".zip";
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
			// 设置压缩流：直接写入response，实现边压缩边下载
			ZipOutputStream zipos = null;
			zipos = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream()));
			zipos.setMethod(ZipOutputStream.DEFLATED); // 设置压缩方法
			ArrayList<String> urls = new ArrayList<String>();// 存放图片路径
			UrlFilesToZip s = new UrlFilesToZip();
			// 循环将文件写入压缩流
			DataOutputStream os = null;
			try {
				for (TblOffeEvdiInfo selectExport : exportExcleList) {
					if(selectExport.getWfzj1()!=null)
					{
						urls.add(selectExport.getWfzj1());
					}
					if(selectExport.getWfzj2()!=null)
					{
						urls.add(selectExport.getWfzj2());
					}
					if(selectExport.getWfzj3()!=null)
					{
						urls.add(selectExport.getWfzj3());
					}
					for (String oneFile : urls) {
						// 根据实体字段名生成压缩包内文件路径
						zipos.putNextEntry(
								new ZipEntry(format + "/" + selectExport.getWfdz() + "(" + selectExport.getKkbh()
										+ ")" + "/" + selectExport.getSbbh() + "/" + selectExport.getWfxw()
										+ "/" + selectExport.getHphm() + "/" + oneFile.substring(21)));

						byte[] bytes = s.getImageFromURL(oneFile);
						os = new DataOutputStream(zipos);
						os.write(bytes, 0, bytes.length);
						zipos.closeEntry();
					}
					}
					urls.clear();// 操作完一条记录清除一次图片路径
				// 关闭流
				zipos.close();
				//os.flush();
				os.close();
			} catch (IOException e) {
				// 此异常不打印，用户在下载途中点击取消中断流的输出会报此异常
			}
			// 更改已导出数据的状态为导出
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * 无效数据单条数据查看
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="selectOne")
	public Map<String,Object> selectOne(@RequestBody HashMap<String,Object> map,HttpServletRequest request) {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		PageInfo<TblOffeEvdiInfo> selectByCondition = dataExportList(map);
		   modelMap.put("tboc_name",selectByCondition.getList()==null?null:selectByCondition.getList().get(0).getWfxwname());//根据违法行为违法记分等信息
		  modelMap.put("tblOffeCate", Inservice.selectByWfxw(modelMap));//违法记分信息
		  modelMap.put("list",selectByCondition);
//	      modelMap.put("cPlateTypeList",service.selectSysFrmCode("C001"));//号牌种类
//	      modelMap.put("tblOffeCateList", pService.tblOffeCateList());//违法行为
//	      modelMap.put("cPlateColorList", service.selectByCPlateColorInfo());//号牌颜色
//	      modelMap.put("cPlateKerisList", service.selectByCPlateKerisInfo());//号牌前两位
	
		return modelMap;
	}
	/**
	 * 下载信息的压缩包
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value = "/downloadFile")
	public void downloadFile(@RequestBody  HashMap<String,Object> map,HttpServletRequest request,
			HttpServletResponse response) {
//		TblOffeEvdiInfo selectExport = service.selectExport(map);
		try {
			// 获取当前时间当做文件夹名
			Date da = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_SS");// 格式化日期
			int rd = (int) (Math.random() * 1000);// 第一层文件夹名的末尾的随机数
			String format = sf.format(da) + "_" + rd;// 时间文件名结尾加三位随机数

			// 控制文件名编码
			// 响应头的设置
			response.reset();
			response.setCharacterEncoding("utf-8");
			response.setContentType("multipart/form-data");

			// 设置压缩包的名字
			// 解决不同浏览器压缩包名字含有中文时乱码的问题
			String downloadName = format + ".zip";
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
			// 设置压缩流：直接写入response，实现边压缩边下载
			ZipOutputStream zipos = null;
			zipos = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream()));
			zipos.setMethod(ZipOutputStream.DEFLATED); // 设置压缩方法
			ArrayList<String> urls = new ArrayList<String>();// 存放图片路径
			UrlFilesToZip s = new UrlFilesToZip();
			// 循环将文件写入压缩流
			DataOutputStream os = null;
			try {
				if(map.get("wfzj1")!=null)
				{
					urls.add(map.get("wfzj1").toString());
				}
				if(map.get("wfzj2")!=null)
				{
					urls.add(map.get("wfzj2").toString());
				}
				if(map.get("wfzj3")!=null)
				{
					urls.add(map.get("wfzj3").toString());
				}
					for (String oneFile : urls) {
						// 根据实体字段名生成压缩包内文件路径
						zipos.putNextEntry(
								new ZipEntry(format + "/" + map.get("wfdz")+ "(" +map.get("kkbh")
										+ ")" + "/" + map.get("sbbh")+ "/" +  map.get("wfxw")
										+ "/" + map.get("hphm")+ "/" + oneFile.substring(21)));

						byte[] bytes = s.getImageFromURL(oneFile);
						os = new DataOutputStream(zipos);
						os.write(bytes, 0, bytes.length);
						zipos.closeEntry();

					}
					urls.clear();// 操作完一条记录清除一次图片路径
				// 关闭流
				zipos.close();
				//os.flush();
				os.close();
			} catch (IOException e) {
				// 此异常不打印，用户在下载途中点击取消中断流的输出会报此异常
			}
			// 更改已导出数据的状态为导出
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
