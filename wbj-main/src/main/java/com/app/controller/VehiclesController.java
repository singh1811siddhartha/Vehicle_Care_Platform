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
import com.app.pojos.Vehicles;

import com.app.service.VehiclesService;

@RestController
@RequestMapping("/api/vehicles")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VehiclesController {

	@Autowired
	private VehiclesService vehser;
	
	@PostMapping("/add")
	public Vehicles addVehiclesDetails(@RequestBody Vehicles veh) {
		return vehser.addVehiclesDetails(veh);
	}
	
	@GetMapping("/getbyid/{id}")
	public Vehicles findBYId(@PathVariable Long id) {
		return vehser.findByIdd(id);	
	}
	
	@DeleteMapping("/deletebyId/{id}")
	public String deleteVehiclesDetails(@PathVariable Long id) {
		return vehser.deleteVehiclesDetails(id);
	}
	@PutMapping("/update")
	public Vehicles updateVehiclesDetails(@RequestBody Vehicles veh) {
		return vehser.updateVehiclesDetails(veh);
	}
}
