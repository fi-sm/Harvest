package com.sam.ams.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.ams.dao.ParkingLookupDAO;
import com.sam.ams.entity.LuMemberType;
import com.sam.ams.entity.LuRateSlab;
import com.sam.ams.entity.LuVehicleType;
import com.sam.ams.entity.CustomerInfo;
import com.sam.ams.entity.ParkingUser;
import com.sam.ams.service.ParkingLookupService;

@Service
@Transactional
public class ParkingLookupServiceImpl implements ParkingLookupService {

	@Autowired
	private ParkingLookupDAO  parkingLookupDAO;
	
	
	
	
	/**
	 * 
	 */
	public List<LuRateSlab> fetchRateSlabList(LuRateSlab luRateSlab)
	{
		
		return parkingLookupDAO.fetchRateSlabList(luRateSlab);
	}
	public void addRateSlabDetail(LuRateSlab luRateSlab)
	{
		System.out.println(luRateSlab);
		try
		{
			parkingLookupDAO.addRateSlabDetail(luRateSlab);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 */
	public List<LuVehicleType> fetchVehicleTypeList(LuVehicleType luRateSlab)
	{
		
		return parkingLookupDAO.fetchVehicleTypeList(luRateSlab);
	}
	public void addVehicleTypeDetail(LuVehicleType luVehicleType)
	{
		parkingLookupDAO.addVehicleTypeDetail(luVehicleType);
	}
	
	
	/**
	 * 
	 */
	public List<LuMemberType> fetchMemberTypeList(LuMemberType luRateSlab)
	{
		return parkingLookupDAO.fetchMemberTypeList(luRateSlab);
	}
	public void addMemberTypeDetail(LuMemberType luMemberType){
		
		
		parkingLookupDAO.addMemberTypeDetail(luMemberType);
	}
	
	
	/**
	 * 
	 */
	public List<CustomerInfo> fetchMembersList(CustomerInfo luRateSlab)
	{
		return parkingLookupDAO.fetchMembersList(luRateSlab);
	}
	public void addMemberDetail(CustomerInfo parkingMembersInfo)
	{
		
		
		parkingLookupDAO.addMemberDetail(parkingMembersInfo);
	}
	
	
	/**
	 * 
	 */
	public List<ParkingUser> fetchParkingUserList(ParkingUser parkingUser)
	{
		
		
		return parkingLookupDAO.fetchParkingUserList(parkingUser);
	}
	public void addParkingUserDetail(ParkingUser parkingUser)
	{
		parkingLookupDAO.addParkingUserDetail(parkingUser);;
	}
	

}
