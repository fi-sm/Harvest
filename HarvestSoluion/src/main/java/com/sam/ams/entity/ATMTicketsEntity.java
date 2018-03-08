package com.sam.ams.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "atmticketsdetail")
public class ATMTicketsEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ticketId;
	@Column
	private String atmID;
	@Column
	private String category;
	@Column
	private String location;
	@Column
	private String creatextime;
	@Column
	private String vendor;
	@Column
	private String ticketsDetail;
	
	/**
	 * @return the ticketId
	 */
	public long getTicketId() {
		return ticketId;
	}
	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	/**
	 * @return the atmID
	 */
	public String getAtmID() {
		return atmID;
	}
	/**
	 * @param atmID the atmID to set
	 */
	public void setAtmID(String atmID) {
		this.atmID = atmID;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the creatextime
	 */
	public String getCreatextime() {
		return creatextime;
	}
	/**
	 * @param creatextime the creatextime to set
	 */
	public void setCreatextime(String creatextime) {
		this.creatextime = creatextime;
	}
	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}
	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	/**
	 * @return the ticketsDetail
	 */
	public String getTicketsDetail() {
		return ticketsDetail;
	}
	/**
	 * @param ticketsDetail the ticketsDetail to set
	 */
	public void setTicketsDetail(String ticketsDetail) {
		this.ticketsDetail = ticketsDetail;
	}
	
	
	

}
