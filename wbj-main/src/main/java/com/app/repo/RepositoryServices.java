package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Services;

public interface RepositoryServices extends JpaRepository<Services, Long> {

}
