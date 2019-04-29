package com.cist.feedbackRes.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cist.feedback.model.QwCompanyAssessment;
import com.cist.feedbackRes.service.FeedbackResService;
import com.cist.frame.page.PageInfo;

@RestController
@RequestMapping("feedbackRes")
public class FeedbackResController {
	@Autowired
	private FeedbackResService service;

	/**
	 * 查询数据
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/list")
	public PageInfo<QwCompanyAssessment> selectData(@RequestBody HashMap<String, Object> map) {
		try {
			PageInfo page = new PageInfo();
			page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<QwCompanyAssessment> info = (PageInfo<QwCompanyAssessment>) service.listpageList(map, page);
			return info;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 更新评定栏目分值数据
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/updateMetrics")
	public String updateMetrics(@RequestBody HashMap<String, Object> map) {
		try {

			Integer update = service.updateMetrics(map);
			if (update > 0) {
				return "{\"result\":\"更新成功\"}";
			} else {
				return "{\"result\":\"更新失败\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 保存数据
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/save")
	public String save(@RequestParam HashMap<String, Object> map,List<MultipartFile> files,HttpServletRequest request) {
		try {

			HttpSession session = request.getSession();
			Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
			String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
			map.put("fk_commit_person_id", userPk);//获取条件人pk
			Integer save = service.save(map,files);
			if (save > 0) {
				return "{\"result\":\"保存成功\"}";
			} else {
				return "{\"result\":\"保存失败\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}