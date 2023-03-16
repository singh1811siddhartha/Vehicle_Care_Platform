package com.app.service;


import com.app.pojos.Services;


public interface ServicesSer {
    Services addServicesDetails(Services ser);

    Services findByIdd(Long id);

    String deleteServicesDetails(Long id);

    Services updateServicesDetails(Services ser);
}
