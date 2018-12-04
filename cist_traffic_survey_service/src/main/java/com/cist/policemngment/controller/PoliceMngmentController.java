package com.cist.policemngment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.policemngment.model.DeptInfo;
import com.cist.policemngment.model.Jcsj_P_R_Allot;
import com.cist.policemngment.model.Jcsj_P_R_Have;
import com.cist.policemngment.model.Jcsj_police_resourc;
import com.cist.policemngment.model.SysPoliceInfo;
import com.cist.policemngment.service.PoliceMngmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.jsqlparser.statement.select.First;

@RestController
@RequestMapping("management")
public class PoliceMngmentController {

	@Autowired
	private PoliceMngmentService pmService;
	
	/**
	 * 分页及条件查询
	 * @return
	 */
	@RequestMapping("index")
	public PageInfo<Jcsj_police_resourc> selectByResourc(@RequestBody Map<String, Object> map){
		PageInfo pinfo = new PageInfo<>();
		pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Jcsj_police_resourc> pageinfo = (PageInfo<Jcsj_police_resourc>)pmService.selectByRespageList(map,pinfo);
		return pageinfo;
		
	}
	
	/**
	 * 新增警务资源管理 
	 * @param map
	 * @return
	 */
	@RequestMapping("add")
	public Integer addResourc(@RequestBody Map<String, Object> map){
		Integer isAdd = pmService.insetResourc(map);
		String[] newCodeArray ={};
		if(map.get("codeString") != null){
			String newCodeString = map.get("codeString").toString();
			newCodeArray  = newCodeString.split(",");
			map.put("arrays", newCodeArray);
			pmService.insertHave(map);
		}
		if(map.get("array") != null){
			pmService.allotPolice(map);
		}
		
		return isAdd;
	}
	
	/**
	 * 修改警务资源管理 
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updateResourc(@RequestBody Map<String, Object> map){
		String newCodeString = map.get("codeString").toString();
		String[] newCodeArray  = newCodeString.split(",");
		map.put("arrays", newCodeArray);
		Integer isUpdate = pmService.updateResourc(map);
		if(isUpdate != null){
			if((boolean) map.get("isType")){
				Integer isHave = pmService.deleteHave(map);
				if (isHave != null){
					pmService.insertHave(map);
				}
			}
			Integer isPolices =  pmService.deletePolice(map);
			if (isPolices != null){
				pmService.allotPolice(map);
			}
			//pmService.updatePolicce(map);
		}
		return isUpdate;
	}
	
	
	/**
	 * 删除警务资源管理 
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deleteResourc(@RequestBody Map<String, Object> map){
		Integer isDelete = pmService.deleteResourc(map);
		if (isDelete != null){
			Integer	isPolice =  pmService.deletePolice(map);
			if (isPolice != null){
				pmService.deleteHave(map);
			}
		}
		return isDelete;
	}
	
	
	/**
	 * 警务资源管理人员
	 * @param map
	 * @return
	 */
	@RequestMapping("police")
	public List<SysPoliceInfo> selectPolice(){
		List<SysPoliceInfo> isPolice = pmService.selectPolice();
		return isPolice;
	}
	
	
	/**
	 * 基础数据
	 * @param map
	 * @return
	 */
	@RequestMapping("selectlist")
	public Map<String,Object> selectList() {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		modelMap.put("craTypeList",pmService.selectSysFrmCode("C002"));//车辆类型
		modelMap.put("craPList",  pmService.selectSysFrmCode("C110"));//车辆品牌
		modelMap.put("commitList", pmService.selectSysFrmCode("W002"));//保险公司
		modelMap.put("actionList", pmService.selectSysFrmCode("G999"));//具备功能
		modelMap.put("carGPS",pmService.selectCarGPS());
		return modelMap;
	}
	
	
	/**
	 * 具备功能选中
	 * @param map
	 * @return
	 */
	@RequestMapping("selectHave")
	public List<Jcsj_P_R_Have> selectCheckHave(@RequestBody Map<String, Object> map){
		List<Jcsj_P_R_Have> listHave =  pmService.selectHave(map);
		return listHave;
	}
	/**
	 * 警员默认选中
	 * @param map
	 * @return
	 */
	@RequestMapping("selectCheck")
	public List<Jcsj_P_R_Allot> selectCheckPolice(@RequestBody Map<String, Object> map){
		List<Jcsj_P_R_Allot> listHave =  pmService.selectPoliceCheck(map);
		return listHave;
	}
	
	/**
	 * 管理部门树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfo")
	public String deptinfo() throws JsonProcessingException {
		// 顶级部门
		List<DeptInfo> departinfo = pmService.depart_infolist(null);
		ObjectMapper mapper = new ObjectMapper();
		List<DeptInfo> list = departinfodg(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidian(list));
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getdiwfdidian(List<DeptInfo> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (DeptInfo depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_code());
			map.put("selectable", depart_info.getSelectable());
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

	public List<DeptInfo> departinfodg(List<DeptInfo> departinfo) {
		for (DeptInfo depart_info : departinfo) {
			// 部门
			List<DeptInfo> list = pmService.depart_infolist(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodg(list);
			}
		}
		return departinfo;
	}
	
}
