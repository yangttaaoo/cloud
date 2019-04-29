package com.cist.videoMonitor.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.videoMonitor.model.Device;
import com.cist.videoMonitor.model.Tbl_VioPrestConfig;
import com.cist.videoMonitor.service.VideoMonitorService;

@RestController
@RequestMapping("videoMonitor")
public class VideoMonitorController {
	@Autowired
	private VideoMonitorService service;

	@RequestMapping("initTree")
	public String initTree(@RequestBody HashMap<String, Object> paramMap) {

		try {
			return service.initTree();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping("info")
	public HashMap<String, Object> getVideoMonitorInfo(@RequestBody HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		Device dev_Info = service.getVideoMonitorInfo(paramMap);
		if (dev_Info != null) {
			List<Tbl_VioPrestConfig> vioPrestConfig = service.getVioPrestConfig(dev_Info.getPk_id());
			resultMap.put("presetInfo", vioPrestConfig);
		} else {
			resultMap.put("presetInfo", null);
		}

		resultMap.put("devInfo", dev_Info);

		return resultMap;

	}

	@RequestMapping("addPrest")
	public int addPrest(@RequestBody HashMap<String, Object> paramMap) {
		return service.EditPrest(paramMap);

	}
	@RequestMapping("delPrest")
	public int delPrest(@RequestBody HashMap<String, List<Integer>> paramMap) {
		
		return service.delPrest(paramMap);

	}
}
