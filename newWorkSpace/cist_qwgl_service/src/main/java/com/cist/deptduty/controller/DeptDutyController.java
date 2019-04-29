package com.cist.deptduty.controller;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.deptduty.service.DeptDutyService;
import com.cist.duty.model.DutyInfo;
import com.cist.duty.model.EchartsInfo;
import com.cist.duty.model.Rule_info;
import com.cist.duty.model.TlInfo;
import com.cist.frame.page.PageInfo;

/***
 * 
 * @Title:  KerisController.java   
 * @Package com.cist.kreis.controller
 * @Description:    勤务考核部门单项分析
 * @author: 田隽杭    
 * @date:   2018年7月16日 下午7:15:35 
 * @version V1.0
 */
@RestController
@RequestMapping("/deptduty")
public class DeptDutyController {
	@Autowired
	private DeptDutyService service;

	/**
	 * 勤务考核部门单项考核首页查询
	 * @param map
	 */
	@RequestMapping("deptdutyInfoList")
    public PageInfo<DutyInfo> deptdutyInfopageList(@RequestBody HashMap<String,Object> modelMap ){
    	PageInfo pinfo = new PageInfo();
    	pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
		PageInfo<DutyInfo> list= (PageInfo<DutyInfo>)service.deptdutyInfopageList(modelMap,pinfo);
		return list;
	}
	/**
	 * 条例查询
	 */
	@RequestMapping("rulelist")
	public  HashMap<String,Object>  rule(@RequestBody HashMap<String,Object> modelMap){
		modelMap.put("rulelist", service.rulelist(modelMap));
		return modelMap;
	}
	/**
	 * 栏目查询
	 */
	@RequestMapping("infolist")
	public  HashMap<String,Object>  infolist(){
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		modelMap.put("infolist", service.infolist());
		return modelMap;
	}
	 /**
	  * 条例明细查询
	  */
	@RequestMapping("tllist")
	public  List<TlInfo>  tllist(@RequestBody HashMap<String,Object> modelMap){
		return service.tllist(modelMap);
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
	public  List<DutyInfo>  lmecharts(@RequestBody HashMap<String,Object> modelMap){
		return service.deptdutyInfo(modelMap);
	}
	/**
	 * 导出Excel表格
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("excel")
	public void export(@RequestParam HashMap<String,Object> map,HttpServletResponse response) throws IOException {
		//数据
		List<DutyInfo>  list1 = service.deptdutyInfo(map);
		List<Rule_info> list3 = service.rulelist(map);
		//动态生成表头
		String[] excelHeader0 = new String[6+list3.size()]; 
		excelHeader0[0] = "所属部门"; 
		excelHeader0[1] = "部门负责人";
		excelHeader0[2] = "指标分数";
		excelHeader0[3] = "考核得分";
		excelHeader0[4] = "是否合格";
		excelHeader0[5] = "排名";
		for(int i = 6;i<list3.size()+6;i++){
			excelHeader0[i] = list3.get(i-6).getTlmc();
		}
		// 声明一个工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = wb.createSheet("勤务考核部门单项考核");
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
        	 DutyInfo report = list1.get(i);
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
             String khdf=report.getZf().toString();
             cell4.setCellValue(khdf);
             cell4.setCellStyle(style2);
             // 导入对应列的数据
             HSSFCell cell5 = row.createCell(4);
             String hg=report.getHg().toString();
             cell5.setCellValue(hg);
             cell5.setCellStyle(style2);
             // 导入对应列的数据
             HSSFCell cell6 = row.createCell(5);
             String pm=report.getPm().toString();
             cell6.setCellValue(pm);
             cell6.setCellStyle(style2);
             
             map.put("ssdw", list1.get(i).getDept_pk());
             List<TlInfo> list4 = service.tllist(map);
             
            for (int j = 0; j < list4.size(); j++) {
            	 // 导入对应列的数据
                HSSFCell cell7 = row.createCell(j+6);
                cell7.setCellValue( list4.get(j).getTlfz().toString());
                cell7.setCellStyle(style2);
			}
        }
        response.setContentType("application/vnd.ms-excel");
        response.addHeader("Content-Disposition", "attachment;filename="+ java.net.URLEncoder.encode("勤务考核部门单项分析", "UTF-8")+".xls");  
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
	}
}
