package com.cist.videoMonitor.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.patrolplan.model.Tbl_Dev_Info;
import com.cist.videoMonitor.mapper.VideoMonitorMapper;
import com.cist.videoMonitor.model.Device;
import com.cist.videoMonitor.model.Tbl_VioPrestConfig;
import com.cist.videoMonitor.model.VideoMonitorTree;
import com.cist.videoMonitor.service.VideoMonitorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class VideoMonitorServiceImpl implements VideoMonitorService {
	@Autowired
	private VideoMonitorMapper mapper;

	public String initTree() throws Exception {

		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("title", "请选择设备");
		result.put("key", "-1");
		result.put("expanded", true);
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
				roadNode.get(j).setChildren(pointNode);
				int  pointSize=pointNode.size();
				for (int k = 0; k < pointSize; k++) {
					HashMap<String, String> devIdMap = new HashMap<String, String>();
					devIdMap.put("devId",pointNode.get(k).getKey());
					List<VideoMonitorTree>	devNode= mapper.getMonitorDevNode(devIdMap);
					pointNode.get(k).setChildren(devNode);
				}
			}
		}
		result.put("children", deptIds);
		ObjectMapper objmapper = new ObjectMapper();
		return objmapper.writeValueAsString(result);
	}

	public List<Tbl_VioPrestConfig> getVioPrestConfig(int devId) {
		HashMap<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("devId", devId);
		return mapper.getVioPrestConfig(paramMap);
	}

	public Device getVideoMonitorInfo(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.getVideoMonitorInfo(paramMap);
	}

	public int EditPrest(HashMap<String, Object> paramMap) {
	Tbl_VioPrestConfig prest = mapper.getPrestByVpcPrest(paramMap);
		int result = 0;
		if (prest!=null) {
			paramMap.put("vpc_pk",prest.getVpc_pk());
			result = mapper.updatePrest(paramMap);
		}else {
			result = mapper.addPrest(paramMap);
		}
			
		return result;
	}

	public int delPrest(HashMap<String, List<Integer>> paramMap) {
		List<Integer> list =paramMap.get("ids");
		
		return mapper.delPrest(list);
	}

}
