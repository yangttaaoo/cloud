package com.cist.devRegister.model;

import java.util.List;


/***
 * 行政区域
 * @author wangtao
 *
 */
public class Ckreiscode {
  private Integer tbek_pk;//主键
  private String tbek_code;//行政区代码
  private String tbek_name;//行政区名称
  private Integer tbek_level;//行政区划级别关联C_KREIS_LEVEL
  private Integer tbek_parent;//父行政区划
  private String tbek_simp_spell;//简拼
  private String tbek_first_letter;//首字母
  private String tbek_mapid;//地图objectid
  private String tbek_map_box;//地图区域
  private String tbek_flag;//是否虚拟行政区划
  private List<Ckreiscode> children=null;
public Integer getTbek_pk() {
	return tbek_pk;
}
public void setTbek_pk(Integer tbek_pk) {
	this.tbek_pk = tbek_pk;
}
public String getTbek_code() {
	return tbek_code;
}
public void setTbek_code(String tbek_code) {
	this.tbek_code = tbek_code;
}
public String getTbek_name() {
	return tbek_name;
}
public void setTbek_name(String tbek_name) {
	this.tbek_name = tbek_name;
}
public Integer getTbek_level() {
	return tbek_level;
}
public void setTbek_level(Integer tbek_level) {
	this.tbek_level = tbek_level;
}
public Integer getTbek_parent() {
	return tbek_parent;
}
public void setTbek_parent(Integer tbek_parent) {
	this.tbek_parent = tbek_parent;
}
public String getTbek_simp_spell() {
	return tbek_simp_spell;
}
public void setTbek_simp_spell(String tbek_simp_spell) {
	this.tbek_simp_spell = tbek_simp_spell;
}
public String getTbek_first_letter() {
	return tbek_first_letter;
}
public void setTbek_first_letter(String tbek_first_letter) {
	this.tbek_first_letter = tbek_first_letter;
}
public String getTbek_mapid() {
	return tbek_mapid;
}
public void setTbek_mapid(String tbek_mapid) {
	this.tbek_mapid = tbek_mapid;
}
public String getTbek_map_box() {
	return tbek_map_box;
}
public void setTbek_map_box(String tbek_map_box) {
	this.tbek_map_box = tbek_map_box;
}
public String getTbek_flag() {
	return tbek_flag;
}
public void setTbek_flag(String tbek_flag) {
	this.tbek_flag = tbek_flag;
}
public List<Ckreiscode> getChildren() {
	return children;
}
public void setChildren(List<Ckreiscode> children) {
	this.children = children;
}
public Ckreiscode(Integer tbek_pk, String tbek_code, String tbek_name, Integer tbek_level, Integer tbek_parent,
		String tbek_simp_spell, String tbek_first_letter, String tbek_mapid, String tbek_map_box, String tbek_flag,
		List<Ckreiscode> children) {
	super();
	this.tbek_pk = tbek_pk;
	this.tbek_code = tbek_code;
	this.tbek_name = tbek_name;
	this.tbek_level = tbek_level;
	this.tbek_parent = tbek_parent;
	this.tbek_simp_spell = tbek_simp_spell;
	this.tbek_first_letter = tbek_first_letter;
	this.tbek_mapid = tbek_mapid;
	this.tbek_map_box = tbek_map_box;
	this.tbek_flag = tbek_flag;
	this.children = children;
}
public Ckreiscode() {
	super();
	// TODO Auto-generated constructor stub
}
  
}
