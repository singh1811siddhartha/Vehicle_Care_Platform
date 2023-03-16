package com.app.repo;

import com.app.pojos.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAdmin extends JpaRepository<Admin, Long> {

}
