package com.cist.menupurview.model;

import java.util.List;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class SysModuleInfo {
	private Integer symi_pk;//
	private Integer symi_parent;//父类ID
	private String symi_code;//菜单代码
	private String symi_name;//菜单名称
	private String name;//菜单名称
	private Integer symi_level;//菜单级别
	private String symi_url;//菜单地址
	private Integer symi_type;//菜单类型
	private Integer symi_status;//菜单状态
	private String symi_pic_url;//菜单图片地址
	private Integer symi_flag;//菜单标准
	private String symi_tug;//全新描述
    private Boolean isLeaf=false;
    private String typename;//菜单类型名称
    private String levelname;//菜单级别名称
    private String statusname;//菜单状态名称
    private String parentname;//上级菜单名称
    
    
    public String getTypename() {
    	if(symi_type==null)
    	{
    		typename="无";
    	}
    	else if(symi_type==1)
    	{
    		typename="顶级菜单";
    	}
    	else if(symi_type==2)
    	{
    		typename="系统";
    	}
    	else if(symi_type==3)
    	{
    		typename="模块";
    	}
    	else if(symi_level==4)
    	{
    		typename="菜单";
    	}
    	else if(symi_level==5)
    	{
    		typename="操作权限";
    	}
    	
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getStatusname() {
		if(symi_status==1)
		{
			statusname="启用";
		}
		else
		{
			statusname="禁用";
			
		}
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	public String getParentname() {
//		if(null!=parentname||parentname!="")
//		{
//			parentname= SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT_PK,symi_parent.toString());
//			//parentname=SysTempStoreUtils.getparentname(symi_parent);
//		}
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	private List<SysModuleInfo> children=null;
    
    public Boolean getIsLeaf() {
		
		return isLeaf;
	}

	public List<SysModuleInfo> getChildren() {
		return children;
	}

	public void setChildren(List<SysModuleInfo> children) {
		this.children = children;
	}

	public String getLevelname() {
		if(symi_level==null)
    	{
			levelname="无";
    	}
    	else if(symi_level==1)
    	{
    		levelname="一级";
    	}
    	else if(symi_level==2)
    	{
    		levelname="二级";
    	}
    	else if(symi_level==3)
    	{
    		levelname="三级";
    	}
    	else if(symi_level==4)
    	{
    		levelname="四级";
    	}
    	else if(symi_level==5)
    	{
    		levelname="五级";
    	}
    	
		return levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}
}