package com.sam.ams.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sam.ams.component.LoginComponent;
import com.sam.ams.component.LoginComponentImpl;
import com.sam.ams.entity.LuMemberType;
import com.sam.ams.entity.LuRateSlab;
import com.sam.ams.entity.LuVehicleType;
import com.sam.ams.entity.CustomerInfo;
import com.sam.ams.entity.ParkingUser;
import com.sam.ams.service.ParkingLookupService;
import com.sam.app.dto.AppCommonBean;

@Controller
public class LookupsUIController {


	 @Autowired
	 ParkingLookupService parkingLookupService;

	
	
	public static void main (String args[]){
		AppCommonBean appCommonBean=new AppCommonBean();
		appCommonBean.setLoginid("samarjeet");
		appCommonBean.setPasswd("samarjeet123");
		
		LoginComponent loginComponent=new LoginComponentImpl();
		loginComponent.authonticateUser(appCommonBean);
	}

	
	@RequestMapping(value = "addRateSlab", method = RequestMethod.POST)
	public ModelAndView addRateSlabDetail(@ModelAttribute LuRateSlab luRateSlab,HttpServletRequest request) {


		ModelAndView modelAndView=null;
		modelAndView =new ModelAndView ("LU_RateSlab");
		try
		{


			parkingLookupService.addRateSlabDetail(luRateSlab);
			List<LuRateSlab> list=parkingLookupService.fetchRateSlabList(luRateSlab);
			modelAndView.addObject("dataTableList", list);
		}
		catch (Exception e)
		{
			//TODO send log throw mail
		}
	
		

		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "getRateSlab", method = RequestMethod.POST)
	public ModelAndView getRateSlab(@ModelAttribute LuRateSlab luRateSlab,HttpServletRequest request) {


		ModelAndView modelAndView=null;
		modelAndView =new ModelAndView ("LU_RateSlab");
		try
		{

			List<LuRateSlab> list=parkingLookupService.fetchRateSlabList(luRateSlab);
			modelAndView.addObject("dataTableList", list);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			//TODO send log throw mail
		}
	
		

		return modelAndView;
	}
	
	
	
	
	
	

	
	
	
	
	


	@RequestMapping(value = "addCustomerr", method = RequestMethod.POST)
	public ModelAndView addParkingMember(@ModelAttribute CustomerInfo parkingMembersInfo,HttpServletRequest request) {

		ModelAndView modelAndView=null;
		modelAndView =new ModelAndView ("LU_ParkingMember");
		try
		{
			parkingLookupService.addMemberDetail(parkingMembersInfo);
			List<CustomerInfo> list=parkingLookupService.fetchMembersList(parkingMembersInfo);
			modelAndView.addObject("dataTableList", list);
		}
		catch (Exception e)
		{
			//TODO send log throw mail
		}
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "getCustomerr", method = RequestMethod.POST)
	public ModelAndView getParkingMember(@ModelAttribute CustomerInfo parkingMembersInfo,HttpServletRequest request) {

		ModelAndView modelAndView=null;
		modelAndView =new ModelAndView ("LU_ParkingMember");
		try
		{

			List<CustomerInfo> list=parkingLookupService.fetchMembersList(parkingMembersInfo);
			modelAndView.addObject("dataTableList", list);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			//TODO send log throw mail
		}
		return modelAndView;
	}
	
	
	
	
	
	


	@RequestMapping(value = "addAdminUser", method = RequestMethod.POST)
	public ModelAndView addAdminUser(@ModelAttribute ParkingUser parkingUser,HttpServletRequest request) {

		ModelAndView modelAndView=null;
		modelAndView =new ModelAndView ("LU_User");
		try
		{
			parkingLookupService.addParkingUserDetail(parkingUser);
			List<ParkingUser> list=parkingLookupService.fetchParkingUserList(parkingUser);
			modelAndView.addObject("dataTableList", list);
		}
		catch (Exception e)
		{
			//TODO send log throw mail
		}
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "getAdminUser", method = RequestMethod.POST)
	public ModelAndView getAdminUser(@ModelAttribute ParkingUser parkingUser,HttpServletRequest request) {

		ModelAndView modelAndView=null;
		modelAndView =new ModelAndView ("LU_User");
		try
		{

			List<ParkingUser> list=parkingLookupService.fetchParkingUserList(parkingUser);
			modelAndView.addObject("dataTableList", list);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			//TODO send log throw mail
		}
		return modelAndView;
	}
	
	
	


	@RequestMapping(value = "addMemberType", method = RequestMethod.POST)
	public ModelAndView addMemberType(@ModelAttribute LuMemberType luMemberType,HttpServletRequest request) {

		ModelAndView modelAndView=null;
		modelAndView =new ModelAndView ("LU_MemberType");
		try
		{
			parkingLookupService.addMemberTypeDetail(luMemberType);
			List<LuMemberType> list=parkingLookupService.fetchMemberTypeList(luMemberType);
			modelAndView.addObject("dataTableList", list);
		}
		catch (Exception e)
		{
			//TODO send log throw mail
		}
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "getMemberType", method = RequestMethod.POST)
	public ModelAndView getMemberType(@ModelAttribute LuMemberType luMemberType,HttpServletRequest request) {

		ModelAndView modelAndView=null;
		modelAndView =new ModelAndView ("LU_MemberType");
		try
		{

			List<LuMemberType> list=parkingLookupService.fetchMemberTypeList(luMemberType);
			modelAndView.addObject("dataTableList", list);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			//TODO send log throw mail
		}
		return modelAndView;
	}
	

	
}
