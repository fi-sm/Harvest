package com.sam.ams.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sam.ams.component.AMSMasterComponent;
import com.sam.ams.component.AMSMasterComponentImpl;
import com.sam.ams.component.CustomerDetailBean;
import com.sam.ams.component.DataTableGridBean;
import com.sam.ams.component.LoginComponent;
import com.sam.ams.component.LoginComponentImpl;
import com.sam.ams.component.MenuComponentImpl;
import com.sam.ams.component.SiteStatusGridBean;
import com.sam.ams.dto.MenuDTO;
import com.sam.ams.dto.PocTable;
import com.sam.ams.entity.Employee;
import com.sam.ams.entity.CustomerBillingInfo;
import com.sam.ams.service.UserTrayService;
import com.sam.app.dto.AppCommonBean;
import com.sam.test.service.EmployeeService;

@Controller
public class AMSUIController {


	@Autowired
	private EmployeeService employeeService;
	 @Autowired
	 UserTrayService userTrayService;

	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getData() {

		ModelAndView model = new ModelAndView("index");
	
		return model;

	}*/

	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView loadBoozePage() 
	{
		ModelAndView modelAndView =null;
		try
		{
			AppCommonBean appCommonBean=new AppCommonBean();
			modelAndView =new ModelAndView ("AMSLogin");
			//modelAndView =new ModelAndView ("ParkingSystem");
			MenuComponentImpl menuComponentImpl=new MenuComponentImpl();
			List<MenuDTO> menuList =menuComponentImpl.boozeMenuItem(appCommonBean);
			modelAndView.addObject("menuList", menuList);
			
			
			
		}
		catch(Exception e)
		{	
			modelAndView.addObject("greeting", "Credential is  inValid.");
			modelAndView =new ModelAndView ("index");
		}
		return modelAndView;
	}
	
	public static void main (String args[]){
		AppCommonBean appCommonBean=new AppCommonBean();
		appCommonBean.setLoginid("samarjeet");
		appCommonBean.setPasswd("samarjeet123");
		
		LoginComponent loginComponent=new LoginComponentImpl();
		loginComponent.authonticateUser(appCommonBean);
	}

	@RequestMapping(value="/AMS", method = RequestMethod.POST)
	public ModelAndView  AMSModule(ModelMap model,HttpServletRequest request) {
		System.out.println("request:"+request.getParameter("iv-user"));
	
		 ModelAndView modelAndView =null;
		 try
			{
		AppCommonBean appCommonBean=new AppCommonBean();
		appCommonBean.setLoginid(request.getParameter("iv-user"));
		appCommonBean.setPasswd(request.getParameter("password"));
		LoginComponent loginComponent=new LoginComponentImpl();
		AppCommonBean outAppCommonBean=loginComponent.authonticateUser(appCommonBean);
		if(true==outAppCommonBean.getIsLogin())
		{
	    modelAndView =new ModelAndView ("ParkingSystem");
		MenuComponentImpl menuComponentImpl=new MenuComponentImpl();
		List<MenuDTO> menuList =menuComponentImpl.fetchMenu(appCommonBean);
		modelAndView.addObject("menuList", menuList);
		}
		else
		{
			modelAndView =new ModelAndView ("Booze");
			modelAndView.addObject("greeting", "Credential is  inValid.");	
		}
			}
			catch(Exception e)
			{	
				modelAndView =new ModelAndView ("Booze");
				modelAndView.addObject("greeting", "Credential is  inValid.");

			}
		return modelAndView;
	}

	
	@RequestMapping(value="/customers", method = RequestMethod.POST)
	public ModelAndView getAllCustomers(ModelMap model) {
		ModelAndView modelAndView=null;
		AMSMasterComponent AMSMasterComponent=new AMSMasterComponentImpl();
		AppCommonBean appCommonBean=new AppCommonBean();
		List<CustomerDetailBean> customersList =AMSMasterComponent.listAllCustomer(appCommonBean);
		modelAndView =new ModelAndView ("Customer");
		modelAndView.addObject("customersList", customersList);
		return modelAndView;
	}
	
	@RequestMapping(value="/atmRequestMessage", method = RequestMethod.POST)
	public ModelAndView getAllATMRequestMessage(ModelMap model) {
		ModelAndView modelAndView=null;
		
		AppCommonBean appCommonBean=new AppCommonBean();
		List<DataTableGridBean> list=userTrayService.getATMRequestMessages(appCommonBean);
		modelAndView =new ModelAndView ("ATMSwitchRequestMessage");
		modelAndView.addObject("dataTableList", list);
		return modelAndView;
	}
	
	@RequestMapping(value="/tickets", method = RequestMethod.POST)
	public ModelAndView getTickets(ModelMap model) {
		ModelAndView modelAndView=null;
		
		AppCommonBean appCommonBean=new AppCommonBean();
		List<DataTableGridBean> list=userTrayService.getTickets(appCommonBean);
		modelAndView =new ModelAndView ("Tikets");
		modelAndView.addObject("dataTableList", list);
		return modelAndView;
	}
	
	@RequestMapping(value="/dispatchTikets", method = RequestMethod.POST)
	public ModelAndView getDispatchTickets(ModelMap model) {
		ModelAndView modelAndView=null;
		
		AppCommonBean appCommonBean=new AppCommonBean();
		appCommonBean.setRole("1");
		List<DataTableGridBean> list=userTrayService.getTickets(appCommonBean);
		modelAndView =new ModelAndView ("DispatchTicktes");
		modelAndView.addObject("dataTableList", list);
		return modelAndView;
	}
	
	@RequestMapping(value="/dashBoard", method = RequestMethod.POST)
	public ModelAndView openDashBoard(ModelMap model) {
		ModelAndView modelAndView=null;
	
		AppCommonBean appCommonBean=new AppCommonBean();
		List<DataTableGridBean> list=userTrayService.getATMRequestMessages(appCommonBean);
		modelAndView =new ModelAndView ("DashBoard");
		modelAndView.addObject("dataTableList", list);
		


		return modelAndView;
	}
	
	@RequestMapping(value="/graph", method = RequestMethod.POST)
	public ModelAndView getGraphPage(ModelMap model) {
		ModelAndView modelAndView=null;
	
		modelAndView =new ModelAndView ("CHART1");

		return modelAndView;
	}
	
	@RequestMapping(value="/graph2", method = RequestMethod.POST)
	public ModelAndView getGraphPage2(ModelMap model) {
		ModelAndView modelAndView=null;
	
		modelAndView =new ModelAndView ("CHART2");

		return modelAndView;
	}
	
	@RequestMapping(value="/graph3", method = RequestMethod.POST)
	public ModelAndView getGraphPage3(ModelMap model) {
		ModelAndView modelAndView=null;
	
		modelAndView =new ModelAndView ("CHART3");

		return modelAndView;
	}
	
	
	@RequestMapping(value="/graphdata", method = RequestMethod.POST)
	public ModelAndView getGraphPageData(ModelMap model) {
		ModelAndView modelAndView=null;
	
		modelAndView =new ModelAndView ("CHART1");

		return modelAndView;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/usertray", method = RequestMethod.POST)
	public ModelAndView userTray(ModelMap model) {
ModelAndView modelAndView=null;
		
		AppCommonBean appCommonBean=new AppCommonBean();
		List<DataTableGridBean> list=userTrayService.getATMRequestMessages(appCommonBean);
		modelAndView =new ModelAndView ("DefectUserTray");
		modelAndView.addObject("dataTableList", list);
		return modelAndView;
	}
	
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/employees", method = RequestMethod.POST)
	public ModelAndView employeeList(ModelMap model) {
ModelAndView modelAndView=null;
		
		AppCommonBean appCommonBean=new AppCommonBean();
		List<DataTableGridBean> list=userTrayService.getEmployeeList(appCommonBean);
		modelAndView =new ModelAndView ("EmployeeList");
		modelAndView.addObject("dataTableList", list);
		return modelAndView;
	}
	
	@RequestMapping(value="/boozeItem", method = RequestMethod.POST)
	public ModelAndView booseItems(ModelMap model) {
		ModelAndView modelAndView=null;
		AMSMasterComponent AMSMasterComponent=new AMSMasterComponentImpl();
		AppCommonBean appCommonBean=new AppCommonBean();
		List<CustomerDetailBean> customersList =AMSMasterComponent.listAllCustomer(appCommonBean);
		modelAndView =new ModelAndView ("BoozeItems");
		modelAndView.addObject("customersList", customersList);
		return modelAndView;
	}
	@RequestMapping(value="/rate.c", method = RequestMethod.POST)
	public String getRate(ModelMap model) {
		model.addAttribute("greeting", "Rate List will be display soon");
		return "Customer";
	}
	@RequestMapping(value="/type", method = RequestMethod.POST)
	public String getTypes(ModelMap model) {
		model.addAttribute("greeting", "Type page is under cunstruction");
		return "BoozeItems";
	}
	
	

	@RequestMapping(value = "addEmployees", method = RequestMethod.POST)
	public ModelAndView viewRegister(@ModelAttribute Employee employee) {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute Employee employee) {
		employee.setLogedIn("Y");
		employeeService.createEmployee(employee);
		ModelAndView modelAndView = null;
		modelAndView =new ModelAndView ("ParkingSystem");
		AppCommonBean appCommonBean=new AppCommonBean();
		MenuComponentImpl menuComponentImpl=new MenuComponentImpl();
		List<MenuDTO> menuList =menuComponentImpl.fetchMenu(appCommonBean);
		modelAndView.addObject("menuList", menuList);
		return modelAndView;
	}

	

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute Employee employee) {
		Employee emp = employeeService.getEmployee(employee);
		ModelAndView modelAndView = null;
		if (emp == null) {
			modelAndView =new ModelAndView ("AMSLogin");
			modelAndView.addObject("errorMessage", "*Invalid credential!!");
		} else {
			modelAndView =new ModelAndView ("ParkingSystem");
			modelAndView.addObject("emp", emp.getName());
			AppCommonBean appCommonBean=new AppCommonBean();
			appCommonBean.setLoginid(emp.getUsername());
			appCommonBean.setPasswd(emp.getPassword());
			MenuComponentImpl menuComponentImpl=new MenuComponentImpl();
			List<MenuDTO> menuList =menuComponentImpl.fetchMenu(appCommonBean);
			modelAndView.addObject("menuList", menuList);
		}
		return modelAndView;
	}


	@RequestMapping(value="/billingDetail", method = RequestMethod.POST)
	public ModelAndView getParkingStatusGriddata(ModelMap model) {
		ModelAndView modelAndView=null;
		
		CustomerBillingInfo appCommonBean=new CustomerBillingInfo();
		List<CustomerBillingInfo> list=userTrayService.fetchParkingStatusGriddata(appCommonBean);
		modelAndView =new ModelAndView ("ParkingStatusDetail");
		modelAndView.addObject("dataTableList", list);
		return modelAndView;
	}
	

	

	
	
	
	@RequestMapping(value = "poctable", method = RequestMethod.GET)
	public ModelAndView pocTable(HttpServletRequest request) {
	
			ModelAndView modelAndView = null;
			modelAndView =new ModelAndView ("PocTable");
			
			String siteName=request.getParameter("siteName");
			String siteId=request.getParameter("siteId");
			String mobileNumber=request.getParameter("mobileNumber");
			
			
			
			String siteStaus=request.getParameter("siteStatus");
			String commercialPower=request.getParameter("commercialPower");
			String dg=request.getParameter("dg");
			String loadStatus=request.getParameter("loadStatus");
			String batVolt=request.getParameter("batVolt");
			String temp=request.getParameter("temp");
			String mainsContractor=request.getParameter("mainsContractor");
			String dgContractor=request.getParameter("dgContractor");
			String dgBat=request.getParameter("dgBat");
			String dgSafety1=request.getParameter("dgSafety1");
			String dgSafety2=request.getParameter("dgSafety2");
			String dgFuelLevel=request.getParameter("dgFuelLevel");
			String dgRunHours=request.getParameter("dgRunHours");
			String batRunHours=request.getParameter("batRunHours");
			String mainRunHours=request.getParameter("mainRunHours");

			
			
			PocTable tbl = new PocTable();
			
			tbl.setSiteName(siteName);
			tbl.setSiteId(siteId);
			tbl.setMobileNumber(mobileNumber);
			
			tbl.setBatRunHours(batRunHours);
			tbl.setBatVolt(batVolt);
			tbl.setDgRunHours(dgRunHours);
			tbl.setCommercialPower(commercialPower);
			tbl.setDg(dg);
			tbl.setDgBat(dgBat);
			tbl.setDgContractor(dgContractor);
			tbl.setDgFuelLevel(dgFuelLevel);
			tbl.setDgSafety1(dgSafety1);
			tbl.setDgSafety2(dgSafety2);
			tbl.setLoadStatus(loadStatus);
			tbl.setMainRunHours(mainRunHours);
			tbl.setMainsContractor(mainsContractor);
			tbl.setSiteStaus(siteStaus);
			tbl.setTemp(temp);
			
			
			
			List<PocTable> obj= new ArrayList<PocTable>();
			obj.add(tbl);
			

			Map<String,Object> map= new HashMap<String, Object>();
		
			
			map.put("dataTableList", obj);
			
			modelAndView.addObject("map", map);
	
		return modelAndView;
	}
	
}
