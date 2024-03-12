package com.assignment.entity;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class TravelTimeDetailsEntity {

    private LocalDateTime date;

    private LocalDateTime time;

    public TravelTimeDetailsEntity() {
    }

    public TravelTimeDetailsEntity(LocalDateTime date, LocalDateTime time) {
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
        return "TravelTimeDetails{" +
                "date=" + date +
                ", time=" + time +
                '}';
    }
}
