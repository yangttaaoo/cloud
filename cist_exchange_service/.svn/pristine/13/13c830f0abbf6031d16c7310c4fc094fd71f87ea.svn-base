package com.cist.visitinterface.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.visitinterface.model.DeptInfo;
import com.cist.visitinterface.model.SJGX_INTERFACE_TYPE;
import com.cist.visitinterface.model.SYS_depart_info;
import com.cist.visitinterface.model.SjgxDevCompany;
import com.cist.visitinterface.model.SjgxInterface;
import com.cist.visitinterface.service.VisitInterfaceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 访问接口维护
 * @author hy
 *
 */
@RestController
@RequestMapping("visitinterface")
@SuppressWarnings("unchecked")
public class VisitInterfaceController {
	@Autowired
	private VisitInterfaceService service;
	/**
	 * 根据条件查询相关信息
	 * @param map
	 * @return
	 */
	@RequestMapping("querylist")
	public PageInfo<SjgxInterface> queryInterface(@RequestBody HashMap<String,Object> map){
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
		 Object obj = service.queryinterfacepageList(map,info);
		 PageInfo<SjgxInterface> list = (PageInfo<SjgxInterface>)obj;
		 HashMap<String,Object> map1=new HashMap<String,Object>();
		 for (int i = 0; i < list.getList().size(); i++) {
			if("1".equals(list.getList().get(i).getInterface_enable_status())) {
				list.getList().get(i).setStatus_name("启用");
			}else {
				list.getList().get(i).setStatus_name("停用");
			}
			if(list.getList().get(i).getFk_interface_type_id()!=null) {
				map1.put("pk_id", list.getList().get(i).getFk_interface_type_id());
				list.getList().get(i).setInterface_type_name(service.queryinterfacetype(map1).get(0).getInterface_type_name());
				//list.getList().get(i).setInterface_describe(service.queryinterfacetype(map1).get(0).getInterface_type_describe());
			}
		}
		return list;
	}
	/**
	 * 查询接口类型信息
	 * @param map
	 * @return
	 */
	@RequestMapping("queryinterfacetype")
	public List<SJGX_INTERFACE_TYPE> queryinterfacetype(@RequestBody HashMap<String,Object> map){
		List<SJGX_INTERFACE_TYPE> list = service.queryinterfacetype(map);
		return list;
	}
	/**
	 * 查询开发单位信息
	 * @param map
	 * @return
	 */
	@RequestMapping("querydev")
	public List<SjgxDevCompany> querydev(@RequestBody HashMap<String,Object> map){
		 List<SjgxDevCompany> list = service.querydev(map);
		return list;
	}
	/**
	 * 添加访问接口维护
	 * @param map
	 * @return
	 */
	@RequestMapping("add")
	public Integer addVisitInterface(@RequestBody HashMap<String,Object> map) {
		if(service.queryid()==null) {
			map.put("pk_id", 1);
		}else {
			int i=service.queryid();
			map.put("pk_id", i+1);
		}
		map.put("create_time", new Date());
		Integer count = service.addsjgx(map);
		return count;
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
	 * 删除接口（单条、批量）
	 * @param map
	 * @return
	 */
	@RequestMapping("delinterface")
	public Integer delinterface(@RequestBody HashMap<String,Object> map) {
		//判断是否为空或者空字符串及删除类型（单条删除或者批量删除）
		String pk_id=map.get("pk_id").toString();
		if(null!=pk_id&&pk_id!=""&&pk_id.indexOf(",")!=-1) {
			pk_id=pk_id.substring(0, pk_id.length()-1);
			String sbb[]=pk_id.split(",");
			map.put("pk_id", sbb);
		}else {
			String[] sbb=new String[1];
			sbb[0]=pk_id;
			map.put("pk_id", sbb);
		}
		Integer count = service.delinterface(map);
		return count;
	}
	/**
	 * 更新访问接口信息
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updateInteface(@RequestBody HashMap<String,Object> map) {
		Integer count = service.updateinterface(map);
		return count;
		
	}
}
