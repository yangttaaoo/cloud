package com.cist.videoMonitor.model;

/**
 * TBL_VIO_PREST_CONFIG
 * 
 * @author xh
 *
 */
public class Tbl_VioPrestConfig {
	// ID
	private int vpc_pk;
	// 设备ID（关联TBL_DEV_VIO_CONFIG表中DVC_PK字段）
	private int dvc_pk;
	// 预置点
	private int vpc_prest;
	// 预置点别名
	private String vpc_byname;

	// 无参构造
	public Tbl_VioPrestConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getVpc_pk() {
		return vpc_pk;
	}

	public void setVpc_pk(int vpc_pk) {
		this.vpc_pk = vpc_pk;
	}

	public int getDvc_pk() {
		return dvc_pk;
	}

	public void setDvc_pk(int dvc_pk) {
		this.dvc_pk = dvc_pk;
	}

	public int getVpc_prest() {
		return vpc_prest;
	}

	public void setVpc_prest(int vpc_prest) {
		this.vpc_prest = vpc_prest;
	}

	public String getVpc_byname() {
		return vpc_byname;
	}

	public void setVpc_byname(String vpc_byname) {
		this.vpc_byname = vpc_byname;
	}

}
