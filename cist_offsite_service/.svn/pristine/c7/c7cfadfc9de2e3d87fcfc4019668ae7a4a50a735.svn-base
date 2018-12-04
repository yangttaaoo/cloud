package com.cist.speedillegal.service.impl;

import java.util.HashMap;
import java.util.List;

import com.cist.speedillegal.mapper.SpeedIllegalmapper;
import com.cist.speedillegal.model.Speed_Illegal_Code;
import com.cist.speedillegal.model.TBL_OFFE_SPEED_INFO;
import com.cist.speedillegal.service.SpeedIllegalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SpeedIllegalServiceImpl implements SpeedIllegalService {
	
	@Autowired
	private SpeedIllegalmapper mapper;

	@Override
	public List<TBL_OFFE_SPEED_INFO> queryspeed() {
		return mapper.queryspeed();
	}
	@Override
	public Integer updatespeed(HashMap<String, Object> map) {
		return mapper.updatespeed(map);
	}
	
	
	
	
}
