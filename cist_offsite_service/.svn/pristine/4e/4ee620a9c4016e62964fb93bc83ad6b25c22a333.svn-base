package com.cist.serviceconfig.imgnameconfig.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.offsite.invalidtrial.model.SysDepartInfo;
import com.cist.serviceconfig.imgnameconfig.model.Sys_frm_code;
import com.cist.serviceconfig.imgnameconfig.model.TblDevTypeInfo;
import com.cist.serviceconfig.imgnameconfig.model.TblImgNameInfo;

public interface ImgNameConfigMapper {

	/**
	 * 查询采集单位信息
	 * 
	 * @return List<TblImgNameInfo>
	 */
	List<TblImgNameInfo> list(HashMap<String,Object> map);
	
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
	 * @return Sys_frm_code
	 */
	List<Sys_frm_code> selectSblxList(HashMap<String,Object> map);
	
	Integer delete(HashMap<String,Object> map);
	
	Integer update(HashMap<String,Object> map);
	
	/**
	 * 可选项
	 * 
	 * @return Sys_frm_code
	 */
	List<Sys_frm_code> selectKxx(HashMap<String,Object> map);
	
}
