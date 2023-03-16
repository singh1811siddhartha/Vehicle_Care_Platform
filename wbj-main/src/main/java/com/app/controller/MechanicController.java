package com.app.controller;

import com.app.pojos.Mechanic;
import com.app.service.MechanicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mechanic")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class MechanicController {


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
