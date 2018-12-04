package com.cist.dataexport.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.cist.dataexport.model.Depart_info;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.CDirectionInfo;
import com.cist.offsite.invalidtrial.model.CPlateColorInfo;
import com.cist.offsite.invalidtrial.model.CPlateKerisInfo;
import com.cist.offsite.invalidtrial.model.CPlateTypeInfo;
import com.cist.offsite.invalidtrial.model.SysDepartInfo;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.offsite.invalidtrial.model.VwDevInfo;
import com.cist.offsite.invalidtrial.utils.DynaSqlProvider;

public interface DataExportMapper {

  /**
	 * 多条件查询无效数据信息
	 * @param map 查询条件
	 * @return List<TblOffeEvdiInfo>
	 */
  /* @SelectProvider(type=DynaSqlProvider.class,method="dataExportList")*/
  List<TblOffeEvdiInfo> list(HashMap<String,Object> map);
   
   /**
 	 * 查询川外违法数据详情
 	 * @param tblOffeEvdiInfo 查询条件
 	 * @return TblOffeEvdiInfo
 	 */
 TblOffeEvdiInfo selectByWfpk(TblOffeEvdiInfo tblOffeEvdiInfo);

 /**
	 * excle导出数据查询 ZIP导出数据查询只查前100条
	 * @param map 查询条件
	 * @return List<TblOffeEvdiInfo>
	 */
 @SelectProvider(type=DynaSqlProvider.class,method="exportZipList")
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