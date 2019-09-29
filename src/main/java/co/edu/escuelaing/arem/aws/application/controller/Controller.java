package co.edu.escuelaing.arem.aws.application.controller;

import co.edu.escuelaing.arem.aws.application.model.User;
import co.edu.escuelaing.arem.aws.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/app")
public class Controller {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {

        try {
            return new ResponseEntity<>(userService.getUsers(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<?> createBoard(@RequestBody User user) {

        try {

            return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}
