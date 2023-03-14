package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Appointments;

public interface RepositoryAppointments extends JpaRepository<Appointments, Long> {

}
