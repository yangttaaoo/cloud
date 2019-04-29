/**  

* <p>Title: Authority.java</p>  

* <p>Description: </p>    

* @author zah  

* @date 2018年8月29日  

* @version 1.0  

*/
package com.cist.login.model;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * @ClassName: Authority
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年8月29日
 * 
 */
public class Authority implements Serializable,Comparable<Authority>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Authority(){
		
	}
	
	public Authority(String symi_name,int symi_level){
		this.symi_name = symi_name;
		this.symi_level = symi_level;
	}

	private long sypi_pk;

	/**
	 * @return the sypi_pk
	 */
	public long getSypi_pk() {
		return sypi_pk;
	}

	/**
	 * @param sypi_pk
	 *            the sypi_pk to set
	 */
	public void setSypi_pk(long sypi_pk) {
		this.sypi_pk = sypi_pk;
	}

	private TreeSet<Authority> child = new TreeSet<Authority>();
	private long symi_pk;
	private String symi_code;
	private long symi_parent;
	private String symi_name;
	private String symi_url;
	private int symi_level;
	private int symi_type;
	private int symi_status;
	private String symi_tug;
	private String symi_pic_url;
	private Boolean menu_status = false;
	/**
	 * @return the symi_tug
	 */
	public String getSymi_tug() {
		return symi_tug;
	}

	/**
	 * @param symi_tug the symi_tug to set
	 */
	public void setSymi_tug(String symi_tug) {
		this.symi_tug = symi_tug;
	}

	/**
	 * @return the symi_pic_url
	 */
	public String getSymi_pic_url() {
		return symi_pic_url;
	}

	/**
	 * @param symi_pic_url the symi_pic_url to set
	 */
	public void setSymi_pic_url(String symi_pic_url) {
		this.symi_pic_url = symi_pic_url;
	}

	/**
	 * @return the children
	 */
	public TreeSet<Authority> getChild() {
		return child;
	}

	/**
	 * @param children the children to set
	 */
	public void setChild(TreeSet<Authority> child) {
		this.child = child;
	}

	/**
	 * @return the symi_pk
	 */
	public long getSymi_pk() {
		return symi_pk;
	}

	/**
	 * @param symi_pk
	 *            the symi_pk to set
	 */
	public void setSymi_pk(long symi_pk) {
		this.symi_pk = symi_pk;
	}

	/**
	 * @return the symi_code
	 */
	public String getSymi_code() {
		return symi_code;
	}

	/**
	 * @param symi_code
	 *            the symi_code to set
	 */
	public void setSymi_code(String symi_code) {
		this.symi_code = symi_code;
	}

	/**
	 * @return the symi_parent
	 */
	public long getSymi_parent() {
		return symi_parent;
	}

	/**
	 * @param symi_parent
	 *            the symi_parent to set
	 */
	public void setSymi_parent(long symi_parent) {
		this.symi_parent = symi_parent;
	}

	/**
	 * @return the symi_name
	 */
	public String getSymi_name() {
		return symi_name;
	}

	/**
	 * @param symi_name
	 *            the symi_name to set
	 */
	public void setSymi_name(String symi_name) {
		this.symi_name = symi_name;
	}

	/**
	 * @return the symi_url
	 */
	public String getSymi_url() {
		return symi_url;
	}

	/**
	 * @param symi_url
	 *            the symi_url to set
	 */
	public void setSymi_url(String symi_url) {
		this.symi_url = symi_url;
	}

	/**
	 * @return the symi_level
	 */
	public int getSymi_level() {
		return symi_level;
	}

	/**
	 * @param symi_level
	 *            the symi_level to set
	 */
	public void setSymi_level(int symi_level) {
		this.symi_level = symi_level;
	}

	/**
	 * @return the symi_type
	 */
	public int getSymi_type() {
		return symi_type;
	}

	/**
	 * @param symi_type
	 *            the symi_type to set
	 */
	public void setSymi_type(int symi_type) {
		this.symi_type = symi_type;
	}

	/**
	 * @return the symi_status
	 */
	public int getSymi_status() {
		return symi_status;
	}

	/**
	 * @param symi_status
	 *            the symi_status to set
	 */
	public void setSymi_status(int symi_status) {
		this.symi_status = symi_status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Authority o) {
		if(null==this.symi_code){
			return -1;
		}
		if(null==o.symi_code){
			return 1;
		}
		if(this.symi_parent==o.symi_parent){
			if(this.symi_code.compareTo(o.symi_code)==0){
				return 1;
			}else{
				return this.symi_code.compareTo(o.symi_code);
			}
		}else{
			return this.symi_code.compareTo(o.symi_code);
		}
		
	}

	public Boolean getMenu_status() {
		return menu_status;
	}

	public void setMenu_status(Boolean menu_status) {
		this.menu_status = menu_status;
	}
	
}
