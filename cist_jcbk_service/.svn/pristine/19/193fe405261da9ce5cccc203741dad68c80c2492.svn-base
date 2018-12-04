package com.cist.warningmanagement.bayonet.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.warningmanagement.bayonet.model.DeptInfo;
import com.cist.warningmanagement.bayonet.model.Qy_Bm;
import com.cist.warningmanagement.bayonet.model.Qylx;
import com.cist.warningmanagement.bayonet.model.Bayonet;
import com.cist.warningmanagement.bayonet.service.BayonetService;
import com.cist.warningmanagement.controlcar.model.Kklx;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("bayonet")
public class BayonetController {
	@Autowired
	private BayonetService service;

	/**
	 * 查询所有的数据
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/all")
	public PageInfo<Bayonet> selectAll(@RequestBody HashMap<String, Object> map) {
		try {
			PageInfo page = new PageInfo();
			page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			Object obj = service.selectAllpageList(map, page);
			PageInfo<Bayonet> tbl = (PageInfo<Bayonet>) obj;
			return tbl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 增加数据
	 */
	@RequestMapping("/add")
	public Integer addData(@RequestBody HashMap<String, Object> map) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("kkbh", map.get("kkbh").toString());
		map1.put("ssbm", map.get("ssbm").toString());
		map1.put("enable", map.get("enable").toString());
		map1.put("qc", map.get("qc").toString());
		map1.put("sfyjts", map.get("sfyjts").toString());
		map1.put("bkjl", map.get("bkjl").toString());
		Integer in = service.insertDada(map1);
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("kkbh", map.get("kkbh").toString());
		if (map.get("qy_code") != null && map.get("qy_code").toString().length() > 2) {
			String qy = map.get("qy_code").toString();
			qy = qy.substring(1, qy.length() - 1);
			String sbb[] = qy.split(",");
			for (int i = 0; i < sbb.length; i++) {
				map2.put("qy_code", sbb[i].trim());
				Integer qysf=service.selectQyRepet(map2);
				if(qysf==null){
					Integer in1 = service.insertQy(map2);
				}
				else if(qysf==1){
					Integer in1 = service.insertQy(map2);
					return in1+1;
				}
			}
		}

		HashMap<String, Object> map3 = new HashMap<String, Object>();

		map3.put("kkbh", map.get("kkbh").toString());
		if (map.get("dept_code") != null) {
			String dept = map.get("dept_code").toString();
			String sbb1[] = dept.split(",");
			for (int i = 0; i < sbb1.length; i++) {
				map3.put("dept_code", sbb1[i]);
				Integer depatsf=service.selectDepatRepet(map3);
				if(depatsf==null){
					Integer in2 = service.insertDept(map3);
				}
				else if(depatsf==1){
				Integer in2 = service.insertDept(map3);
				    return in2+2;
				}
			}
		}
		return in;	
	}

	/**
	 * 删除数据
	 */
	@RequestMapping("/delete")
	public Integer deleteData(@RequestParam HashMap<String, Object> map) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("pk", map.get("pk").toString());
		Integer in = service.deleteDada(map1);
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("kkbh", map.get("kkbh").toString());
		Integer in1 = service.deleteDept(map2);
		Integer in2 = service.deleteQy(map2);
		return in;
	}

	/**
	 * 批量删除
	 */
	@RequestMapping("/deleteall")
	public Integer deleteAll(@RequestBody HashMap<String, Object> map) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		if (map.get("pk") != null) {
			String dept = map.get("pk").toString();
			String sbb1[] = dept.split(",");
			for (int i = 0; i < sbb1.length; i++) {
				map1.put("pk", sbb1[i]);
				Integer in = service.deleteDada(map1);
			}
		}
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		if (map.get("kkbh") != null) {
			String kkbh = map.get("kkbh").toString();
			String sbb[] = kkbh.split(",");
			Integer in2 = null;
			Integer in3 = null;
			for (int i = 0; i < sbb.length; i++) {
				map2.put("kkbh", sbb[i]);
				in2 = service.deleteDept(map2);
				in3 = service.deleteQy(map2);
			}
			return in2 + in3;
		}
		return null;
	}

	/**
	 * 更新数据
	 */
	@RequestMapping("/update")
	public Integer updateData(@RequestBody HashMap<String, Object> map) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("kkbh", map.get("kkbh").toString());
		map1.put("ssbm", map.get("ssbm").toString());
		map1.put("enable", map.get("enable").toString());
		map1.put("qc", map.get("qc").toString());
		map1.put("pk", map.get("pk").toString());
		map1.put("sfyjts", map.get("sfyjts").toString());
		map1.put("bkjl", map.get("bkjl").toString());
		Integer in = service.updateDada(map1);
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("kkbh", map.get("kkbh").toString());
		Integer in4 = service.deleteQy(map2);
		if (map.get("qy_code") != null && map.get("qy_code").toString().length() > 2) {
			String qy = map.get("qy_code").toString();
			qy = qy.substring(1, qy.length() - 1);
			String sbb[] = qy.split(",");
			for (int i = 0; i < sbb.length; i++) {
				map2.put("qy_code", sbb[i]);
				Integer in1 = service.insertQy(map2);
			}
		}
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("kkbh", map.get("kkbh").toString());
		Integer in2 = service.deleteDept(map3);
		if (map.get("dept_code") != null) {
			String dept = map.get("dept_code").toString();
			String sbb1[] = dept.split(",");
			for (int i = 0; i < sbb1.length; i++) {
				map3.put("dept_code", sbb1[i]);
				Integer in3 = service.insertDept(map3);
			}
		}
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

	@RequestMapping("/kkxx")
	public Kklx selectKkxx(@RequestBody HashMap<String, Object> map) {
		Kklx kk = service.selectKkxx(map);
		return kk;
	}

	/**
	 * 查询区域类型
	 */
	@RequestMapping("/qylx")
	public List<Qylx> selectQylx() {
		List<Qylx> qy = service.selectQylx();
		return qy;
	}

	/**
	 * 查询区域
	 * 
	 * @return List<HashMap<String, Object>>
	 */
	@RequestMapping("/qytree")
	public List<Qylx> getToOps() throws Exception {
		List<Qylx> selectDevCompany = service.selectQylx();
		return selectDevCompany;
	}

	/**
	 * 查询区域
	 */
	@RequestMapping("/qy")
	public List<Qy_Bm> selectQy(@RequestBody HashMap<String, Object> map) {
		List<Qy_Bm> qy = service.selectQy(map);
		return qy;
	}

	/**
	 * 查询部门
	 */
	@RequestMapping("/depat")
	public List<Qy_Bm> selectDept(@RequestBody HashMap<String, Object> map) {
		List<Qy_Bm> qy = service.selectDept(map);
		return qy;
	}
}
