package com.cist.pdgrzb.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.page.PageInfo;
import com.cist.frame.utils.SysTempStoreUtils;
import com.cist.pdgrzb.model.DateList;
import com.cist.pdgrzb.model.Depart_info;
import com.cist.pdgrzb.model.DeptInfo;
import com.cist.pdgrzb.model.Qw_I_C_Metricr;
import com.cist.pdgrzb.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("person")
public class PersonController {

	@Autowired
	private PersonService service;
	
	@RequestMapping("index")
	public PageInfo<Qw_I_C_Metricr> selectPersonAll(@RequestBody Map<String, Object> map){
		PageInfo pInfo = new PageInfo();
		pInfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pInfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Qw_I_C_Metricr> pageInfo = (PageInfo<Qw_I_C_Metricr>)service.selectAllpageList(map, pInfo);
		
		
	    return pageInfo;
	}
	
	@RequestMapping("datalist")
	public String DateList() throws JsonProcessingException{
		Calendar calendar = Calendar.getInstance();
		Integer year = calendar.get(Calendar.YEAR);
		String[] jd = {"年度","季度","月度"};
		String[] jdarray = {"第一季度","第二季度","第三季度","第四季度"};
		String[] months =new String[12];
		
		List<DateList> yearlist = new ArrayList<>();
		DateList vTree = null;
		for (int i = 1; i <= 12; i++) {
			months[i-1] = i+"月";
		}
		for (int i = 0; i < 5; i++) {
			vTree = new DateList();
			vTree.setValue(year.toString());
			vTree.setLabel(year.toString());
			yearlist.add(vTree);
			List<DateList> jdList = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				vTree = new DateList();
				vTree.setValue(jd[j]);
				vTree.setLabel(jd[j]);
				jdList.add(vTree);
				yearlist.get(i).setChildren(jdList);
				List<DateList> monthList = new ArrayList<>();
				
				if (j==2) {
					for (int k = 0; k < 12; k++) {
						vTree = new DateList();
						vTree.setValue(months[k]);
						vTree.setLabel(months[k]);
						vTree.setIsLeaf(true);
						monthList.add(vTree);
						jdList.get(j).setChildren(monthList);
					}
				}
				if (j==1) {
					for (int k = 0; k < 4; k++) {
						vTree = new DateList();
						vTree.setValue(jdarray[k]);
						vTree.setLabel(jdarray[k]);
						vTree.setIsLeaf(true);
						monthList.add(vTree);
						jdList.get(j).setChildren(monthList);
					}
				}
				if(j==0){
					vTree.setIsLeaf(true);
					jdList.get(j).setChildren(null);
				}
			}
			
			year++;
		}
		ObjectMapper objmapper = new ObjectMapper();
		return objmapper.writeValueAsString(yearlist);
	}	
	
	@RequestMapping("add")
	public Integer insertPerson(@RequestBody Map<String, Object> map){
		Integer isAdd = service.insertPerson(map);
		if (isAdd != null){
			service.insertZb(map);
		}
		return isAdd;
	}
	
	@RequestMapping("delete")
	public Integer deletePerson(@RequestBody Map<String, Object> map){
		Integer isDelete = service.deletePerson(map);
		return isDelete;
	}
	
	@RequestMapping("update")
	public Integer updatePerson(@RequestBody Map<String, Object> map){
		Integer isUpdate = service.updatePerson(map);
		if (isUpdate!=null){
			service.updateZb(map);
		}
		return isUpdate;
	}
	
	@RequestMapping("deleteAll")
	public Integer deletePersonAll(@RequestParam("pk") String[] pk){
		Integer isDeleteAll = service.deletePersonAll(pk);
		return isDeleteAll;
	}
	
	
	@RequestMapping("isselect")
	public String inputName(@RequestBody String code){
		
			return  SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, code);
		
	}
	
	
	
	/**
	 * 管理部门树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfo")
	public String deptinfo() throws JsonProcessingException {
		// 顶级部门
		List<Depart_info> departinfo = service.depart_infolist(null);
		
		
		
		ObjectMapper mapper = new ObjectMapper();
		List<Depart_info> list = departinfodg(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidian(list));
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getdiwfdidian(List<Depart_info> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName()+""+"("+depart_info.getDept_pk()+")");
			map.put("key", depart_info.getDept_pk());
			map.put("selectable", depart_info.getSelectable());
			map.put("dept", true);
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

	public List<Depart_info> departinfodg(List<Depart_info> departinfo) {
		for (Depart_info depart_info : departinfo) {
			
			List<Depart_info> list = service.depart_infolist(depart_info.getDept_pk());
			List<Depart_info> list1 = service.selectPerson(depart_info.getDept_pk());
			if(list1.size()>0){
				depart_info.setChildren(list1);
			}
			if (list.size() != 0) {
				if(depart_info.getChildren()!=null&&depart_info.getChildren().size()>0){
					depart_info.getChildren().addAll(list);
				}else{
					depart_info.setChildren(list);
				}
				departinfodg(list);
			}
		}
		return departinfo;
	}
	
	
	/**
	 * 管理部门树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfos")
	public String deptinfos() throws JsonProcessingException {
		// 顶级部门
		List<DeptInfo> departinfo = service.depart_infolists(null);
		ObjectMapper mapper = new ObjectMapper();
		List<DeptInfo> list = departinfodgs(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidians(list));
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getdiwfdidians(List<DeptInfo> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (DeptInfo depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_code());
			map.put("selectable", depart_info.getSelectable());
			map.put("isLeaf", depart_info.getIsLeaf());
			if (null != depart_info.getChildren()) {// 下级

				map.put("children", getdiwfdidians(depart_info.getChildren()));
				listmap.add(map);
			} else {
				listmap.add(map);
			}
		}
		return listmap;
	}

	public List<DeptInfo> departinfodgs(List<DeptInfo> departinfo) {
		for (DeptInfo depart_info : departinfo) {
			// 部门
			List<DeptInfo> list = service.depart_infolists(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodgs(list);
			}
		}
		return departinfo;
	}
}
