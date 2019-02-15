/**  

* <p>Title: UserDetails.java</p>  

* <p>Description: </p>    

* @author zah  

* @date 2018年8月29日  

* @version 1.0  

*/  
package com.cist.login.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**  
    * @ClassName: UserDetails  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author Administrator  
    * @date 2018年8月29日  
    *    
    */
public class UserDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 111111L;
	private long sypi_pk;
	private String sypi_name;
	private String sypi_code;
	private String sypi_dept_name;
	private String sypi_dept_code;
	private String sypi_dept_pk;
	private String sypi_status;
	private String sypi_status_name;
	private Date sypi_avp;
	private Date sypi_pvp;
	private String sypi_comp;
	private Map<String,Object> authorityMap; 
	/**
	 * @return the authorityMap
	 */
	public Map<String, Object> getAuthorityMap() {
		return authorityMap;
	}
	/**
	 * @param authorityMap the authorityMap to set
	 */
	public void setAuthorityMap(Map<String, Object> authorityMap) {
		this.authorityMap = authorityMap;
	}
	/**
	 * @return the sypi_comp
	 */
	public String getSypi_comp() {
		return sypi_comp;
	}
	/**
	 * @param sypi_comp the sypi_comp to set
	 */
	public void setSypi_comp(String sypi_comp) {
		this.sypi_comp = sypi_comp;
	}
	private Set<Authority> authority;
	/**
	 * @return the authority
	 */
	public Set<Authority> getAuthority() {
		return authority;
	}
	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(Set<Authority> authority) {
		this.authority = authority;
	}
	/**
	 * @return the sypi_pk
	 */
	public long getSypi_pk() {
		return sypi_pk;
	}
	/**
	 * @param sypi_pk the sypi_pk to set
	 */
	public void setSypi_pk(long sypi_pk) {
		this.sypi_pk = sypi_pk;
	}
	/**
	 * @return the sypi_name
	 */
	public String getSypi_name() {
		return sypi_name;
	}
	/**
	 * @param sypi_name the sypi_name to set
	 */
	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}
	/**
	 * @return the sypi_code
	 */
	public String getSypi_code() {
		return sypi_code;
	}
	/**
	 * @param sypi_code the sypi_code to set
	 */
	public void setSypi_code(String sypi_code) {
		this.sypi_code = sypi_code;
	}
	/**
	 * @return the sypi_dept_name
	 */
	public String getSypi_dept_name() {
		return sypi_dept_name;
	}
	/**
	 * @param sypi_dept_name the sypi_dept_name to set
	 */
	public void setSypi_dept_name(String sypi_dept_name) {
		this.sypi_dept_name = sypi_dept_name;
	}
	/**
	 * @return the sypi_dept_code
	 */
	public String getSypi_dept_code() {
		return sypi_dept_code;
	}
	/**
	 * @param sypi_dept_code the sypi_dept_code to set
	 */
	public void setSypi_dept_code(String sypi_dept_code) {
		this.sypi_dept_code = sypi_dept_code;
	}
	/**
	 * @return the sypi_dept_pk
	 */
	public String getSypi_dept_pk() {
		return sypi_dept_pk;
	}
	/**
	 * @param sypi_dept_pk the sypi_dept_pk to set
	 */
	public void setSypi_dept_pk(String sypi_dept_pk) {
		this.sypi_dept_pk = sypi_dept_pk;
	}
	/**
	 * @return the sypi_status
	 */
	public String getSypi_status() {
		return sypi_status;
	}
	/**
	 * @param sypi_status the sypi_status to set
	 */
	public void setSypi_status(String sypi_status) {
		this.sypi_status = sypi_status;
	}
	/**
	 * @return the sypi_status_name
	 */
	public String getSypi_status_name() {
		return sypi_status_name;
	}
	/**
	 * @param sypi_status_name the sypi_status_name to set
	 */
	public void setSypi_status_name(String sypi_status_name) {
		this.sypi_status_name = sypi_status_name;
	}
	/**
	 * @return the sypi_avp
	 */
	public Date getSypi_avp() {
		return sypi_avp;
	}
	/**
	 * @param sypi_avp the sypi_avp to set
	 */
	public void setSypi_avp(Date sypi_avp) {
		this.sypi_avp = sypi_avp;
	}
	/**
	 * @return the sypi_pvp
	 */
	public Date getSypi_pvp() {
		return sypi_pvp;
	}
	/**
	 * @param sypi_pvp the sypi_pvp to set
	 */
	public void setSypi_pvp(Date sypi_pvp) {
		this.sypi_pvp = sypi_pvp;
	}
}
