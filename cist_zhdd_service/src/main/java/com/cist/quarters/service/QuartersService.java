package com.cist.quarters.service;

import java.util.HashMap;
import java.util.List;

import com.cist.quarters.model.Depart_info;
import com.cist.quarters.model.Functionconf;
import com.cist.quarters.model.Functiontype;
import com.cist.quarters.model.Postglinfo;
import com.cist.quarters.model.Postinfo;


public interface QuartersService {
	  public List<Functiontype> functiontypeList();
	   public List<Functionconf> fssunctionconf(HashMap<String,Object> map);
	   /**添加岗位信息*/
	   public Integer addPostinfo(Postinfo postinfo);
	   /**添加岗位管理信息*/
	   public Integer addPostglinfo(List<HashMap<String,Object>> list);
	   public List<Postinfo> querylistpageList(HashMap<String,Object> map); 
	   public List<Depart_info> depart_infolist(Integer dept_superior);
	   /**删除岗位信息*/
	   public Integer delpostinfo(HashMap<String,Object> map); 
	   public Integer delpostinfogl(HashMap<String,Object> map);
	   /**更新默认岗位*/
	   public Integer updatemo();
	   /**编辑岗位信息*/
	   public Integer updatePostinfo(Postinfo postinfo);
	   /**编辑岗位管理信息*/
	   public Integer updatePostglinfo(List<HashMap<String,Object>> list);
	   /**获取岗位信息的岗位关联配置*/
	   public List<Postglinfo> selectPostglinfo(HashMap<String,Object> map);
}
