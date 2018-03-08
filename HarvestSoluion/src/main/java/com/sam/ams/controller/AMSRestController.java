package com.sam.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sam.ams.component.AMSMasterComponent;
import com.sam.ams.component.AMSMasterComponentImpl;
import com.sam.ams.component.CustomerDetailBean;
import com.sam.ams.dto.ATMRequestMessageDTO;
import com.sam.ams.rest.model.UserTest;
import com.sam.ams.rest.service.UserTestService;
import com.sam.ams.rest.service.UserTestServiceImpl;
import com.sam.ams.service.UserTrayService;
import com.sam.app.dto.AppCommonBean;


/**
 * 
 * @author hp
 *
 */
@RestController
public class AMSRestController {

	 @Autowired
	 UserTrayService userTrayService;// Service which will do
	 UserTestService userService=new UserTestServiceImpl();												// all data
														// retrieval/manipulation

	
	
	@RequestMapping(value = "/amsRequestMessage/", method = RequestMethod.POST)
	public ResponseEntity<Void> atmRequestMessage(@RequestBody ATMRequestMessageDTO atmRequestMessageDTO, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating atmRequestMessageDTO " + atmRequestMessageDTO);

/*		if (userService.isUserExist(user)) {
			System.out.println("A User with name " + user.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}*/

		userTrayService.insertATMRequestMessage(atmRequestMessageDTO);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/amsRequestMessage/{id}").buildAndExpand(atmRequestMessageDTO.getTermid()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
	
	
	@RequestMapping(value = "/siteRequestMessage/", method = RequestMethod.POST)
	public ResponseEntity<Void> siteRequestMessage(@RequestBody ATMRequestMessageDTO atmRequestMessageDTO, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating atmRequestMessageDTO " + atmRequestMessageDTO);

/*		if (userService.isUserExist(user)) {
			System.out.println("A User with name " + user.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}*/

		userTrayService.insertATMRequestMessage(atmRequestMessageDTO);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/amsRequestMessage/{id}").buildAndExpand(atmRequestMessageDTO.getTermid()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	
	
	
	
	// -------------------Retrieve All
	// Users--------------------------------------------------------
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerDetailBean> > listAllUsers() {
		AMSMasterComponent AMSMasterComponent=new AMSMasterComponentImpl();
		AppCommonBean appCommonBean=new AppCommonBean();
		List<CustomerDetailBean> customersList =AMSMasterComponent.listAllCustomer(appCommonBean);
		
		if (customersList.isEmpty()) {
			return new ResponseEntity<List<CustomerDetailBean> >(HttpStatus.NO_CONTENT);// You
																			// many
																			// decide
																			// to
																			// return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<CustomerDetailBean> >(customersList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/userTest/", method = RequestMethod.GET)
	public ResponseEntity<List<UserTest>> listAllTestUsers() {
		List<UserTest> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<UserTest>>(HttpStatus.NO_CONTENT);// You
																			// many
																			// decide
																			// to
																			// return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<UserTest>>(users, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// User--------------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserTest> getUser(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		UserTest user = userService.findById(id);
		if (user == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<UserTest>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserTest>(user, HttpStatus.OK);
	}

	// -------------------Create a
	// User--------------------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody UserTest user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + user.getName());

		if (userService.isUserExist(user)) {
			System.out.println("A User with name " + user.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a User
	// --------------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserTest> updateUser(@PathVariable("id") long id, @RequestBody UserTest user) {
		System.out.println("Updating User " + id);

		UserTest currentUser = userService.findById(id);

		if (currentUser == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<UserTest>(HttpStatus.NOT_FOUND);
		}

		currentUser.setName(user.getName());
		currentUser.setAge(user.getAge());
		currentUser.setSalary(user.getSalary());

		userService.updateUser(currentUser);
		return new ResponseEntity<UserTest>(currentUser, HttpStatus.OK);
	}

	// ------------------- Delete a User
	// --------------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserTest> deleteUser(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting User with id " + id);

		UserTest user = userService.findById(id);
		if (user == null) {
			System.out.println("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<UserTest>(HttpStatus.NOT_FOUND);
		}

		userService.deleteUserById(id);
		return new ResponseEntity<UserTest>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All User
	// --------------------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	public ResponseEntity<UserTest> deleteAllUsers() {
		System.out.println("Deleting All Users");

		userService.deleteAllUsers();
		return new ResponseEntity<UserTest>(HttpStatus.NO_CONTENT);
	}

}
