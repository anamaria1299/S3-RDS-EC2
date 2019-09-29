package co.edu.escuelaing.arem.aws.application.service.impl;

import co.edu.escuelaing.arem.aws.application.model.User;
import co.edu.escuelaing.arem.aws.application.repository.IUserRepository;
import co.edu.escuelaing.arem.aws.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    User user;

    HashMap<String, User> users = new HashMap<>();

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> getUsers() {

        return userRepository.findAll();
    }

    @Override
    public String addUser(User user) {

        return userRepository.save(user);
    }
}
