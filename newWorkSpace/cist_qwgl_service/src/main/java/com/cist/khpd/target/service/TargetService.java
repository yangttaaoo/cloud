package com.cist.khpd.target.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.khpd.rules.model.Rule;
import com.cist.khpd.target.model.Depart_info;
import com.cist.khpd.target.model.Police;
import com.cist.khpd.target.model.Target;
import com.cist.khpd.target.model.TargetMannage;

public interface TargetService {
	/**
	 * 查询所有
	 * @param map
	 * @return
	 */
   Object  selectAllpageList(HashMap<String,Object> map,PageInfo page);
   /**
    * 增加数据
    * @param map
    * @return
    */
   Integer  addData(HashMap<String,Object> map);
   
   /**
    * 删除数据
    * @param map
    * @return
    */
   Integer deleteData(HashMap<String,Object> pk);
   /**
    * 修改数据
    * @param map
    * @return
    */
   Integer updateData(HashMap<String,Object> pk);
   /**
    * 增加个人数据
    * @param map
    * @return
    */
   Integer  addPerson(HashMap<String,Object> map);
   /**
    * 查詢部門名称
    */
   List<Depart_info> selectDepart();
   /**
    * 跟据pk查詢警員
    */
   Depart_info  selectInfo(Integer pk);
   
   Integer deletePolice(HashMap<String,Object> map);
   /**
    * 查询部门栏目
    */
   List<Rule> selectDepat();
   /**
    * 查询个人栏目
    */
   List<Rule> selectPorson();
   /**
    * 查询警员信息
    * @param pk
    * @return
    */
   List<Police> selectPolice(Integer pk);
   /**
    * 查询警员名字
    * @param sypi_pk
    * @return
    */
   Target getSypiCodeName(String sypi_pk);
   /**
    * 查询负责人
    * @param sypi_pk
    * @return
    */
   Target getDeptCodeNameHead(String sypi_pk);
   Target getDeptName(String sypi_pk);
   
   List<Target> selectTestInfo(HashMap<String, Object> map);
   
   Integer selectDepatInfo(HashMap<String, Object> map);
   
   Integer selectDepatInfos(HashMap<String, Object> map);
   /**
    * 导出
    */
    List<TargetMannage> selectExcel(HashMap<String,Object> map);
}