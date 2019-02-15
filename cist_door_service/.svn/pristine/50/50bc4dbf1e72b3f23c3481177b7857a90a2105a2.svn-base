package com.cist.logquery.callinterface.service;
import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.logquery.callinterface.model.CallType;
public interface CallService {
	/**
	 * 查询所有的接口信息
	 * @param map
	 * @return
	 */
    Object selecteAllpageList(HashMap<String,Object> map,PageInfo page);
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
