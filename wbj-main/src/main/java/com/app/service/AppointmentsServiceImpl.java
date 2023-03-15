package com.app.service;

import com.app.pojos.Appointments;
import com.app.repo.RepositoryAppointments;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AppointmentsServiceImpl implements AppointmentsService {

    public RepositoryAppointments repo;


    @Override
    public Appointments addAppointmentsDetails(Appointments app) {
        // TODO Auto-generated method stub
        return repo.save(app);
    }


    @Override
    public Appointments findByIdd(Long id) {
        // TODO Auto-generated method stub

        return repo.findById(id).get();
    }


    @Override
    public String deleteAppointmentsDetails(Long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
        return "DetailsDelete";
    }

    @Override
    public Appointments updateAppointmentsDetails(Appointments app) {
        // TODO Auto-generated method stub
        return repo.save(app);
    }

}
