package com.cist.traffic.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.traffic.model.Event;
import com.cist.traffic.model.Traffic;

public interface TrafficMapper {
	/**
	 * 查询警员在线率
	 * @return
	 */
	public Traffic  selectOnpolice();
	/**
	 * 查询今日交通事件数量
	 * @return
	 */
	public Traffic  selectTodayTrafficNumber(HashMap<String,Object> map);
	/**
	 * -查询交通事件数量总数
	 * @return
	 */
	public Traffic  selectNowTrafficNumber();
	/**
	 * 查询日均交通数量
	 * @return
	 */
	public Traffic  selectAvgTrafficNumber();

	/**
	 * 查询施工占道总数
	 * @return
	 */
	public Traffic  selectSgzdToal(HashMap<String,Object> map);
	/**
	 * 查询同周比
	 * @return
	 */
	public Traffic  selectMondayTrafficNumber();
	/**
	 * 查询道路事件对象
	 * @return
	 */
	public List<Event> selectOneNumber();
}
