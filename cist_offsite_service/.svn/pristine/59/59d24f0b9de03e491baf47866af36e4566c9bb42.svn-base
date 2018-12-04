package com.cist.redrevoke.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.page.PageInfo;
import com.cist.redlist.model.RedListInfo;
import com.cist.redrevoke.service.RedRevokeService;
import com.cist.frame.utils.SysTempStoreUtils;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/redrevoke")
public class RedRevokeController {
	@Autowired
	private RedRevokeService service;
	
	/**
	 * 红名单申请首页，红名单信息查询
	 * @param map
	 */
	@RequestMapping("redRevokeList")
    public PageInfo<RedListInfo> redRevokepageList(@RequestBody HashMap<String,Object> modelMap ){
    	PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
    	PageInfo<RedListInfo> list= (PageInfo<RedListInfo>)service.redRevokepageList(modelMap,pinfo);
		return list;
	}
	/**
	 * 查询一条红名单申请信息
	 * @param map
	 */
	@RequestMapping("OneRedInfo")
	public RedListInfo  OneRedInfo(@RequestBody HashMap<String,Object> modelMap){
		RedListInfo red = service.OneRedInfo(modelMap);
		String hphm = red.getHphm();
		red.setHpqy(hphm.substring(0,2));
		red.setHphm(hphm.substring(2,hphm.length()));
		String plate = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_HPZL,red.getHpzl());
		red.setHpzl_name(plate);
		String cllx = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CLLX,red.getCllx());
		red.setCllx_name(cllx);
		String ssdw = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT,red.getSsdw());
		red.setSsdw_name(ssdw);
		String csys = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CSYS,red.getCsys());
		red.setCsys_name(csys);
		String hpys = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_HPYS,red.getHpys());
		red.setHpys_name(hpys);
		String clpp = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CLPP,red.getClpp());
		red.setClpp_name(clpp);
		return red;
	}
	/**
	 * 红名单撤销
	 * @param map
	 */
	@RequestMapping("revokeRedInfo")
	public int  revokeRedInfo(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request){
		Date day=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		Object name = userMap.get("sypi_name");
		String name1 = null==name?"":name.toString();
		Object code = userMap.get("sypi_code");
		String code1 = code!=null?code.toString():"";
		modelMap.put("cxry", name1+"("+code1+")");
		modelMap.put("cxsj", df.format(day));
		modelMap.put("clzt", "4");
		int status = service.revokeRedInfo(modelMap);
		return status;
	}
}
