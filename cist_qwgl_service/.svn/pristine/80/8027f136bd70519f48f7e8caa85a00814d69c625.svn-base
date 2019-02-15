package com.cist.assessStatisticalRelease.assessTotalityAnalysis.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.assessStatisticalRelease.assessTotalityAnalysis.model.PersonalScore;
import com.cist.assessStatisticalRelease.assessTotalityAnalysis.model.TotalScore;
import com.cist.assessStatisticalRelease.assessTotalityAnalysis.service.AssessTotalityAnalysisService;
import com.cist.assessStatisticalRelease.assessTotalityAnalysis.util.ExcelUtil;
import com.cist.configManage.areaPlan.model.PatrolArea;
import com.cist.configManage.areaPlan.service.AreaPlanService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 勤务个人总体分析
 * 
 * @author 57150
 *
 */
@RestController
@RequestMapping("assessTotalityAnalysis")
public class AssessTotalityAnalysisController {
	@Autowired
	private AssessTotalityAnalysisService service;
	@Autowired
	private AreaPlanService areaPlanservice;

	/**
	 * 初始化查询参数
	 * 
	 * @param paramMap
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("initParam")
	public HashMap<String, Object> initParam(@RequestBody HashMap<String, Object> paramMap)
			throws JsonProcessingException {
		List<PatrolArea> initDeptTree = areaPlanservice.initDeptTree();
		ObjectMapper obj = new ObjectMapper();
		String writeValueAsString = obj.writeValueAsString(initDeptTree);
		paramMap.put("dept", writeValueAsString);
		return paramMap;

	}

	/**
	 * 勤务个人考核分析
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("personAnalyze")
	public HashMap<String, Object> personAnalyze(@RequestBody HashMap<String, Object> paramMap) {
		paramMap.put("metrics_type", 1);
		// 获取每个的个人考核记录<包含总扣分、总加分、总指标分、总考核得分以及排名
		List<TotalScore> totalScore = service.queryTotalScore(paramMap);
		// 获取每个人对应的考核栏目指标分以及该栏目得分
		List<PersonalScore> personalScore = service.queryPersonalScore(paramMap);
		// 根据总成绩list中的警员ID与以栏目分组的list中的警员ID相比较,然后将匹配的栏目分组得分信息绑定到该个人考核的分栏目考核Map中
		service.bindPersonTopicScore(totalScore, personalScore);
		// 考核类型为1 表示个人考核,查询所有符合条件的考核栏目
		HashMap<Long, String> topicIdMap = service.queryUserTopic(paramMap);

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("3306", totalScore);
		resultMap.put("topicIdMap", topicIdMap);
		resultMap.put("topicSize", topicIdMap.size());
		return resultMap;
	}

	/**
	 * 个人勤务考核报表导出
	 * 
	 * @param paramMap
	 * @param response
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("personExportExcel")
	public HashMap<String, Object> personExportExcel(@RequestBody HashMap<String, Object> paramMap,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		paramMap.put("metrics_type", 1);
		// 准备要导出的数据并作一些数据结构的修改
		List<TotalScore> totalScore = service.queryTotalScore(paramMap);
		List<PersonalScore> personalScore = service.queryPersonalScore(paramMap);
		service.bindPersonTopicScore(totalScore, personalScore);
		
		HashMap<Long, String> topicIdMap = service.queryUserTopic(paramMap);

		// 创建一个Excel工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("勤务个人考核分析");

		HSSFCellStyle cs = ExcelUtil.setWorkbookStyle(wb);

		String[] headers = { "部门名称", "警员名称", "综合扣分", "综合加分", "考核栏目", "指标得分", "考核得分", "是否合格", "排行榜" };
		String[] number = { "评定指标", "考核评分" };

		int cellNum = (headers.length - 1) + (topicIdMap.size() * 2);

		ExcelUtil.createSheetHeader(sheet, headers, number, topicIdMap, cellNum, cs, 4, 4, "person");
		ExcelUtil.ShowSheetData(sheet, totalScore, cs, topicIdMap, "person");
		ExcelUtil.setSizeColumn(sheet, totalScore.size());

		ExcelUtil.setResponseHeaderParam(response, request);

		OutputStream out = response.getOutputStream();
		wb.write(out);
		out.close();
		return paramMap;

	}

	/**
	 * 勤务部门考核分析
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("deptAnalyze")
	public HashMap<String, Object> deptAnalyze(@RequestBody HashMap<String, Object> paramMap) {
		// 该时段所有考核栏目ID
		paramMap.put("metrics_type", 2);
		List<TotalScore> totalScore = service.queryDeptTotalScore(paramMap);
		List<PersonalScore> deptScore = service.queryDeptScore(paramMap);
		service.bindDeptTopicScore(totalScore, deptScore);

		HashMap<Long, String> topicIdMap = service.queryUserTopic(paramMap);

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("3306", totalScore);
		resultMap.put("topicIdMap", topicIdMap);
		resultMap.put("topicSize", topicIdMap.size());
		return resultMap;
	}

	/**
	 * 单位勤务考核报表导出
	 * 
	 * @param paramMap
	 * @param response
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("deptExportExcel")
	public HashMap<String, Object> deptExportExcel(@RequestBody HashMap<String, Object> paramMap,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		paramMap.put("metrics_type", 2);
		// 准备要导出的数据并作一些数据结构的修改
		List<TotalScore> totalScore = service.queryDeptTotalScore(paramMap);
		List<PersonalScore> deptScore = service.queryDeptScore(paramMap);
		service.bindDeptTopicScore(totalScore, deptScore);
		
		HashMap<Long, String> topicIdMap = service.queryUserTopic(paramMap);

		// 创建一个Excel工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("勤务单位考核分析");

		HSSFCellStyle cs = ExcelUtil.setWorkbookStyle(wb);

		String[] headers = { "部门名称", "综合扣分", "综合加分", "考核栏目", "指标得分", "考核得分", "是否合格", "排行榜" };
		String[] number = { "评定指标", "考核评分" };

		int cellNum = (headers.length - 1) + (topicIdMap.size() * 2);

		ExcelUtil.createSheetHeader(sheet, headers, number, topicIdMap, cellNum, cs, 3, 4, "dept");
		ExcelUtil.ShowSheetData(sheet, totalScore, cs, topicIdMap, "dept");
		ExcelUtil.setSizeColumn(sheet, totalScore.size());

		ExcelUtil.setResponseHeaderParam(response, request);

		OutputStream out = response.getOutputStream();
		wb.write(out);
		out.close();
		return paramMap;

	}

}
