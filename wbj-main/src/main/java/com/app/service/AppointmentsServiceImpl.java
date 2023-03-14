package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Appointments;
import com.app.repo.RepositoryAppointments;

@Service
@Transactional
public class AppointmentsServiceImpl implements AppointmentsService {
	
	@Autowired
	public RepositoryAppointments repo;
	
	
	@Override
	public Appointments addAppointmentsDetails(Appointments app) {
		// TODO Auto-generated method stub
		return repo.save(app);
	}


	@Override
	public Appointments findByIdd(Long id) {
		// TODO Auto-generated method stub
	
		return repo.findById(id).get() ;
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
