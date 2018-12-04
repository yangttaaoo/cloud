package com.cist.tjfx.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.tjfx.mapper.TjfxMapper;
import com.cist.tjfx.model.EvidenceTj;
import com.cist.tjfx.model.Myxzltj;
import com.cist.tjfx.service.TjfxService;
@Service
public class TjfxServiceImpl implements TjfxService {
	@Autowired
	private TjfxMapper mapper;
	@Override
	public Integer queryevidencenum(HashMap<String,Object> map) {
		return mapper.queryevidencenum(map);
	}
	@Override
	public Integer querybyxz(HashMap<String, Object> map) {
		return mapper.querybyxz(map);
	}
	@Override
	public List<Myxzltj> querymyxzl(HashMap<String, Object> map) {
		return mapper.querymyxzl(map);
	}
	@Override
	public List<EvidenceTj> querynumbydept(HashMap<String, Object> map) {
		return mapper.querynumbydept(map);
	}
	@Override
	public List<EvidenceTj> querytjbyzjlx(HashMap<String, Object> map) {
		return mapper.querytjbyzjlx(map);
	}
	@Override
	public List<EvidenceTj> querytjbysalx(HashMap<String, Object> map) {
		return mapper.querytjbysalx(map);
	}
	@Override
	public List<Myxzltj> querybzzl(HashMap<String, Object> map) {
		return mapper.querybzzl(map);
	}

}
