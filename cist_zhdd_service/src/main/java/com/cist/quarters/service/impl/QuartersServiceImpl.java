package com.cist.quarters.service.impl;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.quarters.mapper.QuartersMapper;
import com.cist.quarters.model.Depart_info;
import com.cist.quarters.model.Zdcl_car_info;
import com.cist.quarters.service.QuartersService;


@Service("quartersService")
public class QuartersServiceImpl implements QuartersService{
	
	@Autowired
	private QuartersMapper mapper;

	@Override
	public List<Depart_info> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public List<Zdcl_car_info> pageListZdclcarinfo(HashMap<String, Object> map) {
		return mapper.pageListZdclcarinfo(map);
	}

}
