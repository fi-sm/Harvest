package com.sam.ams.component;

import java.util.ArrayList;
import java.util.List;

import com.sam.ams.dto.MenuDTO;
import com.sam.ams.dto.SubMenuDTO;
import com.sam.app.dto.AppCommonBean;

public class MenuComponentImpl {
	
	
	//Logger logger = Logger.getLogger(MenuComponentImpl.class);
	
	/**
	 * @return List<GUIModuleBean>
	 * @param String
	 */
	public List<MenuDTO> fetchMenu(AppCommonBean appCommonBean)
	{
		List<MenuDTO> menuList=new ArrayList<MenuDTO>();
		List <SubMenuDTO> subMenuList=new ArrayList <SubMenuDTO>();
		
		MenuDTO menuDTO=new MenuDTO();
		menuDTO.setModuleId(1);
		menuDTO.setModuleLabel("Master");
		SubMenuDTO subMenu=new SubMenuDTO();
		subMenu.setMenuId("1");
		subMenu.setMenuLabel("Employee");
		subMenu.setMenuURL("employees");
		
		subMenuList.add(subMenu);
		subMenu=new SubMenuDTO();
		subMenu.setMenuId("2");
		subMenu.setMenuLabel("Add Employee");
		subMenu.setMenuURL("addEmployees");
		subMenuList.add(subMenu);
	/*	subMenu=new SubMenuDTO();
		subMenu.setMenuId("3");
		subMenu.setMenuLabel("Type");
		subMenu.setMenuURL("type");
		subMenuList.add(subMenu);*/
		menuDTO.setSubMenuList(subMenuList);
		menuList.add(menuDTO);
		
		subMenuList=new ArrayList <SubMenuDTO>();
		menuDTO=new MenuDTO();
		menuDTO.setModuleId(1);
		menuDTO.setModuleLabel("Transaction");
		subMenu=new SubMenuDTO();
		subMenu.setMenuId("2");
		subMenu.setMenuLabel("User Tray");
		subMenu.setMenuURL("usertray");
		subMenuList.add(subMenu);
		subMenu=new SubMenuDTO();
		subMenu.setMenuId("3");
		subMenu.setMenuLabel("ATM Message");
		subMenu.setMenuURL("atmRequestMessage");
		subMenuList.add(subMenu);
		menuDTO.setSubMenuList(subMenuList);
		menuList.add(menuDTO);
		
		
		subMenuList=new ArrayList <SubMenuDTO>();
		menuDTO=new MenuDTO();
		menuDTO.setModuleId(1);
		menuDTO.setModuleLabel("Search");
		subMenu=new SubMenuDTO();
		subMenu.setMenuId("2");
		subMenu.setMenuLabel("Ticket");
		subMenu.setMenuURL("ticket");
		subMenuList.add(subMenu);
		subMenu.setMenuId("3");
		subMenu.setMenuLabel("Terminal");
		subMenu.setMenuURL("rate");
		subMenuList.add(subMenu);
		menuDTO.setSubMenuList(subMenuList);
		menuList.add(menuDTO);
		
		return menuList;
	}
	
	
	
	
	/**
	 * @return List<GUIModuleBean>
	 * @param String
	 */
	public List<MenuDTO> boozeMenuItem(AppCommonBean appCommonBean)
	{
		List<MenuDTO> menuList=new ArrayList<MenuDTO>();
		List <SubMenuDTO> subMenuList=new ArrayList <SubMenuDTO>();
		
		MenuDTO menuDTO=new MenuDTO();
		menuDTO.setModuleId(1);
		menuDTO.setModuleLabel("Master");
		SubMenuDTO subMenu=new SubMenuDTO();
		subMenu.setMenuId("1");
		subMenu.setMenuLabel("Customers");
		subMenu.setMenuURL("customers");
		
		subMenuList.add(subMenu);
		subMenu=new SubMenuDTO();
		subMenu.setMenuId("2");
		subMenu.setMenuLabel("Rate");
		subMenu.setMenuURL("rate");
		subMenuList.add(subMenu);
		subMenu=new SubMenuDTO();
		subMenu.setMenuId("3");
		subMenu.setMenuLabel("Type");
		subMenu.setMenuURL("type");
		subMenuList.add(subMenu);
		
		subMenu=new SubMenuDTO();
		subMenu.setMenuId("4");
		subMenu.setMenuLabel("Kuchh Ni");
		subMenu.setMenuURL("boozeItem");
		subMenuList.add(subMenu);
		
		subMenu=new SubMenuDTO();
		subMenu.setMenuId("5");
		subMenu.setMenuLabel("Blunder Pride");
		subMenu.setMenuURL("boozeItem");
		subMenuList.add(subMenu);
		
		subMenu=new SubMenuDTO();
		subMenu.setMenuId("6");
		subMenu.setMenuLabel("Teachers");
		subMenu.setMenuURL("boozeItem");
		subMenuList.add(subMenu);
		
		subMenu=new SubMenuDTO();
		subMenu.setMenuId("7");
		subMenu.setMenuLabel("McDonald's");
		subMenu.setMenuURL("boozeItem");
		subMenuList.add(subMenu);
		
		subMenu=new SubMenuDTO();
		subMenu.setMenuId("8");
		subMenu.setMenuLabel("Jony Walker");
		subMenu.setMenuURL("boozeItem");
		subMenuList.add(subMenu);
		menuDTO.setSubMenuList(subMenuList);
		menuList.add(menuDTO);
		
		return menuList;
	}
	

}
