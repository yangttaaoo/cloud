package com.cist.serviceconfig.warningconfig.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.serviceconfig.warningconfig.mapper.WarningconfigMapper;
import com.cist.serviceconfig.warningconfig.model.DeptInfo;
import com.cist.serviceconfig.warningconfig.model.TBL_OFFE_VIO_ALARM;
import com.cist.serviceconfig.warningconfig.model.Tbl_dev_info;
import com.cist.serviceconfig.warningconfig.model.VideoMonitorTree;
import com.cist.serviceconfig.warningconfig.service.WarningconfigService;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class WarningconfigServiceImpl implements WarningconfigService {
	@Autowired
	private WarningconfigMapper mapper;

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}
	@Override
	public List<DeptInfo> Monitorpoint(String tbmp_dept_code) {
		return mapper.Monitorpoint(tbmp_dept_code);
	}
	@Override
	public List<DeptInfo> Device(String tbmp_id) {
		return mapper.Device(tbmp_id);
	}
	@Override
	public List<TBL_OFFE_VIO_ALARM> queryyjyz(HashMap<String, Object> map) {
		return mapper.queryyjyz(map);
	}
	@Override
	public Object queryyjyzpageList(HashMap<String, Object> map,PageInfo info) {
		return mapper.queryyjyz(map);
	}
	@Override
	public Integer addyjyz(HashMap<String, Object> map) {
		return mapper.addyjyz(map);
	}
	@Override
	public Integer updateyjyz(HashMap<String, Object> map) {
		return mapper.updateyjyz(map);
	}
	@Override
	public Integer delyjyz(HashMap<String, Object> map) {
		return mapper.delyjyz(map);
	}
	@Override
	public String initTree() throws Exception {

		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("title", "德阳交警支队");
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

}
