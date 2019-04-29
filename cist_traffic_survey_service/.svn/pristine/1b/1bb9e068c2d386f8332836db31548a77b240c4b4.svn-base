package com.cist.roadsection.model;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class CRoadItemInfo {
    private Integer roim_pk;//ID

    private String dept_code;//管理部门代码（关联SYS_DEPART_INFO表中DEPT_CODE字段）

    private String roim_code;//路段代码

    private String tbek_code;//行政区划代码，以逗号分隔的行政区划字符串（关联C_KREIS_CODE表中TBEK_CODE字段）

    private String roim_name;//路段名称

    private String roim_type;//道路类型（参考SYS_FRM_CODE表 FCT_CODE=R007）

    private String roim_ldlx;//路段类型（参考SYS_FRM_CODE表 FCT_CODE=3120）

    private String roim_qsmc;//起点名称

    private String roim_jsmc;//结束点名称

    private String roim_lc;//里程，非城市道路采集，单位：公里

    private String roim_qs;//里程起始，非城市道路采集，单位：公里

    private String roim_js;//里程结束，非城市道路采集，单位：公里

    private Integer roim_xqlc;//辖区里程，单位：公里

    private String roim_lmlx;//路面类型（参考SYS_FRM_CODE表 FCT_CODE=3123）

    private String roim_lmjg;//路面结构（参考SYS_FRM_CODE表 FCT_CODE=3119）

    private String roim_sjss;//设计时速 单位：KM/小时

    private String roim_tcrq;//通车日期，格式：YYYY-MM-dd

    private String roim_lflc;//绿化里程

    private String roim_cds;//车道数

    private String roim_ljlx;//路肩类型（参考SYS_FRM_CODE表 FCT_CODE=R008）

    private String roim_lykd;//路远宽度

    private String roim_lkpddj;//路况评定等级（参考SYS_FRM_CODE表 FCT_CODE=F001）

    private String roim_pic;//道路断面示意图
    
    private String roim_qz;//起止地点 如： 起点————终点
    
    private String tbek_name;//行政区划中文名称 使用code去查找对应的
    
    private String dept_name;//管理部门中文名称 使用code去查找对应的
    
    private String ldlxname;//路段类型名称
    
    private String lmlxname;//路面类型名称

	private String lmjgname;//路面结构名称
	
    private String ljlxname;//路肩类型名称
    
    private String lkpdname;//路况评定名称
    public String getLdlxname() {
    
		if(roim_ldlx!=null){
			ldlxname=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_LKLX, roim_ldlx);
		}
		return ldlxname;
	}

	public void setLdlxname(String ldlxname) {
		this.ldlxname = ldlxname;
	}

	public String getLmlxname() {
	    
			if(roim_lmlx!=null){
				lmlxname=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_LMLX, roim_lmlx);
			}
		return lmlxname;
	}

	public void setLmlxname(String lmlxname) {
		this.lmlxname = lmlxname;
	}

	public String getLmjgname() {
	    
			if(roim_lmjg!=null){
				lmjgname=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_LMJG, roim_lmjg);
			}
		return lmjgname;
	}

	public void setLmjgname(String lmjgname) {
		this.lmjgname = lmjgname;
	}

	public String getLjlxname() {
		
		if(roim_ljlx!=null){
			ljlxname=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_LJLX, roim_ljlx);
		}
		return ljlxname;
	}

	public void setLjlxname(String ljlxname) {
		this.ljlxname = ljlxname;
	}

	public String getLkpdname() {
		if(roim_lkpddj!=null){
			lkpdname=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_LKPDDJ, roim_lkpddj);
		}
		return lkpdname;
	}

	public void setLkpdname(String lkpdname) {
		this.lkpdname = lkpdname;
	}

    
	public Integer getRoim_pk() {
		return roim_pk;
	}

	public void setRoim_pk(Integer roim_pk) {
		this.roim_pk = roim_pk;
	}

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	public String getRoim_code() {
		return roim_code;
	}

	public void setRoim_code(String roim_code) {
		this.roim_code = roim_code;
	}

	public String getTbek_code() {
		return tbek_code;
	}

	public void setTbek_code(String tbek_code) {
		this.tbek_code = tbek_code;
	}

	public String getRoim_name() {
		return roim_name;
	}

	public void setRoim_name(String roim_name) {
		this.roim_name = roim_name;
	}

	public String getRoim_type() {
		if(roim_type!=null&&roim_type!="")
		{
			roim_type=roim_type.trim();
		}
		return roim_type;
	}

	public void setRoim_type(String roim_type) {
		this.roim_type = roim_type;
	}

	public String getRoim_ldlx() {
		return roim_ldlx;
	}

	public void setRoim_ldlx(String roim_ldlx) {
		this.roim_ldlx = roim_ldlx;
	}

	public String getRoim_qsmc() {
		return roim_qsmc;
	}

	public void setRoim_qsmc(String roim_qsmc) {
		this.roim_qsmc = roim_qsmc;
	}

	public String getRoim_jsmc() {
		return roim_jsmc;
	}

	public void setRoim_jsmc(String roim_jsmc) {
		this.roim_jsmc = roim_jsmc;
	}

	public String getRoim_lc() {
		return roim_lc;
	}

	public void setRoim_lc(String roim_lc) {
		this.roim_lc = roim_lc;
	}

	public String getRoim_qs() {
		return roim_qs;
	}

	public void setRoim_qs(String roim_qs) {
		this.roim_qs = roim_qs;
	}

	public String getRoim_js() {
		return roim_js;
	}

	public void setRoim_js(String roim_js) {
		this.roim_js = roim_js;
	}

	public Integer getRoim_xqlc() {
		return roim_xqlc;
	}

	public void setRoim_xqlc(Integer roim_xqlc) {
		this.roim_xqlc = roim_xqlc;
	}

	public String getRoim_lmlx() {
		return roim_lmlx;
	}

	public void setRoim_lmlx(String roim_lmlx) {
		this.roim_lmlx = roim_lmlx;
	}

	public String getRoim_lmjg() {
		return roim_lmjg;
	}

	public void setRoim_lmjg(String roim_lmjg) {
		this.roim_lmjg = roim_lmjg;
	}

	public String getRoim_sjss() {
		return roim_sjss;
	}

	public void setRoim_sjss(String roim_sjss) {
		this.roim_sjss = roim_sjss;
	}

	public String getRoim_tcrq() {
		return roim_tcrq;
	}

	public void setRoim_tcrq(String roim_tcrq) {
		this.roim_tcrq = roim_tcrq;
	}

	public String getRoim_lflc() {
		return roim_lflc;
	}

	public void setRoim_lflc(String roim_lflc) {
		this.roim_lflc = roim_lflc;
	}

	public String getRoim_cds() {
		return roim_cds;
	}

	public void setRoim_cds(String roim_cds) {
		this.roim_cds = roim_cds;
	}

	public String getRoim_ljlx() {
		return roim_ljlx;
	}

	public void setRoim_ljlx(String roim_ljlx) {
		this.roim_ljlx = roim_ljlx;
	}

	public String getRoim_lykd() {
		return roim_lykd;
	}

	public void setRoim_lykd(String roim_lykd) {
		this.roim_lykd = roim_lykd;
	}

	public String getRoim_lkpddj() {
		return roim_lkpddj;
	}

	public void setRoim_lkpddj(String roim_lkpddj) {
		this.roim_lkpddj = roim_lkpddj;
	}

	public String getRoim_pic() {
		return roim_pic;
	}

	public void setRoim_pic(String roim_pic) {
		this.roim_pic = roim_pic;
	}

	public String getRoim_qz() {
			roim_qz=(roim_qsmc==null||roim_qsmc=="")?"未知":roim_qsmc+"—"+((roim_jsmc==null||roim_jsmc=="")?"未知":roim_jsmc);
		return roim_qz;
	}

	public void setRoim_qz(String roim_qz) {
		this.roim_qz = roim_qz;
	}

	public String getDept_name() {
		if(dept_code!=null)
		{
			dept_name=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, dept_code);
		}
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getTbek_name() {
//		if(tbek_code!=null)
//		{
//			tbek_name= SysTempStoreUtils.getFcName(SysBaseDataCode.xz, tbek_code)
//		}
		return tbek_name;
	}

	public void setTbek_name(String tbek_name) {
		this.tbek_name = tbek_name;
	}

}