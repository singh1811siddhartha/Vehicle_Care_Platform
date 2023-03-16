package com.app.service;

import com.app.pojos.User;
import com.app.repo.Repositoryuser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public Repositoryuser repo;


    @Override
    public User addUserDetails(User user) {
        // TODO Auto-generated method stub
        return repo.save(user);
    }


    @Override
    public User findByIdd(Long id) {
        // TODO Auto-generated method stub

        return repo.findById(id).get();
    }


    @Override
    public String deleteUserDetails(Long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
        return "DetailsDelete";
    }

    @Override
    public User updateUserDetails(User user) {
        // TODO Auto-generated method stub
        return repo.save(user);
    }

}
