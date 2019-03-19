package com.cist.devRegister.model;

import java.util.List;

import com.cist.utils.SysTempStoreUtils;

//5.2.卡口参数(JCSJ_DEVICE_BAYONET_PARAM)
public class DeviceBayonetParam {
	//设备ID
	private long device_id;
	//卡口类型（国界卡口、省际卡口、市际卡口、县际卡口、公路主线卡口、公路收费站卡口、城区道路卡口、城区路口卡口、移动卡口、其他卡口
	private char bayonet_type;
	//卡口性质（上行单向卡口、下行单向卡口、双向卡口）
	private char bayonet_nature;
	//上行方向别名
	private String sxfxbm;
	//进出类型（参考SYS_FRM_CODE表fct_code = R402）
	private String sxfxjclx;
	//下行方向别名
	private String xxfxbm;
	//进出类型（参考SYS_FRM_CODE表fct_code = R402）
	private String xxfxjclx;
	private List<DeviceBayonetLane>  cardRoad;
	
	
	
	
	
	
	
	public List<DeviceBayonetLane> getCardRoad() {
		return SysTempStoreUtils.getCardRoadInfobyDevId(this.device_id);
	}
	
	public long getDevice_id() {
		return device_id;
	}
	public void setDevice_id(long device_id) {
		this.device_id = device_id;
	}
	public char getBayonet_type() {
		return bayonet_type;
	}
	public void setBayonet_type(char bayonet_type) {
		this.bayonet_type = bayonet_type;
	}
	public char getBayonet_nature() {
		return bayonet_nature;
	}
	public void setBayonet_nature(char bayonet_nature) {
		this.bayonet_nature = bayonet_nature;
	}

	public String getSxfxbm() {
		return sxfxbm;
	}

	public void setSxfxbm(String sxfxbm) {
		this.sxfxbm = sxfxbm;
	}

	public String getSxfxjclx() {
		return sxfxjclx;
	}

	public void setSxfxjclx(String sxfxjclx) {
		this.sxfxjclx = sxfxjclx;
	}

	public String getXxfxbm() {
		return xxfxbm;
	}

	public void setXxfxbm(String xxfxbm) {
		this.xxfxbm = xxfxbm;
	}

	public String getXxfxjclx() {
		return xxfxjclx;
	}

	public void setXxfxjclx(String xxfxjclx) {
		this.xxfxjclx = xxfxjclx;
	}
	
	
	
	

}
