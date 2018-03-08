package com.sam.ams.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the LU_RATE_SLAB database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_BILLING_INFO") 
public class BillingDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int Id;
	
	@Column(name="CUSTOMER_ID")
	private String customerID;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	

	@Column(name="TOTAL_UNIT")
	private String totalUnit;
	
	@Column(name="CHARGE_PER_UNIT")
	private int chargePerUnit;
	
	@Column(name="CASH_DEPOSIT")
	private int cashDeposit;
	
	@Column(name="DISCOUNT")
	private int discount;
	
	@Column(name="TOTAL_CHARGE_AFTER_DIS")
	private int totalChargeAfterDiscount;
	

	@Column(name="REMARKS")
	private String remarks;


	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}


	/**
	 * @return the customerID
	 */
	public String getCustomerID() {
		return customerID;
	}


	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}


	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}


	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	/**
	 * @return the totalUnit
	 */
	public String getTotalUnit() {
		return totalUnit;
	}


	/**
	 * @param totalUnit the totalUnit to set
	 */
	public void setTotalUnit(String totalUnit) {
		this.totalUnit = totalUnit;
	}


	/**
	 * @return the chargePerUnit
	 */
	public int getChargePerUnit() {
		return chargePerUnit;
	}


	/**
	 * @param chargePerUnit the chargePerUnit to set
	 */
	public void setChargePerUnit(int chargePerUnit) {
		this.chargePerUnit = chargePerUnit;
	}


	/**
	 * @return the cashDeposit
	 */
	public int getCashDeposit() {
		return cashDeposit;
	}


	/**
	 * @param cashDeposit the cashDeposit to set
	 */
	public void setCashDeposit(int cashDeposit) {
		this.cashDeposit = cashDeposit;
	}


	/**
	 * @return the discount
	 */
	public int getDiscount() {
		return discount;
	}


	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}


	/**
	 * @return the totalChargeAfterDiscount
	 */
	public int getTotalChargeAfterDiscount() {
		return totalChargeAfterDiscount;
	}


	/**
	 * @param totalChargeAfterDiscount the totalChargeAfterDiscount to set
	 */
	public void setTotalChargeAfterDiscount(int totalChargeAfterDiscount) {
		this.totalChargeAfterDiscount = totalChargeAfterDiscount;
	}


	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}


	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


}