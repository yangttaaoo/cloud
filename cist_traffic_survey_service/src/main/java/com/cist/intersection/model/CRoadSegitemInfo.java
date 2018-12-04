package com.cist.intersection.model;

import java.util.List;
import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class CRoadSegitemInfo {
    private Long pk;//ID

    private String glbm;//管理部门代码（关联SYS_DEPART_INFO表中DEPT_CODE字段）

    private String dldm;//道路代码（关联C_ROAD_ITEM表中ROIM_CODE字段）

    private String lkdm;//路口代码

    private String lkmc;//路口名称

    private String lklx;//路口类型（参考SYS_FRM_CODE表 FCT_CODE=3120）

    private String lmjg;//路面结构（参考SYS_FRM_CODE表 FCT_CODE=3119）

    private String dlxx;//道路线型（参考SYS_FRM_CODE表 FCT_CODE=3123）

    private String xzqh;//行政区划（关联C_KREIS_CODE表中TBEK_CODE字段）

    private Integer qsms;//起始米数

    private Integer jsms;//结束米数

    private String pic;//路口渠化图
    
    private String lklxname;//路口类型名称
    
    private String lmjgname;//路面结构名称
    
//    private String dllxname;//道路类型名称
    
    private String roim_name;//所属道路名称
    
    private String tbek_name;//行政区划名称
    
    private String dept_name;//部门名称
    
    private List<TblSegitemSignal> xkfalist;//路口下的信控方案

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

    public String getDldm() {
        return dldm;
    }

    public void setDldm(String dldm) {
        this.dldm = dldm == null ? null : dldm.trim();
    }

    public String getLkdm() {
        return lkdm;
    }

    public void setLkdm(String lkdm) {
        this.lkdm = lkdm == null ? null : lkdm.trim();
    }

    public String getLkmc() {
        return lkmc;
    }

    public void setLkmc(String lkmc) {
        this.lkmc = lkmc == null ? null : lkmc.trim();
    }

    public String getLklx() {
        return lklx;
    }

    public void setLklx(String lklx) {
        this.lklx = lklx == null ? null : lklx.trim();
    }

    public String getLmjg() {
        return lmjg;
    }

    public void setLmjg(String lmjg) {
        this.lmjg = lmjg == null ? null : lmjg.trim();
    }

    public String getDlxx() {
        return dlxx;
    }

    public void setDlxx(String dlxx) {
        this.dlxx = dlxx == null ? null : dlxx.trim();
    }

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh == null ? null : xzqh.trim();
    }

    public Integer getQsms() {
        return qsms;
    }

    public void setQsms(Integer qsms) {
        this.qsms = qsms;
    }

    public Integer getJsms() {
        return jsms;
    }

    public void setJsms(Integer jsms) {
        this.jsms = jsms;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }


	public List<TblSegitemSignal> getXkfalist() {
		return xkfalist;
	}

	public void setXkfalist(List<TblSegitemSignal> xkfalist) {
		this.xkfalist = xkfalist;
	}

	public String getDept_name() {
		if(glbm!=null)
		{
			dept_name=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, glbm);	
		}
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getLklxname() {
		if(lklx!=null){
			//路口类型名称
			lklxname = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_LKLX, lklx);	
		}
		return lklxname;
	}

	public void setLklxname(String lklxname) {
		this.lklxname = lklxname;
	}

	public String getLmjgname() {
		
		lmjgname = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_LMJG, lmjg);
		return lmjgname;
	}

	public void setLmjgname(String lmjgname) {
		this.lmjgname = lmjgname;
	}

//	public String getDllxname() {
//		return dllxname;
//	}
//
//	public void setDllxname(String dllxname) {
//		this.dllxname = dllxname;
//	}

	public String getRoim_name() {
		return roim_name;
	}

	public void setRoim_name(String roim_name) {
		this.roim_name = roim_name;
	}

	public String getTbek_name() {
		return tbek_name;
	}

	public void setTbek_name(String tbek_name) {
		this.tbek_name = tbek_name;
	}


}