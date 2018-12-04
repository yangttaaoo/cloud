package com.cist.recheck.model;

import java.io.Serializable;

public class TblOffeCateInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6442086809702416953L;

	private Integer tboc_pk;

    private String tboc_code;

    private String tboc_name;

    private String tboc_short_name;

    private Integer tboc_points;

    private String tboc_fines;

    private String tboc_legal;

    private String tboc_desc;
	public Integer getTboc_pk() {
		return tboc_pk;
	}

	public void setTboc_pk(Integer tboc_pk) {
		this.tboc_pk = tboc_pk;
	}

	public String getTboc_code() {
		return tboc_code;
	}

	public void setTboc_code(String tboc_code) {
		this.tboc_code = tboc_code;
	}

	public String getTboc_name() {
		return tboc_name;
	}
	
	
	public void setTboc_name(String tboc_name) {
		this.tboc_name = tboc_name;
	}

	public String getTboc_short_name() {
		return tboc_short_name;
	}

	public void setTboc_short_name(String tboc_short_name) {
		this.tboc_short_name = tboc_short_name;
	}

	public Integer getTboc_points() {
		return tboc_points;
	}

	public void setTboc_points(Integer tboc_points) {
		this.tboc_points = tboc_points;
	}

	public String getTboc_fines() {
		return tboc_fines;
	}

	public void setTboc_fines(String tboc_fines) {
		this.tboc_fines = tboc_fines;
	}

	public String getTboc_legal() {
		return tboc_legal;
	}

	public void setTboc_legal(String tboc_legal) {
		this.tboc_legal = tboc_legal;
	}

	public String getTboc_desc() {
		return tboc_desc;
	}

	public void setTboc_desc(String tboc_desc) {
		this.tboc_desc = tboc_desc;
	}




}