package com.cist.xxtj.wfsjlztj.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
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
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.xxtj.wfsjlztj.model.TBL_OFFE_VIO_FLOW_STAT;
import com.cist.xxtj.wfsjlztj.service.WfsjlztjService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/wfsjlztj")
public class WfsjlztjController {
	@Autowired
	private WfsjlztjService service;
	
	@RequestMapping("index")
	public HashMap<String,Object> index(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		ModelMap.put("card", service.querycard(null));//查询四卡片的数据
		ModelMap.put("sjlztj", service.queryjrsjlztj(null));//查询今日数据流转统计
		ModelMap.put("wfzppm", service.querywfzppm(null));//查询违法抓拍排名
		List<TBL_OFFE_VIO_FLOW_STAT> sjlztjlist =service.querysjlztjlist(null);
		int scsbs=0;//上传设备数
		int cjzs=0;//抓拍总数
		int yxsj=0;//有效数据
		int wxsj=0;//无效数据
		int sczs=0;//上传总数
		int dssj=0;//待处理数据
		TBL_OFFE_VIO_FLOW_STAT stat=new TBL_OFFE_VIO_FLOW_STAT();
		List<TBL_OFFE_VIO_FLOW_STAT> list =new ArrayList<TBL_OFFE_VIO_FLOW_STAT>();
		list.add(stat);
		for (int i = 0; i < sjlztjlist.size(); i++) {
			
				list.add(sjlztjlist.get(i));
				scsbs+=sjlztjlist.get(i).getScsbs();
				cjzs+=sjlztjlist.get(i).getCjzs();
				yxsj+=sjlztjlist.get(i).getYxsj();
				wxsj+=sjlztjlist.get(i).getWxsj();
				sczs+=sjlztjlist.get(i).getSczs();
				dssj+=sjlztjlist.get(i).getDssj();
			
		}

java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
		list.get(0).setRq("合计");
		list.get(0).setScsbs(scsbs);
		list.get(0).setCjzs(cjzs);
		list.get(0).setYxsj(yxsj);
		list.get(0).setYxslzb(df.format(((double)yxsj/(double)cjzs)*100)+"%");
		list.get(0).setWxsj(wxsj);
		list.get(0).setWxsjzb(df.format(((double)wxsj/(double)cjzs)*100)+"%");
		list.get(0).setSczs(sczs);
		list.get(0).setScslzb(df.format(((double)sczs/(double)cjzs)*100)+"%");
		list.get(0).setDssj(dssj);
		list.get(0).setDclzszb(df.format(((double)dssj/(double)cjzs)*100)+"%");
		ModelMap.put("sjlztjlist", list);//查询数据流转统计列表
		ModelMap.put("jrwflzinfo", service.queryjrwflzinfo());//查询今日数据流转详情
		return ModelMap;
	}
	/**
	 * 按年月周日进行查询
	 * rqlx 日期类型 
	 * 1：当日 2：本周 3：本月 4：全年
	 * @param map
	 * @return
	 */
	@RequestMapping("anyzrcx")
	public HashMap<String,Object> anyzrcx(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		if("4".equals(map.get("rqlx").toString())) {
			ModelMap.put("sjlztj", service.queryqnsjlztj(null));//查询全年数据流转统计
		}else if("3".equals(map.get("rqlx").toString())) {
			ModelMap.put("sjlztj", service.querybysjlztj(null));//查询本月数据流转统计
		}else if("2".equals(map.get("rqlx").toString())) {
			ModelMap.put("sjlztj", service.querybzsjlztj(null));//查询本周数据流转统计
		}else{
			ModelMap.put("sjlztj", service.queryjrsjlztj(null));//查询今日数据流转统计
		}
		return ModelMap;
	}
	
	/**
	 * 违法抓拍排名
	 * @param map
	 * @return
	 */
	@RequestMapping("wfzppm")
	public HashMap<String,Object> wfzppm(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		ModelMap.put("wfzppm", service.querywfzppm(map));//查询违法抓拍排名
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
		//数据
		List<TBL_OFFE_VIO_FLOW_STAT> sjlztjlist =service.querysjlztjlist(null);
		int scsbs=0;//上传设备数
		int cjzs=0;//抓拍总数
		int yxsj=0;//有效数据
		int wxsj=0;//无效数据
		int sczs=0;//上传总数
		int dssj=0;//待处理数据
		TBL_OFFE_VIO_FLOW_STAT stat=new TBL_OFFE_VIO_FLOW_STAT();
		List<TBL_OFFE_VIO_FLOW_STAT> list =new ArrayList<TBL_OFFE_VIO_FLOW_STAT>();
		list.add(stat);
		for (int i = 0; i < sjlztjlist.size(); i++) {
			
				list.add(sjlztjlist.get(i));
				scsbs+=sjlztjlist.get(i).getScsbs();
				cjzs+=sjlztjlist.get(i).getCjzs();
				yxsj+=sjlztjlist.get(i).getYxsj();
				wxsj+=sjlztjlist.get(i).getWxsj();
				sczs+=sjlztjlist.get(i).getSczs();
				dssj+=sjlztjlist.get(i).getDssj();
			
		}

java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
		list.get(0).setRq("合计");
		list.get(0).setScsbs(scsbs);
		list.get(0).setCjzs(cjzs);
		list.get(0).setYxsj(yxsj);
		list.get(0).setYxslzb(df.format(((double)yxsj/(double)cjzs)*100)+"%");
		list.get(0).setWxsj(wxsj);
		list.get(0).setWxsjzb(df.format(((double)wxsj/(double)cjzs)*100)+"%");
		list.get(0).setSczs(sczs);
		list.get(0).setScslzb(df.format(((double)sczs/(double)cjzs)*100)+"%");
		list.get(0).setDssj(dssj);
		list.get(0).setDclzszb(df.format(((double)dssj/(double)cjzs)*100)+"%");
		
		// 声明一个工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = wb.createSheet("数据流转统计列表");
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
        
        String[] headers1 = {"日期","上传设备数","抓拍总数","审核总数","审核总数","审核总数","审核总数","上传总数","上传总数","待处理总数","待处理总数"};
        String[] headnum1= {"0,1,0,0","0,1,1,1","0,1,2,2","0,0,3,6","0,0,7,8","0,0,9,10"};
        String[] headers2 = {"有效数量","占比","无效数量","占比","数量","占比","数量","占比"};
        String[] headnum2= {"1,1,3,3","1,1,4,4","1,1,5,5","1,1,6,6","1,1,7,7","1,1,8,8","1,1,9,9","1,1,10,10"};
        // 生成表格的第一行
        // 第一行表头
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers1.length; i++) {

            sheet.autoSizeColumn(i, true);// 根据字段长度自动调整列的宽度
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(headers1[i]);
            cell.setCellStyle(style);
            if (i >= 0 && i <= 18) {
                for (int j = 0; j < headers1.length; j++) {
                    // 从第j列开始填充
                    cell = row.createCell(j);
                    // 填充excelHeader1[j]第j个元素
                    cell.setCellValue(headers1[j]);
                    cell.setCellStyle(style);
                }

            }

        }
        // 动态合并单元格
        for (int i = 0; i < headnum1.length; i++) {

            sheet.autoSizeColumn(i, true);
            String[] temp = headnum1[i].split(",");
            Integer startrow = Integer.parseInt(temp[0]);
            Integer overrow = Integer.parseInt(temp[1]);
            Integer startcol = Integer.parseInt(temp[2]);
            Integer overcol = Integer.parseInt(temp[3]);
            sheet.addMergedRegion(new CellRangeAddress(startrow, overrow, startcol, overcol));
        }
        
        // 第二行表头
        row = sheet.createRow(1);
        for (int i = 0; i < headers2.length; i++) {

            sheet.autoSizeColumn(i, true);// 自动调整宽度
            HSSFCell cell = row.createCell(i + 3);
            cell.setCellValue(headers2[i]);
            cell.setCellStyle(style);

            if (i > 2 && i <= 18) {
                for (int j = 0; j < headers2.length; j++) {
                    // 从第j+1列开始填充
                    cell = row.createCell(j + 3);
                    // 填充excelHeader1[j]第j个元素
                    cell.setCellValue(headers2[j]);
                    cell.setCellStyle(style);
                }
            }
        }
        
      //表中数据
        for (int i = 0; i < list.size(); i++) {
      	  HSSFRow datarow = sheet.createRow(i+2);
      	  for (int k = 0; k < 11; k++) {
      		  String value="";//值
      		  if(k==0) {
      			 value=list.get(i).getRq();//日期
      		  }else if(k==1) {
      			  value=list.get(i).getScsbs()+"";//上传设备数
      		  }else if(k==2) {
      			  value=list.get(i).getCjzs()+"";//抓拍总数
      		  }else if(k==3) {
      			value=list.get(i).getYxsj()+"";//有效数量
      		  }else if(k==4) {
      			value=list.get(i).getYxslzb()+""; //有效数量占比
      		  }else if(k==5) {
      			value=list.get(i).getWxsj()+""; //无效数据
      		  }else if(k==6) {
      			value=list.get(i).getWxsjzb()+""; //无效数据占比
      		  }else if(k==7) {
      			value=list.get(i).getSczs()+""; //上传总数
      		  }else if(k==8) {
      			value=list.get(i).getScslzb()+""; //上传占比
      		  }else if(k==9) {
      			value=list.get(i).getDssj()+""; //待处理数据
      		  }else{
      			value=list.get(i).getDclzszb()+"";//待处理数据占比
      		  }
              	sheet.autoSizeColumn(k, true);// 根据字段长度自动调整列的宽度
                  HSSFCell cell = datarow.createCell(k);
                  cell.setCellValue(value);
                  cell.setCellStyle(style);
      			}
        }
        response.setContentType("application/vnd.ms-excel");
        response.addHeader("Content-Disposition", "attachment;filename="+ java.net.URLEncoder.encode("数据流转统计列表", "UTF-8")+".xls");  
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
   }

       
        

}
