package com.sam.ams.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the LU_VEHICLE_TYPES database table.
 * 
 */
@Entity
@Table(name="LU_VEHICLE_TYPES")
@NamedQuery(name="LuVehicleType.findAll", query="SELECT l FROM LuVehicleType l")
public class LuVehicleType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="VEHICLE_TYPE_ID")
	private int vehicleTypeId;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="CREATED_DATE")
	private Timestamp createdDate;

	@Column(name="IS_ACTIVE")
	private String isActive;

	@Column(name="MODIFIED_DATE")
	private Timestamp modifiedDate;

	@Column(name="VEHICLE_DESCRIPTION")
	private String vehicleDescription;

	@Column(name="VEHICLE_TYPE_CODE")
	private String vehicleTypeCode;

	public LuVehicleType() {
	}

	public int getVehicleTypeId() {
		return this.vehicleTypeId;
	}

	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getVehicleDescription() {
		return this.vehicleDescription;
	}

	public void setVehicleDescription(String vehicleDescription) {
		this.vehicleDescription = vehicleDescription;
	}

	public String getVehicleTypeCode() {
		return this.vehicleTypeCode;
	}

	public void setVehicleTypeCode(String vehicleTypeCode) {
		this.vehicleTypeCode = vehicleTypeCode;
	}

}