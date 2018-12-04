package com.cist.xxtj.sbyjfztj.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.xxtj.sbyjfztj.model.TBL_ALARM_CARD_STAT;
import com.cist.xxtj.sbyjfztj.model.TBL_OFFE_VIO_ALARM_STAT;
import com.cist.xxtj.sbyjfztj.model.VideoMonitorTree;
import com.cist.xxtj.sbyjfztj.model.Wfddyjpm;
import com.cist.xxtj.sbyjfztj.model.Wfddzpnum;
import com.cist.xxtj.sbyjfztj.model.Wfzpqs;
import com.cist.xxtj.sbyjfztj.model.Yjwfdd;

public interface SbyjfztjMapper {
	public Integer querysbyjnum(HashMap<String,Object> map);
	public List<TBL_OFFE_VIO_ALARM_STAT> querysbyjtj(HashMap<String,Object> map);
	public Integer querytzb(HashMap<String,Object> map);
	public List<Wfddyjpm> querywfddyjpm(HashMap<String,Object> map);
	public List<Yjwfdd> queryyjwfdd(HashMap<String,Object> map);
	public List<Wfddzpnum> querynumbywfdd(HashMap<String,Object> map);
	public List<Wfddyjpm> queryzppm(HashMap<String,Object> map);
	public List<Wfzpqs> querywfzpqs(HashMap<String,Object> map);
	public TBL_OFFE_VIO_ALARM_STAT queryszcjslbysj(HashMap<String,Object> map);
	public List<Wfzpqs> querywfzpqstable(HashMap<String,Object> map);
	public List<Wfddyjpm> querywfzppm(HashMap<String,Object> map);
	public List<TBL_ALARM_CARD_STAT> querysbinfo(HashMap<String,Object> map);
	/**
	 * 获取Tree需要的部门信息
	 * 
	 * @return
	 */
	public List<VideoMonitorTree> getDeptNode();
	
	/**
	 * 获取Tree需要的道路信息
	 * 
	 * @return
	 */
	public List<VideoMonitorTree> getRoadNode(HashMap<String, String> paramMap);
	
	/**
	 * 获取Tree需要的监控视频信息
	 * 
	 * @return
	 */
	public List<VideoMonitorTree> getVideoMonitorNode(HashMap<String, String> paramMap);
	
//	/**
//	 * 获取Tree需要的监控设备信息
//	 * 
//	 * @param paramMap
//	 * @return
//	 */
//	public List<VideoMonitorTree> getMonitorDevNode(HashMap<String,String> paramMap);
}
