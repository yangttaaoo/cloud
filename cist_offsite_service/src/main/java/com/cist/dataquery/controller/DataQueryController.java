package com.cist.dataquery.controller;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.dataexport.util.UrlFilesToZip;
import com.cist.dataquery.model.Excels;
import com.cist.dataquery.model.Oeuser;
import com.cist.dataquery.model.Tbl_Log;
import com.cist.dataquery.model.Tbl_offe_cate;
import com.cist.dataquery.service.DataQueryService;
import com.cist.frame.page.PageInfo;
import com.cist.redinfo.model.Sys_frm_code;
import com.cist.serviceconfig.unlimitedcar.model.ExportExcel;

@RestController
@RequestMapping("/query")
@SuppressWarnings("unchecked")
public class DataQueryController {
	@Resource
	private DataQueryService service;



	@RequestMapping("/findData")
	public PageInfo<Oeuser> findData(@RequestBody HashMap<String, Object> map) {
		try {
			String sbbh=map.get("sbbh").toString();
			if(null!=sbbh&&sbbh!="") {
				sbbh=sbbh.substring(1, sbbh.length()-1);

				if(!sbbh.equals("")) {
					String sbb[]=sbbh.split(",");
					map.put("sbbh", sbb);
				}else {
					map.put("sbbh", null);
				}				
			}	
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
	 * 查询违法行为
	 */
	@RequestMapping("/selectwf")
	public Tbl_offe_cate selectwf(@RequestBody HashMap<String,Object> map){
		Tbl_offe_cate  wf=service.selectwf(map);
		return wf;
	}
	@RequestMapping(value="selectOne")
	public Map<String,Object> selectOne(@RequestBody HashMap<String,Object> map,HttpServletRequest request) {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		PageInfo<Oeuser> selectByCondition = findData(map);
//		modelMap.put("tboc_name",selectByCondition.getList().get(0).getWfxw());//根据违法行为违法记分等信息
		//modelMap.put("tblOffeCate", service.selectwf(map));//违法记分信息
		modelMap.put("list",selectByCondition);
		return modelMap;
	}
	@RequestMapping("/log")
	public List<Tbl_Log> selectLog(@RequestBody HashMap<String,Object> map){
		List<Tbl_Log>   log=service.selectLog(map);
		return log;
	}

	@RequestMapping(value = "/downloadlist")
	public List<Excels> downloadList(@RequestParam HashMap<String, Object> map){
		try {
			List<Excels> list = service.selectAll(map);
			return list;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/** 导出
	 */
	@RequestMapping(value = "/downloadExcle")
	public String downloadExcle(@RequestParam HashMap<String, Object> map, HttpServletResponse response,
			HttpServletRequest request) {
		List<Excels> list = downloadList(map);

		response.reset();
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		// 解决不同浏览器excle包名字含有中文时乱码的问题
		String downloadName = "违法数据查询数据.xls";
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
		ExportExcel<Excels> ex = new ExportExcel<Excels>();
		String[] headers = { "号牌号码", "号牌种类 ", "违法行为", "违法地点 ", "采集单位", "违法时间", "审核状态" };
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

	

	
	/**
	 * 基础数据
	 */
	@RequestMapping("/index")
	public List<Sys_frm_code> index(String fct_code) {
		List<Sys_frm_code>  sys=service.selectHpzl(fct_code);
		return sys;
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
								new ZipEntry(format + "/" + map.get("wfdz")==null?"未知":map.get("wfdz") + "(" +map.get("kkbh")==null?"未知":map.get("kkbh")
										+ ")" + "/" + map.get("sbbh")==null?"未知":map.get("sbbh")+ "/" +  map.get("wfxw")==null?"未知":map.get("wfxw")
										+ "/" + map.get("hphm")==null?"未知":map.get("hphm") + "/" + oneFile.substring(21)));

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
