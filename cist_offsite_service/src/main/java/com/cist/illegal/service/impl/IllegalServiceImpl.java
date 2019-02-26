package com.cist.illegal.service.impl;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.illegal.mapper.IllegalMapper;
import com.cist.illegal.model.C_plate_keris;
import com.cist.illegal.model.SYS_FRM_CODE;
import com.cist.illegal.model.TBL_OFFE_CATE;
import com.cist.illegal.model.TBL_OFFE_EVDI;
import com.cist.illegal.model.TBL_VERIFY_GROUP;
import com.cist.illegal.service.IllegalService;
import com.cist.recheck.model.TblOffeEvdiInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IllegalServiceImpl implements IllegalService {

	@Autowired
	private IllegalMapper mapper;

	@Override
	public List<SYS_FRM_CODE> queryfrms(HashMap<String, Object> map) {
		return mapper.queryfrms(map);
	}

	@Override
	public List<TBL_OFFE_EVDI> queryevdi(HashMap<String, Object> map) {
		return mapper.queryevdi(map);
	}

	@Override
	public Object queryevdipageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.queryevdi(map);
	}

	@Override
	public Object queryuploadpageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.queryupload(map);
	}

	@Override
	public List<C_plate_keris> queryPlateKeris() {
		return mapper.queryPlateKeris();
	}

	@Override
	public List<TBL_OFFE_CATE> selectwfxw(HashMap<String, Object> map) {
		return mapper.selectwfxw(map);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer updateIllegal(HashMap<String, Object> map) {
		Integer updateIllegal = mapper.updateIllegal(map);
		HashMap object = (HashMap) map.get("dataList");//六合一信息
		if(object!=null&&object.get("wfpk")!=null)
		{
			object.put("lhyflag", "1");//六合一标志
			mapper.updateCarInfo(object);
		}
		
		mapper.addlog(map);//保存审核操作日志
		
		if("0".equals(map.get("shbj"))&&updateIllegal>0&&(map.get("clyt")!=null||map.get("yxqz")!=null||map.get("clbz")!=null))
			{
			return mapper.insertBus(map);//审核结果车辆标记，用途插入。
			}
		else
		{
			return updateIllegal;
		}
	}

	@Override
	public List<TBL_OFFE_EVDI> selectNextByWfpk(HashMap<String, Object> map) {
		return mapper.selectNextByWfpk(map);
	}

	@Override
	public List<TBL_OFFE_EVDI> selectUpperByWfpk(HashMap<String, Object> map) {
		return mapper.selectUpperByWfpk(map);
	}

	@Override
	public Integer addveh(HashMap<String, Object> map) {
		return mapper.addveh(map);
	}

	@Override
	public Integer addlog(HashMap<String, Object> map) {
		return mapper.addlog(map);
	}

	@Override
	public Integer queryjrgzl(String sypi_pk) {
		return mapper.queryjrgzl(sypi_pk);
	}

	@Override
	public Integer sycivalue(HashMap<String, Object> map) {
		return mapper.sycivalue(map);
	}

	@Override
	public Integer auditnumber(HashMap<String, Object> map) {
		return mapper.auditnumber(map);
	}

	@Override
	public List<TBL_VERIFY_GROUP> querywfxwqxbysypi(String sypi_pk) {
		return mapper.querywfxwqxbysypi(sypi_pk);
	}

	@Override
	public String querydevbysypi(Integer tbvg_pk) {
		return mapper.querydevbysypi(tbvg_pk);
	}

	@Override
	public List<TBL_OFFE_CATE> querywfxw(HashMap<String, Object> map) {
		return mapper.querywfxw(map);
	}

	@Override
	public String querysbbhbysbpk(HashMap<String, Object> map) {
		return mapper.querysbbhbysbpk(map);
	}

	@Override
	public Integer querycsnum(HashMap<String, Object> map) {
		return mapper.querycsnum(map);
	}

	@Override
	public TBL_OFFE_EVDI querydatabywfpk(String wfpk) {
		return mapper.querydatabywfpk(wfpk);
	}

	@Override
	public TBL_OFFE_EVDI selectCarInfo(HashMap<String, Object> map) {
		return mapper.selectCarInfo(map);
	}

	@Override
	public Integer updateCarInfo(HashMap<String, Object> map) {
		return mapper.updateCarInfo(map);
	}

	@Override
	public TBL_OFFE_EVDI selectValid(HashMap<String, Object> map) {
		return mapper.selectValid(map);
	}

	@Override
	public TBL_OFFE_EVDI selectStatus(HashMap<String, Object> map) {
		return mapper.selectStatus(map);
	}

	@Override
	public Integer insertBus(HashMap<String, Object> map) {
		return mapper.insertBus(map);
	}

	@Override
	public TblOffeEvdiInfo selectRestriction(HashMap<String, Object> map) {
		return mapper.selectRestriction(map);
	}

	@Override
	public Integer tiqu(HashMap<String, Object> map) {
		return mapper.tiqu(map);
	}

	@Override
	public Object selectAllExtractpageList(HashMap<String, Object> map, PageInfo p) {
		return mapper.selectAllExtract(map);
	}

}
