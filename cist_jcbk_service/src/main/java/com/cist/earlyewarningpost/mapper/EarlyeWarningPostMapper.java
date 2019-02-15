package com.cist.earlyewarningpost.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.earlyewarningpost.model.Depart_info;
import com.cist.earlyewarningpost.model.GpsRecord;
import com.cist.earlyewarningpost.model.JcbkBayonetUnits;
import com.cist.earlyewarningpost.model.JcbkControlBayonet;
import com.cist.earlyewarningpost.model.JcbkWarningAcceptance;
import com.cist.earlyewarningpost.model.JcbkWarningAttachment;
import com.cist.earlyewarningpost.model.JcbkWarningDispatch;
import com.cist.earlyewarningpost.model.JcbkWarningDocument;
import com.cist.earlyewarningpost.model.JcbkWarningFeedBack;
import com.cist.earlyewarningpost.model.JcbkWarningResult;
import com.cist.earlyewarningpost.model.JcbkWarningVehicle;
import com.cist.earlyewarningpost.model.Jcsj_police_res_person;
import com.cist.earlyewarningpost.model.Jcsj_police_resources;
import com.cist.earlyewarningpost.model.Qw_report;
import com.cist.earlyewarningpost.model.SysDepartInfo;
import com.cist.earlyewarningpost.model.Sys_frm_code;
import com.cist.earlyewarningpost.model.TblCarRecoInfo;
import com.cist.frame.page.PageInfo;

public interface EarlyeWarningPostMapper {

	/**
	 * 查询預警信息
	 * 
	 * @return List<JcbkWarningVehicle>
	 */
	List<JcbkWarningVehicle> list(HashMap<String,Object> map);
	
	/**
	 * 查询預警信息 已受理
	 * 
	 * @return List<JcbkWarningVehicle>
	 */
	List<JcbkWarningVehicle> selectYsl(HashMap<String,Object> map);
	
	/**
	 * 查询人员警车
	 * 
	 * @return List<JcbkWarningVehicle>
	 */
	List<GpsRecord> gpsRecordList(HashMap<String, Object> map);
	
	/**
	 * 布控卡扣
	 * 
	 * @return List<JcbkControlBayonet>
	 */
	List<JcbkControlBayonet> DeviceList();
	
	public Jcsj_police_res_person Jcsjpoliceresperson(HashMap<String, Object> map);
	
	public Jcsj_police_resources jcsjpolice_resperson(HashMap<String, Object> map);
	
	//拦截单位区域
	List<SysDepartInfo>selectDeptArrea(HashMap<String, Object> map);
	
	public List<Depart_info> depart_infolist(Integer dept_superior);
	
	List<Jcsj_police_res_person> selectPoliceList(HashMap<String,Object> map); 
	List<JcbkWarningVehicle> selectList(HashMap<String,Object> map); 
	
	/**
	 * 基础数据查询
	 * 
	 * @return List<Sys_frm_code>
	 */
	List<Sys_frm_code> selectBaseData(String fct_code);
	
	/**
	 * 更新预警信息状态
	 * 
	 * @return List<Sys_frm_code>
	 */
	Integer update(HashMap<String, Object> map);
	
	/**
	 * 查询预警信息对用的拦截单位
	 * 
	 * @return List<JcbkBayonetUnits>
	 */
	List<JcbkBayonetUnits> selectLj(HashMap<String, Object> map);
	
	/**
	 * 受理信息插入
	 * 
	 * @return Integer
	 */
	Integer insertAccept(HashMap<String, Object> map);
	
	/**
	 * 调度信息插入
	 * 
	 * @return Integer
	 */
	Integer insertDispatch(HashMap<String, Object> map);
	
	/**
	 * 反馈附件插入
	 * 
	 * @return Integer
	 */
	Integer savePic(HashMap<String, Object> map);
	
	/**
	 * 反馈内容插入
	 * 
	 * @return Integer
	 */
	Integer insertFeedBack(HashMap<String, Object> map);
	
	/**
	 * 调度的处置人员信息插入
	 * 
	 * @return Integer
	 */
	Integer insertPersonnel(HashMap<String, Object> map);
	
	/**
	 * 受理信息查询
	 * 
	 * @return JcbkWarningAcceptance
	 */
 	JcbkWarningAcceptance selectAcceptance(HashMap<String, Object> map);
 	
	/**
	 * 处理结果信息插入
	 * 
	 * @return Integer
	 */
	Integer insertResult(HashMap<String, Object> map);
	
	/**
	 * 处理文书信息插入
	 * 
	 * @return Integer
	 */
	Integer insertDocument(HashMap<String, Object> map);
	
	/**
	 * 预警信息反馈内容查询
	 * 
	 * @return JcbkWarningFeedBack
	 */
 	JcbkWarningFeedBack selectFeedBack(HashMap<String, Object> map);
 	
 	/**
	 * 预警信息  调度信息查询
	 * 
	 * @return JcbkWarningFeedBack
	 */
 	JcbkWarningDispatch selectDispatch(HashMap<String, Object> map);
 	
 	/**
	 * 预警信息  反馈附件信息
	 * 
	 * @return JcbkWarningFeedBack
	 */
 	List<JcbkWarningAttachment>selectAttachment(HashMap<String, Object> map);
 	
 	/**
	 * 预警信息  删除附件信息
	 * 
	 * @return JcbkWarningFeedBack
	 */
 	Integer deletePic(HashMap<String, Object> map);
 	
 	/**
	 * 预警信息  处置结果信息
	 * 
	 * @return List<JcbkWarningResult>
	 */
 	List<JcbkWarningResult> selectResult(HashMap<String, Object> map);
 	
 	/**
	 * 预警信息  处置结果信息
	 * 
	 * @return List<JcbkWarningDocument>
	 */
 	List<JcbkWarningDocument> selectDocument(HashMap<String, Object> map);
 	
 	/**
	 * 预警信息 布控卡口信息
	 * 
	 * @return List<JcbkControlBayonet>
	 */
 	List<JcbkControlBayonet> selectBkkk(HashMap<String, Object> map);
 	
 	/**
	 * 预警信息 实时跟踪车辆信息查询
	 * 
	 * @return List<TblCarRecoInfo>
	 */
 	List<TblCarRecoInfo> selectTrajectory(HashMap<String, Object> map);
 	
 	/**
	 * 预警信息 根据部门查询警员信息
	 * 
	 * @return List<Jcsj_police_res_person>
	 */
 	List<Jcsj_police_res_person> selectPolice(HashMap<String, Object> map);
 	
 	/**
	 * 预警信息 查询部门的街面勤务报备关联人员信息
	 * 
	 * @return List<Qw_report>
	 */
 	List<Qw_report> selectQwbb(HashMap<String, Object> map);
}
