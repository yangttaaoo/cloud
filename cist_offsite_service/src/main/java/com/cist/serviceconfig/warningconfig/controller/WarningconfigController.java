package com.cist.serviceconfig.warningconfig.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.serviceconfig.warningconfig.model.TBL_OFFE_VIO_ALARM;
import com.cist.serviceconfig.warningconfig.service.WarningconfigService;
import com.fasterxml.jackson.core.JsonProcessingException;
@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/warningconfig")
public class WarningconfigController {
	@Autowired
	private WarningconfigService service;

	
	
	/**
	 * 部门-安装点位-设备，树结构
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("initTree")	
	public String initTree(@RequestBody HashMap<String, Object> paramMap) {

		try {
			return service.initTree();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
//	@RequestMapping("deptinfo")
//	public String deptinfo()throws JsonProcessingException{
//    //顶级部门
//	List<DeptInfo>	departinfo=service.depart_infolist(null);
//	ObjectMapper mapper = new ObjectMapper();
//	List<DeptInfo> list=departinfodg(departinfo);
//	String json=mapper.writeValueAsString(getdiwfdidian(list));
//	return json.substring(1, json.length()-1);
//	}
//	public List<HashMap<String, Object>> getdiwfdidian(List<DeptInfo> list){
//		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
//		for (DeptInfo depart_info : list) {
//			HashMap<String, Object> map=new HashMap<String, Object>();
//			map.put("title", depart_info.getName());
//			map.put("key", depart_info.getDept_code());
//			map.put("selectable", depart_info.getSelectable());
//			map.put("isLeaf", depart_info.getIsLeaf());
//			if(null!=depart_info.getChildren()) {//下级
//				map.put("children", getdiwfdidian(depart_info.getChildren()));
//				listmap.add(map);
//			}else {
//				listmap.add(map);
//			}
//		}
//		return listmap;
//	}
//	public List<DeptInfo> departinfodg(List<DeptInfo> departinfo){
//	for (DeptInfo depart_info : departinfo) {
//		//安装地点
//		List<DeptInfo> tbmp = service.Monitorpoint(depart_info.getDept_code());
//		for(int i=0; i<tbmp.size();i++){
//			 List<DeptInfo> deptlist = service.Device(tbmp.get(i).getDept_code());
//			 for (int j = 0; j < deptlist.size(); j++) {
//				 deptlist.get(j).setIsDept(true);
//			}
//			//设备
//			tbmp.get(i).setChildren(deptlist);
//		}
//		depart_info.setChildren(tbmp);
//		//部门
//	List<DeptInfo> list= service.depart_infolist(depart_info.getDept_pk());
//		if(list.size()!=0){
//			depart_info.setChildren(list);
//			departinfodg(list);
//		}
//	  }
//     return departinfo;
//	}
	/**
	 * 查询预警阈值信息
	 * @param map
	 * @return
	 */
	@RequestMapping("queryyjyz")
	public PageInfo<TBL_OFFE_VIO_ALARM> queryyjyz(@RequestBody HashMap<String,Object> map){
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<TBL_OFFE_VIO_ALARM> list = (PageInfo<TBL_OFFE_VIO_ALARM>)service.queryyjyzpageList(map,info);
		return list;
	}
	/**
	 * 添加预警阈值信息
	 * @param map
	 * @return
	 */
	@RequestMapping("add")
	public Integer addyjyz(@RequestBody HashMap<String,Object> map) {
		Integer count = service.addyjyz(map);
		return count;
	}
	/**
	 * 更新预警阈值信息
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updateyjyz(@RequestBody HashMap<String,Object> map) {
		Integer count = service.updateyjyz(map);
		return count;
	}
	/**
	 * 删除预警阈值信息
	 * @param map
	 * @return
	 */
	@RequestMapping("del")
	public Integer deleteyjyz(@RequestBody HashMap<String,Object> map) {
		Integer count = service.delyjyz(map);
		return count;
	}
	/**
	 * 查询预警信息
	 * @param map
	 * @return
	 */
	@RequestMapping("queryyj")
	public List<TBL_OFFE_VIO_ALARM> queryyj(@RequestBody HashMap<String,Object> map){
		return service.queryyjyz(map);
	}
}
