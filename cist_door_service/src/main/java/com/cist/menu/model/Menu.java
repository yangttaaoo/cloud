/**
 * 
 */
package com.cist.menu.model;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单
 *
 */
public class Menu implements Serializable{
	private static final long serialVersionUID = 3826667444130665918L;
	private Integer symi_pk;//
	private Integer symi_parent;//父类ID
	private String symi_code;//菜单代码
	private String symi_name;//菜单名称
	private String name;//菜单名称
	private String names;//
	private Integer symi_level;//菜单级别
	private String symi_url;//菜单地址
	private Integer symi_type;//菜单类型
	private Integer symi_status;//菜单状态
	private String symi_pic_url;//菜单图片地址
	private Integer symi_flag;//菜单标准
	private String symi_tug;//全新描述
	private List<Menu> child;//子菜单
	 private Boolean isLeaf=false;
	 private Boolean isshangji=false;
	 
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public Boolean getIsshangji() {
		return isshangji;
	}
	public void setIsshangji(Boolean isshangji) {
		this.isshangji = isshangji;
	}
	public Boolean getIsLeaf() {
		if(null==child&&child.size()==0) {
			return true;
		}
		return isLeaf;
	}
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public String getName() {
		if(null!=symi_name){
			return symi_name;
		}
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Menu> getChild() {
		return child;
	}
	public void setChild(List<Menu> child) {
		this.child = child;
	}
	public Integer getSymi_pk() {
		return symi_pk;
	}
	public void setSymi_pk(Integer symi_pk) {
		this.symi_pk = symi_pk;
	}
	public Integer getSymi_parent() {
		return symi_parent;
	}
	public void setSymi_parent(Integer symi_parent) {
		this.symi_parent = symi_parent;
	}
	public String getSymi_code() {
		return symi_code;
	}
	public void setSymi_code(String symi_code) {
		this.symi_code = symi_code;
	}
	public String getSymi_name() {
		return symi_name;
	}
	public void setSymi_name(String symi_name) {
		this.symi_name = symi_name;
	}
	public Integer getSymi_level() {
		return symi_level;
	}
	public void setSymi_level(Integer symi_level) {
		this.symi_level = symi_level;
	}
	public String getSymi_url() {
		return symi_url;
	}
	public void setSymi_url(String symi_url) {
		this.symi_url = symi_url;
	}
	public Integer getSymi_type() {
		return symi_type;
	}
	public void setSymi_type(Integer symi_type) {
		this.symi_type = symi_type;
	}
	public Integer getSymi_status() {
		return symi_status;
	}
	public void setSymi_status(Integer symi_status) {
		this.symi_status = symi_status;
	}
	public String getSymi_pic_url() {
		return symi_pic_url;
	}
	public void setSymi_pic_url(String symi_pic_url) {
		this.symi_pic_url = symi_pic_url;
	}
	public Integer getSymi_flag() {
		return symi_flag;
	}
	public void setSymi_flag(Integer symi_flag) {
		this.symi_flag = symi_flag;
	}
	public String getSymi_tug() {
		return symi_tug;
	}
	public void setSymi_tug(String symi_tug) {
		this.symi_tug = symi_tug;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(Integer symi_pk, Integer symi_parent, String symi_code,
			String symi_name, Integer symi_level, String symi_url,
			Integer symi_type, Integer symi_status, String symi_pic_url,
			Integer symi_flag, String symi_tug) {
		super();
		this.symi_pk = symi_pk;
		this.symi_parent = symi_parent;
		this.symi_code = symi_code;
		this.symi_name = symi_name;
		this.symi_level = symi_level;
		this.symi_url = symi_url;
		this.symi_type = symi_type;
		this.symi_status = symi_status;
		this.symi_pic_url = symi_pic_url;
		this.symi_flag = symi_flag;
		this.symi_tug = symi_tug;
	}
	
}
