package co.edu.escuelaing.arem.aws.application.service;

import co.edu.escuelaing.arem.aws.application.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getUsers();

    String addUser(User user);
}
