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

import com.app.pojos.Mechanic;
import com.app.service.MechanicService;

@RestController
@RequestMapping("/api/mechanic")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MechanicController {
	

	@Autowired
	private MechanicService mechser;
	
	@PostMapping("/add")
	public Mechanic addMechanicDetails(@RequestBody Mechanic mech) {
		return mechser.addMechanicDetails(mech);
	}
	
	@GetMapping("/getbyid/{id}")
	public Mechanic findBYId(@PathVariable Long id) {
		return mechser.findByIdd(id);	
	}
	
	@DeleteMapping("/deletebyId/{id}")
	public String deleteMechanicDetails(@PathVariable Long id) {
		return mechser.deleteMechDetails(id);
	}
	@PutMapping("/update")
	public Mechanic updateMechanicDetails(@RequestBody Mechanic mech) {
		return mechser.updateMechDetails(mech);
	}

}
