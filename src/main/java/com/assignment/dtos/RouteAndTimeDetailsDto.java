package com.assignment.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RouteAndTimeDetailsDto {

    @JsonProperty(value = "routeAndTimeDetailsId")
    private String routeAndTimeDetailsId;

    public String getRouteAndTimeDetailsId() {
        return routeAndTimeDetailsId;
    }

    public void setRouteAndTimeDetailsId(String routeAndTimeDetailsId) {
        this.routeAndTimeDetailsId = routeAndTimeDetailsId;
    }
}
