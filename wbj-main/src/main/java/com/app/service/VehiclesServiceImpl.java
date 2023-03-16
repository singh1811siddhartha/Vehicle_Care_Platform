package com.app.service;

import com.app.pojos.Vehicles;
import com.app.repo.RepositoryVehicles;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class VehiclesServiceImpl implements VehiclesService {

    public RepositoryVehicles repo;


    @Override
    public Vehicles addVehiclesDetails(Vehicles veh) {
        // TODO Auto-generated method stub
        return repo.save(veh);
    }


    @Override
    public Vehicles findByIdd(Long id) {
        // TODO Auto-generated method stub

        return repo.findById(id).get();
    }


    @Override
    public String deleteVehiclesDetails(Long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
        return "DetailsDelete";
    }

    @Override
    public Vehicles updateVehiclesDetails(Vehicles veh) {
        // TODO Auto-generated method stub
        return repo.save(veh);
    }

}
