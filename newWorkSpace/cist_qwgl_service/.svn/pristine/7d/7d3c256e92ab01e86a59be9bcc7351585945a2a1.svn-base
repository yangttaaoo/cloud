package com.cist.qwgl.qwpb.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.qwgl.bcgl.model.Qwgl_bc_info;
import com.cist.qwgl.qwpb.model.DEPT;
import com.cist.qwgl.qwpb.model.QWGL_PBGL_PBINFO;
import com.cist.qwgl.qwpb.model.QWGL_POLICE_CAR;
import com.cist.qwgl.qwpb.model.QWGL_QWPB_QWQY;
import com.cist.qwgl.qwpb.model.QWGL_ZB_INFO;
import com.cist.qwgl.qwpb.model.SYS_POLICE_INFO;
import com.cist.qwgl.qwpb.model.VW_QWGL_PB_INFO;
import com.cist.qwgl.qwpb.model.ZB_Police;
import com.cist.qwgl.xqgl.model.QWGL_XQGL_INFO;

public interface QwpbService {
	/**
	 * 查询排班信息
	 * @param map
	 * @return
	 */
	public List<QWGL_PBGL_PBINFO> querypb(HashMap<String,Object> map);
	/**
	 * 分页查询排班信息
	 * @param map
	 * @param info
	 * @return
	 */
	public Object querypbpageList(HashMap<String,Object> map,PageInfo info);
	/**
	 * 新增排班信息
	 * @param map
	 * @return
	 */
	public Integer addpb(HashMap<String,Object> map);
	/**
	 * 根据班次id查找班次时间
	 * @param bc_pk
	 * @return
	 */
	public List<Qwgl_bc_info> querysj(String bc_pk);
	/**
	 * 查询值班领导类型
	 * @return
	 */
	public List<Integer> queryzbld();
	/**
	 * 根据类型查找所有值班领导
	 * @param list
	 * @return
	 */
	public List<ZB_Police> queryld(List<Integer> list);
	/**
	 * 查询值班科长
	 * @return
	 */
	public List<ZB_Police> queryzbkz();
	/**
	 * 查询值班民警
	 * @return
	 */
	public List<ZB_Police> queryzbmj();
	/**
	 * 查询值班协警
	 * @return
	 */
	public List<ZB_Police> queryzbxj();
	/**
	 * 查询警车信息
	 * @param map
	 * @return
	 */
	public List<QWGL_POLICE_CAR> querypolicecar(HashMap<String,Object> map);
	/**
	 * 根据id查询号牌号码
	 * @param map
	 * @return
	 */
	public List<QWGL_POLICE_CAR> queryhphm(HashMap<String,Object> map);
	/**
	 * 查询负责人
	 * @return
	 */
	public List<ZB_Police> queryfzr();
	/**
	 * 添加车巡信息
	 * @param map
	 * @return
	 */
	public Integer addcx(HashMap<String,Object> map);
	/**
	 * 查询所有呼号
	 * @return
	 */
	public List<SYS_POLICE_INFO> queryhh();
	/**
	 * 查询装备信息
	 * @param map
	 * @return
	 */
	public List<QWGL_ZB_INFO> queryzbinfo(HashMap<String,Object> map);
	
	public List<QWGL_ZB_INFO> queryzb(HashMap<String,Object> map);
	/**
	 * 添加装备报备信息
	 * @param map
	 * @return
	 */
	public Integer addzbbb(HashMap<String,Object> map);
	
	public List<VW_QWGL_PB_INFO> querytj(HashMap<String,Object> map);
	/**
	 * 查询开始时间最小值
	 * @return
	 */
	public Date querymaxsj(HashMap<String,Object> map);
	/**
	 * 查询结束时间最大值
	 * @return
	 */
	public Date queryminsj(HashMap<String,Object> map);
	/**
	 * 查询单位名称
	 * @param map
	 * @return
	 */
	public List<DEPT> querydeptname(HashMap<String,Object> map);
	/**
	 * 查询勤务区域
	 * @param map
	 * @return
	 */
	public List<QWGL_QWPB_QWQY> queryqwqy(HashMap<String,Object> map);
	/**
	 * 查询警员
	 * @param map
	 * @return
	 */
	public String querypolice(HashMap<String,Object> map);
	/**
	 * 查询车巡民警信息
	 * @param map
	 * @return
	 */
	public String querycxmj(HashMap<String,Object> map);
	/**
	 * 查询车巡协警信息
	 * @param map
	 * @return
	 */
	public String querycxxj(HashMap<String,Object> map);
	/**
	 * 查询车巡号牌号码信息
	 * @param map
	 * @return
	 */
	public String querycxhphm(HashMap<String,Object> map);
	/**
	 * 查询勤务区域
	 * @param map
	 * @return
	 */
	public List<QWGL_XQGL_INFO> queryqy(HashMap<String,Object> map);
}
