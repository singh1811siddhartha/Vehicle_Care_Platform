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
import com.app.pojos.Appointments;
import com.app.service.AppointmentsService;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AppointmentsController {
	
	@Autowired
	private AppointmentsService appser;
	
	@PostMapping("/add")
	public Appointments addAppointmentsDetails(@RequestBody Appointments app) {
		return appser.addAppointmentsDetails(app);
	}
	
	@GetMapping("/getbyid/{id}")
	public Appointments findBYId(@PathVariable Long id) {
		return appser.findByIdd(id);	
	}
	
	@DeleteMapping("/deletebyId/{id}")
	public String deleteAppointmentsDetails(@PathVariable Long id) {
		return appser.deleteAppointmentsDetails(id);
	}
	@PutMapping("/update")
	public Appointments updateAppointmentsDetails(@RequestBody Appointments app) {
		return appser.updateAppointmentsDetails(app);
	}

}
