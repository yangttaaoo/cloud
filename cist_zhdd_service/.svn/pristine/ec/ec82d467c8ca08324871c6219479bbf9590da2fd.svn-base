package com.cist.smsmodule.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.smsmodule.modle.DeptInfo;
import com.cist.smsmodule.modle.Smsmodle;
import com.cist.smsmodule.modle.Sys_frm_code;
import com.cist.smsmodule.service.SmsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("short")
public class SmsController {
	@Autowired
	private SmsService service;

	/**
	 * 查询所有审核数据
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/index")
	public PageInfo<Smsmodle> selectData(@RequestBody HashMap<String, Object> map) {
		PageInfo page = new PageInfo();
		page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Smsmodle> info = (PageInfo<Smsmodle>) service.selectDatapageList(map, page);
		return info;
	}

	/**
	 * 增加数据
	 */
	@RequestMapping("/add")
	public Integer update(@RequestBody HashMap<String, Object> map) {
		Integer in = service.addData(map);
		return in;
	}

	/**
	 * 删除数据
	 */
	@RequestMapping("/delete")
	public Integer updateNoPass(@RequestBody HashMap<String, Object> map) {
		Integer in = service.deleteDate(map);
		return in;
	}

	/**
	 * 修改数据
	 */
	@RequestMapping("/update")
	public Integer updateCall(@RequestBody HashMap<String, Object> map) {
		Integer in = service.updateData(map);
		return in;
	}
	// 部门
	@RequestMapping("deptinfo")
	public String deptinfo() throws JsonProcessingException {
			// 顶级部门
			List<DeptInfo> departinfo = service.depart_infolist(null);
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
				map.put("key", depart_info.getDept_pk());
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
				List<DeptInfo> list = service.depart_infolist(depart_info.getDept_pk());
				if (list.size() != 0) {
					depart_info.setChildren(list);
					departinfodg(list);
				}
			}
			return departinfo;
		}

		/**
		 * 查询可选项
		 * @param map
		 * @return
		 */
		@RequestMapping(value ="selectKxx")
		public List<HashMap<String, Object>> selectKxz(@RequestBody HashMap<String,Object> map) {
			List<Sys_frm_code> selectKxx = service.selectKxx(map);
			List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
			for (Sys_frm_code sys_frm_code : selectKxx) {
				HashMap<String, Object> modelMap=new HashMap();
				modelMap.put("key", sys_frm_code.getFc_code());
				switch (sys_frm_code.getFc_code()) {
				case "WFDD":
					modelMap.put("exm", "{wfdd}");
					break;
				case "SGXQ":
					modelMap.put("exm", "{sgxq}");
					break;
				case "BJR":
					modelMap.put("exm", "{bjr}");
					break;
				case "BJSJ":
					modelMap.put("exm", "{bjsj}");
					break;
//				case "LXFS":
//					modelMap.put("exm", "{lxfs}");
//					break;
				default:
					modelMap.put("exm", "{lxfs}");
					break;
				}
				modelMap.put("title", sys_frm_code.getFc_name());
				listmap.add(modelMap);
			}
			return listmap;
		}
		/**
		 * 查询单位名称和创建人名称
		 * @param map
		 * @return
		 */
		@RequestMapping("info")
		public HashMap<String, Object> info(@RequestBody HashMap<String,Object> map){
			HashMap<String,Object> ModelMap = new HashMap<String,Object>();
			ModelMap.put("deptname", service.queryDeptnameBydeptpk(map));
			ModelMap.put("pepolename", service.querypepolenamebycode(map));
			return ModelMap;
		}
		/**
		 * 批量删除
		 * @param map
		 * @return
		 */
		@RequestMapping("batchdel")
		public Integer batchdel(@RequestBody HashMap<String,Object> map){
			try {
				// 判断是否为空或者空字符串及删除类型（单条删除或者批量删除）
				String pk_id = map.get("pk_id").toString();
				if (null != pk_id && pk_id != "" && pk_id.indexOf(",") != -1) {
					pk_id = pk_id.substring(0, pk_id.length() - 1);
					String sbb[] = pk_id.split(",");
					map.put("pk_id", sbb);
				} else {
					String[] sbb = new String[1];
					sbb[0] = pk_id;
					map.put("pk_id", sbb);
				}
				service.batchdel(map);
				return 1;
			} catch (Exception e) {
				return 2;
			}
		}
}
