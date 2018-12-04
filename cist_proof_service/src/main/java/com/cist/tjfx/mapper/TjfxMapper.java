package com.cist.tjfx.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.tjfx.model.EvidenceTj;
import com.cist.tjfx.model.Myxzltj;

public interface TjfxMapper {

	public Integer queryevidencenum(HashMap<String,Object> map);
	
	public Integer querybyxz(HashMap<String,Object> map);
	
	public List<Myxzltj> querymyxzl(HashMap<String,Object> map);
	
	public List<EvidenceTj> querynumbydept(HashMap<String,Object> map);
	
	public List<EvidenceTj> querytjbyzjlx(HashMap<String,Object> map);
	
	public List<EvidenceTj> querytjbysalx(HashMap<String,Object> map);
	
	public List<Myxzltj> querybzzl(HashMap<String,Object> map);
}
