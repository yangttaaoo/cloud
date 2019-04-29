package com.cist.qwgl.qylxgl.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.qwgl.qylxgl.model.QWGL_QYLX_TYPE;
import com.cist.qwgl.qylxgl.service.QylxglService;

@RestController
@RequestMapping("qylxgl")
@SuppressWarnings("unchecked")
public class QylxglController {
	@Autowired
	private QylxglService service;
	/**
	 * 分页展示区域类型信息
	 * @param map
	 * @return
	 */
	@RequestMapping("queryqylxinfo")
	public PageInfo<QWGL_QYLX_TYPE> queryqylx(@RequestBody HashMap<String,Object> map){
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
		PageInfo<QWGL_QYLX_TYPE> pageinfo = (PageInfo<QWGL_QYLX_TYPE>)service.queryqylxpageList(map, info);
		return pageinfo;
	}
	/**
	 * 添加区域类型信息
	 * @param map
	 * @return
	 */
	@RequestMapping("add")
	public Integer addqylx(@RequestBody HashMap<String,Object> map) {
		if(service.querymaxpk()==null) {
			map.put("pk", 1);
		}else {
			int i=service.querymaxpk();
			map.put("pk", i+1);
		}
		return service.addqylx(map);
	}
	/**
	 * 更新区域类型信息
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updateqylx(@RequestBody HashMap<String,Object> map) {
		return service.updateqylx(map);
	}
	/**
	 * （单条/批量）删除区域类型信息
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deleteqylx(@RequestBody HashMap<String,Object> map) {
		// 判断是否为空或者空字符串及删除类型（单条删除或者批量删除）
		String pk = map.get("pk").toString();
		if (null != pk && pk != "" && pk.indexOf(",") != -1) {
			pk = pk.substring(0, pk.length() - 1);
			String sbb[] = pk.split(",");
			map.put("pk", sbb);
		} else {
			String[] sbb = new String[1];
			sbb[0] = pk;
			map.put("pk", sbb);
		}
		return service.deleteqylx(map);
	}
}
