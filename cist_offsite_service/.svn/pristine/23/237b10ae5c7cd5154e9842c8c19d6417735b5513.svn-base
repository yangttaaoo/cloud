package com.cist.xxtj.sbyjfztj.service;

import java.util.HashMap;
import java.util.List;

import com.cist.xxtj.sbyjfztj.model.TBL_ALARM_CARD_STAT;
import com.cist.xxtj.sbyjfztj.model.TBL_OFFE_VIO_ALARM_STAT;
import com.cist.xxtj.sbyjfztj.model.Wfddyjpm;
import com.cist.xxtj.sbyjfztj.model.Wfddzpnum;
import com.cist.xxtj.sbyjfztj.model.Wfzpqs;
import com.cist.xxtj.sbyjfztj.model.Yjwfdd;

public interface SbyjfztjService {
	/**
	 * 根据条件查询设备预警数量
	 * @param map
	 * @return
	 */
	public Integer querysbyjnum(HashMap<String,Object> map);
	/**
	 * 根据条件查询设备预警统计表信息
	 * @param map
	 * @return
	 */
	public List<TBL_OFFE_VIO_ALARM_STAT> querysbyjtj(HashMap<String,Object> map);
	/**
	 * 根本单条数据查询周同比
	 * @param map
	 * @return
	 */
	public Integer querytzb(HashMap<String,Object> map);
	/**
	 * 查询违法地点预警排名
	 * @param map
	 * @return
	 */
	public List<Wfddyjpm> querywfddyjpm(HashMap<String,Object> map);
	/**
	 * 查询预警违法地点
	 * @param map
	 * @return
	 */
	public List<Yjwfdd> queryyjwfdd(HashMap<String,Object> map);
	/**
	 * 根据违法地点查询抓拍数量
	 * @param map
	 * @return
	 */
	public List<Wfddzpnum> querynumbywfdd(HashMap<String,Object> map);
	/**
	 * 查询违法数据抓拍排名
	 * @param map
	 * @return
	 */
	public List<Wfddyjpm> queryzppm(HashMap<String,Object> map);
	/**
	 * 违法抓拍数量趋势
	 * @param map
	 * @return
	 */
	public List<Wfzpqs> querywfzpqs(HashMap<String,Object> map);
	/**
	 * 根据地点和时间查询上一周相同时间的数据
	 * @param map
	 * @return
	 */
	public TBL_OFFE_VIO_ALARM_STAT queryszcjslbysj(HashMap<String,Object> map);
	/**
	 *  违法地点预警列表
	 * @param map
	 * @return
	 */
	public List<Wfzpqs> querywfzpqstable(HashMap<String,Object> map);
	/**
	 * 违法抓拍量排名
	 * @param map
	 * @return
	 */
	public List<Wfddyjpm> querywfzppm(HashMap<String,Object> map);
	/**
	 * 查询设备相关信息
	 * @param map
	 * @return
	 */
	public List<TBL_ALARM_CARD_STAT> querysbinfo(HashMap<String,Object> map);
	
	/**
	 * 道路树的Tree
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initTree() throws Exception;
}
