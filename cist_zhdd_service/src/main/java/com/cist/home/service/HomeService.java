package com.cist.home.service;

import java.util.HashMap;
import java.util.List;

import com.cist.home.model.DeviceInfo;
import com.cist.home.model.EventFlowInfo;
import com.cist.home.model.EventInfo;
import com.cist.home.model.GpsRecord;
import com.cist.home.model.Jcsj_police_res_person;
import com.cist.home.model.Jcsj_police_resources;
import com.cist.home.model.Sysfrmcode;
import com.cist.home.model.Tbl_car_reco;
import com.cist.home.model.Zhdd_event_acceptance;
import com.cist.home.model.Zhdd_event_attachment;
import com.cist.home.model.Zhdd_event_personnel;
import com.cist.home.model.Zhdd_event_result;
import com.cist.home.model.Zhdd_sms_template;
import com.cist.home.model.Zhdd_work_flow;

public interface HomeService {
	List<DeviceInfo> DeviceList();
	List<EventInfo> EventList(HashMap<String, Object> map);
	Jcsj_police_res_person PoliceList(HashMap<String, Object> map);
	List<EventInfo> EventPoliceList(HashMap<String, Object> map);
	EventInfo EventFlowList(HashMap<String, Object> map);
	List<EventFlowInfo> EventResultList(HashMap<String, Object> map);
	List<GpsRecord> gpsRecordList(HashMap<String, Object> map);
	public Integer addzhddeventacceptance(HashMap<String, Object> map);
	public Integer updatezhddeventinformation(HashMap<String, Object> map);
	public List<Jcsj_police_res_person> jcsj_police_res_personpageliist(HashMap<String, Object> map);
	public List<Zhdd_work_flow> zhdd_work_flow(HashMap<String, Object> map);
	public List<Zhdd_sms_template> zhdd_sms_template(HashMap<String, Object> map);
	public Integer addzhddeventdispatch(HashMap<String, Object> map);
	public Integer addzhdd_event_personnel(List<Zhdd_event_personnel> policList);
	public Integer updatezhddeventinf(HashMap<String, Object> map);
	public Zhdd_event_acceptance shhoulixishij(HashMap<String, Object> map);
	public List<Zhdd_event_acceptance> shhoulixi(HashMap<String, Object> map);
	public Zhdd_event_result eventresult(HashMap<String, Object> map);
	public Jcsj_police_resources jcsjpolice_resperson(HashMap<String, Object> map);
	public Jcsj_police_res_person Jcsjpoliceresperson(HashMap<String, Object> map);
	public Tbl_car_reco tbl_car_reco(HashMap<String, Object> map);
	public List<EventFlowInfo> eventflowinfolist(HashMap<String, Object> map);
	public Integer updatejwd(HashMap<String, Object> map);
	/***
	 * 出警
	 * @param map
	 * @return
	 */
	List<EventInfo> EventListchu(HashMap<String, Object> map);
	/***
	 * 处警
	 * @param map
	 * @return
	 */
	List<EventInfo> EventListchuu(HashMap<String, Object> map);
	/***
	 * 全部
	 * @param map
	 * @return
	 */
	List<EventInfo> EventListquan(HashMap<String, Object> map);
	/***
	 * 正在处理事件的警员
	 * @param map
	 * @return
	 */
	List<String> zzclsjjy(HashMap<String, Object> map);
	/***
	 * 正在处理事件的警员 事件iD
	 * @param map
	 * @return
	 */
	Integer shijianid(HashMap<String, Object> map);
	/***
	 * 根据警员编号查询事件
	 * @param map
	 * @return
	 */
	EventInfo eventinfojy(HashMap<String, Object> map);
	/***
	 * 反馈
	 * @param map
	 * @return
	 */
	EventFlowInfo eventflowinfov(HashMap<String, Object> map);
	/***
	 * 结果
	 * @param map
	 * @return
	 */
	Zhdd_event_result zhdd_event_resultjieguo(HashMap<String, Object> map);
	/***
	 * 下发事件
	 * @param map
	 * @return
	 */
	List<Integer> xiafashijian(HashMap<String, Object> map);
	/**
	 * 上级部门pk
	 * @param map
	 * @return
	 */
	List<Integer> shangjibumenpk(HashMap<String, Object> map);
	/**
	 * 获取事件信息
	 * @param map
	 * @return
	 */
	EventInfo acceptance(HashMap<String, Object> map);
	/**
	 * 获取基础信息
	 * @param map
	 * @return
	 */
	List<Sysfrmcode>  sysfrmcode(HashMap<String, Object> map);
	/***
	 * 添加流程
	 * @param e
	 * @return
	 */
	Integer addEventFlowInfo(EventFlowInfo e);
	/***
	 * 编辑浏览
	 * @param e
	 * @return
	 */
	Integer updateEventFlowInfo(EventFlowInfo e);
	/***
	 * 编辑浏览
	 * @param e
	 * @return
	 */
	Integer addattachment(Zhdd_event_attachment e);
	/***
	 * 查询当前事件的图片
	 * @param e
	 * @return
	 */
	List<Zhdd_event_attachment> selectattachment(HashMap<String, Object> map);
	/***
	 * 查询当前事件的音频
	 * @param e
	 * @return
	 */
	Zhdd_event_attachment selectyinpin(HashMap<String, Object> map);
	/***
	 * 删除附件
	 * @param e
	 * @return
	 */
	int delattachment(HashMap<String, Object> map);
	/***
	 * 编辑处置结果
	 * @param e
	 * @return
	 */
	Integer updatezhddeventresult(Zhdd_event_result e);
	/***
	 * 新增处置结果
	 * @param e
	 * @return
	 */
	Integer addzhddeventresult(Zhdd_event_result e);
	/***
	 * 当前事件返回结果更新当前事件的状态   
	 * @param e
	 * @return
	 */
	Integer updateinformation(HashMap<String, Object> map);
}
