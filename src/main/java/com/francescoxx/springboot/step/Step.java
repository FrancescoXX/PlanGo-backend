package com.francescoxx.springboot.step;

import com.francescoxx.springboot.daytrip.Daytrip;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "steps")
public class Step {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull private int id;

    //Fields to Create Object from Client
    @NotNull private String name;
    @NotNull private String description;
    @NotNull private double latitude;
    @NotNull private double longitude;
    @NotNull @ManyToOne private Daytrip daytrip; //tied course to a particolar Topic

    public Step() {
    }

    public Step(String name, String description, double latitude, double longitude, int daytripId) {
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.daytrip = new Daytrip(daytripId); //just for covnenience
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

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

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Daytrip getDaytrip() { return daytrip; }

    void setDaytrip(Daytrip daytrip) {this.daytrip = daytrip; }

    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", daytrip=" + daytrip +
                '}';
    }
}
