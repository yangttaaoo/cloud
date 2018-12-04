package com.cist.xxtj.wfsjlztj.service;

import java.util.HashMap;
import java.util.List;

import com.cist.xxtj.wfsjlztj.model.Sjlztj;
import com.cist.xxtj.wfsjlztj.model.TBL_FLOW_CARD_STAT;
import com.cist.xxtj.wfsjlztj.model.TBL_OFFE_VIO_FLOW_STAT;
import com.cist.xxtj.wfsjlztj.model.Wfzppm;

public interface WfsjlztjService {
	/**
	 * 查询四卡片数据
	 * @param map
	 * @return
	 */
	public List<TBL_FLOW_CARD_STAT> querycard(HashMap<String,Object> map);
	/**
	 * 查询今日数据流转统计
	 * @param map
	 * @return
	 */
	public List<Sjlztj> queryjrsjlztj(HashMap<String,Object> map);
	/**
	 * 查询本周数据流转统计
	 * @param map
	 * @return
	 */
	public List<Sjlztj> querybzsjlztj(HashMap<String,Object> map);
	/**
	 * 查询本月数据流转统计
	 * @param map
	 * @return
	 */
	public List<Sjlztj> querybysjlztj(HashMap<String,Object> map);
	/**
	 * 查询全年数据流转统计
	 * @param map
	 * @return
	 */
	public List<Sjlztj> queryqnsjlztj(HashMap<String,Object> map);
	/**
	 * 查询数据流转统计列表数据
	 * @param map
	 * @return
	 */
	public List<TBL_OFFE_VIO_FLOW_STAT> querysjlztjlist(HashMap<String,Object> map);
	/**
	 * 查询违法抓拍排名
	 * @param map
	 * @return
	 */
	public List<Wfzppm> querywfzppm(HashMap<String,Object> map);
	/**
	 * 查询今日违法流转详情
	 * @return
	 */
	public List<TBL_OFFE_VIO_FLOW_STAT> queryjrwflzinfo();
}
