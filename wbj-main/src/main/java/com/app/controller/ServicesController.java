package com.app.controller;

import com.app.pojos.Services;
import com.app.service.ServicesSer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class ServicesController {

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
