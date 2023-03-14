package com.app.service;

import com.app.pojos.Vehicles;

public interface VehiclesService {
	public Vehicles addVehiclesDetails(Vehicles veh);
	public Vehicles findByIdd(Long id);
	public String deleteVehiclesDetails(Long id);
	public Vehicles updateVehiclesDetails(Vehicles veh);
}
