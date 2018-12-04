package com.cist.qwgl.qwgzt.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.cist.leavemanagment.model.DeptInfo;
import com.cist.qwgl.qwgzt.model.CarInfo;
import com.cist.qwgl.qwgzt.model.Need;
import com.cist.qwgl.qwgzt.model.PbglPolice;
import com.cist.qwgl.qwgzt.model.Police;
import com.cist.qwgl.qwgzt.model.PoliceCar;

public interface QwgztMapper {
	/**
	 * 查询需要的数据
	 * @return
	 */
	Set<Need> queryNeed(HashMap<String, Object> map);
	/**
	 * 查询车辆数量
	 * @param cx
	 * @return
	 */
	List<CarInfo> queryCar(String cx);
	
	List<DeptInfo> depart_infolist(Integer dept_superior);
	/**
	 * 查询警员姓名
	 * @return
	 */
	List<Police> selectPolice(HashMap<String, Object> map);
	/**
	 * 查询警车号牌
	 * @param today
	 * @return
	 */
	List<PoliceCar> selectPoliceCarCount(HashMap<String, Object> map);
	/**
	 * 查询在值班的警员
	 * @param today
	 * @return
	 */
	List<PbglPolice> selectPbglPolice(String today);
	/**
	 * 查询所有部门
	 * @return
	 */
	List<String> querydepts();
	
}
