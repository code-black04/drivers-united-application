package com.assignment.entity;

import javax.persistence.Embeddable;

@Embeddable
public class LocationDetails {


    private String pickUpLocationCoordinates;

    private String dropOffLocationCoordinates;

    public LocationDetails() {
    }

    public LocationDetails(String pickUpLocationCoordinates, String dropOffLocationCoordinates) {
        this.pickUpLocationCoordinates = pickUpLocationCoordinates;
        this.dropOffLocationCoordinates = dropOffLocationCoordinates;
    }

    public String getPickUpLocationCoordinates() {
        return pickUpLocationCoordinates;
    }

    public void setPickUpLocationCoordinates(String pickUpLocationCoordinates) {
        this.pickUpLocationCoordinates = pickUpLocationCoordinates;
    }

    public String getDropOffLocationCoordinates() {
        return dropOffLocationCoordinates;
    }

    public void setDropOffLocationCoordinates(String dropOffLocationCoordinates) {
        this.dropOffLocationCoordinates = dropOffLocationCoordinates;
    }

    @Override
    public String toString() {
        return "LocationDetails{" +
                "pickUpLocationCoordinates='" + pickUpLocationCoordinates + '\'' +
                ", dropOffLocationCoordinates='" + dropOffLocationCoordinates + '\'' +
                '}';
    }
}
