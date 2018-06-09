package com.francescociulla.springboot.daytrip;

import com.francescociulla.springboot.jwtuser.JwtUser;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
    Daytrip model
 */
@Entity
@Table(name = "daytrips")
public class Daytrip {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //primary key

    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    @ManyToOne
    private JwtUser jwtUser; //tied daytrip to a particolar Jwtuser

    public Daytrip() {
    }

    //To create a daytrip i need name, description, id of the jwtuser to create
    public Daytrip(String name, String description, int jwtUserId) {//SAME AS @PathVariable!!!
        this.name = name;
        this.description = description;
        this.jwtUser = new JwtUser(jwtUserId); //just for convenience
    }

    public Daytrip(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    JwtUser getJwtUser() {
        return jwtUser;
    }

    void setJwtUser(JwtUser jwtUser) {
        this.jwtUser = jwtUser;
    }

    @Override
    public String toString() {
        return "Daytrip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", jwtUser=" + jwtUser +
                '}';
    }
}

