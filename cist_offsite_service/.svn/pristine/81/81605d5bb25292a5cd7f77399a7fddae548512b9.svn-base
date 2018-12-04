package com.cist.illegal.service;

import java.util.HashMap;
import java.util.List;
import com.cist.frame.page.PageInfo;
import com.cist.illegal.model.C_plate_keris;
import com.cist.illegal.model.SYS_FRM_CODE;
import com.cist.illegal.model.TBL_OFFE_CATE;
import com.cist.illegal.model.TBL_OFFE_EVDI;
import com.cist.illegal.model.TBL_VERIFY_GROUP;
import com.cist.recheck.model.TblOffeEvdiInfo;

public interface IllegalService {
	/**
	 * 根据条件查询基础数据
	 * 
	 * @param map
	 * @return
	 */
	List<SYS_FRM_CODE> queryfrms(HashMap<String, Object> map);

	/**
	 * 查询违法数据(不分页)
	 * 
	 * @param map
	 * @return
	 */
	List<TBL_OFFE_EVDI> queryevdi(HashMap<String, Object> map);

	/**
	 * 查询违法数据(分页)
	 * 
	 * @param map
	 * @return
	 */
	Object queryevdipageList(HashMap<String, Object> map, PageInfo info);

	/**
	 * 查询上传违法数据(分页)
	 * 
	 * @param map
	 * @return
	 */
	Object queryuploadpageList(HashMap<String, Object> map, PageInfo info);

	/**
	 * 查询号牌号码前2位
	 * 
	 * @return
	 */
	List<C_plate_keris> queryPlateKeris();

	/**
	 * 查询违法行为
	 * 
	 * @param map
	 * @return
	 */
	List<TBL_OFFE_CATE> selectwfxw(HashMap<String, Object> map);

	/**
	 * 更新违法数据信息(上传、初审)
	 * 
	 * @param map
	 * @return
	 */
	Integer updateIllegal(HashMap<String, Object> map);

	/**
	 * 初审下一条(根据sql语句控制)
	 * 
	 * @param map
	 * @return
	 */
	List<TBL_OFFE_EVDI> selectNextByWfpk(HashMap<String, Object> map);

	/**
	 * 初审上一条(根据sql语句控制)
	 * 
	 * @param map
	 * @return
	 */
	List<TBL_OFFE_EVDI> selectUpperByWfpk(HashMap<String, Object> map);

	/**
	 * 添加特殊车辆信息
	 * 
	 * @param map
	 * @return
	 */
	Integer addveh(HashMap<String, Object> map);

	/**
	 * 添加审核操作日志
	 * 
	 * @param map
	 * @return
	 */
	Integer addlog(HashMap<String, Object> map);

	/**
	 * 查询今日工作量（有效/无效）
	 * 
	 * @return
	 */
	Integer queryjrgzl(String sypi_pk);

	/**
	 * 查询违法数据有效期
	 * 
	 * @param map
	 * @return
	 */
	public Integer sycivalue(HashMap<String, Object> map);

	/**
	 * 违法数据有效期内多少违法数据
	 * 
	 * @param map
	 * @return
	 */
	public Integer auditnumber(HashMap<String, Object> map);

	/**
	 * 根据警员id查询相应的权限信息
	 * 
	 * @param sypi_pk
	 * @return
	 */
	public List<TBL_VERIFY_GROUP> querywfxwqxbysypi(String sypi_pk);

	/**
	 * 根据权限id查询设备权限
	 * 
	 * @param tbvg_pk
	 * @return
	 */
	public String querydevbysypi(Integer tbvg_pk);

	/**
	 * 根据权限查询违法行为
	 * 
	 * @param map
	 * @return
	 */
	List<TBL_OFFE_CATE> querywfxw(HashMap<String, Object> map);
	
	/**
	 * 根据设备id查询设备编号
	 * @param map
	 * @return
	 */
	String querysbbhbysbpk(HashMap<String, Object> map); 
	
	/**
	 * 查询权限下初审数量
	 * @param map
	 * @return
	 */
	Integer querycsnum(HashMap<String, Object> map);
	/**
	 * 根据违法pk查询一条数据
	 * @param wfpk
	 * @return
	 */
	public TBL_OFFE_EVDI querydatabywfpk(String wfpk);
	
	/**
	 * 根据违法pk查询六合一信息
	 * @param map
	 * @return
	 */
	public TBL_OFFE_EVDI selectCarInfo(HashMap<String, Object> map);
	
	/**
	 * 更新六合一信息
	 * @param map
	 * @return
	 */
	public Integer updateCarInfo(HashMap<String, Object> map);
	
	//判断该车辆在同一地点同一时间，在数据库中是否已存在有效违法数据，如存在该条违法数据自动作废；
	TBL_OFFE_EVDI selectValid(HashMap<String,Object> map);
		
//		判断界面类表中该条违法数据状态与数据库该条数据状态是否一致，否则提交失败
		TBL_OFFE_EVDI selectStatus(HashMap<String,Object> map);
		
		//审核结果的车辆标记插入
		Integer insertBus(HashMap<String,Object> map);
		
		/**
		 * 查询限行违法数据
		 * @param map
		 * @return
		 */
		TblOffeEvdiInfo selectRestriction(HashMap<String, Object> map);
	
}
