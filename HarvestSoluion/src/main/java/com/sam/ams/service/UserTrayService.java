package com.sam.ams.service;

import java.util.List;

import com.sam.ams.component.DataTableGridBean;
import com.sam.ams.component.SiteStatusGridBean;
import com.sam.ams.dto.ATMRequestMessageDTO;
import com.sam.ams.entity.DefectsRequestEntity;
import com.sam.ams.entity.CustomerBillingInfo;
import com.sam.app.dto.AppCommonBean;

public interface UserTrayService {
	public void createDefects(DefectsRequestEntity defectsRequestEntity);
	public List<DataTableGridBean> getUserTray(AppCommonBean appCommonBean);
	public void insertATMRequestMessage(ATMRequestMessageDTO atmRequestMessageDTO);
	public List<DataTableGridBean> getATMRequestMessages(AppCommonBean appCommonBean);
	public List<CustomerBillingInfo> fetchParkingStatusGriddata(CustomerBillingInfo appCommonBean);

	public List<DataTableGridBean> getTickets(AppCommonBean appCommonBean);
	
	public List<DataTableGridBean> getEmployeeList(AppCommonBean appCommonBean);
}
