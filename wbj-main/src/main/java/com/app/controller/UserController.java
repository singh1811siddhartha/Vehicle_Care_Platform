package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

	@Autowired
	private UserService userser;
	
	@PostMapping("/add")
	public User addUserDetails(@RequestBody User user) {
		return userser.addUserDetails(user);
	}
	
	@GetMapping("/getbyid/{id}")
	public User findBYId(@PathVariable Long id) {
		return userser.findByIdd(id);	
	}
	
	@DeleteMapping("/deletebyId/{id}")
	public String deleteUserDetails(@PathVariable Long id) {
		return userser.deleteUserDetails(id);
	}
	@PutMapping("/update")
	public User updateUserDetails(@RequestBody User user) {
		return userser.updateUserDetails(user);
	}
}
