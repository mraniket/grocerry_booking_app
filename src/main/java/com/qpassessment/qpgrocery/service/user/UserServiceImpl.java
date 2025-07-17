package com.qpassessment.qpgrocery.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.qpassessment.qpgrocery.dao.UserRepository;
import com.qpassessment.qpgrocery.model.User;

@Service
public class UserServiceImpl implements UserServiceinterface {
	
	@Autowired
	UserRepository userRepo;
	
	private static final PasswordEncoder passEncoder = new BCryptPasswordEncoder();

	@Override
	public User saveUser(User user) {
		user.setPassword(passEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user) {
		
		User oldUser = userRepo.getById(user.getId());
		oldUser.setUsername(user.getUsername());
		oldUser.setPassword(passEncoder.encode(user.getPassword()));
		oldUser.setRoles(user.getRoles());
		return userRepo.save(oldUser);
	}

	@Override
	public void deleteUser(int userId) {
		userRepo.deleteById((long) userId);
	}

	@Override
	public List<User> fetchAllUsers() {
		return userRepo.findAll();
	}

}
