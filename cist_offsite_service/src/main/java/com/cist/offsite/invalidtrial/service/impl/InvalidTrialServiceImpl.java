package com.cist.offsite.invalidtrial.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.mapper.TblOffeEvdiInfoMapper;
import com.cist.offsite.invalidtrial.model.CDirectionInfo;
import com.cist.offsite.invalidtrial.model.CPlateColorInfo;
import com.cist.offsite.invalidtrial.model.CPlateKerisInfo;
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
import com.cist.offsite.invalidtrial.service.InvalidTrialService;
import com.cist.picture.model.Tbl_offe_cate;

@Service(value="invalidTrialService")
public class InvalidTrialServiceImpl implements InvalidTrialService  {

	@Autowired
	private TblOffeEvdiInfoMapper mapper;

	/**
  	 * 查询单条信息审核
  	 * @param map 查询条件
  	 * @return TblOffeEvdiInfo
  	 */
	public TblOffeEvdiInfo selectByWfpk(@RequestParam HashMap<String,Object> map) {
		
		return mapper.selectByWfpk(map);
	}
	 /**
		 * 多条件查询无效数据信息
		 * @param map 查询条件
		 * @return List<TblOffeEvdiInfo>
		 */
	public Object selectByConditionpageList(HashMap<String,Object> map,PageInfo p) {
				Object o = mapper.selectByCondition(map);
				return o;
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
		if(updateByWfpk>0&&(map.get("clyt")!=null||map.get("yxqzdate")!=null||map.get("sxrqdate")!=null||map.get("clbz")!=null))
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
	public TblOffeEvdiInfo selectNextByWfpk(HashMap<String,Object> map) {
		return mapper.selectNextByWfpk(map);
	}
	/**
	 * 查询采集设备信息
	 * @return  List<VwDevInfo>
	 */
	public List<VwDevInfo> selectByVwDevInfo() {
		return mapper.selectByVwDevInfo();
	}

	 /**
		 * 查询号牌类别信息
		 * @return  List<CPlateTypeInfo>
		 */
	public List<Sys_frm_code> selectSysFrmCode(String fct_code) {
		return mapper.selectSysFrmCode(fct_code);
	}

	/**
	 * 查询号牌颜色信息
	 * @return  List<CPlateColorInfo>
	 */
	public List<CPlateColorInfo> selectByCPlateColorInfo() {
		return mapper.selectByCPlateColorInfo();
	}
	
	/**
	 * 查询号牌前两位
	 * @return  List<CPlateKerisInfo>
	 */
	public List<CPlateKerisInfo> selectByCPlateKerisInfo() {
		return mapper.selectByCPlateKerisInfo();
	}
	/**
	 * 查询号牌种类对应的值
	 * @return  List<CPlateKerisInfo>
	 */
	public Sys_frm_code selectByHpzl(HashMap<String,Object> map) {
		return mapper.selectByHpzl(map);
	}
	/**
	 * 查询号牌颜色对应的值
	 * @return  List<CPlateColorInfo>
	 */
	public CPlateColorInfo selectByHpys(HashMap<String, Object> map) {
		return mapper.selectByHpys(map);
	}
	
	/**
	 * 查询违法行为对应的值
	 * @return  Tbl_offe_cate
	 */
	public Tbl_offe_cate selectByWfxw(HashMap<String, Object> map) {
		return mapper.selectByWfxw(map);
	}
	 
	/**
	 * 查询采集单位对应的值
	 * @return  SysDepartInfo
	 */
	public SysDepartInfo selectByCjdw(HashMap<String, Object> map) {
		return mapper.selectByCjdw(map);
	}
	/**
	 * 查询采集设备对应的值
	 * @return  VwDevInfo
	 */
	public Jcsj_Device selectByCjsb(HashMap<String, Object> map) {
		return mapper.selectByCjsb(map);
	}
	
	/**
	 * 查询采集设备对应的值
	 * @return  CDirectionInfo
	 */
	public CDirectionInfo selectByFxbh(HashMap<String, Object> map) {
		return mapper.selectByFxbh(map);
	}
	/**
	 * 查询上一条审核信息审核
	 * @param tblOffeEvdiInfo 查询条件
	 * @return TblOffeEvdiInfo
	 */
	public TblOffeEvdiInfo selectUpByWfpk(HashMap<String,Object> map) {
		return mapper.selectUpByWfpk(map);
	}
	@Override
	public List<Depart_info> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}
	@Override
	public List<Depart_info> Monitorpoint(String tbmp_dept_code) {
		return mapper.Monitorpoint(tbmp_dept_code);
	}
	@Override
	public TblOffeEvdiInfo selectExport(HashMap<String, Object> map) {
		return mapper.selectExport(map);
	}
	@Override
	public List<CRoadItem> selectRoad(String dept_code) {
		return mapper.selectRoad(dept_code);
	}
	@Override
	public List<C_Monitor_Point_Ex> selectPoint(String m_road_code) {
		return mapper.selectPoint(m_road_code);
	}
	@Override
	public List<Tbl_dev_vio_config> selectDev(Integer dve_pk) {
		return mapper.selectDev(dve_pk);
	}
	@Override
	public Integer saveLog(HashMap<String, Object> map) {
		return mapper.saveLog(map);
	}
	@Override
	public List<CReason> selectReason() {
		return mapper.selectReason();
	}
	@Override
	public TblOffeEvdiInfo selectStatus(HashMap<String, Object> map) {
		return mapper.selectStatus(map);
	}
	@Override
	public TblOffeEvdiInfo selectValid(HashMap<String, Object> map) {
		return mapper.selectValid(map);
	}
	@Override
	public TblOffeEvdiInfo selectCount(HashMap<String, Object> map) {
		return mapper.selectCount(map);
	}
	@Override
	public SysConfig selectConfig(HashMap<String, Object> map) {
		return mapper.selectConfig(map);
	}
	@Override
	public Integer insertBus(HashMap<String, Object> map) {
		return mapper.insertBus(map);
	}
	@Override
	public Integer auditnumber(HashMap<String, Object> map) {
		return mapper.auditnumber(map);
	}
	@Override
	public Integer sycivalue(HashMap<String, Object> map) {
		return mapper.sycivalue(map);
	}
	@Override
	public Integer getjintiri(HashMap<String, Object> map) {
		return mapper.getjintiri(map);
	}
	@Override
	public Sys_frm_code selectZfyy(HashMap<String, Object> map) {
		return mapper.selectZfyy(map);
	}
	@Override
	public SysPoliceInfo selectShr(HashMap<String, Object> map) {
		return mapper.selectShr(map);
	}
	@Override
	public Integer updateCarInfo(HashMap<String, Object> map) {
		return mapper.updateCarInfo(map);
	}
	@Override
	public TblOffeEvdiInfo selectRestriction(HashMap<String, Object> map) {
		return mapper.selectRestriction(map);
	}
	@Override
	public List<SysPoliceInfo> selectPolice(HashMap<String, Object> map) {
		return mapper.selectPolice(map);
	}
	
}
