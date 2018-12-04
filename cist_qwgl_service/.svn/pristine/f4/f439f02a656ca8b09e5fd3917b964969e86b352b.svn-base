package com.cist.feedback.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cist.feedback.mapper.FeedbackMapper;
import com.cist.feedback.model.DeptInfo;
import com.cist.feedback.model.QWAppraiseFeedbackResponse;
import com.cist.feedback.model.QwAppraiseTopic;
import com.cist.feedback.model.QwAssessmentAttachment;
import com.cist.feedback.model.Sys_frm_code;
import com.cist.feedback.service.FeedbackService;
import com.cist.feedback.util.FileUtil;
import com.cist.frame.page.PageInfo;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackMapper mapper;

	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo page) {
		return mapper.list(map);
	}

	@Override
	public Integer update(HashMap<String, Object> map) {
		return mapper.update(map);
	}

	@Override
	public Integer delete(HashMap<String, Object> map) {
		return mapper.delete(map);
	}

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public List<Sys_frm_code> selectBaseData(HashMap<String, Object> map) {
		return mapper.selectBaseData(map);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public Integer save(HashMap<String, Object> map, List<MultipartFile> files) {
		Integer save = mapper.save(map);
		if (files.size() > 0) {
			List<QwAssessmentAttachment> list = new ArrayList<>();
			for (MultipartFile multipartFile : files) {
				QwAssessmentAttachment attachment = new QwAssessmentAttachment();
				String fileUploadService = FileUtil.FileUploadService(multipartFile);
				String fName = fileUploadService.trim();// 去除路径中的空格
				String fileName = fName.substring(fName.lastIndexOf("/") + 1); // 获取路径中的资源名称
				// 文件名称
				attachment.setAttachment_name(fileName.substring(0, fileName.indexOf(".")));
				// 文件后缀名
				attachment.setAttachment_suffix(fileName.substring(fileName.indexOf("."), fileName.length()));
				attachment.setAttachment_source(fileUploadService);// 文件资源路径
				attachment.setAttachment_size(multipartFile.getSize() / 1024 + "");// 文件大小
				// 提交人id
				attachment.setFk_commit_person_id(Integer.valueOf(map.get("fk_commit_person_id").toString()));
				// 附件关联id 通过保存反馈信息返回回来的id
				attachment.setFk_relation_id(Integer.valueOf(map.get("id").toString()));
				attachment.setConstraint(map.get("constraint").toString());// 附件功能标识
				list.add(attachment);// 添加到list用作批量插入

			}
			if (save > 0) {
				map.put("list", list);
				mapper.savePic(map);
			}
		}

		return save;
	}

	@Override
	public List<QWAppraiseFeedbackResponse> selectResponse(HashMap<String, Object> map) {
		return mapper.selectResponse(map);
	}

	@Override
	public List<QwAssessmentAttachment> selectPicList(HashMap<String, Object> map) {
		return mapper.selectPicList(map);
	}

	@Override
	public Integer savePic(HashMap<String, Object> map) {
		return mapper.savePic(map);
	}

	@Override
	public List<QwAppraiseTopic> selectLm(HashMap<String, Object> map) {
		return mapper.selectLm(map);
	}

}
