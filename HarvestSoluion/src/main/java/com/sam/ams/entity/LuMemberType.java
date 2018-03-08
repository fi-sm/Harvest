package com.sam.ams.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the LU_MEMBER_TYPE database table.
 * 
 */
@Entity
@Table(name="LU_MEMBER_TYPE")
@NamedQuery(name="LuMemberType.findAll", query="SELECT l FROM LuMemberType l")
public class LuMemberType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MEMBER_TYPE_ID")
	private int memberTypeId;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="CREATED_DATE")
	private Timestamp createdDate;

	@Column(name="IS_ACTIVE")
	private String isActive;

	@Column(name="MEMBER_DESCRIPTION")
	private String memberDescription;

	@Column(name="MEMBER_TYPE_CODE")
	private String memberTypeCode;

	@Column(name="MODIFIED_DATE")
	private Timestamp modifiedDate;

	public LuMemberType() {
	}

	public int getMemberTypeId() {
		return this.memberTypeId;
	}

	public void setMemberTypeId(int memberTypeId) {
		this.memberTypeId = memberTypeId;
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

	public String getMemberDescription() {
		return this.memberDescription;
	}

	public void setMemberDescription(String memberDescription) {
		this.memberDescription = memberDescription;
	}

	public String getMemberTypeCode() {
		return this.memberTypeCode;
	}

	public void setMemberTypeCode(String memberTypeCode) {
		this.memberTypeCode = memberTypeCode;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}