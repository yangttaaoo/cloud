package com.cist.dataquery.mapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.dataquery.model.Device;
import com.cist.dataquery.model.Direction;
import com.cist.dataquery.model.Excels;
import com.cist.dataquery.model.Oeuser;
import com.cist.dataquery.model.SYS_depart_info;
import com.cist.dataquery.model.Syspoliceinfo;
import com.cist.dataquery.model.Tbl_Log;
import com.cist.dataquery.model.Tbl_offe_cate;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.redinfo.model.Sys_frm_code;


public interface DataQueryMapper {

	/**
	 * 条件查询违法数据查询
	 * 
	 * @param map
	 * 查询条件 return List<Oeuser>
	 */
	 List<Oeuser> findData(Map map);

		/**
		 * 根据审核人获取名字
		 * @param map
		 * @return
		 */
	Syspoliceinfo selectPolice(Integer sypi_pk);
	
	
	//查询违法行为
     public Tbl_offe_cate selectwf(HashMap<String,Object> map);
     //查询采集单位
     public SYS_depart_info selectDanwei(HashMap<String,Object> map);
     //查询采集设备
    // public Device selecteq(HashMap<String,Object> map);
     //查询方向
     public Direction selectDirection(HashMap<String,Object> map);
     public  List<Tbl_Log> selectLog(HashMap<String, Object> map);
     
     List<TblOffeEvdiInfo> selectDataById(HashMap<String, Object> map);
     
     List<Excels> selectAll(HashMap<String, Object> map);
     /**
      * 号牌种类
      * @param fct_code
      * @return
      */
	 List<Sys_frm_code> selectHpzl(String fct_code);
	 
	 /**
	  * 采集设备名称
	  * @param map
	  * @return
	  */
	 Device selectSbbhName(Map<String, Object> map);
	 

	 
}
