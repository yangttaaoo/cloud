package com.cist.earlyewarningpost.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cist.configUrl.model.FileUtil;
import com.cist.earlyewarningpost.mapper.EarlyeWarningPostMapper;
import com.cist.earlyewarningpost.model.Depart_info;
import com.cist.earlyewarningpost.model.GpsRecord;
import com.cist.earlyewarningpost.model.JcbkBayonetUnits;
import com.cist.earlyewarningpost.model.JcbkControlBayonet;
import com.cist.earlyewarningpost.model.JcbkWarningAcceptance;
import com.cist.earlyewarningpost.model.JcbkWarningAttachment;
import com.cist.earlyewarningpost.model.JcbkWarningDispatch;
import com.cist.earlyewarningpost.model.JcbkWarningDocument;
import com.cist.earlyewarningpost.model.JcbkWarningFeedBack;
import com.cist.earlyewarningpost.model.JcbkWarningResult;
import com.cist.earlyewarningpost.model.JcbkWarningVehicle;
import com.cist.earlyewarningpost.model.Jcsj_police_res_person;
import com.cist.earlyewarningpost.model.Jcsj_police_resources;
import com.cist.earlyewarningpost.model.Qw_report;
import com.cist.earlyewarningpost.model.SysDepartInfo;
import com.cist.earlyewarningpost.model.Sys_frm_code;
import com.cist.earlyewarningpost.model.TblCarRecoInfo;
import com.cist.earlyewarningpost.service.EarlyeWarningPostService;
import com.cist.frame.page.PageInfo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONArray;

@Service("EarlyeWarningPostService")
public class EarlyeWarningPostServiceImpl implements EarlyeWarningPostService {

	@Autowired
	private EarlyeWarningPostMapper mapper;

	@Override
	public List<JcbkWarningVehicle> list(HashMap<String, Object> map) {
		return mapper.list(map);
	}

	@Override
	public List<JcbkWarningVehicle> selectYsl(HashMap<String, Object> map) {
		return mapper.selectYsl(map);
	}

	@Override
	public List<GpsRecord> gpsRecordList(HashMap<String, Object> map) {
		return mapper.gpsRecordList(map);
	}

	@Override
	public List<JcbkControlBayonet> DeviceList() {
		return mapper.DeviceList();
	}

	@Override
	public Jcsj_police_res_person Jcsjpoliceresperson(HashMap<String, Object> map) {
		return mapper.Jcsjpoliceresperson(map);
	}

	@Override
	public Jcsj_police_resources jcsjpolice_resperson(HashMap<String, Object> map) {
		return mapper.jcsjpolice_resperson(map);
	}

	@Override
	public List<SysDepartInfo> selectDeptArrea(HashMap<String, Object> map) {
		return mapper.selectDeptArrea(map);
	}

	@Override
	public List<Depart_info> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public Object selectPoliceListpageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.selectPoliceList(map);
	}

	@Override
	public List<Sys_frm_code> selectBaseData(String fct_code) {
		return mapper.selectBaseData(fct_code);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Integer update(HashMap<String, Object> map) {
		Integer update = mapper.update(map);
		mapper.insertAccept(map);// 受理信息插入
		// 受理且有效就插入调度信息  并且调度的人员不为空则插入调度信息
		if ("1".equals(map.get("acceptance_state").toString())&&((ArrayList)map.get("checkList")).size()>0) {
			Integer insertDispatch = mapper.insertDispatch(map);// 调度信息插入
			if(insertDispatch>0) {
				mapper.insertPersonnel(map);//调度的处置人员信息插入
			}
			
		}
		return update;
	}

	@Override
	public List<JcbkBayonetUnits> selectLj(HashMap<String, Object> map) {
		return mapper.selectLj(map);
	}

	@Override
	public Integer insertAccept(HashMap<String, Object> map) {
		return mapper.insertAccept(map);
	}

	@Override
	public Integer insertDispatch(HashMap<String, Object> map) {
		return mapper.insertDispatch(map);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Integer savePic(HashMap<String, Object> map, List<MultipartFile> files) {
		ObjectMapper objectMapper = new ObjectMapper();
		List piclist=new ArrayList<String>();
		try {
			if(map.get("deletePic")!=null) {
				piclist	=objectMapper.readValue(map.get("deletePic").toString(), ArrayList.class);
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} //JSON转List
		if("true".equals(map.get("picFlag").toString())) {
			//2、使用JSONArray
			if(piclist.size()>0) {
				map.put("deletePic", piclist);
				mapper.deletePic(map); //先删除图片
			}
	        
		}
		if (files.size() > 0) {
			List<JcbkWarningAttachment> list = new ArrayList<>();
			for (MultipartFile multipartFile : files) {
				JcbkWarningAttachment attachment = new JcbkWarningAttachment();
				String fileUploadService = FileUtil.FileUploadService(multipartFile);
				String fName = fileUploadService.trim();// 去除路径中的空格
				String fileName = fName.substring(fName.lastIndexOf("/") + 1); // 获取路径中的资源名称
				// 文件名称
				attachment.setAttachment_name(fileName.substring(0, fileName.indexOf(".")));
				// 文件后缀名
				attachment.setAttachment_suffix(fileName.substring(fileName.indexOf("."), fileName.length()));
				attachment.setAttachment_source(fileUploadService);// 文件资源路径
				attachment.setAttachment_size(multipartFile.getSize() / 1024 + "");// 文件大小
				list.add(attachment);// 添加到list用作批量插入
			}
			map.put("list", list);// 附件列表信息
			Integer savePic = mapper.savePic(map);
		}
			
		return 1;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Integer insertFeedBack(HashMap<String, Object> map) {
		Integer update = mapper.update(map);
		if(update>0) {
			Integer insertFeedBack = mapper.insertFeedBack(map);
		}
	   if(map.get("cljgList")!=null&&((ArrayList)map.get("cljgList")).size()>0) {
		   mapper.insertResult(map);//处理结果插入
	   }
	   if(map.get("wenshuList")!=null&&((ArrayList)map.get("wenshuList")).size()>0) {
		   mapper.insertDocument(map);//文书插入
	   }
		return update;
	}

	@Override
	public Integer insertPersonnel(HashMap<String, Object> map) {
		return mapper.insertPersonnel(map);
	}

	@Override
	public JcbkWarningAcceptance selectAcceptance(HashMap<String, Object> map) {
		return mapper.selectAcceptance(map);
	}

	@Override
	public Integer insertResult(HashMap<String, Object> map) {
		return mapper.insertResult(map);
	}

	@Override
	public Integer insertDocument(HashMap<String, Object> map) {
		return mapper.insertDocument(map);
	}

	@Override
	public JcbkWarningFeedBack selectFeedBack(HashMap<String, Object> map) {
		return mapper.selectFeedBack(map);
	}

	@Override
	public JcbkWarningDispatch selectDispatch(HashMap<String, Object> map) {
		return mapper.selectDispatch(map);
	}

	@Override
	public List<JcbkWarningAttachment> selectAttachment(HashMap<String, Object> map) {
		return mapper.selectAttachment(map);
	}

	@Override
	public Integer deletePic(HashMap<String, Object> map) {
		return mapper.deletePic(map);
	}

	@Override
	public List<JcbkWarningResult> selectResult(HashMap<String, Object> map) {
		return mapper.selectResult(map);
	}

	@Override
	public List<JcbkWarningDocument> selectDocument(HashMap<String, Object> map) {
		return mapper.selectDocument(map);
	}

	@Override
	public Object selectListpageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.selectList(map);
	}

	@Override
	public List<JcbkControlBayonet> selectBkkk(HashMap<String, Object> map) {
		return mapper.selectBkkk(map);
	}

	@Override
	public List<TblCarRecoInfo> selectTrajectory(HashMap<String, Object> map) {
		return mapper.selectTrajectory(map);
	}

	@Override
	public List<Jcsj_police_res_person> selectPolice(HashMap<String, Object> map) {
		return mapper.selectPolice(map);
	}

	@Override
	public List<Qw_report> selectQwbb(HashMap<String, Object> map) {
		return mapper.selectQwbb(map);
	}

}
