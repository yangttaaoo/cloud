package com.cist.qwgl.qwjg.model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class GpsRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	// GPS设备标识符
	private long gspid;
	// 业务编号（设备类型为2时业务编号为车牌号，其它类型为警员编号）
	private String ywbh;
	// 手机号码
	private String sim;
	// GPS定位时间
	private Date gpstime;
	// 经度
	private BigDecimal jd;
	// 纬度
	private BigDecimal wd;
	private BigDecimal longitude;//经度
	private BigDecimal latitude;//纬度
	
	
	// E东经 W西经
	private String e_w;
	// N北纬 S南纬
	private String n_s;
	// 速度
	private String ydsd;
	// 相对位移速度
	private String gpssd;
	// 相对位移方向
	private String fx;
	// 海拔高度
	private String hbgd;
	// 相对位移距离
	private String wyjl;
	// 入库时间
	private Date rksj;
	// 设备类型（1-手机，2-警车，3-警务通，4-350M）
	private Integer sblx;
	private String sbwybm;//GPS设备唯一编码
	private String zwdz;//中文地址
	private String  fk_device_type;//JY警员 JC警车
	private Integer jytype;//人员分类（1-民警 2-辅警）
	/*// 经度
	private BigDecimal jd;
	// 纬度
	private BigDecimal wd;
	private BigDecimal longitude;//经度
	private BigDecimal latitude;//纬度

*/	
	private Integer img;//JY警员 JC警车 3警车
	

	public Integer getImg() {
	/*	if(this.sblx!=null) {
			 if(this.sblx==2) {
				 return 3;//警车
			 }else {
				 if(this.jytype==1) {
					 return 4;//民警
				 }else {
					 return 44;//辅警
				 }
				 
			 }
		}*/
		
		return img;
	}
	
	public Integer getJytype() {
		return jytype;
	}

	public void setJytype(Integer jytype) {
		this.jytype = jytype;
	}

	public void setImg(Integer img) {
		this.img = img;
	}
	public String getFk_device_type() {
		 if(this.sblx==2) {
			 
			 return "JC";
		 }else {
			 return "JY";
		 }
	}
	public BigDecimal getLongitude() {
		return jd;
	}
	public void setFk_device_type(String fk_device_type) {
		this.fk_device_type = fk_device_type;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public BigDecimal getLatitude() {
		return wd;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public String getSbwybm() {
		return sbwybm;
	}
	public void setSbwybm(String sbwybm) {
		this.sbwybm = sbwybm;
	}
	public String getZwdz() {
		return zwdz;
	}
	public void setZwdz(String zwdz) {
		this.zwdz = zwdz;
	}
	public long getGspid() {
		return gspid;
	}
	public void setGspid(long gspid) {
		this.gspid = gspid;
	}
	public String getYwbh() {
		return ywbh;
	}
	public void setYwbh(String ywbh) {
		this.ywbh = ywbh;
	}
	public String getSim() {
		return sim;
	}
	public void setSim(String sim) {
		this.sim = sim;
	}
	public Date getGpstime() {
		return gpstime;
	}
	public void setGpstime(Date gpstime) {
		this.gpstime = gpstime;
	}
	public BigDecimal getJd() {
		return jd;
	}
	public void setJd(BigDecimal jd) {
		this.jd = jd;
	}
	public BigDecimal getWd() {
		return wd;
	}
	public void setWd(BigDecimal wd) {
		this.wd = wd;
	}
	public String getE_w() {
		return e_w;
	}
	public void setE_w(String e_w) {
		this.e_w = e_w;
	}
	public String getN_s() {
		return n_s;
	}
	public void setN_s(String n_s) {
		this.n_s = n_s;
	}
	public String getYdsd() {
		return ydsd;
	}
	public void setYdsd(String ydsd) {
		this.ydsd = ydsd;
	}
	public String getGpssd() {
		return gpssd;
	}
	public void setGpssd(String gpssd) {
		this.gpssd = gpssd;
	}
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
	public String getHbgd() {
		return hbgd;
	}
	public void setHbgd(String hbgd) {
		this.hbgd = hbgd;
	}
	public String getWyjl() {
		return wyjl;
	}
	public void setWyjl(String wyjl) {
		this.wyjl = wyjl;
	}
	public Date getRksj() {
		return rksj;
	}
	public void setRksj(Date rksj) {
		this.rksj = rksj;
	}
	public Integer getSblx() {
		return sblx;
	}
	public void setSblx(Integer sblx) {
		this.sblx = sblx;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public GpsRecord(long gspid, String ywbh, String sim, Date gpstime, BigDecimal jd, BigDecimal wd, String e_w,
			String n_s, String ydsd, String gpssd, String fx, String hbgd, String wyjl, Date rksj, Integer sblx) {
		super();
		this.gspid = gspid;
		this.ywbh = ywbh;
		this.sim = sim;
		this.gpstime = gpstime;
		this.jd = jd;
		this.wd = wd;
		this.e_w = e_w;
		this.n_s = n_s;
		this.ydsd = ydsd;
		this.gpssd = gpssd;
		this.fx = fx;
		this.hbgd = hbgd;
		this.wyjl = wyjl;
		this.rksj = rksj;
		this.sblx = sblx;
	}
	public GpsRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}