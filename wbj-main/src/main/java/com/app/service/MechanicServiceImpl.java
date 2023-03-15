package com.app.service;

import com.app.pojos.Mechanic;
import com.app.repo.Repositorymechanic;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MechanicServiceImpl implements MechanicService {

    public Repositorymechanic repo;


    @Override
    public Mechanic addMechanicDetails(Mechanic mech) {
        // TODO Auto-generated method stub
        return repo.save(mech);
    }


    @Override
    public Mechanic findByIdd(Long id) {
        // TODO Auto-generated method stub

        return repo.findById(id).get();
    }


    @Override
    public String deleteMechDetails(Long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
        return "DetailsDelete";
    }

    @Override
    public Mechanic updateMechDetails(Mechanic mech) {
        // TODO Auto-generated method stub
        return repo.save(mech);
    }

}
