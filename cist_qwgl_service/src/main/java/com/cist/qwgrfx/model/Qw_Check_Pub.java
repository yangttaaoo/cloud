package com.cist.qwgrfx.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.cist.personalentry.model.IndividualInfo;

public class Qw_Check_Pub implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pk;//id
	private String  khbh;//考核人编号/考核单位编号
	private String  khzb;//考核指标
	private String  zhzb;//综合指标
	private String  sfhg;//是否合格，0-不合格 1-合格
	private String zbrq;//指标日期
	private String  zbnf;//指标年份
	private String  gldw;//管理单位编码
    private Date zbkssj;//指标开始时间
    private Date zbjssj;//指标结束时间
    private String  khlx;//考核类型，1-个人 2-单位
    
    
    private List<IndividualInfo> tllist=new ArrayList<>();
    
    
    
    
    
    
    private Integer pk_id;//ID
	private Double fk_dept_id;//管理部门ID
	private String fk_dept_name;//管理部门中文名
	private char data_sources_type;//数据来源（0：系统录入；1：其他）
	private String data_sources_name;//数据来源中文名称
	private char assessment_type;//考核类型（1：勤务考核；2：非现考核；3：其他）
	private String assessment_name;//考核类型中文名称
	private Integer fk_user_id;//考核人ID	
	private String fk_user_name;//考核人姓名
	private Integer fk_report_id;//勤务报备ID
	private String fk_report_name;
	private Integer assessment_num;//考核条数
	private Integer verify_num;//审核条数
	private Date start_date;//执勤开始日期
	private String start_date_name;
	private Date end_date;//执勤结束日期
	private String end_date_name;
	private String daterng;
	private Integer fk_patrol_area_id;//执勤区域ID
	private String fk_patrol_area_name;//执勤区域名称
	private char own_guns;//是否配枪（0：否；1：是）
	private Integer fk_topic_id;//考核栏目ID
	private String fk_topic_name;
	private Integer fk_regulations_id;//考核条例ID
	private String fk_regulations_name;
	private String regulations_name;
	private String explain;//说明
	private Integer input_person;//录入人ID
	private String input_name;
	private Date input_time;//录入时间
	private String input_time_name;//录入时间中文
	private char verify_status;//审核状态（0：未审核、1：已审核）
	private String verify_name;//审核状态中文名
	private Integer fk_verify_person_id;//审核人ID
	private Date verify_time;//审核时间
	private Integer metrics_num;
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Double getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(Double fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public String getFk_dept_name() {
		return fk_dept_name;
	}
	public void setFk_dept_name(String fk_dept_name) {
		this.fk_dept_name = fk_dept_name;
	}
	public char getData_sources_type() {
		return data_sources_type;
	}
	public void setData_sources_type(char data_sources_type) {
		this.data_sources_type = data_sources_type;
	}
	public String getData_sources_name() {
		return data_sources_name;
	}
	public void setData_sources_name(String data_sources_name) {
		this.data_sources_name = data_sources_name;
	}
	public char getAssessment_type() {
		return assessment_type;
	}
	public void setAssessment_type(char assessment_type) {
		this.assessment_type = assessment_type;
	}
	public String getAssessment_name() {
		return assessment_name;
	}
	public void setAssessment_name(String assessment_name) {
		this.assessment_name = assessment_name;
	}
	public Integer getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(Integer fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	public String getFk_user_name() {
		return fk_user_name;
	}
	public void setFk_user_name(String fk_user_name) {
		this.fk_user_name = fk_user_name;
	}
	public Integer getFk_report_id() {
		return fk_report_id;
	}
	public void setFk_report_id(Integer fk_report_id) {
		this.fk_report_id = fk_report_id;
	}
	public String getFk_report_name() {
		return fk_report_name;
	}
	public void setFk_report_name(String fk_report_name) {
		this.fk_report_name = fk_report_name;
	}
	public Integer getAssessment_num() {
		return assessment_num;
	}
	public void setAssessment_num(Integer assessment_num) {
		this.assessment_num = assessment_num;
	}
	public Integer getVerify_num() {
		return verify_num;
	}
	public void setVerify_num(Integer verify_num) {
		this.verify_num = verify_num;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public String getStart_date_name() {
		return start_date_name;
	}
	public void setStart_date_name(String start_date_name) {
		this.start_date_name = start_date_name;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getEnd_date_name() {
		return end_date_name;
	}
	public void setEnd_date_name(String end_date_name) {
		this.end_date_name = end_date_name;
	}
	public String getDaterng() {
		return daterng;
	}
	public void setDaterng(String daterng) {
		this.daterng = daterng;
	}
	public Integer getFk_patrol_area_id() {
		return fk_patrol_area_id;
	}
	public void setFk_patrol_area_id(Integer fk_patrol_area_id) {
		this.fk_patrol_area_id = fk_patrol_area_id;
	}
	public String getFk_patrol_area_name() {
		return fk_patrol_area_name;
	}
	public void setFk_patrol_area_name(String fk_patrol_area_name) {
		this.fk_patrol_area_name = fk_patrol_area_name;
	}
	public char getOwn_guns() {
		return own_guns;
	}
	public void setOwn_guns(char own_guns) {
		this.own_guns = own_guns;
	}
	public Integer getFk_topic_id() {
		return fk_topic_id;
	}
	public void setFk_topic_id(Integer fk_topic_id) {
		this.fk_topic_id = fk_topic_id;
	}
	public String getFk_topic_name() {
		return fk_topic_name;
	}
	public void setFk_topic_name(String fk_topic_name) {
		this.fk_topic_name = fk_topic_name;
	}
	public Integer getFk_regulations_id() {
		return fk_regulations_id;
	}
	public void setFk_regulations_id(Integer fk_regulations_id) {
		this.fk_regulations_id = fk_regulations_id;
	}
	public String getFk_regulations_name() {
		return fk_regulations_name;
	}
	public void setFk_regulations_name(String fk_regulations_name) {
		this.fk_regulations_name = fk_regulations_name;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public Integer getInput_person() {
		return input_person;
	}
	public void setInput_person(Integer input_person) {
		this.input_person = input_person;
	}
	public String getInput_name() {
		return input_name;
	}
	public void setInput_name(String input_name) {
		this.input_name = input_name;
	}
	public Date getInput_time() {
		return input_time;
	}
	public void setInput_time(Date input_time) {
		this.input_time = input_time;
	}
	public String getInput_time_name() {
		return input_time_name;
	}
	public void setInput_time_name(String input_time_name) {
		this.input_time_name = input_time_name;
	}
	public char getVerify_status() {
		return verify_status;
	}
	public void setVerify_status(char verify_status) {
		this.verify_status = verify_status;
	}
	public String getVerify_name() {
		return verify_name;
	}
	public void setVerify_name(String verify_name) {
		this.verify_name = verify_name;
	}
	public Integer getFk_verify_person_id() {
		return fk_verify_person_id;
	}
	public void setFk_verify_person_id(Integer fk_verify_person_id) {
		this.fk_verify_person_id = fk_verify_person_id;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	public String getTopic_name() {
		return topic_name;
	}
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	public Integer getDefault_value() {
		return default_value;
	}
	public void setDefault_value(Integer default_value) {
		this.default_value = default_value;
	}
	public String getTopic_explain() {
		return topic_explain;
	}
	public void setTopic_explain(String topic_explain) {
		this.topic_explain = topic_explain;
	}
	public String getEnabled_state() {
		return enabled_state;
	}
	public void setEnabled_state(String enabled_state) {
		this.enabled_state = enabled_state;
	}
	public Integer getCreate_person_id() {
		return create_person_id;
	}
	public void setCreate_person_id(Integer create_person_id) {
		this.create_person_id = create_person_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	private String  topic_name;//评定栏目
	private Integer default_value;//默认分值
	private String topic_explain;//栏目说明
	private String enabled_state;//启用状态（0：禁用；1：启用）
	private Integer create_person_id;//创建人
	private Date create_time;//创建时间
    
    
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getKhbh() {
		if(khbh!=null){
			khbh=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER,khbh ); ;
			return khbh;
		}
		return khbh;
	}
	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}
	public String getKhzb() {
		return khzb;
	}
	public void setKhzb(String khzb) {
		this.khzb = khzb;
	}
	public String getZhzb() {
		return zhzb;
	}
	public void setZhzb(String zhzb) {
		this.zhzb = zhzb;
	}
	public String getSfhg() {
		return sfhg;
	}
	public void setSfhg(String sfhg) {
		this.sfhg = sfhg;
	}
	public String getZbrq() {
		return zbrq;
	}
	public void setZbrq(String zbrq) {
		this.zbrq = zbrq;
	}
	public String getZbnf() {
		return zbnf;
	}
	public void setZbnf(String zbnf) {
		this.zbnf = zbnf;
	}
	public String getGldw() {
		if(gldw!=null){
			gldw=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT_PK, gldw);
		}
		return gldw;
	}
	public void setGldw(String gldw) {
		this.gldw = gldw;
	}
	public Date getZbkssj() {
		return zbkssj;
	}
	public void setZbkssj(Date zbkssj) {
		this.zbkssj = zbkssj;
	}
	public Date getZbjssj() {
		return zbjssj;
	}
	public void setZbjssj(Date zbjssj) {
		this.zbjssj = zbjssj;
	}
	public String getKhlx() {
		return khlx;
	}
	public void setKhlx(String khlx) {
		this.khlx = khlx;
	}
	public String getRegulations_name() {
		return regulations_name;
	}
	public void setRegulations_name(String regulations_name) {
		this.regulations_name = regulations_name;
	}
	public Integer getMetrics_num() {
		return metrics_num;
	}
	public void setMetrics_num(Integer metrics_num) {
		this.metrics_num = metrics_num;
	}
	public List<IndividualInfo> getTllist() {
		return tllist;
	}
	public void setTllist(List<IndividualInfo> tllist) {
		this.tllist = tllist;
	}
    
    
}
