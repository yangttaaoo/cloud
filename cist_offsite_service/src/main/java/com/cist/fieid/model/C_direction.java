package com.cist.fieid.model;
/**
 * 行驶方向
 * @author hy
 *
 */
public class C_direction {
	private Integer pk;
	private String dir_code;//code编码
	private String dir_name;//方向名称
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getDir_code() {
		return dir_code;
	}
	public void setDir_code(String dir_code) {
		this.dir_code = dir_code;
	}
	public String getDir_name() {
		return dir_name;
	}
	public void setDir_name(String dir_name) {
		this.dir_name = dir_name;
	}
	
}
