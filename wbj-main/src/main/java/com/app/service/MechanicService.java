package com.app.service;

import com.app.pojos.Mechanic;

public interface MechanicService {
    Mechanic addMechanicDetails(Mechanic mech);

    Mechanic findByIdd(Long id);

    String deleteMechDetails(Long id);

    Mechanic updateMechDetails(Mechanic mech);
}
