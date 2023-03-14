package com.app.controller;

import java.util.List;

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
import com.app.pojos.*;
import com.app.service.AdminsService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdminController {
	
	@Autowired
	private AdminsService userser;
	
	@PostMapping("/userlogin/{email}/{password}")
	public User userlogin(@PathVariable String email,@PathVariable String password) {
		return userser.getUser(email,password);
	}
	
	@GetMapping("/viewuser")
	public List<User> getAllUsers() {
		System.out.println("in get all users");
		return userser.getAllUserDetails();
	}
	
	@Autowired
	private AdminsService mechser;
	
	@GetMapping("/viewmechanic")
	public List<Mechanic> getAllMechanics() {
		System.out.println("in get all mechnics");
		return mechser.getAllMechanicDetails();
	}
	
	@PostMapping("/mechaniclogin/{email}/{password}")
	public Mechanic mechlogin(@PathVariable String email,@PathVariable String password) {
		return mechser.getMech(email,password);
	}
	
	@Autowired
	private AdminsService appser;
	
	@GetMapping("/viewappointments")
	public List<Appointments> getAllAppointments() {
		System.out.println("in get all appointments");
		return appser.getAllAppointmentsDetails();
	}
	

	@Autowired
	private AdminsService review;
	
	@GetMapping("/viewreviews")
	public List<Reviews> getAllReviews() {
		System.out.println("in get all reviews");
		return review.getAllReviewsDetails();
	}
	
	@Autowired
	private AdminsService serser;
	
	@GetMapping("/viewservices")
	public List<Services> getAllServices() {
		System.out.println("in get all services");
		return serser.getAllServicesDetails();
	}
	
	@Autowired
	private AdminsService vehser;
	
	@GetMapping("/viewvehiclesbyuserid/{user_id}")
	public List<Vehicles> getUserVehicles(@PathVariable Long id) {
		return vehser.getVehiclesbyUserid(id);
	}
	
	
	@GetMapping("/viewvehicles")
	public List<Vehicles> getAllVehicles() {
		System.out.println("in get all vehicles");
		return vehser.getAllVehiclesDetails();
	}
	
	
	
	@Autowired
	private AdminsService admin;
	
	@PostMapping("/adminlogin/{email}/{password}")
	public Admin adminlogin(@PathVariable String email,@PathVariable String password) {
		return admin.getAdmin(email,password);
	}
	
	
	@PostMapping("/addadmin")
	public Admin addAdminDetails(@RequestBody Admin a) {
		return admin.addAdminDetails(a);
	}
	
	@GetMapping("/getbyid/{id}")
	public Admin findadminbyid(@PathVariable Long id) {
		return admin.findAdminById(id);	
	}
	
	@DeleteMapping("/deletebyId/{id}")
	public String deleteAdminDetails(@PathVariable Long id) {
		return admin.deleteAdminDetails(id);
	}
	@PutMapping("/updateadmin")
	public Admin updateAdminDetails(@RequestBody Admin a) {
		return admin.updateAdminDetails(a);
	}
	
}
