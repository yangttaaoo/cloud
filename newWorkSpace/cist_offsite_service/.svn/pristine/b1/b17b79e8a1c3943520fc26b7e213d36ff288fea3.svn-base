package com.cist.xxtj.sbyjfztj.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.xxtj.sbyjfztj.mapper.SbyjfztjMapper;
import com.cist.xxtj.sbyjfztj.model.TBL_ALARM_CARD_STAT;
import com.cist.xxtj.sbyjfztj.model.TBL_OFFE_VIO_ALARM_STAT;
import com.cist.xxtj.sbyjfztj.model.VideoMonitorTree;
import com.cist.xxtj.sbyjfztj.model.Wfddyjpm;
import com.cist.xxtj.sbyjfztj.model.Wfddzpnum;
import com.cist.xxtj.sbyjfztj.model.Wfzpqs;
import com.cist.xxtj.sbyjfztj.model.Yjwfdd;
import com.cist.xxtj.sbyjfztj.service.SbyjfztjService;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class SbyjfztjServiceImpl implements SbyjfztjService {
	@Autowired
	private SbyjfztjMapper mapper;

	@Override
	public Integer querysbyjnum(HashMap<String, Object> map) {
		return mapper.querysbyjnum(map);
	}

	@Override
	public List<TBL_OFFE_VIO_ALARM_STAT> querysbyjtj(HashMap<String, Object> map) {
		return mapper.querysbyjtj(map);
	}

	@Override
	public Integer querytzb(HashMap<String, Object> map) {
		return mapper.querytzb(map);
	}

	@Override
	public List<Wfddyjpm> querywfddyjpm(HashMap<String, Object> map) {
		return mapper.querywfddyjpm(map);
	}

	@Override
	public List<Yjwfdd> queryyjwfdd(HashMap<String, Object> map) {
		return mapper.queryyjwfdd(map);
	}

	@Override
	public List<Wfddzpnum> querynumbywfdd(HashMap<String, Object> map) {
		return mapper.querynumbywfdd(map);
	}

	@Override
	public List<Wfddyjpm> queryzppm(HashMap<String, Object> map) {
		return mapper.queryzppm(map);
	}

	@Override
	public List<Wfzpqs> querywfzpqs(HashMap<String, Object> map) {
		return mapper.querywfzpqs(map);
	}

	@Override
	public TBL_OFFE_VIO_ALARM_STAT queryszcjslbysj(HashMap<String, Object> map) {
		return mapper.queryszcjslbysj(map);
	}

	@Override
	public List<Wfzpqs> querywfzpqstable(HashMap<String, Object> map) {
		return mapper.querywfzpqstable(map);
	}

	@Override
	public List<Wfddyjpm> querywfzppm(HashMap<String, Object> map) {
		return mapper.querywfzppm(map);
	}

	@Override
	public List<TBL_ALARM_CARD_STAT> querysbinfo(HashMap<String, Object> map) {
		return mapper.querysbinfo(map);
	}
	
	public String initTree() throws Exception {

		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("title", "请选择违法地点");
		result.put("key", "-1");
		result.put("expanded", true);
		result.put("selectable", false);
		List<VideoMonitorTree> deptIds = mapper.getDeptNode();
		int deptIdSize = deptIds.size();
		for (int i = 0; i < deptIdSize; i++) {
			String deptId = deptIds.get(i).getKey();
			HashMap<String, String> paramMap = new HashMap<String, String>();

			paramMap.put("deptId", deptId);
			List<VideoMonitorTree> roadNode = mapper.getRoadNode(paramMap);
			deptIds.get(i).setChildren(roadNode);
			for (int j = 0; j < roadNode.size(); j++) {
				String roadId = roadNode.get(j).getKey();
				paramMap.put("roadId", roadId);
				List<VideoMonitorTree> pointNode = mapper.getVideoMonitorNode(paramMap);
				for (int k = 0; k < pointNode.size(); k++) {
					pointNode.get(k).setSelectable(true);
				}
				roadNode.get(j).setChildren(pointNode);
			}
		}
		result.put("children", deptIds);
		ObjectMapper objmapper = new ObjectMapper();
		return objmapper.writeValueAsString(result);
	}
}
