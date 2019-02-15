package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Overviewdata implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pk_id;//
	/*街面勤务*/
	private String area_name;
	private Date jiemiani_kaitime;
	private Date jiemiani_enndtime;
	private String jiemiani_cheliang;
	private String jiemiani_renyuan;
	private String jiemiani_banciname;
	private String jiemiani_biename;//别名
	/*值班值守*/
	private Date banci_kaitime;
	private Date banci_enndtime;
	private String banci_renyuan;
	private String banci_biename;//别名
	/*接处警*/
	private String jiechu_renyuan;
	/*机关工作*/
	private Date jiguan_kaitiem;
	private Date jiguan_endtiem;
	private String jiguan_renyuan;
	private String jiguan_biename;//别名
	/*轮休*/
	private Date lun_kaitiem;
	private Date lun_endtiem;
	private String lun_biename;//别名
	private String lun_renyuan;
	
	public String getJiguan_biename() {
		if(null!=jiguan_kaitiem) {
			SimpleDateFormat simp=new SimpleDateFormat("HH:mm");
			return simp.format(jiguan_kaitiem)+"~"+simp.format(jiguan_endtiem);
		}
		return jiguan_biename;
	}
	public void setJiguan_biename(String jiguan_biename) {
		this.jiguan_biename = jiguan_biename;
	}
	public String getBanci_biename() {
		if(null!=banci_kaitime) {
			SimpleDateFormat simp=new SimpleDateFormat("HH:mm");
			return simp.format(banci_kaitime)+"~"+simp.format(banci_enndtime);
		}
		return banci_biename;
	}
	public void setBanci_biename(String banci_biename) {
		this.banci_biename = banci_biename;
	}
	public String getJiemiani_biename() {
		if(null!=jiemiani_kaitime) {
			SimpleDateFormat simp=new SimpleDateFormat("HH:mm");
			return jiemiani_banciname+"/"+simp.format(jiemiani_kaitime)+"~"+simp.format(jiemiani_enndtime);
		}
		return jiemiani_biename;
	}
	public void setJiemiani_biename(String jiemiani_biename) {
		this.jiemiani_biename = jiemiani_biename;
	}
	public String getLun_biename() {
		if(null!=lun_kaitiem) {
			SimpleDateFormat simp=new SimpleDateFormat("HH:mm");
			return simp.format(lun_kaitiem)+"~"+simp.format(lun_endtiem);
		}
		return lun_biename;
	}
	public void setLun_biename(String lun_biename) {
		this.lun_biename = lun_biename;
	}
	public void setLun_kaitiem(Date lun_kaitiem) {
		this.lun_kaitiem = lun_kaitiem;
	}
	public void setLun_endtiem(Date lun_endtiem) {
		this.lun_endtiem = lun_endtiem;
	}
	public String getJiemiani_banciname() {
		return jiemiani_banciname;
	}
	public void setJiemiani_banciname(String jiemiani_banciname) {
		this.jiemiani_banciname = jiemiani_banciname;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	
	public String getJiemiani_cheliang() {
		return jiemiani_cheliang;
	}
	public void setJiemiani_cheliang(String jiemiani_cheliang) {
		this.jiemiani_cheliang = jiemiani_cheliang;
	}
	public String getJiemiani_renyuan() {
		return jiemiani_renyuan;
	}
	public void setJiemiani_renyuan(String jiemiani_renyuan) {
		this.jiemiani_renyuan = jiemiani_renyuan;
	}
	
	
	
	public String getBanci_renyuan() {
		return banci_renyuan;
	}
	public void setBanci_renyuan(String banci_renyuan) {
		this.banci_renyuan = banci_renyuan;
	}
	public String getJiechu_renyuan() {
		return jiechu_renyuan;
	}
	public void setJiechu_renyuan(String jiechu_renyuan) {
		this.jiechu_renyuan = jiechu_renyuan;
	}
	
	
	public String getJiguan_renyuan() {
		return jiguan_renyuan;
	}
	public void setJiguan_renyuan(String jiguan_renyuan) {
		this.jiguan_renyuan = jiguan_renyuan;
	}
	
	public Overviewdata(Integer pk_id, String area_name, Date jiemiani_kaitime, Date jiemiani_enndtime,
			String jiemiani_cheliang, String jiemiani_renyuan, String jiemiani_banciname, String jiemiani_biename,
			Date banci_kaitime, Date banci_enndtime, String banci_renyuan, String banci_biename, String jiechu_renyuan,
			Date jiguan_kaitiem, Date jiguan_endtiem, String jiguan_renyuan, String jiguan_biename, Date lun_kaitiem,
			Date lun_endtiem, String lun_biename, String lun_renyuan) {
		super();
		this.pk_id = pk_id;
		this.area_name = area_name;
		this.jiemiani_kaitime = jiemiani_kaitime;
		this.jiemiani_enndtime = jiemiani_enndtime;
		this.jiemiani_cheliang = jiemiani_cheliang;
		this.jiemiani_renyuan = jiemiani_renyuan;
		this.jiemiani_banciname = jiemiani_banciname;
		this.jiemiani_biename = jiemiani_biename;
		this.banci_kaitime = banci_kaitime;
		this.banci_enndtime = banci_enndtime;
		this.banci_renyuan = banci_renyuan;
		this.banci_biename = banci_biename;
		this.jiechu_renyuan = jiechu_renyuan;
		this.jiguan_kaitiem = jiguan_kaitiem;
		this.jiguan_endtiem = jiguan_endtiem;
		this.jiguan_renyuan = jiguan_renyuan;
		this.jiguan_biename = jiguan_biename;
		this.lun_kaitiem = lun_kaitiem;
		this.lun_endtiem = lun_endtiem;
		this.lun_biename = lun_biename;
		this.lun_renyuan = lun_renyuan;
	}
	public Date getJiemiani_kaitime() {
		return jiemiani_kaitime;
	}
	public void setJiemiani_kaitime(Date jiemiani_kaitime) {
		this.jiemiani_kaitime = jiemiani_kaitime;
	}
	public Date getJiemiani_enndtime() {
		return jiemiani_enndtime;
	}
	public void setJiemiani_enndtime(Date jiemiani_enndtime) {
		this.jiemiani_enndtime = jiemiani_enndtime;
	}
	public Date getBanci_kaitime() {
		return banci_kaitime;
	}
	public void setBanci_kaitime(Date banci_kaitime) {
		this.banci_kaitime = banci_kaitime;
	}
	public Date getBanci_enndtime() {
		return banci_enndtime;
	}
	public void setBanci_enndtime(Date banci_enndtime) {
		this.banci_enndtime = banci_enndtime;
	}
	public Date getJiguan_kaitiem() {
		return jiguan_kaitiem;
	}
	public void setJiguan_kaitiem(Date jiguan_kaitiem) {
		this.jiguan_kaitiem = jiguan_kaitiem;
	}
	public Date getJiguan_endtiem() {
		return jiguan_endtiem;
	}
	public void setJiguan_endtiem(Date jiguan_endtiem) {
		this.jiguan_endtiem = jiguan_endtiem;
	}
	public String getLun_renyuan() {
		return lun_renyuan;
	}
	public void setLun_renyuan(String lun_renyuan) {
		this.lun_renyuan = lun_renyuan;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getLun_kaitiem() {
		return lun_kaitiem;
	}
	public Date getLun_endtiem() {
		return lun_endtiem;
	}
	public Overviewdata() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
