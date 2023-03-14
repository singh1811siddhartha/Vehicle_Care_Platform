package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;
import com.app.repo.*;


@Service
@Transactional

public class AdminServiceImpl implements AdminsService{
	
	@Autowired
	public Repositoryuser repo;
	
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
	

	@Autowired
	public Repositorymechanic repo1;
	
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
	
	@Autowired
	public RepositoryAppointments repo2;
	
	@Override
	public List<Appointments> getAllAppointmentsDetails() {
		return repo2.findAll();
	}
	
	
	@Autowired
	public RepositoryReviews repo3;
	
	@Override
	public List<Reviews> getAllReviewsDetails() {
		return repo3.findAll();
	}
	
	
	@Autowired
	public RepositoryServices repo4;
	
	@Override
	public List<Services> getAllServicesDetails() {
		return repo4.findAll();
	}
	
	
	@Autowired
	public RepositoryVehicles repo5;
	
	@Override
	public List<Vehicles> getAllVehiclesDetails() {
		return repo5.findAll();
	}
	
	@Override
	public List<Vehicles> getVehiclesbyUserid(Long id) {
	    List<Vehicles> vList = repo5.findAll();
	    List<Vehicles> userVlist = null;
	    Vehicles v = null;
	    for (Vehicles veh : vList) {
	        if (veh.getUser_id().equals(id)) {
	            v = veh;
	            userVlist.add(veh);
	            break;
	        }
	    }
	    return userVlist;
	}
	
	
	@Autowired
	public RepositoryAdmin repo6;
	
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
