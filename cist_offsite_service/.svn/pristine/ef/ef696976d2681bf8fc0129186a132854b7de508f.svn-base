package com.cist.serviceconfig.unlimitedcar.model;

import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
public class NoLimited {
	   /**
		 * 车辆不限行管理
		 */
	    private String twi_plate_no;//号牌号码
	    private String twi_plate_type;//号牌种类 
	    private String twi_type_code;//车辆类型
	    private Date  kssj;//开始时间 
	    private Date jssj;//结束时间
	    @SuppressWarnings("unused")
		private String clzt;  
	    private String twi_desc;//描述
	    
	    
	    
	    
		public String getClzt() {
	    	Date day=new Date();    
	    	if(kssj.before(day) && jssj.after(day)){
	    		return "有效";
	    	}
	    	else  if(jssj.equals(day) ||kssj.equals(day)){
	    		return "有效";
	    	}
	    	return "无效";
		}
		
		public String getTwi_plate_no() {
			return twi_plate_no;
		}
		public void setTwi_plate_no(String twi_plate_no) {
			this.twi_plate_no = twi_plate_no;
		}
		public String getTwi_plate_type() {
			if(twi_plate_type!=null){
				return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_HPZL,twi_plate_type);
			}
			return twi_plate_type;
		}
		public void setTwi_plate_type(String twi_plate_type) {
			this.twi_plate_type = twi_plate_type;
		}
		public String getTwi_desc() {
			return twi_desc;
		}
		public void setTwi_desc(String twi_desc) {
			this.twi_desc = twi_desc;
		}
		public String getTwi_type_code() {
			if(twi_type_code!=null){
				return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CLLX,twi_type_code);
			}
			return twi_type_code;
		}
		public void setTwi_type_code(String twi_type_code) {
			this.twi_type_code = twi_type_code;
		}
		public Date getKssj() {
			return kssj;
		}
		public void setKssj(Date kssj) {
			this.kssj = kssj;
		}
		public Date getJssj() {
			return jssj;
		}
		public void setJssj(Date jssj) {
			this.jssj = jssj;
		}

	}

