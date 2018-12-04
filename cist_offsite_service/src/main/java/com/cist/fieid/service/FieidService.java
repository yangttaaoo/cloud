package com.cist.fieid.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.fieid.model.C_direction;
import com.cist.offsite.invalidtrial.model.CPlateColorInfo;
import com.cist.offsite.invalidtrial.model.CPlateKerisInfo;
import com.cist.offsite.invalidtrial.model.CPlateTypeInfo;
import com.cist.fieid.model.TblOffeEvdiInfo;

@Service(value="FieidServiceImpl")
public interface FieidService {

	/**
	 * 查询所有数据详情
	 * @param map
	 * @param info
	 * @return
	 */
	Object selectAllpageList(HashMap<String, Object> map,PageInfo info);
	/**
	 * 获取上一条数据
	 * @param map
	 * @return
	 */
	List<TblOffeEvdiInfo> getPreData(HashMap<String, Object> map);
	/**
	 * 获取下一条数据
	 * @param map
	 * @return
	 */
	List<TblOffeEvdiInfo> getNextData(HashMap<String, Object> map);
	/**
	 * 查询除‘川’以外的号牌详情
	 * @return
	 */
/*	List<TblOffeEvdiInfo> selectHphm();*/
	
	/**
	 * 查询行驶方向
	 * @param direction
	 * @return
	 */
	List<C_direction> runDirection(C_direction direction);
	
	/**
	 * 更新无效数据信息状态
	 * @param info
	 * @return
	 */
	Integer updateState(HashMap<String,Object> map);
	/**
	 * 根据wfpk查询数据
	 * @param wfpk
	 * @return
	 */
	TblOffeEvdiInfo getBywfpk(Long wfpk);
	/**
	 * 查询号牌前两位
	 * @return
	 */
	List<CPlateKerisInfo> selectByCPlateKerisInfo();
	  /**
	 	 * 查询号牌类别信息
	 	 * @return  List<CPlateTypeInfo>
	 	 */
	List<CPlateTypeInfo> selectByCPlateTypeInfo();
	/**
	 * 查询号牌颜色信息
	 * @return  List<CPlateColorInfo>
	 */
	List<CPlateColorInfo> selectByCPlateColorInfo();
	/**
	 * 初始化视频监控的Tree
	 * 
	 * @return
	 * @throws Exception
	 */
	public String devTree(HashMap<String, String> map) throws Exception;
	/**
	 * 查询部门编号
	 * @param map
	 * @return
	 */
	Long getDeptCode(HashMap<String, String> map);
	/**
	 * 保存操作日志
	 * @param map
	 * @return
	 */
	Integer saveLog(HashMap<String, Object> map);
	/**
	 * 保存黄标车或者货车
	 * @param map
	 * @return
	 */
	Integer saveVehBus(HashMap<String, Object> map);
	
	//审核结果的车辆标记插入
	Integer insertBus(HashMap<String,Object> map);
	
	//查询数据当前状态是否未审核
	TblOffeEvdiInfo selectStatus(HashMap<String,Object> map);

	//查询审核结果为有效时是否存在此有效数据
	TblOffeEvdiInfo selectValid(HashMap<String,Object> map);
	 
	/**
	 * 查询限行违法数据
	 * @param map
	 * @return
	 */
	TblOffeEvdiInfo selectRestriction(HashMap<String, Object> map);
	
	//审核数
	public Integer auditnumber(HashMap<String,Object> map);
	//基础代码表
	public Integer sycivalue(HashMap<String,Object> map);
	//今日审核总计
	public Integer getjintiri(HashMap<String,Object> map);
}
