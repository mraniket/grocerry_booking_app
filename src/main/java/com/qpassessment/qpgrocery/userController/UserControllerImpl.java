package com.qpassessment.qpgrocery.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qpassessment.qpgrocery.configuration.JwtUtil;
import com.qpassessment.qpgrocery.model.User;
import com.qpassessment.qpgrocery.service.CustomUserDetailsService;
import com.qpassessment.qpgrocery.service.user.UserServiceinterface;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserControllerInterface {
	
	

	@Autowired
	UserServiceinterface userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired CustomUserDetailsService userdetailserive;

	
	
	@Override
	@PostMapping("/public/addUser")
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@Override
	@PostMapping("/public/userLogin")
	public ResponseEntity<String> userLogin(@RequestBody User user) {
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		UserDetails userdetails = userdetailserive.loadUserByUsername(user.getUsername());
		
		return new ResponseEntity<>(jwtUtil.generateToke(userdetails.getUsername()), HttpStatus.OK);
	}

		//Private Enpoints
	/**
	 * Below are the enpoints which can be only accessed by the ADMIN user
	 * 
	 * */
	
	@Override
	@PutMapping
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@Override
	@DeleteMapping
	public void deleteteUser(Integer id) {

		userService.deleteUser(id);
	}

	@Override
	@GetMapping
	public List<User> getAllUsers() {
		return userService.fetchAllUsers();
	}

}
