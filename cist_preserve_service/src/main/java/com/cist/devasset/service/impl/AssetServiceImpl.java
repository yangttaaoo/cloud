package com.cist.devasset.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.devasset.mapper.AssetMapper;
import com.cist.devasset.model.Jtyw_jksbzc_plan;
import com.cist.devasset.model.Jtyw_sbzc_cs;
import com.cist.devasset.model.Jtyw_sbzc_sbtype;
import com.cist.devasset.model.Vw_jtyw_sbzc_info;
import com.cist.devasset.service.AssetService;
import com.cist.frame.page.PageInfo;

@Service
public class AssetServiceImpl implements AssetService{
	
	@Autowired
	private AssetMapper mapper;

	@Override
	public Object queryAssetpageList(Map<String, Object> map, PageInfo pinfo) {
		return mapper.queryAsset(map);
	}

	@Override
	public Integer insertAsset(Map<String, Object> map) {
		return mapper.insertAsset(map);
	}

	@Override
	public Integer deleteAsset(Map<String, Object> map) {
		return mapper.deleteAsset(map);
	}

	@Override
	public Integer updateAsset(Map<String, Object> map) {
		return mapper.updateAsset(map);
	}

	@Override
	public Integer deleteAll(String[] pk) {
		return mapper.deleteAll(pk);
	}

	@Override
	public List<Jtyw_sbzc_sbtype> queryType(Map<String, Object> map) {
		return mapper.queryType(map);
	}

	@Override
	public List<Jtyw_sbzc_cs> queryCsname(Map<String, Object> map) {
		return mapper.queryCsname(map);
	}

	@Override
	public List<Vw_jtyw_sbzc_info> queryList(Map<String, Object> map) {
		return mapper.queryList(map);
	}
	
}
