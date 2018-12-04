package com.cist.dataexport.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.cist.dataexport.model.Depart_info;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.CDirectionInfo;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.offsite.invalidtrial.utils.DynaSqlProvider;

/**  
 * @ClassName: DataExportService  
 * @Description: TODO(川外违法数据导出业务层)  
 * @author yt  
 * @date 2018年5月25日  
 *    
 */
public interface DataExportService {
   
  /**
	 * 多条件查询无效数据信息
	 * @param map 查询条件
	 * @return Object
	 */
  Object dataExportListpageList(HashMap<String,Object> map,PageInfo p);
  
  /**
	 * 查询川外违法数据详情
	 * @param map 查询条件
	 * @return TblOffeEvdiInfo
	 */
TblOffeEvdiInfo selectByWfpk(TblOffeEvdiInfo tblOffeEvdiInfo);

/**
	 * excle导出数据查询
	 * @param map 查询条件
	 * @return List<TblOffeEvdiInfo>
	 */
 List<TblOffeEvdiInfo> exportZipList(HashMap<String,Object> map);
 
 /**
  * 查询所有方向信息
  * @return  List<CDirectionInfo>
  */
 List<CDirectionInfo> selectCDirectionInfo();
 
 /**
	 * 更新导出的数据状态
	 * @return  Integer
	 */
Integer updateShbz(HashMap<String,Object> map);
  
//上级下级部门
List<Depart_info> depart_infolist(Integer dept_superior);

//根据部门获取 违法地点
List<Depart_info> Monitorpoint(String tbmp_dept_code);
}
