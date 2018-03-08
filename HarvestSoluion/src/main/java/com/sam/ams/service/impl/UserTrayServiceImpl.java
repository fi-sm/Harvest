package com.sam.ams.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.ams.component.DataTableGridBean;
import com.sam.ams.component.SiteStatusGridBean;
import com.sam.ams.dao.UserTrayDAO;
import com.sam.ams.dto.ATMRequestMessageDTO;
import com.sam.ams.entity.ATMRequestMessageEntity;
import com.sam.ams.entity.ATMTicketsEntity;
import com.sam.ams.entity.DefectsRequestEntity;
import com.sam.ams.entity.Employee;
import com.sam.ams.entity.CustomerBillingInfo;
import com.sam.ams.entity.SiteDetailsEntity;
import com.sam.ams.service.UserTrayService;
import com.sam.app.dto.AppCommonBean;

@Service
@Transactional
public class UserTrayServiceImpl implements UserTrayService {

	@Autowired
	private UserTrayDAO  userTrayDAO;
	//EmployeeDAO employeeDAO =new EmployeeDAOImpl();
	
	

	
	/**
	 * 
	 */
		public void insertATMRequestMessage(ATMRequestMessageDTO atmRequestMessageDTO) {
			// TODO Auto-generated method stub
			
			ATMRequestMessageEntity atmRequestMessageEntity=new ATMRequestMessageEntity();
			atmRequestMessageEntity.setMsgdata(atmRequestMessageDTO.getMsgdata());
			atmRequestMessageEntity.setMsglen(atmRequestMessageDTO.getMsglen());
			atmRequestMessageEntity.setMsgtype(atmRequestMessageDTO.getMsgtype());
			atmRequestMessageEntity.setMsgxdate(atmRequestMessageDTO.getMsgxdate());
			atmRequestMessageEntity.setMsgxtime(atmRequestMessageDTO.getMsgxtime());
			atmRequestMessageEntity.setTermid(atmRequestMessageDTO.getTermid());
			atmRequestMessageEntity.setCategory(atmRequestMessageDTO.getCategory());
			if("1".equalsIgnoreCase(atmRequestMessageDTO.getCategory()))
			{
				systemGeneratedTickets(atmRequestMessageDTO);
			}
			System.out.println("Started");
			userTrayDAO.insertATMRequestMessage(atmRequestMessageEntity);
			System.out.println("Completed");
		}
	
		
		public void systemGeneratedTickets(ATMRequestMessageDTO atmRequestMessageDTO) {
			// TODO Auto-generated method stub
			
			ATMTicketsEntity atmRequestMessageEntity=new ATMTicketsEntity();
			atmRequestMessageEntity.setTicketsDetail(atmRequestMessageDTO.getMsgdata());
			atmRequestMessageEntity.setCategory(atmRequestMessageDTO.getCategory());
			atmRequestMessageEntity.setAtmID(atmRequestMessageDTO.getTermid());
			atmRequestMessageEntity.setLocation("Delhi");
			atmRequestMessageEntity.setVendor("Vortex");
			
			System.out.println("Started");
			userTrayDAO.systemGeneratedTickets(atmRequestMessageEntity);
			System.out.println("Completed");
		}
		
		
		
/**
 * 
 */
	public void createDefects(DefectsRequestEntity defectsRequestEntity) {
		// TODO Auto-generated method stub
		//userTrayDAO.createDefects(defectsRequestEntity);
		
	}

/**
 * 
 */
	public List<DataTableGridBean> getUserTray(AppCommonBean appCommonBean) {
		List<DataTableGridBean> datatableList=new ArrayList<DataTableGridBean>();
		DataTableGridBean dataTableGridBean=null;
		List<ATMRequestMessageEntity> messageList=null;
		messageList =userTrayDAO.getATMRequestMessages(appCommonBean);
		System.out.println("messageList:"+messageList);
		for(ATMRequestMessageEntity atmRequestMessage : messageList)
		{
			dataTableGridBean=new DataTableGridBean();
			dataTableGridBean.setField1(atmRequestMessage.getTermid());
			dataTableGridBean.setField2(String.valueOf(atmRequestMessage.getMsglen()));
			dataTableGridBean.setField3(atmRequestMessage.getMsgtype());
			dataTableGridBean.setField4(atmRequestMessage.getMsgxdate());
			dataTableGridBean.setField5(atmRequestMessage.getMsgxtime());
			dataTableGridBean.setField6(atmRequestMessage.getMsgdata());

			datatableList.add(dataTableGridBean);
		}
		return datatableList;
	}
	
	public List<DataTableGridBean> getATMRequestMessages(AppCommonBean appCommonBean) {
		List<DataTableGridBean> datatableList=new ArrayList<DataTableGridBean>();
		DataTableGridBean dataTableGridBean=null;
		List<ATMRequestMessageEntity> messageList=null;
		messageList =userTrayDAO.getATMRequestMessages(appCommonBean);
		System.out.println("messageList:"+messageList);
		for(ATMRequestMessageEntity atmRequestMessage : messageList)
		{
			dataTableGridBean=new DataTableGridBean();
			dataTableGridBean.setField1(atmRequestMessage.getTermid());
			dataTableGridBean.setField2(String.valueOf(atmRequestMessage.getMsglen()));
			dataTableGridBean.setField3(atmRequestMessage.getMsgtype());
			dataTableGridBean.setField4(atmRequestMessage.getMsgxdate());
			dataTableGridBean.setField5(atmRequestMessage.getMsgxtime());
			dataTableGridBean.setField6(atmRequestMessage.getMsgdata());
			dataTableGridBean.setField7(atmRequestMessage.getCategory());

			datatableList.add(dataTableGridBean);
		}
		return datatableList;
	}
	
	/*
	public List<DataTableGridBean> getSiteGriddata(AppCommonBean appCommonBean) {
		List<DataTableGridBean> datatableList=new ArrayList<DataTableGridBean>();
		DataTableGridBean dataTableGridBean=null;
		List<ATMRequestMessageEntity> messageList=null;
		messageList =userTrayDAO.getATMRequestMessages(appCommonBean);
		System.out.println("messageList:"+messageList);
		for(ATMRequestMessageEntity atmRequestMessage : messageList)
		{
			dataTableGridBean=new DataTableGridBean();
			dataTableGridBean.setField1(atmRequestMessage.getTermid());
			dataTableGridBean.setField2(String.valueOf(atmRequestMessage.getMsglen()));
			dataTableGridBean.setField3(atmRequestMessage.getMsgtype());
			dataTableGridBean.setField4(atmRequestMessage.getMsgxdate());
			dataTableGridBean.setField5(atmRequestMessage.getMsgxtime());
			dataTableGridBean.setField6(atmRequestMessage.getMsgdata());
			dataTableGridBean.setField7(atmRequestMessage.getCategory());

			datatableList.add(dataTableGridBean);
		}
		return datatableList;
	}
	
	*/
	
	
	
	
	
	public List<DataTableGridBean> getTickets(AppCommonBean appCommonBean) {
		List<DataTableGridBean> datatableList=new ArrayList<DataTableGridBean>();
		DataTableGridBean dataTableGridBean=null;
		List<ATMTicketsEntity> messageList=null;
		ATMTicketsEntity input=new ATMTicketsEntity();
		input.setCategory(appCommonBean.getRole());
		messageList =userTrayDAO.getTickets(input);
		System.out.println("messageList:"+messageList);
		for(ATMTicketsEntity atmTicketsEntity : messageList)
		{
			dataTableGridBean=new DataTableGridBean();
			dataTableGridBean.setField1(atmTicketsEntity.getTicketId()+"");
			dataTableGridBean.setField2(atmTicketsEntity.getAtmID());
			dataTableGridBean.setField3(atmTicketsEntity.getCategory());
			dataTableGridBean.setField4(atmTicketsEntity.getLocation());
			dataTableGridBean.setField5(atmTicketsEntity.getVendor());
			dataTableGridBean.setField6(atmTicketsEntity.getTicketsDetail());

			datatableList.add(dataTableGridBean);
		}
		return datatableList;
	}
	
	
	public List<DataTableGridBean> getEmployeeList(AppCommonBean appCommonBean) {
		List<DataTableGridBean> datatableList=new ArrayList<DataTableGridBean>();
		DataTableGridBean dataTableGridBean=null;
		List<Employee> messageList=null;
		messageList =userTrayDAO.getEployeeList(appCommonBean);
		System.out.println("messageList:"+messageList);
		for(Employee atmRequestMessage : messageList)
		{
			dataTableGridBean=new DataTableGridBean();
			dataTableGridBean.setField1(atmRequestMessage.getUsername());
			dataTableGridBean.setField2(String.valueOf(atmRequestMessage.getName()));
			dataTableGridBean.setField3(atmRequestMessage.getEmail());
			dataTableGridBean.setField4(atmRequestMessage.getAge()+"");
			dataTableGridBean.setField5(atmRequestMessage.getMobile());
			//dataTableGridBean.setField6(atmRequestMessage.getMsgdata());

			datatableList.add(dataTableGridBean);
		}
		return datatableList;
	}
	
	
	public List<CustomerBillingInfo> fetchParkingStatusGriddata(CustomerBillingInfo appCommonBean) {
		
	
	System.out.println("appCommonBean:fetchSiteStatusDetail  :"+appCommonBean);
	
		return userTrayDAO.fetchParkingStatusGriddata(appCommonBean);
		
	}
	
	

	

}
