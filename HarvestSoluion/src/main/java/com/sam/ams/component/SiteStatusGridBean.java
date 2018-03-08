package com.sam.ams.component;

import java.io.Serializable;

public class SiteStatusGridBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5905142073168996914L;
	
	private String siteId;
	 
	private String siteName;
 
	private String mobile1;
 
	private String mobile2;
 
	private String status;
 
	private String commercialPower;
	
 
	private String dg;
 
	private String loadStatus;
 
	private String batVoltage;
 
	private String temperature;
 
	private String mainContactor;
 
	private String dgContractor;
	
	
 
	private String dgBatetory;
 
	private String dgSafety1;
 
	private String dgSafety2;
 
	private String dgFuelLevel;
 
	private String dgRunHours;
 
	private String batRunHours;
	
 
	private String mainsRunHours;
 
	private String contactNumber;

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
