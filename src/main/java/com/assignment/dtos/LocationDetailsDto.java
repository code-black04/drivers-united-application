package com.assignment.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.parsing.Location;

import javax.tools.DocumentationTool;

public class LocationDetailsDto {

    @JsonProperty(value = "locationDetailsId")
    private Long locationDetailsId;

    @JsonProperty(value = "pickUpLocationCoordinates")
    private String pickUpLocationCoordinates;

    @JsonProperty(value = "dropOffLocationCoordinates")
    private String dropOffLocationCoordinates;

    public Long getLocationDetailsId() {
        return locationDetailsId;
    }

    public void setLocationDetailsId(Long locationDetailsId) {
        this.locationDetailsId = locationDetailsId;
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
}
