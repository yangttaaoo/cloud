package com.cist.illegalUpload.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.illegalUpload.domain.Tbloffeevdi;
import com.cist.illegalUpload.domain.Vehicle;

public interface IllegalUploadMapper {

    /**违法数据自动上传六合一获取上传标志，自动上传1关闭2启动*/
	public int automaticupload();
	/**获取基础信息*/
	public String getfctcode(HashMap<String,Object> map);
	/**13-上传队列*/
	public int updateOffzt(List<Tbloffeevdi> list);
	/**获取违法数据，自动上传六合一*/
	public List<Tbloffeevdi> queryAutoOffeInfo();
	/**更新上传结果*/
	public int updateOffEdv(Tbloffeevdi tbl);
	/***
	 * 查询车架管接口方式
	 * @return
	 */
	public int cjgjkfs();
	/***
	 * 查询数据库车架管信息
	 * @param map
	 * @return
	 */
	public Vehicle vehicledate(HashMap<String,String> map);
	public Tbloffeevdi checkOffedvi(Map<String,Object> map);
	public int updateOffEdv1(Tbloffeevdi tbl);
}