package com.cist.fieid.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.fieid.mapper.FieidMapper;
import com.cist.fieid.model.C_direction;
import com.cist.fieid.model.TblOffeEvdiInfo;
import com.cist.fieid.service.FieidService;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.CPlateColorInfo;
import com.cist.offsite.invalidtrial.model.CPlateKerisInfo;
import com.cist.offsite.invalidtrial.model.CPlateTypeInfo;

@Service
public class FieidServiceImpl implements FieidService {

	@Autowired
	private FieidMapper mapper;

	public Object selectAllpageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.selectAll(map);
	}

	/*
	 * public List<TblOffeEvdiInfo> selectHphm() { return mapper.selectHphm(); }
	 */

	public List<C_direction> runDirection(C_direction direction) {
		return mapper.runDirection(direction);
	}

	public Integer updateState(HashMap<String, Object> map) {
		Integer updateState = mapper.updateState(map);
		mapper.saveLog(map);//保存审核操作日志
		if(updateState>0&&(map.get("clyt")!=null||map.get("sxrqdate")!=null||map.get("yxqzdate")!=null||map.get("clbz")!=null))
			{
			return mapper.insertBus(map);//审核结果车辆标记，用途插入。
			
			}
		else
		{
			return updateState;
		}
	}

	@Override
	public List<TblOffeEvdiInfo> getPreData(HashMap<String, Object> map) {
		return mapper.getPreData(map);
	}

	@Override
	public List<TblOffeEvdiInfo> getNextData(HashMap<String, Object> map) {
		return mapper.getNextData(map);
	}

	@Override
	public TblOffeEvdiInfo getBywfpk(Long wfpk) {
		return mapper.selectBywfpk(wfpk);
	}

	/**
	 * 查询号牌类别信息
	 * 
	 * @return List<CPlateTypeInfo>
	 */
	public List<CPlateTypeInfo> selectByCPlateTypeInfo() {
		return mapper.selectByCPlateTypeInfo();
	}

	/**
	 * 查询号牌颜色信息
	 * 
	 * @return List<CPlateColorInfo>
	 */
	public List<CPlateColorInfo> selectByCPlateColorInfo() {
		return mapper.selectByCPlateColorInfo();
	}

	/**
	 * 查询号牌前两位
	 * 
	 * @return List<CPlateKerisInfo>
	 */
	public List<CPlateKerisInfo> selectByCPlateKerisInfo() {
		return mapper.selectByCPlateKerisInfo();
	}

	@Override
	public String devTree(HashMap<String, String> map) throws Exception {

//		HashMap<String, Object> result = new HashMap<String, Object>();
//		result.put("title", map.get("deptName"));
//		result.put("key", "-1");
//		result.put("expanded", true);
//		List<VideoMonitorTree> roadNode = vmapper.getRoadNode(map);
//		int roadNodeSize = roadNode.size();
//		for (int i = 0; i < roadNodeSize; i++) {
//			String roadId = roadNode.get(i).getKey();
//			map.put("roadId", roadId);
//			List<VideoMonitorTree> pointNode = vmapper.getVideoMonitorNode(map);
//			roadNode.get(i).setChildren(pointNode);
//			int pointSize = pointNode.size();
//			for (int k = 0; k < pointSize; k++) {
//				HashMap<String, String> devIdMap = new HashMap<String, String>();
//				devIdMap.put("devId", pointNode.get(k).getKey());
//				List<VideoMonitorTree> devNode = vmapper.getMonitorDevNode(devIdMap);
//				pointNode.get(k).setChildren(devNode);
//			}
//		}
//		result.put("children", roadNode);
//		ObjectMapper objmapper = new ObjectMapper();
//		return objmapper.writeValueAsString(result);
		return null;
	}

	@Override
	public Long getDeptCode(HashMap<String, String> map) {
		return mapper.getDeptCode(map);
	}

	@Override
	public Integer saveLog(HashMap<String, Object> map) {
		return mapper.saveLog(map);
	}

	@Override
	public Integer saveVehBus(HashMap<String, Object> map) {
		return mapper.saveVehBus(map);
	}

	@Override
	public Integer insertBus(HashMap<String, Object> map) {
		return mapper.insertBus(map);
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
	public TblOffeEvdiInfo selectRestriction(HashMap<String, Object> map) {
		return mapper.selectRestriction(map);
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

}
