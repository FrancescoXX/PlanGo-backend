package com.francescociulla.springboot.jwtuser;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
    JwtUser Model
 */
@Entity
@Table //jwtuser table
public class JwtUser {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //Primary Key

    @NotNull private String userName;
    @NotNull private String password;
    @NotNull private String role;
    @NotNull private String dailyTours;

    public JwtUser() {}

    public JwtUser(int id) {
        this.id= id;
    }

    public JwtUser(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.dailyTours = "vuoto"; //find a use or remove
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDailyTours() {
        return dailyTours;
    }

    public void setDailyTours(String dailyTours) {
        this.dailyTours = dailyTours;
    }

    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", dailyTours='" + dailyTours + '\'' +
                '}';
    }
}
