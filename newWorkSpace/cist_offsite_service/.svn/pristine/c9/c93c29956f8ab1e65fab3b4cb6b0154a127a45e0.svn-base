package com.cist.patrolplan.model;


public class Need {
	private String dept_pk; // 管理部门代码
	private String dvc_name; // 摄像机名称
	private String vcc_name;// 巡逻名称
	private String dept_name;//管理部门名称
	
	public String getDept_name() {
	/*	if (null != dept_pk) {
			return SysTempStoreUtils.getDept(dept_pk);
		}*/
		return dept_name;
	}
	
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_pk() {
		return dept_pk;
	}
	
	public void setDept_pk(String dept_pk) {
		this.dept_pk = dept_pk;
	}

	public String getDvc_name() {
		return dvc_name;
	}
	
	public void setDvc_name(String dvc_name) {
		this.dvc_name = dvc_name;
	}

	public String getVcc_name() {
		return vcc_name;
	}

	public void setVcc_name(String vcc_name) {
		this.vcc_name = vcc_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dept_pk == null) ? 0 : dept_pk.hashCode());
		result = prime * result + ((dvc_name == null) ? 0 : dvc_name.hashCode());
		result = prime * result + ((vcc_name == null) ? 0 : vcc_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Need other = (Need) obj;
		if (dept_pk == null) {
			if (other.dept_pk != null)
				return false;
		} else if (!dept_pk.equals(other.dept_pk))
			return false;
		if (dvc_name == null) {
			if (other.dvc_name != null)
				return false;
		} else if (!dvc_name.equals(other.dvc_name))
			return false;
		if (vcc_name == null) {
			if (other.vcc_name != null)
				return false;
		} else if (!vcc_name.equals(other.vcc_name))
			return false;
		return true;
	}
	

}
