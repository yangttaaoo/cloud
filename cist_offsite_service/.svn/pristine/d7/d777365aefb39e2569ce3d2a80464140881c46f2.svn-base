package com.cist.serviceconfig.unlimitedcar.mapper;

import java.util.HashMap;
import java.util.List;
import com.cist.serviceconfig.unlimitedcar.model.CarManage;
import com.cist.serviceconfig.unlimitedcar.model.Didels;
import com.cist.serviceconfig.unlimitedcar.model.NoLimited;

public interface UnlimitedCarMapper {
	/**
	 * 查询不限行车辆
	 */
    List<CarManage> selectNoCar(HashMap<String,Object> map);
    /**
     * 根据pk删除信息
     */
    Integer delectInfo( HashMap<String, Object> map);
    /**
     * 添加车辆信息
     */
    Integer insertInfo( HashMap<String, Object> map);
    /**
     * 根据号牌号码查询数据
     */
    Didels  selectById(HashMap<String, Object> map);
    /**
     * 根据id修改数据
     */
    Integer updateById(HashMap<String, Object> map);
    /**
     * 批量删除
     */
    Integer deleteAll(String[] pk);
    /**
     * 查导出数据
     */
    List<NoLimited> selectAll(HashMap<String, Object> map); 
}
