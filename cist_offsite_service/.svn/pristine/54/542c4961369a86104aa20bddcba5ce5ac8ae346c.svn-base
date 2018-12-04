package com.cist.statistics.miandata.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.personalstats.model.PersonalStats;
import com.cist.personalstats.util.ExportExcel;
import com.cist.statistics.miandata.model.DataUpload;
import com.cist.statistics.miandata.service.DataUploadService;
import com.cist.statistics.validdata.model.Series;

@RestController
@RequestMapping("mian")
public class DataUploadController {
	
	@Autowired
	private DataUploadService uploadService;
	
	@RequestMapping("tolist")
	public PageInfo<DataUpload> queryList(@RequestBody HashMap<String, Object> map){
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<DataUpload> pageInfo = (PageInfo<DataUpload>)uploadService.querypageList(map,info);
		return pageInfo;
	}
	
/*	@RequestMapping("tomap")
	public List<DataUpload> queryUpload(){
		return uploadService.queryUpload();
	}
	
	@RequestMapping("toexcel")
	public List<DataUpload> selectExcel(@RequestParam HashMap<String, Object> map){
		return uploadService.selectExcel(map);
	}
	*/
	
	/**
	 * 统计图
	 * @return
	 */
	@RequestMapping("tomap")
    public Map<String,Object> index(@RequestBody Map<String, Object> maps){
		List<DataUpload> list=uploadService.queryUpload(maps);
		Map<String,Object> map=new HashMap<String,Object>();
		//分类赋值（横坐标）
		List<String> category=new ArrayList<String>();
		    for(int i=0;i<list.size();i++){
		    	category.add(list.get(i).getSj());
		    }
		    map.put("category", category);
		    String[] legend=new String[3];
		    legend[0]="上传成功";
		    legend[1]="上传失败";
		    legend[2]="上传总数";
		    map.put("legend", legend);
		    //3.主要数据获取
		    List<Series> series=new ArrayList<Series>();
		    List<Long> serisData1=new ArrayList<Long>();  
	        List<Long> serisData2=new ArrayList<Long>();  
	        List<Long> serisData3=new ArrayList<Long>();
	        for(DataUpload ps:list){
	        	serisData1.add((long)ps.getSccg());
	        	serisData2.add((long)ps.getScsb());
	        	serisData3.add((long)ps.getSczs());
	        }
	        series.add(new Series("上传成功", "bar", serisData1));
	        series.add(new Series("上传失败", "bar", serisData2));
	        series.add(new Series("上传总数", "bar", serisData3));
	        map.put("series", series);
		return map;    	
    }
	
	
	
	
	 /**
	    * 导出
	    */
	   @RequestMapping(value="toexcel")
		public String downloadExcle(@RequestParam HashMap<String, Object> map, HttpServletResponse response,
				HttpServletRequest request) {
			   List<DataUpload> list = uploadService.selectExcel(map);
				response.reset();
				response.setCharacterEncoding("utf-8");
				response.setContentType("multipart/form-data");
				// 解决不同浏览器excle包名字含有中文时乱码的问题
				String downloadName = "数据有效率统计.xls";
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
				ExportExcel<DataUpload> ex = new ExportExcel<DataUpload>();
				String[] headers = { "上传时间", "上传成功 ", "上传失败", "上传总数" };
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
