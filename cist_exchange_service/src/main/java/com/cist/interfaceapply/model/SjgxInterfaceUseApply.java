package com.cist.interfaceapply.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SjgxInterfaceUseApply {
    private Integer pk_id;//ID

    private Long fk_used_id;//使用单位

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date start_date;//开始日期

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date end_date;//结束日期

    private String ip_range;//IP范围

    private String func_description;//功能简述

    private String fk_interface_list_id;//接口列表（，分隔）

    private Integer check_reviewer_id;//审核人ID

    private String check_status;//审核状态（-1：不通过，0：审核中，1通过）

    private String license_code;//授权码（审核通过后,后台生成）

    private Date apply_date;//申请日期
    
    private String check_status_name;//审核状态
    
    private String useDate;//授权码（使用日期）
    
    private String dev_company_name;//开发单位名称(、分割)
    
    private String fk_used_name;//使用单位名称
    
    private List<Integer> interface_id=new ArrayList<Integer>();//选中的接口列表id
    
    private List<Integer> dev_company_id=new ArrayList<Integer>();//选中的开发单位id
    
    private String interface_id_str;//选中的接口列表id字符串","分隔
    
    private String dev_company_id_str;//选中的开发单位id字符串","分隔

	public Integer getPk_id() {
		return pk_id;
	}

	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}

	public Long getFk_used_id() {
		return fk_used_id;
	}

	public void setFk_used_id(Long fk_used_id) {
		this.fk_used_id = fk_used_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getIp_range() {
		return ip_range;
	}

	public void setIp_range(String ip_range) {
		this.ip_range = ip_range;
	}

	public String getFunc_description() {
		return func_description;
	}

	public void setFunc_description(String func_description) {
		this.func_description = func_description;
	}

	public String getFk_interface_list_id() {
		return fk_interface_list_id;
	}

	public void setFk_interface_list_id(String fk_interface_list_id) {
		this.fk_interface_list_id = fk_interface_list_id;
	}

	public Integer getCheck_reviewer_id() {
		return check_reviewer_id;
	}

	public void setCheck_reviewer_id(Integer check_reviewer_id) {
		this.check_reviewer_id = check_reviewer_id;
	}

	public String getCheck_status() {
		check_status=check_status.trim();
		
		return check_status;
	}

	public void setCheck_status(String check_status) {
		this.check_status = check_status;
	}

	public String getLicense_code() {
		return license_code;
	}

	public void setLicense_code(String license_code) {
		this.license_code = license_code;
	}

	public Date getApply_date() {
		return apply_date;
	}

	public void setApply_date(Date apply_date) {
		this.apply_date = apply_date;
	}

	public String getCheck_status_name() {
		if(null!=check_status&&check_status!="")
		{
		if(check_status.equals("-1"))
		{
			check_status_name="不通过";
		}
		else if(check_status.equals("0"))
		{
			check_status_name="审核中";
		}
		else if(check_status.equals("1"))
		{
			check_status_name="通过";
		}
		
		}
		return check_status_name;
	}

	public void setCheck_status_name(String check_status_name) {
		this.check_status_name = check_status_name;
	}

	public String getUseDate() {
		if(start_date!=null&&end_date!=null)
		{
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			
			useDate=format.format(start_date)+"-"+format.format(end_date);
		}
		return useDate;
	}

	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}

	public String getDev_company_name() {
		return dev_company_name;
	}

	public void setDev_company_name(String dev_company_name) {
		this.dev_company_name = dev_company_name;
	}

	public String getFk_used_name() {
	if(fk_used_id!=null){
		fk_used_name=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, fk_used_id.toString());
	}
	
		return fk_used_name;
	}

	public void setFk_used_name(String fk_used_name) {
		this.fk_used_name = fk_used_name;
	}


	public String getInterface_id_str() {
		
		return interface_id_str;
	}

	public void setInterface_id_str(String interface_id_str) {
		this.interface_id_str = interface_id_str;
	}

	public String getDev_company_id_str() {
		return dev_company_id_str;
	}

	public void setDev_company_id_str(String dev_company_id_str) {

		this.dev_company_id_str = dev_company_id_str;
	}

	public List<Integer> getInterface_id() {
		if(interface_id_str!=null&&!("".equals(interface_id_str)))
		{
			String[] split = interface_id_str.split(",");
			for (int i = 0; i < split.length; i++) {
				interface_id.add(Integer.valueOf(split[i]));
			}
		}
		return interface_id;
	}

	public void setInterface_id(List<Integer> interface_id) {
		this.interface_id = interface_id;
	}

	public List<Integer> getDev_company_id() {
		if(dev_company_id_str!=null&&!("".equals(dev_company_id_str)))
		{
			String[] split = dev_company_id_str.split(",");
			for (int i = 0; i < split.length; i++) {
				dev_company_id.add(Integer.valueOf(split[i]));
			}
		}
		
		return dev_company_id;
	}

	public void setDev_company_id(List<Integer> dev_company_id) {
		this.dev_company_id = dev_company_id;
	}

}