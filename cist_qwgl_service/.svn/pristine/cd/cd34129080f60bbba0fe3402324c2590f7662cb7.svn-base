package com.cist.khpd.rules.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.khpd.rules.model.Rule;
import com.cist.khpd.rules.model.RuleMannage;
public interface RuleService {
	/**
	 * 查询所有的数据
	 * @param map
	 * @return
	 */
   Object seleteDatapageList(HashMap<String,Object> map,PageInfo page);
   /**
    * 增加数据
    */
   Integer addData(HashMap<String,Object> map);
   /**
    * 删除数据
    */
   Integer deleteData(HashMap<String,Object>  pk);
   /**
    * 更新数据
    */
   Integer updateData(HashMap<String,Object> map);
   /**
    * 查询栏目名称
    */
   List<Rule> selecteLmmc();
   
   
   List<RuleMannage>  selecteDatas(HashMap<String,Object> map);
   /**
    * 增加栏目数据
    */
   Integer addBanner(HashMap<String,Object> map);
}
