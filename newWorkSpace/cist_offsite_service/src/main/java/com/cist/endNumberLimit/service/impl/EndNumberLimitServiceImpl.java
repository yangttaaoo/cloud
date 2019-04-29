package com.cist.endNumberLimit.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.endNumberLimit.mapper.EndNumberLimitMapper;
import com.cist.endNumberLimit.model.MountTree;
import com.cist.endNumberLimit.service.EndNumberLimitService;
import com.cist.frame.page.PageInfo;

@Service
public class EndNumberLimitServiceImpl implements EndNumberLimitService {
	@Autowired
	private EndNumberLimitMapper mapper;

	public Object querypageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		return mapper.queryList(paramMap);
	}

	public int insertData(HashMap<String, Object> paramMap) {
		return mapper.insertData(paramMap);
	}

	public List<MountTree> queryParentNode() {
		return mapper.queryParentNode();
	}

	public int delData(HashMap<String, Object> paramMap) {
		return mapper.delData(paramMap);
	}

	public int delAllData(List<String> list) {
		return mapper.delAllData(list);
	}

	public int update(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.update(paramMap);
	}

	

	public List<MountTree> querChildrenNode(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return mapper.querChildrenNode(hashMap);
	}

}
