package com.assignment.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "travel_time_details")
public class TravelTimeDetailsEntity {

    @Id
    @Column(name = "travel_time_details")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String travelTimeDetailsId;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "time")
    private LocalDateTime time;

    public String getTravelTimeDetailsId() {
        return travelTimeDetailsId;
    }

    public void setTravelTimeDetailsId(String travelTimeDetailsId) {
        this.travelTimeDetailsId = travelTimeDetailsId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
