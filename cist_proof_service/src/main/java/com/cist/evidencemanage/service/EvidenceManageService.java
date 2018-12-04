package com.cist.evidencemanage.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cist.evidencemanage.model.C_road_item;
import com.cist.evidencemanage.model.DeptInfo;
import com.cist.evidencemanage.model.JcsjDevice;
import com.cist.evidencemanage.model.Sys_frm_code;
import com.cist.evidencemanage.model.ZjjhEvidenceAttachment;
import com.cist.evidencemanage.model.ZjjhEvidenceInfo;
import com.cist.frame.page.PageInfo;


public interface EvidenceManageService {
	
	 /***
	    * 新增证据信息
	    * @param HashMap<String,Object>
	    * @return Integer
	    */
	Integer save(HashMap<String,Object> map,List<MultipartFile> files,List<MultipartFile> vifiles);
	
	 /***
	    * 条件查询
	    * @param HashMap<String,Object>,PageInfo
	    * @return Object
	    */
	Object listpageList(HashMap<String,Object> map,PageInfo pinfo); 
	
	 /***
	    * 基础信息查询
	    * @param String
	    * @return List<Sys_frm_code>
	    */
	List<Sys_frm_code> selectFrmCode(String fct_code);
	
	 /***
	    * 管理部门查询
	    * @param Integer
	    * @return List<DeptInfo>
	    */
	List<DeptInfo> depart_infolist(Integer dept_superior);
	
	 /***
	    * 新增附件信息
	    * @param HashMap<String,Object>
	    * @return Integer
	    */
	Integer insertAttachment(HashMap<String,Object> map);
	
	 /***
	    * 道路树查询
	    * @param HashMap<String,Object>
	    * @return List<C_road_item>
	    */
	List<C_road_item> selectRoad(HashMap<String,Object> map);
	
	 /***
	    * 设备查询
	    * @param HashMap<String,Object>
	    * @return List<C_road_item>
	    */
	List<C_road_item> selectDev(HashMap<String,Object> map);
	
	 /***
	    * 更新归档和正常状态
	    * @param HashMap<String,Object>
	    * @return Integer
	    */
	Integer update(HashMap<String,Object> map);
	
	 /***
	    * 查询附件信息
	    * @param HashMap<String,Object>
	    * @return List<ZjjhEvidenceAttachment>
	    */
	List<ZjjhEvidenceAttachment> selectAttachment(HashMap<String,Object> map);
	
	 /***
	    * 下载信息新增
	    * @param HashMap<String,Object>
	    * @return Integer
	    */
	Integer insertDownload(HashMap<String,Object> map);
	
	 /***
	    * 下载附件列表新增
	    * @param HashMap<String,Object>
	    * @return Integer
	    */
	Integer insertDownloadList(HashMap<String,Object> map);
	
	 /***
	    * 查询附件提取密码
	    * @param HashMap<String,Object>
	    * @return List<ZjjhEvidenceInfo>
	    */
	List<ZjjhEvidenceInfo> selectPsw(HashMap<String,Object> map);
	
	 /***
	    * 更新证据信息
	    * @param HashMap<String,Object>
	    * @return Integer
	    */
	Integer updateAll(HashMap<String,Object> map,List<MultipartFile> files,List<MultipartFile> vifiles);
	
	 /***
	    * 删除附件信息
	    * @param HashMap<String,Object>
	    * @return Integer
	    */
	Integer deleteAttachment(HashMap<String,Object> map);
	
}
