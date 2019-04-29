package com.cist.businessconfig.bayonetmanage.service;

import java.util.HashMap;
import java.util.List;

import com.cist.businessconfig.bayonetmanage.model.BayonetTree;
import com.cist.businessconfig.bayonetmanage.model.DeptInfo;
import com.cist.businessconfig.bayonetmanage.model.DeviceBayonetLane;
import com.cist.businessconfig.bayonetmanage.model.Jcbk_bayonet_units;
import com.cist.businessconfig.bayonetmanage.model.Jcbk_control_bayonet;
import com.cist.businessconfig.bayonetmanage.model.Jcsj_device;
import com.cist.businessconfig.bayonetmanage.model.Jcsj_device_bayonet_param;
import com.cist.businessconfig.bayonetmanage.model.NzTreeNode;
import com.cist.frame.page.PageInfo;

public interface BayonetManageService {

	/**
	 * 查询单位
	 * @return
	 */
	public List<NzTreeNode> getDeptNode();
	/**
	 * 查询卡口
	 * @param map
	 * @return
	 */
	public List<NzTreeNode> getBayonetNode(String deptId);
	/**
	 * 查询卡口性质
	 * @param map
	 * @return
	 */
	public List<BayonetTree> getNatureNode(String deviceid);
	
	/**
	 * 初始化视频监控的Tree
	 * 
	 * @return
	 * @throws Exception
	 *//*
	public String initTree() throws Exception;*/
	/**
	 * 根据pk_id查询设备信息
	 * @param pk_id
	 * @return
	 */
	public Jcsj_device querydevicebypkid(HashMap<String,Object> map);
	/**
	 * 管理单位树
	 * @param dept_superior
	 * @return
	 */
	public List<DeptInfo> depart_infolist(Integer dept_superior);
	
	/**
	 * 根据设备id查询卡口参数
	 * @param deviceid
	 * @return
	 */
	public Jcsj_device_bayonet_param querykkinfo(String device_id);
	/**
	 * 查询车辆布控卡口表(分页查询)
	 * @param map
	 * @return
	 */
	public Object querybayonetinfopageList(HashMap<String,Object> map,PageInfo info);
	/**
	 * 查询车辆布控卡口表
	 * @param map
	 * @return
	 */
	public List<Jcbk_control_bayonet> querybayonetinfo(HashMap<String,Object> map);
	/**
	 * 添加车辆布控卡口信息
	 * @param map
	 * @return
	 */
	public Integer addcarbayonet(HashMap<String,Object> map);
	/**
	 * 添加布控卡口拦截单位
	 * @param map
	 * @return
	 */
	public Integer addbayonetunits(HashMap<String,Object> map);
	/**
	 * 根据卡口编号、方向类型查询是否存在
	 * @param map
	 * @return
	 */
	public Jcbk_control_bayonet isshow(HashMap<String,Object> map);
	/**
	 * 根据卡口编号和车辆布控卡口信息id查询布控卡口拦截单位信息
	 * @param map
	 * @return
	 */
	public List<Jcbk_bayonet_units> querybayonetunitsinfo(HashMap<String,Object> map);
	/**
	 * 根据pk删除车辆布控卡口信息
	 * @param map
	 * @return
	 */
	public Integer delJcbk_control_bayonet(HashMap<String,Object> map);
	/**
	 * 根据布控卡口信息删除布控卡口拦截单位
	 * @param map
	 * @return
	 */
	public Integer delJcbk_bayonet_units(HashMap<String,Object> map);
	/**
	 * 更新车辆布控卡口信息
	 * @param map
	 * @return
	 */
	public Integer updatebayonet(HashMap<String,Object> map);
	/**
	 * 批量插入与布控卡口关联的拦截区域
	 * @param paramMap
	 * @return
	 */
	public int addBayonetArea(HashMap<String,Object> paramMap);
	/**
	 * 批量插入与布控卡口关联的设备
	 * @param paramMap
	 * @return
	 */
	public int addBayonetDev(HashMap<String,Object> paramMap);
	/**
	 * 删除与布控卡口关联的拦截区域
	 * @param paramMap
	 * @return
	 */
	public int delBayonetArea(HashMap<String,Object> paramMap);
	/**
	 * 删除与布控卡口关联的设备
	 * @param paramMap
	 * @return
	 */
	public int delBayonetDev(HashMap<String,Object> paramMap);
	/**
	 * 查询卡口车道信息
	 * @param paramMap
	 * @return
	 */
	public List<DeviceBayonetLane> queryBayonetLane(HashMap<String,Object> paramMap);
	/**
	 * 查询卡口某车道关联设备方向
	 * @param paramMap
	 * @return
	 */
	public List<String> queryBayonetLaneConnectDev(DeviceBayonetLane bayonetLane);
	public String queryBayonetDirection(HashMap<String,Object> paramMap);
	public NzTreeNode setBayonetDirectionNode(Jcsj_device_bayonet_param kkinfo,NzTreeNode bayonet,String directionType);
}
