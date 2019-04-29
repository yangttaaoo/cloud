package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
import java.util.List;

import com.cist.qwgl.qwjg.model.GpsRecord;
import com.cist.qwgl.qwjg.model.Jcsj_police_resources;
/**
 * 9.20.	车巡报备
 * @author wangtao
 *
 */
public class Qw_report_car_patrol implements Serializable{
	private static final long serialVersionUID = 1L;
	  private Integer pk_id;//id
	    private String fk_report_id;//勤务报备ID
	    private String fk_police_car_id;//警车id
	    private List<Qw_report_car_relation> qw_report_car_relation;//9.21.	车巡关联人员报备
	    private Jcsjpoliceresources jcsjpoliceresources;//车俩信息
	    private Jcsj_police_res_person fuzenren;//车辆负责人
	    private Jcsj_police_resources jcsj_police_resources;
	 
		public Jcsj_police_resources getJcsj_police_resources() {
			return jcsj_police_resources;
		}
		public void setJcsj_police_resources(Jcsj_police_resources jcsj_police_resources) {
			this.jcsj_police_resources = jcsj_police_resources;
		}
		public Jcsj_police_res_person getFuzenren() {
			if(null!=qw_report_car_relation&&qw_report_car_relation.size()!=0) {
				for (Qw_report_car_relation qw_report_car_relation2 : qw_report_car_relation) {
					if(qw_report_car_relation2.getUser_type().equals("1")) {
						return qw_report_car_relation2.getSyspoliceinfo();
					}
				}
			}
			return fuzenren;
		}
		public void setFuzenren(Jcsj_police_res_person fuzenren) {
			this.fuzenren = fuzenren;
		}
		public Integer getPk_id() {
			return pk_id;
		}
		public void setPk_id(Integer pk_id) {
			this.pk_id = pk_id;
		}
		public String getFk_report_id() {
			return fk_report_id;
		}
		public void setFk_report_id(String fk_report_id) {
			this.fk_report_id = fk_report_id;
		}
		public String getFk_police_car_id() {
			return fk_police_car_id;
		}
		public void setFk_police_car_id(String fk_police_car_id) {
			this.fk_police_car_id = fk_police_car_id;
		}
		
		public List<Qw_report_car_relation> getQw_report_car_relation() {
			return qw_report_car_relation;
		}
		public void setQw_report_car_relation(List<Qw_report_car_relation> qw_report_car_relation) {
			this.qw_report_car_relation = qw_report_car_relation;
		}
		public Jcsjpoliceresources getJcsjpoliceresources() {
			return jcsjpoliceresources;
		}
		public void setJcsjpoliceresources(Jcsjpoliceresources jcsjpoliceresources) {
			this.jcsjpoliceresources = jcsjpoliceresources;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
}
