package com.cist.dutyAssess.PerAssessResultFeedbackReply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cist.myDuty.myAssess.service.MyAssessService;
@RestController
@RequestMapping("assessReply")
public class PerAssessResultFeedbackReplyController {
	
	@Autowired
	private MyAssessService myAssessService;
	/**
	 * 增加一条个人考核的回复信息
	 * 
	 * @param paramMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("addReply")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public HashMap<String, Object> addReply(@RequestParam HashMap<String, Object> paramMap,
			List<MultipartFile> files, HttpServletRequest request) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("flag", 1);
		resultMap.put("title", "回复成功!");
		try {
			int addfeedback = myAssessService.addfeedback(paramMap);
			if (addfeedback > 0) {
				// 获取 设置关联为我的考核报备ID fk_relation_id
				String relation_id = paramMap.get("fk_assessment_id").toString();
				// 获取当前登陆用户Id
				HttpSession session = request.getSession();
				Map<String, Object> userInfo = (Map<String, Object>) session.getAttribute("userInfo" + session.getId());
				String user_id = userInfo.get("sypi_pk") == null ? null : userInfo.get("sypi_pk").toString();
				String upload = myAssessService.addAssessAttachment(files, relation_id, user_id,"wdhffj");
				if (!"1".equals(upload)) {
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					resultMap.put("flag", 0);
					resultMap.put("title", upload);
					return resultMap;
				}
			} else {
				resultMap.put("flag", 1);
				resultMap.put("title", "回复成功!");
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultMap.put("flag", 0);
			resultMap.put("title", "回复异常!");
		}
		return resultMap;

	}
}
