package com.cist.videopatrol.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 视频巡逻方案表
 * @author hy
 *
 */
public class TBL_VIO_CRUISE_CASE implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3569916413998902377L;
	private Integer vcc_pk;
	private String vcc_name;//巡逻名称
	private String vcc_type;//巡逻方式，0视频巡逻，1抽帧巡逻
	private Integer vcc_duration;//巡逻频率
	private String vcc_time;//巡逻时间段
	private Date vcc_start_time;//有效期开始时间
	private Date vcc_end_time;//有效期结束时间
	private String vcc_remark;//备注
	private String dept_pk;//部门ID
	private String vcc_duration_unit;//巡逻频率单位 1：分钟 2：小时
	private String vvc_patrol_type;//巡逻类型（参考SYS_FRM_CODE表FC_CODE=D008）
	
	private String device_gb_serial;//设备国标序列号
	private String device_gb_code;//设备国标编码
	private String device_gb_channel;//设备国标通道号
	private String device_gb_ptz;//参考SYS_FRM_CODE表 FCT_CODE=P015)
	private List<SPJK_VIO_CRUISE_CONFIG> camera=new ArrayList<SPJK_VIO_CRUISE_CONFIG>();
	
	private Integer auto=0;//标识巡检过的视频数量
	
	// 纬度
	private BigDecimal latitude;
	// 经度
	private BigDecimal longitude;
	
	private String road_name;//摄像机所在的道路名称
	
	private Integer vcf_prest_sign;//巡逻预置位
	private Integer vcf_rest_sign;//复位预置位
	
	public String getDevice_gb_code() {
		return device_gb_code;
	}
	public void setDevice_gb_code(String device_gb_code) {
		this.device_gb_code = device_gb_code;
	}
	public String getDevice_gb_channel() {
		return device_gb_channel;
	}
	public void setDevice_gb_channel(String device_gb_channel) {
		this.device_gb_channel = device_gb_channel;
	}
	public String getDevice_gb_ptz() {
		return device_gb_ptz;
	}
	public void setDevice_gb_ptz(String device_gb_ptz) {
		this.device_gb_ptz = device_gb_ptz;
	}
	public Integer getVcc_pk() {
		return vcc_pk;
	}
	public void setVcc_pk(Integer vcc_pk) {
		this.vcc_pk = vcc_pk;
	}
	public String getVcc_name() {
		return vcc_name;
	}
	public void setVcc_name(String vcc_name) {
		this.vcc_name = vcc_name;
	}
	public String getVcc_type() {
		return vcc_type;
	}
	public void setVcc_type(String vcc_type) {
		this.vcc_type = vcc_type;
	}
	public Integer getVcc_duration() {
		return vcc_duration;
	}
	public void setVcc_duration(Integer vcc_duration) {
		this.vcc_duration = vcc_duration;
	}
	public String getVcc_time() {
		return vcc_time;
	}
	public void setVcc_time(String vcc_time) {
		this.vcc_time = vcc_time;
	}
	public Date getVcc_start_time() {
		return vcc_start_time;
	}
	public void setVcc_start_time(Date vcc_start_time) {
		this.vcc_start_time = vcc_start_time;
	}
	public Date getVcc_end_time() {
		return vcc_end_time;
	}
	public void setVcc_end_time(Date vcc_end_time) {
		this.vcc_end_time = vcc_end_time;
	}
	public String getVcc_remark() {
		return vcc_remark;
	}
	public void setVcc_remark(String vcc_remark) {
		this.vcc_remark = vcc_remark;
	}
	public String getDept_pk() {
		return dept_pk;
	}
	public void setDept_pk(String dept_pk) {
		this.dept_pk = dept_pk;
	}
	public String getVcc_duration_unit() {
		return vcc_duration_unit;
	}
	public void setVcc_duration_unit(String vcc_duration_unit) {
		this.vcc_duration_unit = vcc_duration_unit;
	}
	public String getVvc_patrol_type() {
		return vvc_patrol_type;
	}
	public void setVvc_patrol_type(String vvc_patrol_type) {
		this.vvc_patrol_type = vvc_patrol_type;
	}
	public String getDevice_gb_serial() {
		return device_gb_serial;
	}
	public void setDevice_gb_serial(String device_gb_serial) {
		this.device_gb_serial = device_gb_serial;
	}
	public String getRoad_name() {
		return road_name;
	}
	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public Integer getVcf_prest_sign() {
		return vcf_prest_sign;
	}
	public void setVcf_prest_sign(Integer vcf_prest_sign) {
		this.vcf_prest_sign = vcf_prest_sign;
	}
	public Integer getVcf_rest_sign() {
		return vcf_rest_sign;
	}
	public void setVcf_rest_sign(Integer vcf_rest_sign) {
		this.vcf_rest_sign = vcf_rest_sign;
	}
	public List<SPJK_VIO_CRUISE_CONFIG> getCamera() {
		return camera;
	}
	public void setCamera(List<SPJK_VIO_CRUISE_CONFIG> camera) {
		this.camera = camera;
	}
	public Integer getAuto() {
		return auto;
	}
	public void setAuto(Integer auto) {
		this.auto = auto;
	}
}
