package com.app.controller;

import com.app.pojos.*;
import com.app.service.AdminsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class AdminController {

    private AdminsService userser;
    private AdminsService mechser;
    private AdminsService appser;
    private AdminsService review;
    private AdminsService serser;
    private AdminsService vehser;
    private AdminsService admin;

    @PostMapping("/userlogin/{email}/{password}")
    public User userlogin(@PathVariable String email, @PathVariable String password) {
        return userser.getUser(email, password);
    }

    @GetMapping("/viewuser")
    public List<User> getAllUsers() {
        System.out.println("in get all users");
        return userser.getAllUserDetails();
    }

    @GetMapping("/viewmechanic")
    public List<Mechanic> getAllMechanics() {
        System.out.println("in get all mechnics");
        return mechser.getAllMechanicDetails();
    }

    @PostMapping("/mechaniclogin/{email}/{password}")
    public Mechanic mechlogin(@PathVariable String email, @PathVariable String password) {
        return mechser.getMech(email, password);
    }

    @GetMapping("/viewappointments")
    public List<Appointments> getAllAppointments() {
        System.out.println("in get all appointments");
        return appser.getAllAppointmentsDetails();
    }

    @GetMapping("/viewreviews")
    public List<Reviews> getAllReviews() {
        System.out.println("in get all reviews");
        return review.getAllReviewsDetails();
    }

    @GetMapping("/viewservices")
    public List<Services> getAllServices() {
        System.out.println("in get all services");
        return serser.getAllServicesDetails();
    }

    @GetMapping("/viewvehiclesbyuserid/{user_id}")
    public List<Vehicles> getUserVehicles(@PathVariable Long id) {
        return vehser.getVehiclesbyUserid(id);
    }

    @GetMapping("/viewvehicles")
    public List<Vehicles> getAllVehicles() {
        System.out.println("in get all vehicles");
        return vehser.getAllVehiclesDetails();
    }

    @PostMapping("/adminlogin/{email}/{password}")
    public Admin adminlogin(@PathVariable String email, @PathVariable String password) {
        return admin.getAdmin(email, password);
    }


    @PostMapping("/addadmin")
    public Admin addAdminDetails(@RequestBody Admin a) {
        return admin.addAdminDetails(a);
    }

    @GetMapping("/getbyid/{id}")
    public Admin findadminbyid(@PathVariable Long id) {
        return admin.findAdminById(id);
    }

    @DeleteMapping("/deletebyId/{id}")
    public String deleteAdminDetails(@PathVariable Long id) {
        return admin.deleteAdminDetails(id);
    }

    @PutMapping("/updateadmin")
    public Admin updateAdminDetails(@RequestBody Admin a) {
        return admin.updateAdminDetails(a);
    }

}
