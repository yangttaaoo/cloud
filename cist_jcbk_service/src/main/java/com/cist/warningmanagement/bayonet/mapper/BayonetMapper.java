package com.cist.warningmanagement.bayonet.mapper;

import java.util.HashMap;
import java.util.List;
import com.cist.warningmanagement.bayonet.model.DeptInfo;
import com.cist.warningmanagement.bayonet.model.Qy_Bm;
import com.cist.warningmanagement.bayonet.model.Qylx;
import com.cist.warningmanagement.controlcar.model.Kklx;
import com.cist.warningmanagement.bayonet.model.Bayonet;

public interface BayonetMapper {
	
  public  List<Bayonet>  selectAll(HashMap<String,Object> map);
  public  Integer deleteDada(HashMap<String,Object> map);
  public  Integer updateDada(HashMap<String,Object> map);
  public  Integer insertDada(HashMap<String,Object> map);
  public Integer deleteAll(String[] pk);
  List<DeptInfo> depart_infolist(Integer dept_superior);
  public Kklx selectKkxx(HashMap<String, Object> map);
  public List<Qylx> selectQylx();
  //增加区域
  public Integer insertQy(HashMap<String, Object> map);
  //增加单位
  public Integer insertDept(HashMap<String, Object> map);
  
  public List<Qy_Bm> selectQy(HashMap<String, Object> map);
  public List<Qy_Bm> selectDept(HashMap<String, Object> map);
  public  Integer deleteQy(HashMap<String,Object> map);
  public  Integer deleteDept(HashMap<String,Object> map);
  //查询布控区域是否重复
  Integer selectQyRepet (HashMap<String, Object> map);
  //查询部门是否重复
  Integer selectDepatRepet (HashMap<String, Object> map);
 
}
