package com.app.service;

import com.app.pojos.User;

public interface UserService {
	public User addUserDetails(User user);
	public User findByIdd(Long id);
	public String deleteUserDetails(Long id);
	public User updateUserDetails(User user);
}
