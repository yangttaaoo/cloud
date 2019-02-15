package com.cist.devasset.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cist.devasset.model.Jtyw_jksbzc_plan;
import com.cist.devasset.model.Jtyw_sbzc_cs;
import com.cist.devasset.model.Jtyw_sbzc_sbtype;
import com.cist.devasset.model.Vw_jtyw_sbzc_info;
import com.cist.frame.page.PageInfo;

@Service(value="AssetServiceImpl")
public interface AssetService {
	
	/**
	 * 监控设备资产详情及分页
	 * @param map
	 * @param pinfo
	 * @return
	 */
	Object queryAssetpageList(Map<String, Object> map,PageInfo pinfo);
	
	/**
	 * 设备类型名称
	 * @param map
	 * @return
	 */
	List<Jtyw_sbzc_sbtype> queryType(Map<String, Object> map);
	
	/**
	 * 厂商名称
	 * @param map
	 * @return
	 */
	List<Jtyw_sbzc_cs> queryCsname(Map<String, Object> map);
	
	List<Vw_jtyw_sbzc_info> queryList(Map<String, Object> map);
	
	/**
	 * 
	 * 添加监控设备详情
	 * @param map
	 * @return
	 */
	Integer insertAsset(Map<String, Object> map);
	
	/**
	 * 删除监控设备详情
	 * @param map
	 * @return
	 */
	Integer deleteAsset(Map<String, Object> map);
	
	/**
	 * 修改监控设备详情
	 * @param map
	 * @return
	 */
	Integer updateAsset(Map<String, Object> map);
	
	/**
	 * 批量删除监控设备详情
	 * @param pk
	 * @return
	 */
	Integer deleteAll(String[] pk);
}
