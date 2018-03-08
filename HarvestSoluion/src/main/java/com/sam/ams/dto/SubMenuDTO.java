package com.sam.ams.dto;

import java.io.Serializable;


		/**
		 * 
		 * @author Samarjeet
		 *
		 */
public class SubMenuDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String menuId;
	private String menuURL;
	private String menuLabel;
	private Integer menuPriority;
	private String privilege;
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuURL() {
		return menuURL;
	}
	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}
	public String getMenuLabel() {
		return menuLabel;
	}
	public void setMenuLabel(String menuLabel) {
		this.menuLabel = menuLabel;
	}
	public Integer getMenuPriority() {
		return menuPriority;
	}
	public void setMenuPriority(Integer menuPriority) {
		this.menuPriority = menuPriority;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

}
