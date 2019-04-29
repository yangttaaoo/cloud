package com.cist.serviceconfig.imgnameconfig.model;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class TblOffeImgExp {
    private Long tbie_pk;

    private String tbie_name;

    private String tbie_type;

    private String tbie_split;

    private String tbie_format;

    private String tbie_example;

    private String tbie_content;

    private String tbie_desc;
    
    private String tbie_type_name;

	public Long getTbie_pk() {
		return tbie_pk;
	}

	public void setTbie_pk(Long tbie_pk) {
		this.tbie_pk = tbie_pk;
	}

	public String getTbie_name() {
		return tbie_name;
	}

	public void setTbie_name(String tbie_name) {
		this.tbie_name = tbie_name;
	}

	public String getTbie_type() {
		return tbie_type;
	}

	public void setTbie_type(String tbie_type) {
		this.tbie_type = tbie_type;
	}

	public String getTbie_split() {
		return tbie_split;
	}

	public void setTbie_split(String tbie_split) {
		this.tbie_split = tbie_split;
	}

	public String getTbie_format() {
		return tbie_format;
	}

	public void setTbie_format(String tbie_format) {
		this.tbie_format = tbie_format;
	}

	public String getTbie_example() {
		return tbie_example;
	}

	public void setTbie_example(String tbie_example) {
		this.tbie_example = tbie_example;
	}

	public String getTbie_content() {
		return tbie_content;
	}

	public void setTbie_content(String tbie_content) {
		this.tbie_content = tbie_content;
	}

	public String getTbie_desc() {
		return tbie_desc;
	}

	public void setTbie_desc(String tbie_desc) {
		this.tbie_desc = tbie_desc;
	}

	public String getTbie_type_name() {
		if(null!=tbie_type)
    	{
			if(tbie_type.equals("99"))
			{
				return "默认模板";
			}
			tbie_type_name=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_SBLX,tbie_type);
    		return tbie_type_name;
    	}
		return tbie_type_name;
	}

	public void setTbie_type_name(String tbie_type_name) {
		this.tbie_type_name = tbie_type_name;
	}

   
}