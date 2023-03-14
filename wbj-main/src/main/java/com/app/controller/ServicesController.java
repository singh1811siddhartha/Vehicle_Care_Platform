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
import com.app.pojos.Services;

import com.app.service.ServicesSer;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ServicesController {
	
	@Autowired
	private ServicesSer serser;
	
	@PostMapping("/add")
	public Services addServicesDetails(@RequestBody Services ser) {
		return serser.addServicesDetails(ser);
	}
	
	@GetMapping("/getbyid/{id}")
	public Services findBYId(@PathVariable Long id) {
		return serser.findByIdd(id);	
	}
	
	@DeleteMapping("/deletebyId/{id}")
	public String deleteServicesDetails(@PathVariable Long id) {
		return serser.deleteServicesDetails(id);
	}
	@PutMapping("/update")
	public Services updateServicesDetails(@RequestBody Services ser) {
		return serser.updateServicesDetails(ser);
	}

}
