package com.firstcourse.FirstCourse;

import com.firstcourse.FirstCourse.models.Role;
import com.firstcourse.FirstCourse.models.User;
import com.firstcourse.FirstCourse.models.data.RoleDao;
import com.firstcourse.FirstCourse.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service("userService")
public class UserService {

    private UserDao userRepository;
    private RoleDao roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserDao userRepository,
                       RoleDao roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
//        user.setRoles((List<Role>) new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

}