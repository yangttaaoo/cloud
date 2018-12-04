package com.cist.dataquery.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.dataquery.mapper.DataQueryMapper;
import com.cist.dataquery.model.C_plate_type;
import com.cist.dataquery.model.Device;
import com.cist.dataquery.model.Direction;
import com.cist.dataquery.model.Excels;
import com.cist.dataquery.model.Oeuser;
import com.cist.dataquery.model.SYS_depart_info;
import com.cist.dataquery.model.Syspoliceinfo;
import com.cist.dataquery.model.Tbl_Log;
import com.cist.dataquery.model.Tbl_offe_cate;
import com.cist.dataquery.service.DataQueryService;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.redinfo.model.Sys_frm_code;
@Service("datequeryserviceimpl")
public class DataQueryServiceImpl implements DataQueryService{
	@Autowired
    private DataQueryMapper mapper;

	public Object findDatapageList(Map map,PageInfo page) {
		return mapper.findData(map);
	}

	//查询违法行为
    public Tbl_offe_cate selectwf(HashMap<String,Object> map){
		return mapper.selectwf(map);
    	
    }
    //查询采集单位
    public SYS_depart_info selectDanwei(HashMap<String,Object> map){
		return mapper.selectDanwei(map);
    }
   
    //查询方向
    public Direction selectDirection(HashMap<String,Object> map){
		return mapper.selectDirection(map);
    	
    }

	@Override
	public List<Tbl_Log> selectLog(HashMap<String, Object> map) {
		return mapper.selectLog(map);
	}
	@Override
	public List<TblOffeEvdiInfo> selectDataById(HashMap<String, Object> map) {
		return mapper.selectDataById(map);
	}
	@Override
	public List<Excels> selectAll(HashMap<String, Object> map) {
		return mapper.selectAll(map);
	}
	@Override
	public List<Sys_frm_code> selectHpzl(String fct_code) {
		return mapper.selectHpzl(fct_code);
	}
	@Override
	public Device selectSbbhName(Map<String, Object> map) {
		return mapper.selectSbbhName(map);
	}

	@Override
	public Syspoliceinfo selectPolice(Integer sypi_pk) {
		return mapper.selectPolice(sypi_pk);
	}



}
