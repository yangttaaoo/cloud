package com.cist.Illegalbusiness.util;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import com.cist.illegalbehavior.model.Sys_frm_code;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
 
public class Export {
 
    /**
     * 导出xls文件(合并单元格)
     * @param list
     * @param xlsFileName
     * @param sheetName
     */
    public static void reportMergeXls(List<HashMap<String,Object>> list,String sheetName,String[] headers,List<Sys_frm_code> list1 ,OutputStream out) throws Exception{
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetName);//创建一个sheet-test1
 
        //设置单元格风格，居中对齐.
        HSSFCellStyle cs = wb.createCellStyle();
        cs.setAlignment(HorizontalAlignment.CENTER);//居中
        cs.setVerticalAlignment(VerticalAlignment.CENTER);//垂直
// 
//        cs.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
//        cs.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
//        cs.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
//        cs.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
 
        //设置字体:
        HSSFFont font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 12);//设置字体大小
//        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
 
        cs.setFont(font);//要用到的字体格式
 
        //sheet.setColumnWidth(0, 3766); //第一个参数代表列下标(从0开始),第2个参数代表宽度值
        //cs.setWrapText(true);//设置字体超出宽度自动换行
 
        //设置背景颜色
        //cs.setFillBackgroundColor(HSSFColor.BLUE.index);
        //cs.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
 
 
        //创建第一行
        HSSFRow row = sheet.createRow((short) 0);
        HSSFCell cell ;
 
        for (int i = 0; i < headers.length; i++) {//设置表头-标题
            cell = row.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(cs);
            sheet.autoSizeColumn(i);//自动设宽
        }
 
        //设置合并的标题头(注意：横向合并的时候，标题头单元格必须长度和内容单元格一致否则合并时会把其他标题头单元格内容挤掉)
        sheet.addMergedRegion(new CellRangeAddress(0,0,headers.length-1,headers.length-1+list1.size()-1));//横向：合并第一行的第2列到第4列0
        for (int i = 0; i < headers.length-1; i++) {
       	 sheet.addMergedRegion(new CellRangeAddress(0,1,i,i));//纵向：合并第一列的第1行和第2行第	
		}
 
        //设置对应的合并单元格标题
        row = sheet.createRow(1);
        for (int j = 4; j < list1.size()+4; j++) {
            cell = row.createCell((short)j);
            cell.setCellStyle(cs);
            	cell.setCellValue(list1.get(j-4).getFc_name());
                sheet.autoSizeColumn(j);//自动设宽
            
        }
        //设置单元格风格，居中对齐.
        HSSFCellStyle cs1 = wb.createCellStyle();
        cs1.setAlignment(HorizontalAlignment.CENTER);//居中
        cs1.setVerticalAlignment(VerticalAlignment.CENTER);//垂直
//        row.createCell(0).setCellStyle(cs1);
//        sheet.autoSizeColumn(0, true);// 根据字段长度自动调整列的宽度
        //设置列值-内容
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 2);
            Map map = list.get(i);
            row.createCell(0).setCellValue((String)map.get("shr"));
            row.createCell(1).setCellValue(map.get("shsl")==null?0:Integer.valueOf(map.get("shsl").toString()).intValue());
            row.createCell(2).setCellValue(map.get("yxsl")==null?0:Integer.valueOf(map.get("yxsl").toString()).intValue());
            row.createCell(3).setCellValue((String)map.get("yxl"));
            for (int j = 0; j < list1.size(); j++) {
            	row.createCell(j+4).setCellValue(map.get(list1.get(j).getFc_code())==null?0:Integer.valueOf(map.get(list1.get(j).getFc_code()).toString()).intValue());
			}
        }
        // 处理中文不能自动调整列宽的问题
        setSizeColumn(sheet, list.size());
        try {
            wb.write(out);
            out.close();
            /*//页面弹出下载或保存
            response.setContentType("application/x-download");
            response.setHeader("Content-disposition","attachment;filename="+ new String("test.xls".getBytes("utf-8"), "iso-8859-1"));
            response.setCharacterEncoding("utf-8");
            OutputStream os=response.getOutputStream();
            wb.write(os);
            os.close();
             */
        } catch (Exception e) {
            System.out.println("文件输出失败!");
            e.printStackTrace();
        }
 
    }
    
 // 自适应宽度(中文支持)
    public static void setSizeColumn(HSSFSheet sheet, int size) {
        for (int columnNum = 0; columnNum < size; columnNum++) {
            int columnWidth = sheet.getColumnWidth(columnNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                HSSFRow currentRow;
                //当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                } else {
                    currentRow = sheet.getRow(rowNum);
                }
 
                if (currentRow.getCell(columnNum) != null) {
                    HSSFCell currentCell = currentRow.getCell(columnNum);
                    if(currentCell.getCellTypeEnum() == CellType.STRING){
                    	 int length = currentCell.getStringCellValue().getBytes().length;
                         if (columnWidth < length) {
                             columnWidth = length;
                         }
                    }
                }
            }
            sheet.setColumnWidth(columnNum, columnWidth * 256);
        }
    }
 
}
