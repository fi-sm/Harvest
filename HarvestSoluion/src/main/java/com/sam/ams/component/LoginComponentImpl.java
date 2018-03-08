package com.sam.ams.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.app.db.UserSecurityAPIItemCRUD;
import com.sam.app.dto.AppCommonBean;

/**
 * 
 * @author Samarjeet
 *
 */
public class LoginComponentImpl  implements LoginComponent{
	
	
	//Logger logger = Logger.getLogger(LoginComponentImpl.class);
	
	/**
	 * @return List<GUIModuleBean>
	 * @param String
	 */
	public AppCommonBean authonticateUser(AppCommonBean appCommonBean)
	{
		UserSecurityAPIItemCRUD userSecurityAPIItemCRUD=new UserSecurityAPIItemCRUD();
		ObjectMapper mapper = new ObjectMapper();
		Boolean isLogin=false;
		AppCommonBean outAppCommonBean =appCommonBean;
		try
		{
		String resultString=userSecurityAPIItemCRUD.retrieveUserDetailByLoginID(appCommonBean);
		
		outAppCommonBean = mapper.readValue(resultString, AppCommonBean.class);
		System.out.println("appCommonBean.getLoginid()+**+appCommonBean.getPasswd():"+appCommonBean.getLoginid()+"**"+appCommonBean.getPasswd());
		System.out.println("outAppCommonBean.getLoginid()+**+outAppCommonBean.getPasswd():"+outAppCommonBean.getLoginid()+"**"+outAppCommonBean.getPasswd());
		if((appCommonBean.getLoginid()+"**"+appCommonBean.getPasswd()).equals(outAppCommonBean.getLoginid()+"**"+outAppCommonBean.getPasswd()))
		{
			
			isLogin=true;	
			outAppCommonBean.setIsLogin(isLogin);
			System.out.println(isLogin);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return outAppCommonBean;
		
	}
	

}
