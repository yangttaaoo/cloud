package com.cist.dataexport.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.dataexport.mapper.DataExportMapper;
import com.cist.dataexport.model.Depart_info;
import com.cist.dataexport.service.DataExportService;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.mapper.TblOffeEvdiInfoMapper;
import com.cist.offsite.invalidtrial.model.CDirectionInfo;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;

@Service
public class DataExportServiceImpl implements DataExportService  {

	@Autowired
	private DataExportMapper mapper;
	@Autowired
	private TblOffeEvdiInfoMapper Tmapper;

	 /**
		 * 多条件查询无效数据信息
		 * @param map 查询条件
		 * @return List<Object>
		 */
	public Object dataExportListpageList(HashMap<String,Object> map,PageInfo p) {
		Object o=mapper.list(map);
		return o;
				
	}

	 /**
 	 * 查询川外违法数据详情
 	 * @param tblOffeEvdiInfo 查询条件
 	 * @return TblOffeEvdiInfo
 	 */
	public TblOffeEvdiInfo selectByWfpk(TblOffeEvdiInfo tblOffeEvdiInfo) {
		return mapper.selectByWfpk(tblOffeEvdiInfo);
	}
	
	/**
	 * excle导出数据查询
	 * @param map 查询条件
	 * @return List<TblOffeEvdiInfo>
	 */
	public List<TblOffeEvdiInfo> exportZipList(HashMap<String, Object> map) {
		return mapper.exportZipList(map);
	}
	
	/**
	 * 查询所有方向信息
	 * @return  List<CDirectionInfo>
	 */
	public List<CDirectionInfo> selectCDirectionInfo(){
		return mapper.selectCDirectionInfo();
	}
	/**
	 * 更新导出的数据状态
	 * @return  Integer
	 */
	public Integer updateShbz(HashMap<String,Object> map){
		return mapper.updateShbz(map);
		
	}

	@Override
	public List<Depart_info> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public List<Depart_info> Monitorpoint(String tbmp_dept_code) {
		return mapper.Monitorpoint(tbmp_dept_code);
	}
}
