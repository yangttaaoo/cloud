package com.cist.redinfo.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cist.frame.page.PageInfo;
import com.cist.redinfo.model.Car;
import com.cist.redinfo.model.Color;
import com.cist.redinfo.model.Depart_info;
import com.cist.redinfo.model.RedInfo;
import com.cist.redinfo.model.Sys_frm_code;
public interface RedInfoService {
	/**
	 * 查询违法数据表
	 * @param map
	 * @return Object 
	 */
	Object  selectRedInfopageList(Map map,PageInfo page);
	/**
	 * 根据主键查询红名单详情
	 * @param pk
	 * @return RedInfo
	 */
	RedInfo  selectByfk(Integer pk);
	/**
	 * 红名单车
	 */
	Car  selectCar(HashMap<String,Object> map);
	//车辆类型
	public List<Sys_frm_code> selectCllx();
	/**
	 * 查询车身颜色
	 */
	Sys_frm_code selectInfo(HashMap<String,Object> map);
	List<Color> selectColors();
	/**
	 * 查询车身颜色
	 */
	Depart_info selectDepart(HashMap<String,Object> map);
	List<Depart_info> selectDeparts();
}
