package com.app.repo;

import com.app.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositoryuser extends JpaRepository<User, Long> {

}
