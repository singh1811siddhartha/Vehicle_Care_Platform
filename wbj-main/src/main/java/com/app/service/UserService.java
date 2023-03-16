package com.app.service;

import com.app.pojos.User;

public interface UserService {
    User addUserDetails(User user);

    User findByIdd(Long id);

    String deleteUserDetails(Long id);

    User updateUserDetails(User user);
}
