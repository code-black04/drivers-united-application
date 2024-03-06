package com.assignment.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class TravelTimeDetailsDto {

    @JsonProperty(value = "currentDate")
    private LocalDateTime date;

    @JsonProperty(value = "currentTime")
    private LocalDateTime time;

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
