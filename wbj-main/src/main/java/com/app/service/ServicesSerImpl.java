package com.app.service;

import com.app.pojos.Services;
import com.app.repo.RepositoryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ServicesSerImpl implements ServicesSer {

    public RepositoryServices repo;


    @Override
    public Services addServicesDetails(Services ser) {
        // TODO Auto-generated method stub
        return repo.save(ser);
    }


    @Override
    public Services findByIdd(Long id) {
        // TODO Auto-generated method stub

        return repo.findById(id).get();
    }


    @Override
    public String deleteServicesDetails(Long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
        return "DetailsDelete";
    }

    @Override
    public Services updateServicesDetails(Services ser) {
        // TODO Auto-generated method stub
        return repo.save(ser);
    }
}
