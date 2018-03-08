package com.sam.ams.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sitestatusdetail")
public class SiteDetailsEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String siteId;
	@Column
	private String siteName;
	@Column
	private String mobile1;
	@Column
	private String mobile2;
	@Column
	private String status;
	@Column
	private String commercialPower;
	
	@Column
	private String dg;
	@Column
	private String loadStatus;
	@Column
	private String batVoltage;
	@Column
	private String temperature;
	@Column
	private String mainContactor;
	@Column
	private String dgContractor;
	
	
	@Column
	private String dgBatetory;
	@Column
	private String dgSafety1;
	@Column
	private String dgSafety2;
	@Column
	private String dgFuelLevel;
	@Column
	private String dgRunHours;
	@Column
	private String batRunHours;
	
	@Column
	private String mainsRunHours;
	@Column
	private String contactNumber;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCommercialPower() {
		return commercialPower;
	}
	public void setCommercialPower(String commercialPower) {
		this.commercialPower = commercialPower;
	}
	public String getDg() {
		return dg;
	}
	public void setDg(String dg) {
		this.dg = dg;
	}
	public String getLoadStatus() {
		return loadStatus;
	}
	public void setLoadStatus(String loadStatus) {
		this.loadStatus = loadStatus;
	}
	public String getBatVoltage() {
		return batVoltage;
	}
	public void setBatVoltage(String batVoltage) {
		this.batVoltage = batVoltage;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getMainContactor() {
		return mainContactor;
	}
	public void setMainContactor(String mainContactor) {
		this.mainContactor = mainContactor;
	}
	public String getDgContractor() {
		return dgContractor;
	}
	public void setDgContractor(String dgContractor) {
		this.dgContractor = dgContractor;
	}
	public String getDgBatetory() {
		return dgBatetory;
	}
	public void setDgBatetory(String dgBatetory) {
		this.dgBatetory = dgBatetory;
	}
	public String getDgSafety1() {
		return dgSafety1;
	}
	public void setDgSafety1(String dgSafety1) {
		this.dgSafety1 = dgSafety1;
	}
	public String getDgSafety2() {
		return dgSafety2;
	}
	public void setDgSafety2(String dgSafety2) {
		this.dgSafety2 = dgSafety2;
	}
	public String getDgFuelLevel() {
		return dgFuelLevel;
	}
	public void setDgFuelLevel(String dgFuelLevel) {
		this.dgFuelLevel = dgFuelLevel;
	}
	public String getDgRunHours() {
		return dgRunHours;
	}
	public void setDgRunHours(String dgRunHours) {
		this.dgRunHours = dgRunHours;
	}
	public String getBatRunHours() {
		return batRunHours;
	}
	public void setBatRunHours(String batRunHours) {
		this.batRunHours = batRunHours;
	}
	public String getMainsRunHours() {
		return mainsRunHours;
	}
	public void setMainsRunHours(String mainsRunHours) {
		this.mainsRunHours = mainsRunHours;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	
	
	
	
	
	
	
	
}
