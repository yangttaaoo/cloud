package com.cist.policemngment.model;

import java.io.Serializable;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

/**
 * 警务资源信息-人员
 * @author Administrator
 *
 */
public class Jcsj_Police_Res_Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3490909448690605242L;
	private Integer id;//ID
	private String glbm;//管理部门代码
	private String glbm_name;//管理部门代码
	private String rybh;//民警/辅警编号
	private String xm;//姓名
	private String sfzhm;//身份证号码
	private String xb;//性别
	private String ywgw;//业务岗位
	
	private String ywgw_name;//业务岗位
	private String ryfl;//人员分类（1-民警 2-辅警）
	private String fjlx;//人员类型（当RYLX=2时有效）
	private String zj;//职级（当RYLX=1时有效）
	private String bzlx;//编制类型（当RYLX=1时有效）
	private String zw;//职务（当RYLX=1时有效）
	private String zt;//状态，0-停用 1-启用
	private String zt_name;//状态，0-停用 1-启用
	private String zw_name;//业务岗位
	private String bgdh;//办公电话
	private String yddh;//移动电话
	private String dth;//电台号/对讲机号
	private String zhh;//组呼号
	private String vwh;//V网号
	private Date csrq;//出生日期
	private String mz;//民族
	private String hyzk;//婚姻状况
	private String jg;//籍贯
	private String zzmm;//政治面貌
	private String grsf;//个人身份
	private String hjszd;//户籍所在地
	private Date cjgzrq;//参加工作日期
	private Date rdtrq;//入党团日期
	private String sbh;//社保号
	private String pic;//图片地址
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRybh() {
		return rybh;
	}
	public void setRybh(String rybh) {
		this.rybh = rybh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getSfzhm() {
		return sfzhm;
	}
	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getYwgw() {
		return ywgw;
	}
	public void setYwgw(String ywgw) {
		this.ywgw = ywgw;
	}
	public String getPyfl() {
		return ryfl;
	}
	public void setPyfl(String ryfl) {
		this.ryfl = ryfl;
	}
	public String getFjlx() {
		return fjlx;
	}
	public void setFjlx(String fjlx) {
		this.fjlx = fjlx;
	}
	public String getZj() {
		return zj;
	}
	public void setZj(String zj) {
		this.zj = zj;
	}
	public String getBzlx() {
		return bzlx;
	}
	public void setBzlx(String bzlx) {
		this.bzlx = bzlx;
	}

	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getBgdh() {
		return bgdh;
	}
	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
	}
	public String getYddh() {
		return yddh;
	}
	public void setYddh(String yddh) {
		this.yddh = yddh;
	}
	public String getDth() {
		return dth;
	}
	public void setDth(String dth) {
		this.dth = dth;
	}
	public String getZhh() {
		return zhh;
	}
	public void setZhh(String zhh) {
		this.zhh = zhh;
	}
	
	public String getGlbm() {
		return glbm;
	}
	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}
	public String getGlbm_name() {
		if (glbm != null){
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, glbm); 
		}
		
		return glbm_name;
	}
	public void setGlbm_name(String glbm_name) {
		this.glbm_name = glbm_name;
	}
	public String getZt_name() {
		if ("1".equals(zt)){
			return "启用";
		}else{
			return "停用";
		}
		
	}
	public void setZt_name(String zt_name) {
		this.zt_name = zt_name;
	}
	public String getYwgw_name() {
		if (ywgw != null){
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_SZGW, ywgw); 
		}
		return ywgw_name;
	}
	public void setYwgw_name(String ywgw_name) {
		this.ywgw_name = ywgw_name;
	}
	public String getVwh() {
		return vwh;
	}
	public void setVwh(String vwh) {
		this.vwh = vwh;
	}
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getHyzk() {
		return hyzk;
	}
	public void setHyzk(String hyzk) {
		this.hyzk = hyzk;
	}
	public String getJg() {
		return jg;
	}
	public void setJg(String jg) {
		this.jg = jg;
	}
	public String getZzmm() {
		return zzmm;
	}
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	public String getGrsf() {
		return grsf;
	}
	public void setGrsf(String grsf) {
		this.grsf = grsf;
	}
	public Date getRdtrq() {
		return rdtrq;
	}
	public void setRdtrq(Date rdtrq) {
		this.rdtrq = rdtrq;
	}
	public Date getCjgzrq() {
		return cjgzrq;
	}
	public void setCjgzrq(Date cjgzrq) {
		this.cjgzrq = cjgzrq;
	}
	public String getSbh() {
		return sbh;
	}
	public void setSbh(String sbh) {
		this.sbh = sbh;
	}
	public String getHjszd() {
		return hjszd;
	}
	public void setHjszd(String hjszd) {
		this.hjszd = hjszd;
	}
	public Date getCsrq() {
		return csrq;
	}
	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getZw_name() {
		if (zw != null){
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_ZW, zw); 
		}
		return zw_name;
	}
	public void setZw_name(String zw_name) {
		this.zw_name = zw_name;
	}
	
	
}
