package com.cist.earlyewarningpost.controller;

import java.util.ArrayList;
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

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.earlyewarningpost.model.Depart_info;
import com.cist.earlyewarningpost.model.GpsRecord;
import com.cist.earlyewarningpost.model.JcbkBayonetUnits;
import com.cist.earlyewarningpost.model.JcbkControlBayonet;
import com.cist.earlyewarningpost.model.JcbkFenceArea;
import com.cist.earlyewarningpost.model.JcbkWarningAcceptance;
import com.cist.earlyewarningpost.model.JcbkWarningAttachment;
import com.cist.earlyewarningpost.model.JcbkWarningDispatch;
import com.cist.earlyewarningpost.model.JcbkWarningDocument;
import com.cist.earlyewarningpost.model.JcbkWarningFeedBack;
import com.cist.earlyewarningpost.model.JcbkWarningResult;
import com.cist.earlyewarningpost.model.JcbkWarningVehicle;
import com.cist.earlyewarningpost.model.Jcsj_police_res_person;
import com.cist.earlyewarningpost.model.Jcsj_police_resources;
import com.cist.earlyewarningpost.model.Qw_gps_history;
import com.cist.earlyewarningpost.model.SysConfig;
import com.cist.earlyewarningpost.model.SysDepartInfo;
import com.cist.earlyewarningpost.model.Sys_frm_code;
import com.cist.earlyewarningpost.model.TblCarRecoInfo;
import com.cist.earlyewarningpost.service.EarlyeWarningPostService;
import com.cist.frame.page.PageInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/warningPost")
public class EarlyeWarningPostController {

	@Autowired
	EarlyeWarningPostService service;

	/**
	 * 车辆预警信息查询
	 * 
	 * @param request 请求
	 */
	@RequestMapping(value = "list")
	public Map<String, Object> list(@RequestBody HashMap<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("list", service.list(map));// 查询全部预警信息
		map.put("event_current_status", "0");// 0 为未受理
		modelMap.put("weishouli", service.list(map));// 查询全部预警信息
		modelMap.put("yishouli", service.selectYsl(map));// 查询已受理预警信息
		return modelMap;
	}

	/**
	 * 设备列表查询
	 * 
	 * @param map
	 */
	@RequestMapping("devicelist")
	public HashMap<String, Object> DeviceList(@RequestBody HashMap<String, Object> map) {
		List<JcbkControlBayonet> deviceList = service.DeviceList();
		List<GpsRecord> gpsRecordList = service.gpsRecordList(map);
		map.put("Appraiselist", deviceList);// 布控卡口
		map.put("gpsRecordList", gpsRecordList);// 警员警车信息
//		map.put("zzclsjjy", service.zzclsjjy(map));//正在处理事件的警员
		return map;
	}

	/**
	 * 5.23.查询警员信息
	 * 
	 * @param map
	 */
	@RequestMapping("jcsjpoliceresperson")
	public Jcsj_police_res_person jcsjpoliceresperson(@RequestBody HashMap<String, Object> map) {
		return service.Jcsjpoliceresperson(map);
	}

	/**
	 * 5.23. 警务资源信息 设备编号
	 * 
	 * @param map
	 */
	@RequestMapping("jcsjpolice")
	public Jcsj_police_resources jcsjpolice_resperson(@RequestBody HashMap<String, Object> map) {
		return service.jcsjpolice_resperson(map);
	}

	/**
	 * 布控卡口拦截单位  单位关联区域
	 * @param map
	 */
	@RequestMapping("selectDeptArrea")
	public Map<String,Object> selectDeptArrea(@RequestBody HashMap<String, Object> map) {
		Map<String,Object> modelMap = new HashMap<String,Object>();
		List<SysDepartInfo> selectDeptArrea = service.selectDeptArrea(map);
		List<JcbkControlBayonet> selectBkDev = service.selectBkDev(map);
		modelMap.put("deptArrea", selectDeptArrea);
		modelMap.put("bkDev", selectBkDev);
		return modelMap;
				
	}
	/**
	 * 根据当前用户的部门把顶级部门树设置为当前部门
	 * @return
	 * @throws JsonProcessingException
	 */	
private List<Depart_info> topDept(Map<String,Object> map) {
	List<Depart_info> departinfo = new ArrayList<Depart_info>();
	Depart_info  dept = new Depart_info();
	dept.setDept_code(map.get("sypi_dept_code")==null?null:map.get("sypi_dept_code").toString());
	dept.setDept_pk(map.get("sypi_dept_pk")==null?null:Integer.valueOf(map.get("sypi_dept_pk").toString()));
	dept.setName(map.get("sypi_dept_name")==null?null:map.get("sypi_dept_name").toString());
	departinfo.add(dept);
	return departinfo;
}
//	request
	@RequestMapping("departinfo")
	public String departinfo(@RequestBody HashMap<String,Object> map,HttpServletRequest request) throws JsonProcessingException {
		// 当前用户的部门 用于部门权限设置
				HttpSession session = request.getSession();
				Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
				// 顶级部门 null
//				List<Depart_info> departinfo = topDept(userMap);
				map.put("dept_code", userMap.get("sypi_dept_code"));
				List<Depart_info> departinfo = service.depart_infolist(map);
		ObjectMapper mapper = new ObjectMapper();
		List<Depart_info> list = departinfodg(departinfo,map);
		String json = mapper.writeValueAsString(getdiwfdidian(list));
		return json.substring(1, json.length() - 1);
	}

	public List<Depart_info> departinfodg(List<Depart_info> departinfo,HashMap<String,Object> map) {
		for (Depart_info depart_info : departinfo) {
			map.put("dept_code", null);
			map.put("dept_pk", depart_info.getDept_pk());
			List<Depart_info> list = service.depart_infolist(map);
			depart_info.setChildren(list);
			if (null != list) {
				departinfodg(list,map);
			}
		}
		return departinfo;
	}

	public List<HashMap<String, Object>> getdiwfdidian(List<Depart_info> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("data", depart_info.getGeo_spatial());
			map.put("key", depart_info.getDept_code());
			map.put("isLeaf", depart_info.getIsLeaf());
			if (null != depart_info.getChildren()) {// 下级

				map.put("children", getdiwfdidian(depart_info.getChildren()));
				listmap.add(map);
			} else {
				listmap.add(map);
			}
		}
		return listmap;
	}

	@RequestMapping("departinfo1")
	public String departinfo1(@RequestBody HashMap<String,Object> map,HttpServletRequest request) throws JsonProcessingException {
		// 顶级部门 null
		List<Depart_info> departinfo = service.depart_infolist(map);
		ObjectMapper mapper = new ObjectMapper();
		List<Depart_info> list = departinfodg(departinfo,map);
		String json = mapper.writeValueAsString(getdiwfdidian1(list));
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getdiwfdidian1(List<Depart_info> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_pk().toString());
			map.put("isLeaf", depart_info.getIsLeaf());
			if (null != depart_info.getChildren()) {// 下级

				map.put("children", getdiwfdidian1(depart_info.getChildren()));
				listmap.add(map);
			} else {
				listmap.add(map);
			}
		}
		return listmap;
	}

	/**
	 * 实时预警处理首页，预警信息查询
	 * 
	 * @param map
	 */
	@RequestMapping("selectPoliceList")
	public PageInfo<Jcsj_police_res_person> selectPoliceList(@RequestBody HashMap<String, Object> modelMap) {
		PageInfo pinfo = new PageInfo();
		pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
		PageInfo<Jcsj_police_res_person> list = (PageInfo<Jcsj_police_res_person>) service
				.selectPoliceListpageList(modelMap, pinfo);
		return list;
	}

	/**
	 * 基础数据查询
	 * 
	 * @param map
	 */
	@RequestMapping("selectBaseData")
	public List<Sys_frm_code> selectBaseData(@RequestBody HashMap<String, Object> map) {
		map.put("fct_code", "JC01");
		return service.selectBaseData("JC01");
	}

	/**
	 * 更新预警信息状态
	 * 
	 * @param map
	 */
	@RequestMapping("update")
	public String update(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<String, Object> userMap = (Map<String, Object>) session.getAttribute("userInfo" + session.getId());
		String userPk = userMap.get("sypi_pk") == null ? null : userMap.get("sypi_pk").toString();
		String deptCode = userMap.get("sypi_dept_pk") == null ? null : userMap.get("sypi_dept_pk").toString();
		map.put("fk_acceptance_person_id", userPk);// 操作人pk
		map.put("fk_acceptance_dept_id", deptCode);// 操作部门代码
		Integer update = service.update(map);
		if (update > 0) {
			return "{\"result\":\"成功\"}";
		} else {

			return "{\"result\":\"失败\"}";
		}

	}

	/**
	 * 查询预警信息的拦截单位信息
	 * 
	 * @param map
	 */
	@RequestMapping("selectLj")
	public Map<String, Object> selectLj(@RequestBody HashMap<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<JcbkBayonetUnits> selectLj = service.selectLj(map);
		modelMap.put("ljList", selectLj);
		return modelMap;
	}

	/**
	 * 反馈
	 * 
	 * @param map
	 */
	@RequestMapping("feedBack")
	public String feedBack(@RequestParam HashMap<String, Object> map, List<MultipartFile> files) {
		Integer savePic = service.savePic(map, files);
		if (savePic > 0) {
			return "{\"result\":\"成功\"}";
		} else {
			return "{\"result\":\"失败\"}";
		}

	}

	/**
	 * 流程信息查询
	 * 
	 * @param map
	 */
	@RequestMapping("selectProcess")
	public Map<String, Object> selectProcess(@RequestBody HashMap<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 若预警信息为已受理 查询受理信息
		JcbkWarningAcceptance selectAcceptance = service.selectAcceptance(map);
		modelMap.put("acceptanceList", selectAcceptance);
		// 已调度
		if (map.get("event_current_status")!=null && ("2".equals(map.get("event_current_status").toString())
				|| "3".equals(map.get("event_current_status").toString()))) {
			JcbkWarningDispatch selectDispatch = service.selectDispatch(map);// 调度信息
			modelMap.put("dispatchList", selectDispatch);
		}
		// 已完成 则有处置信息
		if ( map.get("event_current_status")!=null &&"3".equals(map.get("event_current_status").toString())) {
			JcbkWarningFeedBack selectFeedBack = service.selectFeedBack(map);
			modelMap.put("feedBackList", selectFeedBack);// 处置信息
			List<JcbkWarningResult> selectResult = service.selectResult(map);
			modelMap.put("cljgList", selectResult);// 处理结果
			List<JcbkWarningDocument> selectDocument = service.selectDocument(map);
			modelMap.put("wenshuList", selectDocument);// 文书信息
		}
		// 反馈附件信息
		List<JcbkWarningAttachment> selectAttachment = service.selectAttachment(map);
		modelMap.put("attachmentList", selectAttachment);

		return modelMap;
	}

	/**
	 * 基础数据查询
	 * 
	 * @param map
	 */
	@RequestMapping("selectBaseDataList")
	public Map<String, Object> selectBaseDataList(@RequestBody HashMap<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 未拦截到原因
		List<Sys_frm_code> selectBaseData = service.selectBaseData(SysBaseDataCode.SYS_WLJYY);
		modelMap.put("ljyyList", selectBaseData);

		// 嫌疑类型
		modelMap.put("xylxList", service.selectBaseData(SysBaseDataCode.SYS_XYLX));

		// 非嫌疑车辆原因
		modelMap.put("fxyList", service.selectBaseData(SysBaseDataCode.SYS_FXYCLYY));

		// 处理结果
		modelMap.put("cljgList", service.selectBaseData(SysBaseDataCode.SYS_CLJG));

		// 文书类别
		modelMap.put("wslbList", service.selectBaseData(SysBaseDataCode.SYS_WSLB));
		return modelMap;
	}

	/**
	 * 更新预警信息状态
	 * 
	 * @param map
	 */
	@RequestMapping("insertFeedBack")
	public String insertFeedBack(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<String, Object> userMap = (Map<String, Object>) session.getAttribute("userInfo" + session.getId());
		String userPk = userMap.get("sypi_pk") == null ? null : userMap.get("sypi_pk").toString();
		String deptCode = userMap.get("sypi_dept_pk") == null ? null : userMap.get("sypi_dept_pk").toString();
		map.put("fk_acceptance_person_id", userPk);// 操作人pk
		map.put("fk_acceptance_dept_id", deptCode);// 操作部门代码
		Integer update = service.insertFeedBack(map);
		if (update > 0) {
			return "{\"result\":\"成功\"}";
		} else {

			return "{\"result\":\"失败\"}";
		}

	}

	/**
	 * 车辆预警信息查询
	 * 
	 * @param request 请求
	 */
	@RequestMapping(value = "selectList")
	public PageInfo<List<JcbkWarningVehicle>> selectList(@RequestBody HashMap<String, Object> map) {
		PageInfo pinfo = new PageInfo();
		pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<List<JcbkWarningVehicle>> selectListpageList = (PageInfo<List<JcbkWarningVehicle>>) service
				.selectListpageList(map, pinfo);
		return selectListpageList;
	}

	/**
	 * 列表首页下拉框信息
	 * 
	 * @param request 请求
	 */
	@RequestMapping(value = "selectListData")
	public Map<String, Object> selectListData(@RequestBody HashMap<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();

		// 号牌种类
		modelMap.put("hpzlList", service.selectBaseData(SysBaseDataCode.SYS_HPZL));
		// 布控类型
		modelMap.put("bklxList", service.selectBaseData(SysBaseDataCode.SYS_BKLX));
		// 布控卡口信息
		modelMap.put("bkkkList", service.selectBkkk(map));
		return modelMap;

	}

	/**
	 * 实时跟踪车辆轨迹信息查询
	 * 
	 * @param request 请求
	 */
	@RequestMapping(value = "selectTrajectory")
	public Map<String, Object> selectTrajectory(@RequestBody HashMap<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();

		List<TblCarRecoInfo> selectTrajectory = service.selectTrajectory(map);
		modelMap.put("list", selectTrajectory);
		return modelMap;

	}

	/**
	 * 基础数据查询
	 * 
	 * @param map
	 */
	@RequestMapping("selectHp")
	public Map<String, Object> selectHp(@RequestBody HashMap<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 号牌种类
		modelMap.put("hpzlList", service.selectBaseData(SysBaseDataCode.SYS_HPZL));
		return modelMap;
	}
	
	/**
	 * 根据部门查询警员信息
	 * 
	 * @param map
	 */
	@RequestMapping("selectPolice")
	public Map<String, Object> selectPolice(@RequestBody HashMap<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 警员信息
		modelMap.put("policList", service.selectPolice(map));
		return modelMap;
	}
	
	/**
	 * 根据部门查询当日街面勤务报备关联人员
	 * 
	 * @param map
	 */
	@RequestMapping("selectQwbb")
	public Map<String, Object> selectQwbb(@RequestBody HashMap<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("policList", service.selectQwbb(map));
		return modelMap;
	}
	
	/**
	 * 查询基础配置信息中的 国标视频地址
	 * @param map
	 */
	@RequestMapping("selectConfig")
	public SysConfig selectConfig(@RequestBody HashMap<String, Object> map) {
		map.put("syci_key", "GBVIDEOURL");
		return service.selectConfig(map);
	}
	
	
	/**
	 * 查询布控卡口拦截区域信息
	 * @param map
	 */
	@RequestMapping("selectArea")
	public List<JcbkFenceArea> selectArea(@RequestBody HashMap<String, Object> map) {
		return service.selectArea(map);
	}
	
	/**
	 *查询警车警员历史定位信息
	 * @param map
	 * @return
	 */
	@RequestMapping("selectGpsHistory")
	public Map<String,Object> selectGpsHistory(@RequestBody HashMap<String, Object> map,HttpServletRequest request){	
		List<Qw_gps_history> selectGpsHistory = service.selectGpsHistory(map);
		map.put("gpsList", selectGpsHistory);
		return map;
	}
}
