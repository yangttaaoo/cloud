package com.cist.illegalUpload.service;

import java.util.HashMap;
import java.util.List;

import com.cist.illegalUpload.domain.Tbloffeevdi;

public interface IllegalUploadService {

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
}
