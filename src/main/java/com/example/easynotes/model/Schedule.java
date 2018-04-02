package com.example.easynotes.model;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id")
    private Long id;

    @Column(name = "time")
    private double time;

    @Column(name = "sports")
    private String sports;

    @Column(name = "description")
    private String description;

    public Schedule() {
    }

    public Schedule(double time, String sports, String description) {
        this.time = time;
        this.sports = sports;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        return id != null ? id.equals(schedule.id) : schedule.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", time=" + time +
                ", sports='" + sports + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
