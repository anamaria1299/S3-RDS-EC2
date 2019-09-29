package co.edu.escuelaing.arem.aws.application.repository.impl;

import co.edu.escuelaing.arem.aws.application.model.User;
import co.edu.escuelaing.arem.aws.application.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository implements IUserRepository {


    @Autowired
    private DataSource database;

    @Override
    public List<User> findAll() {

        String query = "Select * from users";
        List<User> users = new ArrayList<>();
        Connection connection = null;
        try {
            connection = database.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setNickName(rs.getString("nickname"));
                user.setCareer(rs.getString("career"));
                user.setGender(rs.getString("gender"));
                users.add(user);
            }
            connection.close();
            return users;
        } catch (SQLException e) {
            System.err.println("Error occurred when try to get users, Exception: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Failed trying to close connection");
            }
        }

        return users;
    }

    @Override
    public User find(String nickname) {

        String query = "select * from users where nickname = '" + nickname + "'";
        User user = new User();
        Connection connection= null;
        try {
            connection= database.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                user.setName(rs.getString("name"));
                user.setNickName(rs.getString("nickname"));
                user.setCareer(rs.getString("career"));
                user.setGender(rs.getString("gender"));
                return user;
            }
            connection.close();
        } catch (Exception e) {
            System.err.println("Error occurred when try to get user ["+ nickname +"], Exception: " + e.getMessage());
        } finally {
            try {
                connection.close();

            } catch (SQLException e) {
                System.err.println("Failed trying to close connection");
            }
        }

        return user;
    }

    @Override
    public String save(User entity) {

        String query = "INSERT INTO \"users\" VALUES ((SELECT COUNT(*)+1 FROM \"users\"),'"+entity.getName()+
                "','"+entity.getNickName()+"','"+entity.getGender()+"','"+entity.getCareer()+"')";
        String query2 = "select * from users where nickname = '"+entity.getNickName()+"'";
        Connection connection = null;
        try {
            connection = database.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query2);
            if(rs.next()) {
                System.err.println("User with nickname that already exists [" + entity.getNickName() + "]");
                throw new SQLException("User can't be created, because the nickname already exists");
            }
            stmt.execute(query);
            connection.close();
            return entity.getNickName();
        } catch (SQLException e) {
            System.err.println("Error trying to create user ["+ entity.getNickName() +"], Exception: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Failed trying to close connection");
            }
        }

        return "User can not be created";
    }

    @Override
    public void upadate(User entity) {

    }

    @Override
    public void delete(User user) {

    }
}
