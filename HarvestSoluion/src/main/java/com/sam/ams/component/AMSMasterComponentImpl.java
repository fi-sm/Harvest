package com.sam.ams.component;

import java.util.ArrayList;
import java.util.List;

import com.sam.app.dto.AppCommonBean;

public class AMSMasterComponentImpl implements AMSMasterComponent{
	
	
	//Logger logger = Logger.getLogger(AMSMasterComponentImpl.class);
	
	/**
	 * @return List<GUIModuleBean>
	 * @param String
	 */
	public List<CustomerDetailBean> listAllCustomer(AppCommonBean appCommonBean)
	{
		List<CustomerDetailBean> customersList=new ArrayList<CustomerDetailBean>();	
		CustomerDetailBean customerDetailBean=new CustomerDetailBean();
		customerDetailBean.setEmailId("samar@gmail.com");
		customerDetailBean.setGender("M");
		customerDetailBean.setMobileNo("9876543212");
		customerDetailBean.setUserName("samarjeet");
		customerDetailBean.setUserId("samarjeet");
		customerDetailBean.setStatus("A");
		customersList.add(customerDetailBean);
		
		
		customerDetailBean=new CustomerDetailBean();
		customerDetailBean.setEmailId("samar@gmail.com");
		customerDetailBean.setGender("M");
		customerDetailBean.setMobileNo("9876543212");
		customerDetailBean.setUserName("samarjeet");
		customerDetailBean.setUserId("samarjeet");
		customerDetailBean.setStatus("A");
		customersList.add(customerDetailBean);
		
		return customersList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
