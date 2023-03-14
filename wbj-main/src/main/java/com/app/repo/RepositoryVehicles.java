package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Vehicles;

public interface RepositoryVehicles extends JpaRepository<Vehicles, Long> {

}
