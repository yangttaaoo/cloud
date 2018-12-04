package com.cist.patrolplan.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.patrolplan.model.Dept;
import com.cist.patrolplan.model.Need;
import com.cist.patrolplan.model.Tbl_Dev_Info;
import com.cist.patrolplan.service.PatrolplanService;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CASE;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CONFIG;

@RequestMapping("patrolplan")
@RestController
public class PatrolplanController {
	@Autowired
	private PatrolplanService pService;

	@RequestMapping("allist")
	public PageInfo<Need> indexAll(@RequestBody HashMap<String, Object> map) {
		PageInfo pInfo = new PageInfo();
		pInfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pInfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Need> pageInfo = (PageInfo<Need>) pService.selectAllpageList(map, pInfo);
		List<Need> list = pageInfo.getList();
		List<Need> newList = new ArrayList<>();
		Set<Need> set = new HashSet<>();//提出数据一样的对象，
		for (int i = 0; i < list.size(); i++) {
			set.add(list.get(i));
		}
		for (Need need : set) {
			newList.add(need);
		}
		pageInfo.setList(newList);
		pageInfo.setTotal(newList.size());
		return pageInfo;
	}
	/**
	 * 获取管理部门
	 * @param map
	 * @return
	 */
	@RequestMapping("depts")
	public List<Dept> getDepts(@RequestBody HashMap<String, Object> map) {
		return pService.selectDept(map);
	}

	/**
	 * 删除单条数据，先删除巡逻方案下的摄像机，在删除巡逻方案
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer delete(@RequestBody HashMap<String, Object> map) {
/*		String vcc_name = (String) map.get("vcc_name");
		Integer vccpk = SysTempStoreUtils.getVccPk(vcc_name);
		map.put("vcc_pk", vccpk);
		Integer isDelete = pService.deleteByVccpk(map);
		if (isDelete != 0) {
			isDelete = pService.deleteByVccname(map);
			if (isDelete != 0) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}*/
		return 0;
	}

	/**
	 * 批量删除，先删除巡逻方案下的摄像机，在删除巡逻方案
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("deleteArray")
	public Integer deleteArray(@RequestBody HashMap<String, Object> map) {
	/*	ArrayList<String> vcc_names = (ArrayList<String>) map.get("vccnameArr");
		for (int i = 0; i < vcc_names.size(); i++) {
			String vccname = vcc_names.get(i);
			Integer vccpk = SysTempStoreUtils.getVccPk(vccname);
			map.put("vcc_pk", vccpk);
			Integer isDelete = pService.deleteByVccpk(map);

			if (isDelete != 0) {
				map.put("vcc_name", vccname);
				isDelete = pService.deleteByVccname(map);
				if (isDelete == 0) {
					return 0;
				}
			} else {
				return 0;
			}
		}*/
		return 1;
	}

	/**
	 * 根据树的根节点查找设备备案数据
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("info")
	public Map<String, Object> getVideoMonitorInfo(@RequestBody HashMap<String, Object> paramMap) {
		Tbl_Dev_Info tInfo = pService.getVideoMonitorInfo(paramMap);
		if (tInfo == null) {
			return null;
		}
		paramMap.put("Tbl_Dev_Info", tInfo);
		return paramMap;
	}

	/**
	 * 更新或者添加
	 * 
	 * @param paramMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("insert")
	public Integer insert(@RequestBody HashMap<String, Object> paramMap) {
		ArrayList<String> vcc_times = (ArrayList<String>) paramMap.get("vcc_time");
		String vcc_time = "";
		for (int i = 0; i < vcc_times.size(); i++) {
			vcc_time += vcc_times.get(i) + ",";
		}
		paramMap.put("vcc_time", vcc_time);
		Integer vccpk = (Integer) paramMap.get("vcc_pk");
		Integer isupdate;
		// 若存在视频巡逻方案就调用更新操作，否则为添加
		if (vccpk != null) {
			String vcc_time1 = (String) paramMap.get("vcc_time");
			paramMap.put("vcc_time", vcc_time1.substring(0, 50));
			try {
				isupdate = pService.updateTblVioCruiseCase(paramMap);//更新视频巡逻方案
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		} else {
			try {
				isupdate = pService.addTblVioCruiseCase(paramMap);// 添加视频巡逻方案
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		if (isupdate == 0) {
			return 0;
		}
		ArrayList<Map<String, Object>> tvc_configList = (ArrayList<Map<String, Object>>) paramMap.get("tvc_configList");
		ArrayList<Integer> oldvcfpkList = (ArrayList<Integer>) paramMap.get("oldvcfpkList");
		// 如果是更新操作进来，就会执行if，摄像机的添加与否都会从摄像机列表中把以前有的删掉
		if (oldvcfpkList.size() != 0) {
			for (int i = 0; i < tvc_configList.size(); i++) {
				Map<String, Object> map = tvc_configList.get(i);
				Integer vcfpk = (Integer) map.get("vcf_pk");
				if (oldvcfpkList.contains(vcfpk)) {
					oldvcfpkList.remove(vcfpk);
					tvc_configList.remove(i);
					i = -1;
				}
			}
			if (oldvcfpkList.size() != 0) {
				for (int i = 0; i < oldvcfpkList.size(); i++) {
					paramMap.put("vcf_pk", oldvcfpkList.get(i));
					try {
						isupdate = pService.deleteVccpk(paramMap);//删除不关联的摄像机
					} catch (Exception e) {
						e.printStackTrace();
						return 0;
					}
					if (isupdate == 0) {
						return 0;
					}
				}
			}
		}

		TBL_VIO_CRUISE_CASE tvcc = pService.selectTvcc(paramMap);
		paramMap.put("vcc_pk", tvcc.getVcc_pk());
		for (int i = 0; i < tvc_configList.size(); i++) {
			Map<String, Object> map = tvc_configList.get(i);
			paramMap.put("dvc_pk", map.get("dvc_pk"));
			//禁止添加已经关联巡逻方案的摄像机
			List<TBL_VIO_CRUISE_CONFIG> list = pService.getTblVioCruiseConfig(paramMap);
			if (list.size() != 0) {
				return 2;
			}
			paramMap.put("vcf_num", map.get("vcf_num"));
			paramMap.put("vcf_prest_sign", map.get("vcf_prest_sign"));
			paramMap.put("vcf_rest_sign", map.get("vcf_rest_sign"));
			try {
				isupdate = pService.insertTblVioCruiseConfig(paramMap);// 添加摄像机信息
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
			if (isupdate == 0) {
				return 0;
			}
		}
		return 1;
	}

	/**
	 * 点击修改胡查询出巡逻方案信息和摄像机信息
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("showdata")
	public Map<String, Object> showData(@RequestBody HashMap<String, Object> paramMap) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("tvcc", pService.selectTvcc(paramMap));

		String dvc_names = paramMap.get("dvc_name").toString();
		if (null != dvc_names && dvc_names != "") {
			String dvc[] = dvc_names.split(",");
			List<String> list = Arrays.asList(dvc);
			paramMap.put("dvc_name", list);
		}
		modelMap.put("updatedatas", pService.getUpdatedata(paramMap));

		return modelMap;
	}

}
