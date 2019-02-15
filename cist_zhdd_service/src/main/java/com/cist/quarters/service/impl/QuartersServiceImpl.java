package com.cist.quarters.service.impl;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.quarters.mapper.QuartersMapper;
import com.cist.quarters.model.Depart_info;
import com.cist.quarters.model.Functionconf;
import com.cist.quarters.model.Functiontype;
import com.cist.quarters.model.Postglinfo;
import com.cist.quarters.model.Postinfo;
import com.cist.quarters.service.QuartersService;


@Service("quartersService")
public class QuartersServiceImpl implements QuartersService{
	
	@Autowired
	private QuartersMapper mapper;

	@Override
	public List<Functiontype> functiontypeList() {
		
		return mapper.functiontypeList();
	}

	@Override
	public List<Functionconf> fssunctionconf(HashMap<String, Object> map) {
		
		return mapper.fssunctionconf(map);
	}

	@Override
	public Integer addPostinfo(Postinfo postinfo) {
		return mapper.addPostinfo(postinfo);
	}

	@Override
	public Integer addPostglinfo(List<HashMap<String,Object>> list) {
		return mapper.addPostglinfo(list);
	}

	@Override
	public List<Postinfo> querylistpageList(HashMap<String, Object> map) {
		return mapper.querylistpageList(map);
	}

	@Override
	public List<Depart_info> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public Integer delpostinfo(HashMap<String, Object> map) {
		return mapper.delpostinfo(map);
	}

	@Override
	public Integer delpostinfogl(HashMap<String, Object> map) {
		return mapper.delpostinfogl(map);
	}

	@Override
	public Integer updatemo() {
		return mapper.updatemo();
	}

	@Override
	public Integer updatePostinfo(Postinfo postinfo) {
		return mapper.updatePostinfo(postinfo);
	}

	@Override
	public Integer updatePostglinfo(List<HashMap<String, Object>> list) {
		return mapper.updatePostglinfo(list);
	}

	@Override
	public List<Postglinfo> selectPostglinfo(HashMap<String, Object> map) {
		return mapper.selectPostglinfo(map);
	}

}
