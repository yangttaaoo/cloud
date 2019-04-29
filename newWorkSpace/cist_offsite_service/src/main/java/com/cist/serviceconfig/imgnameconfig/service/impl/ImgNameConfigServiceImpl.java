package com.cist.serviceconfig.imgnameconfig.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.dataexport.mapper.DataExportMapper;
import com.cist.dataexport.service.DataExportService;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.mapper.TblOffeEvdiInfoMapper;
import com.cist.offsite.invalidtrial.model.CDirectionInfo;
import com.cist.offsite.invalidtrial.model.SysDepartInfo;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.personalstats.mapper.PersonalStatsMapper;
import com.cist.personalstats.model.PersonalStats;
import com.cist.personalstats.service.PersonalStatsService;
import com.cist.serviceconfig.imgnameconfig.mapper.ImgNameConfigMapper;
import com.cist.serviceconfig.imgnameconfig.model.Sys_frm_code;
import com.cist.serviceconfig.imgnameconfig.model.TblDevTypeInfo;
import com.cist.serviceconfig.imgnameconfig.model.TblImgNameInfo;
import com.cist.serviceconfig.imgnameconfig.service.ImgNameConfigService;

@Service
public class ImgNameConfigServiceImpl implements ImgNameConfigService {

	@Autowired
	private ImgNameConfigMapper mapper;

	/**
	 * 查询违法图片文件名配置模板
	 * 
	 * @return Object
	 */
	public Object listpageList(HashMap<String,Object> map,PageInfo p) {
		return mapper.list(map);
	}
	
	/**
	 * 保存模板
	 * 
	 * @return Integer
	 */
	public Integer save(HashMap<String, Object> map) {
		return mapper.save(map);
	}

	/**
	 * 根据部门code查询部门名称
	 * 
	 * @return SysDepartInfo
	 */
	public SysDepartInfo selectDeptName(HashMap<String, Object> map) {
		return mapper.selectDeptName(map);
	}

	/**
	 * 查询图片文件名配置设备类型下拉
	 * 
	 * @return TblDevTypeInfo
	 */
	public Sys_frm_code selectSblx(HashMap<String, Object> map) {
		return mapper.selectSblx(map);
	}

	/**
	 * 查询图片文件名配置设备类型下拉所有
	 * 
	 * @return TblDevTypeInfo
	 */
	public List<Sys_frm_code> selectSblxList(HashMap<String, Object> map) {
		return mapper.selectSblxList(map);
	}

	/**
	 * 批量删除
	 * 
	 * @return Integer
	 */
	@Override
	public Integer delete(HashMap<String,Object> map) {
		return mapper.delete(map);
	}
	/**
	 * 更新
	 * 
	 * @return Integer
	 */
	@Override
	public Integer update(HashMap<String,Object> map) {
		return mapper.update(map);
	}

	@Override
	public List<Sys_frm_code> selectKxx(HashMap<String, Object> map) {
		return mapper.selectKxx(map);
	}
	
}
