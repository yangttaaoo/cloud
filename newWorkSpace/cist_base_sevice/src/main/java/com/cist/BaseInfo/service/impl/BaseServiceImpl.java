package com.cist.BaseInfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.BaseInfo.mapper.BaseMapper;
import com.cist.BaseInfo.model.BaseDataInfo;
import com.cist.BaseInfo.service.BaseService;

@Service
public class BaseServiceImpl implements BaseService  {

	@Autowired
	private BaseMapper mapper;

	public List<BaseDataInfo>  queryBaseList() {
		List<BaseDataInfo> list =  mapper.queryBaseList();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.cist.BaseInfo.service.BaseService#updatePassword(java.util.Map)
	 */
	@Override
	public void updatePassword(Map<String, Object> map) {
		// TODO Auto-generated method stub
		mapper.updatePassword(map);
	}

}
