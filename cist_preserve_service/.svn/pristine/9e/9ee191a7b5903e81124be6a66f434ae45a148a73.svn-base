package com.cist.opsvdt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.opsvdt.model.Jtyw_group;
import com.cist.opsvdt.model.Jtyw_group_member;
import com.cist.opsvdt.service.OpsDvtService;

@RestController
@RequestMapping("opsvdt")
public class OpsDvtController {

	@Autowired
	private OpsDvtService flowService;

	
	/**
	 * 维护组管理详情
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("index")
	public PageInfo<Jtyw_group> selectAll(@RequestBody HashMap<String, Object> map){
		PageInfo info = new PageInfo<>();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Jtyw_group> pageInfo = (PageInfo<Jtyw_group>)flowService.queryAllpageList(map, info);
		return pageInfo;
	}
	
	/**
	 * 公司基本详情
	 * @param map
	 * @return
	 */
	@RequestMapping("corplist")
	public List<Jtyw_group_member> selectCorp( Map<String, Object> map){
		return flowService.queryCorp(map);
	}
	
	/**
	 * 维护组基本详情
	 * @param map
	 * @return
	 */
	@RequestMapping("corpgroup")
	public List<Jtyw_group> selectGroup( Map<String, Object> map){
		return flowService.queryGroup(map);
	}
	
	/**
	 * 修改维护组管理详情
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updateOps(@RequestBody Map<String, Object> map){
		
		Integer isupdate=flowService.updateVdt(map);
		flowService.updateVdts(map);
		return isupdate;
	}
	
	/**
	 * 删除维护组管理详情
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deleteOps(@RequestBody Map<String, Object> map){
		Integer isdelete   ;
		isdelete =flowService.deleteVdt(map);
		flowService.deleteVdts(map);
		return isdelete;
	}
	
	/**
	 * 添加维护组管理详情
	 * @param map
	 * @return
	 */
	@RequestMapping("insert")
	public Integer add(@RequestBody Map<String, Object> map){
		
		Integer isadd = flowService.insertVdt(map);
		flowService.insertVdts(map);
		return isadd;
	}
	
	/**
	 * 批量删除维护组管理详情
	 * @param map
	 * @return
	 */
	@RequestMapping("deletewfxws")
	   public Integer deleteAll(@RequestParam("pk")  String[] pk){
		  Integer in=flowService.deleteAlls(pk);
		return in;
	   }
	
	
	

	/**
	 * 维护成员列表树
	 * 
	 * @return List<HashMap<String, Object>>
	 */
	@RequestMapping("devcompanyTree")
	public List<HashMap<String, Object>> getToOps() throws Exception{
		HashMap<String,Object> map=new HashMap<String, Object>();
		//维护成员列表树信息查询
	List<Jtyw_group_member> selectDevCompany = flowService.queryCorp(map);
		List<HashMap<String, Object>> getmenu = getDevCompany(selectDevCompany);
		return getmenu;
	}
	
	/**
	 * 查询结果转换为树所需数据结构
	 * 
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getDevCompany(List<Jtyw_group_member> selectDevCompany){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Jtyw_group_member sys : selectDevCompany) {
			HashMap<String, Object> map=new HashMap();
			map.put("title", sys.getGroup_contacts());
			map.put("key", sys.getPk_id());
			map.put("disableCheckbox",false);
			map.put("isLeaf", true);
			listmap.add(map);
		}
		return listmap;
	}
}
