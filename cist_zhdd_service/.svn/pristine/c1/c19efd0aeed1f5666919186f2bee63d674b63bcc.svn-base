package com.cist.eventmanagement.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.eventmanagement.mapper.EventManagementMapper;
import com.cist.eventmanagement.model.DeptInfo;
import com.cist.eventmanagement.model.VW_EVENT_INFO;
import com.cist.eventmanagement.model.Zhdd_event_acceptance;
import com.cist.eventmanagement.model.Zhdd_event_attachment;
import com.cist.eventmanagement.model.Zhdd_event_dispatch;
import com.cist.eventmanagement.model.Zhdd_event_flow;
import com.cist.eventmanagement.model.Zhdd_event_personnel;
import com.cist.eventmanagement.model.Zhdd_event_preselection;
import com.cist.eventmanagement.model.Zhdd_event_result;
import com.cist.eventmanagement.model.Zhdd_event_source;
import com.cist.eventmanagement.model.Zhdd_event_type;
import com.cist.eventmanagement.model.Zhdd_work_flow;
import com.cist.eventmanagement.model.Zhdd_work_flow_detail;
import com.cist.eventmanagement.service.EventManagementService;
import com.cist.frame.page.PageInfo;
@Service
public class EventManagementServiceImpl implements EventManagementService {
	@Autowired
	private EventManagementMapper mapper;
	
	@Override
	public List<VW_EVENT_INFO> queryeventinfo(HashMap<String, Object> map) {
		return mapper.queryeventinfo(map);
	}

	@Override
	public Object queryeventinfopageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.queryeventinfo(map);
	}

	@Override
	public Integer deleteeventinfo(HashMap<String, Object> map) {
		return mapper.deleteeventinfo(map);
	}

	@Override
	public Integer updateeventinfo(HashMap<String, Object> map) {
		return mapper.updateeventinfo(map);
	}

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public List<Zhdd_event_source> querysjly(HashMap<String, Object> map) {
		return mapper.querysjly(map);
	}

	@Override
	public List<Zhdd_event_type> querysjtype(HashMap<String, Object> map) {
		return mapper.querysjtype(map);
	}

	@Override
	public Integer addsj(HashMap<String, Object> map) {
		return mapper.addsj(map);
	}

	@Override
	public Integer addslinfo(HashMap<String, Object> map) {
		return mapper.addslinfo(map);
	}

	@Override
	public Integer delZhdd_event_acceptance(HashMap<String, Object> map) {
		return mapper.delZhdd_event_acceptance(map);
	}

	@Override
	public List<Zhdd_event_dispatch> queryddinfo(HashMap<String, Object> map) {
		return mapper.queryddinfo(map);
	}

	@Override
	public List<Zhdd_event_acceptance> queryslinfo(HashMap<String, Object> map) {
		return mapper.queryslinfo(map);
	}

	@Override
	public List<Zhdd_event_flow> querylcinfo(HashMap<String, Object> map) {
		return mapper.querylcinfo(map);
	}

	@Override
	public List<Zhdd_event_preselection> queryyxx(HashMap<String, Object> map) {
		return mapper.queryyxx(map);
	}

	@Override
	public List<Zhdd_event_personnel> querypeople(HashMap<String, Object> map) {
		return mapper.querypeople(map);
	}

	@Override
	public List<Zhdd_event_attachment> querysjfj(HashMap<String, Object> map) {
		return mapper.querysjfj(map);
	}

	@Override
	public Zhdd_event_result querysjjg(HashMap<String, Object> map) {
		return mapper.querysjjg(map);
	}

	@Override
	public Integer updateZhdd_event_information(HashMap<String, Object> map) {
		return mapper.updateZhdd_event_information(map);
	}

	@Override
	public Integer updateZhdd_event_acceptance(HashMap<String, Object> map) {
		return mapper.updateZhdd_event_acceptance(map);
	}

	@Override
	public Integer updateZhdd_event_result(Map<String, Object> map) {
		return mapper.updateZhdd_event_result(map);
	}

	@Override
	public Integer updateZhdd_event_flow(Map<String, Object> map) {
		return mapper.updateZhdd_event_flow(map);
	}

	@Override
	public Zhdd_work_flow queryZhdd_work_flow(HashMap<String, Object> map) {
		return mapper.queryZhdd_work_flow(map);
	}

	@Override
	public List<Zhdd_work_flow_detail> queryZhdd_work_flow_detail(HashMap<String, Object> map) {
		return mapper.queryZhdd_work_flow_detail(map);
	}

	@Override
	public Integer addflow(Map<String, Object> map) {
		return mapper.addflow(map);
	}

	@Override
	public Integer addresult(Map<String, Object> map) {
		return mapper.addresult(map);
	}

	@Override
	public Integer delZhdd_event_attachment(HashMap<String, Object> map) {
		return mapper.delZhdd_event_attachment(map);
	}

	@Override
	public Integer addZhdd_event_attachment(Zhdd_event_attachment attachment) {
		return mapper.addZhdd_event_attachment(attachment);
	}

	@Override
	public List<Zhdd_event_attachment> queryZhdd_event_attachment(HashMap<String, Object> map) {
		return mapper.queryZhdd_event_attachment(map);
	}

	@Override
	public Integer updateResult(HashMap<String, Object> map) {
		return mapper.updateResult(map);
	}

	
}
