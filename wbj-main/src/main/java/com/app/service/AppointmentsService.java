package com.app.service;

import com.app.pojos.Appointments;

public interface AppointmentsService {

    Appointments addAppointmentsDetails(Appointments app);

    Appointments findByIdd(Long id);

    String deleteAppointmentsDetails(Long id);

    Appointments updateAppointmentsDetails(Appointments app);

}
