package com.cist.offsite.invalidtrial.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.CDirectionInfo;
import com.cist.offsite.invalidtrial.model.CPlateColorInfo;
import com.cist.offsite.invalidtrial.model.CPlateKerisInfo;
import com.cist.offsite.invalidtrial.model.CPlateTypeInfo;
import com.cist.offsite.invalidtrial.model.CReason;
import com.cist.offsite.invalidtrial.model.CRoadItem;
import com.cist.offsite.invalidtrial.model.C_Monitor_Point_Ex;
import com.cist.offsite.invalidtrial.model.Depart_info;
import com.cist.offsite.invalidtrial.model.Jcsj_Device;
import com.cist.offsite.invalidtrial.model.SysConfig;
import com.cist.offsite.invalidtrial.model.SysDepartInfo;
import com.cist.offsite.invalidtrial.model.SysPoliceInfo;
import com.cist.offsite.invalidtrial.model.Sys_frm_code;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.offsite.invalidtrial.model.Tbl_dev_vio_config;
import com.cist.offsite.invalidtrial.model.VwDevInfo;
import com.cist.picture.model.Tbl_offe_cate;

/**  
 * @ClassName: FirstService  
 * @Description: TODO(无效数据业余层)  
 * @author Administrator  
 * @date 2018年5月4日  
 *    
 */
public interface InvalidTrialService {
	
   /**
  	 * 查询单条信息审核
  	 * @param map 查询条件
  	 * @return TblOffeEvdiInfo
  	 */
  TblOffeEvdiInfo selectByWfpk(HashMap<String,Object> map);
  
  /**
	 * 多条件查询无效数据信息
	 * @param map 查询条件
	 * @return List<TblOffeEvdiInfo>
	 */
  Object selectByConditionpageList(HashMap<String,Object> map,PageInfo p);
  
  /**
	 * 更新审核无效数据
	 * @param map 查询条件
	 * @return Integer
	 */
 Integer updateByWfpk(HashMap<String,Object> map);
 /**
	 * 查询下一条审核信息审核
	 * @param tblOffeEvdiInfo 查询条件
	 * @return TblOffeEvdiInfo
	 */
 TblOffeEvdiInfo selectNextByWfpk(HashMap<String,Object> map);
 
 /**
	 * 查询上一条审核信息审核
	 * @param tblOffeEvdiInfo 查询条件
	 * @return TblOffeEvdiInfo
	 */
TblOffeEvdiInfo selectUpByWfpk(HashMap<String,Object> map);
 /**
	 * 查询采集设备信息
	 * 
	 * @return  List<VwDevInfo>
	 */
  List<VwDevInfo> selectByVwDevInfo();
  /**
 	 * 查询号牌类别信息
 	 * @return  List<CPlateTypeInfo>
 	 */
List<Sys_frm_code> selectSysFrmCode(String fct_code);
/**
 * 查询号牌颜色信息
 * @return  List<CPlateColorInfo>
 */
List<CPlateColorInfo> selectByCPlateColorInfo();
 
/**
 * 查询号牌前两位
 * @return  List<CPlateKerisInfo>
 */
List<CPlateKerisInfo> selectByCPlateKerisInfo();

/**
 * 查询号牌种类对应的值
 * @return  Sys_frm_code
 */
Sys_frm_code selectByHpzl(HashMap<String,Object> map);

/**
 * 查询号牌颜色对应的值
 * @return  CPlateColorInfo
 */
CPlateColorInfo selectByHpys(HashMap<String,Object> map);

/**
 * 查询违法行为对应的值
 * @return  Tbl_offe_cate
 */
Tbl_offe_cate selectByWfxw(HashMap<String,Object> map);

/**
 * 查询采集单位对应的值
 * @return  SysDepartInfo
 */
SysDepartInfo selectByCjdw(HashMap<String,Object> map);

/**
 * 查询采集设备对应的值
 * @return  VwDevInfo
 */
Jcsj_Device selectByCjsb(HashMap<String,Object> map);

/**
 * 查询方向对应的值
 * @return  CDirectionInfo
 */
CDirectionInfo selectByFxbh(HashMap<String,Object> map);

//上级下级部门
List<Depart_info> depart_infolist(Integer dept_superior);

//根据部门获取 违法地点
List<Depart_info> Monitorpoint(String tbmp_dept_code);

TblOffeEvdiInfo selectExport(HashMap<String,Object> map);

//根据部门获取设备信息树
List<CRoadItem> selectRoad(String dept_code);

//根据道路获取点位信息
List<C_Monitor_Point_Ex> selectPoint(String m_road_code);

//根据点位查询设备
List<Tbl_dev_vio_config> selectDev(Integer dve_pk);

//操作日志
Integer saveLog(HashMap<String,Object> map);

//作废原因查询
List<CReason> selectReason();

//查询数据当前状态是否未审核
TblOffeEvdiInfo selectStatus(HashMap<String,Object> map);

//查询审核结果为有效时是否存在此有效数据
TblOffeEvdiInfo selectValid(HashMap<String,Object> map);

//统计12日内未审核数据，今日当前用户审核数量
TblOffeEvdiInfo selectCount(HashMap<String,Object> map);

//查询违法数据有效期
SysConfig selectConfig(HashMap<String,Object> map);

//审核结果的车辆标记插入
Integer insertBus(HashMap<String,Object> map);

//审核数
Integer auditnumber(HashMap<String,Object> map);
//基础代码表
Integer sycivalue(HashMap<String,Object> map);
//今日审核总计
Integer getjintiri(HashMap<String,Object> map);

//无效原因名称查询
Sys_frm_code selectZfyy(HashMap<String,Object> map);

//审核人名称
SysPoliceInfo selectShr(HashMap<String,Object> map);

/**
 * 更新六合一信息
 * @param map
 * @return
 */
public Integer updateCarInfo(HashMap<String, Object> map);

/**
 * 查询限行违法数据
 * @param map
 * @return
 */
TblOffeEvdiInfo selectRestriction(HashMap<String, Object> map);

/**
 * 查询警员列表
 * @param map
 * @return
 */
List<SysPoliceInfo> selectPolice(HashMap<String, Object> map);

}
