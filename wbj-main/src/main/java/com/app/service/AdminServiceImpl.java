package com.app.service;

import com.app.controller.VehiclesController;
import com.app.pojos.*;
import com.app.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminsService {

    public Repositoryuser repo;
    public Repositorymechanic repo1;
    public RepositoryAppointments repo2;
    public RepositoryReviews repo3;
    public RepositoryServices repo4;
    public RepositoryVehicles repo5;
    public RepositoryAdmin repo6;

    @Override
    public User getUser(String email, String password) {
        List<User> userList = repo.findAll();
        User u = null;
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                u = user;
                break;
            }
        }
        return u;
    }

    @Override
    public List<User> getAllUserDetails() {
        return repo.findAll();
    }

    @Override
    public Mechanic getMech(String email, String password) {
        List<Mechanic> mechList = repo1.findAll();
        Mechanic m = null;
        for (Mechanic mech : mechList) {
            if (mech.getEmail().equals(email) && mech.getPassword().equals(password)) {
                m = mech;
                break;
            }
        }
        return m;
    }

    @Override
    public List<Mechanic> getAllMechanicDetails() {
        return repo1.findAll();
    }

    @Override
    public List<Appointments> getAllAppointmentsDetails() {
        return repo2.findAll();
    }

    @Override
    public List<Reviews> getAllReviewsDetails() {
        return repo3.findAll();
    }

    @Override
    public List<Services> getAllServicesDetails() {
        return repo4.findAll();
    }

    @Override
    public List<Vehicles> getAllVehiclesDetails() {
        return repo5.findAll();
    }

    @Override
    public List<Vehicles> getVehiclesbyUserid(Long id) {
        List<Vehicles> vList = repo5.findAll();
        List<Vehicles> userVlist = new ArrayList<>();
        Vehicles v = null;
        for (Vehicles veh : vList) {
            if (veh.getUser_id().equals(id)) {
                v = veh;
                userVlist.add(veh);
                break;
            }
        }
        return userVlist;
    }
    // IMPROVED GET VEHICLE BY USER ID
    public List<Vehicles> getVehiclesByUserIdImproved(Long id){
        var vehicles = repo5.findAll();
        return vehicles.stream().filter(vehicles1 -> vehicles1.getUser_id().equals(id)).collect(Collectors.toList());
    }

    @Override
    public Admin getAdmin(String email, String password) {
        List<Admin> aList = repo6.findAll();
        Admin a = null;
        for (Admin admin : aList) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                a = admin;
                break;
            }
        }
        return a;
    }

    @Override
    public Admin addAdminDetails(Admin a) {
        // TODO Auto-generated method stub
        return repo6.save(a);
    }


    public Admin findAdminById(Long id) {
        return repo6.findById(id).get();
    }


    @Override
    public String deleteAdminDetails(Long id) {
        // TODO Auto-generated method stub
        repo6.deleteById(id);
        return "DetailsDelete";
    }

    @Override
    public Admin updateAdminDetails(Admin a) {
        // TODO Auto-generated method stub
        return repo6.save(a);
    }

}
