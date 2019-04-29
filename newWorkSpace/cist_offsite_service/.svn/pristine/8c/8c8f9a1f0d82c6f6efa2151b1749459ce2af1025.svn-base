package com.cist.serviceconfig.unlimitedcar.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.serviceconfig.unlimitedcar.model.Didels;
import com.cist.serviceconfig.unlimitedcar.model.NoLimited;

public interface UnlimitedService {
	/**
	 * 查询不限行车辆
	 */
   Object selectNoCarpageList(HashMap<String,Object> map,PageInfo page);
    /**
     * 根据pk删除信息
     */
   Integer delectInfo(HashMap<String, Object> map);
    /**
     * 添加车辆信息
     */
   Integer insertInfo(HashMap<String, Object> map);
    /**
     * 根据号牌号牌查询数据详情
     */
   Didels  selectById( HashMap<String, Object> map);
    /**
     * 根据id修改数据
     */
    Integer  updateById(HashMap<String, Object> map);
    /**
     * 批量删除
     */
    Integer deleteAll(String[] pk);
    
    List<NoLimited> selectAll(HashMap<String, Object> map);
}
