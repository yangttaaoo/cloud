package com.cist.serviceconfig.imgnameconfig.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.SysDepartInfo;
import com.cist.serviceconfig.imgnameconfig.model.Sys_frm_code;
import com.cist.serviceconfig.imgnameconfig.model.TblDevTypeInfo;
import com.cist.serviceconfig.imgnameconfig.model.TblImgNameInfo;
/**
 * @ClassName: ImgNameConfigService
 * @Description: TODO(违法图片文件名配置业务层)
 * @author yt
 * @date 2018年6月7日
 * 
 */
public interface ImgNameConfigService {
	
	/**
	 * 查询违法图片文件名配置模板
	 * 
	 * @return Object
	 */
	Object listpageList(HashMap<String,Object> map,PageInfo p);
	
	/**
	 * 保存模板
	 * 
	 * @return Integer
	 */
	Integer save(HashMap<String,Object> map);
	
	/**
	 * 根据部门code查询部门名称
	 * 
	 * @return SysDepartInfo
	 */
	SysDepartInfo selectDeptName(HashMap<String,Object> map);
	/**
	 * 查询图片文件名配置设备类型下拉
	 * 
	 * @return Sys_frm_code
	 */
	Sys_frm_code selectSblx(HashMap<String,Object> map);
	/**
	 * 查询图片文件名配置设备类型下拉所有
	 * 
	 * @return TblDevTypeInfo
	 */
	List<Sys_frm_code> selectSblxList(HashMap<String,Object> map);
	
	/**
	 * 批量删除
	 * 
	 * @return Integer
	 */
	Integer delete(HashMap<String,Object> map);
	/**
	 * 更新
	 * 
	 * @return Integer
	 */
	Integer update(HashMap<String,Object> map);
	
	/**
	 * 可选项
	 * 
	 * @return Sys_frm_code
	 */
	List<Sys_frm_code> selectKxx(HashMap<String,Object> map);
	
	
}
