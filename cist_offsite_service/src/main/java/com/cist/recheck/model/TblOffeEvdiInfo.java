package com.cist.recheck.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.cist.frame.utils.SysTempStoreUtils;

@SuppressWarnings("unused")
public class TblOffeEvdiInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5294524870098069170L;
	private Long wfpk;// ID

	private String wfxh;// 数据编码（日期+序号）

	private String wfdz;// 实际的中文地址

	private String wfxw;// 违法行为(参考TBL_OFFE_CATE)

	private String fxbh;// 车道方向

	private String hpzl;// 号牌种类(参考SYS_FRM_CODE表 FCT_CODE=C001)

	private String hphm;// 号牌号码

	private String hpys;// 号牌颜色

	private BigDecimal clsd;// 速度

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
	private Date wfkssj;// 违法开始时间TIMESTAMP(6)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
	private Date wfsj;// 违法时间TIMESTAMP(6)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
	private Date wfjssj;// 违法结束时间TIMESTAMP(6)

	private String wfdd;// 路段代码

	private String lddm;// 路口号

	private String ldms;// 地点米数

	private String dllx;// 道路类型

	private String kkbh;// 卡口编码(路段代码+路口号+地点米数)

	private String sbbh;// 设备编码

	private String wfzj1;// 违法证据1(图片路径)

	private String wfzj2;// 违法证据2(图片路径)

	private String wfzj3;// 违法证据3(图片路径)

	private String wfzj4;// 违法证据4(图片路径)

	private String shbz;// 审核标志(0-未审核1-初审通过 2-复审通过3-初审作废 4-复审作废 5-作废数据有效7-上传成功
						// 8-上传失败9-上传其它标志10-删除标志11-其它13-上传队列 14-导出 15-初筛通过
						// 16-初筛作废)

	private String csr;// 初审人

	private Date cssj;// 初审时间

	private String cszfbz;// 初审作废备注

	private String fsr;// 复审人

	private Date fssj;// 复审时间

	private String fszfbz;// 复审作废备注

	private String cjsb;// 备设备类型(参考SYS_FRM_CODE表 FCT_CODE=W001)

	private String cjdw;// 采集单位代码

	private String clpp;// 车辆品牌

	private String cllx;// 车辆类型

	private String csys;// 车身颜色

	private BigDecimal bdsd;// 标定限速

	private String jszh;// 驾驶证号

	private String zplx;// 抓拍类型,0 自动抓拍 1 手动抓拍

	private String sjly;// 数据来源

	private Date lrsj;// 录入时间

	private Date scsj;// 上传时间

	private String scdm;// 上传代码

	private String xzqh;// 行政区划代码

	private String cdbh;// 车道编号

	private String zsxxdz;// 住所详细地址

	private String syxz;// 使用性质

	private String fdjh;// 发动机号

	private String fzjg;// 发证机关

	private String clyt;// 车辆用途

	private String xb;// 性别

	private String csysname;// 车身颜色

	private String clxh;// 车辆型号

	private String syxzname;// 使用性质名称

	private String clztname;// 车辆状态名称

	private String dwbh;// 单位编号

	private String dwmc;// 单位名称

	private String djrq;// 最近定检日期

	private String jyyxqz;// 检验有效期止

	private String bfrq;// 报废日期

	private String lhyflag;// 此条记录是否有六合一车辆信息0-没有 1-有

	private String cllxname;// 车辆类型名字

	private String clpp1;// 中文品牌

	private String jdcsyr;// 机动车所有人

	private String syrdh;// 联系电话

	private String hpzlname;// 号牌种类名称

	private String csbl;// 超速比例

	private String clsbdh;// 车辆识别代号

	private String dcbz;// 导出标记1-违法数据已导出 0-违法数据未导出

	private String clyt_lhy;// 车辆用途六合一值

	private String tpsl;// 图片数量

	private String cptplj;// 车牌图片路径

	private String clwlc;// 车辆外廊长，单位为厘米，不足四位无需补“0”。如：“100”表示车长为 100 厘米。无法识别为“0”

	private String clzpp1;// 车辆主品牌

	private String clzpp2;// 车辆子品牌

	private String clnk;// 车辆年款

	private String zjsaqdzt;// 主驾驶安全带状态（0-未知1-未系安全带2-系安全带）

	private String fjsaqdzt;// 副驾驶安全带状态（0-未知1-未系安全带2-系安全带）

	private String zjszybzt;// 主驾驶遮阳板状态（0-未知1-未打开 2-打开）

	private String fjszybzt;// 副驾驶遮阳板状态（0-未知1-未打开 2-打开）

	private String sfddh;// 是否打电话（0 -未知1-未打电话2-打电话）

	private String sfhbc;// 是否黄标车（0 -未知1-非黄标车2-黄标车）

	private String sfwxpc;// 是否危险品车（0-未知1-危险品车2-非危险品车）

	private String sfygj;// 是否有挂（0 -未知1-无挂件2-有挂件）

	private String sfbmd;// 是否白名单（0-否 1-是）

	private String sxr;// 筛选人
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date sxsj;// 筛选时间

	private String sfzmhm;// 身份证号码

	private String wfxwname;// 违法行为的名称

	private String csyyName;// 初审作废原因名称

	private String fsyyName;// 复审作废原因名称

	private String csrName;// 初审人名称

	private String fsrName;// 复审人名称

	private String hpTypeName;// 号牌种类名称VARCHAR2(60)

	private String hpysName;// 号牌颜色名称

//	private String tboc_points;// 违法记分
//
//	private String tboc_fines;// 罚款金额

	private String dept_name;// 采集单位名称

	private String shbzname;// 审核标志名称

	private String cjsbName;// 采集设备名称

	private String ysName;// 车身颜色名称
	// 六合一信息
	private String syr;// 车主姓名
	
	private String syxzName;// 使用性质名称
	
	private String cllxName;// 车辆类型名称
	
	private String csysName;// 车身颜色名称
	
	private String clytName;// 车辆用途名称
	
	
	private String djrqName;// 最近定检日期
	
	private String yxqzName;// 检验有效期
	
	private String qzbfqzName;// 报废日期
	private String ztName;// 车辆状态
	
private String tqry;//提取人员pk
	

	private String tqrq;//提取日期 开始时间-结束时间
	
	private String hphmlhy;//号牌号码六合一
	
	private String hpzllhy;//号牌种类六合一
	
	private String clysName;//车辆信息的颜色名称 用于对比与车管库信息颜色是否一致
	
	private String hpzllhyName;//六合一号牌种类名称
	

	public String getHpzllhyName() {
		if(hpzllhy!=null) {
			hpzllhyName = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_HPZL, hpzllhy);
		}
		return hpzllhyName;
	}

	public void setHpzllhyName(String hpzllhyName) {
		this.hpzllhyName = hpzllhyName;
	}

	public String getClysName() {
		if(csys!=null) {
			clysName = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CSYS, csys);
		}
		return clysName;
	}

	public void setClysName(String clysName) {
		this.clysName = clysName;
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
		this.wfxh = wfxh;
	}

	public String getWfdz() {
		return wfdz;
	}

	public void setWfdz(String wfdz) {
		this.wfdz = wfdz;
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

	public String getWfdd() {
		return wfdd;
	}

	public void setWfdd(String wfdd) {
		this.wfdd = wfdd;
	}

	public String getLddm() {
		return lddm;
	}

	public void setLddm(String lddm) {
		this.lddm = lddm;
	}

	public String getLdms() {
		return ldms;
	}

	public void setLdms(String ldms) {
		this.ldms = ldms;
	}

	public String getDllx() {
		return dllx;
	}

	public void setDllx(String dllx) {
		this.dllx = dllx;
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

	public String getShbz() {
		return shbz;
	}

	public void setShbz(String shbz) {
		this.shbz = shbz;
	}

	public String getCsr() {
		return csr;
	}

	public void setCsr(String csr) {
		this.csr = csr;
	}

	public Date getCssj() {
		return cssj;
	}

	public void setCssj(Date cssj) {
		this.cssj = cssj;
	}

	public String getCszfbz() {
		return cszfbz;
	}

	public void setCszfbz(String cszfbz) {
		this.cszfbz = cszfbz;
	}

	public String getFsr() {
		return fsr;
	}

	public void setFsr(String fsr) {
		this.fsr = fsr;
	}

	public Date getFssj() {
		return fssj;
	}

	public void setFssj(Date fssj) {
		this.fssj = fssj;
	}

	public String getFszfbz() {
		return fszfbz;
	}

	public void setFszfbz(String fszfbz) {
		this.fszfbz = fszfbz;
	}

	public String getCjsb() {
		return cjsb;
	}

	public void setCjsb(String cjsb) {
		this.cjsb = cjsb;
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

	public BigDecimal getBdsd() {
		return bdsd;
	}

	public void setBdsd(BigDecimal bdsd) {
		this.bdsd = bdsd;
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

	public String getSjly() {
		return sjly;
	}

	public void setSjly(String sjly) {
		this.sjly = sjly;
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

	public String getScdm() {
		return scdm;
	}

	public void setScdm(String scdm) {
		this.scdm = scdm;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public String getCdbh() {
		return cdbh;
	}

	public void setCdbh(String cdbh) {
		this.cdbh = cdbh;
	}

	public String getZsxxdz() {
		return zsxxdz;
	}

	public void setZsxxdz(String zsxxdz) {
		this.zsxxdz = zsxxdz;
	}

	public String getSyxz() {
		return syxz;
	}

	public void setSyxz(String syxz) {
		this.syxz = syxz;
	}

	public String getFdjh() {
		return fdjh;
	}

	public void setFdjh(String fdjh) {
		this.fdjh = fdjh;
	}

	public String getFzjg() {
		return fzjg;
	}

	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}

	public String getClyt() {
		return clyt;
	}

	public void setClyt(String clyt) {
		this.clyt = clyt;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getCsysname() {
		return csysname;
	}

	public void setCsysname(String csysname) {
		this.setCsysName(csysname);
		this.csysname = csysname;
	}

	public String getClxh() {
		return clxh;
	}

	public void setClxh(String clxh) {
		this.clxh = clxh;
	}

	public String getSyxzname() {
		return syxzname;
	}

	public void setSyxzname(String syxzname) {
		this.syxzname = syxzname;
	}

	public String getClztname() {
		return clztname;
	}

	public void setClztname(String clztname) {
		this.clztname = clztname;
	}

	public String getDwbh() {
		return dwbh;
	}

	public void setDwbh(String dwbh) {
		this.dwbh = dwbh;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getDjrq() {
		return djrq;
	}

	public void setDjrq(String djrq) {
		this.djrq = djrq;
	}

	public String getJyyxqz() {
		return jyyxqz;
	}

	public void setJyyxqz(String jyyxqz) {
		this.jyyxqz = jyyxqz;
	}

	public String getBfrq() {
		return bfrq;
	}

	public void setBfrq(String bfrq) {
		this.bfrq = bfrq;
	}

	public String getLhyflag() {
		return lhyflag;
	}

	public void setLhyflag(String lhyflag) {
		this.lhyflag = lhyflag;
	}

	public String getCllxname() {
		return cllxname;
	}

	public void setCllxname(String cllxname) {
		this.cllxname = cllxname;
	}

	public String getClpp1() {
		return clpp1;
	}

	public void setClpp1(String clpp1) {
		this.clpp1 = clpp1;
	}

	public String getJdcsyr() {
		return jdcsyr;
	}

	public void setJdcsyr(String jdcsyr) {
		this.jdcsyr = jdcsyr;
	}

	public String getSyrdh() {
		return syrdh;
	}

	public void setSyrdh(String syrdh) {
		this.syrdh = syrdh;
	}

	public String getHpzlname() {
		return hpzlname;
	}

	public void setHpzlname(String hpzlname) {
		this.hpzlname = hpzlname;
	}

	public String getCsbl() {
		return csbl;
	}

	public void setCsbl(String csbl) {
		this.csbl = csbl;
	}

	public String getClsbdh() {
		return clsbdh;
	}

	public void setClsbdh(String clsbdh) {
		this.clsbdh = clsbdh;
	}

	public String getDcbz() {
		return dcbz;
	}

	public void setDcbz(String dcbz) {
		this.dcbz = dcbz;
	}

	public String getTpsl() {
		return tpsl;
	}

	public void setTpsl(String tpsl) {
		this.tpsl = tpsl;
	}

	public String getCptplj() {
		return cptplj;
	}

	public void setCptplj(String cptplj) {
		this.cptplj = cptplj;
	}

	public String getClwlc() {
		return clwlc;
	}

	public void setClwlc(String clwlc) {
		this.clwlc = clwlc;
	}

	public String getClzpp1() {
		return clzpp1;
	}

	public void setClzpp1(String clzpp1) {
		this.clzpp1 = clzpp1;
	}

	public String getClzpp2() {
		return clzpp2;
	}

	public void setClzpp2(String clzpp2) {
		this.clzpp2 = clzpp2;
	}

	public String getClnk() {
		return clnk;
	}

	public void setClnk(String clnk) {
		this.clnk = clnk;
	}

	public String getZjsaqdzt() {
		return zjsaqdzt;
	}

	public void setZjsaqdzt(String zjsaqdzt) {
		this.zjsaqdzt = zjsaqdzt;
	}

	public String getFjsaqdzt() {
		return fjsaqdzt;
	}

	public void setFjsaqdzt(String fjsaqdzt) {
		this.fjsaqdzt = fjsaqdzt;
	}

	public String getZjszybzt() {
		return zjszybzt;
	}

	public void setZjszybzt(String zjszybzt) {
		this.zjszybzt = zjszybzt;
	}

	public String getFjszybzt() {
		return fjszybzt;
	}

	public void setFjszybzt(String fjszybzt) {
		this.fjszybzt = fjszybzt;
	}

	public String getSfddh() {
		return sfddh;
	}

	public void setSfddh(String sfddh) {
		this.sfddh = sfddh;
	}

	public String getSfhbc() {
		return sfhbc;
	}

	public void setSfhbc(String sfhbc) {
		this.sfhbc = sfhbc;
	}

	public String getSfwxpc() {
		return sfwxpc;
	}

	public void setSfwxpc(String sfwxpc) {
		this.sfwxpc = sfwxpc;
	}

	public String getSfygj() {
		return sfygj;
	}

	public void setSfygj(String sfygj) {
		this.sfygj = sfygj;
	}

	public String getSfbmd() {
		return sfbmd;
	}

	public void setSfbmd(String sfbmd) {
		this.sfbmd = sfbmd;
	}

	public String getSxr() {
		return sxr;
	}

	public void setSxr(String sxr) {
		this.sxr = sxr;
	}

	public Date getSxsj() {
		return sxsj;
	}

	public void setSxsj(Date sxsj) {
		this.sxsj = sxsj;
	}

	public String getSfzmhm() {
		return sfzmhm;
	}

	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
	}

	public String getWfxwname() {
		if (null != wfxw) {
			return SysTempStoreUtils.getFcName("WF01", wfxw);
		} else {
			wfxwname = "未知";
		}
		return wfxwname;
	}

	public void setWfxwname(String wfxwname) {

		this.wfxwname = wfxwname;
	}

	public String getCsyyName() {
		if (cszfbz != null) {
			return SysTempStoreUtils.getFcName("S001", cszfbz);
		} else {
			csyyName = "未知";
		}
		return csyyName;
	}

	public void setCsyyName(String csyyName) {
		this.csyyName = csyyName;
	}

	public String getFsyyName() {
		if (fszfbz != null) {
			return SysTempStoreUtils.getFcName("S001", fszfbz);
		} else {
			fsyyName = "未知";
		}
		return fsyyName;
	}

	public void setFsyyName(String fsyyName) {
		this.fsyyName = fsyyName;
	}

	public String getCsrName() {
		if (csr != null) {
			return SysTempStoreUtils.getFcName("YH00", csr);
		} else {
			csrName = "未知";
		}
		return csrName;
	}

	public void setCsrName(String csrName) {
		this.csrName = csrName;
	}

	public String getFsrName() {
		if (fsr != null) {
			return SysTempStoreUtils.getFcName("YH00", fsr);
		} else {
			fsrName = "未知";
		}
		return fsrName;
	}

	public void setFsrName(String fsrName) {
		this.fsrName = fsrName;
	}

	public String getHpTypeName() {
		if (hpzl != null) {
			hpTypeName = SysTempStoreUtils.getFcName("C001", hpzl);
		} else {
			hpTypeName = "未知";
		}
		return hpTypeName;
	}

	public void setHpTypeName(String hpTypeName) {
		this.hpTypeName = hpTypeName;
	}

//	public String getTboc_points() {
//		String fcName = SysTempStoreUtils.getFcName("WFJF", wfxw);
//		if (fcName.indexOf("@") == -1) {
//			if (fcName == null || "".equals(fcName)) {
//				return "0";
//			}
//			return fcName;
//		} else {
//			String substring = fcName.substring(0, fcName.indexOf("@"));
//			if ("".equals(substring) || substring == null) {
//				return "0";
//			}
//			return substring;
//		}
//
//	}
//
//	public void setTboc_points(String tboc_points) {
//		this.tboc_points = tboc_points;
//	}
//
//	public String getTboc_fines() {
//		String fcName = SysTempStoreUtils.getFcName("WFJF", wfxw);
//		if (fcName.indexOf("@") == -1) {
//			if (fcName == null || "".equals(fcName)) {
//				return "0";
//			}
//			return fcName;
//		} else {
//			String substring = fcName.substring(fcName.indexOf("@") + 1, fcName.length());
//			if ("".equals(substring) || substring == null) {
//				return "0";
//			}
//			return substring;
//		}
//	}
//
//	public void setTboc_fines(String tboc_fines) {
//		this.tboc_fines = tboc_fines;
//	}

	public String getDept_name() {
		if (cjdw != null) {
			return SysTempStoreUtils.getFcName("DP01", cjdw);
		} else {
			hpTypeName = "未知";
		}
		return hpTypeName;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getShbzname() {
		if ("1".equals(shbz)) {
			return "初审通过";
		} else if ("2".equals(shbz)) {
			return "复审通过";
		} else if ("4".equals(shbz)) {
			return "复审作废";
		}
		return "";
	}

	public void setShbzname(String shbzname) {
		this.shbzname = shbzname;
	}

	public String getSyr() {
		return jdcsyr;
	}

	public void setSyr(String syr) {
		this.syr = syr;
	}

	public String getSyxzName() {
		return syxzname;
	}

	public void setSyxzName(String syxzName) {
		this.syxzName = syxzName;
	}

	public String getCllxName() {
		return cllxName;
	}

	public void setCllxName(String cllxName) {

		this.cllxName = cllxName;
	}

	public String getCsysName() {
		return csysName;
	}

	public void setCsysName(String csysName) {
		this.csysName = csysName;
	}

	public String getQzbfqzName() {
		return bfrq;
	}

	public void setQzbfqzName(String qzbfqzName) {
		this.qzbfqzName = bfrq;
	}

	public String getYxqzName() {
		return jyyxqz;
	}

	public void setYxqzName(String yxqzName) {
		this.yxqzName = jyyxqz;
	}

	public String getClyt_lhy() {
		return clyt_lhy;
	}

	public void setClyt_lhy(String clyt_lhy) {
		this.clyt_lhy = clyt_lhy;
	}

	public String getZtName() {
		return clztname;
	}

	public void setZtName(String ztName) {
		this.ztName = ztName;
	}

	public String getClytName() {
		if (null != clyt_lhy && !clyt_lhy.equals("")) {
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CLYT, clyt_lhy);
		} else {
			clytName = "未知";
		}
		return clytName;
	}

	public void setClytName(String clytName) {
		this.clytName = clytName;
	}

	public String getDjrqName() {
		return djrq;
	}

	public void setDjrqName(String djrqName) {
		this.djrqName = djrqName;
	}

	public String getHpysName() {
		if (hpys != null) {
			return SysTempStoreUtils.getFcName("C007", hpys);
		} else {
			hpysName = "未知";
		}

		return hpysName;
	}

	public void setHpysName(String hpysName) {
		this.hpysName = hpysName;
	}

	public String getCjsbName() {
		if (sbbh != null) {
			return SysTempStoreUtils.getFcName("SB00", sbbh);
		} else {
			cjsbName = "未知";
		}

		return cjsbName;
	}

	public void setCjsbName(String cjsbName) {
		this.cjsbName = cjsbName;
	}

	public String getYsName() {
		if (csys != null) {
			return SysTempStoreUtils.getFcName("C002", csys);
		} else {
			ysName = "未知";
		}

		return ysName;
	}

	public void setYsName(String ysName) {
		this.ysName = ysName;
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
