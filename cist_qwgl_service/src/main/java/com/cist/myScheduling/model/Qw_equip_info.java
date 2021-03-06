/**
 * 
 */
package com.cist.myScheduling.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 装备信息
 *
 */
public class Qw_equip_info implements Serializable{
	private static final long serialVersionUID = 7358217240965000889L;
    private Integer pk_id;//id
    private Integer fk_police_team_id;//警组id
    private Integer fk_report_id;//报备id
    private Integer guns;//枪支
    private Integer ammo;//弹药
    private Integer mobile;//手机对讲机
    private Integer baton;//警棍
    private Integer recorder;//执法记录仪
    private Integer handcuffs;//手铐
    private Integer flashlight;//手电
    private Integer med_pack;//急救包
    private Integer tear_spary;//催泪喷射器
    private Integer bulletproof_vest;//防弹背心
    private Integer riot_helmet;//防暴头盔
    private Integer riot_fork;//防暴叉
    private Integer life_jacket;//救生衣
    private Integer lifelines;//救生绳
    private Integer shield;//盾牌
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getFk_police_team_id() {
		return fk_police_team_id;
	}
	public void setFk_police_team_id(Integer fk_police_team_id) {
		this.fk_police_team_id = fk_police_team_id;
	}
	public Integer getGuns() {
		return guns;
	}
	public void setGuns(Integer guns) {
		this.guns = guns;
	}
	public Integer getAmmo() {
		return ammo;
	}
	public void setAmmo(Integer ammo) {
		this.ammo = ammo;
	}
	public Integer getMobile() {
		return mobile;
	}
	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}
	public Integer getBaton() {
		return baton;
	}
	public void setBaton(Integer baton) {
		this.baton = baton;
	}
	public Integer getRecorder() {
		return recorder;
	}
	public void setRecorder(Integer recorder) {
		this.recorder = recorder;
	}
	public Integer getHandcuffs() {
		return handcuffs;
	}
	public void setHandcuffs(Integer handcuffs) {
		this.handcuffs = handcuffs;
	}
	public Integer getFlashlight() {
		return flashlight;
	}
	public void setFlashlight(Integer flashlight) {
		this.flashlight = flashlight;
	}
	public Integer getMed_pack() {
		return med_pack;
	}
	public void setMed_pack(Integer med_pack) {
		this.med_pack = med_pack;
	}
	public Integer getTear_spary() {
		return tear_spary;
	}
	public void setTear_spary(Integer tear_spary) {
		this.tear_spary = tear_spary;
	}
	public Integer getBulletproof_vest() {
		return bulletproof_vest;
	}
	public void setBulletproof_vest(Integer bulletproof_vest) {
		this.bulletproof_vest = bulletproof_vest;
	}
	public Integer getRiot_helmet() {
		return riot_helmet;
	}
	public void setRiot_helmet(Integer riot_helmet) {
		this.riot_helmet = riot_helmet;
	}
	public Integer getRiot_fork() {
		return riot_fork;
	}
	public void setRiot_fork(Integer riot_fork) {
		this.riot_fork = riot_fork;
	}
	public Integer getLife_jacket() {
		return life_jacket;
	}
	public void setLife_jacket(Integer life_jacket) {
		this.life_jacket = life_jacket;
	}
	public Integer getLifelines() {
		return lifelines;
	}
	public void setLifelines(Integer lifelines) {
		this.lifelines = lifelines;
	}
	public Integer getShield() {
		return shield;
	}
	public void setShield(Integer shield) {
		this.shield = shield;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Qw_equip_info(Integer pk_id, Integer fk_police_team_id, Integer fk_report_id, Integer guns, Integer ammo,
			Integer mobile, Integer baton, Integer recorder, Integer handcuffs, Integer flashlight, Integer med_pack,
			Integer tear_spary, Integer bulletproof_vest, Integer riot_helmet, Integer riot_fork, Integer life_jacket,
			Integer lifelines, Integer shield) {
		super();
		this.pk_id = pk_id;
		this.fk_police_team_id = fk_police_team_id;
		this.fk_report_id = fk_report_id;
		this.guns = guns;
		this.ammo = ammo;
		this.mobile = mobile;
		this.baton = baton;
		this.recorder = recorder;
		this.handcuffs = handcuffs;
		this.flashlight = flashlight;
		this.med_pack = med_pack;
		this.tear_spary = tear_spary;
		this.bulletproof_vest = bulletproof_vest;
		this.riot_helmet = riot_helmet;
		this.riot_fork = riot_fork;
		this.life_jacket = life_jacket;
		this.lifelines = lifelines;
		this.shield = shield;
	}
	public Qw_equip_info() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getFk_report_id() {
		return fk_report_id;
	}
	public void setFk_report_id(Integer fk_report_id) {
		this.fk_report_id = fk_report_id;
	}
   
}
