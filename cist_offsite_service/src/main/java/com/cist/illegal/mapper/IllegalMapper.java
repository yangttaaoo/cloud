package com.cist.illegal.mapper;

import java.util.HashMap;
import java.util.List;
import com.cist.illegal.model.C_plate_keris;
import com.cist.illegal.model.SYS_FRM_CODE;
import com.cist.illegal.model.TBL_OFFE_CATE;
import com.cist.illegal.model.TBL_OFFE_EVDI;
import com.cist.illegal.model.TBL_VERIFY_GROUP;
import com.cist.recheck.model.TblOffeEvdiInfo;

public interface IllegalMapper {
	List<SYS_FRM_CODE> queryfrms(HashMap<String, Object> map);

	List<TBL_OFFE_EVDI> queryevdi(HashMap<String, Object> map);

	List<TBL_OFFE_EVDI> queryupload(HashMap<String, Object> map);

	List<C_plate_keris> queryPlateKeris();

	List<TBL_OFFE_CATE> selectwfxw(HashMap<String, Object> map);

	Integer updateIllegal(HashMap<String, Object> map);

	List<TBL_OFFE_EVDI> selectNextByWfpk(HashMap<String, Object> map);

	List<TBL_OFFE_EVDI> selectUpperByWfpk(HashMap<String, Object> map);

	Integer addveh(HashMap<String, Object> map);

	Integer addlog(HashMap<String, Object> map);

	Integer queryjrgzl(String sypi_pk);

	public Integer sycivalue(HashMap<String, Object> map);

	public Integer auditnumber(HashMap<String, Object> map);

	public List<TBL_VERIFY_GROUP> querywfxwqxbysypi(String sypi_pk);

	public String querydevbysypi(Integer tbvg_pk);

	List<TBL_OFFE_CATE> querywfxw(HashMap<String, Object> map);
	
	String querysbbhbysbpk(HashMap<String, Object> map); 
	
	Integer querycsnum(HashMap<String, Object> map);
	
	public TBL_OFFE_EVDI querydatabywfpk(String wfpk);
	
	TBL_OFFE_EVDI selectCarInfo(HashMap<String, Object> map);
	
    Integer updateCarInfo(HashMap<String, Object> map);
    
  //判断该车辆在同一地点同一时间，在数据库中是否已存在有效违法数据，如存在该条违法数据自动作废；
    TBL_OFFE_EVDI selectValid(HashMap<String,Object> map);
  	
//  	判断界面类表中该条违法数据状态与数据库该条数据状态是否一致，否则提交失败
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
