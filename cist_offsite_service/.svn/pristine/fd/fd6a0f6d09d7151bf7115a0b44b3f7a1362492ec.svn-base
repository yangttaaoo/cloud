package com.cist.statistics.validdata.controller;
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
import com.cist.serviceconfig.unlimitedcar.model.ExportExcel;
import com.cist.statistics.validdata.model.DataCount;
import com.cist.statistics.validdata.model.DataStatic;
import com.cist.statistics.validdata.model.Series;
import com.cist.statistics.validdata.service.ValidDataService;

@RestController
@RequestMapping("/wxsj")
@SuppressWarnings("unchecked")
public class ValidDataController {
	@Autowired
	private ValidDataService service;
	/**
	 * 查询数据
	 * @param map
	 * @return
	 */
	@RequestMapping("/datapage")
	public PageInfo<DataCount> findData(@RequestBody HashMap<String, Object> map){
		try {
			PageInfo page = new PageInfo();
		    page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<DataCount>  count=(PageInfo<DataCount>) service.selectValidpageList(map,page);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	/**
	 * 折线统计图
	 * @return
	 */
	@RequestMapping("/statis")
    public Map<String,Object> index(@RequestBody Map<String, Object> maps){
		List<DataCount> list=service.selectData(maps);
		Map<String,Object> map=new HashMap<String,Object>();
		//分类赋值（横坐标）
		List<String> category=new ArrayList<String>();
		    for(int i=0;i<list.size();i++){
		    	category.add(list.get(i).getSssj());
		    }
		    map.put("category", category);
		    String[] legend=new String[3];
		    legend[0]="审核总数";
		    legend[1]="通过数量";
		    legend[2]="作废数量";
		    map.put("legend", legend);
		    //3.主要数据获取
		    List<Series> series=new ArrayList<Series>();
		    List<Long> serisData1=new ArrayList<Long>();  
	        List<Long> serisData2=new ArrayList<Long>();  
	        List<Long> serisData3=new ArrayList<Long>();
	        for(DataCount ps:list){
	        	serisData1.add((long)ps.getShzs());
	        	serisData2.add((long)ps.getFstg());
	        	serisData3.add((long)ps.getFszf());
	        }
	        series.add(new Series("审核总数", "bar", serisData1));
	        series.add(new Series("通过数量", "bar", serisData2));
	        series.add(new Series("作废数量", "bar", serisData3));
	        map.put("series", series);
		return map;    	
    }
	/**
	 * 折线效率统计图
	 * @param maps
	 * @return
	 */
	@RequestMapping("/bar")
    public Map<String,Object> getBar(@RequestBody Map<String, Object> maps){
		List<DataCount> list=service.selectData(maps);
		Map<String,Object> map=new HashMap<String,Object>();
		//分类赋值（横坐标）
		List<String> category=new ArrayList<String>();
		    for(int i=0;i<list.size();i++){
		    	category.add(list.get(i).getSssj());
		    }
		    map.put("category", category);
		    String[] legend=new String[1];
		    legend[0]="有效比例";
		    map.put("legend", legend);
		    //3.主要数据获取
		    List<Series> series=new ArrayList<Series>();
		    List<Long> serisData1=new ArrayList<Long>();  
	        for(DataCount ps:list){
	        	serisData1.add(ps.getBai());
	        }
            series.add(new Series("有效比例", "line", serisData1));
	        map.put("series", series);	 
		return map;    	
    }
	
	  /**
	    * 导出
	    */
	   @RequestMapping(value = "/downloadExcle")
		public String downloadExcle(@RequestParam HashMap<String, Object> map, HttpServletResponse response,
				HttpServletRequest request) {
			   List<DataStatic> list = service.selectDatas(map);
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
				ExportExcel<DataStatic> ex = new ExportExcel<DataStatic>();
				String[] headers = { "开始时间", "审核总数 ", "复审通过", "复审作废 ", "审核效率" };
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
