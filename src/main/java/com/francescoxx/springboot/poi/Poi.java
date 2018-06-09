package com.francescoxx.springboot.poi;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
    Model template
 */

@Entity
@Table(name = "pois") //corresponding table name in db
public class Poi {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //Primary Key

    @NotNull private String name;
    @NotNull private String description;
    @NotNull private double latitude;
    @NotNull private double longitude;

    public Poi() {}

    public Poi(String name, String description, double latitude, double longitude) {
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Poi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
