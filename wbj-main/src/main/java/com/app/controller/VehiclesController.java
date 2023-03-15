package com.app.controller;

import com.app.pojos.Vehicles;
import com.app.service.VehiclesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class VehiclesController {

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
