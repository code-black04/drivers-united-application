package com.assignment.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class TravelTimeDetailsDto {

    @JsonProperty(value = "date")
    private LocalDateTime date;

    @JsonProperty(value = "time")
    private LocalDateTime time;


    public TravelTimeDetailsDto() {
    }

    public TravelTimeDetailsDto(LocalDateTime date, LocalDateTime time) {
        this.date = date;
        this.time = time;
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

    @Override
    public String toString() {
        return "TravelTimeDetailsDto{" +
                "date=" + date +
                ", time=" + time +
                '}';
    }
}
