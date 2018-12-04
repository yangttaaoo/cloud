package com.cist.qwgl.qwpb.model;

import java.io.Serializable;
/**
 * 勤务区域
 * @author hy
 *
 */
import java.util.List;
public class QWGL_QWPB_QWQY implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1348289065988473274L;
	private String qw_qy;//勤务区域
	private List<String> sj;//时间
	private Integer mj_num;//民警数量
	private String mj_name;//民警姓名
	private Integer xj_num;//协警数量
	private String xj_name;//协警姓名
	private Integer cl_num;//车辆数量
	private String cl_hphm;//车辆号牌号码
	public String getQw_qy() {
		return qw_qy;
	}
	public void setQw_qy(String qw_qy) {
		this.qw_qy = qw_qy;
	}
	public List<String> getSj() {
		return sj;
	}
	public void setSj(List<String> sj) {
		this.sj = sj;
	}
	public Integer getMj_num() {
		return mj_num;
	}
	public void setMj_num(Integer mj_num) {
		this.mj_num = mj_num;
	}
	public String getMj_name() {
		return mj_name;
	}
	public void setMj_name(String mj_name) {
		this.mj_name = mj_name;
	}
	public Integer getXj_num() {
		return xj_num;
	}
	public void setXj_num(Integer xj_num) {
		this.xj_num = xj_num;
	}
	public String getXj_name() {
		return xj_name;
	}
	public void setXj_name(String xj_name) {
		this.xj_name = xj_name;
	}
	public Integer getCl_num() {
		return cl_num;
	}
	public void setCl_num(Integer cl_num) {
		this.cl_num = cl_num;
	}
	public String getCl_hphm() {
		return cl_hphm;
	}
	public void setCl_hphm(String cl_hphm) {
		this.cl_hphm = cl_hphm;
	}
	
}
