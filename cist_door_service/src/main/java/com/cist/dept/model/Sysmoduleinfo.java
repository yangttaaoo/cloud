package com.cist.dept.model;
import java.io.Serializable;
/**
 * 部门
 *
 */
public class Sysmoduleinfo implements Serializable{
	private static final long serialVersionUID = 3826667444130665918L;
	private Integer dept_pk;//ID
	private String dept_code;//部门代码
	private String dept_name;//简称
	private String dept_allname;//全称
	private String dept_seal;//
	private String dept_authority;//责任机关
	private String dept_level;//部门级别
	private String dept_head;//负责人
	private String dept_reat;//联系人
	private String dept_tel;//联系电话
	private String dept_fax;//传真
	private String dept_addr;//地址
	private Integer dept_superior;//上级ID
	private Integer sydt_pk;//机构类型关联sys_dept_type
	private String dept_simp_spell;//首字母
	private Integer tbek_pk;//行政区划关联C_KREIS_CODE
	private Integer map_id;//
	private String dept_flag;//0删除，1未删除
	private String tbek_code;//行政区代码
	public Integer getDept_pk() {
		return dept_pk;
	}
	public void setDept_pk(Integer dept_pk) {
		this.dept_pk = dept_pk;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_allname() {
		return dept_allname;
	}
	public void setDept_allname(String dept_allname) {
		this.dept_allname = dept_allname;
	}
	public String getDept_seal() {
		return dept_seal;
	}
	public void setDept_seal(String dept_seal) {
		this.dept_seal = dept_seal;
	}
	public String getDept_authority() {
		return dept_authority;
	}
	public void setDept_authority(String dept_authority) {
		this.dept_authority = dept_authority;
	}
	public String getDept_level() {
		return dept_level;
	}
	public void setDept_level(String dept_level) {
		this.dept_level = dept_level;
	}
	public String getDept_head() {
		return dept_head;
	}
	public void setDept_head(String dept_head) {
		this.dept_head = dept_head;
	}
	public String getDept_reat() {
		return dept_reat;
	}
	public void setDept_reat(String dept_reat) {
		this.dept_reat = dept_reat;
	}
	public String getDept_tel() {
		return dept_tel;
	}
	public void setDept_tel(String dept_tel) {
		this.dept_tel = dept_tel;
	}
	public String getDept_fax() {
		return dept_fax;
	}
	public void setDept_fax(String dept_fax) {
		this.dept_fax = dept_fax;
	}
	public String getDept_addr() {
		return dept_addr;
	}
	public void setDept_addr(String dept_addr) {
		this.dept_addr = dept_addr;
	}
	public Integer getDept_superior() {
		return dept_superior;
	}
	public void setDept_superior(Integer dept_superior) {
		this.dept_superior = dept_superior;
	}
	public Integer getSydt_pk() {
		return sydt_pk;
	}
	public void setSydt_pk(Integer sydt_pk) {
		this.sydt_pk = sydt_pk;
	}
	public String getDept_simp_spell() {
		return dept_simp_spell;
	}
	public void setDept_simp_spell(String dept_simp_spell) {
		this.dept_simp_spell = dept_simp_spell;
	}
	public Integer getTbek_pk() {
		return tbek_pk;
	}
	public void setTbek_pk(Integer tbek_pk) {
		this.tbek_pk = tbek_pk;
	}
	public Integer getMap_id() {
		return map_id;
	}
	public void setMap_id(Integer map_id) {
		this.map_id = map_id;
	}
	public String getDept_flag() {
		return dept_flag;
	}
	public void setDept_flag(String dept_flag) {
		this.dept_flag = dept_flag;
	}
	public String getTbek_code() {
		return tbek_code;
	}
	public void setTbek_code(String tbek_code) {
		this.tbek_code = tbek_code;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Sysmoduleinfo(Integer dept_pk, String dept_code, String dept_name, String dept_allname, String dept_seal,
			String dept_authority, String dept_level, String dept_head, String dept_reat, String dept_tel,
			String dept_fax, String dept_addr, Integer dept_superior, Integer sydt_pk, String dept_simp_spell,
			Integer tbek_pk, Integer map_id, String dept_flag, String tbek_code) {
		super();
		this.dept_pk = dept_pk;
		this.dept_code = dept_code;
		this.dept_name = dept_name;
		this.dept_allname = dept_allname;
		this.dept_seal = dept_seal;
		this.dept_authority = dept_authority;
		this.dept_level = dept_level;
		this.dept_head = dept_head;
		this.dept_reat = dept_reat;
		this.dept_tel = dept_tel;
		this.dept_fax = dept_fax;
		this.dept_addr = dept_addr;
		this.dept_superior = dept_superior;
		this.sydt_pk = sydt_pk;
		this.dept_simp_spell = dept_simp_spell;
		this.tbek_pk = tbek_pk;
		this.map_id = map_id;
		this.dept_flag = dept_flag;
		this.tbek_code = tbek_code;
	}
	public Sysmoduleinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
