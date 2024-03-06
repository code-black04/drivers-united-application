package com.assignment.entity;

import javax.persistence.*;

@Entity
@Table(name = "route_time_details")
public class RouteAndTimeDetailsEntity {

    @Id
    @Column(name = "route_and_time_details_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String routeAndTimeDetailsId;

    public String getRouteAndTimeDetailsId() {
        return routeAndTimeDetailsId;
    }

    public void setRouteAndTimeDetailsId(String routeAndTimeDetailsId) {
        this.routeAndTimeDetailsId = routeAndTimeDetailsId;
    }
}
