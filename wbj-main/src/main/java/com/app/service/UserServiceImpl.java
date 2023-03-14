package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;
import com.app.repo.Repositoryuser;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	public Repositoryuser repo;
	
	
	@Override
	public User addUserDetails(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}


	@Override
	public User findByIdd(Long id) {
		// TODO Auto-generated method stub
	
		return repo.findById(id).get() ;
	}


	@Override
	public String deleteUserDetails(Long id) {
		// TODO Auto-generated method stub
		 repo.deleteById(id);
		return "DetailsDelete";
	}

	@Override
	public User updateUserDetails(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);	
	}

}
