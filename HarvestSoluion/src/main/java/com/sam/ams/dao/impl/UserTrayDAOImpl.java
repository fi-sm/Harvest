package com.sam.ams.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sam.ams.dao.UserTrayDAO;
import com.sam.ams.dto.DefectsWrapperDTO;
import com.sam.ams.entity.ATMRequestMessageEntity;
import com.sam.ams.entity.ATMTicketsEntity;
import com.sam.ams.entity.DefectsRequestEntity;
import com.sam.ams.entity.Employee;
import com.sam.ams.entity.CustomerBillingInfo;
import com.sam.ams.entity.SiteDetailsEntity;
import com.sam.app.dto.AppCommonBean;

@Repository
public class UserTrayDAOImpl implements UserTrayDAO {

	@Autowired
	SessionFactory sessionFactory;

	//@Override
	public void createEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
	//	Transaction tx = session.beginTransaction();
		session.save(employee);
	//	tx.commit();
		session.close();
	}

	
	public Employee getEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Criteria criteria = null;
		Employee emp = null;
		try {
			criteria = session.createCriteria(Employee.class);
			Criterion criterion = Restrictions.eq("username",
					employee.getUsername());
			criteria.add(criterion);

			criteria.setMaxResults(1);
			emp = (Employee) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return emp;
	}

	/**
	 * 
	 */

	public void createDefects(DefectsRequestEntity defectsRequestEntity) {

		Session session = sessionFactory.openSession();
	//	Transaction tx = session.beginTransaction();
		session.save(defectsRequestEntity);
	//	tx.commit();
		session.close();
		
	}

	/**
	 * 
	 */
	
	public DefectsWrapperDTO getUserTray(AppCommonBean appCommonBean) {

		DefectsWrapperDTO DefectsWrapperDTO=null;
		Session session = sessionFactory.openSession();
		Criteria criteria = null;
		DefectsRequestEntity defectsRequestEntity = null;
		try {
			criteria = session.createCriteria(Employee.class);
			Criterion criterion = Restrictions.eq("username", "");
			criteria.add(criterion);

			criteria.setMaxResults(1);
			defectsRequestEntity = (DefectsRequestEntity) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return DefectsWrapperDTO;
	}


	public void insertATMRequestMessage(ATMRequestMessageEntity atmRequestMessageEntity) {
		// TODO Auto-generated method stub
		

		Session session = sessionFactory.openSession();
	//	Transaction tx = session.beginTransaction();
		session.save(atmRequestMessageEntity);
	//	tx.commit();
		session.close();
		
	}
	
	
	public void systemGeneratedTickets(ATMTicketsEntity atmRequestMessageEntity) {
		// TODO Auto-generated method stub
		

		Session session = sessionFactory.openSession();
	//	Transaction tx = session.beginTransaction();
		session.save(atmRequestMessageEntity);
	//	tx.commit();
		session.close();
		
	}


	public List<ATMRequestMessageEntity> getATMRequestMessages(AppCommonBean appCommonBean) {
		Session session = sessionFactory.openSession();
		Criteria criteria = null;
		List<ATMRequestMessageEntity> results=null;
		try {
			criteria = session.createCriteria(ATMRequestMessageEntity.class);
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
	
	
	public List<ATMTicketsEntity> getTickets(ATMTicketsEntity appCommonBean) {
		Session session = sessionFactory.openSession();
		Criteria criteria = null;
		List<ATMTicketsEntity> results=null;
		try {
			criteria = session.createCriteria(ATMTicketsEntity.class);
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
	
	
	
	public List<Employee> getEployeeList(AppCommonBean appCommonBean) {
		Session session = sessionFactory.openSession();
		Criteria criteria = null;
		List<Employee> results=null;
		try {
			criteria = session.createCriteria(Employee.class);
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

	
	
	
	
	
	
	
	
	
	public void addSiteStatusDetail(SiteDetailsEntity siteDetailsEntity) {
		// TODO Auto-generated method stub
		

		Session session = sessionFactory.openSession();
	//	Transaction tx = session.beginTransaction();
		session.save(siteDetailsEntity);
	//	tx.commit();
		session.close();
		
	}

	
	public void updateSiteStatusDetail(SiteDetailsEntity siteDetailsEntity) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction tx=null;
		try {
			Criteria criteria = session.createCriteria(SiteDetailsEntity.class);

			
			/*if (!"".equals(siteDetailsEntity.getMobile1()) && null != siteDetailsEntity.getMobile1()){
		*/		criteria.add(Restrictions.eq("mobile1", siteDetailsEntity.getMobile1()));
				System.out.println("mobile111"+siteDetailsEntity.getMobile1());
			
			/*}
	*/
	
			
			
			if (!"".equals(siteDetailsEntity.getMobile2()) && null != siteDetailsEntity.getMobile2())
				criteria.add(Restrictions.eq("mobile2", siteDetailsEntity.getMobile1()));

			List<SiteDetailsEntity> list = criteria.list();

		 tx = session.beginTransaction();

			for (SiteDetailsEntity sd : list) {

				if (!"".equals(siteDetailsEntity.getStatus()) && null != siteDetailsEntity.getStatus())
					sd.setStatus(siteDetailsEntity.getStatus());

				if (!"".equals(siteDetailsEntity.getCommercialPower())
						&& null != siteDetailsEntity.getCommercialPower())
					sd.setCommercialPower(siteDetailsEntity.getCommercialPower());

				if (!"".equals(siteDetailsEntity.getDg()) && null != siteDetailsEntity.getDg())
					sd.setDg(siteDetailsEntity.getDg());

				if (!"".equals(siteDetailsEntity.getLoadStatus()) && null != siteDetailsEntity.getLoadStatus())
					sd.setLoadStatus(siteDetailsEntity.getLoadStatus());

				session.update(sd);

			}

			tx.commit();
			

		} catch (Exception e) {
		     if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public List<CustomerBillingInfo> fetchParkingStatusGriddata(CustomerBillingInfo appCommonBean) {
		Session session = sessionFactory.openSession();
		Criteria criteria = null;
		List<CustomerBillingInfo> results=null;
		try {
			criteria = session.createCriteria(CustomerBillingInfo.class);
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

	
	
	
	
	
	
	
	
	
	
	
	
}