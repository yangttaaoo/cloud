package com.cist.qwgl.xqgl.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.qwgl.qylxgl.model.QWGL_QYLX_TYPE;
import com.cist.qwgl.xqgl.model.QWGL_QY_TYPE;
import com.cist.qwgl.xqgl.model.QWGL_XQGL_INFO;

public interface XqglMapper {
	public List<QWGL_XQGL_INFO> queryxq(HashMap<String,Object> map);
	public List<QWGL_QY_TYPE> queryqytype(HashMap<String,Object> map);
	public Integer addxqgl(HashMap<String,Object> map);
	public Integer updatexqgl(HashMap<String,Object> map);
	public Integer deletexqgl(HashMap<String,Object> map);
	public Integer querymaxpk();
	public String querydeptname(String dept_code);
	public List<QWGL_QYLX_TYPE> queryqylx(HashMap<String,Object> map);
}
