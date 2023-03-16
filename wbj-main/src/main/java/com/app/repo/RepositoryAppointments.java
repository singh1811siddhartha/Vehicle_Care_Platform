package com.app.repo;

import com.app.pojos.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAppointments extends JpaRepository<Appointments, Long> {

}
