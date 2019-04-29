package com.cist.statistics.miandata.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.cist.frame.page.PageInfo;
import com.cist.statistics.miandata.model.DataUpload;

@Service(value="DataUploadServiceImpl")
public interface DataUploadService {
	Object querypageList(HashMap<String, Object> map,PageInfo info);
	
	List<DataUpload> queryUpload(Map<String, Object> map);
	
	List<DataUpload> selectExcel(Map<String, Object> map);
}
