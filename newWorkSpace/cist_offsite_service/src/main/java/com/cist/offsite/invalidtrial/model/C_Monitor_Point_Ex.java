package com.cist.offsite.invalidtrial.model;

import java.io.Serializable;
import java.util.List;
/**
 * 监控点点位表
 * @author Administrator
 *
 */
public class C_Monitor_Point_Ex implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 444284959548285089L;
	private Integer m_pk; // 主键
	private String m_dept_code; // 管理部门代码
	private String m_type_pk; // 点位类型（关联SYS_FRM_CODE表中FC_CODE字段）
	private String m_road_code; // 所属道路代码
	private String m_name; // 点位名称
	private String m_code; // 点位代码
	private String m_byname; // 点位别名
	private String m_kreis_code;// 行政区划代码
	private Double m_mapx; // 经度
	private Double m_mapy; // 纬度
	private String m_address; // 所在地点
	private String m_dept_name; //管理部门名称
	private int num;//统计数据
	private String m_road_name; // 所属道路名称
	private String m_kreis_name;
	private String m_type; // 点位类型（关联SYS_FRM_CODE表中FC_CODE字段）
	
	 private List<Tbl_dev_vio_config> children=null;
	public String getM_dept_name() {
		return m_dept_name;
	}
	
	public void setM_dept_name(String m_dept_name) {
		this.m_dept_name = m_dept_name;
	}

	public Integer getM_pk() {
		return m_pk;
	}

	public void setM_pk(Integer m_pk) {
		this.m_pk = m_pk;
	}

	public String getM_dept_code() {
		return m_dept_code;
	}

	public void setM_dept_code(String m_dept_code) {
		this.m_dept_code = m_dept_code;
	}

	public String getM_type_pk() {
		return m_type_pk;
	}

	public void setM_type_pk(String m_type_pk) {
		this.m_type_pk = m_type_pk;
	}

	public String getM_road_code() {
		return m_road_code;
	}

	public void setM_road_code(String m_road_code) {
		this.m_road_code = m_road_code;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_code() {
		return m_code;
	}

	public void setM_code(String m_code) {
		this.m_code = m_code;
	}

	public String getM_byname() {
		return m_byname;
	}

	public void setM_byname(String m_byname) {
		this.m_byname = m_byname;
	}

	public String getM_kreis_code() {
		if(m_kreis_code!=null)
		{
			return m_kreis_code.trim();
		}
		return m_kreis_code;
	}

	public void setM_kreis_code(String m_kreis_code) {
		this.m_kreis_code = m_kreis_code;
	}

	public Double getM_mapx() {
		return m_mapx;
	}

	public void setM_mapx(Double m_mapx) {
		this.m_mapx = m_mapx;
	}

	public Double getM_mapy() {
		return m_mapy;
	}

	public void setM_mapy(Double m_mapy) {
		this.m_mapy = m_mapy;
	}

	public String getM_address() {
		return m_address;
	}

	public void setM_address(String m_address) {
		this.m_address = m_address;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getM_road_name() {
		return m_road_name;
	}

	public void setM_road_name(String m_road_name) {
		this.m_road_name = m_road_name;
	}

	public String getM_kreis_name() {
		/*if (null!=m_kreis_code){
			return SysTempStoreUtils.getKreisName(m_kreis_code);
		}*/
		return m_kreis_name;
	}

	public void setM_kreis_name(String m_kreis_name) {
		this.m_kreis_name = m_kreis_name;
	}

	public String getM_type() {
		return m_type;
	}

	public void setM_type(String m_type) {
		this.m_type = m_type;
	}

	public List<Tbl_dev_vio_config> getChildren() {
		return children;
	}

	public void setChildren(List<Tbl_dev_vio_config> children) {
		this.children = children;
	}

}
