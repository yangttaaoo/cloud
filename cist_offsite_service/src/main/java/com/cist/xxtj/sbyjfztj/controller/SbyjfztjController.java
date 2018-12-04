package com.cist.xxtj.sbyjfztj.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.xxtj.sbyjfztj.model.TBL_OFFE_VIO_ALARM_STAT;
import com.cist.xxtj.sbyjfztj.model.Wfddzpnum;
import com.cist.xxtj.sbyjfztj.model.Wfzpqs;
import com.cist.xxtj.sbyjfztj.service.SbyjfztjService;
import com.cist.xxtj.sbyjfztj.util.TjUtil;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/sbyjfztj")
public class SbyjfztjController {
	@Autowired
	private SbyjfztjService service;
	/**
	 * 页面加载时数据的加载
	 * @param map
	 * @return
	 */
	@RequestMapping("index")
	public HashMap<String,Object> index(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("kssj", format.format(TjUtil.getDayBegin()));
		map.put("jssj", format.format(TjUtil.getDayEnd()));
		List<TBL_OFFE_VIO_ALARM_STAT> sbyjyztj = service.querysbyjtj(map);
		HashMap<String,Object> map1 = null;
		for (int i = 0; i < sbyjyztj.size(); i++) {
			map1 = new HashMap<String,Object>();
			calendar.setTime(sbyjyztj.get(i).getTjsj());
			calendar.add(Calendar.DATE, - 7);
			map1.put("tjnf", calendar.get(Calendar.YEAR));
			map1.put("tjyf", (calendar.get(Calendar.MONTH) + 1));
			map1.put("tjrq", calendar.get(Calendar.DAY_OF_MONTH));
			map1.put("tjxs", sbyjyztj.get(i).getTjxs());
			Integer tzb = service.querytzb(map1);
			sbyjyztj.get(i).setSzcjsl(tzb);
		}
		ModelMap.put("sbyjyztj",sbyjyztj);//设备预警阈值统计信息
		ModelMap.put("wfddyjpm",service.querywfddyjpm(map));//违法地点预警排名
		ModelMap.put("yjwfdd", service.queryyjwfdd(map));//查询预警违法地点
		ModelMap.put("sbinfo", service.querysbinfo(map));//查询设备相关信息
		return ModelMap;
	}
	/**
	 * 按日期查询数据
	 * rqlx 日期类型 
	 * 1：当日 2：本周 3：本月 4：全年
	 * @param map
	 * @return
	 */
	@RequestMapping("arqcx")
	public HashMap<String,Object> arqcx(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		
		if("4".equals(map.get("rqlx").toString())) {//按全年统计
			map.put("kssj", TjUtil.getNowYear()+"-01-01 00:00:00");//本年开始时间
			map.put("jssj", TjUtil.getNowYear()+"-12-31 23:59:59");//本年结束时间
		}else if("3".equals(map.get("rqlx").toString())) {//按本月统计
			map.put("kssj", format.format(TjUtil.getBeginDayOfMonth())+" 00:00:00");//本月开始时间
			map.put("jssj", format.format(TjUtil.getEndDayOfMonth())+" 23:59:59");//当月结束时间
		}else if("2".equals(map.get("rqlx").toString())) {//按本周统计
			map.put("kssj", format.format(TjUtil.getBeginDayOfWeek())+" 00:00:00");//当周开始时间
			map.put("jssj", format.format(TjUtil.getEndDayOfWeek())+" 23:59:59");//当周结束时间
		}else {//按当日统计
			map.put("kssj", format.format(TjUtil.getDayBegin())+" 00:00:00");//当天开始时间
			map.put("jssj", format.format(TjUtil.getDayEnd())+" 23:59:59");//当天结束时间
		}
		List<TBL_OFFE_VIO_ALARM_STAT> sbyjyztj = service.querysbyjtj(map);
		HashMap<String,Object> map1 = null;
		for (int i = 0; i < sbyjyztj.size(); i++) {
			map1 = new HashMap<String,Object>();
			calendar.setTime(sbyjyztj.get(i).getTjsj());
			calendar.add(Calendar.DATE, - 7);
			map1.put("tjnf", calendar.get(Calendar.YEAR));
			map1.put("tjyf", (calendar.get(Calendar.MONTH) + 1));
			map1.put("tjrq", calendar.get(Calendar.DAY_OF_MONTH));
			map1.put("tjxs", sbyjyztj.get(i).getTjxs());
			Integer tzb = service.querytzb(map1);
			sbyjyztj.get(i).setSzcjsl(tzb);
		}
		ModelMap.put("sbyjyztj",sbyjyztj);//设备预警阈值统计信息
		ModelMap.put("wfddyjpm",service.querywfddyjpm(map));//违法地点预警排名
		ModelMap.put("yjwfdd", service.queryyjwfdd(map));//查询预警违法地点
		return ModelMap;
	}
	/**
	 * 违法抓拍统计
	 * @param map
	 * @return
	 */
	@RequestMapping("wfzp")
	public HashMap<String,Object> wfzp(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		
		if(map.get("sbdd")!=null) {
			List<Wfddzpnum> wfzplist = service.querynumbywfdd(map);//根据违法地点查询一周抓拍量
			ModelMap.put("yzwfzpl", wfzplist);//一周违法抓拍量
		}
		map.put("kssj", format.format(TjUtil.getBeginDayOfWeek())+" 00:00:00");//当周开始时间
		map.put("jssj", format.format(TjUtil.getEndDayOfWeek())+" 23:59:59");//当周结束时间
		ModelMap.put("zppm", service.queryzppm(map));//一周违法抓拍量
		List<TBL_OFFE_VIO_ALARM_STAT> sbyjyztj = service.querysbyjtj(map);
		HashMap<String,Object> map1 = null;
		for (int i = 0; i < sbyjyztj.size(); i++) {
			map1 = new HashMap<String,Object>();
			calendar.setTime(sbyjyztj.get(i).getTjsj());
			calendar.add(Calendar.DATE, - 7);
			map1.put("tjnf", calendar.get(Calendar.YEAR));
			map1.put("tjyf", (calendar.get(Calendar.MONTH) + 1));
			map1.put("tjrq", calendar.get(Calendar.DAY_OF_MONTH));
			map1.put("tjxs", sbyjyztj.get(i).getTjxs());
			Integer tzb = service.querytzb(map1);
			sbyjyztj.get(i).setSzcjsl(tzb);
		}
		ModelMap.put("sbyjyztj",sbyjyztj);//设备预警阈值统计信息
		return ModelMap;
	}
	
	

	@RequestMapping("wfzpqs")
	public HashMap<String,Object> wfzpslqs(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH");
		Calendar calendar = Calendar.getInstance();
		List<Wfzpqs> wfzpqs =service.querywfzpqs(map);//违法地点预警列表
		List<Wfzpqs> wfzpqslist =service.querywfzpqstable(map);
		for (int i = 0; i < wfzpqs.size(); i++) {
			if(wfzpqs.get(i).getTjsj()!=null) {
				calendar.setTime(wfzpqs.get(i).getTjsj());
				calendar.add(Calendar.DATE, -7);
				map.put("sj", format1.format(calendar.getTime()));
				TBL_OFFE_VIO_ALARM_STAT stat = service.queryszcjslbysj(map);//查询上周同一时间的最后正常采集数量
				if(stat==null) {
					wfzpqs.get(i).setSzzccjsl(0);
				}else {
					wfzpqs.get(i).setSzzccjsl(stat.getZccjsl());
				}
			}else {
				wfzpqs.get(i).setSzzccjsl(0);
			}
			
		}
		ModelMap.put("wfzpqs", wfzpqs);
		
		for (int i = 0; i < wfzpqslist.size(); i++) {
			calendar.setTime(wfzpqslist.get(i).getTjsj());
			calendar.add(Calendar.DATE, -7);
			map.put("sj", format1.format(calendar.getTime()));
			TBL_OFFE_VIO_ALARM_STAT stat = service.queryszcjslbysj(map);//查询上周同一时间的最后正常采集数量
			if(stat==null) {
				wfzpqslist.get(i).setSzzccjsl(0);
			}else {
				wfzpqslist.get(i).setSzzccjsl(stat.getZccjsl());
			}
		}
		ModelMap.put("wfzpqslist", wfzpqslist);
		ModelMap.put("wfzppm", service.querywfzppm(map));
		return ModelMap;
	}
	
	/**
	 * 查询预警违法地点
	 * rqlx 日期类型 
	 * 1：当日 2：本周 3：本月 4：全年
	 * @param map
	 * @return
	 */
	@RequestMapping("queryyjwfdd")
	public HashMap<String,Object> queryyjwfdd(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		
		if("4".equals(map.get("rqlx").toString())) {//按全年统计
			map.put("kssj", TjUtil.getNowYear()+"-01-01 00:00:00");//本年开始时间
			map.put("jssj", TjUtil.getNowYear()+"-12-31 23:59:59");//本年结束时间
		}else if("3".equals(map.get("rqlx").toString())) {//按本月统计
			map.put("kssj", format.format(TjUtil.getBeginDayOfMonth())+" 00:00:00");//本月开始时间
			map.put("jssj", format.format(TjUtil.getEndDayOfMonth())+" 23:59:59");//当月结束时间
		}else if("2".equals(map.get("rqlx").toString())) {//按本周统计
			map.put("kssj", format.format(TjUtil.getBeginDayOfWeek())+" 00:00:00");//当周开始时间
			map.put("jssj", format.format(TjUtil.getEndDayOfWeek())+" 23:59:59");//当周结束时间
		}else {//按当日统计
			map.put("kssj", format.format(TjUtil.getDayBegin())+" 00:00:00");//当天开始时间
			map.put("jssj", format.format(TjUtil.getDayEnd())+" 23:59:59");//当天结束时间
		}
		List<TBL_OFFE_VIO_ALARM_STAT> sbyjyztj = service.querysbyjtj(map);
		HashMap<String,Object> map1 = null;
		for (int i = 0; i < sbyjyztj.size(); i++) {
			map1 = new HashMap<String,Object>();
			calendar.setTime(sbyjyztj.get(i).getTjsj());
			calendar.add(Calendar.DATE, - 7);
			map1.put("tjnf", calendar.get(Calendar.YEAR));
			map1.put("tjyf", (calendar.get(Calendar.MONTH) + 1));
			map1.put("tjrq", calendar.get(Calendar.DAY_OF_MONTH));
			map1.put("tjxs", sbyjyztj.get(i).getTjxs());
			Integer tzb = service.querytzb(map1);
			sbyjyztj.get(i).setSzcjsl(tzb);
		}
		ModelMap.put("sbyjyztj",sbyjyztj);//设备预警阈值统计信息
		ModelMap.put("yjwfdd", service.queryyjwfdd(map));//查询预警违法地点
		return ModelMap;
	}
	
	/**
	 * 违法地点预警排名
	 * @param map
	 * @return
	 */
	@RequestMapping("wfddyjpm")
	public HashMap<String,Object> queryyjwfd(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		ModelMap.put("wfddyjpm",service.querywfddyjpm(map));//违法地点预警排名
		return ModelMap;
	}
	/**
	 * 导出excel表格
	 * @param map
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("excel")
	public void export(@RequestBody HashMap<String,Object> map,
			HttpServletResponse response) throws IOException, ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		String tablename = map.get("tablename")==null?"未知":map.get("tablename").toString();
		// 声明一个工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = wb.createSheet(tablename);
        // 生成一种样式
        HSSFCellStyle style = wb.createCellStyle();
        
        style.setAlignment(HorizontalAlignment.CENTER);//居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);//垂直
        
     // 生成一种字体
        HSSFFont font = wb.createFont();
        // 设置字体
        font.setFontName("微软雅黑");
        // 设置字体大小
        font.setFontHeightInPoints((short) 12);
        // 字体加粗
        font.setBold(true);
        // 在样式中引用这种字体
        style.setFont(font);
        
        HSSFCellStyle style2 = wb.createCellStyle();
        HSSFFont font2 = wb.createFont();
        // 设置字体
        font2.setFontName("微软雅黑");
        // 设置字体大小
        font2.setFontHeightInPoints((short) 12);
        style2.setAlignment(HorizontalAlignment.CENTER);//居中
        style2.setVerticalAlignment(VerticalAlignment.CENTER);//垂直
        style2.setWrapText(true); 
        
        // 在样式2中引用这种字体
        style2.setFont(font2);
        
        if("1".equals(map.get("table"))) {//违法地点预警列表
        //判断是按照什么类型查询的 
        	
    		Calendar calendar = Calendar.getInstance();
    		
    		if("4".equals(map.get("rqlx").toString())) {//按全年统计
    			map.put("kssj", TjUtil.getNowYear()+"-01-01 00:00:00");//本年开始时间
    			map.put("jssj", TjUtil.getNowYear()+"-12-31 23:59:59");//本年结束时间
    		}else if("3".equals(map.get("rqlx").toString())) {//按本月统计
    			map.put("kssj", format2.format(TjUtil.getBeginDayOfMonth())+" 00:00:00");//本月开始时间
    			map.put("jssj", format2.format(TjUtil.getEndDayOfMonth())+" 23:59:59");//当月结束时间
    		}else if("2".equals(map.get("rqlx").toString())) {//按本周统计
    			map.put("kssj", format2.format(TjUtil.getBeginDayOfWeek())+" 00:00:00");//当周开始时间
    			map.put("jssj", format2.format(TjUtil.getEndDayOfWeek())+" 23:59:59");//当周结束时间
    		}else {//按当日统计
    			map.put("kssj", format2.format(TjUtil.getDayBegin())+" 00:00:00");//当天开始时间
    			map.put("jssj", format2.format(TjUtil.getDayEnd())+" 23:59:59");//当天结束时间
    		}
    		List<TBL_OFFE_VIO_ALARM_STAT> sbyjyztj = service.querysbyjtj(map);
    		HashMap<String,Object> map1 = null;
    		for (int i = 0; i < sbyjyztj.size(); i++) {
    			map1 = new HashMap<String,Object>();
    			calendar.setTime(sbyjyztj.get(i).getTjsj());
    			calendar.add(Calendar.DATE, - 7);
    			map1.put("tjnf", calendar.get(Calendar.YEAR));
    			map1.put("tjyf", (calendar.get(Calendar.MONTH) + 1));
    			map1.put("tjrq", calendar.get(Calendar.DAY_OF_MONTH));
    			map1.put("tjxs", sbyjyztj.get(i).getTjxs());
    			Integer tzb = service.querytzb(map1);
    			sbyjyztj.get(i).setSzcjsl(tzb);
    		}
    		
        	
        //表头
          String[] excelHeader = {"时间","地点","采集数量","预警最大阈值","预警最小阈值","预警类型","最后一次正常数量","增长率","周同比"};
          HSSFRow row = sheet.createRow(0);
          for (int k = 0; k < excelHeader.length; k++) {
          	sheet.autoSizeColumn(k, true);// 根据字段长度自动调整列的宽度
              HSSFCell cell = row.createCell(k);
              cell.setCellValue(excelHeader[k]);
              cell.setCellStyle(style);
  			}
          //表中数据
          for (int i = 0; i < sbyjyztj.size(); i++) {
        	  HSSFRow datarow = sheet.createRow(i+1);
        	  for (int k = 0; k < excelHeader.length; k++) {
        		  String value="";//值
        		  if(k==0) {
//        			 value=sbyjyztj.get(i).getTjsj()+"";//时间
        			 value=format.format(sbyjyztj.get(i).getTjsj());//时间
        		  }else if(k==1) {
        			  value=sbyjyztj.get(i).getSbdd();//地点
        		  }else if(k==2) {
        			  value=sbyjyztj.get(i).getCjsl()+"";//采集数量
        		  }else if(k==3) {
        			  value=sbyjyztj.get(i).getSbcjmax()+"";//预警最大阈值
        		  }else if(k==4) {
        			  value=sbyjyztj.get(i).getSbcjmin()+"";//预警最小阈值
        		  }else if(k==5) {//预警类型 
        			  if(sbyjyztj.get(i).getCjsl()-sbyjyztj.get(i).getSbcjmax()>0) {
        				  value="超出最大阈值"; 
        			  }else if(sbyjyztj.get(i).getCjsl()-sbyjyztj.get(i).getSbcjmin()<0) {
        				  value="低于最小阈值"; 
        			  }else {
        				  value="正常";
        			  }
        		  }else if(k==6) {
        			  value=sbyjyztj.get(i).getZccjsl()+"";//最后一次正常数量
        		  }else if(k==7) {
        			  value=(double)((sbyjyztj.get(i).getCjsl()-sbyjyztj.get(i).getZccjsl())/sbyjyztj.get(i).getZccjsl())*100+"%";//增长率 
        		  }else if(k==8) {
        			  value=(double)((sbyjyztj.get(i).getCjsl()-(sbyjyztj.get(i).getSzcjsl()==null?0:sbyjyztj.get(i).getSzcjsl()))/sbyjyztj.get(i).getCjsl())*100+"%";//周同比 
        		  }
                	sheet.autoSizeColumn(k, true);// 根据字段长度自动调整列的宽度
                    HSSFCell cell = datarow.createCell(k);
                    cell.setCellValue(value);
                    cell.setCellStyle(style);
        			}
          }
          
          
        }else if("2".equals(map.get("table"))) {//违法抓拍数量列表
        	
    		Calendar calendar = Calendar.getInstance();
        	map.put("kssj", format2.format(TjUtil.getBeginDayOfWeek())+" 00:00:00");//当周开始时间
    		map.put("jssj", format2.format(TjUtil.getEndDayOfWeek())+" 23:59:59");//当周结束时间
    		List<TBL_OFFE_VIO_ALARM_STAT> sbyjyztj = service.querysbyjtj(map);
    		HashMap<String,Object> map1 = null;
    		for (int i = 0; i < sbyjyztj.size(); i++) {
    			map1 = new HashMap<String,Object>();
    			calendar.setTime(sbyjyztj.get(i).getTjsj());
    			calendar.add(Calendar.DATE, - 7);
    			map1.put("tjnf", calendar.get(Calendar.YEAR));
    			map1.put("tjyf", (calendar.get(Calendar.MONTH) + 1));
    			map1.put("tjrq", calendar.get(Calendar.DAY_OF_MONTH));
    			map1.put("tjxs", sbyjyztj.get(i).getTjxs());
    			Integer tzb = service.querytzb(map1);
    			sbyjyztj.get(i).setSzcjsl(tzb);
    		}
    		
        	  String[] excelHeader = {"日期","采集数量","预警最大阈值","预警最小阈值","预警类型","最后一次正常数量","增长率","周同比"};
              //表头
              HSSFRow row = sheet.createRow(0);
              for (int k = 0; k < excelHeader.length; k++) {
              	sheet.autoSizeColumn(k, true);// 根据字段长度自动调整列的宽度
                  HSSFCell cell = row.createCell(k);
                  cell.setCellValue(excelHeader[k]);
                  cell.setCellStyle(style);
      			}
              
              //表中数据
              for (int i = 0; i < sbyjyztj.size(); i++) {
            	  HSSFRow datarow = sheet.createRow(i+1);
            	  for (int k = 0; k < excelHeader.length; k++) {
            		  String value="";//值
            		  if(k==0) {
//            			 value=sbyjyztj.get(i).getTjsj()+"";//日期
            			  value=format.format(sbyjyztj.get(i).getTjsj());//日期
            		  }else if(k==1) {
            			  value=sbyjyztj.get(i).getCjsl()+"";//采集数量
            		  }else if(k==2) {
            			  value=sbyjyztj.get(i).getSbcjmax()+"";//预警最大阈值
            		  }else if(k==3) {
            			  value=sbyjyztj.get(i).getSbcjmin()+"";//预警最小阈值
            		  }else if(k==4) {//预警类型 
            			  if(sbyjyztj.get(i).getCjsl()-sbyjyztj.get(i).getSbcjmax()>0) {
            				  value="超出最大阈值"; 
            			  }else if(sbyjyztj.get(i).getCjsl()-sbyjyztj.get(i).getSbcjmin()<0) {
            				  value="低于最小阈值"; 
            			  }else {
            				  value="正常";
            			  }
            		  }else if(k==5) {
            			  value=sbyjyztj.get(i).getZccjsl()+"";//最后一次正常数量
            		  }else if(k==6) {
            			  value=(double)((sbyjyztj.get(i).getCjsl()-sbyjyztj.get(i).getZccjsl())/sbyjyztj.get(i).getZccjsl())*100+"%";//增长率 
            		  }else if(k==7) {
            			  value=(double)((sbyjyztj.get(i).getCjsl()-(sbyjyztj.get(i).getSzcjsl()==null?0:sbyjyztj.get(i).getSzcjsl()))/sbyjyztj.get(i).getCjsl())*100+"%";//周同比 
            		  }
                    	sheet.autoSizeColumn(k, true);// 根据字段长度自动调整列的宽度
                        HSSFCell cell = datarow.createCell(k);
                        cell.setCellValue(value);
                        cell.setCellStyle(style);
            			}
              }
        }else {
        	
    		Calendar calendar = Calendar.getInstance();
    		List<Wfzpqs> wfzpqslist =service.querywfzpqstable(map);
    		
    		for (int i = 0; i < wfzpqslist.size(); i++) {
    			calendar.setTime(wfzpqslist.get(i).getTjsj());
    			calendar.add(Calendar.DATE, -7);
    			map.put("sj", format1.format(calendar.getTime()));
    			TBL_OFFE_VIO_ALARM_STAT stat = service.queryszcjslbysj(map);//查询上周同一时间的最后正常采集数量
    			if(stat==null) {
    				wfzpqslist.get(i).setSzzccjsl(0);
    			}else {
    				wfzpqslist.get(i).setSzzccjsl(stat.getZccjsl());
    			}
    		}
        	 String[] excelHeader = {"时间","采集数量","最后一次正常数量","上周相同星期数量","增长率","周同比"};
             //表头
             HSSFRow row = sheet.createRow(0);
             for (int k = 0; k < excelHeader.length; k++) {
             	sheet.autoSizeColumn(k, true);// 根据字段长度自动调整列的宽度
                 HSSFCell cell = row.createCell(k);
                 cell.setCellValue(excelHeader[k]);
                 cell.setCellStyle(style);
     			}
             //表中数据
             for (int i = 0; i < wfzpqslist.size(); i++) {
           	  HSSFRow datarow = sheet.createRow(i+1);
           	  for (int k = 0; k < excelHeader.length; k++) {
           		  String value="";//值
           		  if(k==0) {
           			 value=wfzpqslist.get(i).getSj()+"";//时间
           		  }else if(k==1) {
           			  value=wfzpqslist.get(i).getCjsl()+"";//采集数量
           		  }else if(k==2) {
           			  value=wfzpqslist.get(i).getZccjsl()+"";//最后一次正常数量
           		  }else if(k==3) {
           			value=wfzpqslist.get(i).getSzzccjsl()+"";//上一周正常采集数量
           		  }else if(k==4) {
           			value=(double)((wfzpqslist.get(i).getCjsl()-wfzpqslist.get(i).getZccjsl())/wfzpqslist.get(i).getCjsl())*100+"%"; //增长率
           		  }else{
           			value=(double)((wfzpqslist.get(i).getZccjsl()-wfzpqslist.get(i).getSzzccjsl())/wfzpqslist.get(i).getZccjsl())*100+"%";//周同比
           		  }
                   	sheet.autoSizeColumn(k, true);// 根据字段长度自动调整列的宽度
                       HSSFCell cell = datarow.createCell(k);
                       cell.setCellValue(value);
                       cell.setCellStyle(style);
           			}
             }
             
        }
        
        
        
        
        response.setContentType("application/vnd.ms-excel");
        response.addHeader("Content-Disposition", "attachment;filename="+ java.net.URLEncoder.encode(tablename, "UTF-8")+".xls");  
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
	}
	
	/**
	 * 道路树
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("initTree")
	public String initTree(@RequestBody HashMap<String, Object> paramMap) {

		try {
			return service.initTree();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
