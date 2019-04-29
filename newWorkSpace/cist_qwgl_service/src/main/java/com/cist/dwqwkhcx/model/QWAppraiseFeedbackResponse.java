package com.cist.dwqwkhcx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class QWAppraiseFeedbackResponse {
    private Integer pk_id;//ID

    private Long fk_assessment_id;//勤务考核ID（个人或者单位考核ID）

    private String assessment_type;//勤务考核类型（1：个人；2：单位）

    private String explain_type;//说明类型（1：反馈说明；2：回复说明）

    private String explain_content;//反馈/回复内容
    private String explain_content_name;//反馈/回复内容
    private Integer fk_user_id;//反馈/回复人ID

    private Date f_r_time;//反馈/回复时间

    private String fk_user_name;//反馈/回复人名字
    
    private List<QwAssessmentAttachment> pic=new ArrayList<QwAssessmentAttachment>();
    
	public Integer getPk_id() {
		return pk_id;
	}

	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}

	public Long getFk_assessment_id() {
		return fk_assessment_id;
	}

	public void setFk_assessment_id(Long fk_assessment_id) {
		this.fk_assessment_id = fk_assessment_id;
	}

	public String getAssessment_type() {
		return assessment_type;
	}

	public void setAssessment_type(String assessment_type) {
		this.assessment_type = assessment_type;
	}

	public String getExplain_type() {
		return explain_type;
	}

	public void setExplain_type(String explain_type) {
		this.explain_type = explain_type;
	}

	public String getExplain_content() {
		return explain_content;
	}

	public void setExplain_content(String explain_content) {
		this.explain_content = explain_content;
	}

	public Integer getFk_user_id() {
		return fk_user_id;
	}

	public void setFk_user_id(Integer fk_user_id) {
		this.fk_user_id = fk_user_id;
	}

	public Date getF_r_time() {
		return f_r_time;
	}

	public void setF_r_time(Date f_r_time) {
		this.f_r_time = f_r_time;
	}

	public String getFk_user_name() {
		if(fk_user_id!=null) {
			fk_user_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, fk_user_id.toString());
		}
		return fk_user_name;
	}

	public void setFk_user_name(String fk_user_name) {
		this.fk_user_name = fk_user_name;
	}

	public List<QwAssessmentAttachment> getPic() {
		return pic;
	}

	public void setPic(List<QwAssessmentAttachment> pic) {
		this.pic = pic;
	}

	public String getExplain_content_name() {
	
		if (explain_type.equals("1")){
			return explain_content_name;
		}else if (explain_type.equals("2")) {
			return "";
		}
		return explain_content_name;
	}

	public void setExplain_content_name(String explain_content_name) {
		this.explain_content_name = explain_content_name;
	}

    
}