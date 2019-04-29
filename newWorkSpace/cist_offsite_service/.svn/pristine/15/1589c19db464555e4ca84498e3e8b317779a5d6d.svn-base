package com.cist.picture.model;



import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class Tbl_offe_evdi implements Serializable{
	private static final long serialVersionUID = 5695037529386076531L;
	private Integer wfpk;
	private String wfbh;//违法编号
	private String wfdd;//违法地点
	private String wfdz;//实际的中文地址
	private String wfxw;//违法行为（对应TBL_OFFE_CATE）
	private String wfxwname;//违法行为（对应TBL_OFFE_CATE）
	private String fxbh;//方向编号
	private String hpzl;//号牌种类
	private String hphm;//号牌号码
	private String hpys;//号牌颜色
	private String clsd;//车辆速度
	private Timestamp wfkssj;//违法开始时间
	private Timestamp wfsj;//违法时间
	private String wfsjname;//违法时间
	private Timestamp wfjssj;//违法结束时间
	private String kkbh;//卡扣编号
	private String sbbh;//违法证据
	private String wfzj1;//违法证据1
	private String wfzj2;//违法证据2
	private String wfzj3;//违法证据3
	private String wfzj4;//违法证据4
	private Integer clbz;//处理标志
	private Integer shbz;//审核标志
	private String shr;//审核人
	private Timestamp shsj;//审核时间
	private String rcshr;//二次审核人
	private String shsm;//审核备注
	private Integer sjly;//数据来源
	private String cjdw;//采集单位
	private String clpp;//车辆品牌
	private String cllx;//车辆类型
	private String csys;//车身颜色
	private Integer bdsu;//标定速度
	private String syr;//车辆所有人
	private String syrdh;//所有人电话
	private String jszh;//驾驶证号
	private String zplx;//靠靠,0 靠靠 1 靠靠
	private String lrr;//录入人
	private Timestamp lrsj;//录入时间
	private Timestamp scsj;//上传时间
	private Integer scbz;//上传标志
	private String scdm;//上传代码
	private String csbz;//初审备注
	private String resve;//行政区别
	private String cdbh;//车道编号
	private String tqry;//提取人员pk
	private String tqrq;//提取日期 开始时间-结束时间
	
	private String hphmlhy;//号牌号码六合一
	
	private String hpzllhy;//号牌种类六合一
	public String getWfdz() {
		return wfdz;
	}

	public void setWfdz(String wfdz) {
		this.wfdz = wfdz;
	}

	public String getWfsjname() {
		if(null!=wfsj) {
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.format(wfsj);
		}
		return wfsjname;
	}

	public void setWfsjname(String wfsjname) {
		this.wfsjname = wfsjname;
	}

	public String getWfxwname() {
		if(null!=wfxw&&wfxw!="") {
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_WFXW,wfxw);
		}
	
		return wfxwname;
	}

	public void setWfxwname(String wfxwname) {
		this.wfxwname = wfxwname;
	}

	public Integer getWfpk() {
		return wfpk;
	}

	public void setWfpk(Integer wfpk) {
		this.wfpk = wfpk;
	}

	public String getWfbh() {
		return wfbh;
	}

	public void setWfbh(String wfbh) {
		this.wfbh = wfbh;
	}

	public String getWfdd() {
		return wfdd;
	}

	public void setWfdd(String wfdd) {
		this.wfdd = wfdd;
	}

	public String getWfxw() {
		return wfxw;
	}

	public void setWfxw(String wfxw) {
		this.wfxw = wfxw;
	}

	public String getFxbh() {
		return fxbh;
	}

	public void setFxbh(String fxbh) {
		this.fxbh = fxbh;
	}

	public String getHpzl() {
		return hpzl;
	}

	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}

	public String getHphm() {
		return hphm;
	}

	public void setHphm(String hphm) {
		this.hphm = hphm;
	}

	public String getHpys() {
		return hpys;
	}

	public void setHpys(String hpys) {
		this.hpys = hpys;
	}

	public String getClsd() {
		return clsd;
	}

	public void setClsd(String clsd) {
		this.clsd = clsd;
	}

	public Timestamp getWfkssj() {
		return wfkssj;
	}

	public void setWfkssj(Timestamp wfkssj) {
		this.wfkssj = wfkssj;
	}

	public Timestamp getWfsj() {
		return wfsj;
	}

	public void setWfsj(Timestamp wfsj) {
		this.wfsj = wfsj;
	}

	public Timestamp getWfjssj() {
		return wfjssj;
	}

	public void setWfjssj(Timestamp wfjssj) {
		this.wfjssj = wfjssj;
	}

	public String getKkbh() {
		return kkbh;
	}

	public void setKkbh(String kkbh) {
		this.kkbh = kkbh;
	}

	public String getSbbh() {
		return sbbh;
	}

	public void setSbbh(String sbbh) {
		this.sbbh = sbbh;
	}

	public String getWfzj1() {
		return wfzj1;
	}

	public void setWfzj1(String wfzj1) {
		this.wfzj1 = wfzj1;
	}

	public String getWfzj2() {
		return wfzj2;
	}

	public void setWfzj2(String wfzj2) {
		this.wfzj2 = wfzj2;
	}

	public String getWfzj3() {
		return wfzj3;
	}

	public void setWfzj3(String wfzj3) {
		this.wfzj3 = wfzj3;
	}

	public String getWfzj4() {
		return wfzj4;
	}

	public void setWfzj4(String wfzj4) {
		this.wfzj4 = wfzj4;
	}

	public Integer getClbz() {
		return clbz;
	}

	public void setClbz(Integer clbz) {
		this.clbz = clbz;
	}

	public Integer getShbz() {
		return shbz;
	}

	public void setShbz(Integer shbz) {
		this.shbz = shbz;
	}

	public String getShr() {
		return shr;
	}

	public void setShr(String shr) {
		this.shr = shr;
	}

	public Timestamp getShsj() {
		return shsj;
	}

	public void setShsj(Timestamp shsj) {
		this.shsj = shsj;
	}

	public String getRcshr() {
		return rcshr;
	}

	public void setRcshr(String rcshr) {
		this.rcshr = rcshr;
	}

	public String getShsm() {
		return shsm;
	}

	public void setShsm(String shsm) {
		this.shsm = shsm;
	}

	public Integer getSjly() {
		return sjly;
	}

	public void setSjly(Integer sjly) {
		this.sjly = sjly;
	}

	public String getCjdw() {
		return cjdw;
	}

	public void setCjdw(String cjdw) {
		this.cjdw = cjdw;
	}

	public String getClpp() {
		return clpp;
	}

	public void setClpp(String clpp) {
		this.clpp = clpp;
	}

	public String getCllx() {
		return cllx;
	}

	public void setCllx(String cllx) {
		this.cllx = cllx;
	}

	public String getCsys() {
		return csys;
	}

	public void setCsys(String csys) {
		this.csys = csys;
	}

	public Integer getBdsu() {
		return bdsu;
	}

	public void setBdsu(Integer bdsu) {
		this.bdsu = bdsu;
	}

	public String getSyr() {
		return syr;
	}

	public void setSyr(String syr) {
		this.syr = syr;
	}

	public String getSyrdh() {
		return syrdh;
	}

	public void setSyrdh(String syrdh) {
		this.syrdh = syrdh;
	}

	public String getJszh() {
		return jszh;
	}

	public void setJszh(String jszh) {
		this.jszh = jszh;
	}

	public String getZplx() {
		return zplx;
	}

	public void setZplx(String zplx) {
		this.zplx = zplx;
	}

	public String getLrr() {
		return lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
	}

	public Timestamp getLrsj() {
		return lrsj;
	}

	public void setLrsj(Timestamp lrsj) {
		this.lrsj = lrsj;
	}

	public Timestamp getScsj() {
		return scsj;
	}

	public void setScsj(Timestamp scsj) {
		this.scsj = scsj;
	}

	public Integer getScbz() {
		return scbz;
	}

	public void setScbz(Integer scbz) {
		this.scbz = scbz;
	}

	public String getScdm() {
		return scdm;
	}

	public void setScdm(String scdm) {
		this.scdm = scdm;
	}

	public String getCsbz() {
		return csbz;
	}

	public void setCsbz(String csbz) {
		this.csbz = csbz;
	}

	public String getResve() {
		return resve;
	}

	public void setResve(String resve) {
		this.resve = resve;
	}

	public String getCdbh() {
		return cdbh;
	}

	public void setCdbh(String cdbh) {
		this.cdbh = cdbh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Tbl_offe_evdi(Integer wfpk, String wfbh, String wfdd, String wfxw,
			String fxbh, String hpzl, String hphm, String hpys, String clsd,
			Timestamp wfkssj, Timestamp wfsj, Timestamp wfjssj, String kkbh,
			String sbbh, String wfzj1, String wfzj2, String wfzj3,
			String wfzj4, Integer clbz, Integer shbz, String shr,
			Timestamp shsj, String rcshr, String shsm, Integer sjly,
			String cjdw, String clpp, String cllx, String csys, Integer bdsu,
			String syr, String syrdh, String jszh, String zplx, String lrr,
			Timestamp lrsj, Timestamp scsj, Integer scbz, String scdm,
			String csbz, String resve, String cdbh) {
		super();
		this.wfpk = wfpk;
		this.wfbh = wfbh;
		this.wfdd = wfdd;
		this.wfxw = wfxw;
		this.fxbh = fxbh;
		this.hpzl = hpzl;
		this.hphm = hphm;
		this.hpys = hpys;
		this.clsd = clsd;
		this.wfkssj = wfkssj;
		this.wfsj = wfsj;
		this.wfjssj = wfjssj;
		this.kkbh = kkbh;
		this.sbbh = sbbh;
		this.wfzj1 = wfzj1;
		this.wfzj2 = wfzj2;
		this.wfzj3 = wfzj3;
		this.wfzj4 = wfzj4;
		this.clbz = clbz;
		this.shbz = shbz;
		this.shr = shr;
		this.shsj = shsj;
		this.rcshr = rcshr;
		this.shsm = shsm;
		this.sjly = sjly;
		this.cjdw = cjdw;
		this.clpp = clpp;
		this.cllx = cllx;
		this.csys = csys;
		this.bdsu = bdsu;
		this.syr = syr;
		this.syrdh = syrdh;
		this.jszh = jszh;
		this.zplx = zplx;
		this.lrr = lrr;
		this.lrsj = lrsj;
		this.scsj = scsj;
		this.scbz = scbz;
		this.scdm = scdm;
		this.csbz = csbz;
		this.resve = resve;
		this.cdbh = cdbh;
	}

	public Tbl_offe_evdi() {
		super();
	}

	public String getTqry() {
		return tqry;
	}

	public void setTqry(String tqry) {
		this.tqry = tqry;
	}

	public String getTqrq() {
		return tqrq;
	}

	public void setTqrq(String tqrq) {
		this.tqrq = tqrq;
	}

	public String getHphmlhy() {
		return hphmlhy;
	}

	public void setHphmlhy(String hphmlhy) {
		this.hphmlhy = hphmlhy;
	}

	public String getHpzllhy() {
		return hpzllhy;
	}

	public void setHpzllhy(String hpzllhy) {
		this.hpzllhy = hpzllhy;
	}
	
}
