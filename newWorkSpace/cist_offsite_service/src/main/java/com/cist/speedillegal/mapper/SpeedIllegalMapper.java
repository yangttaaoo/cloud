package com.cist.speedillegal.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.speedillegal.model.Speed_Illegal_Code;
import com.cist.speedillegal.model.TBL_OFFE_SPEED_INFO;
public interface SpeedIllegalMapper {
	List<TBL_OFFE_SPEED_INFO> queryspeed();
	Integer updatespeed(HashMap<String, Object> map);
}
