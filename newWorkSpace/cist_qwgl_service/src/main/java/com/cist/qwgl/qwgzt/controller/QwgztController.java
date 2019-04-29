package com.cist.qwgl.qwgzt.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
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

import com.cist.qwgl.qwgzt.model.CarInfo;
import com.cist.qwgl.qwgzt.model.Need;
import com.cist.qwgl.qwgzt.model.Police;
import com.cist.qwgl.qwgzt.model.PoliceCar;
import com.cist.qwgl.qwgzt.service.QwgztService;

@RestController
@RequestMapping("qwgzt")
public class QwgztController {
	@Autowired
	private QwgztService service;

	@RequestMapping("queryneed")
	public Need queryneed(@RequestBody HashMap<String, Object> map) {
		String date = (String) map.get("date");
		String[] dates = date.split("-");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cale = null;
		int year = Integer.valueOf(dates[0]);
		int month = Integer.valueOf(dates[1]);
		String firstday, lastday;
		// 获取前月的第一天
		cale = Calendar.getInstance();
		cale.set(Calendar.YEAR, year);
		cale.set(Calendar.MONTH, month - 1);
		cale.set(Calendar.DAY_OF_MONTH, 1);
		cale.set(Calendar.HOUR_OF_DAY, 0);
		cale.set(Calendar.MINUTE, 0);
		cale.set(Calendar.SECOND, 0);
		firstday = sdf.format(cale.getTime());
		// 获取前月的最后一天
		cale = Calendar.getInstance();
		cale.set(Calendar.YEAR, year);
		cale.set(Calendar.MONTH, month);
		cale.set(Calendar.DAY_OF_MONTH, 0);
		cale.set(Calendar.HOUR_OF_DAY, 23);
		cale.set(Calendar.MINUTE, 59);
		cale.set(Calendar.SECOND, 59);
		lastday = sdf.format(cale.getTime());
		map.put("kssj", firstday);
		map.put("jssj", lastday);

		Set<Need> needs = service.queryNeed(map);
		String cx = null;
		String zqmj, zqxj;
		Integer countmj = 0, countxj = 0, countCar = 0;
		for (Need need : needs) {
			zqmj = need.getZqmj();
			zqxj = need.getZqxj();
			countmj += zqmj.split(",").length;
			countxj += zqxj.split(",").length;
			cx = need.getCx();
			List<CarInfo> carInfos = service.queryCar(cx);
			countCar = carInfos.size();
			for (int i = 0; i < countCar; i++) {
				countmj += carInfos.get(i).getZqmj().split(",").length;
				countxj += carInfos.get(i).getZqxj().split(",").length;
			}
			countCar = carInfos.size();
		}
		Need need = new Need();
		need.setCountmj(countmj);
		need.setCountcar(countCar);
		need.setCountxj(countxj);

		return need;
	}

	@RequestMapping("querydiaodu")
	public Map<String, Object> querydiaodu(@RequestBody HashMap<String, Object> parammap) {
		// List<PbglPolice> pbglPolices = service.selectPbglPolice(today);
		// String[] zqmjs = pbglPolice.getZqmj().split(",");
		// String[] zqxjs = pbglPolice.getZqxj().split(",");
		HashMap<String, Object> map = new HashMap<>();
		HashMap<String, Object> resultmap = new HashMap<>();
		map.put("sypi_kind", "2");
		// map.put("zhiban", zqmjs);
		List<Police> ddzqmj = service.selectPolice(map);
		map.put("sypi_kind", "3");
		// map.put("zhiban", zqxjs);
		List<Police> ddzqxj = service.selectPolice(map);
//		resultmap.put("ddzqxj", ddzqxj);
//		resultmap.put("ddzqmj", ddzqmj);
		map.put("today", parammap.get("today"));
		List<PoliceCar> policeCars = service.selectPoliceCarCount(map);
//		resultmap.put("policeCars", policeCars);
		String result = "";
		String dept = "部门:";
		String zqmjstr = "执勤民警:";
		String zqxjstr = "执勤协警:";
		String zqclstr = "执勤车辆:";
		List<String> returnresult = new ArrayList<>();
		List<String> depts = service.querydepts();
		for (String deptname : depts) {
			dept += deptname;
			int total = 0;
			for (int i = 0; i < ddzqmj.size(); i++) {
				Police police = ddzqmj.get(i);
				if (police.getDept_name().equals(deptname)) {
					total ++;
					zqmjstr += police.getPolicename() + "、";
				}
			}
			dept += "(民警"+total+"人"; 
			total = 0;
			for (int i = 0; i < ddzqxj.size(); i++) {
				Police police = ddzqxj.get(i);
				if (police.getDept_name().equals(deptname)) {
					total ++;
					zqxjstr += police.getPolicename() + "、";
				}
			}
			dept += "、协警"+total+"人"; 
			total = 0;
			for (int i = 0; i < policeCars.size(); i++) {
				PoliceCar policeCar = policeCars.get(i);
				String dept_name = policeCar.getDept_name();
				if (dept_name != null && dept_name != "" && dept_name.equals(deptname)) {
					total ++;
					zqclstr += policeCar.getHphm() + "、";
				}
			}
			dept += "、车辆"+total+"台)"; 
			result = dept + "\r\n" + zqmjstr + "\r\n" + zqxjstr + "\r\n" + zqclstr;
			returnresult.add(result);
			result = "";
			dept = "部门:";
			zqmjstr = "执勤民警:";
			zqxjstr = "执勤协警:";
			zqclstr = "执勤车辆:";
		}
		resultmap.put("data", returnresult);
		resultmap.put("countzqmj", ddzqmj.size());
		resultmap.put("countzqxj", ddzqxj.size());
		resultmap.put("countcar", policeCars.size());
		resultmap.put("deptsize", depts.size());
		return resultmap;
	}

	@RequestMapping("excel")
	public void export(HttpServletResponse response, String date,String[] data) throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("可调度人员表");
		HSSFRow row = null;
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
//		HSSFCell cell = null;
//		row.createCell(0).setCellStyle(style);
		sheet.addMergedRegion(new CellRangeAddress(0,data.length-1,0,0));
		for (int i = 0; i < data.length; i++) {
			row = sheet.createRow(i);
			if (i==0) {
				row.createCell(0).setCellValue(date);
			}
			// 将内容按顺序赋给对应的列对象
			row.createCell(1).setCellValue(data[i]);
			row.setRowStyle(style);
		}
		
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition",
				"attachment;filename=" + java.net.URLEncoder.encode("可调度人员表", "UTF-8") + ".xls");
		OutputStream outputStream = response.getOutputStream();
		wb.write(outputStream);
		outputStream.flush();
		outputStream.close();
		wb.close();
	}
}
