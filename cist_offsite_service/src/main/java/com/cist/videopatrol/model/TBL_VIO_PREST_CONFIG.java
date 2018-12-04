package com.cist.videopatrol.model;

import java.io.Serializable;
/**
 * 摄像机预置点表
 * @author hy
 *
 */
public class TBL_VIO_PREST_CONFIG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6019444900355120603L;
	private Integer vpc_pk;//id
	private Integer dvc_pk;//设备ID（关联TBL_DEV_VIO_CONFIG表）
	private Integer vpc_prest;//预制点
	private String vpc_byname;//预置点别名
	public Integer getVpc_pk() {
		return vpc_pk;
	}
	public void setVpc_pk(Integer vpc_pk) {
		this.vpc_pk = vpc_pk;
	}
	public Integer getDvc_pk() {
		return dvc_pk;
	}
	public void setDvc_pk(Integer dvc_pk) {
		this.dvc_pk = dvc_pk;
	}
	public Integer getVpc_prest() {
		return vpc_prest;
	}
	public void setVpc_prest(Integer vpc_prest) {
		this.vpc_prest = vpc_prest;
	}
	public String getVpc_byname() {
		return vpc_byname;
	}
	public void setVpc_byname(String vpc_byname) {
		this.vpc_byname = vpc_byname;
	}
	
}
