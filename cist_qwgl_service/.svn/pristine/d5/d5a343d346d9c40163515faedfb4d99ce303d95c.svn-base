package com.cist.assessStatisticalRelease.assessTotalityAnalysis.util;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import com.cist.assessStatisticalRelease.assessTotalityAnalysis.model.PersonalScore;
import com.cist.assessStatisticalRelease.assessTotalityAnalysis.model.TotalScore;
/**
 * 勤务个人总体分析考核报表导出工具类
 * @author 57150
 *
 */
public class ExcelUtil {

	/**
	 * 
	 * @param sheet
	 *            工作表
	 * @param headers
	 *            第一行标题
	 * @param number
	 *            第三行标题
	 * @param topicIdMap
	 *            栏目map
	 * @param cellNum
	 *            每行单元格数
	 * @param cs
	 *            单元格风格
	 * @param prefixNum
	 *            前缀不合并列
	 * @param suffixNum
	 *            后缀不合并列
	 */
	public static void createSheetHeader(HSSFSheet sheet, String[] headers, String[] number,
			HashMap<Long, String> topicIdMap, int cellNum, HSSFCellStyle cs, int prefixNum, int suffixNum,String type) {
		for (int i = 0; i < 3; i++) {
			HSSFRow rows = sheet.createRow(i);
			for (int j = 0; j < cellNum; j++) {
				HSSFCell createCell = rows.createCell(j);
				if (i == 0) {
					if (j <= prefixNum) {
						createCell.setCellValue(headers[j]);
						if (j != prefixNum)
							sheet.addMergedRegion(new CellRangeAddress(i, 2, j, j));
					} else if (j >= cellNum - suffixNum) {
						createCell.setCellValue(headers[j - (topicIdMap.size() * 2) + 1]);
						sheet.addMergedRegion(new CellRangeAddress(i, 2, j, j));
					}
					createCell.setCellStyle(cs);
				}
				if (i == 1) {
					if (j >= prefixNum && j < cellNum - suffixNum) {
						if (j % 2 != 0) {
							if("person".equals(type))
							sheet.addMergedRegion(new CellRangeAddress(i, i, j - 1, j));
						}else {
							if("dept".equals(type))
							 sheet.addMergedRegion(new CellRangeAddress(i, i, j - 1, j));
						}
							
					}
					createCell.setCellStyle(cs);
				}
//				if (i == 2) {
//					if (j >= prefixNum && j < cellNum - suffixNum) {
//						createCell.setCellValue(number[j % 2]);
//					}
//				}
			}
			if (i == 0) {
				sheet.addMergedRegion(new CellRangeAddress(i, i, prefixNum, (topicIdMap.size() * 2) + prefixNum - 1));
			}
			sheet.autoSizeColumn(i);
		}
	}

	/**
	 * 展示个人考核分析数据
	 * 
	 * @param sheet
	 * @param totalScore
	 * @param cs
	 * @param topicIdMap
	 * @param type
	 */
	public static void ShowSheetData(HSSFSheet sheet, List<TotalScore> totalScore, HSSFCellStyle cs,
			HashMap<Long, String> topicIdMap, String type) {
		for (int i = 0; i < totalScore.size(); i++) {
			HSSFRow rows = sheet.createRow(i + 3);
			TotalScore score = totalScore.get(i);
			int v = 0;
			if ("person".equals(type)) {
				ExcelUtil.setCellValue(rows, v, score.getFk_dept_name(), cs);
				v++;
			}
			ExcelUtil.setCellValue(rows, v, score.getFk_user_name(), cs);
			v++;
			
			ExcelUtil.setCellValue(rows, v, score.getTotal_buckle_score(), cs);
			v++;
			ExcelUtil.setCellValue(rows, v, score.getTotal_add_score(), cs);
			v++;

			for (Long topicId : topicIdMap.keySet()) {
				sheet.getRow(1).getCell(v).setCellValue(topicIdMap.get(topicId));
				
				PersonalScore perScore = score.getPersonalScoreMap().get(topicId);
				ExcelUtil.setCellValue(rows, v, perScore != null ? perScore.getIndicator_score() : 0L, cs);
				v++;
				ExcelUtil.setCellValue(rows, v, perScore != null ? perScore.getAssess_score() : 0L, cs);
				v++;
			}
			ExcelUtil.setCellValue(rows, v, score.getTotal_indicator_score(), cs);
			v++;
			ExcelUtil.setCellValue(rows, v, score.getTotal_assess_score(), cs);
			v++;
			ExcelUtil.setCellValue(rows, v,
					Long.compare(score.getTotal_assess_score(), score.getTotal_indicator_score()) == -1 ? "不合格" : "合格",
					cs);
			v++;
			ExcelUtil.setCellValue(rows, v, score.getTotal_rank(), cs);
		}
	}

	/**
	 * 自适应宽度(中文支持)
	 * 
	 * @param sheet
	 * @param size
	 */
	public static void setSizeColumn(HSSFSheet sheet, int size) {
		for (int columnNum = 0; columnNum < size; columnNum++) {
			int columnWidth = sheet.getColumnWidth(columnNum) / 256;
			for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
				HSSFRow currentRow;
				// 当前行未被使用过
				if (sheet.getRow(rowNum) == null) {
					currentRow = sheet.createRow(rowNum);
				} else {
					currentRow = sheet.getRow(rowNum);
				}

				if (currentRow.getCell(columnNum) != null) {
					HSSFCell currentCell = currentRow.getCell(columnNum);
					if (currentCell.getCellTypeEnum() == CellType.STRING) {
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

	/**
	 * 设置工作簿的一些基本样式
	 * 
	 * @param wb
	 */
	public static HSSFCellStyle setWorkbookStyle(HSSFWorkbook wb) {
		// 设置单元格风格，居中对齐.
		HSSFCellStyle cs = wb.createCellStyle();
		cs.setAlignment(HorizontalAlignment.CENTER);// 居中
		cs.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直
		HSSFFont font = wb.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 12);// 设置字体大小
		return cs;
	}

	/**
	 * 设置响应头的一些参数
	 * 
	 * @param wb
	 */
	public static void setResponseHeaderParam(HttpServletResponse response, HttpServletRequest request) {
		response.reset();
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		// 解决不同浏览器excle包名字含有中文时乱码的问题
		String downloadName = "个人工作统计" + System.currentTimeMillis() + ".xls";
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
	}

	/**
	 * 设置考核报表单元格数据
	 * 
	 * @param rows
	 * @param cellIndex
	 * @param value
	 * @param cs
	 */
	public static void setCellValue(HSSFRow rows, int cellIndex, Object value, HSSFCellStyle cs) {

		HSSFCell createCell = rows.createCell(cellIndex);
		if (value instanceof Long) {
			createCell.setCellValue((Long) value);
		} else if (value instanceof String) {
			createCell.setCellValue((String) value);
		}
		createCell.setCellStyle(cs);

	}

}
