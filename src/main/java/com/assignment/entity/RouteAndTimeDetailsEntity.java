package com.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "route_time_details")
public class RouteAndTimeDetailsEntity {

    @Id
    @Column(name = "route_and_time_details_id")
    private String routeAndTimeDetailsId;

    public String getRouteAndTimeDetailsId() {
        return routeAndTimeDetailsId;
    }

    public void setRouteAndTimeDetailsId(String routeAndTimeDetailsId) {
        this.routeAndTimeDetailsId = routeAndTimeDetailsId;
    }
}
