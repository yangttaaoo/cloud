package com.cist.statistics.ensemblejob.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.statistics.ensemblejob.model.Statistics;
import com.cist.statistics.ensemblejob.model.EnsembleJob;
import com.cist.statistics.ensemblejob.model.Illegal_Behavior;
import com.cist.statistics.ensemblejob.service.EnsembleJobService;
import com.netflix.client.http.HttpResponse;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/ensemblejob")
public class EsembleJobController {
	
	@Autowired
	private EnsembleJobService service;
	@RequestMapping("/querytj")
	public List<Statistics> querytj(@RequestBody HashMap<String,Object> map){
		List<EnsembleJob>  list = service.selectzpsl(map);
		List<EnsembleJob>  list1 = service.selectshsl(map);
		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
//			if(list1.get(i).getSj()!=null&&list.get(j).getSj()!=null) {
					if(list1.get(i).getWfxw().equals(list.get(j).getWfxw())&&list1.get(i).getSj().equals(list.get(j).getSj())){
						list1.get(i).setZpsl(list.get(j).getZpsl());
					}else{
						list1.get(i).setZpsl(0);
					}
			}
		}
		List<Illegal_Behavior> list2 = service.selectwfxw(null);
		
		TreeSet<Date> hs = new TreeSet<Date>();
		List<Statistics> list3 = new ArrayList<Statistics>();
		List<Statistics> list4 = new ArrayList<Statistics>();
		for (int i = 0; i < list1.size(); i++) {
			hs.add(list1.get(i).getSj());
		}
		Iterator<Date> it = hs.iterator();
		int count=0;
		while(it.hasNext()){
			Statistics st = new Statistics();
			Date d = (Date) it.next();
			st.setTjsj(d);
			List<Integer> datalist = new ArrayList<Integer>();
			int zpcount=0;
			int shcount=0;
			int cs=0;
			for (int i = 0; i < list1.size(); i++) {
				if(list1.get(i).getSj().equals(d)){
					for (int j = 0; j < list2.size(); j++) {
						String a= list2.get(j).getWfxw_id();
						String b=list1.get(i).getWfxw();
						 //int index = list2.get(j).getWfxw_id().indexOf(list1.get(i).getWfxw());
						int index=a.indexOf(b);
						if(datalist.size()+2<=list2.size()*2){
							if(index!=-1){
								datalist.add(list1.get(i).getZpsl());
								datalist.add(list1.get(i).getShsl());
									if(list1.get(i).getZpsl()!=null) {
										zpcount+=list1.get(i).getZpsl();
									}
									if(list1.get(i).getShsl()!=null) {
										shcount+=list1.get(i).getShsl();
									}
								}else{
									datalist.add(0);
									datalist.add(0);
								}
						}else{
							//超过16条
							if(index!=-1){
								if(list1.get(i).getZpsl()!=null) {
									datalist.set(j*2,list1.get(i).getZpsl()+datalist.get(j*2));	
									zpcount+=list1.get(i).getZpsl();
								}
								if(list1.get(i).getShsl()!=null) {
									datalist.set(j*2+1,list1.get(i).getShsl()+datalist.get(j*2));
									shcount+=list1.get(i).getShsl();
								}
							}
						}
					}
					cs++;
				}
				cs=0;
			
			}
			st.setShzs(shcount);
			st.setZpzs(zpcount);
			st.setDatalist(datalist);
			list3.add(count, st);
			count++;
			datalist=null;
		}
		for (int i = list3.size()-1; i >=0; i--) {
			list4.add(list3.get(i));
		}
		return list4;
	}
	@RequestMapping("/querywfxw")
	public List<Illegal_Behavior> selectwfxw(){
		Illegal_Behavior ill = new Illegal_Behavior();
		return service.selectwfxw(ill);
	}
	@RequestMapping("/queryline")
	public List<EnsembleJob> queryline(@RequestBody HashMap<String,Object> map) throws ParseException{
		EnsembleJob job = new EnsembleJob();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		
		if(map.get("kssj")!=null&&map.get("kssj")!="") {
			System.out.println(sdf.parse((String) map.get("kssj")));
			job.setKssj(sdf.parse((String) map.get("kssj")));
		}
		if(map.get("jssj")!=null&&map.get("jssj")!="") {
			job.setJssj(sdf.parse((String) map.get("jssj")));
		}
		if(map.get("cjdw")!=null&&map.get("cjdw")!="") {
			job.setCjdw((String) map.get("cjdw"));
		}
		 List<EnsembleJob> list = service.selectshzs(job);
		 List<EnsembleJob> list1 = service.selecttgzs(job);
		 List<EnsembleJob> list2 = service.selectzpzs(job);
		 for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getSj()!=null){
				for (int j = 0; j < list1.size(); j++) {
					if(list1.get(j).getSj()!=null&&list.get(i).getSj().equals(list1.get(j).getSj())){
						if(list1.get(j).getTgsl()!=null){
							list.get(i).setTgsl(list1.get(j).getTgsl());
						}else{
							list.get(i).setTgsl(0);
						}
						
					}
				}
				for (int j = 0; j < list2.size(); j++) {
					if(list2.get(j).getSj()!=null&&list.get(i).getSj().equals(list2.get(j).getSj())){
						if(list2.get(j).getZpsl()!=null){
							list.get(i).setZpsl(list2.get(j).getZpsl());
						}else{
							list.get(i).setZpsl(0);
						}
											
					}
				}
			}
		}
		return list;
	}
	/**
	 * 违法类型柱状图
	 * @param job
	 * @return
	 */
	@RequestMapping("/querybar")
	public List<Illegal_Behavior> querybar(@RequestBody EnsembleJob job){
		 List<EnsembleJob> list1 = service.wfxwlxtj(job);
		 Illegal_Behavior ill = new Illegal_Behavior();
		 List<Illegal_Behavior> list = service.selectwfxw(ill);
		 for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list1.size(); j++) {
					if(list.get(i).getWfxw_id().indexOf(list1.get(j).getWfxw())!=-1){
						if(list1.get(j).getWfxwlxsl()!=null){
							if(list.get(i).getSl()==null){
								list.get(i).setSl(list1.get(j).getWfxwlxsl());
							}else{
								list.get(i).setSl(list.get(i).getSl()+list1.get(j).getWfxwlxsl());
							}
						}else{
							if(list.get(i).getSl()==null){
								list.get(i).setSl(0);
							}
						}
					}
				}
			}
		return list;
	}
	/**
	 * 导出Excel表格
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/excel")
	public void export(@RequestBody HashMap<String,Object> map,HttpServletResponse response) throws IOException {
		//数据
		List<EnsembleJob>  list = service.selectzpsl(map);
		List<EnsembleJob>  list1 = service.selectshsl(map);
		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
//			if(list1.get(i).getSj()!=null&&list.get(j).getSj()!=null) {
					if(list1.get(i).getWfxw().equals(list.get(j).getWfxw())&&list1.get(i).getSj().equals(list.get(j).getSj())){
						list1.get(i).setZpsl(list.get(j).getZpsl());
					}else{
						list1.get(i).setZpsl(0);
					}
			}
		}
		List<Illegal_Behavior> list2 = service.selectwfxw(null);
		TreeSet<Date> hs = new TreeSet<Date>();
		List<Statistics> list3 = new ArrayList<Statistics>();
		for (int i = 0; i < list1.size(); i++) {
			hs.add(list1.get(i).getSj());
		}
		Iterator<Date> it = hs.iterator();
		int count=0;
		while(it.hasNext()){
			Statistics st = new Statistics();
			Date d = (Date) it.next();
			st.setTjsj(d);
			List<Integer> datalist = new ArrayList<Integer>();
			int zpcount=0;
			int shcount=0;
			int cs=0;
			for (int i = 0; i < list1.size(); i++) {
				if(list1.get(i).getSj().equals(d)){
					for (int j = 0; j < list2.size(); j++) {
						String a= list2.get(j).getWfxw_id();
						String b=list1.get(i).getWfxw();
						 //int index = list2.get(j).getWfxw_id().indexOf(list1.get(i).getWfxw());
						int index=a.indexOf(b);
						if(datalist.size()+2<=list2.size()*2){
							if(index!=-1){
								datalist.add(list1.get(i).getZpsl());
								datalist.add(list1.get(i).getShsl());
									if(list1.get(i).getZpsl()!=null) {
										zpcount+=list1.get(i).getZpsl();
									}
									if(list1.get(i).getShsl()!=null) {
										shcount+=list1.get(i).getShsl();
									}
								}else{
									datalist.add(0);
									datalist.add(0);
								}
						}else{
							//超过16条
							if(index!=-1){
								if(list1.get(i).getZpsl()!=null) {
									datalist.set(j*2,list1.get(i).getZpsl()+datalist.get(j*2));	
									zpcount+=list1.get(i).getZpsl();
								}
								if(list1.get(i).getShsl()!=null) {
									datalist.set(j*2+1,list1.get(i).getShsl()+datalist.get(j*2));
									shcount+=list1.get(i).getShsl();
								}
							}
						}
					}
					cs++;
				}
				cs=0;
			
			}
			st.setShzs(shcount);
			st.setZpzs(zpcount);
			st.setDatalist(datalist);
			list3.add(count, st);
			count++;
			datalist=null;
		}
		List<Statistics> list4 = new ArrayList<Statistics>();
		for (int i = list3.size()-1; i >=0; i--) {
			list4.add(list3.get(i));
		}
		//表头第一行
		String[] excelHeader0= {"日期","每日抓拍数量汇总","每日审核数量汇总","交通违法类型","交通违法类型","交通违法类型","交通违法类型","交通违法类型","交通违法类型","交通违法类型","交通违法类型","交通违法类型","交通违法类型","交通违法类型","交通违法类型","交通违法类型","交通违法类型","交通违法类型","交通违法类型"};
		//表头第一行排版布局
		String[] headnum0= {"0,2,0,0","0,2,1,1","0,2,2,2","0,0,3,18"};
		//表头第二行
		String[] excelHeader1= {"不按导向车道行驶","不按导向车道行驶","超速","超速","闯红灯","闯红灯","逆向行驶","逆向行驶","违反禁止标线","违反禁止标线","违反禁止标志","违反禁止标志","违反使用专用车道","违反使用专用车道","违停","违停"};
		//表头第二行排版布局
		String[] headnum1= {"1,1,3,4","1,1,5,6","1,1,7,8","1,1,9,10","1,1,11,12","1,1,13,14","1,1,15,16","1,1,17,18"};
		//表头第三行
		String[] excelHeader2= {"审核数量","抓拍数量","审核数量","抓拍数量","审核数量","抓拍数量","审核数量","抓拍数量","审核数量","抓拍数量","审核数量","抓拍数量","审核数量","抓拍数量","审核数量","抓拍数量","审核数量"};
		//表头第三行排版布局
		String[] headnum2= {"2,2,3,3","2,2,4,4","2,2,5,5","2,2,6,6","2,2,7,7","2,2,8,8","2,2,9,9","2,2,10,10","2,2,11,11","2,2,12,12","2,2,13,13","2,2,14,14","2,2,15,15","2,2,16,16","2,2,17,17","2,2,18,18"};
		// 声明一个工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = wb.createSheet("总体工作统计");
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
        // 字体加粗
        // font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 在样式2中引用这种字体
        style2.setFont(font2);
        // 生成表格的第一行
        // 第一行表头
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < excelHeader0.length; i++) {

            sheet.autoSizeColumn(i, true);// 根据字段长度自动调整列的宽度
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(excelHeader0[i]);
            cell.setCellStyle(style);

            // System.out.println(excelHeader0[i]);

            if (i >= 0 && i <= 18) {
                for (int j = 0; j < excelHeader0.length; j++) {
                    // 从第j列开始填充
                    cell = row.createCell(j);
                    // 填充excelHeader1[j]第j个元素
                    cell.setCellValue(excelHeader0[j]);
                    cell.setCellStyle(style);
                }

            }
        }
        // 动态合并单元格
        for (int i = 0; i < headnum0.length; i++) {

            sheet.autoSizeColumn(i, true);
            String[] temp = headnum0[i].split(",");
            Integer startrow = Integer.parseInt(temp[0]);
            Integer overrow = Integer.parseInt(temp[1]);
            Integer startcol = Integer.parseInt(temp[2]);
            Integer overcol = Integer.parseInt(temp[3]);
            sheet.addMergedRegion(new CellRangeAddress(startrow, overrow, startcol, overcol));
        }
        // 第二行表头
        row = sheet.createRow(1);
        for (int i = 0; i < excelHeader1.length; i++) {

            sheet.autoSizeColumn(i, true);// 自动调整宽度
            HSSFCell cell = row.createCell(i + 1);
            cell.setCellValue(excelHeader1[i]);
            cell.setCellStyle(style);

            if (i >= 3 && i <= 18) {
                for (int j = 0; j < excelHeader1.length; j++) {
                    // 从第j+1列开始填充
                    cell = row.createCell(j + 2);
                    // 填充excelHeader1[j]第j个元素
                    cell.setCellValue(excelHeader1[j]);
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
     // 第三行表头
        row = sheet.createRow(2);
        for (int i = 0; i < excelHeader2.length; i++) {

            HSSFCell cell = row.createCell(i + 2);
            cell.setCellValue(excelHeader2[i]);
            cell.setCellStyle(style);
            // System.out.println(excelHeader2[i]);
            sheet.autoSizeColumn(i, true);// 自动调整宽度

            if (i >=3 && i <= 18) {
                for (int j = 0; j < excelHeader2.length; j++) {
                    // 从第j+2列开始填充
                    cell = row.createCell(j);
                    // 填充excelHeader1[j]第j个元素
                    cell.setCellValue(excelHeader2[j]);
                    cell.setCellStyle(style);
                }
            }
        }
        for (int i = 0; i < list4.size(); i++) {
        	 row = sheet.createRow(i+3);
        	 Statistics report = list4.get(i);
        	 
        	 // 导入对应列的数据
        	 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        	 sheet.autoSizeColumn(0, true);
             HSSFCell cell = row.createCell(0);
             String date=format.format(report.getTjsj());
             cell.setCellValue(date);
             cell.setCellStyle(style2);
             
             // 导入对应列的数据
             HSSFCell cell1 = row.createCell(1);
             String zpzs=report.getZpzs().toString();
             cell1.setCellValue(zpzs);
             cell1.setCellStyle(style2);
             
             // 导入对应列的数据
             HSSFCell cell2 = row.createCell(2);
             String shzs=report.getShzs().toString();
             cell2.setCellValue(shzs);
             cell2.setCellStyle(style2);
             
            for (int j = 0; j < report.getDatalist().size(); j++) {
            	 // 导入对应列的数据
                HSSFCell cell3 = row.createCell(j+3);
                cell3.setCellValue( report.getDatalist().get(j).toString());
                cell3.setCellStyle(style2);
			}
        }
//        response.setContentType("application/vnd.ms-excel");
//        response.addHeader("Content-Disposition", "attachment;filename="+ java.net.URLEncoder.encode("总体工作统计表", "UTF-8")+".xls");  
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
		
	}
}
