package com.cist.patrolplan.model;

public class SpjkVioPrestConfig {

	private long vpc_pk;//ID
	private Integer pk_id;//设备ID（关联JCSJ_DEVICE表中PK_ID字段）
	private Integer vpc_prest;//预制点
	private String vpc_byname;//预置点别名
	public long getVpc_pk() {
		return vpc_pk;
	}
	public void setVpc_pk(long vpc_pk) {
		this.vpc_pk = vpc_pk;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
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
