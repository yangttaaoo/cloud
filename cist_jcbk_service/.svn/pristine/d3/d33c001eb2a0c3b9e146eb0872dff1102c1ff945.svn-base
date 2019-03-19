package com.cist.messagetemplateconfig.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.messagetemplateconfig.mapper.MessageConfigMapper;
import com.cist.messagetemplateconfig.model.Jcbk_sms_template;
import com.cist.messagetemplateconfig.model.Sys_frm_code;
import com.cist.messagetemplateconfig.service.MessageConfigService;
@Service
public class MessageConfigServiceImpl implements MessageConfigService {
	@Autowired
	private MessageConfigMapper mapper;

	@Override
	public List<Jcbk_sms_template> selectData(HashMap<String, Object> map) {
		return mapper.selectData(map);
	}

	@Override
	public Object selectDatapageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.selectData(map);
	}

	@Override
	public Integer updateData(HashMap<String, Object> map) {
		return mapper.updateData(map);
	}

	@Override
	public Integer addData(HashMap<String, Object> map) {
		return mapper.addData(map);
	}

	@Override
	public List<Sys_frm_code> selectKxx(HashMap<String, Object> map) {
		return mapper.selectKxx(map);
	}

	@Override
	public Integer deleteData(HashMap<String, Object> map) {
		return mapper.deleteData(map);
	}
}
