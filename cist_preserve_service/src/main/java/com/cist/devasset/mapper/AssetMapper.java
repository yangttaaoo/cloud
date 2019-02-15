package com.cist.devasset.mapper;

import java.util.List;
import java.util.Map;

import com.cist.devasset.model.Jtyw_jksbzc_plan;
import com.cist.devasset.model.Jtyw_sbzc_cs;
import com.cist.devasset.model.Jtyw_sbzc_sbtype;
import com.cist.devasset.model.Vw_jtyw_sbzc_info;

public interface AssetMapper {
	/**
	 * 监控设备资产详情
	 * @param map
	 * @return
	 */
	List<Vw_jtyw_sbzc_info> queryAsset(Map<String, Object> map);
	
	List<Vw_jtyw_sbzc_info> queryList(Map<String, Object> map);
	
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
