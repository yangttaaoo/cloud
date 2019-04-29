package com.cist.dataquery.model;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Tbl_Log {
	
	private Integer tool_pk;//id
	private String tool_user;//联系人
	private String tool_user_name;//联系人
	private String tool_ip;//操作ip
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date tool_time;//操作时间
	private String tool_dept_code;//操作部门代码
	private String tool_type;//业务类型 1-违法初审 2-违法复审 3-作废审核 4-违法上传 5-违法初筛
	private String tool_result;//处理结果
	private String tool_sign;//原始数据修改标记 0-未修改 1-已修改
	private String tool_wfxh;//违法序号(参考TBL_OFFE_EVDI表 中WFXH字段)
	private String tool_src;//原始数据
	private String tool_dest;//修改后的数据
	public Integer getTool_pk() {
		return tool_pk;
	}
	public void setTool_pk(Integer tool_pk) {
		this.tool_pk = tool_pk;
	}
	public String getTool_user() {
		return tool_user;
	}
	public void setTool_user(String tool_user) {
		this.tool_user = tool_user;
	}
	public String getTool_ip() {
		return tool_ip;
	}
	public void setTool_ip(String tool_ip) {
		this.tool_ip = tool_ip;
	}
	public Date getTool_time() {
		return tool_time;
	}
	public void setTool_time(Date tool_time) {
		this.tool_time = tool_time;
	}
	public String getTool_dept_code() {
		if(tool_dept_code!=null){			
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT,tool_dept_code);
		}
		return tool_dept_code;
	}
	public void setTool_dept_code(String tool_dept_code) {
		this.tool_dept_code = tool_dept_code;
	}
	public String getTool_type() {
		switch (tool_type) {
		 case "1":
			 tool_type="违法初审";	
		   break;
		 case "2":
			 tool_type="违法复审";	
		   break;
		 case "3":
			 tool_type="作废审核";	
		   break;
		 case "4":
			 tool_type="违法上传";	
			 break;
		}
		
		return tool_type;
	}
	public void setTool_type(String tool_type) {
		this.tool_type = tool_type;
	}
	public String getTool_result() {
		return tool_result;
	}
	public void setTool_result(String tool_result) {
		this.tool_result = tool_result;
	}
	public String getTool_sign() {
		return  "0".equals(tool_sign)?"未修改":"已修改";
	}
	public void setTool_sign(String tool_sign) {
		this.tool_sign = tool_sign;
	}
	public String getTool_wfxh() {
		return tool_wfxh;
	}
	public void setTool_wfxh(String tool_wfxh) {
		this.tool_wfxh = tool_wfxh;
	}
	public String getTool_src() {
		return tool_src;
	}
	public void setTool_src(String tool_src) {
		this.tool_src = tool_src;
	}
	public String getTool_dest() {
		return tool_dest;
	}
	public void setTool_dest(String tool_dest) {
		this.tool_dest = tool_dest;
	}
	public String getTool_user_name() {
		
		if(tool_user!=null)
		{
			return SysTempStoreUtils.getFcName("YH00", tool_user);
		}
		
		return tool_user_name;
	}
	public void setTool_user_name(String tool_user_name) {
		this.tool_user_name = tool_user_name;
	}
	
}
