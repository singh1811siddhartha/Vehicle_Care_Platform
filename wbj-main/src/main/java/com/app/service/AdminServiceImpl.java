package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;
import com.app.repo.*;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminsService{
	
	
	 @Autowired
	 public Repositoryuser repo;
	 @Autowired
	 public Repositorymechanic repo1;
	 @Autowired
	 public RepositoryAppointments repo2;
	 @Autowired
	 public RepositoryReviews repo3;
	 @Autowired
	 public RepositoryServices repo4;
	 @Autowired
	 public RepositoryVehicles repo5;
	 @Autowired
	 public RepositoryAdmin repo6;
	
	@Override
	public User getUser(String email, String password) {
	    List<User> userList = repo.findAll();
	    User u = null;
	    for (User user : userList) {
	        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
	            u = user;
	            break;
	        }
	    }
	    return u;
	}
	
	@Override
	public List<User> getAllUserDetails() {
		return repo.findAll();
	}
	

	
	@Override
	public Mechanic getMech(String email, String password) {
	    List<Mechanic> mechList = repo1.findAll();
	    Mechanic m = null;
	    for (Mechanic mech : mechList) {
	        if (mech.getEmail().equals(email) && mech.getPassword().equals(password)) {
	            m = mech;
	            break;
	        }
	    }
	    return m;
	}
	
	@Override
	public List<Mechanic> getAllMechanicDetails() {
		return repo1.findAll();
	}
	

	
	@Override
	public List<Appointments> getAllAppointmentsDetails() {
		return repo2.findAll();
	}
	
	
	
	@Override
	public List<Reviews> getAllReviewsDetails() {
		return repo3.findAll();
	}
	
	
	
	@Override
	public List<Services> getAllServicesDetails() {
		return repo4.findAll();
	}
	
	@Override
	public List<Services> getServicesbyMechid(Long id) {
	    List<Services> sList = repo4.findAll();
	    List<Services> mechSlist = new ArrayList<>();
	    for (Services s : sList) {
	        if (s.getMechanic_id().equals(id)) {
	            mechSlist.add(s);
	        }
	    }
	    return mechSlist;
	}
	
	
	@Override
	public List<Vehicles> getAllVehiclesDetails() {
		return repo5.findAll();
	}
	
	@Override
	public List<Vehicles> getVehiclesbyUserid(Long id) {
	    List<Vehicles> vList = repo5.findAll();
	    List<Vehicles> userVlist = new ArrayList<>();
	    for (Vehicles veh : vList) {
	        if (veh.getUser_id().equals(id)) {
	            userVlist.add(veh);
	        }
	    }
	    return userVlist;
	}
	
	

	
	@Override
	public Admin getAdmin(String email, String password) {
	    List<Admin> aList = repo6.findAll();
	    Admin a = null;
	    for (Admin admin : aList) {
	        if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
	            a = admin;
	            break;
	        }
	    }
	    return a;
	}
	
	@Override
	public Admin addAdminDetails(Admin a) {
		// TODO Auto-generated method stub
		return repo6.save(a);
	}


	public Admin findAdminById(Long id) {
		return repo6.findById(id).get();
	}


	@Override
	public String deleteAdminDetails(Long id) {
		// TODO Auto-generated method stub
		 repo6.deleteById(id);
		return "DetailsDelete";
	}
	
	@Override
	public Admin updateAdminDetails(Admin a){
		// TODO Auto-generated method stub
		return repo6.save(a);	
	}
	
}
