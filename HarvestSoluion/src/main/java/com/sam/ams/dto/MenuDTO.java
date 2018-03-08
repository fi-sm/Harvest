package com.sam.ams.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Samarjeet
 *
 */
public class MenuDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1582838808284316747L;
	private Integer moduleId;
	private Integer priority;
	private String moduleLabel;	
	private List <SubMenuDTO> subMenuList;
	/**
	 * @return the moduleId
	 */
	public Integer getModuleId() {
		return moduleId;
	}
	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	/**
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	/**
	 * @return the moduleLabel
	 */
	public String getModuleLabel() {
		return moduleLabel;
	}
	/**
	 * @param moduleLabel the moduleLabel to set
	 */
	public void setModuleLabel(String moduleLabel) {
		this.moduleLabel = moduleLabel;
	}
	/**
	 * @return the subMenuList
	 */
	public List<SubMenuDTO> getSubMenuList() {
		return subMenuList;
	}
	/**
	 * @param subMenuList the subMenuList to set
	 */
	public void setSubMenuList(List<SubMenuDTO> subMenuList) {
		this.subMenuList = subMenuList;
	}
}
