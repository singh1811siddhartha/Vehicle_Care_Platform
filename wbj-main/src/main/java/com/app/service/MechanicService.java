package com.app.service;

import com.app.pojos.Mechanic;

public interface MechanicService {
	public Mechanic addMechanicDetails(Mechanic mech);
	public Mechanic findByIdd(Long id);
	public String deleteMechDetails(Long id);
	public Mechanic updateMechDetails(Mechanic mech);
}
