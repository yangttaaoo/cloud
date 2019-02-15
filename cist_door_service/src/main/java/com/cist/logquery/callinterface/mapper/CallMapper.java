package com.cist.logquery.callinterface.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.logquery.callinterface.model.CallType;
import com.cist.logquery.callinterface.model.Interface;

public interface CallMapper {
	/**
	 * 查询所有的接口信息
	 * @param map
	 * @return
	 */
    List<Interface> selecteAll(HashMap<String,Object> map);
    /**
     * 删除所有
     * @param pk
     * @return
     */
	Integer deleteAll(String[] pk);
    /**
     * 删除单个
     * @param te
     * @return
     */
	Integer deleteOne(Integer te);
	/**
	 * 查询接口名称
	 * @return
	 */
	List<CallType> selecteType();
}
