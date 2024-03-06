package com.assignment.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "driver_details")
public class DriverEntity {

    @Column(name = "driver_Id", unique = true, insertable = false)
    @Id
    private String driverId;

    @Column(name = "password")
    private String password;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
