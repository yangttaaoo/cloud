/**  

* <p>Title: ConfigUrlBean.java</p>  

* <p>Description: </p>    

* @author zah  

* @date 2018年9月28日  

* @version 1.0  

*/
package com.cist.configUrl.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ConfigUrlBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年9月28日
 * 
 */
@Component("configUrlBean")
@ConfigurationProperties(prefix="cist.pro")
public class ConfigUrlBean {

	private String picFtpUrl = "51.56.81.6";
	private String picFtpPort = "21";
	private String picHttpUrl = "51.56.81.6";
	private String picHttpPort = "6120";

	private String ftpUser = "pic";

	private String ftpPwd = "123456";
	private String privatekey = "";
	private String httpUser = "pic";
	
	private String httpPwd = "123456";

	public String getFtpPwd() {
		return ftpPwd;
	}

	public String getFtpUser() {
		return ftpUser;
	}

	public String getHttpPwd() {
		return httpPwd;
	}

	public String getHttpUser() {
		return httpUser;
	}

	/**
	 * @return the picFtpPort
	 */
	public String getPicFtpPort() {
		return picFtpPort;
	}

	/**
	 * @return the picFtpUrl
	 */
	public String getPicFtpUrl() {
		return picFtpUrl;
	}

	/**
	 * @return the picHttpPort
	 */
	public String getPicHttpPort() {
		return picHttpPort;
	}

	public String getPicHttpUrl() {
		return picHttpUrl;
	}

	public String getPrivatekey() {
		return privatekey;
	}

	public void setFtpPwd(String ftpPwd) {
		this.ftpPwd = ftpPwd;
	}
	public void setFtpUser(String ftpUser) {
		this.ftpUser = ftpUser;
	}
	
	public void setHttpPwd(String httpPwd) {
		this.httpPwd = httpPwd;
	}

	public void setHttpUser(String httpUser) {
		this.httpUser = httpUser;
	}

	/**
	 * @param picFtpPort
	 *            the picFtpPort to set
	 */
	public void setPicFtpPort(String picFtpPort) {
		this.picFtpPort = picFtpPort;
	}

	/**
	 * @param picFtpUrl
	 *            the picFtpUrl to set
	 */
	public void setPicFtpUrl(String picFtpUrl) {
		this.picFtpUrl = picFtpUrl;
	}

	/**
	 * @param picHttpPort
	 *            the picHttpPort to set
	 */
	public void setPicHttpPort(String picHttpPort) {
		this.picHttpPort = picHttpPort;
	}

	public void setPicHttpUrl(String picHttpUrl) {
		this.picHttpUrl = picHttpUrl;
	}

	public void setPrivatekey(String privatekey) {
		this.privatekey = privatekey;
	}
}
