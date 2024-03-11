package com.assignment.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationDetailsDto {


    @JsonProperty(value = "pickUpLocationCoordinates")
    private String pickUpLocationCoordinates;

    @JsonProperty(value = "dropOffLocationCoordinates")
    private String dropOffLocationCoordinates;

    public LocationDetailsDto() {
    }

    public LocationDetailsDto(String pickUpLocationCoordinates, String dropOffLocationCoordinates) {
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
        return "LocationDetailsDto{" +
                "pickUpLocationCoordinates='" + pickUpLocationCoordinates + '\'' +
                ", dropOffLocationCoordinates='" + dropOffLocationCoordinates + '\'' +
                '}';
    }
}
