package com.cist.deptdutyall.controller;

import java.io.IOException;
import java.io.OutputStream;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.deptdutyall.service.DeptDutyAllService;
import com.cist.duty.model.DutyInfo;
import com.cist.duty.model.EchartsInfo;
import com.cist.duty.service.DutyService;
import com.cist.dutyall.model.DutyAllInfo;
import com.cist.dutyall.model.TlInfo;
import com.cist.frame.page.PageInfo;


/***
 * 
 * @Title:  DeptDutyAllController.java   
 * @Package com.cist.deptdutyall.controller
 * @Description:    勤务考核部门总体分析
 * @author: 田隽杭    
 * @date:   2018年8月1日 下午02:07:00 
 * @version V1.0
 */
@RestController
@RequestMapping("/deptdutyall")
public class DeptDutyAllController {
	@Autowired
	private DeptDutyAllService service;
	@Autowired
	private DutyService service2;
	
	/**
	 * 勤务考核部门总体考核首页查询
	 * @param map
	 */
	@RequestMapping("deptdutyAllInfoList")
    public PageInfo<DutyAllInfo> deptdutyAllInfopageList(@RequestBody HashMap<String,Object> modelMap ){
    	PageInfo pinfo = new PageInfo();
    	pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
		PageInfo<DutyAllInfo> list= (PageInfo<DutyAllInfo>)service.deptdutyAllInfopageList(modelMap,pinfo);
		return list;
	}
	/**
	 * 导出Excel表格
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("excel")
	public void export(@RequestParam HashMap<String,Object> map,HttpServletResponse response) throws IOException {
		//数据
		List<DutyAllInfo>  list1 = service.deptdutyAllInfo(map);

		//动态生成表头
		String[] excelHeader0 = {"所属部门","部门负责人","综合指标","综合扣分","综合加分","考核得分","是否合格","综合排名"};
		
		// 声明一个工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = wb.createSheet("勤务考核部门总体分析");
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
        }
        for (int i = 0; i < list1.size(); i++) {
        	 row = sheet.createRow(i+1);
        	 DutyAllInfo report = list1.get(i);
             // 导入对应列的数据
             HSSFCell cell1 = row.createCell(0);
             String ssdw=report.getSypi_dept_name();
             cell1.setCellValue(ssdw);
             cell1.setCellStyle(style2);
             // 导入对应列的数据
             HSSFCell cell2 = row.createCell(1);
             String jymc=report.getDept_head();
             cell2.setCellValue(jymc);
             cell2.setCellStyle(style2);
             // 导入对应列的数据
             HSSFCell cell3 = row.createCell(2);
             String pdfs=report.getEva_num().toString();
             cell3.setCellValue(pdfs);
             cell3.setCellStyle(style2);
             // 导入对应列的数据
             HSSFCell cell4 = row.createCell(3);
             String kf=report.getKf().toString();
             cell4.setCellValue(kf);
             cell4.setCellStyle(style2);
             // 导入对应列的数据
             HSSFCell cell5 = row.createCell(4);
             String jf=report.getJf().toString();
             cell5.setCellValue(jf);
             cell5.setCellStyle(style2);
             // 导入对应列的数据
             HSSFCell cell6 = row.createCell(5);
             String zf=report.getZf().toString();
             cell6.setCellValue(zf);
             cell6.setCellStyle(style2);
             // 导入对应列的数据
             HSSFCell cell7 = row.createCell(6);
             String hg=report.getHg().toString();
             cell7.setCellValue(hg);
             cell7.setCellStyle(style2);
             // 导入对应列的数据
             HSSFCell cell8 = row.createCell(7);
             String pm=report.getPm().toString();
             cell8.setCellValue(pm);
             cell8.setCellStyle(style2);
        }
        response.setContentType("application/vnd.ms-excel");
        response.addHeader("Content-Disposition", "attachment;filename="+ java.net.URLEncoder.encode("勤务考核部门总体分析", "UTF-8")+".xls");  
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
	}
	/**
	 * 合格率统计图数据查询
	 */
	@RequestMapping("hgecharts")
	public  EchartsInfo  hgecharts(@RequestBody HashMap<String,Object> modelMap){
		return service.hgecharts(modelMap);
	}
	/**
	 * 条例扣分统计图数据查询
	 */
	@RequestMapping("tlecharts")
	public  List<EchartsInfo>  tlecharts(@RequestBody HashMap<String,Object> modelMap){
		return service.tlecharts(modelMap);
	}
	/**
	 * 总体栏目扣分统计图数据查询
	 */
	@RequestMapping("lmecharts")
	public  List<DutyAllInfo>  lmecharts(@RequestBody HashMap<String,Object> modelMap){
		return service.deptdutyAllInfo(modelMap);
	}
	/**
	 * 报表数据列表查询
	 */
	@RequestMapping("listchart")
	public HashMap<String,Object> listchart(@RequestBody HashMap<String,Object> modelMap) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		List<TlInfo> list3 = service.tlcx();
		List<DutyAllInfo>  list1 = service.deptdutyAllInfo(map);
		for (int i = 0; i < list1.size(); i++) {
			List<TlInfo> list2 = service.tllist(list1.get(i).getDept_pk());
			list1.get(i).setTlinfo(list2);
		}
		map.put("listdata", list1);//综合得分list
		map.put("lmdata", list3);//栏目列表list
		return map;
	}
	/**
	 * 导出Excel表格
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("excel2")
	public void export2(@RequestParam HashMap<String,Object> map,HttpServletResponse response) throws IOException {
		//数据
		List<TlInfo> list3 = service.tlcx();
		List<DutyAllInfo>  list1 = service.deptdutyAllInfo(map);
		for (int i = 0; i < list1.size(); i++) {
			List<TlInfo> list2 = service.tllist(list1.get(i).getDept_pk());
			list1.get(i).setTlinfo(list2);
		}
		//动态生成表头第一行 
		String[] excelHeader0 = new String[list3.size()*2+8]; 
		excelHeader0[0] = "所属部门"; 
		excelHeader0[1] = "部门负责人";
		excelHeader0[2] = "综合指标";
		excelHeader0[3] = "综合扣分";
		excelHeader0[4] = "综合加分";
		excelHeader0[5] = "考核得分";
		excelHeader0[6] = "是否合格";
		excelHeader0[7] = "综合排名";
		for(int i = 8;i<list3.size()*2+8;i++){
			excelHeader0[i] = "考核栏目";
		}
		//动态生成表头第一行排版布局
		String[] headnum0= new String[9];
		headnum0[0] = "0,2,0,0";
		headnum0[1] = "0,2,1,1";
		headnum0[2] = "0,2,2,2";
		headnum0[3] = "0,2,3,3";
		headnum0[4] = "0,2,4,4";
		headnum0[5] = "0,2,5,5";
		headnum0[6] = "0,2,6,6";
		headnum0[7] = "0,2,7,7";
		headnum0[8] = "0,0,8,"+(list3.size()*2+7);
		//动态生成表头第二行
		String[] excelHeader1 = new String[list3.size()*2];
		for(int i = 0;i<list3.size()*2;i=i+2){
			excelHeader1[i] = list3.get(i/2).getLmmc();
			excelHeader1[i+1] = list3.get(i/2).getLmmc();
		}
		//动态生成表头第二行排版布局
		String[] headnum1= new String[list3.size()];
		for(int i=8;i<list3.size()*2+8;i=i+2){
			headnum1[(i-8)/2] ="1,1,"+i+","+(i+1);
		}
		
		//动态生成表头第三行
		String[] excelHeader2 = new String[list3.size()*2];
		for(int i = 0;i<list3.size()*2;i=i+2){
			excelHeader2[i] = "评定指标";
			excelHeader2[i+1] = "考核评分";
		}
		
		// 声明一个工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = wb.createSheet("勤务考核部门总体分析-报表");
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
        for (int i = 8; i < excelHeader1.length+8; i++) {
            sheet.autoSizeColumn(i, true);// 自动调整宽度
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(excelHeader1[i-8]);
            cell.setCellStyle(style);
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
        for (int i = 8; i < excelHeader2.length+8; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(excelHeader2[i-8]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i, true);// 自动调整宽度
        }
        for (int i = 0; i < list1.size(); i++) {
        	 row = sheet.createRow(i+3);
        	 DutyAllInfo report = list1.get(i);
             // 导入对应列的数据-所属部门
             HSSFCell cell1 = row.createCell(0);
             String ssdw=report.getSypi_dept_name();
             cell1.setCellValue(ssdw);
             cell1.setCellStyle(style2);
             // 导入对应列的数据-部门扶着人
             HSSFCell cell2 = row.createCell(1);
             String jymc=report.getDept_head();
             cell2.setCellValue(jymc);
             cell2.setCellStyle(style2);
             // 导入对应列的数据-综合指标
             HSSFCell cell3 = row.createCell(2);
             String pdfs=report.getEva_num().toString();
             cell3.setCellValue(pdfs);
             cell3.setCellStyle(style2);
             // 导入对应列的数据-综合扣分
             HSSFCell cell4 = row.createCell(3);
             String kf=report.getKf().toString();
             cell4.setCellValue(kf);
             cell4.setCellStyle(style2);
             // 导入对应列的数据-综合加分
             HSSFCell cell5 = row.createCell(4);
             String jf=report.getJf().toString();
             cell5.setCellValue(jf);
             cell5.setCellStyle(style2);
             // 导入对应列的数据-考核得分
             HSSFCell cell6 = row.createCell(5);
             String zf=report.getZf().toString();
             cell6.setCellValue(zf);
             cell6.setCellStyle(style2);
             // 导入对应列的数据-是否合格
             HSSFCell cell7 = row.createCell(6);
             String hg=report.getHg().toString();
             cell7.setCellValue(hg);
             cell7.setCellStyle(style2);
             // 导入对应列的数据-综合排名
             HSSFCell cell8 = row.createCell(7);
             String pm=report.getPm().toString();
             cell8.setCellValue(pm);
             cell8.setCellStyle(style2);
             for(int j = 0;j<report.getTlinfo().size()*2;j=j+2){
            	 //导入对应列的数据-栏目分值
            	 HSSFCell cell9 = row.createCell(8+j);
                 String lmfz=report.getTlinfo().get(j/2).getLmfz().toString();
                 cell9.setCellValue(lmfz);
                 cell9.setCellStyle(style2);
               //导入对应列的数据-栏目分值
            	 HSSFCell cell10 = row.createCell(9+j);
                 String khdf=report.getTlinfo().get(j/2).getKhpf().toString();
                 cell10.setCellValue(khdf);
                 cell10.setCellStyle(style2);
             }
        }
        response.setContentType("application/vnd.ms-excel");
        response.addHeader("Content-Disposition", "attachment;filename="+ java.net.URLEncoder.encode("勤务考核部门总体分析-报表", "UTF-8")+".xls");  
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
	}
}
