package com.app.controller;

import com.app.pojos.User;
import com.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class UserController {

    private UserService userser;

    @PostMapping("/add")
    public User addUserDetails(@RequestBody User user) {
        return userser.addUserDetails(user);
    }

    @GetMapping("/getbyid/{id}")
    public User findBYId(@PathVariable Long id) {
        return userser.findByIdd(id);
    }

    @DeleteMapping("/deletebyId/{id}")
    public String deleteUserDetails(@PathVariable Long id) {
        return userser.deleteUserDetails(id);
    }

    @PutMapping("/update")
    public User updateUserDetails(@RequestBody User user) {
        return userser.updateUserDetails(user);
    }
}
