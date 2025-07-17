package com.qpassessment.qpgrocery.service.user;

import java.util.List;

import com.qpassessment.qpgrocery.model.User;

public interface UserServiceinterface {
	
	public User saveUser(User user);
	public User updateUser(User user);
	public void deleteUser(int userId);
	public List<User> fetchAllUsers();

}
