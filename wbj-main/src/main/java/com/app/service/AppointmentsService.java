package com.app.service;

import com.app.pojos.Appointments;

public interface AppointmentsService {
	
	public Appointments addAppointmentsDetails(Appointments app);
	public Appointments findByIdd(Long id);
	public String deleteAppointmentsDetails(Long id);
	public Appointments updateAppointmentsDetails(Appointments app);

}
