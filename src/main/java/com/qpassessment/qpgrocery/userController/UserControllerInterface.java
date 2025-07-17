package com.qpassessment.qpgrocery.userController;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.qpassessment.qpgrocery.model.User;

public interface UserControllerInterface {
	
	public User createUser(User user);
	public User updateUser(User user);
	public void deleteteUser(Integer id);
	public List<User> getAllUsers();
	public ResponseEntity<String> userLogin(User user);

}
