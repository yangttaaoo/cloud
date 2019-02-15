package com.cist.evidencemanage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cist.evidencemanage.mapper.EvidenceManageMapper;
import com.cist.evidencemanage.model.C_road_item;
import com.cist.evidencemanage.model.DeptInfo;
import com.cist.evidencemanage.model.JcsjDevice;
import com.cist.evidencemanage.model.Sys_frm_code;
import com.cist.evidencemanage.model.ZjjhEvidenceAttachment;
import com.cist.evidencemanage.model.ZjjhEvidenceInfo;
import com.cist.evidencemanage.service.EvidenceManageService;
import com.cist.evidencemanage.util.FileUtil;
import com.cist.frame.page.PageInfo;

@Service
public class EvidenceManageServiceImpl implements EvidenceManageService {
	@Autowired
	private EvidenceManageMapper mapper;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public Integer save(HashMap<String, Object> map, List<MultipartFile> files, List<MultipartFile> vifiles) {
		Integer save = mapper.save(map);
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> modelMap = null;
		// 图片文件
		for (MultipartFile multipartFile : files) {
			modelMap = new HashMap<String, Object>();
			// 上传图片到FTP返回路径
			String fileUploadService = FileUtil.FileUploadService(multipartFile);
			// 0 为手动上传 1为接口提取， 接口提取需要保存提取设备id和提取时间
			if (map.get("data_source_type").equals("1")) {
				modelMap.put("fk_extract_device_id", map.get("fk_extract_device_id"));// 提取设备id
				modelMap.put("extract_time", map.get("extract_time"));// 提取时间
			}
			modelMap.put("fk_evidence_id", map.get("fk_evidence_id"));// 证据信息id
			modelMap.put("evidence_type", "0");// 证据整类型 1 为视频，0为图片
			modelMap.put("data_source_type", map.get("data_source_type"));// 证据来源
			String fName = fileUploadService.trim(); // 去除路径中的空格
			String fileName = fName.substring(fName.lastIndexOf("/") + 1);// 获取路径中的资源名称
			modelMap.put("attachment_name", fileName);// 文件名称
			modelMap.put("attachment_location", fileUploadService);// 资源路径
			list.add(modelMap);
		}
		// 视频文件
		for (MultipartFile multipartFile : vifiles) {
			modelMap = new HashMap<String, Object>();
			// 上传图片到FTP返回路径
			String fileUploadService = FileUtil.FileUploadService(multipartFile);
			// 0 为手动上传 1为接口提取， 接口提取需要保存提取设备id和提取时间
			if (map.get("data_source_type").equals("1")) {
				modelMap.put("fk_extract_device_id", map.get("fk_extract_device_id"));
				modelMap.put("extract_time", map.get("extract_time"));
			}
			modelMap.put("fk_evidence_id", map.get("fk_evidence_id"));
			modelMap.put("evidence_type", "1");// 证据整类型 1 为视频，0为图片
			modelMap.put("data_source_type", map.get("data_source_type"));// 证据来源
			String fName = fileUploadService.trim();// 去除路径中的空格
			String fileName = fName.substring(fName.lastIndexOf("/") + 1); // 获取路径中的资源名称
			modelMap.put("attachment_name", fileName);// 文件名称
			modelMap.put("attachment_location", fileUploadService);// 资源路径
			list.add(modelMap);
		}

		map.put("list", list);
		// 如果有附件信息则在数据库中新增
		if (list.size() > 0) {
			mapper.insertAttachment(map);
		}

		return save;
	}

	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.list(map);
	}

	@Override
	public List<Sys_frm_code> selectFrmCode(String fct_code) {
		return mapper.selectFrmCode(fct_code);
	}

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public Integer insertAttachment(HashMap<String, Object> map) {
		return mapper.insertAttachment(map);
	}

	@Override
	public List<C_road_item> selectRoad(HashMap<String, Object> map) {
		return mapper.selectRoad(map);
	}

	@Override
	public List<C_road_item> selectDev(HashMap<String, Object> map) {
		return mapper.selectDev(map);
	}

	@Override
	public Integer update(HashMap<String, Object> map) {
		return mapper.update(map);
	}

	@Override
	public List<ZjjhEvidenceAttachment> selectAttachment(HashMap<String, Object> map) {
		return mapper.selectAttachment(map);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public Integer insertDownload(HashMap<String, Object> map) {
		Integer insertDownload = mapper.insertDownload(map);
		return insertDownload;
	}

	@Override
	public Integer insertDownloadList(HashMap<String, Object> map) {
		return mapper.insertDownloadList(map);
	}

	@Override
	public List<ZjjhEvidenceInfo> selectPsw(HashMap<String, Object> map) {
		return mapper.selectPsw(map);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public Integer updateAll(HashMap<String, Object> map, List<MultipartFile> files, List<MultipartFile> vifiles) {
		// 判断是否有需要删除的附件信息
		if (((ArrayList) map.get("deleteId")).size() > 0) {
			Integer deleteAttachment = mapper.deleteAttachment(map);
		}

		Integer updateAll = mapper.updateAll(map);
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> modelMap = null;
		// 图片文件
		for (MultipartFile multipartFile : files) {
			modelMap = new HashMap<String, Object>();
			// 上传图片到FTP返回路径
			String fileUploadService = FileUtil.FileUploadService(multipartFile);
			// 如果为1标识为接口提取，0为手动上传，为接口提取需要保存提取设备id和提取时间
			if (map.get("data_source_type").equals("1")) {
				modelMap.put("fk_extract_device_id", map.get("fk_extract_device_id"));//
				modelMap.put("extract_time", map.get("extract_time"));//
			}
			modelMap.put("fk_evidence_id", map.get("fk_evidence_id"));//
			modelMap.put("evidence_type", "0");//
			modelMap.put("data_source_type", map.get("data_source_type"));//
			String fName = fileUploadService.trim();// 去除路径中的空格
			String fileName = fName.substring(fName.lastIndexOf("/") + 1); // 获取路径中的资源名称
			modelMap.put("attachment_name", fileName);// 文件名称
			modelMap.put("attachment_location", fileUploadService);// 资源路径

			list.add(modelMap);
		}
		// 视频文件
		for (MultipartFile multipartFile : vifiles) {
			modelMap = new HashMap<String, Object>();
			// 上传图片到FTP返回路径
			String fileUploadService = FileUtil.FileUploadService(multipartFile);
			// 如果为1标识为接口提取，否则则为手动上传，保存接口的字段
			if (map.get("data_source_type").equals("1")) {
				modelMap.put("fk_extract_device_id", map.get("fk_extract_device_id"));
				modelMap.put("extract_time", map.get("extract_time"));
			}
			modelMap.put("fk_evidence_id", map.get("fk_evidence_id"));
			modelMap.put("evidence_type", "1");
			modelMap.put("data_source_type", map.get("data_source_type"));
			String fName = fileUploadService.trim();// 去除路径中的空格
			String fileName = fName.substring(fName.lastIndexOf("/") + 1); // 获取路径中的资源名称
			modelMap.put("attachment_name", fileName);// 文件名称
			modelMap.put("attachment_location", fileUploadService);// 资源路径
			list.add(modelMap);
		}

		map.put("list", list);
		// 如果有附件信息则在数据库中新增
		if (list.size() > 0) {
			mapper.insertAttachment(map);
		}
		return updateAll;
	}

	@Override
	public Integer deleteAttachment(HashMap<String, Object> map) {
		return mapper.deleteAttachment(map);
	}

}
