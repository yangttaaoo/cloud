package com.cist.myDuty.myAssess.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cist.configManage.areaPlan.model.TempModel;
import com.cist.frame.page.PageInfo;
import com.cist.myDuty.myAssess.mapper.MyAssessMapper;
import com.cist.myDuty.myAssess.model.FeedbackResponse;
import com.cist.myDuty.myAssess.model.GpsRecord;
import com.cist.myDuty.myAssess.model.OffSiteQuery;
import com.cist.myDuty.myAssess.model.QwAssessmentAttachment;
import com.cist.myDuty.myAssess.model.ReportStreet;
import com.cist.myDuty.myAssess.model.SignIn;
import com.cist.myDuty.myAssess.service.MyAssessService;
import com.cist.myDuty.myAssess.util.FileUtil;

@Service
public class MyAssessServiceImpl implements MyAssessService {
	@Autowired
	private MyAssessMapper mapper;

	@Override
	public Object queryAssesspageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		// TODO Auto-generated method stub
		return mapper.queryAssessList(paramMap);
	}

	@Override
	public List<TempModel> queryAssessItem() {
		// TODO Auto-generated method stub
		return mapper.queryAssessItem();
	}

	@Override
	public int addfeedback(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.addfeedback(paramMap);
	}

	@Override
	public FeedbackResponse queryHaveFeedback(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.queryHaveFeedback(paramMap);
	}

	@Override
	public ReportStreet queryReportStreet(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.queryReportStreet(paramMap);
	}

	@Override
	public Object queryOffSiteQuerypageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		// TODO Auto-generated method stub
		return mapper.getOffSiteQuerybyUserId(paramMap);
	}

	@Override
	public List<SignIn> querySignIn(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.querySignIn(paramMap);
	}

	@Override
	public List<GpsRecord> queryTrackPlayback(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.queryTrackPlayback(paramMap);
	}

	@Override
	public List<QwAssessmentAttachment> queryAssessAttachment(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.queryAssessAttachment(paramMap);
	}

	@Override
	public String addAssessAttachment(List<MultipartFile> files, String relation_id, String user_id,String constraint) {
		List<QwAssessmentAttachment> list = new ArrayList<QwAssessmentAttachment>();
		for (int i = 0; i < files.size(); i++) {
			QwAssessmentAttachment attachment = new QwAssessmentAttachment();
			String path;
			try {
				path = FileUtil.FileUploadService(files.get(i), i);
			} catch (Exception e) {
				return "文件上传异常!";
			} // 附件路径
			if (!"false".equals(path)) {
				// 设置关联为我的考核反馈记录的ID //fk_relation_id
				attachment.setFk_relation_id(Integer.parseInt(relation_id));
				// 附件名称
				attachment.setAttachment_name(path.substring(0, path.lastIndexOf(".")));
				// 附件后缀名
				attachment.setAttachment_suffix(path.substring(path.lastIndexOf("."), path.length()));
				// 附件大小
				attachment.setAttachment_size(Long.toString(files.get(i).getSize()));
				// 附件路径
				attachment.setAttachment_source("http://192.168.0.111/" + path);
				// 提交人ID
				attachment.setFk_commit_person_id(Integer.parseInt(user_id));
				// 关联区分标识(自定义)
				attachment.setConstraint(constraint);
				list.add(attachment);
			} else {
				return "文件上传失败!";
			}
		}
		if (list.size() > 0) {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("list", list);
			int addAssessAttachment = mapper.addAssessAttachment(paramMap);
			if (addAssessAttachment > 0)
				return "1";
			else
				return "附件信息保存失败!";
		}
		return "1";
	}

}
