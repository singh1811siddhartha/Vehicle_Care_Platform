package com.app.service;

import com.app.pojos.Vehicles;

public interface VehiclesService {
    Vehicles addVehiclesDetails(Vehicles veh);

    Vehicles findByIdd(Long id);

    String deleteVehiclesDetails(Long id);

    Vehicles updateVehiclesDetails(Vehicles veh);
}
