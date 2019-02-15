package com.cist.smsmodule.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.smsmodule.modle.DeptInfo;
import com.cist.smsmodule.modle.Smsmodle;
import com.cist.smsmodule.modle.Sys_frm_code;

public interface SmsMapper {
  //查询所有的数据
  List<Smsmodle> selectData(HashMap<String,Object> map);
  //增加数据
  Integer addData(HashMap<String,Object> map);
  //修改数据
  Integer updateData(HashMap<String,Object> map);
  //删除数据
  Integer deleteDate(HashMap<String,Object> map);
  //部门
  List<DeptInfo> depart_infolist(Integer dept_superior);
  //查询可选项
  List<Sys_frm_code> selectKxx(HashMap<String,Object> map);
  //根据单位pk查询单位名称
  String queryDeptnameBydeptpk(HashMap<String,Object> map);
  //根据创建人code查询创建人名称
  String querypepolenamebycode(HashMap<String,Object> map);
  //批量删除
  Integer batchdel(HashMap<String,Object> map);
}
