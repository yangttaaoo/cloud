package com.cist.businessconfig.bayonetmanage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cist.businessconfig.bayonetapply.model.Sys_frm_code;
import com.cist.businessconfig.bayonetapply.service.BayonetApplyService;
import com.cist.businessconfig.bayonetmanage.model.BayonetTree;
import com.cist.businessconfig.bayonetmanage.model.DeptInfo;
import com.cist.businessconfig.bayonetmanage.model.Jcbk_control_bayonet;
import com.cist.businessconfig.bayonetmanage.model.Jcsj_device_bayonet_param;
import com.cist.businessconfig.bayonetmanage.service.BayonetManageService;
import com.cist.frame.page.PageInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/bayonetmanage")
public class BayonetManageController {
	@Autowired
	private BayonetManageService service;
	@Autowired
	private BayonetApplyService bayonetApplyService;

	@RequestMapping("initTree")
	public String initKkTree() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		String json = mapper.writeValueAsString(getdiwfdidian());
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getdiwfdidian() {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "请选择卡口");
		map.put("key", "0");
		map.put("selectable", false);
		map.put("isLeaf", false);
		List<BayonetTree> deptinfo = service.getDeptNode();
		for (int i = 0; i < deptinfo.size(); i++) {
			List<BayonetTree> Bayonetinfo = service.getBayonetNode(deptinfo.get(i).getKey());
			for (int j = 0; j < Bayonetinfo.size(); j++) {
				Jcsj_device_bayonet_param kkinfo = service.querykkinfo(Bayonetinfo.get(j).getKey());
				if (kkinfo != null) {
					HashMap<String, Object> map1 = new HashMap<String, Object>();
					List<BayonetTree> deviceinfo = new ArrayList<BayonetTree>();
					BayonetTree bayonetTree = null;
					if ("1".equals(kkinfo.getBayonet_nature())) {// 上行
						map1.put("deviceid", kkinfo.getDevice_id());
						map1.put("fxlx", 1);
						if (service.isshow(map1) == null) {
							bayonetTree = new BayonetTree();
							bayonetTree.setKey(kkinfo.getDevice_id() + "-1");
							bayonetTree.setTitle("上行(" + kkinfo.getSxfxbm() + ")");
							bayonetTree.setSelectable(true);
							deviceinfo.add(bayonetTree);
						}

					} else if ("2".equals(kkinfo.getBayonet_nature())) {// 下行
						map1.put("deviceid", kkinfo.getDevice_id());
						map1.put("fxlx", 2);
						if (service.isshow(map1) == null) {
							bayonetTree = new BayonetTree();
							bayonetTree.setKey(kkinfo.getDevice_id() + "-2");
							bayonetTree.setTitle("下行(" + kkinfo.getXxfxbm() + ")");
							bayonetTree.setSelectable(true);
							deviceinfo.add(bayonetTree);
						}
					} else if ("3".equals(kkinfo.getBayonet_nature())) {// 双向
						for (int n = 0; n < 2; n++) {
							if (n == 0) {
								map1.put("deviceid", kkinfo.getDevice_id());
								map1.put("fxlx", 1);
								if (service.isshow(map1) == null) {
									bayonetTree = new BayonetTree();
									bayonetTree.setKey(kkinfo.getDevice_id() + "-1");
									bayonetTree.setTitle("上行(" + kkinfo.getSxfxbm() + ")");
									bayonetTree.setSelectable(true);
									deviceinfo.add(bayonetTree);
								}
							} else {
								map1.put("deviceid", kkinfo.getDevice_id());
								map1.put("fxlx", 2);
								if (service.isshow(map1) == null) {
									bayonetTree = new BayonetTree();
									bayonetTree.setKey(kkinfo.getDevice_id() + "-2");
									bayonetTree.setTitle("下行(" + kkinfo.getXxfxbm() + ")");
									bayonetTree.setSelectable(true);
									deviceinfo.add(bayonetTree);
								}
							}
						}
					} else {

					}
					Bayonetinfo.get(j).setChildren(deviceinfo);
				}
			}
			deptinfo.get(i).setChildren(Bayonetinfo);
		}

		map.put("children", deptinfo);
		listmap.add(map);
		return listmap;
	}

	/**
	 * 根据pk_id查询设备信息
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("querydevicebypkid")
	public HashMap<String, Object> querydevicebypkid(@RequestBody HashMap<String, Object> map) {
		HashMap<String, Object> ModelMap = new HashMap<String, Object>();
		ModelMap.put("deviceinfo", service.querydevicebypkid(map));
		return ModelMap;
	}

	/**
	 * 管理部门树
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
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
			List<DeptInfo> list = service.depart_infolist(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodg(list);
			}
		}
		return departinfo;
	}

	/**
	 * 分页查询布控卡口信息
	 * 
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("querykkinfo")
	public PageInfo<Jcbk_control_bayonet> querykkinfopageList(@RequestBody HashMap<String, Object> map,
			HttpServletRequest request) {
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Jcbk_control_bayonet> pageinfo = (PageInfo<Jcbk_control_bayonet>) service.querybayonetinfopageList(map,
				info);
		return pageinfo;
	}

	/**
	 * 添加车辆布控卡口信息
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("add")
	public Integer addcarkkinfo(@RequestBody HashMap<String, Object> map) {
		try {
			HashMap<String, Object> ModelMap = new HashMap<String, Object>();
			ModelMap.put("kkbh", map.get("kkbh"));
			service.addcarbayonet(map);
			List<String> str = (List<String>) map.get("ljdw");
			for (int i = 0; i < str.size(); i++) {
				ModelMap.put("bmdm", str.get(i));
				ModelMap.put("bkkk", map.get("bayonetid"));
				service.addbayonetunits(ModelMap);
			}
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}

	/**
	 * 车辆布控卡口修改页面初始化
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("editpageinit")
	public HashMap<String, Object> bayoneteditinit(@RequestBody HashMap<String, Object> map) {
		HashMap<String, Object> ModelMap = new HashMap<String, Object>();
		ModelMap.put("bayonetunitsinfo", service.querybayonetunitsinfo(map));// 布控卡口拦截单位
		return ModelMap;
	}

	/**
	 * 更新车辆布控卡口信息
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updatebayonet(@RequestBody HashMap<String, Object> map) {
		try {
			HashMap<String, Object> ModelMap = new HashMap<String, Object>();
			service.updatebayonet(map);
			ModelMap.put("kkbh", map.get("kkbh"));
			List<String> list = new ArrayList<String>();
			list.add(map.get("pk").toString());
			map.put("list", list);
			service.delJcbk_bayonet_units(map);
			List<String> str = (List<String>) map.get("ljdw");
			for (int i = 0; i < str.size(); i++) {
				ModelMap.put("bmdm", str.get(i));
				ModelMap.put("bkkk", map.get("pk"));
				service.addbayonetunits(ModelMap);
			}

			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}

	/**
	 * 删除车辆布控卡口信息
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer delbayonet(@RequestBody HashMap<String, Object> map) {
		try {
			service.delJcbk_control_bayonet(map);
			service.delJcbk_bayonet_units(map);
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}

	@RequestMapping("initIndexTab")
	public HashMap<String, Object> initIndexTab(@RequestBody HashMap<String, Object> paramMap) throws JsonProcessingException {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		paramMap.put("fct_code", "C001");
		List<Sys_frm_code> hpzl = bayonetApplyService.querySys_frm_code(paramMap);
		resultMap.put("hpzl", hpzl);// 号牌种类

		paramMap.put("fct_code", "C002");// 车辆类型
		List<Sys_frm_code> cllx = bayonetApplyService.querySys_frm_code(paramMap);
		resultMap.put("cllx", cllx);

		paramMap.put("fct_code", "BKLX");// 布控类型
		List<Sys_frm_code> bklx = bayonetApplyService.querySys_frm_code(paramMap);
		resultMap.put("bklx", bklx);
		resultMap.put("dept",this.deptinfo());
		return resultMap;

	}
}