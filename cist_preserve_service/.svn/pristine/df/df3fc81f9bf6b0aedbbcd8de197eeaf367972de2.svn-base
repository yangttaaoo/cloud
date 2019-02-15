package com.cist.xjzx.gzcx.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 故障信息实体类
 * @author Hy
 *
 */
public class VW_SBGZ_INFO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3999299191753711151L;
	private String pk_id;
	private String device_id;//设备ID
	private String alarm_type;//告警类型 1-温度 2-电压 3-断网 4—断电
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date alarm_time;//告警时间
	
	
	
	private String fk_dept_id;//部门id
	private String create_person;//创建人ID
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date create_time;//创建时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date enable_date;//启用时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date validity_date;//有效期止
	private String contacts_person;//责任人
	private String contacts_num;//责任人联系电话
	private String remarks;//备注
	private String fk_device_type;//设备类型
	private String device_name;//设备名称
	private String device_num;//设备编号
	private String belonged_road_id;//所属道路ID
	private Integer kilometre_num;//公里数
	private Integer meter_num;//米数
	private String road_name;//道路名称
	private String longitude;//经度
	private String latitude;//纬度
	private String network_location;//所在网络位置
	private String upload_mode;//数据上传模式
	private String device_source;//设备来源
	private String direction;//方向
	
	
	
	private String alarm_name;//告警名称
	private String fc_name;//设备类型名称
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date complete_time_limit;//完成时限
	private String job_name;//工单名称
	private String job_num;//工单号
	private String job_contents;//工单内容
	private String marks;//工单备注
	
	private String tbet_type_name;//设备类型名称
	private Integer fk_company_id;//接收公司id
	private Integer fk_group_id;//接收小组id
	
	public String getPk_id() {
		return pk_id;
	}
	public void setPk_id(String pk_id) {
		this.pk_id = pk_id;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getAlarm_type() {
		return alarm_type;
	}
	public void setAlarm_type(String alarm_type) {
		this.alarm_type = alarm_type;
	}
	public Date getAlarm_time() {
		return alarm_time;
	}
	public void setAlarm_time(Date alarm_time) {
		this.alarm_time = alarm_time;
	}
	public String getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(String fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public String getCreate_person() {
		return create_person;
	}
	public void setCreate_person(String create_person) {
		this.create_person = create_person;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getEnable_date() {
		return enable_date;
	}
	public void setEnable_date(Date enable_date) {
		this.enable_date = enable_date;
	}
	public Date getValidity_date() {
		return validity_date;
	}
	public void setValidity_date(Date validity_date) {
		this.validity_date = validity_date;
	}
	public String getContacts_person() {
		return contacts_person;
	}
	public void setContacts_person(String contacts_person) {
		this.contacts_person = contacts_person;
	}
	public String getContacts_num() {
		return contacts_num;
	}
	public void setContacts_num(String contacts_num) {
		this.contacts_num = contacts_num;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getFk_device_type() {
		return fk_device_type;
	}
	public void setFk_device_type(String fk_device_type) {
		this.fk_device_type = fk_device_type;
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public String getDevice_num() {
		return device_num;
	}
	public void setDevice_num(String device_num) {
		this.device_num = device_num;
	}
	public String getBelonged_road_id() {
		return belonged_road_id;
	}
	public void setBelonged_road_id(String belonged_road_id) {
		this.belonged_road_id = belonged_road_id;
	}
	public Integer getKilometre_num() {
		return kilometre_num;
	}
	public void setKilometre_num(Integer kilometre_num) {
		this.kilometre_num = kilometre_num;
	}
	public Integer getMeter_num() {
		return meter_num;
	}
	public void setMeter_num(Integer meter_num) {
		this.meter_num = meter_num;
	}
	public String getRoad_name() {
		return road_name;
	}
	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getNetwork_location() {
		return network_location;
	}
	public void setNetwork_location(String network_location) {
		this.network_location = network_location;
	}
	public String getUpload_mode() {
		return upload_mode;
	}
	public void setUpload_mode(String upload_mode) {
		this.upload_mode = upload_mode;
	}
	public String getDevice_source() {
		return device_source;
	}
	public void setDevice_source(String device_source) {
		this.device_source = device_source;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	//1-温度 2-电压 3-断网 4—断电
	public String getAlarm_name() {
		if("1".equals(alarm_type)) {
			return "温度";
		}else if("".equals(alarm_type)) {
			return "电压";
		}else if("".equals(alarm_type)) {
			return "断网";
		}else {
			return "断电";
		}
		
	}
	public void setAlarm_name(String alarm_name) {
		this.alarm_name = alarm_name;
	}
	public String getFc_name() {
		return fc_name;
	}
	public void setFc_name(String fc_name) {
		this.fc_name = fc_name;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_num() {
		return job_num;
	}
	public void setJob_num(String job_num) {
		this.job_num = job_num;
	}
	public String getJob_contents() {
		return job_contents;
	}
	public void setJob_contents(String job_contents) {
		this.job_contents = job_contents;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getTbet_type_name() {
		return tbet_type_name;
	}
	public void setTbet_type_name(String tbet_type_name) {
		this.tbet_type_name = tbet_type_name;
	}
	public Integer getFk_company_id() {
		return fk_company_id;
	}
	public void setFk_company_id(Integer fk_company_id) {
		this.fk_company_id = fk_company_id;
	}
	public Integer getFk_group_id() {
		return fk_group_id;
	}
	public void setFk_group_id(Integer fk_group_id) {
		this.fk_group_id = fk_group_id;
	}
	public Date getComplete_time_limit() {
		return complete_time_limit;
	}
	public void setComplete_time_limit(Date complete_time_limit) {
		this.complete_time_limit = complete_time_limit;
	}
	
	
	
	
	
//	private Integer sbgz_pk;//设备故障PK
//	private Integer sb_pk;//设备PK
//	private String gz_type;//故障类型
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//	private Date gzdate;//故障时间
//	private String tbei_name;//设备名称
//	private Integer tbet_type;//设备类型
//	private String tbec_ip;//ip地址
//	private String gz_info;//故障详情
//	private String tbmp_azdz;//安装地址


//
//	public Integer getSbgz_pk() {
//		return sbgz_pk;
//	}
//
//	public void setSbgz_pk(Integer sbgz_pk) {
//		this.sbgz_pk = sbgz_pk;
//	}
//
//	public Integer getSb_pk() {
//		return sb_pk;
//	}
//
//	public void setSb_pk(Integer sb_pk) {
//		this.sb_pk = sb_pk;
//	}
//
//	public String getGz_type() {
//		return gz_type;
//	}
//
//	public void setGz_type(String gz_type) {
//		this.gz_type = gz_type;
//	}
//
//	public Date getGzdate() {
//		return gzdate;
//	}
//
//	public void setGzdate(Date gzdate) {
//		this.gzdate = gzdate;
//	}
//
//	public String getTbei_name() {
//		return tbei_name;
//	}
//
//	public void setTbei_name(String tbei_name) {
//		this.tbei_name = tbei_name;
//	}
//
//	public Integer getTbet_type() {
//		return tbet_type;
//	}
//
//	public void setTbet_type(Integer tbet_type) {
//		this.tbet_type = tbet_type;
//	}
//
//	public String getTbet_type_name() {
//		if(tbet_type==null) {
//			return "";
//		}else if(tbet_type==1) {
//			return "卡口";
//		}else if(tbet_type==2) {
//			return "电警";
//		}else if(tbet_type==3) {
//			return "信号机";
//		}else if(tbet_type==4) {
//			return "诱导屏";
//		}else{
//			return "视频";
//		}
//	}
//
//	public String getTbec_ip() {
//		return tbec_ip;
//	}
//
//	public void setTbec_ip(String tbec_ip) {
//		this.tbec_ip = tbec_ip;
//	}
//
//	public Integer getFk_company_id() {
//		return fk_company_id;
//	}
//
//	public void setFk_company_id(Integer fk_company_id) {
//		this.fk_company_id = fk_company_id;
//	}
//
//	public Integer getFk_group_id() {
//		return fk_group_id;
//	}
//
//	public void setFk_group_id(Integer fk_group_id) {
//		this.fk_group_id = fk_group_id;
//	}
//
//	public String getGz_info() {
//		return gz_info;
//	}
//
//	public void setGz_info(String gz_info) {
//		this.gz_info = gz_info;
//	}
//
//	public String getTbmp_azdz() {
//		return tbmp_azdz;
//	}
//
//	public void setTbmp_azdz(String tbmp_azdz) {
//		this.tbmp_azdz = tbmp_azdz;
//	}
//
//	public Date getComplete_time_limit() {
//		return complete_time_limit;
//	}
//
//	public void setComplete_time_limit(Date complete_time_limit) {
//		this.complete_time_limit = complete_time_limit;
//	}
//
//	public String getJob_name() {
//		return job_name;
//	}
//
//	public void setJob_name(String job_name) {
//		this.job_name = job_name;
//	}
//
//	public String getJob_num() {
//		return job_num;
//	}
//
//	public void setJob_num(String job_num) {
//		this.job_num = job_num;
//	}
//
//	public String getJob_contents() {
//		return job_contents;
//	}
//
//	public void setJob_contents(String job_contents) {
//		this.job_contents = job_contents;
//	}
//
//	public String getRemarks() {
//		return remarks;
//	}
//
//	public void setRemarks(String remarks) {
//		this.remarks = remarks;
//	}
//
//	public void setTbet_type_name(String tbet_type_name) {
//		this.tbet_type_name = tbet_type_name;
//	}
//
//	
}
