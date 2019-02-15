package com.cist.dj.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;




public class TblOffeEvdiInfo  implements  Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5294524870098069170L;
	/**
	 * 
	 */
	 private Long wfpk; //编号主键 NUMBER(10)

	 
	 private String clpp1;//车辆品牌VARCHAR2(64)
	 
	    private String wfxh;//违法编号 VARCHAR2(15)

	    private String wfdz;//违法地点VARCHAR2(255)

	    private String wfxw;//违法行为(对应TBL_OFFE_CATE)VARCHAR2(5)

	    private String fxbh;//方向编号CHAR(4)

	    private String hpzl;//号牌种类CHAR(2)

	    private String hphm;//号牌号码VARCHAR2(15)

	    private String hpys;//号牌颜色CHAR(1)

	    private BigDecimal clsd;//车辆速度NUMBER(5,1)

	    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GTM+8")
	    private Date wfkssj;//违法开始时间TIMESTAMP(6)
	    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GTM+8")
	    private Date wfsj;//违法时间TIMESTAMP(6)
	    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GTM+8")
	    private Date wfjssj;//违法结束时间TIMESTAMP(6)

	    private String kkbh;//卡口编号VARCHAR2(18)

	    private String sbbh;//设备编号CHAR(18)

	    private String wfzj1;//违法证据1VARCHAR2(256)

	    private String wfzj2;//违法证据2VARCHAR2(256)

	    private String wfzj3;//违法证据3VARCHAR2(256)

	    private String wfzj4;//违法证据4VARCHAR2(256)

	    private Short clbz;//处理标志INTEGER

	    private Short shbz;//审核标志INTEGER

	    private String shr;//审核人VARCHAR2(64)

	    private Date shsj;//审核时间TIMESTAMP(6)

	    private String ecshr;//二次审核人VARCHAR2(64)

	    private Date ecshsj;//二次审核时间TIMESTAMP(6)

	    private String cszfbz;//初审作废备注VARCHAR2(255)
	    
	    private String fszfbz;//复审作废备注VARCHAR2(255)

	    private Short sjly;//数据来源INTEGER

	    private String cjdw;//采集单位VARCHAR2(12)

	    private String clpp;//车辆品牌VARCHAR2(64)

	    private String cllx;//车辆类型VARCHAR2(64)

	    private String csys;//车身颜色VARCHAR2(2)

	    private BigDecimal bdsd;//标定速度NUMBER(5,1)

	    private String syxzname;//使用性质
	    
	    private String clyt_lhy;//车辆用途六合一值
	    
	    private String clyt;//车辆用途六合一值
	    
	    private String clztname;//车辆状态名称
	    
	    private String syr;//车辆所有人VARCHAR2(64)
	    
	    private String chaosubili;//超速比例
	    
	    private String syrdh;//所有人电话VARCHAR2(12)

	    private String jszh;//驾驶证号VARCHAR2(18)

	    private String jyyxqz;//检验有效期止VARCHAR2(32)
	    
	    private String zplx;//VARCHAR2(32)

	    private String lrr;//录入人VARCHAR2(32)

	    private Date lrsj;//录入时间TIMESTAMP(6)

	    private Date scsj;//上传时间TIMESTAMP(6)

	    private Short scbz;//上传标志INTEGER

	    private String scdm;//上传代码VARCHAR2(255)

	    private String csbz;//初审备注VARCHAR2(255)

	    private String resve;//行政区划VARCHAR2(255)

	    private String cdbh;//车道编号VARCHAR(2)
	    
	    private String hpzl1;
	    
	    private int jrll;//今日流量
	    
	    public int getJrll() {
			return jrll;
		}
	    
	    public void setJrll(int jrll) {
			this.jrll = jrll;
		}
	    
	    public Long getWfpk() {
	        return wfpk;
	    }

	    public void setWfpk(Long wfpk) {
	        this.wfpk = wfpk;
	    }

	    public String getWfxh() {
	        return wfxh;
	    }

	    public void setWfxh(String wfxh) {
	        this.wfxh = wfxh == null ? null : wfxh.trim();
	    }

	    public String getWfdz() {
	    	return wfdz;
	    }

	    public void setWfdz(String wfdz) {
	        this.wfdz = wfdz == null ? null : wfdz.trim();
	    }
	    
	    public String getWfxw() {
			return wfxw;
		}
	    
	    public void setWfxw(String wfxw) {
			this.wfxw = wfxw;
		}


	    public String getFxbh() {
//	    	if(null!=fxbh){
//	    		return SysTempStoreUtils.getfxbh(fxbh);
//	    	}
	        return fxbh;
	    }

	    public void setFxbh(String fxbh) {
	        this.fxbh = fxbh == null ? null : fxbh.trim();
	    }
	    
	    public String getHpzl() {
			return hpzl;
		}
	    
	    public void setHpzl(String hpzl) {
			this.hpzl = hpzl;
		}

	    public String getHpzl1() {
	    	if(null!=hpzl){
	    		return SysTempStoreUtils.getFcName("C001",hpzl);
			}
			return hpzl1;
	    }

	    public void setHpzl1(String hpzl1) {
	        this.hpzl1 = hpzl == null ? null : hpzl.trim();
	    }

	    public String getHphm() {
	        return hphm;
	    }

	    public void setHphm(String hphm) {
	        this.hphm = hphm == null ? null : hphm.trim();
	    }

	    public String getHpys() {
	        return hpys;
	    }

	    public void setHpys(String hpys) {
	        this.hpys = hpys == null ? null : hpys.trim();
	    }

	    public BigDecimal getClsd() {
	        return clsd;
	    }

	    public void setClsd(BigDecimal clsd) {
	        this.clsd = clsd;
	    }

	    public Date getWfkssj() {
	        return wfkssj;
	    }

	    public void setWfkssj(Date wfkssj) {
	        this.wfkssj = wfkssj;
	    }

	    public Date getWfsj() {
	        return wfsj;
	    }

	    public void setWfsj(Date wfsj) {
	        this.wfsj = wfsj;
	    }

	    public Date getWfjssj() {
	        return wfjssj;
	    }

	    public void setWfjssj(Date wfjssj) {
	        this.wfjssj = wfjssj;
	    }

	    public String getKkbh() {
	        return kkbh;
	    }

	    public void setKkbh(String kkbh) {
	        this.kkbh = kkbh == null ? null : kkbh.trim();
	    }

	    public String getSbbh() {
//	    	if (null!=sbbh){
//	    		return SysTempStoreUtils.getFcName("", sbbh);
//	    	}
	        return sbbh;
	    }

	    public void setSbbh(String sbbh) {
	        this.sbbh = sbbh == null ? null : sbbh.trim();
	    }

	    public String getWfzj1() {
	        return wfzj1;
	    }

	    public void setWfzj1(String wfzj1) {
	        this.wfzj1 = wfzj1 == null ? null : wfzj1.trim();
	    }

	    public String getWfzj2() {
	        return wfzj2;
	    }

	    public void setWfzj2(String wfzj2) {
	        this.wfzj2 = wfzj2 == null ? null : wfzj2.trim();
	    }

	    public String getWfzj3() {
	        return wfzj3;
	    }

	    public void setWfzj3(String wfzj3) {
	        this.wfzj3 = wfzj3 == null ? null : wfzj3.trim();
	    }

	    public String getWfzj4() {
	        return wfzj4;
	    }

	    public void setWfzj4(String wfzj4) {
	        this.wfzj4 = wfzj4 == null ? null : wfzj4.trim();
	    }

	    public Short getClbz() {
	        return clbz;
	    }

	    public void setClbz(Short clbz) {
	        this.clbz = clbz;
	    }

	    public Short getShbz() {
			return shbz;
		}

	    public void setShbz(Short shbz) {
	        this.shbz = shbz;
	    }

	    public String getShr() {
	        return shr;
	    }

	    public void setShr(String shr) {
	        this.shr = shr == null ? null : shr.trim();
	    }

	    public Date getShsj() {
	        return shsj;
	    }

	    public void setShsj(Date shsj) {
	        this.shsj = shsj;
	    }

	    public String getEcshr() {
	        return ecshr;
	    }

	    public void setEcshr(String ecshr) {
	        this.ecshr = ecshr == null ? null : ecshr.trim();
	    }

	    public Date getEcshsj() {
	        return ecshsj;
	    }

	    public void setEcshsj(Date ecshsj) {
	        this.ecshsj = ecshsj;
	    }

	    public String getCszfbz() {
			return cszfbz;
		}
	    
	    public void setCszfbz(String cszfbz) {
			this.cszfbz = cszfbz;
		}
	    
	    public String getFszfbz() {
			return fszfbz;
		}
	    
	    public void setFszfbz(String fszfbz) {
			this.fszfbz = fszfbz;
		}

	    public Short getSjly() {
	        return sjly;
	    }

	    public void setSjly(Short sjly) {
	        this.sjly = sjly;
	    }

	    public String getCjdw() {
//	    	if(null!=cjdw){
//				return SysTempStoreUtils.getDanwei(cjdw);
//			}
			return cjdw;
	    }

	    public void setCjdw(String cjdw) {
	        this.cjdw = cjdw == null ? null : cjdw.trim();
	    }

	    public String getClpp() {
	        return clpp;
	    }

	    public void setClpp(String clpp) {
	        this.clpp = clpp == null ? null : clpp.trim();
	    }

	    public String getCllx() {
	        return cllx;
	    }

	    public void setCllx(String cllx) {
	        this.cllx = cllx == null ? null : cllx.trim();
	    }

	    public String getCsys() {
	        return csys;
	    }

	    public void setCsys(String csys) {
	        this.csys = csys == null ? null : csys.trim();
	    }

	    public BigDecimal getBdsd() {
	        return bdsd;
	    }

	    public void setBdsd(BigDecimal bdsd) {
	        this.bdsd = bdsd;
	    }

	    public String getSyr() {
	        return syr;
	    }

	    public void setSyr(String syr) {
	        this.syr = syr == null ? null : syr.trim();
	    }

	    public String getSyrdh() {
	        return syrdh;
	    }

	    public void setSyrdh(String syrdh) {
	        this.syrdh = syrdh == null ? null : syrdh.trim();
	    }

	    public String getJszh() {
	        return jszh;
	    }

	    public void setJszh(String jszh) {
	        this.jszh = jszh == null ? null : jszh.trim();
	    }

	    public String getZplx() {
	        return zplx;
	    }

	    public void setZplx(String zplx) {
	        this.zplx = zplx == null ? null : zplx.trim();
	    }

	    public String getLrr() {
	        return lrr;
	    }

	    public void setLrr(String lrr) {
	        this.lrr = lrr == null ? null : lrr.trim();
	    }

	    public Date getLrsj() {
	        return lrsj;
	    }

	    public void setLrsj(Date lrsj) {
	        this.lrsj = lrsj;
	    }

	    public Date getScsj() {
	        return scsj;
	    }

	    public void setScsj(Date scsj) {
	        this.scsj = scsj;
	    }

	    public Short getScbz() {
	        return scbz;
	    }

	    public void setScbz(Short scbz) {
	        this.scbz = scbz;
	    }

	    public String getScdm() {
	        return scdm;
	    }

	    public void setScdm(String scdm) {
	        this.scdm = scdm == null ? null : scdm.trim();
	    }

	    public String getCsbz() {
	        return csbz;
	    }

	    public void setCsbz(String csbz) {
	        this.csbz = csbz == null ? null : csbz.trim();
	    }

	    public String getResve() {
	        return resve;
	    }

	    public void setResve(String resve) {
	        this.resve = resve == null ? null : resve.trim();
	    }

	    public String getCdbh() {
	        return cdbh;
	    }

	    public void setCdbh(String cdbh) {
	        this.cdbh = cdbh == null ? null : cdbh.trim();
	    }

		public String getChaosubili() {
			return chaosubili;
		}

		public void setChaosubili(String chaosubili) {
			this.chaosubili = chaosubili;
		}

		public String getSyxzname() {
			return syxzname;
		}

		public void setSyxzname(String syxzname) {
			this.syxzname = syxzname;
		}

		public String getClyt_lhy() {
			return clyt_lhy;
		}

		public void setClyt_lhy(String clyt_lhy) {
			this.clyt_lhy = clyt_lhy;
		}

		public String getClztname() {
			return clztname;
		}

		public void setClztname(String clztname) {
			this.clztname = clztname;
		}

		public String getJyyxqz() {
			return jyyxqz;
		}

		public void setJyyxqz(String jyyxqz) {
			this.jyyxqz = jyyxqz;
		}

		public String getClpp1() {
			return clpp1;
		}

		public void setClpp1(String clpp1) {
			this.clpp1 = clpp1;
		}

		public String getClyt() {
			return clyt;
		}

		public void setClyt(String clyt) {
			this.clyt = clyt;
		}
	
	
}
