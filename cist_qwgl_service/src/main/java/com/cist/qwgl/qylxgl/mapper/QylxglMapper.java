package com.cist.qwgl.qylxgl.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.qwgl.qylxgl.model.QWGL_QYLX_TYPE;

public interface QylxglMapper {
	public List<QWGL_QYLX_TYPE> queryqylx(HashMap<String,Object> map);
	public Integer addqylx(HashMap<String,Object> map);
	public Integer updateqylx(HashMap<String,Object> map);
	public Integer deleteqylx(HashMap<String,Object> map);
	public Integer querymaxpk();
}
