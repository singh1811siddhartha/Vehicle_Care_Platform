package com.app.service;

import com.app.pojos.*;

import java.util.List;

public interface AdminsService {

    Admin addAdminDetails(Admin a);

    Admin findAdminById(Long id);

    String deleteAdminDetails(Long id);

    Admin updateAdminDetails(Admin a);

    List<User> getAllUserDetails();

    List<Mechanic> getAllMechanicDetails();

    List<Appointments> getAllAppointmentsDetails();

    List<Reviews> getAllReviewsDetails();

    List<Services> getAllServicesDetails();

    List<Vehicles> getAllVehiclesDetails();
    //List<Admin> getAllAdmin();

    User getUser(String email, String password);

    Mechanic getMech(String email, String password);

    Admin getAdmin(String email, String password);

    List<Vehicles> getVehiclesbyUserid(Long id);


}
