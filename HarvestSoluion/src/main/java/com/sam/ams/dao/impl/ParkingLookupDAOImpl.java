package com.sam.ams.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sam.ams.dao.ParkingLookupDAO;
import com.sam.ams.entity.LuMemberType;
import com.sam.ams.entity.LuRateSlab;
import com.sam.ams.entity.LuVehicleType;
import com.sam.ams.entity.CustomerInfo;
import com.sam.ams.entity.ParkingUser;

@Repository
public class ParkingLookupDAOImpl implements ParkingLookupDAO {

	@Autowired
	SessionFactory sessionFactory;



	public List<LuRateSlab> fetchRateSlabList(LuRateSlab luRateSlab) {
		Session session = sessionFactory.openSession();
		Criteria criteria = null;
		List<LuRateSlab> results=null;
		try {
			criteria = session.createCriteria(LuRateSlab.class);
            results =criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return results;
		
	}

	
	public void addRateSlabDetail(LuRateSlab luRateSlab) {
		Session session = sessionFactory.openSession();
		System.out.println(luRateSlab);
	//	Transaction tx = session.beginTransaction();
		session.save(luRateSlab);
	//	tx.commit();
		session.close();
		
	}
	
	
	/**
	 * Vehicle Type
	 */
	
	
	public List<LuVehicleType> fetchVehicleTypeList(LuVehicleType luRateSlab) {
		Session session = sessionFactory.openSession();
		Criteria criteria = null;
		List<LuVehicleType> results=null;
		try {
			criteria = session.createCriteria(LuVehicleType.class);
            results =criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return results;
		
	}

	
	public void addVehicleTypeDetail(LuVehicleType luVehicleType) {
		Session session = sessionFactory.openSession();
	//	Transaction tx = session.beginTransaction();
		session.save(luVehicleType);
	//	tx.commit();
		session.close();
		
	}
	
	
	/**
	 * Member Type
	 */
	
	public List<LuMemberType> fetchMemberTypeList(LuMemberType luRateSlab) {
		Session session = sessionFactory.openSession();
		Criteria criteria = null;
		List<LuMemberType> results=null;
		try {
			criteria = session.createCriteria(LuMemberType.class);
            results =criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return results;
		
	}

	
	public void addMemberTypeDetail(LuMemberType luMemberType) {
		Session session = sessionFactory.openSession();
	//	Transaction tx = session.beginTransaction();
		session.save(luMemberType);
	//	tx.commit();
		session.close();
		
	}
	
	
	/**
	 * Members
	 */
	
	public List<CustomerInfo> fetchMembersList(CustomerInfo luRateSlab) {
		Session session = sessionFactory.openSession();
		Criteria criteria = null;
		List<CustomerInfo> results=null;
		try {
			criteria = session.createCriteria(CustomerInfo.class);
            results =criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return results;
		
	}

	
	public void addMemberDetail(CustomerInfo parkingMembersInfo) {
		Session session = sessionFactory.openSession();
	//	Transaction tx = session.beginTransaction();
		session.save(parkingMembersInfo);
	//	tx.commit();
		session.close();
		
	}
	
	
	/**
	 * Parking User
	 */
	
	public List<ParkingUser> fetchParkingUserList(ParkingUser parkingUser) {
		Session session = sessionFactory.openSession();
		Criteria criteria = null;
		List<ParkingUser> results=null;
		try {
			criteria = session.createCriteria(ParkingUser.class);
            results =criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return results;
		
	}

	
	public void addParkingUserDetail(ParkingUser parkingUser) {
		Session session = sessionFactory.openSession();
	//	Transaction tx = session.beginTransaction();
		session.save(parkingUser);
	//	tx.commit();
		session.close();
		
	}
	
	
	
}