package com.sam.app.dto;

import java.io.Serializable;

public class AppCommonDynamoDB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8559878973781210734L;
	
	private String tableName;


	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
