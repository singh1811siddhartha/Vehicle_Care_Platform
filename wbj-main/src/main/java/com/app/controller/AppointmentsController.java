package com.app.controller;

import com.app.pojos.Appointments;
import com.app.service.AppointmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class AppointmentsController {

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
