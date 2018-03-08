package com.sam.ams.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ATMInputMessage")
public class ATMRequestMessageEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long inputmsgid;
	@Column
	private String termid;
	@Column
	private String msgtype;
	@Column
	private String category;
	@Column
	private String msgxdate;
	@Column
	private String msgxtime;
	@Column
	private String msgdata;
	@Column
	private int msglen;
	/**
	 * @return the inputmsgid
	 */
	public long getInputmsgid() {
		return inputmsgid;
	}
	/**
	 * @param inputmsgid the inputmsgid to set
	 */
	public void setInputmsgid(long inputmsgid) {
		this.inputmsgid = inputmsgid;
	}
	/**
	 * @return the termid
	 */
	public String getTermid() {
		return termid;
	}
	/**
	 * @param termid the termid to set
	 */
	public void setTermid(String termid) {
		this.termid = termid;
	}
	/**
	 * @return the msgtype
	 */
	public String getMsgtype() {
		return msgtype;
	}
	/**
	 * @param msgtype the msgtype to set
	 */
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	/**
	 * @return the msgxdate
	 */
	public String getMsgxdate() {
		return msgxdate;
	}
	/**
	 * @param msgxdate the msgxdate to set
	 */
	public void setMsgxdate(String msgxdate) {
		this.msgxdate = msgxdate;
	}
	/**
	 * @return the msgxtime
	 */
	public String getMsgxtime() {
		return msgxtime;
	}
	/**
	 * @param msgxtime the msgxtime to set
	 */
	public void setMsgxtime(String msgxtime) {
		this.msgxtime = msgxtime;
	}
	/**
	 * @return the msgdata
	 */
	public String getMsgdata() {
		return msgdata;
	}
	/**
	 * @param msgdata the msgdata to set
	 */
	public void setMsgdata(String msgdata) {
		this.msgdata = msgdata;
	}
	/**
	 * @return the msglen
	 */
	public int getMsglen() {
		return msglen;
	}
	/**
	 * @param msglen the msglen to set
	 */
	public void setMsglen(int msglen) {
		this.msglen = msglen;
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

}
