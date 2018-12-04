package com.cist.illegalbehavior.model;

import java.util.Date;


public class TblOffeVioWfxwStat {
    private Long pk;//ID

    private String glbm;//管理部门（中文）

    private String wfxwtj;//违法行为统计（JSON格式，违法行为代码：数量）

    private Date tjsj;//统计时间

    private String tjnf;//年份

    private String tjyf;//月份

    private String tjrq;//日

    public String name;  
    
    public int value;
    
	public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getGlbm() {
        return glbm;
    }

    public void setGlbm(String glbm) {
        this.glbm = glbm == null ? null : glbm.trim();
    }

    public String getWfxwtj() {
        return wfxwtj;
    }

    public void setWfxwtj(String wfxwtj) {
        this.wfxwtj = wfxwtj == null ? null : wfxwtj.trim();
    }

    public Date getTjsj() {
        return tjsj;
    }

    public void setTjsj(Date tjsj) {
        this.tjsj = tjsj;
    }

    public String getTjnf() {
        return tjnf;
    }

    public void setTjnf(String tjnf) {
        this.tjnf = tjnf == null ? null : tjnf.trim();
    }

    public String getTjyf() {
        return tjyf;
    }

    public void setTjyf(String tjyf) {
        this.tjyf = tjyf == null ? null : tjyf.trim();
    }

    public String getTjrq() {
        return tjrq;
    }

    public void setTjrq(String tjrq) {
        this.tjrq = tjrq == null ? null : tjrq.trim();
    }



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}



}