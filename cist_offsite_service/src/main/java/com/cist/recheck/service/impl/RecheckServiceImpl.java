package com.cist.recheck.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cist.frame.page.PageInfo;
import com.cist.illegal.model.TBL_OFFE_CATE;
import com.cist.illegal.model.TBL_VERIFY_GROUP;
import com.cist.offsite.invalidtrial.mapper.TblOffeEvdiInfoMapper;
import com.cist.offsite.invalidtrial.model.Sys_frm_code;
import com.cist.picture.model.C_plate_type;
import com.cist.picture.model.Tbl_offe_cate;
import com.cist.recheck.mapper.RecheckMapper;
import com.cist.recheck.model.TblOffeCateInfo;
import com.cist.recheck.model.TblOffeEvdiInfo;
import com.cist.recheck.model.VwDevInfo;
import com.cist.recheck.model.Vw_dev_info;
import com.cist.recheck.service.RecheckService;

import oracle.net.aso.p;




@Service
public class RecheckServiceImpl implements RecheckService{
	
	@Autowired
	private RecheckMapper mapper;


	/**
   	 * 查询所有无效数据
   	 * @return List<TblOffeEvdiInfo>
   	 */
	public Object selectAllInvalidTrialpageList(PageInfo pinfo) {
		return mapper.selectAllInvalidTrial();
	}

	/**
  	 * 查询单条信息审核
  	 * @param map 查询条件
  	 * @return TblOffeEvdiInfo
  	 */
	public TblOffeEvdiInfo selectByWfpk(TblOffeEvdiInfo tblOffeEvdiInfo) {
		
		return mapper.selectByWfpk(tblOffeEvdiInfo);
	}
	 /**
		 * 多条件查询无效数据信息
		 * @param map 查询条件
		 * @return List<TblOffeEvdiInfo>
		 */
	public Object selectByConditionpageList(HashMap<String,Object> map,PageInfo p) {
		return	mapper.selectByCondition(map);
	}

	/**
	 * 更新审核无效数据
	 * @param map 查询条件
	 * @return Integer
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer updateByWfpk(HashMap<String,Object> map) {
		Integer updateByWfpk = mapper.updateByWfpk(map);
		mapper.saveLog(map);//保存审核操作日志
		if(updateByWfpk>0&&(map.get("clyt")!=null||map.get("sxrqdate")!=null||map.get("yxqzdate")!=null||map.get("clbz")!=null))
			{
			return mapper.insertBus(map);//审核结果车辆标记，用途插入。
			
			}
		else
		{
			return updateByWfpk;
		}
	}
	/**
	 * 查询下一条审核信息审核
	 * @param tblOffeEvdiInfo 查询条件
	 * @return TblOffeEvdiInfo
	 */
	public TblOffeEvdiInfo selectNextByWfpk(TblOffeEvdiInfo tblOffeEvdiInfo) {
		return mapper.selectNextByWfpk(tblOffeEvdiInfo);
	}
	/**
	 * 查询采集设备信息
	 * @return  List<VwDevInfo>
	 */
	public List<VwDevInfo> selectByVwDevInfo() {
		return mapper.selectByVwDevInfo();
	}

	public TblOffeCateInfo tblByShort(HashMap<String, Object> map) {
		return mapper.tblByShort(map);
	}

	public List<TblOffeEvdiInfo> queryWfdd() {
		return mapper.queryWfdd();
	}


	public List<TblOffeEvdiInfo> selectNextByWfpk(HashMap<String, Object> map) {
		return mapper.selectNextByWfpk(map);
	}


	public List<TblOffeEvdiInfo> selectUpperByWfpk(HashMap<String, Object> map) {
		return mapper.selectUpperByWfpk(map);
	}

	@Override
	public List<Vw_dev_info> treeSb(HashMap<String,Object> map) {
		return mapper.treeSb(map);
	}

	@Override
	public List<Vw_dev_info> treeSbList(String tbei_code) {
		return mapper.treeSbList(tbei_code);
	}

	@Override
	public List<TblOffeEvdiInfo> exportZipList(HashMap<String, Object> map) {
		return mapper.exportZipList(map);
	}

	@Override
	public Integer saveLog(HashMap<String, Object> map) {
		return mapper.saveLog(map);
	}

	@Override
	public List<Sys_frm_code> selectSysFrmCode(String fct_code) {
		return mapper.selectSysFrmCode(fct_code);
	}

	@Override
	public Integer addInsert(HashMap<String, Object> map) {
		return mapper.addInsert(map);
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
	public List<Sys_frm_code> plateTypeList(String fct_code) {
		return mapper.plateTypeList(fct_code);
	}

	@Override
	public TblOffeEvdiInfo selectValid(HashMap<String, Object> map) {
		return mapper.selectValid(map);
	}

	@Override
	public TblOffeEvdiInfo selectStatus(HashMap<String, Object> map) {
		return mapper.selectStatus(map);
	}

	@Override
	public Integer insertBus(HashMap<String, Object> map) {
		return mapper.insertBus(map);
	}

	@Override
	public Integer updateCarInfo(HashMap<String, Object> map) {
		return mapper.updateCarInfo(map);
	}

	@Override
	public TblOffeEvdiInfo selectInfo(HashMap<String, Object> map) {
		return mapper.selectInfo(map);
	}

	@Override
	public TblOffeEvdiInfo selectRestriction(HashMap<String, Object> map) {
		return mapper.selectRestriction(map);
	}

	@Override
	public String querysbbhbysbpk(HashMap<String, Object> map) {
		return mapper.querysbbhbysbpk(map);
	}




/*	public List<TblOffeCateInfo> selectByWfxw(TblOffeCateInfo tInfo) {
		return mapper.selectByWfxw(tInfo);
	}*/
}
