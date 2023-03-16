package com.app.service;

import java.util.List;

import com.app.pojos.*;

public interface AdminsService {
	
	public Admin addAdminDetails(Admin a);
	public Admin findAdminById(Long id);
	public String deleteAdminDetails(Long id);
	public Admin updateAdminDetails(Admin a);
	
	List<User> getAllUserDetails();
	List<Mechanic> getAllMechanicDetails();
	List<Appointments> getAllAppointmentsDetails();
	List<Reviews> getAllReviewsDetails();
	List<Services> getAllServicesDetails();
	List<Vehicles> getAllVehiclesDetails();
	//List<Admin> getAllAdmin();
	
	public User getUser(String email, String password);
	public Mechanic getMech(String email, String password);
	public Admin getAdmin(String email, String password);
	public List<Vehicles> getVehiclesbyUserid(Long id);
	public List<Services> getServicesbyMechid(Long id);

}
