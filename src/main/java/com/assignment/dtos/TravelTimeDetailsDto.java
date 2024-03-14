package com.assignment.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class TravelTimeDetailsDto {

    @JsonProperty(value = "date")
    private LocalDateTime date;

    @JsonProperty(value = "time")
    private LocalDateTime time;

    @JsonProperty(value = "durationInSeconds")
    private long durationInSeconds;

    public TravelTimeDetailsDto(LocalDateTime date, LocalDateTime time, long durationInSeconds) {
        this.date = date;
        this.time = time;
        this.durationInSeconds = durationInSeconds;
    }

    // Getter and setter for the new field
    public long getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(long durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

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
                ", durationInSeconds=" + durationInSeconds +
                '}';
    }
}
