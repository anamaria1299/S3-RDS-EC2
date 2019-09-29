package co.edu.escuelaing.arem.aws.application.repository;

import co.edu.escuelaing.arem.aws.application.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends DAO<User, String>{

}

