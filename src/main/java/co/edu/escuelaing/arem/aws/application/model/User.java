package co.edu.escuelaing.arem.aws.application.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class User implements Serializable {

    private String name;
    private String nickName;
    private String gender;
    private String career;

    public User(){}

    public User(String name, String nickName, String gender, String career) {

        this.name = name;
        this.nickName = nickName;
        this.gender = gender;
        this.career = career;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public String getGender() {
        return gender;
    }

    public String getCareer() {
        return career;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
