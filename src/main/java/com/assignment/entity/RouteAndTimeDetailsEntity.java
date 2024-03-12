package com.assignment.entity;

import javax.persistence.*;

@Entity
@Table(name = "route_time_details")
public class RouteAndTimeDetailsEntity {

    @Id
    @Column(name = "route_and_time_details_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String routeAndTimeDetailsId;

    @Embedded
    private TravelTimeDetailsEntity travelTimeDetails;

    @Embedded
    private LocationDetailsEntity location;


    public RouteAndTimeDetailsEntity() {
    }

    public RouteAndTimeDetailsEntity(String routeAndTimeDetailsId, TravelTimeDetailsEntity travelTimeDetails, LocationDetailsEntity location) {
        this.routeAndTimeDetailsId = routeAndTimeDetailsId;
        this.travelTimeDetails = travelTimeDetails;
        this.location = location;
    }

    public String getRouteAndTimeDetailsId() {
        return routeAndTimeDetailsId;
    }

    public void setRouteAndTimeDetailsId(String routeAndTimeDetailsId) {
        this.routeAndTimeDetailsId = routeAndTimeDetailsId;
    }

    public TravelTimeDetailsEntity getTravelTimeDetails() {
        return travelTimeDetails;
    }

    public void setTravelTimeDetails(TravelTimeDetailsEntity travelTimeDetails) {
        this.travelTimeDetails = travelTimeDetails;
    }

    public LocationDetailsEntity getLocation() {
        return location;
    }

    public void setLocation(LocationDetailsEntity location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "RouteAndTimeDetailsEntity{" +
                "routeAndTimeDetailsId='" + routeAndTimeDetailsId + '\'' +
                ", travelTimeDetails=" + travelTimeDetails +
                ", location=" + location +
                '}';
    }
}
