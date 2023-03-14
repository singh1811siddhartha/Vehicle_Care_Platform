package com.app.service;


import com.app.pojos.Services;


public interface ServicesSer {
	public Services addServicesDetails(Services ser);
	public Services findByIdd(Long id);
	public String deleteServicesDetails(Long id);
	public Services updateServicesDetails(Services ser);
}
