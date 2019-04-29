package com.cist.khpdlmgl.mapper;

import java.util.HashMap;
import java.util.List;
import com.cist.khpdlmgl.model.LmglTarget;

public interface LmglMapper {
	/**
	 * 查询所有的数据
	 * @param page
	 * @return
	 */
   public List<LmglTarget>  selectData(HashMap<String,Object> map); 
   /**
    * 添加数据
    * @param map
    * @return
    */
   public Integer addData(HashMap<String,Object> map);
   /**
    * 更新数据
    * @param map
    * @return
    */
   public Integer updateData(HashMap<String,Object> map);
   /**
    * 删除数据
    * @param map
    * @return
    */
   public Integer deleteData(String[] pk);
   
   Integer deletOneData(HashMap<String, Object> map);
}
