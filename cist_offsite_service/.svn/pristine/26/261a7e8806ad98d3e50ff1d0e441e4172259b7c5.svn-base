package com.cist.recheck.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.cist.illegal.model.TBL_OFFE_CATE;
import com.cist.illegal.model.TBL_VERIFY_GROUP;
import com.cist.offsite.invalidtrial.model.Sys_frm_code;
import com.cist.offsite.invalidtrial.utils.DynaSqlProvider;
import com.cist.picture.model.C_plate_type;
import com.cist.picture.model.Tbl_offe_cate;
import com.cist.recheck.model.TblOffeCateInfo;
import com.cist.recheck.model.TblOffeEvdiInfo;
import com.cist.recheck.model.VwDevInfo;
import com.cist.recheck.model.Vw_dev_info;

public interface RecheckMapper {
	/**
	 * 查询所有无效数据
	 * @return List<TblOffeEvdiInfo>
	 */
	List<TblOffeEvdiInfo> selectAllInvalidTrial();
	
	
	/**
	 * 查询所有号牌种类
	 * @return
	 */
	List<Sys_frm_code> plateTypeList(String fct_code);
	
	/**
	 * 查询单条信息审核
	 * @param map 查询条件
	 * @return List<TblOffeEvdiInfo>
	 */
	TblOffeEvdiInfo selectByWfpk(TblOffeEvdiInfo tblOffeEvdiInfo);
	/**
	 * 多条件查询无效数据信息
	 * @param map 查询条件
	 * @return List<TblOffeEvdiInfo>
	 */
	List<TblOffeEvdiInfo> selectByCondition(HashMap<String,Object> map);


	/**
	 * 查询号牌类别信息
	 * @return  List<CPlateTypeInfo>
	 */
	List<Sys_frm_code> selectSysFrmCode(String fct_code);


	/**
	 * excle导出数据查询 ZIP导出数据查询只查前100条
	 * @param map 查询条件
	 * @return List<TblOffeEvdiInfo>
	 */

	List<TblOffeEvdiInfo> exportZipList(HashMap<String,Object> map);

	/**
	 * 审核无效数据
	 * @param map 查询条件
	 * @return Integer
	 */
	Integer updateByWfpk(HashMap<String,Object> map);
	/**
	 * 查询下一条审核信息审核
	 * @param tblOffeEvdiInfo 查询条件
	 * @return TblOffeEvdiInfo
	 */
	TblOffeEvdiInfo selectNextByWfpk(TblOffeEvdiInfo tblOffeEvdiInfo);
	/**
	 * 查询采集设备信息
	 * @return  List<VwDevInfo>
	 */
	List<VwDevInfo> selectByVwDevInfo();

	/**
	 * 查询违法内容
	 * @param modelMap
	 * @return
	 */
	TblOffeCateInfo  tblByShort(HashMap<String, Object> map);

	/**
	 * 查询违法地点
	 * @return
	 */
	List<TblOffeEvdiInfo> queryWfdd();

	/**
	 * 设备树
	 * @param map
	 * @return
	 */
	List<Vw_dev_info> treeSb(HashMap<String,Object> map);



	/**
	 * 设备树
	 * @param map
	 * @return
	 */
	List<Vw_dev_info> treeSbList(String tbei_code);

	/**
	 * 查询下一条
	 * @param map
	 * @return
	 */
	List<TblOffeEvdiInfo> selectNextByWfpk(HashMap<String, Object> map);

	/**
	 * 查询上一条
	 * @param map
	 * @return
	 */
	List<TblOffeEvdiInfo> selectUpperByWfpk(HashMap<String, Object> map);

	/**
	 * 操作日志
	 * @param map
	 * @return
	 */
	Integer saveLog(HashMap<String,Object> map);

	/**
	 * 车辆标记
	 * @param map
	 * @return
	 */
	Integer addInsert(HashMap<String,Object> map);


	Integer queryjrgzl(String sypi_pk);
	Integer sycivalue(HashMap<String,Object> map);
	Integer auditnumber(HashMap<String,Object> map);


	public List<TBL_VERIFY_GROUP> querywfxwqxbysypi(String sypi_pk);
	public String querydevbysypi(Integer tbvg_pk);



	/**
	 * 根据权限查询违法行为
	 * @param map
	 * @return
	 */
	List<TBL_OFFE_CATE> querywfxw(HashMap<String,Object> map);

	//判断该车辆在同一地点同一时间，在数据库中是否已存在有效违法数据，如存在该条违法数据自动作废；
		TblOffeEvdiInfo selectValid(HashMap<String,Object> map);
		
//		判断界面类表中该条违法数据状态与数据库该条数据状态是否一致，否则提交失败
		TblOffeEvdiInfo selectStatus(HashMap<String,Object> map);
		
		//审核结果的车辆标记插入
		Integer insertBus(HashMap<String,Object> map);
		
		/**
		 * 更新六合一信息
		 * @param map
		 * @return
		 */
		public Integer updateCarInfo(HashMap<String, Object> map);
		
		//获取车管信息后更新最新违法数据 
		TblOffeEvdiInfo selectInfo(HashMap<String, Object> map);
		
		/**
		 * 查询限行违法数据
		 * @param map
		 * @return
		 */
		TblOffeEvdiInfo selectRestriction(HashMap<String, Object> map);
		
		/**
		 * 根据设备id查询设备编号
		 * @param map
		 * @return
		 */
		String querysbbhbysbpk(HashMap<String, Object> map); 
}
