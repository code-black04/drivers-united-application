package com.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "location_details")
public class LocationDetailsEntity {

    @Id
    @Column(name = "location_details_id")
    private Long locationDetailsId;

    @Column(name = "pick_up_location_coordinates")
    private String pickUpLocationCoordinates;

    @Column(name = "drop_off_location_coordinates")
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
