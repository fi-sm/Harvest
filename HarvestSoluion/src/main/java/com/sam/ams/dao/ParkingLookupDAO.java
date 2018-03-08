package com.sam.ams.dao;

import java.util.List;

import com.sam.ams.entity.LuMemberType;
import com.sam.ams.entity.LuRateSlab;
import com.sam.ams.entity.LuVehicleType;
import com.sam.ams.entity.CustomerInfo;
import com.sam.ams.entity.ParkingUser;

/**
 * 
 * @author SamarjeetYadav
 *
 */
public interface ParkingLookupDAO {
	public List<LuRateSlab> fetchRateSlabList(LuRateSlab luRateSlab);
	public void addRateSlabDetail(LuRateSlab luRateSlab);
	public List<LuVehicleType> fetchVehicleTypeList(LuVehicleType luRateSlab);
	public void addVehicleTypeDetail(LuVehicleType luVehicleType);
	public List<LuMemberType> fetchMemberTypeList(LuMemberType luRateSlab);
	public void addMemberTypeDetail(LuMemberType luMemberType);
	public List<CustomerInfo> fetchMembersList(CustomerInfo luRateSlab);
	public void addMemberDetail(CustomerInfo parkingMembersInfo);
	public List<ParkingUser> fetchParkingUserList(ParkingUser parkingUser);
	public void addParkingUserDetail(ParkingUser parkingUser);
	

}
