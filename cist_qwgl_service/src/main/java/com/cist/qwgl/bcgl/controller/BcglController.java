package com.cist.qwgl.bcgl.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.qwgl.bcgl.model.DeptInfo;
import com.cist.qwgl.bcgl.model.Qw_type;
import com.cist.qwgl.bcgl.model.Qwgl_bc_info;
import com.cist.qwgl.bcgl.service.BcglService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("bcgl")
public class BcglController {
	@Autowired
	private BcglService service;
	/**
	 * 分页查询班次详细信息
	 * @param map
	 * @return
	 */
	@RequestMapping("bcinfo")
	public PageInfo<Qwgl_bc_info> querybc(@RequestBody HashMap<String,Object> map){
		PageInfo info = new PageInfo();
		if(map.get("currentPage")!=null){
			info.setPageNum( Integer.parseInt(map.get("currentPage").toString()) );
		}else{
			info.setPageNum(1);
		}
		if(map.get("pageSize")!=null){
			info.setPageSize(Integer.parseInt(map.get("pageSize").toString()) );
		}else{
			info.setPageSize(9);
		}
		Object obj = service.querybcpageList(map, info);
		PageInfo<Qwgl_bc_info> pageinfo = (PageInfo<Qwgl_bc_info>)obj;
		return pageinfo;
		
	}
	/**
	 * 查询所有的勤务类型
	 * @return
	 */
	@RequestMapping("queryqwlx")
	public List<Qw_type> queryqwlx(){
		return service.queryqwlx(null);
	}
	
	/**
	 * 管理部门树
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
	 * 添加班次信息
	 * @param map
	 * @return
	 */
	@RequestMapping("add")
	public Integer addbcinfo(@RequestBody HashMap<String,Object> map,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());//获取用户
		map.put("create_person", userMap.get("sypi_pk"));//创建人
		map.put("create_time", new Date());//创建时间
		if(service.querymaxpk()==null) {
			map.put("bc_pk", 1);
		}else {
			int i=service.querymaxpk();
			map.put("bc_pk", i+1);
		}
		Integer count = service.addbcinfo(map);
		return count;
	}
	/**
	 * 更新班次信息
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updatebcinfo(@RequestBody HashMap<String,Object> map) {
		return service.updatebcinfo(map);
	}
	/**
	 * 删除班次信息（单条/批量）
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deletebcinfo(@RequestBody HashMap<String,Object> map) {
		// 判断是否为空或者空字符串及删除类型（单条删除或者批量删除）
				String bc_pk = map.get("bc_pk").toString();
				if (null != bc_pk && bc_pk != "" && bc_pk.indexOf(",") != -1) {
					bc_pk = bc_pk.substring(0, bc_pk.length() - 1);
					String sbb[] = bc_pk.split(",");
					map.put("bc_pk", sbb);
				} else {
					String[] sbb = new String[1];
					sbb[0] = bc_pk;
					map.put("bc_pk", sbb);
				}
		return service.deletebcinfo(map);
	}
	/**
	 * 查询所有排班信息
	 * @param map
	 * @return
	 */
	@RequestMapping("queryallpb")
	public List<Qwgl_bc_info> querypbinfo(@RequestBody HashMap<String,Object> map){
		List<Qwgl_bc_info> list = service.querybc(map);
		return list;
	}
}
