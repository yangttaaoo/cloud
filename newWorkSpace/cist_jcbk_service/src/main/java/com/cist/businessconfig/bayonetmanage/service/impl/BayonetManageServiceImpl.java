package com.cist.businessconfig.bayonetmanage.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.businessconfig.bayonetmanage.mapper.BayonetManageMapper;
import com.cist.businessconfig.bayonetmanage.model.BayonetTree;
import com.cist.businessconfig.bayonetmanage.model.DeptInfo;
import com.cist.businessconfig.bayonetmanage.model.DeviceBayonetLane;
import com.cist.businessconfig.bayonetmanage.model.Jcbk_bayonet_units;
import com.cist.businessconfig.bayonetmanage.model.Jcbk_control_bayonet;
import com.cist.businessconfig.bayonetmanage.model.Jcsj_device;
import com.cist.businessconfig.bayonetmanage.model.Jcsj_device_bayonet_param;
import com.cist.businessconfig.bayonetmanage.model.NzTreeNode;
import com.cist.businessconfig.bayonetmanage.service.BayonetManageService;
import com.cist.frame.page.PageInfo;

@Service
public class BayonetManageServiceImpl implements BayonetManageService {

	@Autowired
	private BayonetManageMapper mapper;

	@Override
	public List<NzTreeNode> getDeptNode() {
		return mapper.getDeptNode();
	}

	@Override
	public List<NzTreeNode> getBayonetNode(String deptId) {
		return mapper.getBayonetNode(deptId);
	}

	@Override
	public List<BayonetTree> getNatureNode(String deviceid) {
		return mapper.getNatureNode(deviceid);
	}

	@Override
	public Jcsj_device querydevicebypkid(HashMap<String, Object> map) {
		return mapper.querydevicebypkid(map);
	}

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public Jcsj_device_bayonet_param querykkinfo(String device_id) {
		return mapper.querykkinfo(device_id);
	}

	@Override
	public Object querybayonetinfopageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.querybayonetinfo(map);
	}

	@Override
	public List<Jcbk_control_bayonet> querybayonetinfo(HashMap<String, Object> map) {
		return mapper.querybayonetinfo(map);
	}

	@Override
	public Integer addcarbayonet(HashMap<String, Object> map) {
		return mapper.addcarbayonet(map);
	}

	@Override
	public Integer addbayonetunits(HashMap<String, Object> map) {
		return mapper.addbayonetunits(map);
	}

	@Override
	public Jcbk_control_bayonet isshow(HashMap<String, Object> map) {
		return mapper.isshow(map);
	}

	@Override
	public List<Jcbk_bayonet_units> querybayonetunitsinfo(HashMap<String, Object> map) {
		return mapper.querybayonetunitsinfo(map);
	}

	@Override
	public Integer delJcbk_control_bayonet(HashMap<String, Object> map) {
		return mapper.delJcbk_control_bayonet(map);
	}

	@Override
	public Integer delJcbk_bayonet_units(HashMap<String, Object> map) {
		return mapper.delJcbk_bayonet_units(map);
	}

	@Override
	public Integer updatebayonet(HashMap<String, Object> map) {
		return mapper.updatebayonet(map);
	}

	@Override
	public int addBayonetArea(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.addBayonetArea(paramMap);
	}

	@Override
	public int addBayonetDev(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.addBayonetDev(paramMap);
	}

	@Override
	public int delBayonetArea(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.delBayonetArea(paramMap);
	}

	@Override
	public int delBayonetDev(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.delBayonetDev(paramMap);
	}

	@Override
	public List<DeviceBayonetLane> queryBayonetLane(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.queryBayonetLane(paramMap);
	}

	@Override
	public List<String> queryBayonetLaneConnectDev(DeviceBayonetLane bayonetLane) {
		// TODO Auto-generated method stub
		return mapper.queryBayonetLaneConnectDev(bayonetLane);
	}

	@Override
	public String queryBayonetDirection(HashMap<String, Object> paramMap) {
		String connectDevDirection = "";
		List<DeviceBayonetLane> bayonetLaneList = this.queryBayonetLane(paramMap);
		if (bayonetLaneList.size() > 0) {
			List<String> connectDev = this.queryBayonetLaneConnectDev(bayonetLaneList.get(0));
			if (connectDev.size() > 0) {
				connectDevDirection = connectDev.get(0);
			}
		}
		return connectDevDirection;
	}

	@Override
	public NzTreeNode setBayonetDirectionNode(Jcsj_device_bayonet_param bayonetParam, NzTreeNode bayonet,
			String directionType) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		NzTreeNode bayonetDirection = new NzTreeNode();
		map1.put("deviceid", bayonetParam.getDevice_id());
		map1.put("fxlx", directionType);
		if (this.isshow(map1) == null) {
			bayonetDirection.setKey(bayonetParam.getDevice_id() + "-" + directionType);
			String fxbm = "";
			if ("1".equals(directionType))// 上行
				fxbm = null == bayonetParam.getSxfxbm() ? "-上行(未知)" : "-上行(" + bayonetParam.getXxfxbm() + ")";
			if ("2".equals(directionType))// 下行
				fxbm = null == bayonetParam.getXxfxbm() ? "-下行(未知)" : "-下行(" + bayonetParam.getXxfxbm() + ")";
			bayonetDirection.setTitle(bayonet.getTitle() + fxbm);
			bayonetDirection.setSelectable(true);
			bayonetDirection.setIsLeaf(true);
			bayonetDirection.setRoad_name(bayonet.getRoad_name());
			bayonetDirection.setDevice_num(bayonet.getDevice_num());
			bayonetDirection.setLongitude(bayonet.getLongitude());
			bayonetDirection.setLatitude(bayonet.getLatitude());
			bayonetDirection.setFk_dept_id(bayonet.getFk_dept_id());
			bayonetDirection.setBayonet_name(bayonet.getDevice_name());
		}else {
			return null;
		}
		return bayonetDirection;
	}

}
