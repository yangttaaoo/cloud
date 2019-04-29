package com.cist.illegalbehavior.model;

import java.util.Date;

public class TblWfxwWfddStat  implements Comparable<TblWfxwWfddStat>{
    private Long pk;//ID

    private String wfddmc;//违法地点名称

    private Integer cjzs;//采集总数

    private Integer yxs;//有效数

    private Integer wxs;//无效数

    private String yxl;//有效率

    private String wfxwtj;//违法行为统计（JSON格式，违法行为代码：数量）

    private Date tjsj;//统计时间（格式：YYYY-MM-dd）

    private String tjnf;//年份

    private String tjyf;//月份

    private String tjrq;//日
    
    private String percent;//日
    
    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getWfddmc() {
        return wfddmc;
    }

    public void setWfddmc(String wfddmc) {
        this.wfddmc = wfddmc == null ? null : wfddmc.trim();
    }

    public Integer getCjzs() {
        return cjzs;
    }

    public void setCjzs(Integer cjzs) {
        this.cjzs = cjzs;
    }

    public Integer getYxs() {
        return yxs;
    }

    public void setYxs(Integer yxs) {
        this.yxs = yxs;
    }

    public Integer getWxs() {
        return wxs;
    }

    public void setWxs(Integer wxs) {
        this.wxs = wxs;
    }

    public String getYxl() {
        return yxl;
    }

    public void setYxl(String yxl) {
        this.yxl = yxl == null ? null : yxl.trim();
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

	@Override
	public int compareTo(TblWfxwWfddStat o) {
		return o.getCjzs().compareTo(this.getCjzs());
	}

	public String getPercent() {
		if(yxs!=0&&cjzs!=0)
		{
			percent=(int) (Math.ceil((float)yxs/(float)cjzs*100))+"%";
		}
		else
		{
			percent="0%";
		}
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}
}