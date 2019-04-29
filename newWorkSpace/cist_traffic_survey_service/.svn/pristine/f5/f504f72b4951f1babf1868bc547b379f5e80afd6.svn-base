package com.cist.intervalVelocity.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.cist.devRegister.model.Device;
import com.cist.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class IntervalVelocity {
	// ID
		private Integer pk_id;
	// 部门ID
		private long fk_dept_id;
		// 创建人ID
		private Integer create_person;
		// 创建时间
		@JsonFormat(pattern="yyyy-MM-dd  hh:mm:ss")
		private Date create_time;
		
		
		// 启用日期
		@JsonFormat(pattern="yyyy-MM-dd  hh:mm:ss")
		private Date enable_date;
		// 有效期止
		@JsonFormat(pattern="yyyy-MM-dd  hh:mm:ss")
		private Date validity_date;
		// 责任人
		private String contacts_person;
		// 责任人联系电话
		private String contacts_num;
		// 备注
		private String remarks;
		// 设备类型
		private String fk_device_type;
		// 设备名称
		private String device_name;
		// 设备编号
		private String device_num;
		// 间距 
		private Integer spacing;
		//大车限速
		private Integer speed_limit_big_car;
		//小车限速
		private Integer speed_limit_small_car;
		//米数
		private Integer meter_num;
		//道路名称
		private String road_name;
		//关联卡口IDs
		private String relevance_device_id;
		
		
		
		// 设备类型Name
		private String fk_device_type_name;
		
		
		// 行政区域code
		private String xzqh;
		
		//所属道路id
				private String kilometre_num;
				// 公里数/路口号
				private String belonged_road_id;
				// 方向
				private String direction;
		

		
				
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
		public String getKilometre_num() {
					return kilometre_num;
				}
				public void setKilometre_num(String kilometre_num) {
					this.kilometre_num = kilometre_num;
				}
				public String getBelonged_road_id() {
					return belonged_road_id;
				}
				public void setBelonged_road_id(String belonged_road_id) {
					this.belonged_road_id = belonged_road_id;
				}
				public String getDirection() {
					return direction;
				}
				public void setDirection(String direction) {
					this.direction = direction;
				}
		public List<String> getRelevance_device_id() {

			List<String> asList =Arrays.asList(this.relevance_device_id.split(","));
			return asList;
		}
		public void setRelevance_device_id(String relevance_device_id) {
			this.relevance_device_id = relevance_device_id;
		}
		public Integer getPk_id() {
			return pk_id;
		}
		public void setPk_id(Integer pk_id) {
			this.pk_id = pk_id;
		}
		public long getFk_dept_id() {
			return fk_dept_id;
		}
		public void setFk_dept_id(long fk_dept_id) {
			this.fk_dept_id = fk_dept_id;
		}
		public Integer getCreate_person() {
			return create_person;
		}
		public void setCreate_person(Integer create_person) {
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
		public Integer getSpacing() {
			return spacing;
		}
		public void setSpacing(Integer spacing) {
			this.spacing = spacing;
		}
		public Integer getSpeed_limit_big_car() {
			return speed_limit_big_car;
		}
		public void setSpeed_limit_big_car(Integer speed_limit_big_car) {
			this.speed_limit_big_car = speed_limit_big_car;
		}
		public Integer getSpeed_limit_small_car() {
			return speed_limit_small_car;
		}
		public void setSpeed_limit_small_car(Integer speed_limit_small_car) {
			this.speed_limit_small_car = speed_limit_small_car;
		}
		public String getFk_device_type_name() {
			return fk_device_type_name;
		}
		public void setFk_device_type_name(String fk_device_type_name) {
			this.fk_device_type_name = fk_device_type_name;
		}
		public String getXzqh() {
			return xzqh;
		}
		public void setXzqh(String xzqh) {
			this.xzqh = xzqh;
		}
		public IntervalVelocity() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
	
}
