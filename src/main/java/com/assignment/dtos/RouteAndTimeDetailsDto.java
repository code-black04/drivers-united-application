package com.assignment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"routeAndTimeDetailsId", "location"})
public class RouteAndTimeDetailsDto {

    @JsonProperty(value = "routeAndTimeDetailsId")
    private String routeAndTimeDetailsId;

    @JsonProperty(value = "travelTimeDetails")
    private TravelTimeDetailsDto travelTimeDetails;

    @JsonProperty(value = "location")
    private LocationDetailsDto location;

    public RouteAndTimeDetailsDto() {
    }

    public RouteAndTimeDetailsDto(String routeAndTimeDetailsId, TravelTimeDetailsDto travelTimeDetails, LocationDetailsDto location) {
        this.routeAndTimeDetailsId = routeAndTimeDetailsId;
        this.travelTimeDetails = travelTimeDetails;
        this.location = location;
    }

    public TravelTimeDetailsDto getTravelTimeDetails() {
        return travelTimeDetails;
    }

    public void setTravelTimeDetails(TravelTimeDetailsDto travelTimeDetails) {
        this.travelTimeDetails = travelTimeDetails;
    }

    public String getRouteAndTimeDetailsId() {
        return routeAndTimeDetailsId;
    }

    public void setRouteAndTimeDetailsId(String routeAndTimeDetailsId) {
        this.routeAndTimeDetailsId = routeAndTimeDetailsId;
    }

    @Override
    public String toString() {
        return "RouteAndTimeDetailsDto{" +
                "routeAndTimeDetailsId='" + routeAndTimeDetailsId + '\'' +
                ", travelTimeDetails=" + travelTimeDetails +
                ", location=" + location +
                '}';
    }
}