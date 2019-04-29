package com.cist.quarters.mapper;
import java.util.HashMap;
import java.util.List;

import com.cist.quarters.model.Depart_info;
import com.cist.quarters.model.Zdcl_car_info;

public interface QuartersMapper {
   /**部门树*/
   public List<Depart_info> depart_infolist(Integer dept_superior);
   public List<Zdcl_car_info> pageListZdclcarinfo(HashMap<String, Object> map);
   
}
