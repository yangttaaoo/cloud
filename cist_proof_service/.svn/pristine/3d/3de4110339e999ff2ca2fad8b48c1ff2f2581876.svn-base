package com.cist.tjfx.service;

import java.util.HashMap;
import java.util.List;

import com.cist.tjfx.model.EvidenceTj;
import com.cist.tjfx.model.Myxzltj;

public interface TjfxService {
	/**
	 * 统计各状态的证据总数
	 * @return
	 */
	public Integer queryevidencenum(HashMap<String,Object> map);
	/**
	 * 统计本月证据新增量
	 * @param map
	 * @return
	 */
	public Integer querybyxz(HashMap<String,Object> map);
	/**
	 * 统计每月证据新增量
	 * @param map
	 * @return
	 */
	public List<Myxzltj> querymyxzl(HashMap<String,Object> map);
	/**
	 * 根据单位统计证据数量
	 * @param map
	 * @return
	 */
	public List<EvidenceTj> querynumbydept(HashMap<String,Object> map);
	/**
	 * 根据证据类型进行统计
	 * @param map
	 * @return
	 */
	public List<EvidenceTj> querytjbyzjlx(HashMap<String,Object> map);
	/**
	 * 根据涉案类型进行统计
	 * @param map
	 * @return
	 */
	public List<EvidenceTj> querytjbysalx(HashMap<String,Object> map);
	/**
	 * 按天进行总量统计
	 * @param map
	 * @return
	 */
	public List<Myxzltj> querybzzl(HashMap<String,Object> map);
}
