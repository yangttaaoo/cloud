package com.cist.messagequery.warningquery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.messagequery.warningquery.mapper.WarningQueryMapper;
import com.cist.messagequery.warningquery.model.WarningQuery;
import com.cist.messagequery.warningquery.service.WarningQueryService;
@Service
public class WarningQueryServiceImpl implements WarningQueryService {
	@Autowired
	private WarningQueryMapper mapper;

	public Object queryallwarningpageList(WarningQuery war, PageInfo info) {
		return mapper.queryallwarning(war);
	}

	public List<WarningQuery> queryallwarning(WarningQuery war) {
		return mapper.queryallwarning(war);
	}

}
