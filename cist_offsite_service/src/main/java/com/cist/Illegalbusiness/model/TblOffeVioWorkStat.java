package com.cist.Illegalbusiness.model;

import java.util.Date;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TblOffeVioWorkStat implements Comparable<TblOffeVioWorkStat> {
    private Long pk;//ID

    private String shr;//审核人（中文）

    private Integer shsl;//审核数量

    private int yxsl;//有效数量

    private int wxsl;//无效数量

    private int tpcsl;//套牌车数量

    private String ssdw;//审核人所属单位（中文）

    private String wfxwtj;//违法行为统计（JSON格式，违法行为代码：数量）

    private Date tjsj;//统计时间

    private String tjnf;//年份

    private String tjyf;//月份

    private String tjrq;//日

    private String tjxs;//小时
    
    
    private int wsh;//12日内未审核数量
    
    private int shzl;//当年审核总量
    
    private int wfsl;//12日内违法数量
    
    private int lastWeek;//上周审核有效数量
    private int week;//本周审核有效数量
    private int yestoday;//昨日审核有效数量
    private int today;//今日审核有效数量
    
    private int efficiency;//有效率
    
    private int wlastWeek;//上周违法数量
    private int wweek;//本周违法数量
    private int wyestoday;//昨日违法数量
    private int wtoday;//今日违法数量
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date wfsj;//违法时间
    
    private String sj;//时间

	private String cjdw;//采集单位

	private String dept_name;//采集单位名称
	
	public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr == null ? null : shr.trim();
    }

	public int getYxsl() {
		return yxsl;
	}

	public void setYxsl(int yxsl) {
		this.yxsl = yxsl;
	}

	public int getWxsl() {
		return wxsl;
	}

	public void setWxsl(int wxsl) {
		this.wxsl = wxsl;
	}

	public int getTpcsl() {
		return tpcsl;
	}

	public void setTpcsl(int tpcsl) {
		this.tpcsl = tpcsl;
	}

	public String getCjdw() {
		return cjdw;
	}

	public void setCjdw(String cjdw) {
		this.cjdw = cjdw;
	}

	public String getSsdw() {
        return ssdw;
    }

    public void setSsdw(String ssdw) {
        this.ssdw = ssdw == null ? null : ssdw.trim();
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

    public String getTjxs() {
        return tjxs;
    }

    public void setTjxs(String tjxs) {
        this.tjxs = tjxs == null ? null : tjxs.trim();
    }

	public int getWsh() {
		return wsh;
	}

	public void setWsh(int wsh) {
		this.wsh = wsh;
	}

	public int getWfsl() {
		return wfsl;
	}

	public void setWfsl(int wfsl) {
		this.wfsl = wfsl;
	}
	
	public String getDept_name() {
		if (cjdw != null) {
			return SysTempStoreUtils.getFcName("DP01", cjdw);
		} else {
			dept_name = "未知";
		}
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getShzl() {
		return shzl;
	}

	public void setShzl(int shzl) {
		this.shzl = shzl;
	}

	public Date getWfsj() {
		return wfsj;
	}

	public void setWfsj(Date wfsj) {
		this.wfsj = wfsj;
	}

	public String getSj() {
		return sj;
	}

	public void setSj(String sj) {
		this.sj = sj;
	}

	public int getLastWeek() {
		return lastWeek;
	}

	public void setLastWeek(int lastWeek) {
		this.lastWeek = lastWeek;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getYestoday() {
		return yestoday;
	}

	public void setYestoday(int yestoday) {
		this.yestoday = yestoday;
	}

	public int getToday() {
		return today;
	}

	public void setToday(int today) {
		this.today = today;
	}

	public int getWlastWeek() {
		return wlastWeek;
	}

	public void setWlastWeek(int wlastWeek) {
		this.wlastWeek = wlastWeek;
	}

	public int getWweek() {
		return wweek;
	}

	public void setWweek(int wweek) {
		this.wweek = wweek;
	}

	public int getWyestoday() {
		return wyestoday;
	}

	public void setWyestoday(int wyestoday) {
		this.wyestoday = wyestoday;
	}

	public int getWtoday() {
		return wtoday;
	}

	public void setWtoday(int wtoday) {
		this.wtoday = wtoday;
	}

	public Integer getShsl() {
		return shsl;
	}

	public void setShsl(Integer shsl) {
		this.shsl = shsl;
	}

	@Override
	public int compareTo(TblOffeVioWorkStat o) {
		return o.getShsl().compareTo(this.getShsl());
	}

	public int getEfficiency() {
		if(shsl!=0&&yxsl!=0)
		{
			efficiency=(int) (Math.ceil((float)yxsl/(float)shsl*100)) ;
		}
		return efficiency;
	}

	public void setEfficiency(int efficiency) {
		this.efficiency = efficiency;
	}
}