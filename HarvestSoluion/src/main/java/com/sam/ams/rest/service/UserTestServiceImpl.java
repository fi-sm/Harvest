package com.sam.ams.rest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.ams.rest.model.UserTest;




@Service("userService")
@Transactional
public class UserTestServiceImpl implements UserTestService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<UserTest> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<UserTest> findAllUsers() {
		return users;
	}
	
	public UserTest findById(long id) {
		for(UserTest user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public UserTest findByName(String name) {
		for(UserTest user : users){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(UserTest user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(UserTest user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<UserTest> iterator = users.iterator(); iterator.hasNext(); ) {
		    UserTest user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(UserTest user) {
		return findByName(user.getName())!=null;
	}

	private static List<UserTest> populateDummyUsers(){
		List<UserTest> users = new ArrayList<UserTest>();
		users.add(new UserTest(counter.incrementAndGet(),"Sam",30, 70000));
		users.add(new UserTest(counter.incrementAndGet(),"Tom",40, 50000));
		users.add(new UserTest(counter.incrementAndGet(),"Jerome",45, 30000));
		users.add(new UserTest(counter.incrementAndGet(),"Silvia",50, 40000));
		return users;
	}

	public void deleteAllUsers() {
		users.clear();
	}

}
