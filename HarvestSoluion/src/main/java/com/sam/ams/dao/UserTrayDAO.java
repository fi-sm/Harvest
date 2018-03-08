package com.sam.ams.dao;

import java.util.List;

import com.sam.ams.dto.DefectsWrapperDTO;
import com.sam.ams.entity.ATMRequestMessageEntity;
import com.sam.ams.entity.ATMTicketsEntity;
import com.sam.ams.entity.DefectsRequestEntity;
import com.sam.ams.entity.Employee;
import com.sam.ams.entity.CustomerBillingInfo;
import com.sam.ams.entity.SiteDetailsEntity;
import com.sam.app.dto.AppCommonBean;

/**
 * 
 * @author SamarjeetYadav
 *
 */
public interface UserTrayDAO {
	public void createDefects(DefectsRequestEntity defectsRequestEntity);
	public DefectsWrapperDTO getUserTray(AppCommonBean appCommonBean);
	public void insertATMRequestMessage(ATMRequestMessageEntity atmRequestMessageEntity);
	public void systemGeneratedTickets(ATMTicketsEntity aTMTicketsEntity);
	public List<ATMRequestMessageEntity>  getATMRequestMessages(AppCommonBean appCommonBean);
	public List<Employee>  getEployeeList(AppCommonBean appCommonBean);
	public List<ATMTicketsEntity> getTickets(ATMTicketsEntity appCommonBean);
	public void addSiteStatusDetail(SiteDetailsEntity siteDetailsEntity);
	public void updateSiteStatusDetail(SiteDetailsEntity siteDetailsEntity);
	public List<CustomerBillingInfo> fetchParkingStatusGriddata(CustomerBillingInfo appCommonBean);

}
