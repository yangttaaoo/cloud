package com.cist.qwkhgrfb.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.qwkhgrfb.model.Publish;
import com.cist.qwkhgrfb.model.Qw_Check_Pub;

public interface PublishMapper {
	/**
	 * 查询个人发布信息
	 * @param map
	 * @return
	 */
  public List<Qw_Check_Pub> selectData(HashMap<String,Object> map);
  
  public List<Publish> downloadList(HashMap<String, Object> map);
}
