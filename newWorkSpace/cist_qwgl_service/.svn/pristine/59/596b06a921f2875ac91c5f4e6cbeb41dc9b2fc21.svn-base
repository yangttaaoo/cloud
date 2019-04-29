package com.cist.khpd.resultback.service;

import java.util.HashMap;

import com.cist.frame.page.PageInfo;
import com.cist.khpd.resultback.model.Police;

public interface ResultService {
	/**
	 * 查询所有的数据
	 * @param map
	 * @param page
	 * @return
	 */
   Object  selectDatapageList(HashMap<String,Object> map,PageInfo page);
   /**
    * 增加数据
    */ 
   Integer  addData(HashMap<String,Object> map);
   /**
    * 删除数据
    */
   Integer deleteData(HashMap<String,Object> map);
   /**
    * 修改数据
    */
   Integer updateData(HashMap<String,Object> map);
   /**
    * 回复
    * @param map
    * @return
    */
   Integer replyUser(HashMap<String,Object> map);
   /**
    * 增加个人数据
    */
   Integer addPersonData(HashMap<String,Object> map);
   /**
    * 查询警员名字
    * @param sypi_pk
    * @return
    */
   Police selectPerson(String sypi_pk);
}
