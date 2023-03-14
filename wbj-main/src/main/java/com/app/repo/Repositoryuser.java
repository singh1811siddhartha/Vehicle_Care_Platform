package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.User;

public interface Repositoryuser extends JpaRepository<User, Long> {

}
